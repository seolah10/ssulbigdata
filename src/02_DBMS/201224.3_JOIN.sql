-- [III] JOIN : ���̺��� 2�� �̻� �����Ͽ� �˻�
SELECT * FROM EMP 
    WHERE ENAME = 'SCOTT'; -- �μ���ȣ(DEPNO):20
SELECT * FROM DEPT; 
-- (1) CROSS JOIN(FROM���� ���̺� 2�� �̻�) �ܼ��� ��ġ�� ��...
SELECT * FROM EMP, DEPT 
    WHERE ENAME = 'SCOTT';


-- (2) �� EQUI JOIN (���� �ʵ��� DEPTNO���� ��ġ�Ǵ� ���Ǹ� JOIN)
SELECT * FROM EMP, DEPT
    WHERE ENAME = 'SCOTT' AND EMP.DEPTNO = DEPT.DEPTNO; -- ���� ����
SELECT * FROM EMP, DEPT 
    WHERE EMP.DEPTNO = DEPT.DEPTNO;

-- ��� ����� �̸�, �μ���, �μ���ȣ
SELECT ENAME, DNAME, E.DEPTNO 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = E.DEPTNO;
SELECT E.*, ENAME, LOC 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = E.DEPTNO;
-- ���, �̸�, �μ���ȣ, �μ��̸�, �ٹ���
SELECT EMPNO, ENAME, E.DEPTNO, DNAME, LOC 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = E.DEPTNO;
-- �޿� 2000�̻��� ������ �̸�, ����, �޿�, �μ��� �ٹ��� �ʵ� ���
SELECT ENAME, JOB, SAL, DNAME, LOC 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL >= 2000;
-- LOC�� CHICAGO�� ����� �̸�, ����, �μ���, �ٹ��� �ʵ� ���
SELECT ENAME, JOB, DNAME, LOC 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = E.DEPTNO AND LOC = 'CHICAGO';
-- �μ���ȣ�� 10 �Ǵ� 20�� ����� �̸�, ���� �ٹ��� ���(�޿��� ����)
SELECT ENAME, JOB, LOC 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = E.DEPTNO AND D.DEPTNO IN (10,20)
    ORDER BY SAL;
-- �̸�, �޿�, ��(COMM), ����((�޿�+COMM)*12), �μ���, �ٹ���
SELECT ENAME, SAL, COMM, (SAL+NVL(COMM,0))*12 ����, DNAME, LOC 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = E.DEPTNO;
-- ������ JOB�� salesman �Ǵ� manager�� ����� (������ ū�� ����)
SELECT ENAME, SAL, COMM, (SAL+NVL(COMM,0))*12 ����, DNAME, LOC 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = E.DEPTNO AND JOB IN ('SALESMAN', 'MANAGER')
    ORDER BY ���� DESC;
SELECT ENAME, SAL, COMM, (SAL+NVL(COMM,0))*12 ����, DNAME, LOC FROM 
    EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND UPPER(JOB) IN ('SALESMAN','MANAGER') -- UPPER: �빮�� 
    ORDER BY ���� DESC;
-- COMM�� NULL�̰� �޿��� 1200�̻��� ����� 
--    �̸�, �޿�, �Ի���, �μ���ȣ, �μ���(�μ����, �޿�ū�� ����)
SELECT ENAME, SAL, HIREDATE, E.DEPTNO, DNAME 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND COMM IS NULL AND SAL >= 1200
    ORDER BY DNAME, SAL DESC;
    
-- <��Ʈ ���� ����>
-- ���忡�� �ٹ��ϴ� ����� �̸��� �޿��� ����Ͻÿ�
SELECT ENAME, SAL 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND LOC = 'NEW YORK';
-- ACCOUTING �μ� �Ҽ� ����� �̸��� �Ի����� ����Ͻÿ�
SELECT ENAME, HIREDATE 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND DNAME = 'ACCOUNTING';
-- ������ MANAGER�� ����� �̸�, �μ����� ����Ͻÿ�
SELECT ENAME, DNAME 
    FROM EMP E , DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND JOB = 'MANAGER';
-- COMM�� NULL�� �ƴ� ����� �̸�, �޿�, �μ��ڵ�, �ٹ����� ����Ͻÿ�
SELECT ENAME, SAL, E.DEPTNO, LOC 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND COMM IS NOT NULL;

-- (3) �� NON-EQUI JOIN
-- SCOTT�� �޿� ����� �˾ƺ���.
SELECT ENAME, SAL 
    FROM EMP 
    WHERE ENAME = 'SCOTT';
