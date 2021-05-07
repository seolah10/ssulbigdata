-- [IV] 단일행함수
-- 함수 = 단일행함수 + 그룹함수
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YY"년"MM"월"DD"일"') 
    FROM EMP; -- 특수문자가 아닌 글자는 반드시 ""사이에 입력
SELECT ENAME, INITCAP(ENAME) 
    FROM EMP; -- ININTCAP(); 첫글자만 대문자로 
SELECT SUM(SAL) 
    FROM EMP; -- 그룹함수, SUM(); 합계
SELECT DEPTNO, SUM(SAL) 
    FROM EMP 
    GROUP BY DEPTNO; -- 그룹함수 (부서번호 그룹 별로 급여 합계 출력하기)
-- EX. 숫자함수, 문자함수, 날짜함수, 형변환함수, NVL(). etc... 

-- (1) 숫자함수
DESC DUAL; -- 오라클에서 제공하는 1행 1열짜리 DUMMY TABLE
SELECT ABS(-9) 
    FROM DUAL; -- 절대값
SELECT FLOOR(34.5678) 
    FROM DUAL; -- 소수점에서 내림 
SELECT FLOOR(34.5678*10)/10 
    FROM DUAL; -- 소수점 한자리에서 내림 (JAVA에서 했던 방법)
SELECT TRUNC(34.5678) 
    FROM DUAL; -- 소수점에서 내림 
SELECT TRUNC(34.5678,1) 
    FROM DUAL; -- 소수점 한자리에서 내림 
SELECT TRUNC(34.5678,-1) 
    FROM DUAL; -- 일의 자리에서 내림
-- ex) EMP테이블에서 이름, 급여 출력(급여는 십의 자리에서 내림)
SELECT ENAME, TRUNC(SAL,-2) SAL 
    FROM EMP;

SELECT CEIL(34.5678) 
    FROM DUAL; -- 소수점에서 올림
SELECT ROUND(34.5678) 
    FROM DUAL; -- 소수점에서 반올림
SELECT ROUND(34.5678,1) 
    FROM DUAL; -- 소수점 한자리에서 반올림
SELECT ROUND(34.5678,-1) 
    FROM DUAL; -- 일의자리에서 반올림
SELECT FLOOR(10/4) 
    FROM DUAL; -- 원래 값(2.5)에서 소수점에서 버리고 출력

SELECT MOD(9,2)    
    FROM DUAL; -- MOD(); 나머지 연산
SELECT MOD('9',2) 
    FROM DUAL;
-- ex) 홀수 달에 입사한 직원들의 모든 필드를 출력
SELECT * FROM EMP 
    WHERE MOD(TO_CHAR(HIREDATE, 'MM'),2) = 1; 


-- (2) 문자 함수 
-- 1) 문자 변환
SELECT UPPER('abcABC') 
    FROM DUAL; -- 대문자로 변환
SELECT LOWER('abcABC') 
    FROM DUAL; -- 소문자로 변환 
SELECT INITCAP('abcABC') 
    FROM DUAL; -- 첫문자만 대문자, 나머지는 소문자로 변환
-- ex) JOB이 MANAGER인 직원의 모든 필드
SELECT * FROM EMP 
    WHERE UPPER(JOB) = 'MANAGER';
-- ex) 사번, 사원명을 출력하되, 사원명의 이름은 첫글자만 대문자가 되도록 출력
SELECT EMPNO, INITCAP(ENAME) 
    FROM EMP;

-- 2) 문자 연결
SELECT 'AB' || 'CD' || 'EF' || 'GH' 
    FROM DUAL; --  연결연산자 || 사용 
SELECT CONCAT(CONCAT('AB','CD'), CONCAT('EF','GH')) 
    FROM DUAL; -- CONCAT 함수 사용 
      -- CONCAT은 두 문자씩만 연결 가능하므로, 그 이상을 연결하고 싶을 땐 두 문자씩 묶은 후 또 그룹화해야 한다.
-- ex) 'ENAME은 JOB이다.' 형태 출력하기
SELECT  ENAME || '은 ' || JOB || '이다.' 
    FROM EMP; --  연결연산자 || 사용 
