DROP TABLE STUDENT;
DROP TABLE MAJOR;
DROP SEQUENCE STUDENT_SEQ;
---------------------------
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
----------------------------- �а����� �Է� 
INSERT INTO MAJOR VALUES (1, '��������');
INSERT INTO MAJOR VALUES (2, '�濵������');
INSERT INTO MAJOR VALUES (3, '��ǻ�Ͱ���');
INSERT INTO MAJOR VALUES (4, '����Ʈ����');
INSERT INTO MAJOR VALUES (5, '�ΰ�������');
SELECT * FROM MAJOR;
----------------------------- �л����� �Է� 
INSERT INTO STUDENT(SNO, SNAME, MNO, SCORE)
    VALUES (TO_CHAR(SYSDATE, 'YYYY') || 
            TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL, '000')),
            '���켺', (SELECT MNO FROM MAJOR WHERE MNAME='��������'), 90);
INSERT INTO STUDENT(SNO, SNAME, MNO, SCORE)
    VALUES (TO_CHAR(SYSDATE, 'YYYY') || 
            TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL, '000')),
            '���켺', (SELECT MNO FROM MAJOR WHERE MNAME='��������'), 90); 
INSERT INTO STUDENT(SNO, SNAME, MNO, SCORE)
    VALUES (TO_CHAR(SYSDATE, 'YYYY') || 
            TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL, '000')),
            '������', (SELECT MNO FROM MAJOR WHERE MNAME='��������'), 95); 
INSERT INTO STUDENT(SNO, SNAME, MNO, SCORE)
    VALUES (TO_CHAR(SYSDATE, 'YYYY') || 
            TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL, '000')),
            '������', (SELECT MNO FROM MAJOR WHERE MNAME='��ǻ�Ͱ���'), 80);
INSERT INTO STUDENT
    VALUES (TO_CHAR(SYSDATE, 'YYYY') || 
            TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL, '000')),
            '������', (SELECT MNO FROM MAJOR WHERE MNAME='�ΰ�������'), 10, 1);
SELECT * FROM STUDENT;
COMMIT;

----------------------------------SwingMng�� �ʿ��� ���� 
-- 0. ùȭ�鿡 �����̸��� �޺��ڽ��� �߰�(mName) 
--      : DAO���� public Vector<String> getMNamelist()
SELECT MNAME FROM MAJOR;

-- 1. �й��˻� (sNo, sName, mName, score) 
--      : DAO���� public StudentSwingDto sNogetStudent(String sNo)
SELECT SNO, SNAME, MNAME, SCORE 
    FROM STUDENT S, MAJOR M
    WHERE S.MNO=M.MNO AND SNO='2021001';
    
-- 2. �̸��˻� (sNo, sName, mName, score) 
--      : DAO���� public ArrayList<StudentSwingDto> sNamegetStudent(String sName)
SELECT SNO, SNAME, MNAME, SCORE 
    FROM STUDENT S, MAJOR M
    WHERE S.MNO=M.MNO AND SNAME='������';
    
-- 3. �����˻� (rank, sName(sNo����), mName(mNo����), score) 
--      : DAO���� public ArrayList<StudentSwingDto> mNamegetStudent(String mName)
--- ��� : 1 ���켺(2021001) ��������(1) 90 
SELECT ROWNUM RANK, SNAME||'('||SNO||')' SNAME, MNAME||'('||MNO||')' MNAME, SCORE
    FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M
            WHERE S.MNO=M.MNO AND MNAME='��������'
            ORDER BY SCORE DESC);
            
-- 4. �л��Է� : DAO���� public int insertStudent(String sName, String mName, int score)
--              DAO���� public int insertStudent(StudentSwingDto dto)
INSERT INTO STUDENT (SNO, SNAME, MNO, SCORE) 
    VALUES (TO_CHAR(SYSDATE, 'YYYY') || TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL, '000')),
    '������', (SELECT MNO FROM MAJOR WHERE MNAME='�濵������'), 40);
COMMIT;    

-- 5. �л����� : DAO���� public int updateStudent(String sNo, String sName, String mName, int score)
--              DAO���� public int updateStudent(StudentSwingDto dto)
SELECT * FROM STUDENT;
UPDATE STUDENT SET SNAME='������',
    MNO=(SELECT MNO FROM MAJOR WHERE MNAME='�ΰ�������'),
    SCORE=50
        WHERE SNO='2021006';
COMMIT;

-- 6. �л���� (rank, sName(sNo����), mName(mNo����), score) 
--      : DAO���� public ArrayList<StudentSwingDto> getStudents()
-- ��� : 1 ���켺(2021001) ��������(1) 90
SELECT ROWNUM RANK, SNAME||'('||SNO||')' SNAME, MNAME||'('||MNO||')' MNAME, SCORE
    FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M
            WHERE S.MNO=M.MNO AND EXPEL=0
            ORDER BY SCORE DESC);
            
-- 7. ���������  (rank, sName(sNo����), mName(mNo����), score) 
--      : DAO���� public ArrayList<StudentSwingDto> getStudentsExpel()
-- ��� : 1 ������(2021004) ��ǻ�Ͱ���(3) 10
SELECT ROWNUM RANK, SNAME||'('||SNO||')' SNAME, MNAME||'('||MNO||')' MNAME, SCORE
    FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M
            WHERE S.MNO=M.MNO AND EXPEL=1
            ORDER BY SCORE DESC);
-- 8. ����ó�� : DAO���� public int sNoExpel(String sNo)
UPDATE STUDENT SET EXPEL=1 WHERE SNO='2021005';
COMMIT;

SELECT * FROM STUDENT;
SELECT * FROM MAJOR;
UPDATE STUDENT SET EXPEL=0;
