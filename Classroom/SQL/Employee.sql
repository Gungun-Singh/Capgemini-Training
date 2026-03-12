DROP TABLE IF EXISTS emp;

CREATE TABLE emp (
  empno decimal(4,0) NOT NULL,
  ename varchar(10) default NULL,
  job varchar(9) default NULL,
  mgr decimal(4,0) default NULL,
  hiredate date default NULL,
  sal decimal(7,2) default NULL,
  comm decimal(7,2) default NULL,
  deptno decimal(2,0) default NULL
);

DROP TABLE IF EXISTS dept;

CREATE TABLE dept (
  deptno decimal(2,0) default NULL,
  dname varchar(14) default NULL,
  loc varchar(13) default NULL
);

INSERT INTO emp VALUES ('7369','SMITH','CLERK','7902','1980-12-17','800.00',NULL,'20');
INSERT INTO emp VALUES ('7499','ALLEN','SALESMAN','7698','1981-02-20','1600.00','300.00','30');
INSERT INTO emp VALUES ('7521','WARD','SALESMAN','7698','1981-02-22','1250.00','500.00','30');
INSERT INTO emp VALUES ('7566','JONES','MANAGER','7839','1981-04-02','2975.00',NULL,'20');
INSERT INTO emp VALUES ('7654','MARTIN','SALESMAN','7698','1981-09-28','1250.00','1400.00','30');
INSERT INTO emp VALUES ('7698','BLAKE','MANAGER','7839','1981-05-01','2850.00',NULL,'30');
INSERT INTO emp VALUES ('7782','CLARK','MANAGER','7839','1981-06-09','2450.00',NULL,'10');
INSERT INTO emp VALUES ('7788','SCOTT','ANALYST','7566','1982-12-09','3000.00',NULL,'20');
INSERT INTO emp VALUES ('7839','KING','PRESIDENT',NULL,'1981-11-17','5000.00',NULL,'10');
INSERT INTO emp VALUES ('7844','TURNER','SALESMAN','7698','1981-09-08','1500.00','0.00','30');
INSERT INTO emp VALUES ('7876','ADAMS','CLERK','7788','1983-01-12','1100.00',NULL,'20');
INSERT INTO emp VALUES ('7900','JAMES','CLERK','7698','1981-12-03','950.00',NULL,'30');
INSERT INTO emp VALUES ('7902','FORD','ANALYST','7566','1981-12-03','3000.00',NULL,'20');
INSERT INTO emp VALUES ('7934','MILLER','CLERK','7782','1982-01-23','1300.00',NULL,'10');

INSERT INTO dept VALUES ('10','ACCOUNTING','NEW YORK');
INSERT INTO dept VALUES ('20','RESEARCH','DALLAS');
INSERT INTO dept VALUES ('30','SALES','CHICAGO');
INSERT INTO dept VALUES ('40','OPERATIONS','BOSTON');

SELECT * FROM emp;
SELECT * FROM dept;

SELECT ename, sal from emp;
-- display sal of employee without duplicates
select distinct sal from emp;

-- display emp name , sal, without duplicates

(select distinct ename from emp)
union
(select distinct sal from emp);

-- display salary of emp with bonus of 1000 rupees
select ename,sal+1000 from emp;

select ename, sal-1000 from emp;

-- display emp name , salary and annual salary of emp
select ename, sal, sal*12 from emp;

-- display emp name, sal with hike of 10%
select ename, sal, sal+sal*0.1 from emp;
-- deduction
select ename, sal, sal-sal*0.1 from emp;


select ename, sal, sal+1000 bonus from emp;

select sal*12 Annual_salary from emp;

select sal*12 "Annual salary" from emp;

select sal as "Monthly salary",sal*12 Annual_salary from emp;

-- 1
select ename, sal, sal+50 as hike from emp;

-- 2..deductin of 10%
select ename, sal, sal*12,sal*12-(sal*12*0.10) as deducted_sal from emp;

-- 3
select ename, sal,  sal+ CASE 
                WHEN comm IS NULL THEN 0 
                ELSE comm 
             END AS sal as total_salary from emp;

-- 4
select emp.*, sal*12 as "annual salary" from emp;

-- 5
select ename, job, sal, sal-100 as "penalty salary" from emp;



select * from emp;






-- display emp name, dept no. of emp working in dept no 20
select ename, deptno from emp where deptno =20;

