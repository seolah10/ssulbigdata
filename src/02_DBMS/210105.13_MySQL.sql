show tables;
show databases;

-- 계정생성, 권한부여, 권한박탈, 계정삭제(DCL)
create user user10 identified by 'password'; -- 계정 생성
grant all on *.* to user10; -- 권한 부여 
grant all privileges on *.* to user10;
flush privileges;

revoke all on *.* from user10; -- 권한 박탈
revoke all privileges on *.* from user10;

drop user user01; -- 사용자 계정 삭제

-- 데이터베이스로 들어가기 
show databases;
create database park; -- 새로운 park 데이터베이스 생성
use world; -- world 데이터 베이스로 들어감
use park; -- parkdb 데이터 베이스로 들어감

select database(); -- 현재 들어와있는 데이터베이스

-- 테이블 만들기 
create table emp(
	empno 	  numeric(4) 	primary key,
    ename	  varchar(20)   not null,
    nickname  varchar(20)   unique, -- 널 포함 가능, 널 값이 아닐 경우 유일한 값으로 지정
    sal		  numeric(7,2)  check(sal > 0),
    hiredate  datetime		default now(),
    comm 	  numeric(7,2)  default(0) 
	);
select * from emp;
drop table if exists emp;
-- 테이블 삭제 후 다시 만들기 (이번엔 제약 조건을 아래에 입력)
create table emp(
	empno 	  numeric(4), 	
    ename	  varchar(20)   not null,
    nickname  varchar(20),  
    sal		  numeric(7,2),  
    hiredate  datetime		default now(),
    comm 	  numeric(7,2)  default(0), 
    primary key(empno),
    unique(nickname),
    check(sal > 0) 
	);

-- 데이터 추가 
insert into emp (empno, ename, nickname, sal)
	values (1111, 'park', 'snowman', 9000);
select * from emp;
drop table if exists emp;

-- <실습> 학생들의 학과정보 테이블 만들기 
-- 1) 학과 정보, 학생 정보 테이블 생성 
create table major(
	mcode    int 	primary key	   auto_increment, 
							   -- auto_increment설정시 numeric말고 int 사용 
							   -- mySql에는 시퀀스가 없고, auto_increment로 순차번호를 설정한다.
    mname    varchar(20),
    moffice  varchar(30)
); 

create table student(
	sno	   int   primary key,
    sname  varchar(20),
    mcode  int    references major(mcode)
);
select * from student;
-- 2) 데이터 추가
insert into major(mname, moffice) 
	values ('컴퓨터공학', '101호');
insert into major(mname, moffice) 
	values ('경영', '102호');
insert into major(mname, moffice) 
	values ('빅데이터', '103호');
insert into major(mname, moffice) 
	values ('기계공학', '104호');
select * from major;

insert into student 
	values (1111, '김', 1);
insert into student 
	values (1112, '이', 2);
insert into student 
	values (1113, '박', 3);
insert into student 
	values (1114, '최', 4);
insert into student 
	values (1115, '정', 5);
select * from student; -- 입력한 데이터가 모두 들어옴 

-- 3) 두 테이블 모두 삭제 후 다시 만들기
drop table student;
drop table major;

create table major(
	mCode int primary key auto_increment,-- auto_increment일경우 int
    mName varchar(20),
    mOffice varchar(30));

create table student(
	sNo int,
    sName varchar(20),
    mCode int,
    primary key(sNo),
    foreign key(mCode) references major(mCode));

-- 4) 데이터 추가 
insert into major(mname, moffice) 
	values ('컴퓨터공학', '101호');
insert into major(mname, moffice) 
	values ('경영', '102호');
insert into major(mname, moffice) 
	values ('빅데이터', '103호');
insert into major(mname, moffice) 
	values ('기계공학', '104호');
select * from major;

insert into student 
	values (1111, '김', 1);
insert into student 
	values (1112, '이', 2);
insert into student 
	values (1113, '박', 3);
insert into student 
	values (1114, '최', 4);
insert into student 
	values (1115, '정', 5); -- foreign key 제약조건으로 인해 실행 불가 (5번은 없는 전공번호)
select * from student; -- 김, 이, 박, 최 