SELECT * FROM SALGRADE; -- �޿���� �ҷ�����
SELECT ENAME, SAL, GRADE 
    FROM EMP, SALGRADE
    WHERE ENAME = 'SCOTT' 
        AND SAL BETWEEN LOSAL AND HISAL;
-- ��� ����� ���, �̸�, JOB, �����, �޿�, �޿����(1���, 2���)..
SELECT EMPNO, ENAME, JOB, MGR, SAL, GRADE || '���' 
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL;

-- <��Ʈ ���� ����>
--Comm�� null�� �ƴ� ����� �̸�, �޿�, ���, �μ���ȣ, �μ��̸�, �ٹ���
SELECT ENAME, SAL, GRADE, E.DEPTNO, DNAME, LOC 
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO 
        AND SAL BETWEEN LOSAL AND HISAL 
        AND COMM IS NOT NULL;
-- �̸�, �޿�, �Ի���, �޿����
SELECT ENAME, SAL, HIREDATE, GRADE 
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL;
-- �̸�, �޿�, �Ի���, �޿����, �μ���, �ٹ���
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME, LOC 
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO 
        AND SAL BETWEEN LOSAL AND HISAL;
-- �̸�, �޿�, ���, �μ��ڵ�, �ٹ���. �� COMM�� NULL�� �ƴ� ���
SELECT ENAME, SAL, GRADE, E.DEPTNO, LOC 
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO 
        AND SAL BETWEEN LOSAL AND HISAL 
        AND COMM IS NOT NULL;
-- �̸�, �޿�, �޿����, ����, �μ���, �μ��� ����, �μ��� ������ ������.
--                                          ����=(sal+comm)*12 comm�� null�̸� 0
SELECT ENAME, SAL, GRADE, (SAL+NVL(COMM,0))*12 ����, DNAME 
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO 
        AND SAL BETWEEN LOSAL AND HISAL  
    ORDER BY DNAME, ����;
-- �̸�, ����, �޿�, ���, �μ��ڵ�, �μ��� ���. 
--          �޿��� 1000~3000����.
--          �������� : �μ���, �μ������� ������, ���������� �޿� ū��
SELECT ENAME, JOB, SAL, GRADE, E.DEPTNO, DNAME 
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO 
        AND SAL BETWEEN LOSAL AND HISAL 
        AND SAL>=1000 AND SAL<=3000
    ORDER BY DNAME, JOB, SAL DESC;
-- �̸�, �޿�, ���, �Ի���, �ٹ���. 81�⿡ �Ի��� ���. ��� ū��
SELECT ENAME, SAL, GRADE, HIREDATE, LOC 
    FROM EMP E, DEPT D, SALGRADE 
    WHERE E.DEPTNO = D.DEPTNO 
        AND SAL BETWEEN LOSAL AND HISAL 
        AND HIREDATE LIKE '81/%'
    ORDER BY GRADE DESC;
SELECT ENAME, SAL, GRADE, HIREDATE, LOC 
    FROM EMP E, DEPT D, SALGRADE 
    WHERE E.DEPTNO = D.DEPTNO 
        AND SAL BETWEEN LOSAL AND HISAL 
        AND TO_CHAR(HIREDATE, 'YY') = '81'
    ORDER BY GRADE DESC;


-- (4) �� SELF JOIN
SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME MANAGERNAME 
    FROM EMP W, EMP M
    WHERE W.ENAME = 'SMITH' 
        AND W.MGR = M.EMPNO;
SELECT WORKER.EMPNO, WORKER.ENAME, MANAGER.ENAME
    FROM EMP WORKER, EMP MANAGER
    WHERE WORKER.MGR=MANAGER.EMPNO;--EMPNO�� NULL���� �����Ƿ� 13��
-- "SMITH�� ���� FORD��" ���
SELECT W.ENAME || '�� ���� ' || M.ENAME || '��.' 
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;

-- <��Ʈ ���� ����>
-- ex1. ����� �̸��� 'KING'�� ������� �̸��� JOB ���--self
SELECT W.ENAME, W.JOB 
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO 
        AND M.ENAME = 'KING';
--�١� ex2. SCOTT�� ������ �μ���ȣ���� �ٹ��ϴ� ����� �̸� ���--self
                                -- SMITH, JONES, ADAMS, FORD  
SELECT E1.ENAME, E1.DEPTNO, E2.ENAME, E2.DEPTNO 
    FROM EMP E1, EMP E2
    WHERE E1.ENAME = 'SCOTT' 
        AND E1.DEPTNO = E2.DEPTNO AND E2.ENAME!= 'SCOTT'; 
