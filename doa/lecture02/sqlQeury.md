## SQL

구조화된 쿼리 언어, SQL은 데이터를 보다 쉽게 검색하고 추가, 삭제, 수정 같은 조작을 할 수 있도록 고안된 컴퓨터 언어이며, 관계형 데이터베이스에서 데이터를 조작하고 쿼리하는 표준 수단

## DML 데이터 조작어

insert, update, delete, select 등이 여기에 해당함.

## DDL 데이터 정의어

create, drop, alter 스키마를 정의하거나 조작하기 위해서 사용된다.

## DCL 데이터 제어어

grant, revoke 데이터를 제어하는 언어, 권한을 주거나 파기, 트랜잭션 부여 커밋하거나 롤백하는 부분을 수행 → 데이터 보안, 무결성 유지

## Database 사용자 생성과 권한 부여

데이터베이스를 생성했다면, 해당 계정이 데이터베이스를 사용할 수 있도록 권한을 주도록 해야한다.

```jsx
mysql> grant all privileges on connectdb.* to 계정명@'localhost' identified by '패스워드';
Query OK, 0 rows affected, 1 warning (0.00 sec)

mysql> flush privileges;
Query OK, 0 rows affected (0.01 sec)

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| connectdb          |
+--------------------+
2 rows in set (0.00 sec)

mysql> use connectdb
Database changed

mysql> exit
Bye
```

## 현재시각조회

→ 대소문자를 구분하지 않는다. 약속된 언어들은 구분하지 않으나, 싱글쿼터안에서는 싱글쿼터로 데이터를 구분하기 때문에 대소문자를 구분한다,

```jsx
mysql> select version(), current_date;
+------------+--------------+
| version()  | current_date |
+------------+--------------+
| 5.7.31-log | 2020-10-20   |
+------------+--------------+
1 row in set (0.00 sec)

mysql> select version(); select now();
+------------+
| version()  |
+------------+
| 5.7.31-log |
+------------+
1 row in set (0.00 sec)

+---------------------+
| now()               |
+---------------------+
| 2020-10-20 17:48:04 |
+---------------------+
1 row in set (0.01 sec)
```

## 현재 데이터베이스에 존재하는 테이블 목록 및 구조

```jsx
mysql> show tables;
+-----------------------+
| Tables_in_connectdb   |
+-----------------------+
| bonus                 |
| department            |
| employee              |
| project               |
| project_participation |
| role                  |
| salarygrade           |
+-----------------------+
7 rows in set (0.00 sec)

mysql> desc bonus;
+-------+--------------+------+-----+---------+-------+
| Field | Type         | Null | Key | Default | Extra |
+-------+--------------+------+-----+---------+-------+
| ename | varchar(10)  | NO   | PRI | NULL    |       |
| job   | varchar(9)   | NO   | PRI | NULL    |       |
| sal   | decimal(7,2) | YES  |     | NULL    |       |
| comm  | decimal(7,2) | YES  |     | NULL    |       |
+-------+--------------+------+-----+---------+-------+
4 rows in set (0.01 sec)
```

column(key), row(record) → 컬럼과 레코드

select column from table

→ 'column', 'table'

→ select ename from bonus;

```json
mysql> select * from department;
+--------+------------+----------+
| deptno | name       | location |
+--------+------------+----------+
|     10 | ACCOUNTING | NEW YORK |
|     20 | RESEARCH   | DALLAS   |
|     30 | SALES      | CHICAGO  |
|     40 | OPERATIONS | BOSTON   |
+--------+------------+----------+
4 rows in set (0.00 sec)

mysql> select name from department;
+------------+
| name       |
+------------+
| ACCOUNTING |
| RESEARCH   |
| SALES      |
| OPERATIONS |
+------------+
4 rows in set (0.00 sec)

mysql> select deptno, name from department;
+--------+------------+
| deptno | name       |
+--------+------------+
|     10 | ACCOUNTING |
|     20 | RESEARCH   |
|     30 | SALES      |
|     40 | OPERATIONS |
+--------+------------+
4 rows in set (0.00 sec)

mysql> select deptno 부서번호, name 부서명 from department;
+----------+------------+
| 부서번호 | 부서명     |
+----------+------------+
|       10 | ACCOUNTING |
|       20 | RESEARCH   |
|       30 | SALES      |
|       40 | OPERATIONS |
+----------+------------+
4 rows in set (0.00 sec)
```

