-- [III] JOIN : 테이블을 2개 이상 연결하여 검색
SELECT * FROM EMP 
    WHERE ENAME = 'SCOTT'; -- 부서번호(DEPNO):20
SELECT * FROM DEPT; 
-- (1) CROSS JOIN(FROM절에 테이블 2개 이상) 단순히 합치는 것...
SELECT * FROM EMP, DEPT 
    WHERE ENAME = 'SCOTT';


-- (2) ★ EQUI JOIN (공통 필드인 DEPTNO값이 일치되는 조건만 JOIN)
SELECT * FROM EMP, DEPT
    WHERE ENAME = 'SCOTT' AND EMP.DEPTNO = DEPT.DEPTNO; -- 조인 조건
SELECT * FROM EMP, DEPT 
    WHERE EMP.DEPTNO = DEPT.DEPTNO;

-- 모든 사원의 이름, 부서명, 부서번호
SELECT ENAME, DNAME, E.DEPTNO 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = E.DEPTNO;
SELECT E.*, ENAME, LOC 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = E.DEPTNO;
-- 사번, 이름, 부서번호, 부서이름, 근무지
SELECT EMPNO, ENAME, E.DEPTNO, DNAME, LOC 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = E.DEPTNO;
-- 급여 2000이상인 직원만 이름, 업무, 급여, 부서명 근무지 필드 출력
SELECT ENAME, JOB, SAL, DNAME, LOC 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL >= 2000;
-- LOC이 CHICAGO인 사람의 이름, 업무, 부서명, 근무지 필드 출력
SELECT ENAME, JOB, DNAME, LOC 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = E.DEPTNO AND LOC = 'CHICAGO';
-- 부서번호가 10 또는 20인 사원의 이름, 업무 근무지 출력(급여순 정렬)
SELECT ENAME, JOB, LOC 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = E.DEPTNO AND D.DEPTNO IN (10,20)
    ORDER BY SAL;
-- 이름, 급여, 상여(COMM), 연봉((급여+COMM)*12), 부서명, 근무지
SELECT ENAME, SAL, COMM, (SAL+NVL(COMM,0))*12 연봉, DNAME, LOC 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = E.DEPTNO;
-- 위에서 JOB이 salesman 또는 manager인 사원만 (연봉이 큰순 정렬)
SELECT ENAME, SAL, COMM, (SAL+NVL(COMM,0))*12 연봉, DNAME, LOC 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = E.DEPTNO AND JOB IN ('SALESMAN', 'MANAGER')
    ORDER BY 연봉 DESC;
SELECT ENAME, SAL, COMM, (SAL+NVL(COMM,0))*12 연봉, DNAME, LOC FROM 
    EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND UPPER(JOB) IN ('SALESMAN','MANAGER') -- UPPER: 대문자 
    ORDER BY 연봉 DESC;
-- COMM이 NULL이고 급여가 1200이상인 사원의 
--    이름, 급여, 입사일, 부서번호, 부서명(부서명순, 급여큰순 정렬)
SELECT ENAME, SAL, HIREDATE, E.DEPTNO, DNAME 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND COMM IS NULL AND SAL >= 1200
    ORDER BY DNAME, SAL DESC;
    
-- <노트 파일 예제>
-- 뉴욕에서 근무하는 사원의 이름과 급여를 출력하시오
SELECT ENAME, SAL 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND LOC = 'NEW YORK';
-- ACCOUTING 부서 소속 사원의 이름과 입사일을 출력하시오
SELECT ENAME, HIREDATE 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND DNAME = 'ACCOUNTING';
-- 직급이 MANAGER인 사원의 이름, 부서명을 출력하시오
SELECT ENAME, DNAME 
    FROM EMP E , DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND JOB = 'MANAGER';
-- COMM이 NULL이 아닌 사원의 이름, 급여, 부서코드, 근무지를 출력하시오
SELECT ENAME, SAL, E.DEPTNO, LOC 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND COMM IS NOT NULL;

-- (3) ★ NON-EQUI JOIN
-- SCOTT의 급여 등급을 알아보자.
SELECT ENAME, SAL 
    FROM EMP 
    WHERE ENAME = 'SCOTT';
SELECT * FROM SALGRADE; -- 급여등급 불러오기
SELECT ENAME, SAL, GRADE 
    FROM EMP, SALGRADE
    WHERE ENAME = 'SCOTT' 
        AND SAL BETWEEN LOSAL AND HISAL;
