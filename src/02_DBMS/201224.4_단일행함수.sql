-- [IV] �������Լ�
-- �Լ� = �������Լ� + �׷��Լ�
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YY"��"MM"��"DD"��"') 
    FROM EMP; -- Ư�����ڰ� �ƴ� ���ڴ� �ݵ�� ""���̿� �Է�
SELECT ENAME, INITCAP(ENAME) 
    FROM EMP; -- ININTCAP(); ù���ڸ� �빮�ڷ� 
SELECT SUM(SAL) 
    FROM EMP; -- �׷��Լ�, SUM(); �հ�
SELECT DEPTNO, SUM(SAL) 
    FROM EMP 
    GROUP BY DEPTNO; -- �׷��Լ� (�μ���ȣ �׷� ���� �޿� �հ� ����ϱ�)
-- EX. �����Լ�, �����Լ�, ��¥�Լ�, ����ȯ�Լ�, NVL(). etc... 

-- (1) �����Լ�
DESC DUAL; -- ����Ŭ���� �����ϴ� 1�� 1��¥�� DUMMY TABLE
SELECT ABS(-9) 
    FROM DUAL; -- ���밪
SELECT FLOOR(34.5678) 
    FROM DUAL; -- �Ҽ������� ���� 
SELECT FLOOR(34.5678*10)/10 
    FROM DUAL; -- �Ҽ��� ���ڸ����� ���� (JAVA���� �ߴ� ���)
SELECT TRUNC(34.5678) 
    FROM DUAL; -- �Ҽ������� ���� 
SELECT TRUNC(34.5678,1) 
    FROM DUAL; -- �Ҽ��� ���ڸ����� ���� 
SELECT TRUNC(34.5678,-1) 
    FROM DUAL; -- ���� �ڸ����� ����
-- ex) EMP���̺��� �̸�, �޿� ���(�޿��� ���� �ڸ����� ����)
SELECT ENAME, TRUNC(SAL,-2) SAL 
    FROM EMP;

SELECT CEIL(34.5678) 
    FROM DUAL; -- �Ҽ������� �ø�
SELECT ROUND(34.5678) 
    FROM DUAL; -- �Ҽ������� �ݿø�
SELECT ROUND(34.5678,1) 
    FROM DUAL; -- �Ҽ��� ���ڸ����� �ݿø�
SELECT ROUND(34.5678,-1) 
    FROM DUAL; -- �����ڸ����� �ݿø�
SELECT FLOOR(10/4) 
    FROM DUAL; -- ���� ��(2.5)���� �Ҽ������� ������ ���

SELECT MOD(9,2)    
    FROM DUAL; -- MOD(); ������ ����
SELECT MOD('9',2) 
    FROM DUAL;
-- ex) Ȧ�� �޿� �Ի��� �������� ��� �ʵ带 ���
SELECT * FROM EMP 
    WHERE MOD(TO_CHAR(HIREDATE, 'MM'),2) = 1; 


-- (2) ���� �Լ� 
-- 1) ���� ��ȯ
SELECT UPPER('abcABC') 
    FROM DUAL; -- �빮�ڷ� ��ȯ
SELECT LOWER('abcABC') 
    FROM DUAL; -- �ҹ��ڷ� ��ȯ 
SELECT INITCAP('abcABC') 
    FROM DUAL; -- ù���ڸ� �빮��, �������� �ҹ��ڷ� ��ȯ
-- ex) JOB�� MANAGER�� ������ ��� �ʵ�
SELECT * FROM EMP 
    WHERE UPPER(JOB) = 'MANAGER';
-- ex) ���, ������� ����ϵ�, ������� �̸��� ù���ڸ� �빮�ڰ� �ǵ��� ���
SELECT EMPNO, INITCAP(ENAME) 
    FROM EMP;

-- 2) ���� ����
SELECT 'AB' || 'CD' || 'EF' || 'GH' 
    FROM DUAL; --  ���Ῥ���� || ��� 
SELECT CONCAT(CONCAT('AB','CD'), CONCAT('EF','GH')) 
    FROM DUAL; -- CONCAT �Լ� ��� 
      -- CONCAT�� �� ���ھ��� ���� �����ϹǷ�, �� �̻��� �����ϰ� ���� �� �� ���ھ� ���� �� �� �׷�ȭ�ؾ� �Ѵ�.
