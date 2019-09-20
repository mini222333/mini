#################################
Table 생성 DDL (auto commit)  취소안됨

테이블은 실제로 데이터들이 저장되는 곳이라고 생각하면 쉽게 이해할 수 있으며,
CREATE TABLE 명령어를 이용해서 테이블을 생성할 수 있다.
#################################



drop table book; --삭제 복구x

create table book( 
	bookno number(5),
	title varchar2(30),
	author varchar2(30),
	pubdate date
	); --생성


	
	
	
	
	
	
	dml
select * from book;

insert into book values(1,'java','kim',sysdate);	
insert into book values(2,'jsp','홍',sysdate);
insert into book values(2,'jsp','홍',sysdate);
insert into book values(2,'jsp','홍','19/02/02');


commit; --확정 취소불가능
rollback;--취소.오토커밋후까지


insert into book (bookno,title) values(3,'db');
insert into book (bookno,title,author,pubdate)
values(4,'db',null,null);


delete from book;
rollback;
delete from book where title='db';
delete from book where author is null;
delete from book where author ='홍';

desc book; --테이블 구조


ddl --오토커밋.위 자동으로 커밋처리됨
alter table book add(price number(7)); --구조변경 컬럼추가

insert into book (bookno,title,author,pubdate,price)
values(4,'db',null,null,900);


--데이터수정 update

update book set price=10; --전부 갱신


update book set price=1000.99;-- 반올림처리
commit;
rollback;

update book set price=900 where title='db'; --조건
select * from book;

update book set author='~~~~~~~', price=900, pubdate=sysdate where bookno=3;

ddl
update book set price=null;
alter table book modify(price number(7,2)); --실수형
update book set price=1000.99;
commit;

alter table book drop column price; --롤백x



#########################################
drop table book;
create table book( 
	bookno number(5),
	title varchar2(30),
	author varchar2(30),
	pubdate date
	);
alter table book add
alter table book modify
alter table book drop column price
rename book to book2;
rename book2 to book;



insert into book (bookno,title,author,pubdate) values(4,)
delete from book where author = '홍';
update book set author='~~~~~~~~~~~', price=900,pubdate=sysdate where bookno=3;


delete from book; --rollback 가능
truncate table book; auto commit;--복구불가능
drop table book; auto commit;

select * from book;
#########################################

select * from emp;
select * from dept;


create table emp2 as select * from emp;
create table dept2 as select * from dept;--제약조건은 카피안됨


insert into dept(deptno,dname,loc) values(50,'EDU','SEOUL');
insert into dept2 values(50,'EDU','SEOUL');
commit;

insert into dept values(10,'EDU','SEOUL');--제약조건에 걸려서 안됨	
insert into dept2 values(10,'EDU','SEOUL');--제약조건 x




insert into emp(empno,ename,hiredate,sal,deptno) values(9999,'홍길동',sysdate,0,40); --제약조건 emp는 90 안됨

insert into emp2(empno,ename,hiredate,sal,deptno)
values(9999,'홍길동',sysdate,0,90); --제약조건x 들어감




drop table book;
create table book( 
	bookno number(5) constraint scott_book_pk primary key ,--제약조건 이름 부여
	title varchar2(30) constraint scott_book_title_unique unique, --중복x nullo
	author varchar2(30),
	price number(7,2) constraint scott_book_price_check check (price>0),
	pubdate date default sysdate
	);


insert into book (bookno,title,author,price,pubdate)
values (1,'db','홍길동',900,sysdate);
insert into book (bookno,title,author,price,pubdate)
values (2,'jsp','홍길동',22000,sysdate);

insert into book (bookno,title,author,price,pubdate)
values (3,'java','김길동',32000,default);

commit;


select CONSTRAINT_name
from user_cons_columns
where table_name='BOOK';





drop table book;
create table book( 
	bookno number(5) ,
	title varchar2(30) unique, 
	author varchar2(30),
	price number(7,2) check (price>0),
	pubdate date default sysdate
	);

	
	
	alter table book add constraint book_bookno_pk primary key(bookno);
	alter table book drop constraint book_bookno_pk;
	
	insert into book (bookno,title,author,price,pubdate)
	values(1,null,'김길동',32000,default);
	
	insert into book (bookno,title,author,price)
	values(1,null,'김길동',32000);
	
	
	
	
	select * from book;
	commit;
	
	select CONSTRAINT_name
	from user_cons-columns
	where table_name='BOOK';
	########################################
	emp dept
	########################################
	delete from dept where deptno=50;
	
	drop table dept2;
	create table dept2 as select * from dept;
	alter table dept2 add constraint dept2_pk primary key(deptno);
	
	drop table emp2;
	create table emp2 as select * from emp;	
	alter table emp2 add constraint emp2_pk primary key(empno);
	alter table emp2 add foreign key(deptno) references dept2;
	alter table emp2 add foreign key(mgr) references emp2;
	
	alter table emp2 add constraint emp2_fk_mgr foreign key(mgr) references emp2;
	alter table emp2 add constraint emp2_fk1 foreign key (deptno) references dept2;
	delete from dept2 where deptno=20;--x 삭제 안됨
	
	alter table emp2 drop constraint emp2_fk1; --삭제
	
	
	alter table emp2
	add constraint emp2_fk1
	foreign key(deptno) references dept2 on delete set null; --제약조건 추가 삭제되는대신 null
	
	
	delete from dept2 where deptno=20;--o 20>null
	
	select * from emp2;
	
	rollback;
	
	alter table emp2 drop constraint emp2_fk1;
	
	
    alter table emp2
	add constraint emp2_fk1
	foreign key(deptno) references dept2 on delete cascade;
	
	delete from dept2 where deptno=20;
	--20 싹 삭제됨.연결삭제
	--삭제되고 자식 튜플도 삭제
	rollback;
	
	
	select * from dept2;
	insert into dept2 values(50,'EDU','SEOUL');
	
	select * from emp2;
	insert into emp2 (empno,ename,hiredate,sal,deptno)
	values(9999,'홍길동',sysdate,0,50);
	
	insert into emp2 (empno,ename,hiredate,sal,deptno)
	values(7777,'고길동',sysdate,0,null);
	
insert into emp2 (empno,ename,hiredate,sal,deptno,mgr)
	values(8888,'이길동',sysdate,0,null,10);	
	
	drop table emp2;
	drop table dept2 cascade CONSTRAINT;

## 트랜잭션 ##
create table emp2 as select * from emp;
select * from emp2;

sqlplus 창1
delete from emp2 where deptno=10;

sqlplus 창2
update emp2 set comm=0 where deptno=10;

block 되는거 확인 => 창1에서 commit or rollback 명령 수행하면 lock 풀림