-- 모든 사원의 사번, 이름, JOB, 상사사번, 급여, 급여등급(1등급, 2등급)..
SELECT EMPNO, ENAME, JOB, MGR, SAL, GRADE || '등급' 
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL;

-- <노트 파일 예제>
--Comm이 null이 아닌 사원의 이름, 급여, 등급, 부서번호, 부서이름, 근무지
SELECT ENAME, SAL, GRADE, E.DEPTNO, DNAME, LOC 
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO 
        AND SAL BETWEEN LOSAL AND HISAL 
        AND COMM IS NOT NULL;
-- 이름, 급여, 입사일, 급여등급
SELECT ENAME, SAL, HIREDATE, GRADE 
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL;
-- 이름, 급여, 입사일, 급여등급, 부서명, 근무지
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME, LOC 
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO 
        AND SAL BETWEEN LOSAL AND HISAL;
-- 이름, 급여, 등급, 부서코드, 근무지. 단 COMM이 NULL이 아닌 경우
SELECT ENAME, SAL, GRADE, E.DEPTNO, LOC 
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO 
        AND SAL BETWEEN LOSAL AND HISAL 
        AND COMM IS NOT NULL;
-- 이름, 급여, 급여등급, 연봉, 부서명, 부서별 정렬, 부서가 같으면 연봉순.
--                                          연봉=(sal+comm)*12 comm이 null이면 0
SELECT ENAME, SAL, GRADE, (SAL+NVL(COMM,0))*12 연봉, DNAME 
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO 
        AND SAL BETWEEN LOSAL AND HISAL  
    ORDER BY DNAME, 연봉;
-- 이름, 업무, 급여, 등급, 부서코드, 부서명 출력. 
--          급여가 1000~3000사이.
--          정렬조건 : 부서별, 부서같으면 업무별, 업무같으면 급여 큰순
SELECT ENAME, JOB, SAL, GRADE, E.DEPTNO, DNAME 
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO 
        AND SAL BETWEEN LOSAL AND HISAL 
        AND SAL>=1000 AND SAL<=3000
    ORDER BY DNAME, JOB, SAL DESC;
-- 이름, 급여, 등급, 입사일, 근무지. 81년에 입사한 사람. 등급 큰순
SELECT ENAME, SAL, GRADE, HIREDATE, LOC 
    FROM EMP E, DEPT D, SALGRADE 
    WHERE E.DEPTNO = D.DEPTNO 
        AND SAL BETWEEN LOSAL AND HISAL 
        AND HIREDATE LIKE '81/%'
    ORDER BY GRADE DESC;
SELECT ENAME, SAL, GRADE, HIREDATE, LOC 
    FROM EMP E, DEPT D, SALGRADE 
    WHERE E.DEPTNO = D.DEPTNO 
        AND SAL BETWEEN LOSAL AND HISAL 
        AND TO_CHAR(HIREDATE, 'YY') = '81'
    ORDER BY GRADE DESC;


-- (4) ★ SELF JOIN
SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME MANAGERNAME 
    FROM EMP W, EMP M
    WHERE W.ENAME = 'SMITH' 
        AND W.MGR = M.EMPNO;
SELECT WORKER.EMPNO, WORKER.ENAME, MANAGER.ENAME
    FROM EMP WORKER, EMP MANAGER
    WHERE WORKER.MGR=MANAGER.EMPNO;--EMPNO에 NULL값이 없으므로 13명
-- "SMITH의 상사는 FORD다" 출력
SELECT W.ENAME || '의 상사는 ' || M.ENAME || '다.' 
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;

-- <노트 파일 예제>
-- ex1. 상사의 이름이 'KING'인 사원들의 이름과 JOB 출력--self
SELECT W.ENAME, W.JOB 
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO 
        AND M.ENAME = 'KING';
--☆☆ ex2. SCOTT과 동일한 부서번호에서 근무하는 사람의 이름 출력--self
                                -- SMITH, JONES, ADAMS, FORD  
SELECT E1.ENAME, E1.DEPTNO, E2.ENAME, E2.DEPTNO 
    FROM EMP E1, EMP E2
    WHERE E1.ENAME = 'SCOTT' 
        AND E1.DEPTNO = E2.DEPTNO AND E2.ENAME!= 'SCOTT'; 
SELECT E2.ENAME 
    FROM EMP E1, EMP E2
    WHERE E1.ENAME = 'SCOTT' 
        AND E1.DEPTNO = E2.DEPTNO 
        AND E2.ENAME!= 'SCOTT';    
