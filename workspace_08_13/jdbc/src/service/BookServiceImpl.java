package service;

import java.util.List;

import dao.BookDao;
import vo.BookVo;

public class BookServiceImpl implements BookService {

	BookDao dao;
	
	
	
	public BookServiceImpl() {}
	
	public BookServiceImpl(BookDao dao) {
		this.dao = dao;
	}

	public BookDao getDao() {
		return dao;
	}

	public void setDao(BookDao dao) {
		this.dao = dao;
	}

	@Override
	public List<BookVo> bookList() {
		return dao.getBookRec();
	}

	@Override
	public int addBook(BookVo book) {
		// TODO Auto-generated method stub
		return dao.insertBook(book);
	}

	@Override
	public int deleteBook(int bookid) {
		// TODO Auto-generated method stub
		return dao.deleteBook(bookid);
	}

	@Override
	public int updateBook(BookVo book) {
		// TODO Auto-generated method stub
		return updateBook(book);
	}
	
	

}
