package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.BookVo;

public class BookDao_Oracle extends BookDao {
	public List<BookVo> getBookRec() {
	
		String sql =
				"select * from ( "+
				"select rownum row#,bookid, bookname, publisher, price "+
				"from (select * from Book order by bookid desc) "+
				")where row# between ? and ? ";
		
		List<BookVo> list = new ArrayList<BookVo>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {


			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅
			ps.setInt(1,1);
			ps.setInt(2,5);

			// 실행 및 결과값 핸들링
			rs = ps.executeQuery();// ?세팅필요x 세팅값rs가 가지고있음
			while (rs.next()) {
				BookVo book = new BookVo();
				book.setBookid(rs.getInt("bookid"));
				book.setBookname(rs.getString("bookname"));
				book.setPublisher(rs.getString("publisher"));
					book.setPrice(rs.getInt("price"));
						list.add(book);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
			System.out.println("******con 반납******");
		}
		return list;

	}

	public int insertBook(BookVo book) throws Exception {

		String sql = "insert into book(bookid,bookname,publisher,price) "
				+ "values((select nvl(max(bookid),0)+1 from book),?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅
			//ps.setInt(1, book.getBookid());
			ps.setString(1, book.getBookname());
			ps.setString(2, book.getPublisher());
			ps.setInt(3, book.getPrice());
			// 실행 및 결과값 핸들링
			result = ps.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}

	public int update(BookVo book) {

		String sql = "update book set price = ? where bookid = ?";
		Connection con = null;
		PreparedStatement ps = null;
		// ResultSet rs =null; dml이라 필요x
		int result = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅
			ps.setInt(1, book.getPrice());
			ps.setInt(2, book.getBookid());
			// 실행 및 결과값 핸들링
			// ps.executeQuery(); dml이라 x
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}

	public int deleteBook(int bookid) {
		String sql = "delete from book where bookid = ? ";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅
			ps.setInt(1, bookid);
			// 실행 및 결과값 핸들링
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}

		return result;

	}

	public static void searchBook(String bookname) {
		// String sql = "select * from emp where lower(ename) like '%'||?||'%'";
		String sql = "select * from Book where lower(bookname) like ?";
		// %, 대소문자 처리
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅
			// ps.setString(1, ename);
			ps.setString(1, "%" + bookname.toLowerCase() + "%");
			// 실행 및 결과값 핸들링
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.print(rs.getInt("bookid") + "\t");
				System.out.print(rs.getString("bookname") + "\t\t");
				System.out.print(rs.getString("publisher") + " \t\t");
				System.out.print(rs.getInt("price") + "\t");
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}

	}
}
