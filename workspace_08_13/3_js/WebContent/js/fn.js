/**
*
*/


console.log("fn.js log");
let name = "홍길동";
let flag =  true<10; //false 0  true 1 
let now = new Date();
let num = 99;
const pi = 3.14;

/*자바스크립트 함수는 일급함수
-함수를 값으로 다룰 수 있다.
-변수에 함수를 담을 수 있다.ex(const log=console.log;)
-함수의 결과값 리턴값으로 사용가능
-함수의 인자로 사용가능
*/

const log = console.log;

function f1(){
	alert("hello javascript~~~~~");
}

const f2 = f1;

const f3 = () => alert("hello javascript~~~~~");//람다

const f4 = (i) => alert(i);

function sum(a,b,c){
	if(!c) c=0;
	return a+b+c;
}
function sumAll() {//arguments
	let sum=0;
	for(let i=0;i<arguments.length;i++){
		sum +=arguments[i];
	}
	return sum;
}

function small(a,b){
	if(a>b) return b;
	else return a; 
}
	const min = (a,b) => a>b? b : a; //작은수 리턴

function callback(){
	log('callback');//콜백 찍어줌
}

function callTenTimes(fn){
	for(let i=0;i<3;i++){
		try{
			fn();// 반복수행
	}catch(e){
		log('함수 이름을 넘겨 주세요');
		
	}

}
}


//callTenTimes(callback);
//callTenTimes(function(){
//	log('~~~~~');
//});
//callTenTimes(()=>alert('~~~~~'));

//let fc;
//callTenTimes(fc = ()=> alert('~~~~~~'));
	
//let intervalId = setInterval(callback,3000);//3초간격으로 콜백 찍어줌
//clearInterval(intervalId) //멈춤

//	let id2 = setInterval(function() {
//		
//		log(new Date());
//	}, 1000)//세미콜론생략도가능
//	
//	
//	setTimeout(function() {
//		clearInterval(id2)		
//		//location.href="http://www.naver.com";//5초 후 네이버
//		//location.href="http://localhost:8000/2_css/submenu/index.html";
//	}, 5000);
//	
	
	function fa(){
		let data=0;
		function inner(){
			return ++data;
		}
		return inner;
	}
	
	let ff1=fa;
	
	let ff2=fa();//증가
	
	//자바스크립트 클로저
	ff1()()
	ff1()()
	ff1()()
	ff1()()
	ff1()()
	ff1()()//계속 1
ff2()
ff2()
ff2()
ff2()//증가

let fb1 = function fb(){
		let data=0;
		function inner(){
			return ++data;
			}
		return inner;
	};
	let fb2 = function fb(){
		let data=0;
		function inner(){
			return ++data;
			}
		return inner;
	}();//공유해서쓸수있음 웹브라우저 끌떄까지 살아있음 
	
	