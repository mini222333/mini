package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import dao.BookDao_Oracle;
import service.BookService;
import service.BookServiceImpl;
import vo.BookVo;


@WebServlet("/insertBook.do")
public class insertBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		System.out.println("/insertBook.do 요청 처리");
		
		BookDao dao = new BookDao_Oracle();
		BookService service = new BookServiceImpl(dao);
		
		BookVo vo = new BookVo();
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		vo.setBookname(request.getParameter("bookname"));
		vo.setPublisher(request.getParameter("publisher"));
		
		try {
		service.addBook(vo);		
		response.sendRedirect("listBook.do");
	}catch (Exception e) {
		request.setAttribute("exception", new Exception("등록 데이터 입력을 확인후 다시 등록해주세요."));
		getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
		
	}
}
}
