create database todo;

/*루트 계정에서 아래 명령어 수행*/
grant all privileges on todo.* to connectuser@'%';
flush privileges;

use todo;

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

update todo set type = 'DOING' where id = 1; 
update todo set type = 'DONE' where id = 1;
delete from todo where sequence=17; 

select id, title, name, sequence, type, regdate from todo where type = 'TODO' order by regdate desc;

/*프로젝트 */

/*목록출력 */
select id, title, name, sequence, type, regdate from todo order by regdate desc; 

/*단계 */
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

