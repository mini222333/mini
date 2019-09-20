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

import dao.UsersDao;
import service.UsersService;
import service.UsersServiceImpl;
import vo.UserVo;

public class UsersApp {

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
    JButton add,list,delete,search,exit;
    TextField id,password,name,role;
    TextArea output;
	
    
    UsersDao users = new UsersDao ();
    UsersService service = new UsersServiceImpl(users);
    
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
    	p2.add(new JLabel("   유   저   "));
    	p2.add(id = new TextField(20));
    	p2.add(new JLabel("  비밀번호   "));
    	p2.add(password = new TextField(20));
    	p2.add(new JLabel("  닉네임  "));
    	p2.add(name = new TextField(20));
     	p2.add(new JLabel("  권  한  "));
    	p2.add(role = new TextField(20));
    	
    	add(p2,BorderLayout.NORTH);
    	
    	add(output= new TextArea(15, 40));
    	output.setFont(new Font(null,1,20));
    	
    	pack();
    	setVisible(true);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	add.addActionListener(e -> {
    		UserVo vo = new UserVo();
    		vo.setId(id.getText());
    		vo.setPassword(password.getText());
    		vo.setName(name.getText());
    		vo.setRole(role.getText());
    		
    		
    		service.addUsers(vo);
    		
    		id.setText("");
    		password.setText("");
    		name.setText("");
    		role.setText("");
    		
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
    		
    		service.usersList().forEach(i->output.append(i+"\n"));
    		} );
    	
    	delete.addActionListener(e->{
    		int i=service.deleteUsers(id.getText());
    		output.setText(i+" 유저 삭제 \n");
    		
    	});
    	}
}





