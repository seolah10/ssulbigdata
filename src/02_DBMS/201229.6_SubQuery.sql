-- [VI] SUB QUERY : QUERY안에 QUERY가 내포

-- ★ 1. 서브쿼리 개념
--서브쿼리 (1) 단일행서브쿼리(서브쿼리결과가 단일행) = > >= < <= != <>
    --    (2) 다중행서브쿼리(서브쿼리결과가 2행이상)IN ANY SOME ALL EXISTS
--EX. SCOTT이 근무하는 부서이름 출력
SELECT DNAME 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO 
        AND ENAME = 'SCOTT'; -- JOIN 방법
SELECT DEPTNO FROM EMP
    WHERE ENAME = 'SCOTT'; -- 단일행 서브쿼리
SELECT DNAME FROM DEPT
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP
                        WHERE ENAME = 'SCOTT'); -- 메인쿼리

-- EX. JOB이 'MANAGER'인 사람의 부서이름
SELECT DEPTNO FROM EMP
    WHERE JOB = 'MANAGER'; -- 다중행 서브쿼리
SELECT DNAME FROM DEPT
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP
                        WHERE JOB = 'MANAGER'); -- 메인쿼리
                        
-- ★ 2. 단일행 서브쿼리
--EX. 회사에서 급여를 제일 많이 받는 사람의 이름과 급여
SELECT MAX(SAL) FROM EMP; -- 서브쿼리 (단일행, 단일열)
SELECT ENAME, SAL 
    FROM EMP
    WHERE SAL = (SELECT MAX(SAL) FROM EMP);
    
-- EX. SCOTT와 같은 부서번호인 사람이름
SELECT ENAME FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP
                        WHERE ENAME = 'SCOTT')
            AND ENAME != 'SCOTT';

-- EX. SCOTT과 같은 근무지인 사람이름 (50번부서 DALLAS  홍길동 입력 후)
INSERT INTO DEPT 
    VALUES (50, 'IT', 'DALLAS');
INSERT INTO EMP (EMPNO, ENAME, DEPTNO) 
    VALUES (9999, '홍', 50); -- 50번부서 DALLAS에서 근무하는 홍길동 추가

SELECT LOC 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
        AND ENAME = 'SCOTT'; -- 서브쿼리

SELECT ENAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
        AND LOC = (SELECT LOC FROM EMP E, DEPT D
                        WHERE E.DEPTNO = D.DEPTNO
                            AND ENAME = 'SCOTT')
        AND ENAME != 'SCOTT'; -- 메인쿼리
        
-- EX. SCOTT과 같은 부서에 근무하는 사람들의 급여합을 출력
SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'; --서브쿼리
SELECT SUM(SAL) FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP 
                        WHERE ENAME = 'SCOTT'); -- 메인쿼리
                        
-- EX. SCOTT과 동일한 JOB을 가진 사원의 모든 정보를 출력
SELECT * FROM EMP
    WHERE JOB = (SELECT JOB FROM EMP
                    WHERE ENAME = 'SCOTT');

-- EX. DALLAS에서 근무하는 사원의 이름, 부서번호 출력 
ROLLBACK;
SELECT ENAME, DEPTNO
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT
                        WHERE LOC = 'DALLAS');
                    
-- EX. SALES(DNAME) 부서에서 근무하는 직원의 이름, 급여 출력
SELECT ENAME, SAL 
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT
                        WHERE DNAME = 'SALES');

-- EX. 'KING'이 직속상사인 사원의 이름과 급여
SELECT ENAME, SAL
    FROM EMP
    WHERE MGR = (SELECT EMPNO FROM EMP
                    WHERE ENAME = 'KING');
                    
-- EX. 평균급여 이하로 받는 사원의 이름, 급여 
SELECT ENAME,SAL
    FROM EMP
    WHERE SAL <= (SELECT AVG(SAL) FROM EMP);

-- EX. SCOTT이랑 JOB과 부서번호가 같은 직원의 모든 필드 출력 (다중열 서브쿼리)
SELECT * FROM EMP
    WHERE (JOB, DEPTNO) = (SELECT JOB, DEPTNO 
                             FROM EMP
                             WHERE ENAME = 'SCOTT');

