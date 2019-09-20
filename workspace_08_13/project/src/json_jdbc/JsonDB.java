package json_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import util.JDBCUtil;
import vo.UserVO;

public class JsonDB {

	public UserVO loginUser(UserVO vo) {
		List<UserVO> list = new ArrayList<UserVO>();
		String sql = "select * from users where id=? and password=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserVO data = null;
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			// 실행 및 결과값 핸들링
			rs = ps.executeQuery();
			if (rs.next()) {
				data = new UserVO();
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("password"));
			} else {
				System.out.println("로그인 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return data;
	}

	public int addUser(UserVO vo) {
		String sql = "insert into users(id,password,name,role) values(?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getRole());
			// 실행 및 결과값 핸들링
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
	// id중복체크
	public static String idCheck(String id) {
		String sql = "select * from users where id=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Map<String, String> map = new HashMap<String, String>();
		
		try {
			con=JDBCUtil.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, id);
		
		rs = ps.executeQuery();
		//결과값 핸들링
		while(rs.next()) {
			map.put("id",rs.getString("id"));
			
		}
		
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return JSONObject.toJSONString(map);
	}

}
