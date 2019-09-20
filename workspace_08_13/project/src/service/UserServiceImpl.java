package service;

import dao.UserDAO;
import vo.UserVO;	

public class UserServiceImpl implements UserService{

	UserDAO dao;
	
	public UserServiceImpl() {}
	public UserServiceImpl(UserDAO dao) {
		super();
		this.dao = dao;
	}


	@Override
	public UserVO login(UserVO vo) {
		return dao.loginUser(vo);
	}

	@Override
	public int addUser(UserVO vo) throws Exception {
		return dao.addUser(vo);
	}




}
