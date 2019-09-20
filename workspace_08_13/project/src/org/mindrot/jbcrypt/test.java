package org.mindrot.jbcrypt;

public class test {
	public static void main(String[] args) {
		String password="mini01"; //회원가입 프로젝트7 리퀘스트 입력받는식으로 반반 나눠서. 입력받는파일 참고
		// Hash a password for the first time
		String hashed = BCrypt.hashpw(password, BCrypt.gensalt(10));

		// gensalt's log_rounds parameter determines the complexity
		// the work factor is 2**log_rounds, and the default is 10
		//String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
		String candidate="mini00"; //로그인할때 비번 입력
		// Check that an unencrypted password matches one that has
		// previously been hashed
		System.out.println(candidate);
		if (BCrypt.checkpw(candidate, hashed))
			System.out.println("It matches");
		else
			System.out.println("It does not match");
		String candidate2="mini01"; //로그인할때 비번 입력
		// Check that an unencrypted password matches one that has
		// previously been hashed
		System.out.println(candidate2);
		if (BCrypt.checkpw(candidate2, hashed))
			System.out.println("It matches");
		else
			System.out.println("It does not match");
		
		
	}
	
}
