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
----------------------------- 학과정보 입력 
INSERT INTO MAJOR VALUES (1, '빅데이터학');
INSERT INTO MAJOR VALUES (2, '경영정보학');
INSERT INTO MAJOR VALUES (3, '컴퓨터공학');
INSERT INTO MAJOR VALUES (4, '소프트웨어');
INSERT INTO MAJOR VALUES (5, '인공지능학');
SELECT * FROM MAJOR;
----------------------------- 학생정보 입력 
INSERT INTO STUDENT(SNO, SNAME, MNO, SCORE)
    VALUES (TO_CHAR(SYSDATE, 'YYYY') || 
            TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL, '000')),
            '정우성', (SELECT MNO FROM MAJOR WHERE MNAME='빅데이터학'), 90);
INSERT INTO STUDENT(SNO, SNAME, MNO, SCORE)
    VALUES (TO_CHAR(SYSDATE, 'YYYY') || 
            TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL, '000')),
            '정우성', (SELECT MNO FROM MAJOR WHERE MNAME='빅데이터학'), 90); 
INSERT INTO STUDENT(SNO, SNAME, MNO, SCORE)
    VALUES (TO_CHAR(SYSDATE, 'YYYY') || 
            TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL, '000')),
            '이정재', (SELECT MNO FROM MAJOR WHERE MNAME='빅데이터학'), 95); 
INSERT INTO STUDENT(SNO, SNAME, MNO, SCORE)
    VALUES (TO_CHAR(SYSDATE, 'YYYY') || 
            TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL, '000')),
            '전지현', (SELECT MNO FROM MAJOR WHERE MNAME='컴퓨터공학'), 80);
INSERT INTO STUDENT
    VALUES (TO_CHAR(SYSDATE, 'YYYY') || 
            TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL, '000')),
            '김제적', (SELECT MNO FROM MAJOR WHERE MNAME='인공지능학'), 10, 1);
SELECT * FROM STUDENT;
COMMIT;

----------------------------------SwingMng에 필요한 쿼리 
-- 0. 첫화면에 전공이름들 콤보박스에 추가(mName) 
--      : DAO에서 public Vector<String> getMNamelist()
SELECT MNAME FROM MAJOR;

-- 1. 학번검색 (sNo, sName, mName, score) 
--      : DAO에서 public StudentSwingDto sNogetStudent(String sNo)
SELECT SNO, SNAME, MNAME, SCORE 
    FROM STUDENT S, MAJOR M
    WHERE S.MNO=M.MNO AND SNO='2021001';
    
-- 2. 이름검색 (sNo, sName, mName, score) 
--      : DAO에서 public ArrayList<StudentSwingDto> sNamegetStudent(String sName)
SELECT SNO, SNAME, MNAME, SCORE 
    FROM STUDENT S, MAJOR M
    WHERE S.MNO=M.MNO AND SNAME='전지현';
    
-- 3. 전공검색 (rank, sName(sNo포함), mName(mNo포함), score) 
--      : DAO에서 public ArrayList<StudentSwingDto> mNamegetStudent(String mName)
--- 출력 : 1 정우성(2021001) 빅데이터학(1) 90 
SELECT ROWNUM RANK, SNAME||'('||SNO||')' SNAME, MNAME||'('||MNO||')' MNAME, SCORE
    FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M
            WHERE S.MNO=M.MNO AND MNAME='빅데이터학'
            ORDER BY SCORE DESC);
            
-- 4. 학생입력 : DAO에서 public int insertStudent(String sName, String mName, int score)
--              DAO에서 public int insertStudent(StudentSwingDto dto)
INSERT INTO STUDENT (SNO, SNAME, MNO, SCORE) 
    VALUES (TO_CHAR(SYSDATE, 'YYYY') || TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL, '000')),
    '하정우', (SELECT MNO FROM MAJOR WHERE MNAME='경영정보학'), 40);
COMMIT;    

-- 5. 학생수정 : DAO에서 public int updateStudent(String sNo, String sName, String mName, int score)
--              DAO에서 public int updateStudent(StudentSwingDto dto)
SELECT * FROM STUDENT;
UPDATE STUDENT SET SNAME='하정우',
    MNO=(SELECT MNO FROM MAJOR WHERE MNAME='인공지능학'),
    SCORE=50
        WHERE SNO='2021006';
COMMIT;

-- 6. 학생출력 (rank, sName(sNo포함), mName(mNo포함), score) 
--      : DAO에서 public ArrayList<StudentSwingDto> getStudents()
-- 출력 : 1 정우성(2021001) 빅데이터학(1) 90
SELECT ROWNUM RANK, SNAME||'('||SNO||')' SNAME, MNAME||'('||MNO||')' MNAME, SCORE
    FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M
            WHERE S.MNO=M.MNO AND EXPEL=0
            ORDER BY SCORE DESC);
            
-- 7. 제적자출력  (rank, sName(sNo포함), mName(mNo포함), score) 
--      : DAO에서 public ArrayList<StudentSwingDto> getStudentsExpel()
-- 출력 : 1 김제적(2021004) 컴퓨터공학(3) 10
SELECT ROWNUM RANK, SNAME||'('||SNO||')' SNAME, MNAME||'('||MNO||')' MNAME, SCORE
    FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M
            WHERE S.MNO=M.MNO AND EXPEL=1
            ORDER BY SCORE DESC);
-- 8. 제적처리 : DAO에서 public int sNoExpel(String sNo)
UPDATE STUDENT SET EXPEL=1 WHERE SNO='2021005';
COMMIT;

SELECT * FROM STUDENT;
SELECT * FROM MAJOR;
UPDATE STUDENT SET EXPEL=0;
