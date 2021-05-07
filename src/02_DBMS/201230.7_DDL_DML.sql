-- [VII] DDL, DML, DCL
-- SQL = DDL(���̺����, ����, ��������, ���̺� ����������)
  --   + DML(SELECT, INSERT, UPDATE, DELETE)
  --   + DCL(����ڰ�������, ����ڿ��Ա��Ѻο�, ���ѹ�Ż, Ʈ�����Ǹ�ɾ�)
  
  -- �� �� �� DDL �� �� �� --
-- 1. ���̺� ���� (CREATE TABLE)
-- EX. �������� ���̺� ����� 
CREATE TABLE BOOK(
    BOOKID     NUMBER(4),    
    BOOKNAME   VARCHAR2(20), 
    PUBLISHER  VARCHAR2(20),
    RDATE      DATE,         -- ���� ��¥
    PRICE      NUMBER(8), 
    PRIMARY KEY(BOOKID) -- ���̺� �� ��Ű(PRIMARY KEY) = ����, NOT NULL
);
DROP TABLE BOOK; -- BOOK TABLE ����

CREATE TABLE BOOK(
    BOOKID     NUMBER(4)    PRIMARY KEY,  -- ��Ű�� �ش� �ʵ� ���� �Է��ϴ� �͵� ����   
    BOOKNAME   VARCHAR2(20), 
    PUBLISHER  VARCHAR2(20),
    RDATE      DATE,         -- ���� ��¥
    PRICE      NUMBER(8) 
);
SELECT * FROM BOOK; -- BOOK TABLE ���� Ȯ��

-- EX. EMP TABLE �� ������ EMP01 TABLE �����
CREATE TABLE EMP01(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(20),
    SAL   NUMBER(7,2)
);
SELECT * FROM EMP01;
DESC EMP01;     -- EMP01 TABLE�� ���� Ȯ��

-- EX. DEPT TABLE�� ������ DEPT01 TABLE �����
CREATE TABLE DEPT01(
    DEPTNO NUMBER(2),
    DNAME  VARCHAR2(14),
    LOC    VARCHAR2(13)
);
SELECT * FROM DEPT01;

-- EX. ���������� �̿��Ͽ� EMP2 TABLE �����
CREATE TABLE EMP02
    AS 
    SELECT * FROM EMP;
SELECT * FROM EMP02;
INSERT INTO EMP02 (EMPNO, ENAME, DEPTNO)
    VALUES (7369, 'HONG', 90); -- ������ �߰�

-- EX. EMP02�� ������ ������� EMP03 TABLE�� �����ϵ�, �����ȣ ����� �μ���ȣ�� �����ϱ�
CREATE TABLE EMP03
    AS
    SELECT EMPNO, ENAME, DEPTNO FROM EMP;
SELECT * FROM EMP03;

-- EX. EMP02�� ������ ������� EMP04 TABLE�� �����ϵ�, 10�� �μ��� �����ϱ�
CREATE TABLE EMP04
    AS 
    SELECT * FROM EMP WHERE DEPTNO = 10;
SELECT * FROM EMP04;

-- EX. EMP02�� ������ ������� EMP05 TABLE�� �����ϵ�, EMP TABLE�� ������ �����ϱ�
CREATE TABLE EMP05
    AS
    SELECT * FROM EMP WHERE 1=0; -- �����͸� ������� �ʾƾ� �ϹǷ� ���� ���� �� ���� �� ����
SELECT * FROM EMP05;


-- 2. ���̺� ���� ���� (ALTER TABLE)
-- ALTER TABLE ���̺�� 

-- (1) �ʵ� �߰� (ADD)
-- EX. EMP03 TABLE�� ����, �޿�, ����ȣ �ʵ� �߰��ϱ�
ALTER TABLE EMP03 
    ADD (JOB VARCHAR2(10), SAL NUMBER(7,2), MGR NUMBER(4));
SELECT * FROM EMP03;

