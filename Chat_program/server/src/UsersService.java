import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.mysql.jdbc.util.ResultSetUtil;

 
public class UsersService {
	public Users doLogin(String name,String pwd){
		try {
			System.out.println(name+"!@#$"+pwd);
			Connection connection = ConnectionUtil.getConnection();
			String sql ="select * from users where name=? and pwd=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			Users users = null;
			if(rs.next()){
				users = new Users();
				users.setId(rs.getInt("id"));
				users.setName(rs.getString("name"));
				users.setPwd(rs.getString("pwd"));
			}
			return users;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
