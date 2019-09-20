package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import util.JDBCUtil;

public class test03 {
//과제 view
	//db연동 애플리케이션은 쓰리티어이상
	public static void main(String[] args) {
		int deptno = 10;
		if(args.length != 0) {
		deptno =Integer.parseInt(args[0]);
		}
		//하드코딩x 
		String sql="select * from emp where deptno= "+deptno;

		
		System.out.println("**********JDBC TEST*******");
		Connection con = null;//필요한 변수 설정
		Statement st = null;
		ResultSet rs = null; //select 결과값 받을 객체
		int result = 0; //dml의 결과값
		
		
		
		
		try {//1. JDBC Driver 설치 : ojdbc6.jar classpath
		//2. 드라이버 로딩
			//new oracle.jdbc.OracleDriver();//x 오라클에서만 쓸수있음
			//3. db로 연결 connection 생성
			con = JDBCUtil.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(sql);
				//4. sql 구문을 관리해주는 객체 (Statement) 생성
				//5. sql 실행
				//셀렉트구문  executequery
				//dml구문 executeupdate
				//System.out.println(rs.getMetaData().getColumnCount());//컬럼 세개
				//6. 결과값 핸들링
				while(rs.next()) {//rs.next 데이터 있으면 밑으로 내려가고 없으면 x
					System.out.print(rs.getString(1)+"\t");//인덱스도 가능하지만 컬럼네임
					System.out.print(rs.getString(2)+"\t");
					System.out.print(rs.getString(3)+"\t");
					System.out.print(rs.getString(4)+"\n");
				}
				
				
				
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {	//7. 자원 반납
			JDBCUtil.close(con,  st,  rs);

		}//드라이버 런타임에 결정.
		
	
	System.out.println("**********END**********");

	}

}
