package java_db;



public class ddd {
	public static void main(String[] args) {

		String msg = "hello java";
		System.out.print("1");
		try {
			System.out.print("2");
		if(msg==null)
			throw new Exception();
		System.out.print(3/0);
		System.out.print("3");
		}catch (RuntimeException e) {
			System.out.print("4");
		}catch (Exception e) {
			System.out.print("5");
		}finally {
			System.out.print("6");
		}
		System.out.print("7");
		}
}
