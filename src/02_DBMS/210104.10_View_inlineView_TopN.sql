-- [X] VIEW, INLINE VIEW, TOP-N구문
-- 1. VIEW : 가상의 테이블 
-- (1)단순뷰
-- EX. EMPv0이란 VIEW 생성 또는 수정 = EMP TABLE의 일부 필드를 갖는 가상의 테이블
--      생성
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP;
SELECT * FROM EMPv0;

--      데이터 추가
INSERT INTO EMPv0 
    VALUES (1111, 'PARK', 'IT', 40); -- VIEW에 INSERT
SELECT * FROM EMP WHERE EMPNO = 1111; -- 실제 EMP TABLE에도 추가된다.

-- EX. EMPv0 VIEW에서 EMP TABLE의 30번 부서행만 가져오기
CREATE OR REPLACE VIEW EMPv0 
    AS SELECT * FROM EMP WHERE DEPTNO = 30; 
SELECT * FROM USER_VIEWS; -- 데이터 딕셔너리 뷰 확인
SELECT * FROM EMPv0;  

INSERT INTO EMPv0
    VALUES (1111, 'JOE', NULL, NULL, NULL, NULL, NULL, 30); 
                        -- EMP TABLE처럼 EMPN0의 UNIQUE 제약 조건으로 인해 추가 불가능

--       30번이 아닌 부서엔 데이터 추가는 가능하지만, 보이지는 않는다.
INSERT INTO EMPv0
    VALUES (1112, 'JOE', NULL, NULL, NULL, NULL, NULL, 40);
SELECT * FROM EMPv0; -- 위에서 추가한 1112번 사원은 볼 수 없다.
SELECT * FROM EMP; -- 여기서 볼 수 있다.

DELETE FROM EMPv0 WHERE EMPNO < 1113; -- 아까 30번 부서만 가져왔으므로, 30번부서 사원인 1111만 삭제됨
DELETE FROM EMP WHERE EMPNO < 1113; -- 1111, 1112 모두 삭제

COMMIT; 

-- EX. EMP TABLE 30번 부서의 가상 테이블을 불러와서 30번 부서만 추가 가능하도록 설정하기
CREATE OR REPLACE VIEW EMPv0
    AS SELECT * FROM EMP WHERE DEPTNO = 30
    WITH CHECK OPTION; -- VIEW의 제한 조건
SELECT * FROM EMPv0;
--      30번 부서엔 데이터 추가 가능
INSERT INTO EMPv0
    VALUES (1111, 'PARK', 'ANALYST', NULL, SYSDATE, 1250, NULL, 30); 
SELECT * FROM EMPv0;
--      30번 부서에는 데이터 추가 불가능 
INSERT INTO EMPv0
    VALUES (1112, 'JOE', 'VICE PRESIDENT', NULL, SYSDATE, 1250, NULL, 40); -- 실행 불가 
--      뷰 데이터 삭제
DELETE FROM EMPv0 WHERE EMPNO = 1111;
    
-- (2) 복합뷰 
-- EX. EMP TABLE과 DEPT TABLE에서 데이터를 불러와 EMPv1 VIEW만들기
CREATE OR REPLACE VIEW EMPv1
    AS SELECT EMPNO, ENAME, JOB, DNAME 
            FROM DEPT D, EMP E
            WHERE D.DEPTNO = E.DEPTNO;
SELECT * FROM EMPv1;      
--      복합뷰에서는 DML사용이 제한적이다.
INSERT INTO EMPv1
    VALUES (1111, 'PARK', 'ANALYST', 'RESEARCH'); -- 실행 불가

-- **** 복합뷰 포함 DML 명령어(INSERT, UPDATE, DELETE)를 모두 사용할 수 없는 경우
-- 1) VIEW가 읽기 전용일 때 
CREATE OR REPLACE VIEW  EMPv2
    AS SELECT EMPNO, ENAME, DEPTNO FROM EMP
    WITH READ ONLY; 
SELECT * FROM EMPv2;
SELECT EMPNO, ENAME, DNAME FROM EMPv2 E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
INSERT INTO EMPv2 VALUES (1111, '홍', 40);    

-- 2) 가져오는 테이블에서 NOT NULL인 필드를 가져오지 않았을 때 
CREATE OR REPLACE VIEW EMPv3
    AS SELECT ENAME, SAL FROM EMP;
