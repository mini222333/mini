package day06;

public class Test01 {
	public static void main(String[] args) {
		int[] num = {2,4,6,8};
		int[] num2;
		num2 = new int[]{1,2,3,4,5,6,7};
		//new int[]가 없다면 선언과 초기화는 한라인에서 이루어져야함
		
		String[] arr = {"hello","java","test"};
		for(int data : num) {
			System.out.println(data);
		}
		
			for(String data:arr) {
			System.out.println(data);
			}
		
	}

}