deptno 부서번호, name 부서명 → 컬럼명을 별칭으로 바꾸어서 출력할 수 있음. 신기하다.

**문제1)**

employee 테이블에서 직원의 사번(empno), 이름(name), 직업(job)을 출력한다.

```json
mysql> show tables;
+-----------------------+
| Tables_in_connectdb   |
+-----------------------+
| bonus                 |
| department            |
| employee              |
| project               |
| project_participation |
| role                  |
| salarygrade           |
+-----------------------+
7 rows in set (0.00 sec)

mysql> desc employee;
+----------+--------------+------+-----+---------+-------+
| Field    | Type         | Null | Key | Default | Extra |
+----------+--------------+------+-----+---------+-------+
| empno    | int(11)      | NO   | PRI | NULL    |       |
| name     | varchar(10)  | YES  |     | NULL    |       |
| job      | varchar(9)   | YES  |     | NULL    |       |
| boss     | int(11)      | YES  | MUL | NULL    |       |
| hiredate | varchar(12)  | YES  |     | NULL    |       |
| salary   | decimal(7,2) | YES  |     | NULL    |       |
| comm     | decimal(7,2) | YES  |     | NULL    |       |
| deptno   | int(11)      | YES  | MUL | NULL    |       |
+----------+--------------+------+-----+---------+-------+
8 rows in set (0.00 sec)

mysql> select empno, name, job from employee;
+-------+--------+-----------+
| empno | name   | job       |
+-------+--------+-----------+
|  7369 | SMITH  | CLERK     |
|  7499 | ALLEN  | SALESMAN  |
|  7521 | WARD   | SALESMAN  |
|  7566 | JONES  | MANAGER   |
|  7654 | MARTIN | SALESMAN  |
|  7698 | BLAKE  | MANAGER   |
|  7782 | CLARK  | MANAGER   |
|  7788 | SCOTT  | ANALYST   |
|  7839 | KING   | PRESIDENT |
|  7844 | TURNER | SALESMAN  |
|  7876 | ADAMS  | CLERK     |
|  7900 | JAMES  | CLERK     |
|  7902 | FORD   | ANALYST   |
|  7934 | MILLER | CLERK     |
+-------+--------+-----------+
14 rows in set (0.00 sec)

mysql> select empno 사번, name 이름, job 직업 from employee;
+------+--------+-----------+
| 사번 | 이름   | 직업      |
+------+--------+-----------+
| 7369 | SMITH  | CLERK     |
| 7499 | ALLEN  | SALESMAN  |
| 7521 | WARD   | SALESMAN  |
| 7566 | JONES  | MANAGER   |
| 7654 | MARTIN | SALESMAN  |
| 7698 | BLAKE  | MANAGER   |
| 7782 | CLARK  | MANAGER   |
| 7788 | SCOTT  | ANALYST   |
| 7839 | KING   | PRESIDENT |
| 7844 | TURNER | SALESMAN  |
| 7876 | ADAMS  | CLERK     |
| 7900 | JAMES  | CLERK     |
| 7902 | FORD   | ANALYST   |
| 7934 | MILLER | CLERK     |
+------+--------+-----------+
14 rows in set (0.00 sec)
```

concat 문자열 합침

```json
mysql> select concat('안녕하세요', '최도아라고', '합니다.') as hello;
+-----------------------------+
| hello                       |
+-----------------------------+
| 안녕하세요최도아라고합니다. |
+-----------------------------+
1 row in set (0.00 sec)

mysql> select concat(empno, '-', deptno) as '사번-부서번호' from employee;
+---------------+
| 사번-부서번호 |
+---------------+
| 7782-10       |
| 7839-10       |
| 7934-10       |
| 7369-20       |
| 7566-20       |
| 7788-20       |
| 7876-20       |
| 7902-20       |
| 7499-30       |
| 7521-30       |
| 7654-30       |
| 7698-30       |
| 7844-30       |
| 7900-30       |
+---------------+
14 rows in set (0.00 sec)

mysql> select deptno from employee;
+--------+
| deptno |
+--------+
|     10 |
|     10 |
|     10 |
|     20 |
|     20 |
|     20 |
|     20 |
|     20 |
|     30 |
|     30 |
|     30 |
|     30 |
|     30 |
|     30 |
+--------+
14 rows in set (0.00 sec)
```