SELECT CONCAT(CONCAT(ENAME,'은 '), CONCAT(JOB,'이다.')) 
    FROM EMP; -- CONCAT함수 사용

-- 3) SUBSTR(STR, 시작위치, 문자갯수) - 첫 위치가 1 / SUBSTRB(STR, 시작위치, 문자바이트수)
SELECT SUBSTR('WELCOM TO ORACLE', 3, 2) 
    FROM DUAL; --3번째 위치부터 문자 2개 
SELECT SUBSTRB('WELCOM TO ORACLE', 3, 2) 
    FROM DUAL; --3번째 BYTE부터 2BYTE
SELECT SUBSTR('데이터베이스', 4, 3) 
    FROM DUAL; -- 4번째 위치부터 문자 3개
SELECT SUBSTRB('데이터베이스', 4, 3) 
    FROM DUAL; -- 4번째 BYTE부터 3BYTE
        -- 영어는 한 문자가 1BYTE, 한글은 한 문자가 3BYTE라서 결과가 다르다.
-- ex) 9월에 입사한 사원의 모든 필드 (81/01/01)
SELECT * FROM EMP 
    WHERE SUBSTR(HIREDATE, 4, 2) = '09'; -- 날짜의 4번째 위치부터 두 문자가 '09' 
-- ex) 해당 전화번호의 뒷자리 4자리만 출력하기
SELECT SUBSTR('02-716-9999', -4, 4) 
    FROM DUAL; -- 위치가 음수일 경우, 뒤부터 센다. 

-- 4) LENGTH(); 문자 수 / LENGHB(); 문자 바이트 수
SELECT LENGTH('ABCD') 
    FROM DUAL;
SELECT LENGTHB('ABCD') 
    FROM DUAL;
SELECT LENGTH('오라클') 
    FROM DUAL;
SELECT LENGTHB('오라클') 
    FROM DUAL;

-- 5) INSTR(str, 찾을글자); str에서 찾을 글자의 위치(첫번째1), 없으면 0 출력(JAVA에서는 -1이었음)
SELECT INSTR('ABCABC', 'B') 
    FROM DUAL; -- 문자가 중복될 경우, 먼저 쓰여진 문자의 위치를 출력함
SELECT INSTR('ABCABC', 'B', 3) 
    FROM DUAL; -- INSTR(str, 찾을글자, 시작위치); - 3번째 뒤에 있는 'B'의 위치를 찾는다.
-- ex) 9월에 입사한 사원을 INSTR함수를 이용하여 출력하기 (81/12/09)
SELECT * FROM EMP 
    WHERE INSTR(HIREDATE, '09') = 4; -- 날짜에서 문자 '09'가 4번 위치에 와야 한다.
-- ex) 9일에 입사한 사원을 INSTR함수를 이용하여 출력하기 (81/12/09)
SELECT * FROM EMP 
    WHERE INSTR(HIREDATE, '09') = 7;

-- 6) LPAD(문자, 자릿수, '*'); 문자를 자릿수만큼 확보 하고 왼쪽 빈자리엔 *로 채운다.
--    RPAD(문자, 자릿수, '*'); 문자를 자릿수만큼 확보 하고 오른쪽 빈자리엔 *로 채운다.
SELECT LPAD('ORACLE', 20, '#') 
    FROM DUAL; -- ORACLE의 왼쪽을 ORCLE포함하여 20자리가 되도록 #을 채운다.
SELECT RPAD('ORACLE', 20, '#') 
    FROM DUAL; 
-- ex) 사원명과 급여 출력 (급여는 총 6자리가 되도록 숫자 앞에 *를 채워서 출력한다.)
SELECT ENAME, LPAD(SAL, 6, '*') 
    FROM EMP;
-- ex) 사번, 사원명(사원명은 S****형식으로 출력)
SELECT EMPNO, RPAD(SUBSTR(ENAME, 1, 1), LENGTH(ENAME), '*')  NAME 
    FROM EMP;