SELECT * FROM EMPv3;
INSERT INTO EMPv3 
    VALUES ('홍', 9000); -- EMP TABLE의 EMPNO 필드가 NOT NULL인데 현재 EMPv3엔 없다.
DESC EMPv3;    
     
-- 3) VIEW 생성 시 필드에 연산이 있을 경우 
CREATE OR REPLACE VIEW EMPv3
    AS SELECT EMPNO, ENAME, SAL*12 YEARSAL FROM EMP; -- VIEW의 별칭은 필드 바로 옆에,
CREATE OR REPLACE VIEW EMPv3 (EMPNO, ENAME, YEARSAL) -- 혹은 ()안에 따로 - 단, 이 경우엔 모든 필드에 별칭을 주어야 한다.
    AS SELECT EMPNO, ENAME, SAL*12 FROM EMP;
SELECT * FROM EMPv3;

INSERT INTO EMPv3 
    VALUES (1115, 'LEE', 12000); -- 필드에 연산(SAL*12)이 있어서 실행 불가
    
-- 4) VIEW 생성시 필드에 함수를 사용한 경우 
CREATE OR REPLACE VIEW EMPv3
    AS SELECT EMPNO, ENAME, ROUND(SAL, -3) SAL FROM EMP;

INSERT INTO EMPv3
    VALUES (1115, 'SHIN', 1000); -- 함수(ROUND)가 포함된 필드로 인해 실행 불가


CREATE OR REPLACE VIEW DEPTv1 (DEPTNO, MINSAL, MAXSAL, AVGSAL)
    AS SELECT DEPTNO, MIN(SAL), MAX(SAL), ROUND(AVG(SAL),1)
            FROM EMP GROUP BY DEPTNO;
SELECT * FROM DEPTv1;

INSERT INTO DEPTv1
    VALUES (40, 800, 9000, 4000); -- 함수 필드들로 인해 사용 불가

-- 5) DISTINCT를 포함한 VIEW 
CREATE OR REPLACE VIEW EMPv3
    AS SELECT DISTINCT JOB, DEPTNO 
            FROM EMP ORDER BY JOB;
SELECT * FROM EMPv3;

INSERT INTO EMPv3
    VALUES ('CLEAR', 10); -- JOB필드가 DISTINCT이므로 실행 불가

-- 2. INLINE VIEW: SQL문을 수행하는 한 줄의 명령어에서만 유용한 VIEW / FROM절의 서브쿼리 
--      SELECT 필드1, 필드2.... 
--          FROM EMP E, (서브쿼리) S
--          WHERE 조건

-- EX. 급여가 2000을 초과하는 사원의 평균 급여 
SELECT AVG(SAL) 
    FROM EMP
    WHERE SAL > 2000; 
SELECT AVG(SAL)
    FROM (SELECT SAL FROM EMP WHERE SAL > 2000); -- INLINE VIEW

--EX. 이름, 급여, 부서번호, 해당 사원의 부서 평균 급여 (SELECT절 서브쿼리 이용)
SELECT ENAME, SAL, DEPTNO 
    FROM EMP; -- (1) 이름, 급여 부서번호 출력
SELECT DEPTNO, ROUND(AVG(SAL)) 
    FROM EMP GROUP BY DEPTNO; -- (2) 부서별 평균 급여 

SELECT ENAME, SAL, E.DEPTNO, S.AVGSAL -- (1) + (2) 
    FROM EMP E, (SELECT DEPTNO, ROUND(AVG(SAL)) AVGSAL  -- INLINE VIEW (2) 
                    FROM EMP GROUP BY DEPTNO) S
    WHERE E.DEPTNO = S.DEPTNO 
      AND SAL > AVGSAL;

-- EX. 이름, 급여, 부서번호, 해당 사원의 부서 평균(부서 평균보다 많이 받는 직원만)
SELECT ENAME, SAL, E.DEPTNO, ROUND(AVGSAL)
    FROM EMP E, (SELECT DEPTNO, AVG(SAL) AVGSAL 
                    FROM EMP GROUP BY DEPTNO) S
    WHERE E.DEPTNO = S.DEPTNO 
      AND SAL > AVGSAL;