-- ex) 'ENAME�� JOB�̴�.' ���� ����ϱ�
SELECT  ENAME || '�� ' || JOB || '�̴�.' 
    FROM EMP; --  ���Ῥ���� || ��� 
SELECT CONCAT(CONCAT(ENAME,'�� '), CONCAT(JOB,'�̴�.')) 
    FROM EMP; -- CONCAT�Լ� ���

-- 3) SUBSTR(STR, ������ġ, ���ڰ���) - ù ��ġ�� 1 / SUBSTRB(STR, ������ġ, ���ڹ���Ʈ��)
SELECT SUBSTR('WELCOM TO ORACLE', 3, 2) 
    FROM DUAL; --3��° ��ġ���� ���� 2�� 
SELECT SUBSTRB('WELCOM TO ORACLE', 3, 2) 
    FROM DUAL; --3��° BYTE���� 2BYTE
SELECT SUBSTR('�����ͺ��̽�', 4, 3) 
    FROM DUAL; -- 4��° ��ġ���� ���� 3��
SELECT SUBSTRB('�����ͺ��̽�', 4, 3) 
    FROM DUAL; -- 4��° BYTE���� 3BYTE
        -- ����� �� ���ڰ� 1BYTE, �ѱ��� �� ���ڰ� 3BYTE�� ����� �ٸ���.
-- ex) 9���� �Ի��� ����� ��� �ʵ� (81/01/01)
SELECT * FROM EMP 
    WHERE SUBSTR(HIREDATE, 4, 2) = '09'; -- ��¥�� 4��° ��ġ���� �� ���ڰ� '09' 
-- ex) �ش� ��ȭ��ȣ�� ���ڸ� 4�ڸ��� ����ϱ�
SELECT SUBSTR('02-716-9999', -4, 4) 
    FROM DUAL; -- ��ġ�� ������ ���, �ں��� ����. 

-- 4) LENGTH(); ���� �� / LENGHB(); ���� ����Ʈ ��
SELECT LENGTH('ABCD') 
    FROM DUAL;
SELECT LENGTHB('ABCD') 
    FROM DUAL;
SELECT LENGTH('����Ŭ') 
    FROM DUAL;
SELECT LENGTHB('����Ŭ') 
    FROM DUAL;

-- 5) INSTR(str, ã������); str���� ã�� ������ ��ġ(ù��°1), ������ 0 ���(JAVA������ -1�̾���)
SELECT INSTR('ABCABC', 'B') 
    FROM DUAL; -- ���ڰ� �ߺ��� ���, ���� ������ ������ ��ġ�� �����
SELECT INSTR('ABCABC', 'B', 3) 
    FROM DUAL; -- INSTR(str, ã������, ������ġ); - 3��° �ڿ� �ִ� 'B'�� ��ġ�� ã�´�.
-- ex) 9���� �Ի��� ����� INSTR�Լ��� �̿��Ͽ� ����ϱ� (81/12/09)
SELECT * FROM EMP 
    WHERE INSTR(HIREDATE, '09') = 4; -- ��¥���� ���� '09'�� 4�� ��ġ�� �;� �Ѵ�.
-- ex) 9�Ͽ� �Ի��� ����� INSTR�Լ��� �̿��Ͽ� ����ϱ� (81/12/09)
SELECT * FROM EMP 
    WHERE INSTR(HIREDATE, '09') = 7;

-- 6) LPAD(����, �ڸ���, '*'); ���ڸ� �ڸ�����ŭ Ȯ�� �ϰ� ���� ���ڸ��� *�� ä���.
--    RPAD(����, �ڸ���, '*'); ���ڸ� �ڸ�����ŭ Ȯ�� �ϰ� ������ ���ڸ��� *�� ä���.
SELECT LPAD('ORACLE', 20, '#') 
    FROM DUAL; -- ORACLE�� ������ ORCLE�����Ͽ� 20�ڸ��� �ǵ��� #�� ä���.
SELECT RPAD('ORACLE', 20, '#') 
    FROM DUAL; 
-- ex) ������ �޿� ��� (�޿��� �� 6�ڸ��� �ǵ��� ���� �տ� *�� ä���� ����Ѵ�.)
SELECT ENAME, LPAD(SAL, 6, '*') 
    FROM EMP;
