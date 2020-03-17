package mwfj.demo.spring.ui;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mwfj.demo.spring.entities.User;

public class MainModule {
	
	

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[]{"config.xml"});
		
//		UserService userService = (UserService)ctx.getBean("userService");
//		userService.newUser(null, null);
		
		User user = (User)ctx.getBean("user");
		System.out.println(user.getId());
		System.out.println(user.getLoginName());
		System.out.println(user.getLoginPassword());
		for(String list : user.getColors()) {
			System.out.println(list);
		}
		for(String set : user.getCities()) {
			System.out.println(set);
		}
		for(Map.Entry<String, String> entry : user.getMaps().entrySet()) {
			System.out.println(entry.getKey() + "|" + entry.getValue());
		}
		

	}

}