-- (2) �ʵ� ���� (MODIFY)
-- EX. EMP03 TABLE�� �ʵ�� �Ϻ� �����ϱ�
ALTER TABLE EMP03 MODIFY(EMPNO VARCHAR(5)); -- �̹� ���� �����Ͱ� ����ִ� ���¶� ���� �Ұ�
ALTER TABLE EMP03 MODIFY(JOB VARCHAR(5)); -- ����ִ� ���� ���� NULL�̹Ƿ� ���� ����
ALTER TABLE EMP03 MODIFY(ENAME VARCHAR(200)); 
ALTER TABLE EMP03 MODIFY(ENAME VARCHAR(5)); -- �̹� 5BYTE�� �Ѵ� �����Ͱ� ����־� ���� �Ұ�

-- (3) �ʵ� ���� (DROP)
-- EX. EMP03 TABLE�� �ʵ带 �����ϱ�
ALTER TABLE EMP03 DROP COLUMN JOB;      -- JOB �ʵ� ���� (���� �Ŀ� ������ ���� �Ұ���)
ALTER TABLE EMP03 DROP COLUMN DEPTNO;   -- DEPTNO �ʵ� ���� 
SELECT * FROM EMP03;

-- * �������� Ư�� �ʵ忡 �������� ���ϵ��� �����ϱ�
ALTER TABLE EMP03 
    SET UNUSED (SAL); -- SAL �ʵ忡 ���� �Ұ� 
SELECT * FROM EMP03;
-- * �������� ���� �Ұ��ߴ� �ʵ带 �����ϱ�
ALTER TABLE EMP03 
    DROP UNUSED COLUMNS; -- ������ ������ ���̺� �׼��� �Ұ� 
SELECT * FROM EMP03;


-- 3. ���̺� ����(DROP TABLE)
DROP TABLE EMP01;
DROP TABLE DEPT; -- �ٸ� ���̺��� �����ϴ� �����Ͱ� �ִ� ���̺��� ��쿣 DROP�� �Ұ����ϴ�.
SELECT * FROM DEPT; -- ���� ���� Ȯ�� (�������� ����)


-- 4. ���̺� ���� �����͸� �� �� �����ϱ� (TRUNCATE TABLE)
TRUNCATE TABLE EMP02;   --  TRUNCATE�� DDL��ɾ��̹Ƿ� ��� �Ұ���


-- 5. ���̺� �̸� ���� (RENAME)
RENAME EMP03 TO EMP3; -- EMP03�� EMP3���� �̸� ����


-- 6. ������ ��ųʸ�(���� �Ұ�) -> ������ ��ųʸ� ��(����� ���ٿ�)
    -- DBA_TABLES, DBA_INDEXES, DBA_CONSTRAINTS, DBA_VIEWS;
    -- USER_TABLES, USER_INDEXES, USER_CONSTRAINTS, USER_VIEWS;
    -- ALL_TABLES, ALL_INDEXES, ALL_CONSTRAINTS, ALL_VIEWS;
    
-- USER_xxx ; SCOTT�� ������ ��ü(���̺�, �ε���, ..) ���� ��ȸ
SHOW USER; -- ����ڰ� �������� Ȯ��
SELECT * FROM USER_TABLES;
SELECT * FROM USER_INDEXES;
SELECT * FROM USER_CONSTRAINTS;
SELECT * FROM USER_VIEWS;

-- DBA_xxx ; DBA������ ���� ����ڸ� ���� ������ ��ü ����
SELECT TABLE_NAME, OWNER FROM DBA_TABLES;
SELECT * FROM DBA_INDEXES;
SELECT * FROM DBA_CONSTRAINTS;
SELECT * FROM DBA_VIEWS;

-- ALL_xxx ; SCOTT�� ������ ��ü�� ������ �ο��� ��ü
SELECT * FROM ALL_TABLES;
SELECT * FROM ALL_INDEXES;
SELECT * FROM ALL_CONSTRAINTS;
SELECT * FROM ALL_VIEWS;


-- �� �� �� DML �� �� �� --
-- 1. INSERT INTO ���̺��̸� (�ʵ��1, �ʵ��2, ..)  VALUES (��1, ��2, ...);
--    INSERT INTO ���̺��̸� VALUES (��1, ��2, ...);
-- EX. DEPT01 TABLE�� ������ �߰��ϱ�
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC)
    VALUES (10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT01 (DNAME, LOC, DEPTNO)
    VALUES ('SALES', 'BOSTON', 20);  -- �Է��ϴ� �ʵ�� ���� ������ �����ؾ� �Ѵ�.
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC)
    VALUES (30, 'IT', NULL);
