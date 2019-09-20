package test;

import dao.DeptDao;

public class test09_DeptDao {

	public static void main(String[] args) {
		DeptDao dao = new DeptDao();
		dao.getDeptRec().forEach(i->System.out.println(i));
		System.out.println("------------------------------");
		dao.getDeptRec(1,3).forEach(i->System.out.println(i));
	}

}
