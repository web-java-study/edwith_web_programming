select version(), current_date;
show databases;


use connectdb;
create table student(
	student_id int not null auto_increment primary key,
    name varchar(100),
    grade varchar(100),
    dept varchar(100)
);

show tables;
commit;



CREATE TABLE EMPLOYEE(
   empno      INTEGER NOT NULL,
   name       VARCHAR(10),
   job        VARCHAR(9),
   boss       INTEGER,
   hiredate   VARCHAR(12),
   salary     DECIMAL(7, 2),
   comm       DECIMAL(7, 2),
   deptno     INTEGER
);
 
CREATE TABLE DEPARTMENT(
   deptno     INTEGER NOT NULL,
   name       VARCHAR(14),
   location   VARCHAR(13)
);

CREATE TABLE SALARYGRADE(
   grade      INTEGER NOT NULL,
   losal      INTEGER NOT NULL,
   hisal      INTEGER NOT NULL
);

CREATE TABLE BONUS (
   ename      VARCHAR(10) NOT NULL,
   job        VARCHAR(9) NOT NULL,
   sal        DECIMAL(7, 2),
   comm       DECIMAL(7, 2)
);

CREATE TABLE PROJECT(
   projectno    INTEGER NOT NULL,
   description  VARCHAR(100),
   start_date   VARCHAR(12),
   end_date     VARCHAR(12)
);

CREATE TABLE PROJECT_PARTICIPATION(
   projectno    INTEGER NOT NULL,
   empno        INTEGER NOT NULL,
   start_date   VARCHAR(12) NOT NULL,
   end_date     VARCHAR(12),
   role_id      INTEGER
);

CREATE TABLE ROLE(
   role_id      INTEGER NOT NULL,
   description  VARCHAR(100)
);

-- Primary Keys
ALTER TABLE EMPLOYEE
   ADD CONSTRAINT emp_pk
   PRIMARY KEY (empno);

ALTER TABLE DEPARTMENT
   ADD CONSTRAINT dept_pk
   PRIMARY KEY (deptno);

ALTER TABLE SALARYGRADE
   ADD CONSTRAINT salgrade_pk
   PRIMARY KEY (grade);

ALTER TABLE BONUS
   ADD CONSTRAINT bonus_pk
   PRIMARY KEY (ename, job);

ALTER TABLE PROJECT
   ADD CONSTRAINT project_pk
   PRIMARY KEY (projectno);
 
ALTER TABLE PROJECT_PARTICIPATION
   ADD CONSTRAINT participation_pk
   PRIMARY KEY (projectno, empno, start_date);

ALTER TABLE ROLE
   ADD CONSTRAINT role_pk
   PRIMARY KEY (role_id);

-- EMPLOYEE to DEPARTMENT
ALTER TABLE EMPLOYEE
   ADD CONSTRAINT department
   FOREIGN KEY (deptno)
   REFERENCES DEPARTMENT (deptno);

-- EMPLOYEE to EMPLOYEE
ALTER TABLE EMPLOYEE
   ADD CONSTRAINT boss
   FOREIGN KEY (boss)
   REFERENCES EMPLOYEE (empno);
 
-- EMPLOYEE to PROJECT_PARTICIPATION
ALTER TABLE PROJECT_PARTICIPATION
   ADD CONSTRAINT employee
   FOREIGN KEY (empno)
   REFERENCES EMPLOYEE (empno);

-- PROJECT to PROJECT_PARTICIPATION
ALTER TABLE PROJECT_PARTICIPATION
   ADD CONSTRAINT project
   FOREIGN KEY (projectno)
   REFERENCES PROJECT (projectno);

-- ROLE to PROJECT_PARTICIPATION
ALTER TABLE PROJECT_PARTICIPATION
   ADD CONSTRAINT role
   FOREIGN KEY (role_id)
   REFERENCES ROLE (role_id);