-- ☆☆ ex3. SCOTT과 동일한 근무지에서 근무하는 사람의 이름 출력--self,equi
SELECT E1.ENAME, D1.LOC 
    FROM EMP E1, DEPT D1
    WHERE E1.DEPTNO = D1.DEPTNO 
        AND E1.ENAME = 'SCOTT'; -- 1. SCOTT의 부서 출력
SELECT E2.ENAME, D2.LOC 
    FROM EMP E2, DEPT D2
    WHERE E2.DEPTNO = D2.DEPTNO;    -- 2. 모든 사원의 이름과 근무지 출력
SELECT E2.ENAME 
    FROM EMP E1, DEPT D1, EMP E2, DEPT D2
     WHERE E1.DEPTNO = D1.DEPTNO 
        AND E1.ENAME = 'SCOTT' 
        AND E2.DEPTNO=D2.DEPTNO 
        AND D1.LOC=D2.LOC 
        AND E2.ENAME <> 'SCOTT';

ROLLBACK;
------------------------------

-- (5)★ OUTER JOIN; 조인 조건에 만족하지 않은 행까지 나타나도록 함
-- 사번, 사원명, 사원의 상사명 출력하기 
SELECT W.EMPNO, W.ENAME, M.ENAME 
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+); -- 상사가 없는(NULL인) 사원들도 출력하기 위해 상사명 필드에(+)추가
SELECT W.ENAME, NVL(M.ENAME,'-CEO-') 
    FROM EMP W, EMP M -- 상사가 없는 사원의 NULL 설정
    WHERE W.MGR = M.EMPNO(+);

SELECT W.EMPNO 사원, W.ENAME, M.ENAME 
    FROM EMP W, EMP M
    WHERE W.MGR(+) = M.EMPNO 
        AND W.EMPNO IS NULL; -- 말단사원

SELECT * FROM EMP; -- 15행
SELECT * FROM DEPT; -- 5행(10,20,30,40,50)
SELECT * FROM EMP E, DEPT D
    WHERE E.DEPTNO(+) = D.DEPTNO;
-- SMITH의 매니저는 FORD입니다 / KING의 매니저는 無입니다.
SELECT W.ENAME || '의 매니저는 ' || NVL(M.ENAME,'無') || '입니다'
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);
SELECT * FROM EMP;
-- ★ <연습문제> PART1
--1. 이름, 직속상사
SELECT W.ENAME, M.ENAME 
    FROM EMP W, EMP M 
    WHERE W.MGR = M.EMPNO;
--2. 이름, 급여, 업무, 직속상사
SELECT W.ENAME, W.SAL, W.JOB, M.ENAME MANAGER 
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;
--3. 이름, 급여, 업무, 직속상사. (상사가 없는 직원까지 전체 직원 다 출력.
    --상사가 없을 시 '없음'으로 출력)
SELECT W.ENAME, W.SAL, W.JOB, NVL(M.ENAME,'없음') MANAGER 
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO (+);
--4. 이름, 급여, 부서명, 직속상사명
SELECT W.ENAME, W.SAL, DNAME, M.ENAME 
    FROM EMP W, EMP M, DEPT D
    WHERE W.MGR = M.EMPNO 
        AND W.DEPTNO = D. DEPTNO;
--5. 이름, 급여, 부서코드, 부서명, 근무지, 직속상사명, (상사가 없는 직원까지 전체 직원 다 출력)
SELECT W.ENAME, W.SAL, W.DEPTNO, DNAME, LOC, NVL(M.ENAME,'없음') 직속상사 
    FROM EMP W, EMP M, DEPT D
    WHERE W.MGR = M.EMPNO(+) 
        AND W.DEPTNO = D. DEPTNO;
--6. 이름, 급여, 등급, 부서명, 직속상사명. 급여가 2000이상인 사람
SELECT W.ENAME, W.SAL, GRADE, DNAME, M.ENAME MANAGER 
    FROM EMP W, EMP M, DEPT D, SALGRADE
    WHERE W.MGR = M.EMPNO 
        AND W.DEPTNO = D.DEPTNO 
        AND W.SAL BETWEEN LOSAL AND HISAL 
        AND W.SAL >= 2000;
