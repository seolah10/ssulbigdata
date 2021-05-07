-- DROP
DROP TABLE STUDENT;
DROP TABLE MAJOR;
DROP SEQUENCE STUDENT_SEQ;

--CREATE
CREATE TABLE MAJOR(
    MNO NUMBER(2),
    MNAME VARCHAR2(50),
    PRIMARY KEY(MNO)
);
CREATE SEQUENCE STUDENT_SEQ 
    MAXVALUE 999
    NOCACHE
    NOCYCLE;
    
CREATE TABLE STUDENT(
    SNO VARCHAR2(7),
    SNAME VARCHAR2(50),
    MNO NUMBER(2),
    SCORE NUMBER(3) DEFAULT 0 CHECK(SCORE>=0 AND SCORE<=100),
    EXPEL NUMBER(1) DEFAULT 0 CHECK(EXPEL=0 OR EXPEL=1),
    PRIMARY KEY(SNO),
    FOREIGN KEY(MNO) REFERENCES MAJOR(MNO)
);

-- �а����� �Է� 
INSERT INTO MAJOR VALUES (1, '��������');
INSERT INTO MAJOR VALUES (2, '�濵������');
INSERT INTO MAJOR VALUES (3, '��ǻ�Ͱ���');
INSERT INTO MAJOR VALUES (4, '����Ʈ����');
INSERT INTO MAJOR VALUES (5, '�ΰ�������');
SELECT * FROM MAJOR;
COMMIT;

--�ܼ� StudentMng
-- 2021001������ ����� ����
SELECT TO_CHAR(SYSDATE, 'YYYY')||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL, '000'))
    FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY')||LPAD(STUDENT_SEQ.NEXTVAL, 3, '0') 
    FROM DUAL;

-- 1�� ���. �̸�, ������, ������ �Է¹޾� �Է�
--    �й��� �������� �̿��Ͽ� "����⵵||������ȣ"�� �Է��Ѵ�
INSERT INTO STUDENT (SNO, SNAME, MNO, SCORE) 
    VALUES (TO_CHAR(SYSDATE, 'YYYY')||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000')),
            '���켺', (SELECT MNO FROM MAJOR WHERE MNAME='��������'), 90);
INSERT INTO STUDENT (SNO, SNAME, MNO, SCORE) 
    VALUES (TO_CHAR(SYSDATE, 'YYYY')||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000')),
            '�ڼ���', (SELECT MNO FROM MAJOR WHERE MNAME='��������'), 90);
INSERT INTO STUDENT (SNO, SNAME, MNO, SCORE) 
    VALUES (TO_CHAR(SYSDATE, 'YYYY')||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000')),
            '�����', (SELECT MNO FROM MAJOR WHERE MNAME='��ǻ�Ͱ���'), 90);
INSERT INTO STUDENT (SNO, SNAME, MNO, SCORE) 
    VALUES (TO_CHAR(SYSDATE, 'YYYY')||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000')),
            '������', (SELECT MNO FROM MAJOR WHERE MNAME='��ǻ�Ͱ���'), 70);
INSERT INTO STUDENT (SNO, SNAME, MNO, SCORE) 
    VALUES (TO_CHAR(SYSDATE, 'YYYY')||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000')),
            'ȫ����', (SELECT MNO FROM MAJOR WHERE MNAME='�ΰ�������'), 20);            
SELECT * FROM STUDENT;

--2�� ���. ���ϴ� �а��̸��� �Է¹޾�
--    �а��� ��ȸ�� ������ ���� ������ ���
-- 1��    	���켺(2021001)     ��������      	90'
SELECT ROWNUM RANK, SNAME||'('||SNO||')' SNAME, MNAME, SCORE
    FROM (SELECT * FROM STUDENT S, MAJOR M  
            WHERE S.MNO = M.MNO AND MNAME='��ǻ�Ͱ���'
            ORDER BY SCORE DESC); -- ���1 

SELECT ROWNUM RANK, SNO, SNAME, MNAME, SCORE
    FROM (SELECT * FROM STUDENT S, MAJOR M
            WHERE S.MNO=M.MNO AND MNAME='��ǻ�Ͱ���'
            ORDER BY SCORE DESC); -- 

--3�� ������  
-- ���������� ���� ��ü �л��� ��ȸ �� ������ ���� �� ���
--���           �̸�         �а�      	����
--������������������������������������������������������������
--1��    	������(2021005)     �ΰ�������     	100
SELECT ROWNUM RANK, SNAME||'('||SNO||')' SNAME, MNAME, SCORE
    FROM (SELECT * FROM STUDENT S, MAJOR M  
            WHERE S.MNO = M.MNO AND EXPEL=0
            ORDER BY SCORE DESC); -- ���1 

SELECT ROWNUM RANK, SNO, SNAME, MNAME, SCORE
    FROM (SELECT * FROM STUDENT S, MAJOR M  
            WHERE S.MNO = M.MNO AND EXPEL=0
            ORDER BY SCORE DESC); -- ���2 

--4�� ������  
-- �������� ��ü �л��� ��ȸ �� ������ ���� �� ���
--���           �̸�         �а�      	����
--������������������������������������������������������������
--1��    ȫö��(2021006)     ����Ʈ����		20
SELECT ROWNUM RANK, SNAME||'('||SNO||')' SNAME, MNAME, SCORE
    FROM (SELECT * FROM STUDENT S, MAJOR M  
            WHERE S.MNO = M.MNO AND EXPEL=1
            ORDER BY SCORE DESC); -- ���1 
SELECT ROWNUM RANK, SNO, SNAME, MNAME, SCORE
    FROM (SELECT * FROM STUDENT S, MAJOR M  
            WHERE S.MNO = M.MNO AND EXPEL=1
            ORDER BY SCORE DESC); -- ���1 








