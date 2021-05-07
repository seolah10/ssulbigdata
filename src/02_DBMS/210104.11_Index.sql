-- [XI] 인덱스 : 조회를 빠르게 하는 인덱스

SELECT * FROM USER_INDEXES; -- SCOTT가 딕셔너리 뷰에 소유한 인덱스 정보

DROP TABLE EMP01;

CREATE TABLE EMP01 
    AS SELECT * FROM EMP;
SELECT * FROM EMP01;

SELECT COUNT(*) FROM EMP01;

INSERT INTO EMP01 
    SELECT * FROM EMP01; -- 12번 실행하여 22만개 정도의 행을 만든다. 
SELECT TO_CHAR(COUNT(*),'9,999,999') FROM EMP01;
     
INSERT INTO EMP01 
    SELECT * FROM EMP01; -- 3번 더(총 15번) 실행하여 180만개 정도의 행을 만든다.
SELECT * FROM EMP01 
    WHERE ENAME = 'KING'; -- 총 50개 행 출력 0.451초 소요 

-- 인덱스 생성 후 빠른 조히
CREATE INDEX IDX_EMP01_ENAME ON EMP01(ENAME); -- 인덱스 생성

SELECT * FROM EMP01 
    WHERE ENAME = 'KING'; -- 총 50개 행 출력 0.2초 소요 

SELECT * FROM USER_INDEXES;

-- 인덱스 삭제 
DROP INDEX IDX_EMP01_ENAME; -- 인덱스 삭제
DROP TABLE EMP01; -- 하지만 테이블을 삭제하면 인덱스도 자동 삭제된다. 