-- 5) 학번, 이름, 학과명, 학과 번호, 사무실 출력하기 
select sno, sname, m.mcode, mname, moffice
	from student s, major m
    where s.mcode = m.mcode;

select sno, sname, m.mcode, mname, moffice
	from student s right outer join major m -- outer join
    on s.mcode = m.mcode;

-- <실습> Oracle의 emp table과 흡사한 personal table과
--      		 dept table과 흡사한 division table 만들기 
drop table personal;
drop table division;

create table division(
	dno		  int,  	-- 부서 번호
    dname     varchar(20),
    phone     varchar(20), -- 부서 연락처
    position  varchar(20), 
    primary key(dno)
);

create table personal(
	pno		  int,                     -- 사번
    pname     varchar(20)	not null, -- 사원명
    job 	  varchar(20)	not null,
    manager	  int,					  -- 상사 사번
    startdate date,					  -- 입사일
    pay		  int,
    bonus     int,
    dno		  int,
    primary key(pno),
    foreign key(dno)  references division(dno)
);
select * from division;
select * from personal;

insert into division
	values (10, 'finance', '02-999-9999','여의도');
insert into division
	values (20, 'research', '02-111-2222','강남');
insert into division
	values (30, 'sales', '02-222-3333','합정');
insert into division
	values (40, 'marketing', '02-233-2323','종로');
commit;

insert into personal 
	values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal 
	values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal 
	values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal 
	values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal 
	values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal 
	values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal 	
	values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal 
	values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal 
	values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal 
	values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);
select * from personal;

commit;

-- < 연습 문제 > : oracle과 대부분 흡사함 -- 
-- 1. 사번, 이름, 급여를 출력
select pno, pname, pay from personal;

-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
select * from personal
	where pay between 2000 and 5000;

-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
select pno, pname, dno 
	from personal
    where dno in (10,20);

-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
select pno, pname, pay 
	from personal
    where bonus is null 
    order by pay desc;

-- 5. 사번, 이름, 부서번호, 급여. 부서코드 순 정렬 같으면 PAY 큰순
select pno, pname, dno, pay 
	from personal
    order by dno, pay desc;

-- 6. 사번, 이름, 부서명
select pno, pname, dname 
	from personal p, division d
    where p.dno = d.dno;

-- 7. 사번, 이름, 상사이름
select w.pno, w.pname, m.pname
	from personal w, personal m
    where w.manager = m.pno;

-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력)
select w.pno, w.pname, m.pname 
	from personal w left outer join personal m
    on w.manager = m.pno;

-- 8-1. 사번, 이름, 상사이름(상사가 없는 사람도 출력. 상사가 없을경우 없다고 출력)
select w.pno, w.pname, ifnull(m.pname, '없음') manager -- ifnull(); null값 지정  
	from personal w left outer join personal m
    on w.manager = m.pno;
    
select w.pno, w.pname, if(m.pname is null, '없다', m.pname) manager 
					-- if(); java의 삼항연산자와 흡사
	from personal w left outer join personal m
    on w.manager = m.pno;
-- 9. 이름이 s로 시작하는 사원 이름
select pname from personal
    where pname like 's%';

select pname from personal
	where substr(pname, 1, 1) = 's';
    
select pname from personal
	where instr(pname, 's') = 1;

-- 10. 사번, 이름, 급여, 부서명, 상사이름
select w.pno, w.pname, w.pay, dname, m.pname
	from personal w, personal m, division d
    where w.dno = d.dno
	  and w.manager = m.pno;

-- 11. 부서코드, 급여합계, 최대급여
select dno, sum(pay), max(pay)
	from personal;

-- 12. 부서명, 급여평균, 인원수
select dname, avg(pay), count(*)
	from personal p, division d
    where p.dno = d.dno
    group by dname;

-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
select dno, sum(pay), count(*)
	from personal
    group by dno
    having count(*) >=4;

-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
select pno, pname, pay 
	from personal
    where pay = (select max(pay) from personal);

-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호
select pname, pay, dno
	from personal
    where pay > (select avg(pay) from personal);

