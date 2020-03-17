
@Table(tableName="user")
public class Users {
	@Column(columnName="id", isStr="no")
	private int id;
	@Column(columnName="name", isStr="yes")
	private String name;
	@Column(columnName="password", isStr="yes")
	private String pwd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
