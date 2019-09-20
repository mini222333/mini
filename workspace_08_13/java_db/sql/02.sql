--select ~from~ ->select문 기본문법
select * from employees;

select * from emp;
select * from dept;
select ename,hiredate from emp;
select ENAME,HIREDATE  from EMP;
SELECT ENAME,HIREDATE  FROM EMP;

select ename,sal,comm  from emp;
select ename,sal,sal*12,comm  from emp; --검색할때 연산조건을 넣어서 검색해도 조건에 맞게끔 연산돼어 검색된다.
select ename,sal,sal*12 as 년봉,comm  from emp; -- as는 한 속성에 이름을 부여하는 것 ->별칭이라고 함 =>별칭으로 붙은 검색결과가 나옴
select ename,sal,sal*12 as "년   봉",comm  from emp; --이때말고는 문자열 ''처리 as에서만 "" 사용 가능

desc dept; --dept 테이블의 요약정보를 보여줌.구조  볼수있음


select dname,loc from dept;
conn hr/hr
select * from employees;
select first_name,job_id,department_id from employees;


conn SCOTT/TIGER

null을 포함한 산술식은 null
select empno, ename,sal,comm from emp;
select empno, ename,sal,comm , sal+comm from emp;
select empno, ename,sal,comm , sal+comm 월급여 from emp;
--null을 포함한 연산의 결과는 null이 나온다.
select empno, ename,sal,comm , nvl(comm,0), sal+nvl(comm,0) 월급여 from emp; --nvl함수 중요
select empno, ename,sal,comm , (sal+nvl(comm,0))*12 연봉 from emp; --nvl함수 중요
--nvl 의미 comm의 값이 null이면 0으로 바꿔줘 라는 의미 이다 즉 이녀석은 null을 0으로 바꿔서 출력해주는 함수이다.
--주의할 점은 comm의 데이터타입이다  즉 괄호 안(a,b) ->a,b의 데이터타입이 일치해야 한다 .

select empno, ename, mgr,deptno from emp;
select empno, ename, nvl(mgr,'CEO'),deptno from emp; --x mgr int 받는데 스트링 넣어서 에러.
select empno, ename, nvl(to_char(mgr),'CEO') as mgr,deptno from emp;--mgr을 문자열로 컨버팅하는 함수 to_char(mgr)

### 문자열 연결 연산자 ||
select empno, ename,deptno from emp;
select empno|| ' ' || ename||' '||deptno from emp; --붙어서 나오지말라고 띄어쓰기 삽입
select empno, ename,sal||'원' from emp; --결과에 원이 나오게 출력

## dual 가상의 테이블
select 10*24*24 from dept; --연산의 결과 를 출력 하는데 결과가 4번 나오는 문제가 생김 
select 10*24*24 from dual; --가상의 테이블

select sysdate from dual; --오늘 날짜 출력

##중복제거 (distinct)
select job from emp; --중복되는 결과도 나옴
select distinct job from emp; --중복이 제거되서 출력 , 검색하고 싶은 속성의 앞에 붙여준다 

select * from emp; --emp 전부 출력
select deptno from emp;
select distinct deptno from emp;


## row 제한 where 절 사용,별칭 사용 안됨

select 검색하고싶은 속성
from 테이블명
where 조건


select *
from emp
where deptno=10;
--10번 부서에 근무하는 사원 리스트


select *
from emp
where job='manager'; --x 대소문자 구분해서 안됨

## 대소문자 구분하지 않고 검색 가능 하도록 합니다.
select *
from emp
where upper(job)=upper('MANAGER');
--대문자 변환 upper() 소문자 변환 lower()

select sysdate from dual; --오늘 날짜 출력


select *
from emp
where hiredate = '81/09/28';
--81/09/28 입사한 사원

select *
from emp
where hiredate <> '81/09/28';
-- >는 '' 이후 입사한 사원 반대<도 가능
-- <> 는 !=과 같은 의미

select *
from emp
where hiredate != '81/09/28';


## between and 하한값 먼저 지정한다

select *
from emp
where sal >= 3000 and sal <= 5000;
--급여가 3천에서 5천인 사람 출력 

select *
from emp
where sal between 3000 and 5000;
-- 도 위의 명령과 같은 값이 출력 3천과5천을 포함한다<=,>=

select *
from emp
where sal between 5000 and 3000; --x 앞이 작은값 뒤가 큰값이 와야함



select *
from emp
where sal not between 3000 and 5000;
--조건이 아닌 것 출력


select *
from emp
where deptno=10 or deptno=20;
--10과 20인 것 출력

## 집합연산자 IN

select *
from emp
where deptno IN(10,20);
--위의 명령과 동일 

select *
from emp
where deptno not IN(10,20);
--10,20이 아닌 것 출력

select *
from dept
where (deptno,loc ) IN((10, 'DALLAS'),(30,'CHICAGO'));
--deptno가 10이면서 loc가 dallas이거나 30이면서 chicago인 것들 찾기
--in(and조건),or조건이 성립


## like 연산자
select *
from emp
where ename ='ALLEN';
--위의 조건은 ALLEN과 완전히 일치해야 한다.

select *
from emp
where ename like 'ALLEN';
-- 자바의 contains와 like는 비슷하다 즉 포함하고 있는 것 찾기 

select *
from emp
where ename like'S%';
--s로 시작하는것 출력
select *
from emp
where ename like'%S%';
--s 포함하는것 출력

select *
from emp
where lower(ename) like lower('%S%');

select *
from emp
where ename like'%M_T%';
--중간에 M 사이 모름 그뒤 T가 있는것 찾을때

##81년도에 입사한 사원 목록 추출
select *
from emp
where hiredate like '82%';
--82년도에 입사한 사람만 출력

