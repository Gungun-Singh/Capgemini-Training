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