**문제2)**

사원 테이블의 모든 부서번호를 출력하되, 중복되는 값을 제외하고 출력한다.

```json
mysql> select deptno from employee;
+--------+
| deptno |
+--------+
|     10 |
|     10 |
|     10 |
|     20 |
|     20 |
|     20 |
|     20 |
|     20 |
|     30 |
|     30 |
|     30 |
|     30 |
|     30 |
|     30 |
+--------+
14 rows in set (0.00 sec)

mysql> select distinct deptno from employee;
+--------+
| deptno |
+--------+
|     10 |
|     20 |
|     30 |
+--------+
3 rows in set (0.01 sec)

-> distinct 키워드, 중복되는 값을 제외합니다.
mysql> select distinct deptno 부서번호 from employee;
+----------+
| 부서번호 |
+----------+
|       10 |
|       20 |
|       30 |
+----------+
3 rows in set (0.00 sec)
```

## Order by 정렬

```json
mysql> select empno, name from employee order by name;
+-------+--------+
| empno | name   |
+-------+--------+
|  7876 | ADAMS  |
|  7499 | ALLEN  |
|  7698 | BLAKE  |
|  7782 | CLARK  |
|  7902 | FORD   |
|  7900 | JAMES  |
|  7566 | JONES  |
|  7839 | KING   |
|  7654 | MARTIN |
|  7934 | MILLER |
|  7788 | SCOTT  |
|  7369 | SMITH  |
|  7844 | TURNER |
|  7521 | WARD   |
+-------+--------+
14 rows in set (0.00 sec)

-> 뒤에서부터 정렬
mysql> select empno, name from employee order by name desc; 
+-------+--------+
| empno | name   |
+-------+--------+
|  7521 | WARD   |
|  7844 | TURNER |
|  7369 | SMITH  |
|  7788 | SCOTT  |
|  7934 | MILLER |
|  7654 | MARTIN |
|  7839 | KING   |
|  7566 | JONES  |
|  7900 | JAMES  |
|  7902 | FORD   |
|  7782 | CLARK  |
|  7698 | BLAKE  |
|  7499 | ALLEN  |
|  7876 | ADAMS  |
+-------+--------+
14 rows in set (0.00 sec)
```

**문제3**

```json
mysql> select empno, name, job from employee order by name;
+-------+--------+-----------+
| empno | name   | job       |
+-------+--------+-----------+
|  7876 | ADAMS  | CLERK     |
|  7499 | ALLEN  | SALESMAN  |
|  7698 | BLAKE  | MANAGER   |
|  7782 | CLARK  | MANAGER   |
|  7902 | FORD   | ANALYST   |
|  7900 | JAMES  | CLERK     |
|  7566 | JONES  | MANAGER   |
|  7839 | KING   | PRESIDENT |
|  7654 | MARTIN | SALESMAN  |
|  7934 | MILLER | CLERK     |
|  7788 | SCOTT  | ANALYST   |
|  7369 | SMITH  | CLERK     |
|  7844 | TURNER | SALESMAN  |
|  7521 | WARD   | SALESMAN  |
+-------+--------+-----------+
14 rows in set (0.00 sec)

mysql> select empno as 사번, name as 이름, job as 직업 from employee order by 이름;
+--------+--------+-----------+
| 사번   | 이름   | 직업      |
+--------+--------+-----------+
|   7876 | ADAMS  | CLERK     |
|   7499 | ALLEN  | SALESMAN  |
|   7698 | BLAKE  | MANAGER   |
|   7782 | CLARK  | MANAGER   |
|   7902 | FORD   | ANALYST   |
|   7900 | JAMES  | CLERK     |
|   7566 | JONES  | MANAGER   |
|   7839 | KING   | PRESIDENT |
|   7654 | MARTIN | SALESMAN  |
|   7934 | MILLER | CLERK     |
|   7788 | SCOTT  | ANALYST   |
|   7369 | SMITH  | CLERK     |
|   7844 | TURNER | SALESMAN  |
|   7521 | WARD   | SALESMAN  |
+--------+--------+-----------+
14 rows in set (0.00 sec)
```