## 이름이 A B C D 로 시작하는 사원의 목록
select *
from emp
where ename like 'A%' or ename like 'B%' or ename like 'C%' or ename like 'D%';
--가독성 떨어짐

##정규식 사용
select *
from emp
where regexp_like(ename, 'A|B|C|D');
--abcd를 포함하는 것들

select *
from emp
where regexp_like(ename, '[A-D]');
--위와 같음

select *
from emp
where regexp_like(ename, '^[A-D]');
-- ^[] 는 []안의 것들로 시작하는 것들을 출력해주는 정규식

select *
from emp
where regexp_like(ename, '[A-D]$');
--ABCD로 끝나는 것들만 출력해주는 정규식


## is null

	select *
	from emp
	where comm is null;
-- null을 골라내지 못함 



select *
from emp
where comm is not null;
--null은 =이 아닌 is로 검색한다  is와 is not 이 있다 

## row 제한 where 절 사용, 별칭 사용 안됨
select ename, sal,comm, sal+nvl(comm,0) total
from emp
where total>3000; --sal+val(comm,0)이 와줘야함
--안됨 이유 : total은 as로 속성의 이름을 바꿔 출력하는 별칭이므로 이 명령이 성립하려면 total 자리에 sal+nvl(comm,0)이 들어와야함


select ename, sal, comm, sal+nvl(comm,0) total
from emp
where deptno=20; 
-- select ~from 에서 ~안에 들어가있는 조건이 아니더라도 where절에 조건으로 들어갈 수 있다.

## 정렬 order by --기본적으로 오름차순
select ename, sal, comm,sal+nvl(comm,0) total,deptno
from emp
order by deptno; --오름차순. desc 붙이면 내림차순 deptno가 기준이 된다.


select ename, sal, comm,sal+nvl(comm,0) total,deptno
from emp
order by total;
--total 순으로 정렬


select ename, sal, comm,sal+nvl(comm,0) total,deptno
from emp
order by 2; --sal 순으로 정렬


select ename, sal, comm,sal+nvl(comm,0) total,deptno
from emp
order by deptno desc,total;
-- deptno는 내림차순으로 total은 오름차순으로 정렬돼 보여준다


##select문 순서

select *
from emp
where deptno = 30
order by sal;

select *
from emp
where deptno in (20,30)
order by sal;

select *
from emp
where deptno = any (20,30)
order by sal;
--위의 명령과 똑같은 결과

select *
from emp
where deptno != all (20,30) --=<>
order by sal;
--20과 30을 제외

select *
from emp
where deptno <> all (20,30) 
order by sal;

##내장함수 p204 single row function 리턴값o

select * from dept;
select dname,loc from dept;
select dname, lower(dname),loc,lower(loc) from dept; --소문자로 출력하는 열을 추가
--뒤에가면 프로시져를 만드는데 프로시져는 리턴값이 없는 실행만 한다 우리가 사용한 위 함수는 리턴값이 있다.

select round(45.5678) , trunc(45.5678) from dual;--앞은 반올림 되버리고 뒤는 소수점 이하를 다 잘라버림 
select round(45.5678,2) , trunc(45.5678,2) from dual;--소수점 이하 2자리 까지 위의 법칙을 적용



select sysdate, sysdate+30 from dual;-- 9월로 자동으로 넘어감 


select ename, hiredate from emp;

select ename, hiredate,substr(hiredate,1,2) 입사연도 from emp; --오라클은 인덱스 1부터 시작 --hiredate의 1번째부터 2개를 뽑으라는 의미 


select sysdate, to_char(sysdate, 'YYYY') from dual;
select sysdate, to_char(sysdate, 'YY') from dual;
select sysdate, to_char(sysdate, 'day') from dual;

## emp 테이블에서 사원들의 입사월을 출력해보세요
select ename, hiredate, to_char(hiredate,'mm') from emp;

select sysdate,to_date('2019/08/14') from dual;--sysdate 는 날짜형으로 인식하지만 ''는 문자형으로 인식한다 컴퓨터에게 날짜형인지 알려주려면
--to_date함수 안에 넣어줘야 한다. ex) to_date('2019/08/14')
select sysdate,to_date('08/14/19') from dual; --년도를 뒤로 빼는 나라도 있는데 이런식으로 하면 에러가 난다. 명확하게 알려줄 필요가 있다. 
select sysdate,to_date('08/14/2019','mm/dd/yy') from dual; -- 뒤에 형식으로 뭐가 뭔지 알려준다. 


## nvl() 함수 -- null과 연관이 있는 함수
select ename, mgr,comm from emp;
 select ename,mgr, nvl(to_char(comm),'_') from emp; --숫자타입을 문자타입으로 바꾸고 널을 _로처리함
 select ename,mgr,nvl(comm,0) from emp; --타입 일치 강조했음
 ##nvl2(a,b,c); --널인 경우와 널이 아닌 경우를 구분해서 사용하는 함수 널이 아니면 b 널이면 c 
 select ename,mgr,nvl2(comm,comm,0) from emp; --널이 아니면 그대로 널이면 0이 드가라는 의미 
 select ename,nvl2(to_char(mgr),'e','n'),nvl(comm,0) from emp;
 --상사코드가 있으면 e로 없으면 n으로 표시하게 했음  tochar해준 이유는 숫자타입의 속성이라 문자타입으로 바꿔준 후 문자타입으로 표시
 
 ##decode 함수 if elseif~ 와 비슷
 select ename ,sal , deptno,decode(deptno,10,sal*1,20,sal*2,30,sal*3,sal) 계산 from emp;
 --deptno가 10이라면 *1 20이라면 *2 30이라면 *3하라는 의미