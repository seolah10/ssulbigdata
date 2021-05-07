-- [XI] �ε��� : ��ȸ�� ������ �ϴ� �ε���

SELECT * FROM USER_INDEXES; -- SCOTT�� ��ųʸ� �信 ������ �ε��� ����

DROP TABLE EMP01;

CREATE TABLE EMP01 
    AS SELECT * FROM EMP;
SELECT * FROM EMP01;

SELECT COUNT(*) FROM EMP01;

INSERT INTO EMP01 
    SELECT * FROM EMP01; -- 12�� �����Ͽ� 22���� ������ ���� �����. 
SELECT TO_CHAR(COUNT(*),'9,999,999') FROM EMP01;
     
INSERT INTO EMP01 
    SELECT * FROM EMP01; -- 3�� ��(�� 15��) �����Ͽ� 180���� ������ ���� �����.
SELECT * FROM EMP01 
    WHERE ENAME = 'KING'; -- �� 50�� �� ��� 0.451�� �ҿ� 

-- �ε��� ���� �� ���� ����
CREATE INDEX IDX_EMP01_ENAME ON EMP01(ENAME); -- �ε��� ����

SELECT * FROM EMP01 
    WHERE ENAME = 'KING'; -- �� 50�� �� ��� 0.2�� �ҿ� 

SELECT * FROM USER_INDEXES;

-- �ε��� ���� 
DROP INDEX IDX_EMP01_ENAME; -- �ε��� ����
DROP TABLE EMP01; -- ������ ���̺��� �����ϸ� �ε����� �ڵ� �����ȴ�. 