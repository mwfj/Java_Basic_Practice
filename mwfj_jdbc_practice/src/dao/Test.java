package dao;



public class Test {

	public static void main(String[] args) {
		
		StudentDAO sDao = new StudentDAOimpl();
		sDao.deleteStudent("5");
	}
}
