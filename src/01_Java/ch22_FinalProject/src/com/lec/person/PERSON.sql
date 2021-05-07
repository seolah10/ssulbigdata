DROP TABLE PERSON;
DROP TABLE JOB;

CREATE TABLE JOB (
    JNO NUMBER(2) PRIMARY KEY,
    JNAME VARCHAR(20) NOT NULL
);
CREATE TABLE PERSON (
    NO NUMBER(5) PRIMARY KEY,
    NAME VARCHAR(20) NOT NULL,
    JNO NUMBER(2) REFERENCES JOB(JNO),
    KOR NUMBER(3),
    ENG NUMBER(3),
    MAT NUMBER(3)
);
DROP SEQUENCE PERSON_NO_SQ;
CREATE SEQUENCE PERSON_NO_SQ
    MAXVALUE 99999 NOCACHE NOCYCLE;

INSERT INTO JOB VALUES (10, '배우');
INSERT INTO JOB VALUES (20, '가수');
INSERT INTO JOB VALUES (30, '엠씨');
SELECT * FROM JOB;

-- 1. 입력 
INSERT INTO PERSON VALUES 
    (PERSON_NO_SQ.NEXTVAL, '정우성',
        (SELECT JNO FROM JOB WHERE JNAME='배우'), 90, 80, 81);
INSERT INTO PERSON VALUES 
    (PERSON_NO_SQ.NEXTVAL, '박세영',
        (SELECT JNO FROM JOB WHERE JNAME='배우'), 80, 90, 91);
INSERT INTO PERSON VALUES 
    (PERSON_NO_SQ.NEXTVAL, '배수지',
        (SELECT JNO FROM JOB WHERE JNAME='가수'), 100, 70, 85);
SELECT * FROM PERSON;
COMMIT;

-- 2번 기능: 총점 순으로 내림차순
SELECT NAME||'('||NO||'번)' NAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
    FROM PERSON P, JOB J
    WHERE P.JNO = J.JNO AND JNAME='배우'
    ORDER BY SUM DESC; -- FROM절에 들어갈 서브쿼리

SELECT ROWNUM RANK, S.* 
    FROM (SELECT NAME||'('||NO||'번)' NAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
            FROM PERSON P, JOB J
            WHERE P.JNO = J.JNO AND JNAME='배우'
            ORDER BY SUM DESC) S; -- JAVA의 2번 기능에 쓸 쿼리 

-- 3번.
SELECT ROWNUM RANK, S.* 
    FROM (SELECT NAME||'('||NO||'번)' NAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
            FROM PERSON P, JOB J
            WHERE P.JNO = J.JNO
            ORDER BY SUM DESC) S;

-- 콤보박스에 넣을 직업 리스트 
SELECT JNAME FROM JOB;