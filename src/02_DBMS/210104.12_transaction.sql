-- [XII] Transaction ��ɾ� ; COMMIT; ROLLBACK; SAVEPOINT;
COMMIT;

DROP TABLE DEPT01;
CREATE TABLE DEPT01 
    AS SELECT * FROM DEPT;
SELECT * FROM DEPT01; -- 10,20,30,40�� �μ� ���� 
DELETE FROM DEPT01; -- ��� �μ� ������ ����

ROLLBACK; -- �ٽ� �������

SELECT * FROM DEPT01; -- 10,20,30,40�� �μ� �ٽ� ��Ÿ��

---------------------< ���ο� Ʈ����� ���� >
DELETE FROM DEPT01 WHERE DEPTNO = 40; -- 40�� �μ� ����
SELECT * FROM DEPT01; -- 10,20,30�� �μ� ���� 

COMMIT; -- ���ݱ����� ������ ���� 

---------------------<���ο� Ʈ����� ���� > 
DELETE FROM DEPT01 WHERE DEPTNO = 30; -- 30�� �μ� ����
SELECT * FROM DEPT01; -- 10,20�� �μ� ���� 

SAVEPOINT C1; -- C1����: 10,20�� �μ� 

DELETE FROM DEPT01 WHERE DEPTNO = 20; -- 20�� �μ� ����
SELECT * FROM DEPT01; -- 10�� �μ� ���� 

SAVEPOINT C2; -- C2����: 10�� �μ� 

DELETE FROM DEPT01 WHERE DEPTNO = 10; -- 10�� �μ� ����
SELECT * FROM DEPT01; -- ������ ���� 

ROLLBACK TO C2; -- C2�������� �ٽ� ���ư���
SELECT * FROM DEPT01; -- 10���μ� �ٽ� ����

ROLLBACK TO C1; -- C1�������� �ٽ� ���ư���
SELECT * FROM DEPT01; -- 20���μ����� �ٽ� ����

COMMIT; -- ���ݱ����� ������ ����