--7. 이름, 급여, 등급, 부서명, 직속상사명, (직속상사가 없는 직원까지 전체직원 부서명 순 정렬)
SELECT W.ENAME, W.SAL, GRADE, DNAME, M.ENAME MANAGER 
    FROM EMP W, EMP M, DEPT D, SALGRADE
    WHERE W.MGR = M.EMPNO(+) 
        AND W.DEPTNO = D.DEPTNO 
        AND W.SAL BETWEEN LOSAL AND HISAL
    ORDER BY DNAME;
--8. 이름, 급여, 등급, 부서명, 연봉, 직속상사명. 연봉=(급여+comm)*12 단 comm이 null이면 0
SELECT W.ENAME, W.SAL, GRADE, DNAME, W.SAL+NVL(W.COMM,0)*12 연봉, M.ENAME MANAGER 
    FROM EMP W, EMP M, DEPT D, SALGRADE
    WHERE W.MGR = M.EMPNO(+) 
        AND W.DEPTNO = D. DEPTNO 
        AND W.SAL BETWEEN LOSAL AND HISAL;
--9. 8번을 부서명 순 부서가 같으면 급여가 큰 순 정렬
SELECT W.ENAME, W.SAL, GRADE, DNAME, W.SAL+NVL(W.COMM,0)*12 연봉, M.ENAME MANAGER 
    FROM EMP W, EMP M, DEPT D, SALGRADE
    WHERE W.MGR = M.EMPNO 
        AND W.DEPTNO = D.DEPTNO 
        AND W.SAL BETWEEN LOSAL AND HISAL
    ORDER BY DNAME, W.SAL DESC;
    
--  PART2
--1.EMP 테이블에서 모든 사원에 대한 이름,부서번호,부서명을 출력하는 SELECT 문장을 작성하여라.
SELECT ENAME, E.DEPTNO, DNAME 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO;
--2. EMP 테이블에서 NEW YORK에서 근무하고 있는 사원에 대하여 이름,업무,급여,부서명을 출력
SELECT ENAME, JOB, SAL, DNAME 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO   
        AND LOC = 'NEW YORK';
--3. EMP 테이블에서 보너스를 받는 사원에 대하여 이름,부서명,위치를 출력
SELECT ENAME, DNAME, LOC 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO 
    AND COMM IS NOT NULL AND COMM != 0;
--4. EMP 테이블에서 이름 중 L자가 있는 사원에 대하여 이름,업무,부서명,위치를 출력
SELECT ENAME, JOB, DNAME, LOC 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO 
        AND ENAME LIKE '%L%';
--5. 사번, 사원명, 부서코드, 부서명을 검색하라. 사원명기준으로 오름차순정렬
SELECT EMPNO, ENAME, E.DEPTNO, DNAME 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO 
    ORDER BY ENAME;
--6. 사번, 사원명, 급여, 부서명을 검색하라. 
    --단 급여가 2000이상인 사원에 대하여 급여를 기준으로 내림차순으로 정열하시오
SELECT EMPNO, ENAME, SAL, ENAME 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO 
        AND SAL >= 2000
    ORDER BY SAL DESC;
--7. 사번, 사원명, 업무, 급여, 부서명을 검색하시오. 단 업무가 MANAGER이며 급여가 2500이상인
-- 사원에 대하여 사번을 기준으로 오름차순으로 정열하시오.
SELECT EMPNO, ENAME, JOB, SAL, DNAME 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO 
        AND JOB = 'MANAGER' 
        AND SAL >= 2500
    ORDER BY EMPNO;
--8. 사번, 사원명, 업무, 급여, 등급을 검색하시오. 단, 급여기준 내림차순으로 정렬하시오
SELECT EMPNO, ENAME, JOB, SAL, GRADE 
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
    ORDER BY SAL DESC;
--9. 사원테이블에서 사원명, 사원의 상사를 검색하시오(상사가 없는 직원까지 전체)
SELECT W.ENAME WORKER, M.ENAME MANAGER  
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);
--10. 사원명, 상사명, 상사의 상사명을 검색하시오
SELECT W.ENAME WORKER, M.ENAME MANAGER, MM.ENAME SUPERMANAGER 
    FROM EMP W, EMP M, EMP MM
    WHERE W.MGR = M.EMPNO 
        AND M.MGR = MM.EMPNO;
--11. 위의 결과에서 상위 상사가 없는 모든 직원의 이름도 출력되도록 수정하시오
SELECT W.ENAME, NVL(M.ENAME,'') MANAGER, NVL(MM.ENAME,'') SUPERMANAGER 
    FROM EMP W, EMP M, EMP MM
    WHERE W.MGR = M.EMPNO(+) 
        AND M.MGR = MM.EMPNO(+);