-- display name and sal of emp who r earning more than 2000;
select ename, sal from emp where sal>2000;

-- display the details of empl who r working as manager
select * from emp where job='MANAGER';

-- display name and hire date of empl who r hired after 1981

select ename, hiredate from emp where hiredate>'1981-12-31';

-- display name and salary and annual salary of emp if annual is more than 12000;

select ename, sal, sal*12 as annual_sal from emp where sal*12>12000;

select 'Mr ' || Ename as employee_name from emp;

select ename || ' is working as '||job||' and earning salary of '|| sal from emp;
select concat(ename, ' is working as ',job, ' and earning salary of ',sal) from emp;


-- display the details of emp working in dept 20 and earning salary more than 2000

select * from emp where deptno= 20 and sal>2000;

-- display name and dept no of emp who are working in dept no. 10, 20

select ename, deptno from emp where deptno =10 or deptno=20;

-- display the details of emp who are earning more than 2000  in dept no. 10,20
select * from emp where sal>2000 and (deptno =10 or deptno =20);

select * from emp;

-- display details of emp who are not working as sales man and analyst
select * from emp where job <> 'SALESMAN' and job<>'ANALYST';

Select * from emp where job not in 'SALESMAN' AND job not in'ANALYST';

select * from emp where not (job='SALESMAN' OR job ='ANALYST');

select * from emp where not job ='SALESMAN' AND not job= 'ANALYST';


-- display details of emp working under dept no 20
select ename,deptno from emp where deptno in(10,20);

select * from emp;

select ename,deptno from emp where deptno not in(10,20);

-- display name and salary of emp who r earning salary in the range of 1000 to 3000
select ename, sal from emp where sal between 1000 and 3000;

-- display the details of employee who r hired in the year of 1981

select * from emp where hiredate between '1981-01-01' and '1981-12-31';

-- display the details of emp who r not earning salary in the range of 1000 to 3000
select * from emp where sal not between 1000 and 3000;


select * from emp where comm is null;

select * from emp where comm is not null;

-- display details of emp who are earning salary but not commision
select * from emp where sal is not null and comm is null;

-- display names of employee whose name starts with s
select * from emp where ename like 'S%';

-- display names of empl whose name consists of char a
select ename from emp where ename like '%A%';

-- display details of employee whose name consists of char a 2 times
select * from emp where ename like '%A%A%';

-- exactly 2 a's
select * from emp where ename like '%A%A%' AND ename not like '%A%A%A%';

-- display name and salary of empl who are earning 4 digit of salary
select * from emp where sal>=1000 and sal<=9999;


-- select * from emp where sal like '____.__';
-- select * from emp where round(sal) like '____'; 

select * from emp where round(sal):: text like '____';

-- display details of emp who are hired in the month of feb
select * from emp where hiredate:: text like '%-02-%';

-- display emp name which doesnt start with s
select * from emp where ename not like 'S%';

-- display the names of employee whose name starts with a or s
select * from emp where ename like 'A%' or ename like 'S%';

-- starts with vowel
select * from emp where ename like 'A%' or ename like 'E%' or ename like 'I%' or ename like 'O%' or ename like 'U%';

-- display the details whose name starts with consonants and end with vowels

select * from emp where (ename not like 'A%' and ename not like 'E%' and ename not like 'I%' and ename not like 'O%' and ename not like 'U%') AND (
 ename like '%A' or ename like '%E' or ename like '%I' or ename like '%O' or ename like '%U'); 



select * from emp;





select ename from emp where mgr is not null AND deptno =10;


select ename from emp where comm is null and job='CLERK';


-- select ename from emp where not(job='MANAGER' and (deptno=10 or deptno=30));
select ename from emp where mgr is null and (deptno=10 or deptno=30);

select * from emp where ename like 'J%' and ename like '%S';

select * from emp where sal BETWEEN 1000 and 9999;

select * from emp where ename like '_____';

select ename, hiredate from emp where hiredate:: TEXT like '1982-%-01';

select * from emp where ename like 'A____A';

select ename, job from emp where job like '%MAN%';

select ename from emp where ename like '%S';

select * from emp where job='ANALYST' and (sal between 1000 and 9999);

select ename from emp where hiredate:: text like '%-01-%'; 

select * from emp where ename like '%L%L%' and job='MANAGER';