-- ex) 사번, 사원명(S****), 입사일(80/12/**) 출력 
SELECT EMPNO, RPAD(SUBSTR(ENAME, 1, 1), LENGTH(ENAME), '*'), 
              RPAD(SUBSTR(HIREDATE,1,6), LENGTH(HIREDATE),'*') 
    FROM EMP;
-- ex) 사번, 사원명(****H), 입사일(80/12/**) 출력
SELECT EMPNO, LPAD(SUBSTR(ENAME,-1,1), LENGTH(ENAME), '*'),
              RPAD(SUBSTR(HIREDATE, 1, 6), LENGTH(HIREDATE), '*') 
    FROM EMP;
-- ex) 이름의 세번째 자리가 R인 사원의 모든 필드 출력
SELECT * FROM EMP 
    WHERE ENAME LIKE '__R%'; -- LIKE 연산자 
SELECT * FROM EMP 
    WHERE SUBSTR(ENAME, 3, 1) = 'R'; -- SUBSTR 함수
SELECT * FROM EMP 
    WHERE INSTR(ENAME, 'R') = 3; -- INSTR 함수

-- 7) TRIM(); 양 옆의 SPACE제거 
SELECT TRIM('     ORACLE DB     ') 
    FROM DUAL;
SELECT LTRIM('     ORACLE DB     ') 
    FROM DUAL; -- 왼쪽 SPACE 제거
SELECT RTRIM('     ORACLE DB     ') 
    FROM DUAL; -- 오른쪽 SPACE 제거

-- 8) REPLACE(문자, 바꿀문자, 대체할문자) 
-- ex) 사원들의 이름의 A를 X로 변경하여 출력한다.
SELECT REPLACE(ENAME, 'A', 'X') 
    FROM EMP;


-- (3) 날짜 예약어, 날짜 함수
-- 1) SYSDATE 
SELECT SYSDATE FROM DUAL; -- SYSDATE; 현재 날짜 출력
SELECT TO_CHAR(SYSDATE, 'YY-MM-DD HH24:MI:SS"초"') 
    FROM DUAL; -- 현재 날짜와 시각 출력
SELECT SYSDATE-1 어제, SYSDATE 오늘, SYSDATE+1 내일 
    FROM DUAL;
-- ex) 이름, 입사일, 근무일수 출력 (근무일자는 소수점에서 버리고 출력한다.) 
SELECT ENAME, HIREDATE, FLOOR(SYSDATE-HIREDATE) 근무일수 
    FROM EMP; 
SELECT ENAME, HIREDATE, TRUNC(SYSDATE-HIREDATE) 근무일수 
    FROM EMP; 
-- ex) 이름, 입사일, 근무주수, 근무년수 출력
SELECT ENAME, HIREDATE, FLOOR((SYSDATE-HIREDATE)/7) 근무주수,
                        FLOOR((SYSDATE-HIREDATE)/365) 근무년수 
    FROM EMP;

-- 2) MONTHS_DATE(최근시점, 지난시점), 특정한 두 시점 사이의 개월 수
-- ex) 이름, 입사일, 근무월수 출력
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) 
    FROM EMP; 
                           
-- 3) ADD_MONTH(날짜, 추가 개월 수)                            
-- ex) 이름, 입사일, 수습기간 만료일(수습기간은 6개월)
SELECT ENAME HIREDATE, ADD_MONTHS(HIREDATE, 6) "수습기간 만료일" 
    FROM EMP;
                           
-- 4) NEXT_DAY(특정날짜, '수'); 특정날짜로부터 처음 돌아오는 수요일
--    LAST_DAY(특정날짜); 특정 날짜에 해당하는 달의 말일
-- ex) 돌아오는 토요일이 언제인지 출력하기
SELECT NEXT_DAY(SYSDATE, '토') 
    FROM DUAL;
-- ex) 이름, 입사일, 월급날(월급날은 말일이다.)
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) 월급날 FROM EMP;

-- 5) ROUND; 날짜 반올림 / TRUNC; 날짜 버림
SELECT ROUND(SYSDATE, 'YEAR') 
    FROM DUAL; -- <년 반올림>: 현 시점에서 가까운 1월 1일 
SELECT ROUND(SYSDATE, 'MONTH') 
    FROM DUAL; -- <월 반올림>: 현 시점에서 가까운 1일의 달 
SELECT ROUND(SYSDATE, 'DAY') 
    FROM DUAL; -- <일 반올림>: 현 시점에서 가까운 일요일의 날짜
SELECT ROUND(SYSDATE) 
    FROM DUAL; -- <시간 반올림> 현 시점에서 가까운 0시에 해당하는 날짜 

SELECT TRUNC(SYSDATE, 'YEAR') 
    FROM DUAL; -- <년 버림>: 지난 1월 1일
SELECT TRUNC(SYSDATE, 'MONTH') 
    FROM DUAL; -- <월 버림>: 지난 1일
SELECT TRUNC(SYSDATE, 'DAY') 
    FROM DUAL; -- <일 버림>: 지난 일요일에 해당하는 날짜
SELECT TRUNC(SYSDATE) 
    FROM DUAL; -- <시간 버림>: 지난 0시에 해당하는 날짜

-- ex) 이름, 입사일, 입사일에 해당하는 달의 1일 
SELECT ENAME, HIREDATE, TRUNC(HIREDATE, 'MONTH') 
    FROM EMP;
-- ex) 이름, 입사일, 월급날(25일)
SELECT ENAME, HIREDATE, ROUND(HIREDATE-9, 'MONTH')+24 "월급날" 
    FROM EMP;
-- ex) 이름, 입사일, 월급날(17일)
SELECT ENAME, HIREDATE, ROUND(HIREDATE-1, 'MONTH')+16 "월급날" 
    FROM EMP; 
-- ex) 이름, 입사일, SAL(월급), 이때까지 받은 월급합
SELECT ENAME, HIREDATE SAL, SAL*TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) 
    FROM EMP;
-- ex) 이름, 입사일 SAL, COMM, 이때까지 받은 연봉(SAL*12+COMM)의 합
SELECT ENAME, HIREDATE, SAL, COMM,
    SAL*TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE))+NVL(COMM,0) * TRUNC((SYSDATE-HIREDATE)/365)
    FROM EMP;


-- (4) 형변환함수 
-- 1) TO_CHAR(날짜, 패턴); 날짜값을 패턴에 맞게 문자형으로 변환 
     -- YY(년도) MM(월) MON(월이름) DD(일) DY(요일)
     -- HH24(0~23시) AM(오전/오후) HH(0~11시) MI(분) SS(초)
-- ex. 현재 날짜와 시각 출력하기 
SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY"년" DD"월" MM"일" DY"요일"')  
    FROM EMP; -- YY,MM,DD 모두 반드시 두자리 이상 표기
SELECT TO_CHAR(SYSDATE, 'YY"년" MON DD"일" AM HH"시" MI"분" SS"초"')
    FROM EMP;

-- TO_CHAR(숫자, 패턴) ; 숫자값을 패턴에 맞게 문자형로 변환
    -- 패턴내 0 ; 자릿수. 자릿수가 맞지 않으면 0으로 채움
    -- 패턴내 9 ; 자릿수. 자릿수가 맞지 않으면 채우지 않음(자바에서는 #)
    -- 패턴내 $ ; 통화단위 $가 숫자앞에 붙음
    -- 패턴내 L ; 지역통화단위가 숫자앞에 붙음
SELECT ENAME, TO_CHAR(SAL, 'L999,999') SAL 
    FROM EMP;
SELECT ENAME, TO_CHAR(SAL, '$999,999') SAL 
    FROM EMP;
SELECT ENAME, TO_CHAR(SAL, '$000,000') SAL  
    FROM EMP; -- 0은 표기한 만큼 자릿수를 채워서 입력된다. 
    
-- 2) TO_DATE(문자, 패턴) ; '81/01/01'문자를 패턴에 맞게 날짜형으로 변환
-- 81/5/1 ~ 83/5/1 사이에 입사한 직원 출력
SELECT * FROM EMP
    WHERE HIREDATE BETWEEN '81/05/01' AND '83/05/01'; -- 우리나라 날짜 시스템에서만 가능한 방법
SELECT * FROM EMP
    WHERE HIREDATE BETWEEN TO_DATE('19810501','YYYYMMDD')
                       AND TO_DATE('19830501','YYYYMMDD'); -- 년도 4자리  
-- ex. 2020년11월30일부터 현재까지 날짜수를 출력(시스템의 날짜형 포맷을 모른다는 가정 하에)
SELECT SYSDATE - TO_DATE('20201130','YYYYMMDD') 
    FROM DUAL; -- 소수점 처리 필요
SELECT ROUND(SYSDATE - TO_DATE('20201130','YYYYMMDD')) 
    FROM DUAL; 
SELECT TRUNC(SYSDATE - TO_DATE('20201130','YYYYMMDD')) 
    FROM DUAL;    
    
-- 3) TO_NUMBER(문자, 패턴);문자를 패턴에 맞게 숫자형으로 변환    
SELECT TO_NUMBER('1,000', '9,999') 
    FROM DUAL;    
SELECT TO_NUMBER('1,000', '9,999')*1.1 
    FROM DUAL; -- 연산을 위해 사용한다.
    
    
-- (5) NULL관련함수 ; NVL(널일 수도 있는 데이터, 널이면대신할 값)
                     -- 매개변수 2개는 반드시 타입이 일치해야 함
--ex. 사원이름, 직속상사의 이름(직속상사가 없으면 CEO로 출력)
SELECT W.ENAME, NVL(M.ENAME, 'CEO') 
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);
--ex. 사원이름, 직속상사의 사번(직속상사가 없으면 CEO로 출력)
SELECT ENAME, NVL(TO_CHAR(MGR), 'CEO') MGR 
    FROM EMP; -- 타입이 서로 다른 MGR과 'CEO'를 일치시켜준다.
    
    
-- (6) DECODE(데이터, 값1, 결과1, 값2, 결과2, ..., 값N, 결과N, 그외결과)
-- ex. 이름, 부서번호, 부서이름    
SELECT ENAME, D.DEPTNO, ENAME 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO; -- JOIN 방법

SELECT ENAME, DEPTNO, 
       DECODE(DEPTNO, 10, 'ACCOUNTING', 20, 'RESEARCH', 30, 'SALES',
                      40, 'OPERATIONS', 'ETC.') AS "DNAME"
    FROM EMP; -- DECODE 방법

SELECT ENAME, DEPTNO,
    CASE WHEN DEPTNO = 10 THEN 'ACCOUNTING'
         WHEN DEPTNO = 20 THEN 'RESEARCH'
         WHEN DEPTNO = 30 THEN 'SALES'
         WHEN DEPTNO = 40 THEN 'OPERATION'
         ELSE 'ETC'
    END AS "DNAME"
    FROM EMP; -- CASE 이용 
SELECT ENAME, DEPTNO,
    CASE DEPTNO WHEN 10 THEN 'ACCOUNTIN'
                WHEN 20 THEN 'RESEARCH'
                WHEN 30 THEN 'SALES'
                WHEN 40 THEN 'OPERATIONS'
         ELSE 'ETC'
    END AS "DNAME"
    FROM EMP; -- CASE 이용 (조건필드가 다 동일하면 앞으로 뺌)    
    
--ex. 이름, 급여, 인상예정급여     
    -- JOB에 따라 'ANALYST' 10%인상, 'MANAGER'면 20%인상
            -- 'PRESIDENT'면 30%인상 'SALESMAN'면 40%인상
            -- 'CLERK'은 인상제외
SELECT ENAME, SAL 현급여, 
    DECODE(JOB, 'ANALYST', SAL*1.1, 'MANAGER', SAL*1.2, 
                'PRESIDENT', SAL*1.3, 'SALESMAN', SAL*1.4, SAL) 인상급여
    FROM EMP; -- DECODE 이용 
SELECT ENAME ,SAL 현급여,
    CASE WHEN JOB = 'ANALYST' THEN SAL*1.1 
         WHEN JOB = 'MANAGER' THEN SAL*1.2
         WHEN JOB = 'PRESIDENT' THEN SAL*1.3
         WHEN JOB = 'SALESMAN' THEN SAL*1.4
         ELSE SAL
    END 인상급여
    FROM EMP; -- CASE 이용 
SELECT ENAME, SAL 현급여,
    CASE JOB WHEN 'ANALYST' THEN SAL*1.1
             WHEN 'MANAGER' THEN SAL*1.2
             WHEN 'PRESIDENT' THEN SAL*1.3
             WHEN 'SALESMAN' THEN SAL*1.4
    ELSE SAL
    END 인상급여
    FROM EMP; -- CASE 이용 (중복필드 앞으로 빼기)


-- (7) 그 외 함수
-- 1) EXTRACT 
-- ex. 사원들 입사일의 년도만 / 월만 추출하기
SELECT EXTRACT(YEAR FROM HIREDATE) YEAR 
    FROM EMP;
SELECT TO_CHAR(HIREDATE, 'YYYY') YRAR
    FROM EMP;
SELECT EXTRACT(MONTH FROM HIREDATE) MONTH
    FROM EMP;
SELECT TO_CHAR(HIREDATE, 'MM') MONTH 
    FROM EMP;

-- 2) LEVEL, START WITH(최상위레벨의조건), CONNECT BY PRIOR(레벨들 연결조건)
-- ex. 직원 관계도 직급별로 나타내기
SELECT LEVEL, LPAD(' ', LEVEL*2) || ENAME, MGR -- 직급에 따라 사원명 들여쓰기 
    FROM EMP
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO = MGR;


--< 총 연습문제>
-- 1. 현재 날짜를 출력하고 TITLE에 “Current Date”로 출력하는 SELECT 문장을 기술하시오.
SELECT SYSDATE "Current Date" 
    FROM DUAL;

-- 2. EMP 테이블에서 현재 급여에 15%가 증가된 급여를 계산하여,
-- 사원번호,이름,업무,급여,증가된 급여(New Salary),증가액(Increase)를 출력하는 SELECT 문장
SELECT EMPNO, ENAME, JOB, SAL, 
       SAL*1.15 "New Salary", SAL*0.15 "Increase" 
    FROM EMP;

--3. 이름, 입사일, 입사일로부터 6개월 후 돌아오는 월요일 구하여 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, HIREDATE, 
       NEXT_DAY(ADD_MONTHS(HIREDATE, 6), '월') "6개월 후 월요일"
    FROM EMP;
--4. 이름, 입사일, 입사일로부터 현재까지의 개월수, 급여, 입사일부터 현재까지의 받은 급여의 총계를 출력
SELECT ENAME, HIREDATE,
       TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) 개월수, SAL, 
       ROUND(MONTHS_BETWEEN(SYSDATE, HIREDATE)*SAL, 2) 급여총계
    FROM EMP;

SELECT ENAME, HIREDATE,
       TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) 개월수, SAL,
       TO_CHAR(ROUND(MONTHS_BETWEEN(SYSDATE, HIREDATE),2)*SAL,'$9,999,999.99') 급여총계
    FROM EMP;
    
--5. 모든 사원의 이름과 급여(15자리로 출력 좌측의 빈 곳은 “*”로 대치)를 출력
SELECT ENAME, LPAD(SAL, 15, '*') 
    FROM EMP;

--6. 모든 사원의 정보를 이름,업무,입사일,입사한 요일을 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DAY')
    FROM EMP;

SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DY"요일"') 
    FROM EMP;
    
--7. 이름의 길이가 6자 이상인 사원의 정보를 이름,이름의 글자수,업무를 출력
SELECT ENAME, LENGTH(ENAME), JOB 
    FROM EMP
    WHERE LENGTH(ENAME) >= 6;
    
--8. 모든 사원의 정보를 이름, 업무, 급여, 보너스, 급여+보너스를 출력
SELECT ENAME, JOB, SAL, COMM, SAL+NVL(COMM,0) 
    FROM EMP;

-- 9.사원 테이블의 사원명에서 2번째 문자부터 3개의 문자를 추출하시오. 
SELECT ENAME, SUBSTR(ENAME, 2, 3) 
    FROM EMP;

--10. 사원 테이블에서 입사일이 12월인 사원의 사번, 사원명, 입사일을 검색하시오. 
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE HIREDATE LIKE '%/12/%';
    
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE SUBSTR(HIREDATE, 4, 2) = '12';
    
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE INSTR(HIREDATE, '12', 4) = 4; 

SELECT EMPNO, ENAME, HIREDATE
    FROM EMP 
    WHERE EXTRACT(MONTH FROM HIREDATE) = 12; -- 모든 날짜 시스템에 적용 가능 
    
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE TO_CHAR(HIREDATE, 'MM') = '12';    -- 모든 날짜 시스템에 적용 가능
    
--11. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
--EMPNO		ENAME		급여
--7369		       SMITH		*******800
--7499		       ALLEN		******1600
--7521		       WARD		******1250
--……. 
SELECT EMPNO, ENAME, LPAD(SAL, 10, '*')
    FROM EMP;
    
-- 12. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
-- EMPNO	 ENAME 	입사일
-- 7369	  SMITH		1980-12-17
-- ….
SELECT EMPNO, ENAME, 
       TO_CHAR(HIREDATE, 'YYYY-MM-DD') 입사일
    FROM EMP;

--13. 사원 테이블에서 부서 번호가 20인 사원의 사번, 이름, 직무, 급여를 출력하시오.
    --(급여는 앞에 $를 삽입하고3자리마다 ,를 출력한다)
SELECT EMPNO, ENAME, JOB, TO_CHAR(SAL, '$9,999') SAL 
    FROM EMP
    WHERE DEPTNO = 20;

-- 14. 사원 테이블에서 급여에 따라 사번, 이름, 급여, 등급을 검색하는 SQL 문장을 작성 하시 오.
-- 급여가 0~1000 E / 1001~2000 D / 2001~3000 C / 3001~4000 B / 4001~5000 A
SELECT EMPNO, ENAME, SAL,
       CASE WHEN SAL BETWEEN 0 AND 1000 THEN 'E'
            WHEN SAL BETWEEN 1001 AND 2000 THEN 'D'
            WHEN SAL BETWEEN 2001 AND 3000 THEN 'C'
            WHEN SAL BETWEEN 3001 AND 4000 THEN 'B'
            WHEN SAL BETWEEN 4001 AND 5000 THEN 'A'
            END 등급 
    FROM EMP;

SELECT EMPNO, ENAME, SAL,
       CASE WHEN SAL >= 0 AND SAL <= 1000 THEN 'E'
            WHEN SAL >= 1001 AND SAL <= 2000 THEN 'D'
            WHEN SAL >= 2001 AND SAL <= 3000 THEN 'C'
            WHEN SAL >= 3001 AND SAL <= 4000 THEN 'B'
            WHEN SAL >= 4001 AND SAL <= 5000 THEN 'A'
            END 등급 
    FROM EMP;

SELECT EMPNO, ENAME, SAL,
       CASE TRUNC((SAL-1)/1000) WHEN 0 THEN 'E'
                                WHEN 1 THEN 'D'
                                WHEN 2 THEN 'C'
                                WHEN 3 THEN 'B'
       ELSE 'A'
       END 등급
    FROM EMP;
                                
SELECT EMPNO, ENAME, SAL,
       DECODE(TRUNC((SAL-1)/1000), 0, 'E', 1, 'D', 2, 'C', 
                                   3, 'B', 'A') 등급 
    FROM EMP;

-- 0~999 E / 1000~1999 D / 2000~2999 C / 3000~3999 B / 4000이상 A
SELECT EMPNO, ENAME, SAL, 
       DECODE(TRUNC(SAL/1000), 0, 'E', 1, 'D', 2, 'C', 3, 'B', 'A') 등급 
    FROM EMP;
    
SELECT EMPNO, ENAME, SAL, CASE TRUNC(SAL/1000) WHEN 0 then 'E' 
                                               WHEN 1 THEN 'D' 
                                               WHEN 2 THEN 'C' 
                                               WHEN 3 THEN 'B'
                          ELSE 'A' END 등급 
   FROM EMP;



