-- [X] VIEW, INLINE VIEW, TOP-N����
-- 1. VIEW : ������ ���̺� 
-- (1)�ܼ���
-- EX. EMPv0�̶� VIEW ���� �Ǵ� ���� = EMP TABLE�� �Ϻ� �ʵ带 ���� ������ ���̺�
--      ����
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP;
SELECT * FROM EMPv0;

--      ������ �߰�
INSERT INTO EMPv0 
    VALUES (1111, 'PARK', 'IT', 40); -- VIEW�� INSERT
SELECT * FROM EMP WHERE EMPNO = 1111; -- ���� EMP TABLE���� �߰��ȴ�.

-- EX. EMPv0 VIEW���� EMP TABLE�� 30�� �μ��ุ ��������
CREATE OR REPLACE VIEW EMPv0 
    AS SELECT * FROM EMP WHERE DEPTNO = 30; 
SELECT * FROM USER_VIEWS; -- ������ ��ųʸ� �� Ȯ��
SELECT * FROM EMPv0;  

INSERT INTO EMPv0
    VALUES (1111, 'JOE', NULL, NULL, NULL, NULL, NULL, 30); 
                        -- EMP TABLEó�� EMPN0�� UNIQUE ���� �������� ���� �߰� �Ұ���

--       30���� �ƴ� �μ��� ������ �߰��� ����������, �������� �ʴ´�.
INSERT INTO EMPv0
    VALUES (1112, 'JOE', NULL, NULL, NULL, NULL, NULL, 40);
SELECT * FROM EMPv0; -- ������ �߰��� 1112�� ����� �� �� ����.
SELECT * FROM EMP; -- ���⼭ �� �� �ִ�.

DELETE FROM EMPv0 WHERE EMPNO < 1113; -- �Ʊ� 30�� �μ��� ���������Ƿ�, 30���μ� ����� 1111�� ������
DELETE FROM EMP WHERE EMPNO < 1113; -- 1111, 1112 ��� ����

COMMIT; 

-- EX. EMP TABLE 30�� �μ��� ���� ���̺��� �ҷ��ͼ� 30�� �μ��� �߰� �����ϵ��� �����ϱ�
CREATE OR REPLACE VIEW EMPv0
    AS SELECT * FROM EMP WHERE DEPTNO = 30
    WITH CHECK OPTION; -- VIEW�� ���� ����
SELECT * FROM EMPv0;
--      30�� �μ��� ������ �߰� ����
INSERT INTO EMPv0
    VALUES (1111, 'PARK', 'ANALYST', NULL, SYSDATE, 1250, NULL, 30); 
SELECT * FROM EMPv0;
--      30�� �μ����� ������ �߰� �Ұ��� 
INSERT INTO EMPv0
    VALUES (1112, 'JOE', 'VICE PRESIDENT', NULL, SYSDATE, 1250, NULL, 40); -- ���� �Ұ� 
--      �� ������ ����
DELETE FROM EMPv0 WHERE EMPNO = 1111;
    
-- (2) ���պ� 
-- EX. EMP TABLE�� DEPT TABLE���� �����͸� �ҷ��� EMPv1 VIEW�����
CREATE OR REPLACE VIEW EMPv1
    AS SELECT EMPNO, ENAME, JOB, DNAME 
            FROM DEPT D, EMP E
            WHERE D.DEPTNO = E.DEPTNO;
SELECT * FROM EMPv1;      
--      ���պ信���� DML����� �������̴�.
INSERT INTO EMPv1
    VALUES (1111, 'PARK', 'ANALYST', 'RESEARCH'); -- ���� �Ұ�

-- **** ���պ� ���� DML ��ɾ�(INSERT, UPDATE, DELETE)�� ��� ����� �� ���� ���
-- 1) VIEW�� �б� ������ �� 
CREATE OR REPLACE VIEW  EMPv2
    AS SELECT EMPNO, ENAME, DEPTNO FROM EMP
    WITH READ ONLY; 
SELECT * FROM EMPv2;
SELECT EMPNO, ENAME, DNAME FROM EMPv2 E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
INSERT INTO EMPv2 VALUES (1111, 'ȫ', 40);    

-- 2) �������� ���̺��� NOT NULL�� �ʵ带 �������� �ʾ��� �� 
CREATE OR REPLACE VIEW EMPv3
    AS SELECT ENAME, SAL FROM EMP;