-- <연습문제 - 단일행 서브쿼리> 
-- 1. 사원테이블에서 가장 먼저 입사한 사람의 이름, 급여, 입사일
SELECT ENAME, SAL, HIREDATE 
    FROM EMP
    WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);

-- 2. 회사에서 가장 급여가 적은 사람의 이름, 급여
SELECT ENAME, SAL 
    FROM EMP
    WHERE SAL = (SELECT MIN(SAL) FROM EMP);

-- 3. 회사 평균보다 급여를 많이 받는 사람의 이름, 급여, 부서코드
SELECT ENAME, SAL, DEPTNO
    FROM EMP
    WHERE SAL > (SELECT AVG(SAL) FROM EMP);
    
-- 4. 회사 평균 이하의 급여를 받는 사람의 이름, 급여, 부서명
SELECT ENAME, SAL, DNAME 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = E.DEPTNO
        AND SAL <= (SELECT AVG(SAL) FROM EMP);

-- 5. SCOTT보다 먼저 입사한 사람의 이름, 급여, 입사일, 급여 등급
SELECT ENAME, SAL, HIREDATE, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
        AND HIREDATE < (SELECT HIREDATE FROM EMP
                            WHERE ENAME = 'SCOTT');

-- 6. 5번(SCOTT보다 먼저 입사한 사람의 이름, 급여, 입사일, 급여 등급)에 부서명 추가하고 
    --급여가 큰 순 정렬
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME
    FROM EMP E, SALGRADE, DEPT D
    WHERE SAL BETWEEN LOSAL AND HISAL
        AND E.DEPTNO = D.DEPTNO
        AND HIREDATE < (SELECT HIREDATE FROM EMP
                            WHERE ENAME = 'SCOTT')
    ORDER BY SAL DESC;
                            
-- 7. 사원테이블에서 BLAKE 보다 급여가 많은 사원들의 사번, 이름, 급여를 검색
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL > (SELECT SAL FROM EMP
                    WHERE ENAME = 'BLAKE');

-- 8. 사원테이블에서 MILLER보다 늦게 입사한 사원의 사번, 이름, 입사일을 검색하시오
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE HIREDATE > (SELECT HIREDATE FROM EMP
                        WHERE ENAME = 'MILLER');

-- 9. 사원테이블에서 사원전체 평균 급여보다 급여가 많은 사원들의 사번, 이름, 급여를 검색
SELECT EMPNO, ENAME, SAL 
    FROM EMP
    WHERE SAL > (SELECT AVG(SAL) FROM EMP);

-- 10. 사원테이블에서 CLARK와 같은 부서며, 사번이 7698인 직원의 급여보다 
        -- 많은 급여를 받는 사원들의 사번, 이름, 급여 검색
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'CLARK')
        AND SAL > (SELECT SAL FROM EMP WHERE EMPNO = 7698);

-- 11.  응용심화. 사원테이블에서 CLARK와 같은 부서명이며, 사번이 7698인 직원의 급여보다 
    --  많은 급여를 받는 사원들의 사번, 이름, 급여 검색
SELECT EMPNO, ENAME, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
        AND DNAME = (SELECT DNAME 
                        FROM EMP E, DEPT D 
                        WHERE E.DEPTNO = D.DEPTNO AND ENAME = 'CLARK')
        AND SAL > (SELECT SAL FROM EMP WHERE EMPNO = 7698);
        

-- 12.  사원 테이블에서 BLAKE와 같은 부서에 있는 모든 사원의 이름과 입사일자를 출력하는 SELECT문을 작성하시오.
SELECT ENAME, HIREDATE 
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP
                        WHERE ENAME = 'BLAKE');
                        
-- 13.  사원 테이블에서 평균 급여 이상을 받는 모든 종업원에 대해서 사원번호와 이름을 출력
        --(단 급여가 많은 순으로 출력하여라.)
SELECT EMPNO, ENAME 
    FROM EMP
    WHERE SAL >= (SELECT AVG(SAL) FROM EMP)
    ORDER BY SAL DESC;

---------------------------------------------------