-- 3. TOP-N 구문 (TOP 1~10등, TOP 11~20등, TOP 6~10등...)
-- ROUNUM: 테이블에서 가져온 순서. 테이블 행의 논리적인 순서
--    EX. 
SELECT ROWNUM, ENAME, SAL 
    FROM EMP;
SELECT ROWNUM, ENAME, SAL 
    FROM EMP 
    ORDER BY SAL;
SELECT ROWNUM, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL);
SELECT ROWNUM, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL)
    WHERE ROWNUM < 6;
SELECT ROWNUM, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL)
    WHERE ROWNUM BETWEEN 6 AND 10; -- 1등이 아닌 수부터 출력할 경우 출력되지 않는다.
    
-- 함수를 이용한 RANK 출력 
SELECT RANK() OVER(ORDER BY SAL) RANK,
       DENSE_RANK() OVER (ORDER BY SAL) D_RANK,
       ROW_NUMBER() OVER (ORDER BY SAL) N_RANK,
       ENAME, SAL
    FROM EMP;

-- TOP-N 구문 
SELECT ROWNUM, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL)
    WHERE ROWNUM BETWEEN 1 AND 5; -- 6~10등은 출력되지 않는다.
    
SELECT ROWNUM, RN, ENAME, SAL 
    FROM (SELECT ROWNUM RN, ENAME, SAL 
                FROM (SELECT * FROM EMP ORDER BY SAL))
    WHERE RN BETWEEN 6 AND 10;

SELECT ENAME, EMPNO, JOB, MGR, HIREDATE
    FROM (SELECT ROWNUM RN, ENAME, EMPNO, JOB, MGR, HIREDATE
            FROM (SELECT * FROM EMP ORDER BY ENAME))
    WHERE RN BETWEEN 6 AND 10;

-- <총 연습문제>

-- 1. 부서명과 사원명을 출력하는 용도의 뷰, DNAME_ENAME_VU 를 작성하시오
CREATE OR REPLACE VIEW DNAME_ENAME_VU 
    AS SELECT DNAME, ENAME 
        FROM EMP E, DEPT D
        WHERE E.DEPTNO = D.DEPTNO;

SELECT * FROM DNAME_ENAME_VU;

-- 2. 사원명과 직속상관명을 출력하는 용도의 뷰,  WORKER_MANAGER_VU를 작성하시오
CREATE OR REPLACE VIEW WORKER_MANAGER_VU (WORKER, MANAGER)
    AS SELECT W.ENAME, M.ENAME 
        FROM EMP W, EMP M
        WHERE W.MGR = M.EMPNO;

SELECT * FROM WORKER_MANAGER_VU;

-- 3. 부서별 급여합계 등수를 출력하시오(부서번호, 급여합계, 등수) ? 친구출제
SELECT ROWNUM "RANK", DEPTNO, SUMSAL
    FROM (SELECT DEPTNO, SUM(SAL) SUMSAL FROM EMP 
            GROUP BY DEPTNO ORDER BY SUM(SAL) DESC);
 
-- 3-1. 부서별 급여합계 등수가 2~3등인 부서번호, 급여합계, 등수를 출력하시오.
SELECT RN, DEPTNO, SUMSAL
    FROM (SELECT ROWNUM RN, DEPTNO, SUMSAL 
            FROM(SELECT DEPTNO, SUM(SAL) SUMSAL FROM EMP
                    GROUP BY DEPTNO ORDER BY SUM(SAL) DESC))
    WHERE RN BETWEEN 2 AND 3;

-- 4. 사원테이블에서 사번, 사원명, 입사일을 입사일이 최신에서 오래된 사원 순으로 정렬하시오

SELECT EMPNO, ENAME, HIREDATE 
    FROM EMP
    ORDER BY HIREDATE DESC;
    
-- 5. 사원테이블에서 사번, 사원명, 입사일을 입사일이 최신에서 오래된 사원 5명을 출력하시오
SELECT EMPNO, ENAME, HIREDATE 
    FROM (SELECT EMPNO, ENAME, HIREDATE 
            FROM EMP
            ORDER BY HIREDATE DESC)
    WHERE ROWNUM <=5; 

-- 6. 사원 테이블에서 사번, 사원명, 입사일을 최신부터 오래된 순으로 6번째로 늦은 사원부터 10번째 사원까지 출력
SELECT RN, EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM RN, EMPNO, ENAME, HIREDATE 
            FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC))
    WHERE RN BETWEEN 6 AND 10;

