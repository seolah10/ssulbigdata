SHOW USER;

SELECT * FROM TAB;
SELECT * FROM DBA_TABLES; -- DBA���� ���� �ڸ� ���� ���� 
SELECT * FROM USER_TABLES;-- �� ������ ���� �ִ� ���̺� ����
SELECT * FROM ALL_TABLES; -- ���� ������ ���̺� ����
SELECT * FROM ALL_TABLES
    WHERE TABLE_NAME = 'EMP'; -- Ư�� ���̺� ����ϱ�
EXIT; -- ���� ����

SHOW USER;
SELECT * FROM SCOTT.EMP;    -- ���� ��Ż�ϸ� ���� �Ұ�
EXIT;