select ename from emp where ename like 'A%' or ename like 'J%' or ename like 'S%';

select ename from emp where ename not like '__A%';








select length(ename) from emp;


select 'hello';

select ename, length(ename) as length from emp;

-- display the names of emp whose name has exactly 4 char
select ename from emp where length(ename)=4;

-- display details of empl whose name is more than 4 characters but less than 7 characters

select * from emp where length(ename)>4 and length(ename)<7;







-- --------------------------------------------------------------------------------------------------------------









select lower('SMITH');
select Substr('Qspiders',2,4);

select Substr('Qspiders',5,6);
-- select Substr('Qspiders',-3);

select Substr(ename,1,1) from emp;

select position('s' in 'Prisha');

select substr('Galgotias uni',position(' ' in 'Galgotias uni')+1);

select substr('rimi@gmail.com', position('@' in 'rimi@gmail.com'));

select substr('rimi@gmail.com',1, position('@' in 'rimi@gmail.com')-1);

select round(45.63);
select ceil(46.23);


select now();
select current_date;
select current_timestamp


select Extract(year from now());

select Extract(month from now());

select Extract(day from now());

select Extract(hour from now());
select Extract(minute from now());
select Extract(second from now());


-- retrieve all emp who were hired on friday

-- TO_CHAR()...CONVERT DATE INTO FORMAT MODELS


-- day - monday
-- dy - mon
-- dd - 16
-- d - 1

select emp.* , to_char(Hiredate, 'day') as day from emp 
where to_char(Hiredate,'dy')= 'fri';

-- month - decemnber
-- mon - dec
-- mp - 12

-- retrieve dec 
select emp.* , to_char(Hiredate, 'mon') as mon from emp
where to_char(Hiredate, 'mon') = 'dec';
-- or
-- where hiredate:: text like '____-12-____';

-- yyyy - 2026
-- yy - 26

-- hired on 1981
select emp.* , to_char(hiredate, 'yyyy') from emp
where to_char(hiredate,'yyyy') ='1981';

-- hh12 - 11 hours
-- hh24 - ...
-- mi - 39
-- ss - 39 second

-- hh12-mi--ss  == 11-40-20
-- hh24-mi-ss ==  


-- display the details of emp who hired in the month of march, april, may
select emp.* , to_char (hiredate,'month') from emp
where trim(to_char(hiredate,'month')) in ('march', 'april', 'may');



-- display the details of emp who r hired on 1981 in the month of feb, dec, april on wed and fri

SELECT emp.*,
       TO_CHAR(hiredate, 'mon'),
       TO_CHAR(hiredate, 'year'),
       TO_CHAR(hiredate, 'dy')
FROM emp
WHERE TO_CHAR(hiredate, 'mon') IN ('feb','apr','dec')
  AND (TO_CHAR(hiredate, 'yyyy')) ='1981'
  AND TO_CHAR(hiredate, 'dy') IN ('wed','fri');




select now() - interval '1 day';
select now() + interval '1 day';
select now() - interval '3 month';
select now() - interval '1 year';


-- hired in last 2 years
select * from emp 
where hiredate > current_date - interval '2 year';


select age(current_date, '2025-01-01');

select extract(year from age(current_date, '2025-01-01')) exper;

-- retrieve emp having 10 yrs of exp

select emp.* , extract(year from age(current_date , hiredate)) exp from emp
where extract(year from age(current_date , hiredate)) >=10;


Select ename, sal, comm, sal + coalesce(comm,0) as total_Sal 
from emp;


-- SELECT ename, MAX(sal) FROM emp;

-- select ename from emp where sal= max(sal);

select count(comm) from emp;

select count(*) from emp;

-- display no. of empl whose name consists of char a

select count(ename) from emp where ename like '%A%';

-- display max salary , min salary and average sal of all emp working in deptno 20

select max(sal) maximum, min(sal) minimum, avg(sal) average from emp where deptno =20;

select * from emp;

-- display number of empl and total salary of all the employees who is earning more than 1700

select count(*) , sum(sal) from emp where sal>1700;










select * from emp;


-- can only use deptno col name in select clause
select deptno, count(*) from emp
group by (deptno);

-- display no. of employyes in each dept if there sal > 2000

select deptno, count(*) from emp where sal>2000 group by(deptno);

-- display min and max salary given to an employee in each desig
select min(sal), max(sal),job from emp
group by(job);

