package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.BookVo;

public class BookDao_MySQL extends BookDao{
	public List<BookVo> getBookRec() {
		System.out.println("BookDao_MySQL getBookRec");
		List<BookVo> list= new ArrayList<BookVo>();
		return null;

	}

	public int insertBook(BookVo book) {
		
		System.out.println("BookDao_MySQL insertBook");
		return 0;
	}

	public int update(BookVo book) {
		System.out.println("BookDao_MySQl updateBook");
		return 0;
	}

	public int deleteBook(int bookid) {
		System.out.println("BookDao_MySQL deleteBook");
		return 0;

	}
}