-- ★ 3. 다중행 서브쿼리 ;  IN, ALL, ANY=SOME, EXISTS
-- (1) IN ; 서브쿼리 결과 중 하나라도 일치하면 참
--EX. 부서별로 입사일이 가장 늦은 사람의 부서번호, 이름, 입사일, 부서번호 출력
SELECT DEPTNO, ENAME, HIREDATE, DEPTNO
    FROM EMP
    WHERE (DEPTNO, HIREDATE) IN (SELECT DEPTNO, MAX(HIREDATE) 
                                    FROM EMP
                                    GROUP BY DEPTNO);

--EX. 급여 3000이상 받는 사원이 소속된 부서에서 근무하는 사원들의 모든 정보 
SELECT * FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP
                        WHERE SAL >= 3000);

-- (2) ALL
-- EX. 30번 부서 최대 급여보다 급여를 많이 받는 사람의 모든 정보
SELECT * FROM EMP
    WHERE SAL > (SELECT MAX(SAL) FROM EMP
                    WHERE DEPTNO = 30);
SELECT * FROM EMP
    WHERE SAL > ALL (SELECT SAL FROM EMP
                        WHERE DEPTNO = 30); 

-- (3) ANY/SOME
SELECT * FROM EMP
    WHERE SAL > ANY (SELECT SAL FROM EMP
                        WHERE DEPTNO = 30);  -- 위의 ALL함수식과 결과 비교해보기

SELECT * FROM EMP
    WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 30);

-- (4) EXISTS ; 서브쿼리 결과가 존재하면 참
-- EX. 직속부하가 있는 직원들의 사번, 이름, 급여
SELECT EMPNO, ENAME, SAL
    FROM EMP M 
    WHERE EXISTS (SELECT * FROM EMP W
                    WHERE M.EMPNO = W.MGR);
                    
-- EX. 말단사원의 모든 필드 정보 출력
SELECT * FROM EMP M
    WHERE NOT EXISTS (SELECT * FROM EMP
                        WHERE M.EMPNO = MGR);

-- <탄탄다지기>
-- 1) 부서별로 가장 급여를 많이 받는 사원의 사번, 이름, 급여, 부서번호
SELECT EMPNO, ENAME, SAL, DEPTNO
    FROM EMP
    WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL)
                                FROM EMP
                                GROUP BY DEPTNO);
    
-- 2) 직급(JOB)이 MANAGER인 사람이 속한 부서의 부서번호, 부서명, 지역
SELECT DEPTNO, DNAME, LOC
    FROM DEPT
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP
                        WHERE JOB = 'MANAGER');
                        
-- 3) 연봉이 3000 이상인 사람들 중 급여 등급을 나누어서
--    해당 등급별 최고 급여를 받는 사람들의 사번, 이름, 직업, 입사일, 급여등급 출력
SELECT EMPNO, ENAME, JOB, HIREDATE, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
      AND (GRADE, SAL) IN (SELECT GRADE, MAX(SAL) 
                            FROM EMP, SALGRADE
                            WHERE SAL BETWEEN LOSAL AND HISAL
                              AND SAL >= 3000
                            GROUP BY GRADE);
                            
-- 4) (응용심화) 입사일 분기별로 가장 높은 연봉을 받는 사람들의 \
--              분기, 사번, 이름, JOB, 상사사번, 입사일, 급여, 상여 출력 
SELECT HIREDATE, CEIL(TO_CHAR(HIREDATE, 'MM')/3) QUARTER FROM EMP; -- 분기 

SELECT CEIL(TO_CHAR(HIREDATE, 'MM')/3) QUARTER, EMPNO, ENAME, 
       JOB, MGR, HIREDATE, SAL, COMM
    FROM EMP
    WHERE (CEIL(TO_CHAR(HIREDATE, 'MM')/3), SAL) IN
           (SELECT CEIL(TO_CHAR(HIREDATE, 'MM')/3), MAX(SAL) 
                FROM EMP
                GROUP BY CEIL(TO_CHAR(HIREDATE, 'MM')/3))
    ORDER BY QUARTER;

-- 5) SALESMAN 모든 사원들보다 급여를 많이 받는 사원들의 이름, 급여, 직급 출력 
--    (단, 영업사원은 출력하지 않는다.)
SELECT ENAME, SAL, JOB 
    FROM EMP
    WHERE SAL > ALL (SELECT SAL FROM EMP
                        WHERE JOB = 'SALESMAN')
      AND JOB != 'SALESMAN';