SELECT * FROM EMPv3;
INSERT INTO EMPv3 
    VALUES ('ȫ', 9000); -- EMP TABLE�� EMPNO �ʵ尡 NOT NULL�ε� ���� EMPv3�� ����.
DESC EMPv3;    
     
-- 3) VIEW ���� �� �ʵ忡 ������ ���� ��� 
CREATE OR REPLACE VIEW EMPv3
    AS SELECT EMPNO, ENAME, SAL*12 YEARSAL FROM EMP; -- VIEW�� ��Ī�� �ʵ� �ٷ� ����,
CREATE OR REPLACE VIEW EMPv3 (EMPNO, ENAME, YEARSAL) -- Ȥ�� ()�ȿ� ���� - ��, �� ��쿣 ��� �ʵ忡 ��Ī�� �־�� �Ѵ�.
    AS SELECT EMPNO, ENAME, SAL*12 FROM EMP;
SELECT * FROM EMPv3;

INSERT INTO EMPv3 
    VALUES (1115, 'LEE', 12000); -- �ʵ忡 ����(SAL*12)�� �־ ���� �Ұ�
    
-- 4) VIEW ������ �ʵ忡 �Լ��� ����� ��� 
CREATE OR REPLACE VIEW EMPv3
    AS SELECT EMPNO, ENAME, ROUND(SAL, -3) SAL FROM EMP;

INSERT INTO EMPv3
    VALUES (1115, 'SHIN', 1000); -- �Լ�(ROUND)�� ���Ե� �ʵ�� ���� ���� �Ұ�


CREATE OR REPLACE VIEW DEPTv1 (DEPTNO, MINSAL, MAXSAL, AVGSAL)
    AS SELECT DEPTNO, MIN(SAL), MAX(SAL), ROUND(AVG(SAL),1)
            FROM EMP GROUP BY DEPTNO;
SELECT * FROM DEPTv1;

INSERT INTO DEPTv1
    VALUES (40, 800, 9000, 4000); -- �Լ� �ʵ��� ���� ��� �Ұ�

-- 5) DISTINCT�� ������ VIEW 
CREATE OR REPLACE VIEW EMPv3
    AS SELECT DISTINCT JOB, DEPTNO 
            FROM EMP ORDER BY JOB;
SELECT * FROM EMPv3;

INSERT INTO EMPv3
    VALUES ('CLEAR', 10); -- JOB�ʵ尡 DISTINCT�̹Ƿ� ���� �Ұ�

-- 2. INLINE VIEW: SQL���� �����ϴ� �� ���� ��ɾ���� ������ VIEW / FROM���� �������� 
--      SELECT �ʵ�1, �ʵ�2.... 
--          FROM EMP E, (��������) S
--          WHERE ����

-- EX. �޿��� 2000�� �ʰ��ϴ� ����� ��� �޿� 
SELECT AVG(SAL) 
    FROM EMP
    WHERE SAL > 2000; 
SELECT AVG(SAL)
    FROM (SELECT SAL FROM EMP WHERE SAL > 2000); -- INLINE VIEW

--EX. �̸�, �޿�, �μ���ȣ, �ش� ����� �μ� ��� �޿� (SELECT�� �������� �̿�)
SELECT ENAME, SAL, DEPTNO 
    FROM EMP; -- (1) �̸�, �޿� �μ���ȣ ���
SELECT DEPTNO, ROUND(AVG(SAL)) 
    FROM EMP GROUP BY DEPTNO; -- (2) �μ��� ��� �޿� 

SELECT ENAME, SAL, E.DEPTNO, S.AVGSAL -- (1) + (2) 
    FROM EMP E, (SELECT DEPTNO, ROUND(AVG(SAL)) AVGSAL  -- INLINE VIEW (2) 
                    FROM EMP GROUP BY DEPTNO) S
    WHERE E.DEPTNO = S.DEPTNO 
      AND SAL > AVGSAL;

-- EX. �̸�, �޿�, �μ���ȣ, �ش� ����� �μ� ���(�μ� ��պ��� ���� �޴� ������)
SELECT ENAME, SAL, E.DEPTNO, ROUND(AVGSAL)
    FROM EMP E, (SELECT DEPTNO, AVG(SAL) AVGSAL 
                    FROM EMP GROUP BY DEPTNO) S
    WHERE E.DEPTNO = S.DEPTNO 
      AND SAL > AVGSAL;