-- display numb of times sal are repeated in empl table
select count(*),sal from emp
group by sal;

-- display avg sal to empl in each job
select job, avg(sal) from emp 
group by job;

-- display no. of empl earning comm in each dept
select count(comm),deptno from emp group by deptno;

select count(*),deptno from emp where comm is not null group by deptno;

select count(*) , sal, ename
from emp
group by sal,deptno,ename;


select count(*), job
from emp
group by 2;


-- display empl working in dept having
select count(*) , deptno
from emp
group by deptno
having count(*) >=4;

-- no. of empl in each dept having atleast 2 empl in it and name consist of a or s
select count(*),deptno
from emp
where ename like '%A%' or ename like '%S%'
group by deptno
having count(*)>=2;

-- display sal repeated in empl table
select count(sal), sal from emp
group by sal
having count(sal)>1;


-- display job and total sal of each job ...if tot sal of each job >7000
select job, sum(sal) total_salary from emp
group by job
having sum(sal)>7000;

-- avg salary of all empl and display it only if avg sal exceeds 55,000.
select avg(sal) average_sal from emp
having avg(sal)>55000;

-- numb of empl earning more than 1200 in each job and total sal needed to pay emp of each job must exceed 3800
select count(*),sum(sal),job from emp
where sal>1200
group by job
having sum(sal)>3800;

-- job and max sal of empl in each job if max exceeds 2600
select job, max(sal) from emp
group by job
having max(sal)>2600;

-- hiredate which are duplicate in empl table
select hiredate 
from emp
group by hiredate
having count(*)>1;

-- deptno and numb of empl working only if there are 2 empl working in each dept as manager
select deptno, count(*) from emp
WHERE job = 'MANAGER'
group by(deptno)
having count(*)=2 ;


-- arrange name of empl in desc order
select ename
from emp
order by ename desc;

-- display all sal of empl working as manager in asc order
select sal from emp
where job ='MANAGER'
order by sal;

-- display no. of times sal are repeated...in desc order
select count(*) no_of_times , sal
from emp
group by sal
order by no_of_times desc;


-- display details of empl who is earning more than allen
select * from emp
where sal>(select sal from emp where ename='ALLEN');



-- ASSIGNMENTS
-- 1
select ename 
FROM emp 
WHERE sal>(select sal FROM emp WHERE ename='ADAMS');

-- 2
select ename,sal FROM emp 
WHERE sal<(select sal FROM emp WHERE ename='KING');

-- 3
select ename, deptno 
FROM emp 
WHERE deptno=(select deptno FROM emp WHERE ename='JONES');

-- 4
select ename,job FROM emp 
WHERE job=(select job FROM emp WHERE ename='JAMES');

-- 5
select empno, ename,sal*12 AS annual_salary 
FROM emp 
WHERE sal*12>(select sal*12 FROM emp WHERE ename='WARD');

-- 6
select ename, hiredate FROM emp 
WHERE hiredate<(select hiredate FROM emp WHERE ename='SCOTT');

-- 7
select ename, hiredate 
FROM emp 
WHERE hiredate>(SELECT hiredate FROM emp WHERE job='PRESIDENT');

-- 8
select ename, sal FROM emp 
WHERE sal<(select sal FROM emp WHERE empno=7839);

-- 9
select * from emp 
where hiredate < (SELECT hiredate FROM emp WHERE ename='MILLER');

-- 10
SELECT ename, empno 
FROM emp 
WHERE sal > (SELECT sal FROM emp WHERE ename = 'ALLEN');

-- 11
SELECT ename, sal 
FROM emp 
WHERE sal > (SELECT sal FROM emp WHERE ename = 'BLAKE');




select * from dept;

select * from emp;


-- display dept name of smith
select d.dname from dept d
join emp e ON d.deptno=e.deptno
where e.ename='SMITH';



select Dname
from dept
where deptno in (
	select deptno from emp
	where ename in('SMITH' ,'ALLEN')
);



select * from dept
where deptno in (
	select deptno from emp
	where job in('DEVELOPER')
);

-- DETAIL OF empl who is earning min salary
select * from emp
where sal in (select min(sal) from emp);

-- display dept details of empl who is earning max salary
select *
from dept
where deptno IN (
    select deptno
    from emp
    where sal in (select max(sal) from emp)
);

