	create table users( 
	id varchar2(8) primary key,
	password varchar2(12),
	name varchar2(8) ,
	role varchar2(5) default 'user'
	);
	
	
	
	create table board( 
 	seq number(5) primary key,
	title varchar2 (50) not null,
     content varchar2(500) not null,    
     regdate date default sysdate,
     cnt number(10) check (cnt>0),  
     id varchar2(8) ,
     foreign key(id) references users
     );
     
     create sequence board_seq;
     
     
     회원 등록
     insert into users(id,password,name,role)
values ('mini1','1234','민희1',default);
     insert into users(id,password,name,role)
values ('mini2','5678','민희2',default);
     insert into users(id,password,name,role)
values ('mini3','4321','민희3',default);
     insert into users(id,password,name,role)
values ('mini4','8765','민희4',default);
     insert into users(id,password,name,role)
values ('mini5','1357','민희5','admin');

	회원 수정
	update users
	set password ='1111'
	where id='mini1';
	
	
	로그인
	select id,password from users where id='mini1' and password='1234';
	select id,password from users where id='mini2' and password='5678';
	select id,password from users where id='mini3' and password='4321';
	select id,password from users where id='mini4' and password='8765';
	select id,password from users where id='mini5' and password='1357';
	
	
	
	게시판 글 등록
	insert into board(seq,title,content,regdate,cnt,id)
	values(board_seq.nextval,'1','~~~~~~~~~~~~',default,1,'mini1');
	insert into board(seq,title,content,regdate,cnt,id)
	values(board_seq.nextval,'2','~~~~~~~~~~~~',default,1,'mini1');
	insert into board(seq,title,content,regdate,cnt,id)
	values(board_seq.nextval,'3','~~~~~~~~~~~~',default,1,'mini1');
	insert into board(seq,title,content,regdate,cnt,id)
	values(board_seq.nextval,'4','~~~~~~~~~~~~',default,1,'mini1');
	insert into board(seq,title,content,regdate,cnt,id)
	values(board_seq.nextval,'5','~~~~~~~~~~~~',default,1,'mini2');
	insert into board(seq,title,content,regdate,cnt,id)
	values(board_seq.nextval,'6','~~~~~~~~~~~~',default,1,'mini2');
	insert into board(seq,title,content,regdate,cnt,id)
	values(board_seq.nextval,'7','~~~~~~~~~~~~',default,1,'mini2');
	insert into board(seq,title,content,regdate,cnt,id)
	values(board_seq.nextval,'8','~~~~~~~~~~~~',default,1,'mini2');
	insert into board(seq,title,content,regdate,cnt,id)
	values(board_seq.nextval,'9','~~~~~~~~~~~~',default,1,'mini3');
	insert into board(seq,title,content,regdate,cnt,id)
	values(board_seq.nextval,'10','~~~~~~~~~~~~',default,1,'mini3');
	insert into board(seq,title,content,regdate,cnt,id)
	values(board_seq.nextval,'11','~~~~~~~~~~~~',default,1,'mini3');
	insert into board(seq,title,content,regdate,cnt,id)
	values(board_seq.nextval,'12','~~~~~~~~~~~~',default,1,'mini3');
	insert into board(seq,title,content,regdate,cnt,id)
	values(board_seq.nextval,'13','~~~~~~~~~~~~',default,1,'mini4');
	insert into board(seq,title,content,regdate,cnt,id)
	values(board_seq.nextval,'14','~~~~~~~~~~~~',default,1,'mini4');
	insert into board(seq,title,content,regdate,cnt,id)
	values(board_seq.nextval,'15','~~~~~~~~~~~~',default,1,'mini4');
	insert into board(seq,title,content,regdate,cnt,id)
	values(board_seq.nextval,'16','~~~~~~~~~~~~',default,1,'mini4');
	insert into board(seq,title,content,regdate,cnt,id)
	values(board_seq.nextval,'17','~~~~~~~~~~~~',default,1,'mini5');
	insert into board(seq,title,content,regdate,cnt,id)
	values(board_seq.nextval,'18','~~~~~~~~~~~~',default,1,'mini5');
	insert into board(seq,title,content,regdate,cnt,id)
	values(board_seq.nextval,'19','~~~~~~~~~~~~',default,1,'mini5');
	insert into board(seq,title,content,regdate,cnt,id)
	values(board_seq.nextval,'20','~~~~~~~~~~~~',default,1,'mini5');

	
	글 수정
	update board
	set title='1',content='zzzzzzzzzzzzz'
	where id='mini1'and title='1';
	
	
	게시판 글 삭제
	delete 
	from board
	where id='mini1' and title='1';
	
	
	데이터 검색
	select title
	from board
	where  lower(title)=lower('1');
	
	
	전체 등록글 수
	select board_seq.curval from dual;
	
	사용자별 등록글 수
	select count(title)
	from board
	where id='mini1';
	
	
	월별 게시글 수
	select substr(regdate,4,2) ab달,count(title) 글작성수 from board where id= 'a2' group by substr(regdate,4,2) order by 1;
	
	사용자별 게시글 검색
	select title from board where id='mini1';
	
	
	제목으로 게시글 검색
	select title from board where lower(title)=lower('1');
	
	















	
	
	create table customer(
	custid number primary key,
	name varchar2(40),
	address varchar2(40),
	phone varchar2(30)
	);
	
	
	create table orders(
	orderid number primary key,
	custid number not null,
	foreign key(custid) references customer on delete cascade,
	bookid number not null,
	saleprice number,
	orderdate date
	);






