/**
 *  자바스크립트 객체
 */

const log = console.log;

let array = ['가','다','하','나'];

array[4]='~~~~';
array.pop()/*끝부터보여줌*/
array.push('A')/*데이터추가*/

//array.forEach(i=>log(i))
//array.forEach(i=>document.write("<h4>"+i+"</h4>"))

//array.filter(i => i>'다').forEach(i=>log(i))


//자바스크립트 객체  : 싱글톤
/*
let student = {
	name:"홍길동",
	ko:99,
	eng:100,
	sum:function(){
		return this.ko+this.eng;
	},
	avg:function(){
		return this.sum()/2;
	}
}
student["name"]
student.name
student.avg()
student.address='서울'
	
delete student.address
//delete student.sum
for(let data  in student){
	log(student[data]);
}
*/
/* this 생략시 error
let student = {
		name:"홍길동",
		ko:99,
		eng:100,
		sum:function(){
			return ko+eng;
		},
		avg:function(){
			return sum()/2;
		}
}
let student = {
	name:"홍길동",
	ko:99,
	eng:100,
	
	avg:function(){
		return this.sum()/2;
	}
}
*/

/*
let product = [
	{name:"바나나",price:700 },
	{name:"체리",price:1700 },
	{name:"사과",price:900 },
	{name:"배",price:5000 },
	{name:"수박",price:17000 }
];
product[0].name
product[0]["name"]
product[0].price
for(let data  in product){
	log(product[data])
	for(let d  in product[data]){
		log(product[data][d])
	}
}
function print_product(data){
	log(data.name,"::",data.price)
}
print_product(product[0])
for(let data  in product){
	print_product(product[data]);
}
*/

//자바스크립트 객체 => 생성자 함수를 통한 객체 생성 
// 객체는 자신만의 데이터를 가지며 , 
// 함수는 공유하도록 설계 한다.  => prototype

function Student(name,ko,eng){
	this.name = name;
	this.ko=ko;
	this.eng=eng;
}

Student.prototype.sum=function(){
	return this.ko+this.eng;
}

Student.prototype.avg=function(){
	return this.sum()/2;
}

let s1 = new Student("홍길동", 90, 77);
let s2 = new Student("고길동", 99, 97);
let s3 = new Student("박길동", 69, 57);

/*
s1.grade =function(){
	return this.avg() > 80 ? 'A' :'B';
}
*/
//s2,s3도 쓰게하고싶다면 프로토타입

Student.prototype.grade =function(){
	return this.avg() > 80 ? 'A' :'B';
}

//log(s1.name,"/",s1.avg(),"/",s1.grade());
//log(s2.name,"/",s2.avg(),"/",s2.grade());
//log(s3.name,"/",s3.avg(),"/",s3.grade());

/*
Object.prototype.grade =function(){
	return this.avg() > 80 ? 'A' :'B';
}
*/


let students = [
	new Student("홍길동", 90, 77),
	new Student("고길동", 99, 97),
	new Student("박길동", 69, 57),
	new Student("이길동", 89, 77),
	new Student("강길동", 59, 97),
	new Student("나길동", 99, 27)
];
/*
let testin;
let testof;
for(let data  in students){
	testin = data;
	log(students[data].name," / ",students[data].avg());
}
//인덱스
log(' students 평균 리스트 ')
for(let data  of students){
	testof = data;
	log(data.name," / ",data.avg());
}
*/
//데이터
log(s1.toString())
//오브젝트 찍힘
/*
s1.toString = function(){
	return this.name+"::"+this.avg()+"::";
}
*/

Student.prototype.toString = function(){
	return this.name+"::"+this.avg();
}

log(s1.toString())//홍길동::83.5
log(s2.toString())

for(let data  of students){
	log(data.toString());
}



students.forEach(i=>log(i.toString()));
students.forEach(i=>log("foreach : "+i.name+":"+i.avg()));