SELECT E2.ENAME 
    FROM EMP E1, EMP E2
    WHERE E1.ENAME = 'SCOTT' 
        AND E1.DEPTNO = E2.DEPTNO 
        AND E2.ENAME!= 'SCOTT';    
-- �١� ex3. SCOTT�� ������ �ٹ������� �ٹ��ϴ� ����� �̸� ���--self,equi
SELECT E1.ENAME, D1.LOC 
    FROM EMP E1, DEPT D1
    WHERE E1.DEPTNO = D1.DEPTNO 
        AND E1.ENAME = 'SCOTT'; -- 1. SCOTT�� �μ� ���
SELECT E2.ENAME, D2.LOC 
    FROM EMP E2, DEPT D2
    WHERE E2.DEPTNO = D2.DEPTNO;    -- 2. ��� ����� �̸��� �ٹ��� ���
SELECT E2.ENAME 
    FROM EMP E1, DEPT D1, EMP E2, DEPT D2
     WHERE E1.DEPTNO = D1.DEPTNO 
        AND E1.ENAME = 'SCOTT' 
        AND E2.DEPTNO=D2.DEPTNO 
        AND D1.LOC=D2.LOC 
        AND E2.ENAME <> 'SCOTT';

ROLLBACK;
------------------------------

-- (5)�� OUTER JOIN; ���� ���ǿ� �������� ���� ����� ��Ÿ������ ��
-- ���, �����, ����� ���� ����ϱ� 
SELECT W.EMPNO, W.ENAME, M.ENAME 
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+); -- ��簡 ����(NULL��) ����鵵 ����ϱ� ���� ���� �ʵ忡(+)�߰�
SELECT W.ENAME, NVL(M.ENAME,'-CEO-') 
    FROM EMP W, EMP M -- ��簡 ���� ����� NULL ����
    WHERE W.MGR = M.EMPNO(+);

SELECT W.EMPNO ���, W.ENAME, M.ENAME 
    FROM EMP W, EMP M
    WHERE W.MGR(+) = M.EMPNO 
        AND W.EMPNO IS NULL; -- ���ܻ��

SELECT * FROM EMP; -- 15��
SELECT * FROM DEPT; -- 5��(10,20,30,40,50)
SELECT * FROM EMP E, DEPT D
    WHERE E.DEPTNO(+) = D.DEPTNO;
-- SMITH�� �Ŵ����� FORD�Դϴ� / KING�� �Ŵ����� ���Դϴ�.
SELECT W.ENAME || '�� �Ŵ����� ' || NVL(M.ENAME,'��') || '�Դϴ�'
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);
SELECT * FROM EMP;
-- �� <��������> PART1
--1. �̸�, ���ӻ��
SELECT W.ENAME, M.ENAME 
    FROM EMP W, EMP M 
    WHERE W.MGR = M.EMPNO;
--2. �̸�, �޿�, ����, ���ӻ��
SELECT W.ENAME, W.SAL, W.JOB, M.ENAME MANAGER 
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;
--3. �̸�, �޿�, ����, ���ӻ��. (��簡 ���� �������� ��ü ���� �� ���.
    --��簡 ���� �� '����'���� ���)
SELECT W.ENAME, W.SAL, W.JOB, NVL(M.ENAME,'����') MANAGER 
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO (+);
--4. �̸�, �޿�, �μ���, ���ӻ���
SELECT W.ENAME, W.SAL, DNAME, M.ENAME 
    FROM EMP W, EMP M, DEPT D
    WHERE W.MGR = M.EMPNO 
        AND W.DEPTNO = D. DEPTNO;
--5. �̸�, �޿�, �μ��ڵ�, �μ���, �ٹ���, ���ӻ���, (��簡 ���� �������� ��ü ���� �� ���)
SELECT W.ENAME, W.SAL, W.DEPTNO, DNAME, LOC, NVL(M.ENAME,'����') ���ӻ�� 
    FROM EMP W, EMP M, DEPT D
    WHERE W.MGR = M.EMPNO(+) 
        AND W.DEPTNO = D. DEPTNO;
--6. �̸�, �޿�, ���, �μ���, ���ӻ���. �޿��� 2000�̻��� ���
SELECT W.ENAME, W.SAL, GRADE, DNAME, M.ENAME MANAGER 
    FROM EMP W, EMP M, DEPT D, SALGRADE
    WHERE W.MGR = M.EMPNO 
        AND W.DEPTNO = D.DEPTNO 
        AND W.SAL BETWEEN LOSAL AND HISAL 
        AND W.SAL >= 2000;
