package service;

import java.util.List;

import vo.BookVo;

public interface BookService {
	
		List<BookVo> bookList();
		int addBook (BookVo book);
		int deleteBook(int bookid);
		int updateBook (BookVo book);
		

}