as랑 as 없이 사용하는 거랑 차이가 없는 듯;;

**문제3**

employee 테이블에서 직원의 사번, 이름, 직업을 출력한다. 단 이름 기준으로 내림차순으로 정렬한다.

```json
mysql> select empno, name, job from employee order by name desc;
+-------+--------+-----------+
| empno | name   | job       |
+-------+--------+-----------+
|  7521 | WARD   | SALESMAN  |
|  7844 | TURNER | SALESMAN  |
|  7369 | SMITH  | CLERK     |
|  7788 | SCOTT  | ANALYST   |
|  7934 | MILLER | CLERK     |
|  7654 | MARTIN | SALESMAN  |
|  7839 | KING   | PRESIDENT |
|  7566 | JONES  | MANAGER   |
|  7900 | JAMES  | CLERK     |
|  7902 | FORD   | ANALYST   |
|  7782 | CLARK  | MANAGER   |
|  7698 | BLAKE  | MANAGER   |
|  7499 | ALLEN  | SALESMAN  |
|  7876 | ADAMS  | CLERK     |
+-------+--------+-----------+
14 rows in set (0.00 sec)
```

## Table 생성

```json
mysql> create table employee2(
    -> empno integer not null primary key,
    -> name varchar(10),
    -> job varchar(9),
    -> boss integer,
    -> hiredate varchar(12),
    -> salary decimal(7, 2),
    -> comm decimal(7, 2),
    -> deptno integer);
Query OK, 0 rows affected (0.03 sec)

mysql> create table book(
    -> isbn varchar(10) primary key,
    -> title varchar(20) not null,
    -> price integer not null);
Query OK, 0 rows affected (0.04 sec)

mysql> desc book;
+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| isbn  | varchar(10) | NO   | PRI | NULL    |       |
| title | varchar(20) | NO   |     | NULL    |       |
| price | int(11)     | NO   |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

mysql> desc employee2;
+----------+--------------+------+-----+---------+-------+
| Field    | Type         | Null | Key | Default | Extra |
+----------+--------------+------+-----+---------+-------+
| empno    | int(11)      | NO   | PRI | NULL    |       |
| name     | varchar(10)  | YES  |     | NULL    |       |
| job      | varchar(9)   | YES  |     | NULL    |       |
| boss     | int(11)      | YES  |     | NULL    |       |
| hiredate | varchar(12)  | YES  |     | NULL    |       |
| salary   | decimal(7,2) | YES  |     | NULL    |       |
| comm     | decimal(7,2) | YES  |     | NULL    |       |
| deptno   | int(11)      | YES  |     | NULL    |       |
+----------+--------------+------+-----+---------+-------+
8 rows in set (0.00 sec)
```

## 테이블 추가 및 삭제, 변경

```json
mysql> alter table book
    -> add author varchar(20);
Query OK, 0 rows affected (0.06 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> desc book;
+--------+-------------+------+-----+---------+-------+
| Field  | Type        | Null | Key | Default | Extra |
+--------+-------------+------+-----+---------+-------+
| isbn   | varchar(10) | NO   | PRI | NULL    |       |
| title  | varchar(20) | NO   |     | NULL    |       |
| price  | int(11)     | NO   |     | NULL    |       |
| author | varchar(20) | YES  |     | NULL    |       |
+--------+-------------+------+-----+---------+-------+
4 rows in set (0.00 sec)

mysql> alter table book
    -> drop price;
Query OK, 0 rows affected (0.06 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> alter table book change author author_cg varchar(30) not null;
Query OK, 0 rows affected (0.07 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> alter table book change author author_cg varchar(30) not null;
Query OK, 0 rows affected (0.07 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> alter table employee2
    -> change deptno dept_no int(11);
Query OK, 0 rows affected (0.01 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> desc employee2;
+----------+--------------+------+-----+---------+-------+
| Field    | Type         | Null | Key | Default | Extra |
+----------+--------------+------+-----+---------+-------+
| empno    | int(11)      | NO   | PRI | NULL    |       |
| name     | varchar(10)  | YES  |     | NULL    |       |
| job      | varchar(9)   | YES  |     | NULL    |       |
| boss     | int(11)      | YES  |     | NULL    |       |
| hiredate | varchar(12)  | YES  |     | NULL    |       |
| salary   | decimal(7,2) | YES  |     | NULL    |       |
| comm     | decimal(7,2) | YES  |     | NULL    |       |
| dept_no  | int(11)      | YES  |     | NULL    |       |
+----------+--------------+------+-----+---------+-------+
8 rows in set (0.00 sec)
```