--7. �̸�, �޿�, ���, �μ���, ���ӻ���, (���ӻ�簡 ���� �������� ��ü���� �μ��� �� ����)
SELECT W.ENAME, W.SAL, GRADE, DNAME, M.ENAME MANAGER 
    FROM EMP W, EMP M, DEPT D, SALGRADE
    WHERE W.MGR = M.EMPNO(+) 
        AND W.DEPTNO = D.DEPTNO 
        AND W.SAL BETWEEN LOSAL AND HISAL
    ORDER BY DNAME;
--8. �̸�, �޿�, ���, �μ���, ����, ���ӻ���. ����=(�޿�+comm)*12 �� comm�� null�̸� 0
SELECT W.ENAME, W.SAL, GRADE, DNAME, W.SAL+NVL(W.COMM,0)*12 ����, M.ENAME MANAGER 
    FROM EMP W, EMP M, DEPT D, SALGRADE
    WHERE W.MGR = M.EMPNO(+) 
        AND W.DEPTNO = D. DEPTNO 
        AND W.SAL BETWEEN LOSAL AND HISAL;
--9. 8���� �μ��� �� �μ��� ������ �޿��� ū �� ����
SELECT W.ENAME, W.SAL, GRADE, DNAME, W.SAL+NVL(W.COMM,0)*12 ����, M.ENAME MANAGER 
    FROM EMP W, EMP M, DEPT D, SALGRADE
    WHERE W.MGR = M.EMPNO 
        AND W.DEPTNO = D.DEPTNO 
        AND W.SAL BETWEEN LOSAL AND HISAL
    ORDER BY DNAME, W.SAL DESC;
    
--  PART2
--1.EMP ���̺��� ��� ����� ���� �̸�,�μ���ȣ,�μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT ENAME, E.DEPTNO, DNAME 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO;
--2. EMP ���̺��� NEW YORK���� �ٹ��ϰ� �ִ� ����� ���Ͽ� �̸�,����,�޿�,�μ����� ���
SELECT ENAME, JOB, SAL, DNAME 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO   
        AND LOC = 'NEW YORK';
--3. EMP ���̺��� ���ʽ��� �޴� ����� ���Ͽ� �̸�,�μ���,��ġ�� ���
SELECT ENAME, DNAME, LOC 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO 
    AND COMM IS NOT NULL AND COMM != 0;
--4. EMP ���̺��� �̸� �� L�ڰ� �ִ� ����� ���Ͽ� �̸�,����,�μ���,��ġ�� ���
SELECT ENAME, JOB, DNAME, LOC 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO 
        AND ENAME LIKE '%L%';
--5. ���, �����, �μ��ڵ�, �μ����� �˻��϶�. ������������ ������������
SELECT EMPNO, ENAME, E.DEPTNO, DNAME 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO 
    ORDER BY ENAME;
--6. ���, �����, �޿�, �μ����� �˻��϶�. 
    --�� �޿��� 2000�̻��� ����� ���Ͽ� �޿��� �������� ������������ �����Ͻÿ�
SELECT EMPNO, ENAME, SAL, ENAME 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO 
        AND SAL >= 2000
    ORDER BY SAL DESC;
--7. ���, �����, ����, �޿�, �μ����� �˻��Ͻÿ�. �� ������ MANAGER�̸� �޿��� 2500�̻���
-- ����� ���Ͽ� ����� �������� ������������ �����Ͻÿ�.
SELECT EMPNO, ENAME, JOB, SAL, DNAME 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO 
        AND JOB = 'MANAGER' 
        AND SAL >= 2500
    ORDER BY EMPNO;
--8. ���, �����, ����, �޿�, ����� �˻��Ͻÿ�. ��, �޿����� ������������ �����Ͻÿ�
SELECT EMPNO, ENAME, JOB, SAL, GRADE 
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
    ORDER BY SAL DESC;
--9. ������̺��� �����, ����� ��縦 �˻��Ͻÿ�(��簡 ���� �������� ��ü)
SELECT W.ENAME WORKER, M.ENAME MANAGER  
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);
--10. �����, ����, ����� ������ �˻��Ͻÿ�
SELECT W.ENAME WORKER, M.ENAME MANAGER, MM.ENAME SUPERMANAGER 
    FROM EMP W, EMP M, EMP MM
    WHERE W.MGR = M.EMPNO 
        AND M.MGR = MM.EMPNO;
--11. ���� ������� ���� ��簡 ���� ��� ������ �̸��� ��µǵ��� �����Ͻÿ�
SELECT W.ENAME, NVL(M.ENAME,'') MANAGER, NVL(MM.ENAME,'') SUPERMANAGER 
    FROM EMP W, EMP M, EMP MM
    WHERE W.MGR = M.EMPNO(+) 
        AND M.MGR = MM.EMPNO(+);



