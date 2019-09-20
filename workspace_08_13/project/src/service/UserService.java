package service;


import vo.UserVO;

public interface UserService {
	public UserVO login(UserVO vo);
	public int addUser (UserVO vo) throws Exception;
	
}