-- display name , sal,job and hiredate of emp working in sales dept and hired before king
SELECT ename, sal, job, hiredate
FROM emp
WHERE deptno = (
    SELECT deptno 
    FROM dept 
    WHERE dname = 'SALES'
)
AND hiredate<(
    SELECT hiredate 
    FROM emp 
    WHERE ename = 'KING'
);

-- display dept name in which there are atleast 4 empl working
select dname from dept
where deptno in (select deptno from emp group by deptno having count(*) >3);

-- display the details of emps getting same salary in the same dept
select * from emp where (deptno,sal) in (
select deptno, sal from emp
group by sal, deptno
HAVING COUNT(*)>1);





select * from emp;

select * from emp
limit 1 offset 2;


-- display 5th 6th 7th rec
select * from emp
limit 3 offset 4;

-- display last record 
select * from emp
order by empno desc
limit 1
;

select * from emp 
limit 1 offset (select count(*)-1
from emp);


-- display 4th max salary
select distinct sal from emp
order by sal desc
limit 1 offset 3;

-- display detail of empl who is earning  3rd and 4th min salary
select * from emp where sal in (select distinct sal from emp
order by sal asc
limit 2 offset 2)
order by sal asc;







select * from (select * from emp where deptno =20) dummy;

-- display ename, annual_sal of emp whose annual sal is more than 12000
select ename, sal*12 as annual_sal
from emp 
where sal*12>12000;
-- or

select ename, sal*12 as annual_sal 
from (select emp.*, sal*12 as annual_sal from emp) t1
where annual_sal>12000;



-- -----------------------------------------------------------------------------------------------------------------------------
AUTHORS	(author_id,author_name,state)
BOOKS	(book_id, title,author_id,genre_id)
GENRES	(genre_id,genre_name)
LOANS	(loan_id,user_id,book_id,borrowed_date,return_date)
USERS	(user_id,user_name,phnno, email,book_id)

-- display author name who has written book "SQL"
select author_name
from authors
where author_id in (select author_id from books where title='SQL');

-- display no. of books written by each author
select count(*) from books group by author_id

-- display the user details who has borrowed a book "Atomic habits".
select * from users where user_id in (select user_id from loans
	where book_id in ( select book_id from books where title= 'ATOMIC HABITS'));

-- DISPLAY no. of books borrowed by each user??
select count(user_id), user_id from loans group by user_id;




select * from emp;

select * from dept;


-- CARTESIAN / CROSS JOIN
select * 
from emp cross join dept;


-- display ename,sal and location of all the empl who r working in CHICAGO
select ename, sal, loc 
from emp INNER JOIN dept
on emp.deptno = dept.deptno
where loc='CHICAGO';


-- display name and job whose job and dname starts with 'S'
select ename, job
from emp inner join dept
on emp.deptno = dept.deptno
where job like 'S%' and dname like 'S%';

-- dname and mgrno fro empl rep to 7839
 select dname, mgr
from emp inner join dept
on emp.deptno = dept.deptno
where mgr ='7839';

-- dname and hiredate ...hired after 83 into accounting or research dept
select dname, hiredate
from emp inner join dept
on emp.deptno = dept.deptno
where hiredate >'1983-12-31' and dname in ('ACCOUNTING' , 'RESEARCH'); 

-- DNAME AND ename of empl getting comm in dept 10 or 30
select dname, ename
from emp inner join dept
on emp.deptno = dept.deptno
where comm is not null and emp.deptno in ('10', '30');

-- dname and empno for all empl whose emp are 7839,7902 and r working in loc newyrk
select dname, empno 
from emp inner join dept
on emp.deptno = dept.deptno
where empno in ('7839', '7902') and loc ='NEW YORK';


-- no of emp working in each dept
select count(*) , emp.deptno,dname
from emp inner join dept
on emp.deptno = dept.deptno
group by emp.deptno, dname;

-- display emp name and their deptname even though the employee who don't work in any dept 
select ename, dname
from emp left join dept
on emp.deptno = dept.deptno;

-- display ename and dept name even though the dept where no emp r working 
select ename, dname
from emp right join dept
on emp.deptno = dept.deptno;

select ename, dname
from dept left join emp
on emp.deptno = dept.deptno;

select ename, dname
from dept,emp
on emp.deptno(+)= dept.deptno;

select *
from dept full join emp
on emp.deptno = dept.deptno;
