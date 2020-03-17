package basic;

public class Employee extends Person{

		private String company_name;
		private int wages;
		private String job_position;
		public String getCompany_name() {
			return company_name;
		}
		public void setCompany_name(String company_name) {
			this.company_name = company_name;
		}
		public int getWages() {
			return wages;
		}
		public void setWages(int wages) {
			this.wages = wages;
		}
		public String getJob_position() {
			return job_position;
		}
		public void setJob_position(String job_position) {
			this.job_position = job_position;
		}
		
}