SELECT * FROM DEPT01;

-- NULL���� �Է����� ������ �˾Ƽ� �ڵ� �Էµȴ�.
INSERT INTO DEPT01 (DEPTNO, DNAME) 
    VALUES (40, 'OPERATION');   -- �Է����� ���� LOC�ʵ忡 �ڵ� NULL�� ����.
SELECT * FROM DEPT01;

-- INSERT������ �ʵ���� ������ ���, �ݵ�� ��� �ʵ尪�� �� �Է����־�� �Ѵ�.
INSERT INTO DEPT01 
    VALUES (50, '����', '����');
SELECT * FROM DEPT01;
DESC DEPT01;

-- EX. DEPT01 TABLE�� DEPT TABLE 10~30�� �μ������� ������ INSERT�ϱ�
INSERT INTO DEPT01 
    SELECT * FROM DEPT WHERE DEPTNO < 40;
SELECT * FROM DEPT01;

-- EX. BOOK���̺� 11��, '����������', �Ѽ�����, ������ ����, ������ 90000 INSERT
INSERT INTO BOOK
    VALUES (11, '����������', '�Ѽ�����', SYSDATE, 90000);
SELECT * FROM BOOK;

-- * Ʈ����� ��ɾ� * -- 
COMMIT; -- DML ��ɾ�� Ʈ����� ������ ����ȴ�. �� Ʈ������� �۾��� �ݿ���
ROLLBACK; -- Ʈ����� �ȿ� �ִ� DML��ɾ� ���

-- EX. SAM01 TABLE�����Ͽ� �������� �۾� �����ϱ�
DROP TABLE SAM01; -- ���̺� ���� ��ɾ�� ���� ���翩�� Ȯ��
CREATE TABLE SAM01(  -- ���̺� ����
    EMPNO   NUMBER(4) CONSTRAINT C_SAM PRIMARY KEY,
    ENAME   VARCHAR2(10),
    JOB     VARCHAR2(9),
    SAL     NUMBER(7,2)
);
SELECT * FROM USER_CONSTRAINTS; 

DROP TABLE SAM01;
CREATE TABLE SAM01(
    EMPNO NUMBER(4) PRIMARY KEY,
    ENAME VARCHAR2(10),
    JOB VARCHAR2(9),
    SAL NUMBER(7,2)
);
SELECT * FROM USER_CONSTRAINTS;

DROP TABLE SAM01;
CREATE TABLE SAM01(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10),
    JOB VARCHAR2(9),
    SAL NUMBER(7,2),
    PRIMARY KEY(EMPNO)
);

INSERT INTO SAM01 (EMPNO, ENAME, JOB, SAL)  -- ������ �߰�
    VALUES (1000, 'APPLE', 'POLICE',10000);
INSERT INTO SAM01                           -- ��� �ʵ带 �Է��� ���� �ʵ�� �Է� ��������
    VALUES (1010, 'BANANA', 'NURSE', 15000);
INSERT INTO SAM01
    VALUES (1020, 'ORANGE', 'DOCTOR', 25000);
INSERT INTO SAM01 (EMPNO, ENAME, SAL)
    VALUES (1030, 'VERY', 25000);
INSERT INTO SAM01
    VALUES (1040, 'CAT', NULL, 2000);
INSERT INTO SAM01
    SELECT EMPNO, ENAME, JOB, SAL 
    FROM EMP WHERE DEPTNO = 10; -- EMP TABLE���� �μ���ȣ�� 10���� ����� ���� �ҷ�����
SELECT * FROM SAM01;   


-- 2. UPDATE ���̺�� SET �ʵ��1 = ��1(, �ʵ��2 = ��2, ...) (WHERE ����);
DROP TABLE EMP01;
CREATE TABLE EMP01      -- EMP TABLE�� ��� ������ EMP01 TABLE�� �����Ͽ� �ҷ�����
    AS 
    SELECT * FROM EMP;