-- data
INSERT INTO DEPARTMENT VALUES (10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPARTMENT VALUES (20, 'RESEARCH',   'DALLAS');
INSERT INTO DEPARTMENT VALUES (30, 'SALES',      'CHICAGO');
INSERT INTO DEPARTMENT VALUES (40, 'OPERATIONS', 'BOSTON');
 
INSERT INTO EMPLOYEE VALUES (7839, 'KING',   'PRESIDENT', NULL, '1981-11-17', 5000, NULL, 10);
    INSERT INTO EMPLOYEE VALUES (7566, 'JONES',  'MANAGER',   7839, '1981-04-02',  2975, NULL, 20);
       INSERT INTO EMPLOYEE VALUES(7788, 'SCOTT',  'ANALYST',   7566, '1982-12-09', 3000, NULL, 20);
          INSERT INTO EMPLOYEE VALUES(7876, 'ADAMS',  'CLERK',     7788, '1983-01-12', 1100, NULL, 20);
       INSERT INTO EMPLOYEE VALUES(7902, 'FORD',   'ANALYST',   7566, '1981-12-03',  3000, NULL, 20);
          INSERT INTO EMPLOYEE VALUES(7369, 'SMITH',  'CLERK',     7902, '1980-12-17',  800, NULL, 20);
    INSERT INTO EMPLOYEE VALUES (7698, 'BLAKE',  'MANAGER',   7839, '1981-05-01',  2850, NULL, 30);
       INSERT INTO EMPLOYEE VALUES(7499, 'ALLEN',  'SALESMAN',  7698, '1981-02-20', 1600,  300, 30);
       INSERT INTO EMPLOYEE VALUES(7521, 'WARD',   'SALESMAN',  7698, '1981-02-22', 1250,  500, 30);
       INSERT INTO EMPLOYEE VALUES(7654, 'MARTIN', 'SALESMAN',  7698, '1981-09-28', 1250, 1400, 30);
       INSERT INTO EMPLOYEE VALUES(7844, 'TURNER', 'SALESMAN',  7698, '1981-09-08',  1500,    0, 30);
       INSERT INTO EMPLOYEE VALUES(7900, 'JAMES',  'CLERK',     7698, '1981-12-03',   950, NULL, 30);
    INSERT INTO EMPLOYEE VALUES(7782, 'CLARK',  'MANAGER',   7839, '1981-06-09',  2450, NULL, 10);
       INSERT INTO EMPLOYEE VALUES(7934, 'MILLER', 'CLERK',     7782, '1982-01-23', 1300, NULL, 10);
 
INSERT INTO SALARYGRADE VALUES (1,  700, 1200);
INSERT INTO SALARYGRADE VALUES (2, 1201, 1400);
INSERT INTO SALARYGRADE VALUES (3, 1401, 2000);
INSERT INTO SALARYGRADE VALUES (4, 2001, 3000);
INSERT INTO SALARYGRADE VALUES (5, 3001, 9999);
 
INSERT INTO ROLE VALUES (100, 'Developer');
INSERT INTO ROLE VALUES (101, 'Researcher');
INSERT INTO ROLE VALUES (102, 'Project manager');

INSERT INTO PROJECT VALUES (1001, 'Development of Novel Magnetic Suspension System', '2006-01-01', '2007-08-13');
INSERT INTO PROJECT VALUES (1002, 'Research on thermofluid dynamics in Microdroplets', '2006-08-22', '2007-03-20');
INSERT INTO PROJECT VALUES (1003, 'Foundation of Quantum Technology', '2007-02-24', '2008-07-31');
INSERT INTO PROJECT VALUES (1004, 'High capacity optical network', '2008-01-01', null);
 
INSERT INTO PROJECT_PARTICIPATION VALUES (1001, 7902, '2006-01-01', '2006-12-30', 102);
INSERT INTO PROJECT_PARTICIPATION VALUES (1001, 7369, '2006-01-01', '2007-08-13', 100);
INSERT INTO PROJECT_PARTICIPATION VALUES (1001, 7788, '2006-05-15', '2006-11-01', 100);

INSERT INTO PROJECT_PARTICIPATION VALUES (1002, 7876, '2006-08-22', '2007-03-20', 102);
INSERT INTO PROJECT_PARTICIPATION VALUES (1002, 7782, '2006-08-22', '2007-03-20', 101);
INSERT INTO PROJECT_PARTICIPATION VALUES (1002, 7934, '2007-01-01', '2007-03-20', 101);

INSERT INTO PROJECT_PARTICIPATION VALUES (1003, 7566, '2007-02-24', '2008-07-31', 102);
INSERT INTO PROJECT_PARTICIPATION VALUES (1003, 7900, '2007-02-24', '2007-01-31', 101);

INSERT INTO PROJECT_PARTICIPATION VALUES (1004, 7499, '2008-01-01', null, 102);
INSERT INTO PROJECT_PARTICIPATION VALUES (1004, 7521, '2008-05-01', null, 101);
INSERT INTO PROJECT_PARTICIPATION VALUES (1004, 7654, '2008-04-15', null, 101);
INSERT INTO PROJECT_PARTICIPATION VALUES (1004, 7844, '2008-02-01', null, 101);
INSERT INTO PROJECT_PARTICIPATION VALUES (1004, 7900, '2008-03-01', '2008-04-01', 101);
INSERT INTO PROJECT_PARTICIPATION VALUES (1004, 7900, '2008-05-20', null, 101);

commit;

select * from department;
select empno, name, job from employee;
select empno as 사번, name as 이름, job as 직업 from employee;
/* 컬럼합성 */
select concat(empno,'-',deptno) as '사번-부서번호' from employee;

/*중복행제거*/
select distinct deptno from employee;

/*정렬 */
select empno, name, job from employee order by name;

 /* employee 테이블에서 고용일(hiredate)이 1981년 이전의 사원이름과 고용일을 출력하시오. */
 select name, hiredate from employee where hiredate < '1981-01-01';
/* employee 테이블에서 부서번호가 30인 사원이름과 부서번호를 출력하시오. */
select name, deptno from employee where deptno =30;

/* IN 키워드 (또는)
예제 : employee 테이블에서 부서번호가 10또는 30인 사원이름과 부서번호를 출력하시오. */
select name, deptno from employee where deptno in (10,30);

/*검색키워드 LIKE */
select name, job from employee where name like '%A%';

/*ucase, upper* 대문자변환/
select upper('Seoul'), ucase('seOUL');

/*LCASE, LOWER* 소문자변환*/
select lower(name) from employee;

/*substring*/
select substring('happy day',3,2);
select substring(name,3,2) from employee;

/*lpad, rpad 비밀번호 가리기 */
select lpad('hi',5,'?');
select lpad(name,5,'?') from employee;
select rpad(name,10,'?') from employee;

/*trim 공백제거 !!!앞뒤공백만 제거 가능, 중간공백 제거 불가*/
SELECT TRIM(' hi '),TRIM(BOTH 'x' FROM 'xxxhixxx');
select trim(name), trim(both 'H' from name) from employee;

/*ABS 절대값 */
SELECT ABS(2), ABS(-2);

/*나누기*/
select mod(234,10);

/*그룹함수*/
SELECT AVG(salary) , SUM(salary)
FROM employee
WHERE deptno = 30;

select deptno, avg(salary), sum(salary)
from employee
group by deptno;

/*자료입력 insert */
/*INSERT INTO 테이블명(필드1, 필드2, 필드3, 필드4, … ) 
        VALUES ( 필드1의 값, 필드2의 값, 필드3의 값, 필드4의 값, … )*/
/*insert into 테이블 values("모든" 칼럼에 들어갈 자료를 순서대로~~~!!); */

insert into ROLE (role_id, description) values ( 200, 'CEO');
select * from role;

/*update 테이블 set 칼럼명 = "변수" where 조건식;*/
update ROLE set description = 'CTO' where role_id = 200;

/* DELETE FROM  테이블명 WHERE  조건식 ;*/
delete from ROLE where role_id = 200;

select emp.name, dep.name as "부서명"
from employee emp
inner join department dep on emp.deptno = dep.deptno;

/*  조인문 검색 https://coding-factory.tistory.com/87 */
select * from department;

create table employee2(
	empno int not null primary key,
     name       VARCHAR(10),   
	   job        VARCHAR(9),   
	   boss       INTEGER,   
	   hiredate   VARCHAR(12),   
	   salary     DECIMAL(7, 2),   
	   comm       DECIMAL(7, 2),   
	  deptno     int
);

alter table employee2 change empno empno int not null auto_increment;

select role_id, description from role where role_id = 100;
desc role;


/*프로젝트 */
CREATE TABLE todo ( 
	id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT, 
    title VARCHAR(255) NOT NULL, name VARCHAR(100) NOT NULL, 
    sequence INT(1) NOT NULL, 
    type VARCHAR(20) DEFAULT 'TODO', 
    regdate DATETIME DEFAULT NOW(), 
    PRIMARY KEY (id) 
);


				insert into todo(title, name, sequence) values('자바스크립트공부하기', '홍길동', 3); 
				insert into todo(title, name, sequence) values('리포트 제출하기', '홍길동', 3);
				insert into todo(title, name, sequence) values('자바스크립트공부하기', '홍길동', 1); 
				insert into todo(title, name, sequence) values('리포트 제출하기', '홍길동', 1);
				insert into todo(title, name, sequence) values('자바스크립트공부하기', '홍길동', 2); 
				insert into todo(title, name, sequence) values('리포트 제출하기', '홍길동', 2);
				insert into todo(title, name, sequence) values('자바스크립트공부하기', '홍길동', 3); 
				insert into todo(title, name, sequence) values('리포트 제출하기', '홍길동', 3);
				insert into todo(title, name, sequence) values('자바스크립트공부하기', '홍길동', 1); 
				insert into todo(title, name, sequence) values('리포트 제출하기', '홍길동', 1);
				insert into todo(title, name, sequence) values('자바스크립트공부하기', '홍길동', 2); 
				insert into todo(title, name, sequence) values('리포트 제출하기', '홍길동', 2);
				insert into todo(title, name, sequence) values('자바스크립트공부하기', '홍길동', 3); 
				insert into todo(title, name, sequence) values('리포트 제출하기', '홍길동', 3);
				insert into todo(title, name, sequence) values('자바스크립트공부하기', '홍길동', 1); 
				insert into todo(title, name, sequence) values('리포트 제출하기', '홍길동', 1);
				insert into todo(title, name, sequence) values('자바스크립트공부하기', '홍길동', 2); 
				insert into todo(title, name, sequence) values('리포트 제출하기', '홍길동', 2);
				insert into todo(title, name, sequence) values('자바스크립트공부하기', '홍길동', 3); 
				insert into todo(title, name, sequence) values('리포트 제출하기', '홍길동', 3);
				insert into todo(title, name, sequence) values('자바스크립트공부하기', '홍길동', 1); 
				insert into todo(title, name, sequence) values('리포트 제출하기', '홍길동', 1);
				insert into todo(title, name, sequence) values('자바스크립트공부하기', '홍길동', 2); 
				insert into todo(title, name, sequence) values('리포트 제출하기', '홍길동', 2);
				insert into todo(title, name, sequence) values('자바스크립트공부하기', '홍길동', 3); 
				insert into todo(title, name, sequence) values('리포트 제출하기', '홍길동', 3);
				insert into todo(title, name, sequence) values('자바스크립트공부하기', '홍길동', 1); 
				insert into todo(title, name, sequence) values('리포트 제출하기', '홍길동', 1);
				insert into todo(title, name, sequence) values('자바스크립트공부하기', '홍길동', 2); 
				insert into todo(title, name, sequence) values('리포트 제출하기', '홍길동', 2);
				insert into todo(title, name, sequence) values('자바스크립트공부하기', '홍길동', 3); 
				insert into todo(title, name, sequence) values('리포트 제출하기', '홍길동', 3);
				insert into todo(title, name, sequence) values('자바스크립트공부하기', '홍길동', 1); 
				insert into todo(title, name, sequence) values('리포트 제출하기', '홍길동', 1);
				insert into todo(title, name, sequence) values('자바스크립트공부하기', '홍길동', 2); 
				insert into todo(title, name, sequence) values('리포트 제출하기', '홍길동', 2);


update todo.todo
set type = 
	case
		when type = 'TODO'
		then 'DOING'
		when type = 'DOING'
		then 'DONE'
        else 'DONE'
		end
where id = 1;

select id, title, name, sequence, type, regdate from todo where id = 1 order by regdate desc; 

update todo set type = 'DONE' where id = 1;
 
 
select id, title, name, sequence, type, regdate from todo where id = 1 order by regdate desc; 

select id, title, name, sequence, type, regdate from todo where type = 'TODO' order by regdate desc;