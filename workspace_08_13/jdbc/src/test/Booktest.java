package test;

import dao.BookDao;
import vo.BookVo;

public class Booktest {
	public static void main(String[] args) {
		
		BookDao bookdao = new BookDao();
		bookdao.getBookRec().forEach(i->System.out.println(i));
		
		
		System.out.println("---------------------------");
		//int count = emp.insertDept(70,"교육부","서울");
		//System.out.println(count+" : insert ");
		System.out.println("--------------등록------------");
		
		//Employee data = new Employee(7777, "고길동", 3900, 10);
		BookVo data = new BookVo();
		data.setBookid(12);
		data.setBookname("java");
		data.setPublisher("mini");
		data.setPrice(5000);
		
		int count = bookdao.insertBook(data);
		System.out.println(count+" : insert ");
		
		System.out.println(" end  ");

		
		System.out.println("--------------수정------------");
		BookVo data2 = new BookVo();
		data2.setBookname("");
		data2.setPublisher("zzz");
		data2.setPrice(6000);
		int count2= bookdao.update(data2);
		System.out.println(count2+" => 갱신 ");
		
		System.out.println("--------------삭제------------");
		int count3 = bookdao.deleteBook(1111);
		System.out.println(count3==1 ? "1111 삭제":" 삭제 데이터 없음  ");
		

	}
	
}