-- ex) ���, �����(������� S****�������� ���)
SELECT EMPNO, RPAD(SUBSTR(ENAME, 1, 1), LENGTH(ENAME), '*')  NAME 
    FROM EMP;
-- ex) ���, �����(S****), �Ի���(80/12/**) ��� 
SELECT EMPNO, RPAD(SUBSTR(ENAME, 1, 1), LENGTH(ENAME), '*'), 
              RPAD(SUBSTR(HIREDATE,1,6), LENGTH(HIREDATE),'*') 
    FROM EMP;
-- ex) ���, �����(****H), �Ի���(80/12/**) ���
SELECT EMPNO, LPAD(SUBSTR(ENAME,-1,1), LENGTH(ENAME), '*'),
              RPAD(SUBSTR(HIREDATE, 1, 6), LENGTH(HIREDATE), '*') 
    FROM EMP;
-- ex) �̸��� ����° �ڸ��� R�� ����� ��� �ʵ� ���
SELECT * FROM EMP 
    WHERE ENAME LIKE '__R%'; -- LIKE ������ 
SELECT * FROM EMP 
    WHERE SUBSTR(ENAME, 3, 1) = 'R'; -- SUBSTR �Լ�
SELECT * FROM EMP 
    WHERE INSTR(ENAME, 'R') = 3; -- INSTR �Լ�

-- 7) TRIM(); �� ���� SPACE���� 
SELECT TRIM('     ORACLE DB     ') 
    FROM DUAL;
SELECT LTRIM('     ORACLE DB     ') 
    FROM DUAL; -- ���� SPACE ����
SELECT RTRIM('     ORACLE DB     ') 
    FROM DUAL; -- ������ SPACE ����

-- 8) REPLACE(����, �ٲܹ���, ��ü�ҹ���) 
-- ex) ������� �̸��� A�� X�� �����Ͽ� ����Ѵ�.
SELECT REPLACE(ENAME, 'A', 'X') 
    FROM EMP;


-- (3) ��¥ �����, ��¥ �Լ�
-- 1) SYSDATE 
SELECT SYSDATE FROM DUAL; -- SYSDATE; ���� ��¥ ���
SELECT TO_CHAR(SYSDATE, 'YY-MM-DD HH24:MI:SS"��"') 
    FROM DUAL; -- ���� ��¥�� �ð� ���
SELECT SYSDATE-1 ����, SYSDATE ����, SYSDATE+1 ���� 
    FROM DUAL;
-- ex) �̸�, �Ի���, �ٹ��ϼ� ��� (�ٹ����ڴ� �Ҽ������� ������ ����Ѵ�.) 
SELECT ENAME, HIREDATE, FLOOR(SYSDATE-HIREDATE) �ٹ��ϼ� 
    FROM EMP; 
SELECT ENAME, HIREDATE, TRUNC(SYSDATE-HIREDATE) �ٹ��ϼ� 
    FROM EMP; 
-- ex) �̸�, �Ի���, �ٹ��ּ�, �ٹ���� ���
SELECT ENAME, HIREDATE, FLOOR((SYSDATE-HIREDATE)/7) �ٹ��ּ�,
                        FLOOR((SYSDATE-HIREDATE)/365) �ٹ���� 
    FROM EMP;

-- 2) MONTHS_DATE(�ֱٽ���, ��������), Ư���� �� ���� ������ ���� ��
-- ex) �̸�, �Ի���, �ٹ����� ���
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) 
    FROM EMP; 
                           
-- 3) ADD_MONTH(��¥, �߰� ���� ��)                            
-- ex) �̸�, �Ի���, �����Ⱓ ������(�����Ⱓ�� 6����)
SELECT ENAME HIREDATE, ADD_MONTHS(HIREDATE, 6) "�����Ⱓ ������" 
    FROM EMP;
                           
-- 4) NEXT_DAY(Ư����¥, '��'); Ư����¥�κ��� ó�� ���ƿ��� ������
--    LAST_DAY(Ư����¥); Ư�� ��¥�� �ش��ϴ� ���� ����
-- ex) ���ƿ��� ������� �������� ����ϱ�
SELECT NEXT_DAY(SYSDATE, '��') 
    FROM DUAL;
-- ex) �̸�, �Ի���, ���޳�(���޳��� �����̴�.)
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) ���޳� FROM EMP;

-- 5) ROUND; ��¥ �ݿø� / TRUNC; ��¥ ����
SELECT ROUND(SYSDATE, 'YEAR') 
    FROM DUAL; -- <�� �ݿø�>: �� �������� ����� 1�� 1�� 
SELECT ROUND(SYSDATE, 'MONTH') 
    FROM DUAL; -- <�� �ݿø�>: �� �������� ����� 1���� �� 
SELECT ROUND(SYSDATE, 'DAY') 
    FROM DUAL; -- <�� �ݿø�>: �� �������� ����� �Ͽ����� ��¥
SELECT ROUND(SYSDATE) 
    FROM DUAL; -- <�ð� �ݿø�> �� �������� ����� 0�ÿ� �ش��ϴ� ��¥ 

SELECT TRUNC(SYSDATE, 'YEAR') 
    FROM DUAL; -- <�� ����>: ���� 1�� 1��
SELECT TRUNC(SYSDATE, 'MONTH') 
    FROM DUAL; -- <�� ����>: ���� 1��
SELECT TRUNC(SYSDATE, 'DAY') 
    FROM DUAL; -- <�� ����>: ���� �Ͽ��Ͽ� �ش��ϴ� ��¥
SELECT TRUNC(SYSDATE) 
    FROM DUAL; -- <�ð� ����>: ���� 0�ÿ� �ش��ϴ� ��¥

-- ex) �̸�, �Ի���, �Ի��Ͽ� �ش��ϴ� ���� 1�� 
SELECT ENAME, HIREDATE, TRUNC(HIREDATE, 'MONTH') 
    FROM EMP;
-- ex) �̸�, �Ի���, ���޳�(25��)
SELECT ENAME, HIREDATE, ROUND(HIREDATE-9, 'MONTH')+24 "���޳�" 
    FROM EMP;
-- ex) �̸�, �Ի���, ���޳�(17��)
SELECT ENAME, HIREDATE, ROUND(HIREDATE-1, 'MONTH')+16 "���޳�" 
    FROM EMP; 
-- ex) �̸�, �Ի���, SAL(����), �̶����� ���� ������
SELECT ENAME, HIREDATE SAL, SAL*TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) 
    FROM EMP;
-- ex) �̸�, �Ի��� SAL, COMM, �̶����� ���� ����(SAL*12+COMM)�� ��
SELECT ENAME, HIREDATE, SAL, COMM,
    SAL*TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE))+NVL(COMM,0) * TRUNC((SYSDATE-HIREDATE)/365)
    FROM EMP;


-- (4) ����ȯ�Լ� 
-- 1) TO_CHAR(��¥, ����); ��¥���� ���Ͽ� �°� ���������� ��ȯ 
     -- YY(�⵵) MM(��) MON(���̸�) DD(��) DY(����)
     -- HH24(0~23��) AM(����/����) HH(0~11��) MI(��) SS(��)
-- ex. ���� ��¥�� �ð� ����ϱ� 
SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY"��" DD"��" MM"��" DY"����"')  
    FROM EMP; -- YY,MM,DD ��� �ݵ�� ���ڸ� �̻� ǥ��
SELECT TO_CHAR(SYSDATE, 'YY"��" MON DD"��" AM HH"��" MI"��" SS"��"')
    FROM EMP;

-- TO_CHAR(����, ����) ; ���ڰ��� ���Ͽ� �°� �������� ��ȯ
    -- ���ϳ� 0 ; �ڸ���. �ڸ����� ���� ������ 0���� ä��
    -- ���ϳ� 9 ; �ڸ���. �ڸ����� ���� ������ ä���� ����(�ڹٿ����� #)
    -- ���ϳ� $ ; ��ȭ���� $�� ���ھտ� ����
    -- ���ϳ� L ; ������ȭ������ ���ھտ� ����
SELECT ENAME, TO_CHAR(SAL, 'L999,999') SAL 
    FROM EMP;
SELECT ENAME, TO_CHAR(SAL, '$999,999') SAL 
    FROM EMP;
SELECT ENAME, TO_CHAR(SAL, '$000,000') SAL  
    FROM EMP; -- 0�� ǥ���� ��ŭ �ڸ����� ä���� �Էµȴ�. 
    
-- 2) TO_DATE(����, ����) ; '81/01/01'���ڸ� ���Ͽ� �°� ��¥������ ��ȯ
-- 81/5/1 ~ 83/5/1 ���̿� �Ի��� ���� ���
SELECT * FROM EMP
    WHERE HIREDATE BETWEEN '81/05/01' AND '83/05/01'; -- �츮���� ��¥ �ý��ۿ����� ������ ���
SELECT * FROM EMP
    WHERE HIREDATE BETWEEN TO_DATE('19810501','YYYYMMDD')
                       AND TO_DATE('19830501','YYYYMMDD'); -- �⵵ 4�ڸ�  
-- ex. 2020��11��30�Ϻ��� ������� ��¥���� ���(�ý����� ��¥�� ������ �𸥴ٴ� ���� �Ͽ�)
SELECT SYSDATE - TO_DATE('20201130','YYYYMMDD') 
    FROM DUAL; -- �Ҽ��� ó�� �ʿ�
SELECT ROUND(SYSDATE - TO_DATE('20201130','YYYYMMDD')) 
    FROM DUAL; 
SELECT TRUNC(SYSDATE - TO_DATE('20201130','YYYYMMDD')) 
    FROM DUAL;    
    
-- 3) TO_NUMBER(����, ����);���ڸ� ���Ͽ� �°� ���������� ��ȯ    
SELECT TO_NUMBER('1,000', '9,999') 
    FROM DUAL;    
SELECT TO_NUMBER('1,000', '9,999')*1.1 
    FROM DUAL; -- ������ ���� ����Ѵ�.
    
    
-- (5) NULL�����Լ� ; NVL(���� ���� �ִ� ������, ���̸����� ��)
                     -- �Ű����� 2���� �ݵ�� Ÿ���� ��ġ�ؾ� ��
--ex. ����̸�, ���ӻ���� �̸�(���ӻ�簡 ������ CEO�� ���)
SELECT W.ENAME, NVL(M.ENAME, 'CEO') 
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);
--ex. ����̸�, ���ӻ���� ���(���ӻ�簡 ������ CEO�� ���)
SELECT ENAME, NVL(TO_CHAR(MGR), 'CEO') MGR 
    FROM EMP; -- Ÿ���� ���� �ٸ� MGR�� 'CEO'�� ��ġ�����ش�.
    
    
-- (6) DECODE(������, ��1, ���1, ��2, ���2, ..., ��N, ���N, �׿ܰ��)
-- ex. �̸�, �μ���ȣ, �μ��̸�    
SELECT ENAME, D.DEPTNO, ENAME 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO; -- JOIN ���

SELECT ENAME, DEPTNO, 
       DECODE(DEPTNO, 10, 'ACCOUNTING', 20, 'RESEARCH', 30, 'SALES',
                      40, 'OPERATIONS', 'ETC.') AS "DNAME"
    FROM EMP; -- DECODE ���

SELECT ENAME, DEPTNO,
    CASE WHEN DEPTNO = 10 THEN 'ACCOUNTING'
         WHEN DEPTNO = 20 THEN 'RESEARCH'
         WHEN DEPTNO = 30 THEN 'SALES'
         WHEN DEPTNO = 40 THEN 'OPERATION'
         ELSE 'ETC'
    END AS "DNAME"
    FROM EMP; -- CASE �̿� 
SELECT ENAME, DEPTNO,
    CASE DEPTNO WHEN 10 THEN 'ACCOUNTIN'
                WHEN 20 THEN 'RESEARCH'
                WHEN 30 THEN 'SALES'
                WHEN 40 THEN 'OPERATIONS'
         ELSE 'ETC'
    END AS "DNAME"
    FROM EMP; -- CASE �̿� (�����ʵ尡 �� �����ϸ� ������ ��)    
    
--ex. �̸�, �޿�, �λ����޿�     
    -- JOB�� ���� 'ANALYST' 10%�λ�, 'MANAGER'�� 20%�λ�
            -- 'PRESIDENT'�� 30%�λ� 'SALESMAN'�� 40%�λ�
            -- 'CLERK'�� �λ�����
SELECT ENAME, SAL ���޿�, 
    DECODE(JOB, 'ANALYST', SAL*1.1, 'MANAGER', SAL*1.2, 
                'PRESIDENT', SAL*1.3, 'SALESMAN', SAL*1.4, SAL) �λ�޿�
    FROM EMP; -- DECODE �̿� 
SELECT ENAME ,SAL ���޿�,
    CASE WHEN JOB = 'ANALYST' THEN SAL*1.1 
         WHEN JOB = 'MANAGER' THEN SAL*1.2
         WHEN JOB = 'PRESIDENT' THEN SAL*1.3
         WHEN JOB = 'SALESMAN' THEN SAL*1.4
         ELSE SAL
    END �λ�޿�
    FROM EMP; -- CASE �̿� 
SELECT ENAME, SAL ���޿�,
    CASE JOB WHEN 'ANALYST' THEN SAL*1.1
             WHEN 'MANAGER' THEN SAL*1.2
             WHEN 'PRESIDENT' THEN SAL*1.3
             WHEN 'SALESMAN' THEN SAL*1.4
    ELSE SAL
    END �λ�޿�
    FROM EMP; -- CASE �̿� (�ߺ��ʵ� ������ ����)


-- (7) �� �� �Լ�
-- 1) EXTRACT 
-- ex. ����� �Ի����� �⵵�� / ���� �����ϱ�
SELECT EXTRACT(YEAR FROM HIREDATE) YEAR 
    FROM EMP;
SELECT TO_CHAR(HIREDATE, 'YYYY') YRAR
    FROM EMP;
SELECT EXTRACT(MONTH FROM HIREDATE) MONTH
    FROM EMP;
SELECT TO_CHAR(HIREDATE, 'MM') MONTH 
    FROM EMP;

-- 2) LEVEL, START WITH(�ֻ�������������), CONNECT BY PRIOR(������ ��������)
-- ex. ���� ���赵 ���޺��� ��Ÿ����
SELECT LEVEL, LPAD(' ', LEVEL*2) || ENAME, MGR -- ���޿� ���� ����� �鿩���� 
    FROM EMP
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO = MGR;


--< �� ��������>
-- 1. ���� ��¥�� ����ϰ� TITLE�� ��Current Date���� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT SYSDATE "Current Date" 
    FROM DUAL;

-- 2. EMP ���̺��� ���� �޿��� 15%�� ������ �޿��� ����Ͽ�,
-- �����ȣ,�̸�,����,�޿�,������ �޿�(New Salary),������(Increase)�� ����ϴ� SELECT ����
SELECT EMPNO, ENAME, JOB, SAL, 
       SAL*1.15 "New Salary", SAL*0.15 "Increase" 
    FROM EMP;

--3. �̸�, �Ի���, �Ի��Ϸκ��� 6���� �� ���ƿ��� ������ ���Ͽ� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, HIREDATE, 
       NEXT_DAY(ADD_MONTHS(HIREDATE, 6), '��') "6���� �� ������"
    FROM EMP;
--4. �̸�, �Ի���, �Ի��Ϸκ��� ��������� ������, �޿�, �Ի��Ϻ��� ��������� ���� �޿��� �Ѱ踦 ���
SELECT ENAME, HIREDATE,
       TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) ������, SAL, 
       ROUND(MONTHS_BETWEEN(SYSDATE, HIREDATE)*SAL, 2) �޿��Ѱ�
    FROM EMP;

SELECT ENAME, HIREDATE,
       TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) ������, SAL,
       TO_CHAR(ROUND(MONTHS_BETWEEN(SYSDATE, HIREDATE),2)*SAL,'$9,999,999.99') �޿��Ѱ�
    FROM EMP;
    
--5. ��� ����� �̸��� �޿�(15�ڸ��� ��� ������ �� ���� ��*���� ��ġ)�� ���
SELECT ENAME, LPAD(SAL, 15, '*') 
    FROM EMP;

--6. ��� ����� ������ �̸�,����,�Ի���,�Ի��� ������ ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DAY')
    FROM EMP;

SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DY"����"') 
    FROM EMP;
    
--7. �̸��� ���̰� 6�� �̻��� ����� ������ �̸�,�̸��� ���ڼ�,������ ���
SELECT ENAME, LENGTH(ENAME), JOB 
    FROM EMP
    WHERE LENGTH(ENAME) >= 6;
    
--8. ��� ����� ������ �̸�, ����, �޿�, ���ʽ�, �޿�+���ʽ��� ���
SELECT ENAME, JOB, SAL, COMM, SAL+NVL(COMM,0) 
    FROM EMP;

-- 9.��� ���̺��� ������� 2��° ���ں��� 3���� ���ڸ� �����Ͻÿ�. 
SELECT ENAME, SUBSTR(ENAME, 2, 3) 
    FROM EMP;

--10. ��� ���̺��� �Ի����� 12���� ����� ���, �����, �Ի����� �˻��Ͻÿ�. 
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE HIREDATE LIKE '%/12/%';
    
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE SUBSTR(HIREDATE, 4, 2) = '12';
    
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE INSTR(HIREDATE, '12', 4) = 4; 

SELECT EMPNO, ENAME, HIREDATE
    FROM EMP 
    WHERE EXTRACT(MONTH FROM HIREDATE) = 12; -- ��� ��¥ �ý��ۿ� ���� ���� 
    
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE TO_CHAR(HIREDATE, 'MM') = '12';    -- ��� ��¥ �ý��ۿ� ���� ����
    
--11. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
--EMPNO		ENAME		�޿�
--7369		       SMITH		*******800
--7499		       ALLEN		******1600
--7521		       WARD		******1250
--����. 
SELECT EMPNO, ENAME, LPAD(SAL, 10, '*')
    FROM EMP;
    
-- 12. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
-- EMPNO	 ENAME 	�Ի���
-- 7369	  SMITH		1980-12-17
-- ��.
SELECT EMPNO, ENAME, 
       TO_CHAR(HIREDATE, 'YYYY-MM-DD') �Ի���
    FROM EMP;

--13. ��� ���̺��� �μ� ��ȣ�� 20�� ����� ���, �̸�, ����, �޿��� ����Ͻÿ�.
    --(�޿��� �տ� $�� �����ϰ�3�ڸ����� ,�� ����Ѵ�)
SELECT EMPNO, ENAME, JOB, TO_CHAR(SAL, '$9,999') SAL 
    FROM EMP
    WHERE DEPTNO = 20;

-- 14. ��� ���̺��� �޿��� ���� ���, �̸�, �޿�, ����� �˻��ϴ� SQL ������ �ۼ� �Ͻ� ��.
-- �޿��� 0~1000 E / 1001~2000 D / 2001~3000 C / 3001~4000 B / 4001~5000 A
SELECT EMPNO, ENAME, SAL,
       CASE WHEN SAL BETWEEN 0 AND 1000 THEN 'E'
            WHEN SAL BETWEEN 1001 AND 2000 THEN 'D'
            WHEN SAL BETWEEN 2001 AND 3000 THEN 'C'
            WHEN SAL BETWEEN 3001 AND 4000 THEN 'B'
            WHEN SAL BETWEEN 4001 AND 5000 THEN 'A'
            END ��� 
    FROM EMP;

SELECT EMPNO, ENAME, SAL,
       CASE WHEN SAL >= 0 AND SAL <= 1000 THEN 'E'
            WHEN SAL >= 1001 AND SAL <= 2000 THEN 'D'
            WHEN SAL >= 2001 AND SAL <= 3000 THEN 'C'
            WHEN SAL >= 3001 AND SAL <= 4000 THEN 'B'
            WHEN SAL >= 4001 AND SAL <= 5000 THEN 'A'
            END ��� 
    FROM EMP;

SELECT EMPNO, ENAME, SAL,
       CASE TRUNC((SAL-1)/1000) WHEN 0 THEN 'E'
                                WHEN 1 THEN 'D'
                                WHEN 2 THEN 'C'
                                WHEN 3 THEN 'B'
       ELSE 'A'
       END ���
    FROM EMP;
                                
SELECT EMPNO, ENAME, SAL,
       DECODE(TRUNC((SAL-1)/1000), 0, 'E', 1, 'D', 2, 'C', 
                                   3, 'B', 'A') ��� 
    FROM EMP;

-- 0~999 E / 1000~1999 D / 2000~2999 C / 3000~3999 B / 4000�̻� A
SELECT EMPNO, ENAME, SAL, 
       DECODE(TRUNC(SAL/1000), 0, 'E', 1, 'D', 2, 'C', 3, 'B', 'A') ��� 
    FROM EMP;
    
SELECT EMPNO, ENAME, SAL, CASE TRUNC(SAL/1000) WHEN 0 then 'E' 
                                               WHEN 1 THEN 'D' 
                                               WHEN 2 THEN 'C' 
                                               WHEN 3 THEN 'B'
                          ELSE 'A' END ��� 
   FROM EMP;



