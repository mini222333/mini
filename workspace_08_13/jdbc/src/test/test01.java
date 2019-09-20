package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test01 {

	public static void main(String[] args) {

		String driver = "oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user="SCOTT";
		String pw="TIGER";
		
		String sql= "select * from emp where deptno=10";		
		System.out.println("**********JDBC TEST*******");
		Connection con = null;//필요한 변수 설정
		Statement st = null;
		ResultSet rs = null; //select 결과값 받을 객체
		int result = 0; //dml의 결과값
		
		
		
		
		try {//1. JDBC Driver 설치 : ojdbc6.jar classpath
		//2. 드라이버 로딩
			Class.forName(driver);
			//new oracle.jdbc.OracleDriver();//x 오라클에서만 쓸수있음
			//3. db로 연결 connection 생성
			con = DriverManager.getConnection(url, user, pw);
				//4. sql 구문을 관리해주는 객체 (Statement) 생성
				st = con.createStatement();
				//5. sql 실행
				rs = st.executeQuery(sql);
				//System.out.println(rs.getMetaData().getColumnCount());//컬럼 세개
				//6. 결과값 핸들링
				while(rs.next()) {
					System.out.print(rs.getInt("empno")+"\t");//인덱스도 가능하지만 컬럼네임
					System.out.print(rs.getString("ename")+"\t");
					System.out.print(rs.getString("job")+"\t");
					System.out.print(rs.getString("mgr")+"\t");
					System.out.print(rs.getDate("hiredate")+"\t");
					System.out.print(rs.getString("sal")+"\t");
					System.out.print(rs.getString("comm")+"\t");
					System.out.print(rs.getString("deptno")+"\n");
				}
				
				
				
				
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver 확인 필요");//이름 다르거나 드라이버 인식 안되면 뜸.클래스패스 확인
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {	//7. 자원 반납
		try {
			if(rs !=null) rs.close();
			if(st !=null) st.close();
			if(con !=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}//드라이버 런타임에 결정.
		
	
		
	
	
	
	
	
	System.out.println("**********END**********");

	}

}
