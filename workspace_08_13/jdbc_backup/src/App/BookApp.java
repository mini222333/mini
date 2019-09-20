package App;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import dao.BookDao;
import service.BookService;
import service.BookServiceImpl;
import vo.Book;

public class BookApp {

	public static void main(String[] args) {
//		//규칙 서비스레이어는 서비스로 끝나야함
//		//book service impl 북서비스를 implements한 구현객체
//		
//		BookService service = null;
//		//service.addBook(book);
//		service.bookList().forEach(i->System.out.println(i));
		
		new Gui();
	}

}
class Gui extends JFrame{
	static int num=0;
    JButton add,list,delete,search,exit;
    TextField title,price,isbn,publisher;
    TextArea output;
	
    BookDao book = new BookDao();
    BookService service = new BookServiceImpl(book);
    
    Gui(){

    	Panel p1 = new Panel();
    	p1.add(add = new JButton("ADD"));
    	p1.add(list = new JButton("List"));
    	p1.add(delete = new JButton("삭제"));
    	p1.add(search = new JButton("검색"));
    	p1.add(exit = new JButton("종료"));
    	add(p1,BorderLayout.SOUTH);
    	
    	Panel p2 = new Panel();
    	p2.setLayout(new GridLayout(3,2));
    	p2.add(new JLabel("   ISBN   "));
    	p2.add(isbn = new TextField(20));
    	p2.add(new JLabel("  제      목   "));
    	p2.add(title = new TextField(20));
    	p2.add(new JLabel("  가      격  "));
    	p2.add(price = new TextField(20));
     	p2.add(new JLabel("  출  판  사  "));
    	p2.add(publisher = new TextField(20));
    	
    	add(p2,BorderLayout.NORTH);
    	
    	add(output= new TextArea(15, 40));
    	output.setFont(new Font(null,1,20));
    	
    	pack();
    	setVisible(true);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	add.addActionListener(e -> {
    		Book vo = new Book();
    		vo.setBookid(Integer.parseInt(isbn.getText()));
    		vo.setBookname(title.getText());
    		vo.setPrice(Integer.parseInt(price.getText()));
    		vo.setPublisher(publisher.getText());
    		
    		
    		service.addBook(vo);
    		
    		title.setText("");
    		isbn.setText("");
    		price.setText("");
    		publisher.setText("");
    		
    		///mgr.add(new Book(title.getText(),Integer.parseInt(price.getText())));
    	});
    	
    	exit.addActionListener(e-> {
    	    //mgr.save();
    		System.exit(0);
    	});
    	
    	list.addActionListener(e -> {
    		output.setText(" BookList  \n");
    		//mgr.getBookList().forEach(i -> {
    			//output.append(i+"\n");
    		
    		service.bookList().forEach(i->output.append(i+"\n"));
    		} );
    	
    	delete.addActionListener(e->{
    		int i=service.deleteBook(Integer.parseInt(isbn.getText()));
    		output.setText(i+" 개의 도서 삭제 \n");
    		
    	});
    	}
}