-- 16. 14번에 부서명을 추가하고 부서명순 정열 같으면 급여 큰순
select pno, pname, pay, dname 
	from personal p, division d
	where p.dno = d.dno
      and pay = (select max(pay) from personal)
    order by dname, pay desc;

-- 17. 자신이 속한 부서의 평균보다 많이 받는 사람의 이름, 금여, 부서번호, 반올림한 해당부서평균
-- 1) 서브쿼리 이용 
select pname, pay, dno, 
       round((select avg(pay) from personal where p.dno=dno)) 
	from personal p
	where pay > (select avg(pay) from personal where p.dno=dno);

-- 2) inline view 이용
select pname, pay, dno from personal; -- (1) 
select dno, avg(pay) avgsal from personal group by dno; -- (2)
select pname, pay, s.dno, avgsal  -- (1), (2) JOIN
	from personal p, (select dno, avg(pay) avgsal from personal group by dno) s
    where p.dno = s.dno 
      && pay > avgsal; -- mySQL에서는 AND 대신 &&을 사용해도 된다.


-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
select pname, pay, dname
	from personal p, division d
    where p.dno = d.dno
	  and startdate = (select min(startdate) from personal);

-- 19. 이름, 급여, 해당부서평균(반올림)
select pname, pay, 
	   round((select avg(pay) from personal where dno = p.dno)) 부서평균 
	from personal p;

-- 20. 이름, 급여, 부서명, 해당부서평균(반올림)
select pname, pay, dname,
	   round((select avg(pay) from personal where dno = p.dno)) 부서평균 
	from personal p, division d
    where p.dno = d.dno;

-- -- -- -- -- -- -- -- 
-- ORACLE에서의 단일행함수와 mySQL 컬럼 함수의 다른 부분

select concat(pname,'은 ',job,'이다.') from personal; -- 매개변수 3개 이상 사용 가능 (오라클은 2개씩만)
select round(356.98,1); -- from절 없이 사용 가능 (오라클에서는 'from dual;' 이 붙어야 함)
select year(startdate), month(startdate), pname from personal; -- 년도만 or -- 월만 추출하기 
select monthname(startdate) from personal; -- 월 이름 추출
select dayname(startdate) from personal; -- 요일 이름 추출
-- date_format에서 포맷 글자
-- 		%y 21(년도 2자리) %Y 2021(년도 4자리)
-- 		%M 월이름(January, ..)  %m(01월, 02월,...) 
-- 		%b 짧은 월이름(Jan,..)   %c 월수(1,2,3...12)
-- 		%e 일(1,2,3,..)        %d(01,02,03,..)
-- 		%H 24시간  %h 12시간  %p (오전, 오후) %i 분 %s 초 
select date_format(now(), '%y년%c월%d일 %p %h시 %i분 %s초'); -- 현재 날짜와 시각 출력 alter
-- ex. personal table에서 이름, 입사일(yyyy년 mm월 dd일) 출력 
select pname, date_format(startdate, '%y년 %c월 %e일') 
	from personal;

-- 현재 날짜와 시간 
select sysdate();
select now();

-- 현재 날짜만
select current_date();
select curdate();

-- 현재 시간만 
select current_time();
select curtime();

-- format()
select format(pay, 1) from personal; -- 소수점 한자리까지 표시 / 자릿수 3자리마다 , 표시
select format(pay, 0) from personal; -- 일의 자리까지 표시 / 자릿수 3자리마다 , 표시 

-- if()  -  이름, 급여, 급여가 3000이상인지 아닌지 여부 출력 
select pname, pay, if(pay >= 3000, '높다', '낮다') 
	from personal;

-- top-n구문  - 급여가 높은 순대로 이름, 급여 출력하기
select pname, pay from personal order by pay desc;
-- 1) limit n (1~n등까지)
select pname, pay from personal order by pay desc
	limit 5;
-- 2) limit n1, n2 (n1번째부터 n2개 - n1번째 = 처음 0번째) 
select pname, pay from personal order by pay desc
	limit 3,3; -- 4~6등 
select pname, pay from personal order by pay desc
	limit 5,4;  -- 6~9등
select pname, pay from personal order by pay desc 
	limit 0, 3; -- 1~3등 
select pname, pay from personal order by pay desc
	limit 3; -- 1~3등