-- EX. �μ���ȣ�� 30������ ����
UPDATE EMP01 
    SET DEPTNO = 30;
SELECT * FROM EMP01;
ROLLBACK;

-- EX. ��� �������� �޿��� 10% �λ�
UPDATE EMP01 
    SET SAL = SAL * 1.1;
SELECT * FROM EMP01;

-- * Ư�� ���� �����͸� ������ ���� WHERE���� �߰��Ѵ�.
-- EX. 10�� �μ� �������� �Ի����� ���÷�, �μ���ȣ�� 30�� �μ��� ����
UPDATE EMP01 
    SET HIREDATE = SYSDATE, DEPTNO = 30
    WHERE DEPTNO = 30;
SELECT * FROM EMP01;

-- EX. SAL�� 3000 �̻��� ����� �޿��� 10% �λ��Ͻÿ�
UPDATE EMP01
    SET SAL = SAL * 1.1 
    WHERE SAL >= 3000;

-- EX. DALLAS�� �ٹ��ϴ� �������� �޿��� 1000 �λ��Ͻÿ�
UPDATE EMP01
    SET SAL = SAL + 1000
    WHERE DEPTNO IN (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');

-- EX. SCOTT ����� �μ���ȣ�� 20����, JOB�� MANAGER�� �����Ͽ���.
UPDATE EMP01
    SET DEPTNO = 20, JOB = 'MANAGER'
    WHERE ENAME = 'SCOTT';
    
-- EX. SCOTT ����� �Ի����� ���÷�, �޿��� 50����, COMM�� 400���� �����Ͽ���
UPDATE EMP01
    SET HIREDATE = SYSDATE, SAL = 50, COMM = 400
    WHERE ENAME = 'SCOTT';

-- * ���������� �̿��� UPDATE�� 
-- EX. DEPT01 TABLE���� 20�� �μ��� �������� 40�� �μ��� ���������� ���� 
SELECT * FROM DEPT01;
UPDATE DEPT01
    SET DNAME = (SELECT DNAME FROM DEPT01 WHERE DEPTNO = 40)
    WHERE DEPTNO = 20;
    
-- EX. DEPT01 TABLE���� 20�� �μ��� �������� 40�� �μ��� �μ��� ���������� ����
UPDATE DEPT01
    SET (DNAME, LOC) = (SELECT DNAME, LOC FROM DEPT01 WHERE DEPTNO = 40)
    WHERE DEPTNO = 20;

-- EX. EMP01 TABLE�� ��� ����� �޿��� �Ի����� 'KING'�� �޿��� �Ի��Ϸ� ����
UPDATE EMP01
    SET (SAL, HIREDATE) = (SELECT SAL, HIREDATE 
                             FROM EMP WHERE ENAME = 'KING');


-- 3. DELETE FROM ���̺�� WHERE ����; 
COMMIT;
SELECT * FROM EMP01;
DELETE FROM EMP01; 
ROLLBACK;

-- EX. EMP01 TABLE���� 30�� �μ� �����鸸 ����
DELETE FROM EMP01 
    WHERE DEPTNO = 30;

-- EX. EMP01 TABLE���� JOB�� �������� ���� ������� ����
DELETE FROM SAM01
    WHERE JOB IS NULL;

-- EX. EMP01 TABLE���� �μ����� SALES�� ������� ����
DELETE FROM EMP01
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES');

-- EX. EMP01 TABLE���� RESEARCH �μ� �Ҽ��� ������� ����
DELETE FROM EMP01 
    WHERE DEPTNO = (SELECT DEPTNO  FROM DEPT WHERE DNAME = 'RESEARCH');

-- EX. MY_DATA TABLE�� �ۼ��Ͽ� �������� �۾��� �����غ��� 
-- 1) MY_DATA TABLE �����ϱ�
DROP TABLE MY_DATA;
CREATE TABLE MY_DATA(
    ID     NUMBER(4)   PRIMARY KEY,
    NAME   VARCHAR2(10),
    USERID VARCHAR2(30),
    SALARY NUMBER(10,2)
); 

-- 2) MY_DATA TABLE�� ������ �Է��ϱ�
INSERT INTO MY_DATA 
    VALUES (1, INITCAP('SCOTT'), 'sscott', 10000.00);