## 테이블명 변경

```json
mysql> alter table employee2 rename employee3;
Query OK, 0 rows affected (0.02 sec)

mysql> show tables;
+-----------------------+
| Tables_in_connectdb   |
+-----------------------+
| bonus                 |
| book                  |
| department            |
| employee              |
| employee3             |
| project               |
| project_participation |
| role                  |
| salarygrade           |
+-----------------------+
9 rows in set (0.00 sec)
```

**문제4**

테이블 삭제 실습, employee2 테이블을 삭제하라

→ employee3 로 변경되었던 테이블을 employee2 로 바꾼 후에 삭제

```json
mysql> show tables;
+-----------------------+
| Tables_in_connectdb   |
+-----------------------+
| bonus                 |
| book                  |
| department            |
| employee              |
| employee3             |
| project               |
| project_participation |
| role                  |
| salarygrade           |
+-----------------------+
9 rows in set (0.00 sec)

mysql> alter table employee3 rename employee2;
Query OK, 0 rows affected (0.01 sec)

mysql> desc employee2;
+----------+--------------+------+-----+---------+-------+
| Field    | Type         | Null | Key | Default | Extra |
+----------+--------------+------+-----+---------+-------+
| empno    | int(11)      | NO   | PRI | NULL    |       |
| name     | varchar(10)  | YES  |     | NULL    |       |
| job      | varchar(9)   | YES  |     | NULL    |       |
| boss     | int(11)      | YES  |     | NULL    |       |
| hiredate | varchar(12)  | YES  |     | NULL    |       |
| salary   | decimal(7,2) | YES  |     | NULL    |       |
| comm     | decimal(7,2) | YES  |     | NULL    |       |
| dept_no  | int(11)      | YES  |     | NULL    |       |
+----------+--------------+------+-----+---------+-------+
8 rows in set (0.00 sec)

mysql> drop table employee2;
Query OK, 0 rows affected (0.01 sec)
```

## SQL join

여러 테이블을 하나의 가상 단일 테이블로 만드는 것

가장 중요한 기능이 join.

join이 구체적으로 어떻게 동작하는가?

- 테이블을 분리하는 법
- 분리된 테이블을 합성햇 하나의 테이블로 만드는 법
- join의 종류와 사용방법
    - inner join
    - left outer join, right outer join
    - full outer join

## SQL join 연습장

URL : http://bit.ly/join-exec

**SQL-join visualizer**

[https://sql-joins.leopard.in.ua/](https://sql-joins.leopard.in.ua/)

벤다이어그램으로 표현, 어떤 경우에 어떤 join을 사용할 수 있는지 알 수 있음

**left join**

```json
SELECT * FROM TableA A LEFT JOIN TableB B ON A.key = B.key WHERE B.key IS NULL
```
SELECT * FROM topic

SELECT * FROM topic LEFT JOIN author ON topic.author_id = author.aid

SELECT * FROM topic LEFT JOIN author ON topic.author_id = author.aid LEFT JOIN profile ON author.profile_id = profile.pid;

SELECT tid, topic.title, author_id, name, profile.title AS job_title FROM topic LEFT JOIN author ON topic.author_id = author.aid LEFT JOIN profile ON author.profile_id = profile.pid;

SELECT tid, topic.title, author_id, name, profile.title AS job_title FROM topic LEFT JOIN author ON topic.author_id = author.aid LEFT JOIN profile ON author.profile_id = profile.pid WHERE aid = 1;


**right join**

```json
SELECT * FROM TableA A RIGHT JOIN TableB B ON A.key = B.key WHERE A.key IS NULL
```

**inner join**

```json
SELECT * FROM TableA A INNER JOIN TableB B ON A.key = B.key
```

**full outer join - 많이 사용하지 않음**

```json
SELECT * FROM TableA A FULL OUTER JOIN TableB B ON A.key = B.key WHERE A.key IS NULL OR B.key IS NULL
```

## Reference

- 생활코딩 SQL join
- 부스트코스 SQL