-- 6) SALESMAN 사원들 중 어떤 한 사람보다 급여를 많이 받는 사원들의 이름, 급여, 직급
--    (영업사원도 포함하여 출력한다.)
SELECT ENAME, SAL, JOB
    FROM EMP
    WHERE SAL > ANY (SELECT SAL FROM EMP
                        WHERE JOB = 'SALESMAN');
                        
-- 7) 급여가 3000 미만인 사람 중 가장 최근에 입사한 사람의 사원번호, 이름, 급여, 입사일 
SELECT EMPNO, ENAME, SAL, HIREDATE
    FROM EMP
    WHERE HIREDATE IN (SELECT MAX(HIREDATE) FROM EMP
                        WHERE SAL < 3000);
                        
SELECT EMPNO, ENAME, SAL, HIREDATE FROM EMP 
    WHERE HIREDATE >= ALL (SELECT HIREDATE FROM EMP 
                            WHERE SAL<3000);

-- 8) 직급이 'SALESMAN'인 사원이 받는 급여의 최소급여보다 많이 받는 사원들의
--    이름, 급여, 직급, 부서번호 (단, 부서번호가 20번인 사원은 제외한다.)
SELECT ENAME, SAL, JOB, DEPTNO
    FROM EMP
    WHERE SAL > ANY (SELECT SAL FROM EMP
                        WHERE JOB = 'SALESMAN')
      AND DEPTNO != 20;

-- <연습문제 - 다중행 서브쿼리>
-- 14. 사원 테이블에서 이름에 “T”가 있는 사원이 근무하는 부서에서 근무하는 모든 종업원에 대해
    --사원 번호,이름,급여를 출력하는 SELECT문을 작성하시오. 단 사원번호 순으로 출력하여라.
SELECT EMPNO, ENAME, SAL 
    FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP
                        WHERE ENAME LIKE '%T%')
    ORDER BY EMPNO;

-- 15. 사원 테이블에서 부서 위치가 Dallas인 모든 종업원에 대해 이름,업무,급여를 출력
SELECT ENAME, JOB, SAL 
    FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO FROM DEPT
                        WHERE INITCAP(LOC) = 'Dallas');
SELECT ENAME, JOB, SAL 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
      AND INITCAP(LOC) = 'Dallas';
      
-- 16. EMP 테이블에서 King에게 보고하는 모든 사원의 이름과 급여를 출력하는 SELECT문
SELECT EMPNO FROM EMP WHERE INITCAP(ENAME)='KING'; -- 서브쿼리
SELECT ENAME, SAL 
    FROM EMP
    WHERE MGR = (SELECT EMPNO FROM EMP WHERE INITCAP(ENAME)='King');
SELECT ENAME, SAL
 FROM EMP W 
    WHERE EXISTS (SELECT * FROM EMP
                    WHERE EMPNO = W.MGR AND INITCAP(ENAME) = 'King');

-- 17. 사원 테이블에서 SALES부서 사원의 이름,업무를 출력하는 SELECT문을 작성하시오.
SELECT ENAME, JOB
    FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO FROM DEPT 
                       WHERE DNAME = 'SALES');  
    
-- 18. 사원 테이블에서 월급이 부서 30의 최저 월급보다 높은 사원을 출력
SELECT * FROM EMP
    WHERE SAL > ANY (SELECT SAL FROM EMP WHERE DEPTNO = 30);
SELECT * FROM EMP
    WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 30);
    
-- 19. 부서 10에서 부서 30의 사원과 같은 업무를 맡고 있는 사원의 이름과 업무를 출력
SELECT ENAME, JOB 
    FROM EMP
    WHERE JOB IN (SELECT JOB FROM EMP WHERE DEPTNO = 30)
      AND DEPTNO = 10;

-- 20. 사원 테이블에서 FORD와 업무도 월급도 같은 사원의 모든 정보를 출력
SELECT * FROM EMP
    WHERE (JOB, SAL) IN (SELECT JOB, SAL FROM EMP WHERE ENAME = 'FORD')
      AND ENAME != 'FORD';