INSERT INTO MY_DATA
    VALUES (2, INITCAP('FORD'), 'fford', 13000.00);
INSERT INTO MY_DATA
    VALUES (3, INITCAP('PATEL'), 'ppatel', 33000.00);
INSERT INTO MY_DATA
    VALUES (4, INITCAP('REPORT'), 'rreport', 22350.00);
INSERT INTO MY_DATA
    VALUES (5, INITCAP('GOOD'), 'ggood', 45000.00);
    -- �Ʒ��� ���� ������ε� ���� 
INSERT INTO MY_DATA 
  VALUES (5, 'Good', 'ggood',TO_NUMBER('44,450.00','99,999.99'));

-- 3) 2������ �Է��� �ڷ� Ȯ��
SELECT * FROM MY_DATA;

-- 4) �ڷḦ ���������� �����ͺ��̽��� ���
COMMIT;

-- 5) ID�� 3���� ����� �޿��� 65,000.00���� �����ϰ�, ���������� �����ͺ��̽��� �ݿ�
UPDATE MY_DATA 
    SET SALARY = 65000.00 
    WHERE ID = 3;
COMMIT;

-- 6) �̸��� Ford�� ����� ���������ϱ�
DELETE FROM MY_DATA
    WHERE INITCAP(NAME) = 'Ford';

-- 7) �޿��� 15,000������ ����� �޿��� 15,000������ �����ϱ�
UPDATE MY_DATA 
    SET SALARY = 15000
    WHERE SALARY <= 15000;

-- 8) ���̺� ����
DROP TABLE MY_DATA;
---------------------------------------
-- �� �� �� ERD : ����ȭ�� �����͸� �����ϱ� ���� DB�� ����ϴµ�,
--              DB�� ������ �������ǵ� �پ��� ����� �����ϴ� ��

-- EX. deptEmp.exerd ���Ͽ� ���̺� 2�� ������ ���⿡ ���̺� ����� 
-- 1) DEPT1 TABLE(�θ����̺�) ���� �����ϱ�
CREATE TABLE DEPT1(
    DEPTNO  NUMBER(2)   PRIMARY KEY,
    DNAME   VARCHAR2(14),
    LOC     VARCHAR2(13)
);
SELECT * FROM DEPT1;

-- 2) EMP1 TABLE ����
CREATE TABLE EMP1(              -- ��������: �������� ������ ������ ���� 
    EMPNO     NUMBER(4)   PRIMARY KEY, -- ��������1. PRIMARY KEY
    ENAME     VARCHAR2(10)   UNIQUE,   -- ��������2. UNIQUE
    JOB       VARCHAR2(9)    NOT NULL,  -- ��������3. NOT NULL
    MGR       NUMBER(4),
    HIREDATE  DATE       DEFAULT SYSDATE, -- ��������4. DEFAULT
    SAL       NUMBER(7,2)   CHECK (SAL > 0), -- ��������5. CHECK
    COMM      NUMBER(7,2),
    DEPTNO    NUMBER(2)    REFERENCES DEPT1(DEPTNO) -- ��������6. FOREIGN KEY
);
SELECT * FROM EMP1;

-- 3) �� ���̺� ������ �߰�
INSERT INTO DEPT1 
    VALUES (10, 'ȸ��','����');
INSERT INTO DEPT1 
    VALUES (20, '����','����');
INSERT INTO DEPT1 
    VALUES (30, '����','�̴�');
INSERT INTO DEPT1 
    VALUES (40, '����','����');
SELECT * FROM DEPT1;

INSERT INTO EMP1 (EMPNO, ENAME, JOB, MGR, SAL, DEPTNO)
    VALUES (1111, 'ȫ��', 'ȸ��', NULL, 9000, 40);
SELECT * FROM EMP1;
INSERT INTO EMP1 (EMPNO, ENAME, JOB, MGR, SAL, DEPTNO)
    VALUES (1112, 'ȫ��', '����', 1111, 1000, 30);
INSERT INTO EMP1 VALUES
    (1113, '�豺', '����', 1112, TO_DATE('20201230','YYYYMMDD'), 8000, 200, 40);
