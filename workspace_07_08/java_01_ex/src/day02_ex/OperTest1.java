  
package day02_ex;

class OperTest1{
	public static void main(String[] args){
		int a = 10;
		int b = 20;
		System.out.println(++a);

		System.out.println(++a + b++);
		  
		System.out.println((++a%3) + (a*++b));
	}
}