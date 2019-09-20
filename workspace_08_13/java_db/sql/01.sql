/*오라클 데이타베이스는 기본계정(hr)을 준다 근대 락이 걸려서 아래실행문은 그 락을 푸는 과정
 *cmd -> sqlplus system/1234 로 sql관리자에 로긴하고 아래 명령을 복붙한다. 
 *새로운 cmd창을 열어서 sqlplus hr/hr로 로긴한다.
 *그 후 select * from tab;을 입력해서 오라클에서 제공하는 테이블을 확인했다.
 *
 *오라클의 경우 사용자이름=스키마 이다. ->계정을 생성하고 그안에 테이블을 만듬
 *mysql은 데이터베이스=스키마 이다. ->데이터베이스를 만들고 그 안에 테이블을 만든다. 
 *
 *데이터베이스에서는 현신세계의 모든것을 테이블화 
 *
 *데이타베이스 모델링  : 현실세계에서 일어나는 현상이나 객체들을 테이블화하는거 ->가장 중요한 작업 
 *프로젝트 : 현실 세계의 업무를 컴퓨터 시스템으로 옮겨 놓는 과정
 */

alter user hr identified by hr account unlock;

sqlplus hr/hr
select * from tab;


--tablespace 생성
create tablespace bit 
datafile 'c:\lib\bit.dbf'
size 30M
autoextend on next 2M maxsize UNLIMITED;


--계정 생성 test01/1234
create user SCOTT identified by TIGER
default tablespace bit; --계정을 만들면 bit에 저장


-- 권한 부여 test01/1234
grant connect to test01;
revoke connect from test01; --권한 뺏기
grant connect,resource to test01;


--계정 삭제
drop user test01 cascade;

--계정 변경
conn


GRANT CONNECT RESOURCE TO SCOTT INDENIFIED BY TIGER;

ALTER USER SCOTT DEFAULT TABLESPACE bit;
ALTER USER SCOTT TEMPORARY TABLESPACE TEMP;

@c:\lib\scott.sql;


show linesize;
set linesize 300;

show pagesize;
set pagesize 20;