SELECT * FROM EMP1;

COMMIT;

-- EX. student.exert ���Ͽ� ���̺��� ���� �� �л��� �����ϴ� ���̺� ����� 
DROP TABLE STUDENT;
DROP TABLE MAJOR;

-- 1) ���̺� ����
CREATE TABLE MAJOR(
    MAJOR_CODE       NUMBER(2)  PRIMARY KEY,
    MAJOR_NAME       VARCHAR2(100) NOT NULL,
    MAJOR_OFFICE_LOC VARCHAR2(100) NOT NULL
);

CREATE TABLE STUDENT(
    STUDENT_COTE    VARCHAR2(10)  PRIMARY KEY,
    STUDENT_NAME    VARCHAR2(30),
    SCORE           NUMBER(3),
    MAJOR_CODE      NUMBER(2)   REFERENCES MAJOR(MAJOR_CODE) 
);

-- 2) ������ �߰�
INSERT INTO MAJOR 
    VALUES (1, '�濵����', '3�� �ι���');
INSERT INTO MAJOR 
    VALUES (2, '����Ʈ�������', '3�� �ι���');
INSERT INTO MAJOR 
    VALUES (3, '������', '4�� ���н�');
INSERT INTO MAJOR 
    VALUES (4, '����', '4�� ���н�');
SELECT * FROM MAJOR;

INSERT INTO STUDENT 
    VALUES ('A01', '��浿', 100, 1);
INSERT INTO STUDENT 
    VALUES ('A02', '���浿', 90, 2);
INSERT INTO STUDENT 
    VALUES ('A03', 'ȫ�浿', 95, 1);
SELECT * FROM STUDENT;

DROP TABLE STUDENT; -- ������ ���� �����ϴ� ���̺���� 
DROP TABLE MAJOR;


-- EX. book.exerd���Ͽ� ���̺� ������ ����� ������������ ���̺� �����
-- 1) ���̺� ����
DROP TABLE BOOK;
DROP TABLE BOOKCATEGORY;

CREATE TABLE BOOKCATECORY( 
    CATEGORY_CODE   NUMBER(3)   PRIMARY KEY,
    CATEGORY_KIND   VARCHAR2(50),
    OFFICE_LOC      VARCHAR2(50)
);
SELECT * FROM BOOKCATEGORY;

CREATE TABLE BOOK01(
    CATEGORY_CODE NUMBER(3),
    BOOKNO VARCHAR2(20),
    BOOKNAME VARCHAR2(100),
    PUBLISHER VARCHAR2(100),
    PUBYEAR NUMBER(4) DEFAULT TO_NUMBER(TO_CHAR(SYSDATE,'YYYY')),
    PRIMARY KEY(BOOKNO),
    FOREIGN KEY(CATEGORY_CODE) REFERENCES BOOKCATEGORY(CATEGORY_CODE)
);

-- 2) ������ �߰�

INSERT INTO BOOKCATEGORY 
    VALUES (100, 'ö��','3�� �ι���');
INSERT INTO BOOKCATEGORY 
    VALUES (200, '�ι�','3�� �ι���');
INSERT INTO BOOKCATEGORY 
    VALUES (300, '�ڿ�����','3�� ���н�');
INSERT INTO BOOKCATEGORY 
    VALUES (400, 'IT','4�� ���н�');
SELECT * FROM BOOKCATEGORY;

INSERT INTO BOOK 
    VALUES (100,'100A01','ö������ ��','��������',2017);
INSERT INTO BOOK 
    VALUES (400,'400A01','�̰��� DB��','��������',2018);
INSERT INTO BOOK 
    VALUES (200,'500A01','����Ŭ','�Ѻ��̵��');
SELECT * FROM BOOK;

-- �� �� �� DCL �� �� �� --
-- ���� �߰� 
CREATE USER kim IDENTIFIED BY tiger; -- kim(����� tiger) ����

-- ���� �ο�
GRANT CREATE SESSION, CREATE TABLE TO kim;
GRANT SELECT ON EMP TO kim;

-- ���� ��Ż 
REVOKE SELECT ON EMP FROM kim;
DROP USER kim cascade;




