SHOW USER;

SELECT * FROM TAB;
SELECT * FROM DBA_TABLES; -- DBA권한 가진 자만 접근 가능 
SELECT * FROM USER_TABLES;-- 내 계정이 갖고 있는 테이블 정보
SELECT * FROM ALL_TABLES; -- 접근 가능한 테이블 정보
SELECT * FROM ALL_TABLES
    WHERE TABLE_NAME = 'EMP'; -- 특정 테이블 출력하기
EXIT; -- 접속 해제

SHOW USER;
SELECT * FROM SCOTT.EMP;    -- 권한 박탈하면 접근 불가
EXIT;