-- 3. TOP-N ���� (TOP 1~10��, TOP 11~20��, TOP 6~10��...)
-- ROUNUM: ���̺��� ������ ����. ���̺� ���� ������ ����
--    EX. 
SELECT ROWNUM, ENAME, SAL 
    FROM EMP;
SELECT ROWNUM, ENAME, SAL 
    FROM EMP 
    ORDER BY SAL;
SELECT ROWNUM, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL);
SELECT ROWNUM, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL)
    WHERE ROWNUM < 6;
SELECT ROWNUM, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL)
    WHERE ROWNUM BETWEEN 6 AND 10; -- 1���� �ƴ� ������ ����� ��� ��µ��� �ʴ´�.
    
-- �Լ��� �̿��� RANK ��� 
SELECT RANK() OVER(ORDER BY SAL) RANK,
       DENSE_RANK() OVER (ORDER BY SAL) D_RANK,
       ROW_NUMBER() OVER (ORDER BY SAL) N_RANK,
       ENAME, SAL
    FROM EMP;

-- TOP-N ���� 
SELECT ROWNUM, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL)
    WHERE ROWNUM BETWEEN 1 AND 5; -- 6~10���� ��µ��� �ʴ´�.
    
SELECT ROWNUM, RN, ENAME, SAL 
    FROM (SELECT ROWNUM RN, ENAME, SAL 
                FROM (SELECT * FROM EMP ORDER BY SAL))
    WHERE RN BETWEEN 6 AND 10;

SELECT ENAME, EMPNO, JOB, MGR, HIREDATE
    FROM (SELECT ROWNUM RN, ENAME, EMPNO, JOB, MGR, HIREDATE
            FROM (SELECT * FROM EMP ORDER BY ENAME))
    WHERE RN BETWEEN 6 AND 10;

-- <�� ��������>

-- 1. �μ���� ������� ����ϴ� �뵵�� ��, DNAME_ENAME_VU �� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW DNAME_ENAME_VU 
    AS SELECT DNAME, ENAME 
        FROM EMP E, DEPT D
        WHERE E.DEPTNO = D.DEPTNO;

SELECT * FROM DNAME_ENAME_VU;

-- 2. ������ ���ӻ������ ����ϴ� �뵵�� ��,  WORKER_MANAGER_VU�� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW WORKER_MANAGER_VU (WORKER, MANAGER)
    AS SELECT W.ENAME, M.ENAME 
        FROM EMP W, EMP M
        WHERE W.MGR = M.EMPNO;

SELECT * FROM WORKER_MANAGER_VU;

-- 3. �μ��� �޿��հ� ����� ����Ͻÿ�(�μ���ȣ, �޿��հ�, ���) ? ģ������
SELECT ROWNUM "RANK", DEPTNO, SUMSAL
    FROM (SELECT DEPTNO, SUM(SAL) SUMSAL FROM EMP 
            GROUP BY DEPTNO ORDER BY SUM(SAL) DESC);
 
-- 3-1. �μ��� �޿��հ� ����� 2~3���� �μ���ȣ, �޿��հ�, ����� ����Ͻÿ�.
SELECT RN, DEPTNO, SUMSAL
    FROM (SELECT ROWNUM RN, DEPTNO, SUMSAL 
            FROM(SELECT DEPTNO, SUM(SAL) SUMSAL FROM EMP
                    GROUP BY DEPTNO ORDER BY SUM(SAL) DESC))
    WHERE RN BETWEEN 2 AND 3;

-- 4. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� ������ �����Ͻÿ�

SELECT EMPNO, ENAME, HIREDATE 
    FROM EMP
    ORDER BY HIREDATE DESC;
    
-- 5. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� 5���� ����Ͻÿ�
SELECT EMPNO, ENAME, HIREDATE 
    FROM (SELECT EMPNO, ENAME, HIREDATE 
            FROM EMP
            ORDER BY HIREDATE DESC)
    WHERE ROWNUM <=5; 

-- 6. ��� ���̺��� ���, �����, �Ի����� �ֽź��� ������ ������ 6��°�� ���� ������� 10��° ������� ���
SELECT RN, EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM RN, EMPNO, ENAME, HIREDATE 
            FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC))
    WHERE RN BETWEEN 6 AND 10;