-- 21. 이름이 JONES인 직원의 JOB과 같거나 
    --월급이 FORD 월급 이상인 사원의 정보를 이름,업무,부서번호,급여를 출력하는 SELECT문을 작성.
    -- 단, 업무별 알파벳 순, 월급이 많은 순으로 출력하여라.
SELECT ENAME, JOB, DEPTNO, SAL 
    FROM EMP
    WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'JONES')
       OR SAL >= (SELECT SAL FROM EMP WHERE ENAME = 'FORD')
    ORDER BY JOB, SAL DESC;

-- 22. 사원 테이블에서 SCOTT 또는 WARD와 월급이 같은 사원의 정보를 이름,업무,급여를 출력하는 SELECT문을 작성하시오.
SELECT ENAME, JOB, SAL 
    FROM EMP
    WHERE SAL IN (SELECT SAL FROM EMP 
                    WHERE ENAME IN ('SCOTT','WARD'))
      AND ENAME NOT IN ('SCOTT','WARD');

-- 23. 사원 테이블에서 CHICAGO에서 근무하는 사원과 같은 업무를 하는 사원들의 이름,업무를 출력하는 SELECT문을 작성하시오.
SELECT JOB FROM EMP E, DEPT D  
    WHERE E.DEPTNO = D.DEPTNO 
      AND LOC = 'CHICAGO'; -- 서브 쿼리 
SELECT ENAME, JOB 
    FROM EMP
    WHERE JOB IN (SELECT JOB FROM EMP E, DEPT D  
                    WHERE E.DEPTNO = D.DEPTNO AND LOC = 'CHICAGO'); -- 메인쿼리

-- 24. 사원 테이블에서 부서별로 월급이 평균 월급보다 높은 사원을 출력하는 SELECT문을 작성하시오.
--사원번호, 이름, 급여, DEPTNO, 해당부서별평균SAL
SELECT EMPNO, ENAME, SAL, DEPTNO, 
       (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO) -- 서브쿼리는 SELECT절에도 올 수 있다.
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO);

-- 25. 사원 테이블에서 업무별로 월급이 평균 월급보다 낮은 사원을 부서번호,이름,급여를 출력하는 SELECT문을 작성하시오.
SELECT DEPTNO, ENAME, SAL, (SELECT AVG(SAL) FROM EMP WHERE JOB = E.JOB) 
    FROM EMP E
    WHERE SAL < (SELECT AVG(SAL) FROM EMP WHERE JOB = E.JOB);

-- 26 사원 테이블에서 적어도 한 명 이상으로부터 보고를 받을 수 있는 사원을 업무,이름,사원번호,부서번호를 출력
-- (단, 부서번호 순으로 오름차순 정렬)
SELECT JOB, ENAME, EMPNO, DEPTNO
    FROM EMP
    WHERE EMPNO IN (SELECT MGR FROM EMP)
    ORDER BY DEPTNO;
SELECT JOB, ENAME, EMPNO, DEPTNO
    FROM EMP M
    WHERE EXISTS (SELECT EMPNO FROM EMP WHERE M.EMPNO = MGR)
    ORDER BY DEPTNO;

-- 27. 사원 테이블에서 말단 사원의 사원번호, 이름, 업무, 부서번호를 출력하는 SELECT문을 작성하시오.
SELECT EMPNO, ENAME, JOB, DEPTNO
    FROM EMP M
    WHERE NOT EXISTS (SELECT EMPNO FROM EMP WHERE M.EMPNO = MGR);     
SELECT M.EMPNO, M.ENAME, M.JOB, M.DEPTNO 
    FROM EMP W, EMP M
    WHERE W.MGR(+) = M.EMPNO AND W.ENAME IS NULL;
    
    -- 서브쿼리 결과에 NULL이 있으므로 아래와 같이는 할 수 없다.
SELECT EMPNO, ENAME, JOB, DEPTNO
    FROM EMP
    WHERE EMPNO NOT IN (SELECT MGR FROM EMP); --결과가 나타나지 않는다.
    -- 그래서 아래와 같이 해준다. 
SELECT EMPNO, ENAME, JOB, DEPTNO
    FROM EMP
    WHERE EMPNO NOT IN (SELECT MGR FROM EMP WHERE MGR IS NOT NULL);



















