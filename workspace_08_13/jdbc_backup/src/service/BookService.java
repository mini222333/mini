package service;

import java.util.List;

import vo.Book;

public interface BookService {
	
		List<Book> bookList();
		int addBook (Book book);
		int deleteBook(int bookid);
		int updateBook (Book book);
		

}
