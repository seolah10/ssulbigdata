-- [XII] Transaction 명령어 ; COMMIT; ROLLBACK; SAVEPOINT;
COMMIT;

DROP TABLE DEPT01;
CREATE TABLE DEPT01 
    AS SELECT * FROM DEPT;
SELECT * FROM DEPT01; -- 10,20,30,40번 부서 존재 
DELETE FROM DEPT01; -- 모든 부서 데이터 삭제

ROLLBACK; -- 다시 원래대로

SELECT * FROM DEPT01; -- 10,20,30,40번 부서 다시 나타남

---------------------< 새로운 트랜잭션 시작 >
DELETE FROM DEPT01 WHERE DEPTNO = 40; -- 40번 부서 삭제
SELECT * FROM DEPT01; -- 10,20,30번 부서 존재 

COMMIT; -- 지금까지의 데이터 저장 

---------------------<새로운 트랜잭션 시작 > 
DELETE FROM DEPT01 WHERE DEPTNO = 30; -- 30번 부서 삭제
SELECT * FROM DEPT01; -- 10,20번 부서 존재 

SAVEPOINT C1; -- C1지점: 10,20번 부서 

DELETE FROM DEPT01 WHERE DEPTNO = 20; -- 20번 부서 삭제
SELECT * FROM DEPT01; -- 10번 부서 존재 

SAVEPOINT C2; -- C2지점: 10번 부서 

DELETE FROM DEPT01 WHERE DEPTNO = 10; -- 10번 부서 삭제
SELECT * FROM DEPT01; -- 데이터 없음 

ROLLBACK TO C2; -- C2지점으로 다시 돌아가기
SELECT * FROM DEPT01; -- 10번부서 다시 복구

ROLLBACK TO C1; -- C1지점으로 다시 돌아가기
SELECT * FROM DEPT01; -- 20번부서까지 다시 복구

COMMIT; -- 지금까지의 데이터 저장