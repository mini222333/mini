package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.BookDao;
import service.BookService;
import service.BookServiceImpl;
import vo.Book;

public class Test11_BookService {
	
	BookService service = null;
	
	@Before//환경셋업작업
	public void setUp() {
		System.out.println(" setUp() 수행 ");
		
		BookDao dao = new BookDao();
		service = new BookServiceImpl(dao);
		
		
		
		
	}
	
	@After
	public void tearDown() {
			service=null;
			System.out.println("============ tearDown() 호출 ============");
	
	}
	//@Test
	public void test1() {
		System.out.println("============ Book List==============");
		service.bookList().forEach(i->System.out.println(i));
		System.out.println("====================================");
		
		
	
	}
	
	//@Test
	public void insert() {
	
		Book book = new Book();
		book.setBookid(6);
		book.setBookname("mini");
		book.setPrice(3333);
		book.setPublisher("mini1");
		int num=0;
		try {
			num = service.addBook(book);
		} catch (Exception e) {
			
		} 
		if(num>0) System.out.println("등록 성공");
		else {
			System.out.println("등록 실패");
		}
	
	}
		//@Test
		public void update() {
			Book book = new Book();
			book.setBookid(6);
			book.setPrice(4444);
			service.updateBook(book);
		}
		
		//@Test
		public void delete() {
			service.deleteBook(6);
		}
}
