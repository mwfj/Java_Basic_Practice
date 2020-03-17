package io_practice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Iterator;
import java.util.Properties;
/**
 * 
 * @author mwfj
 *  JDK 1.7  新特性 try...catch...resource(可以对实现closeable的类使用)
 *  				可以在try之后的括号内加入需要close的流，在运行完try之后系统会自动关闭这些流
 * Properties 类：通过load()读取peoperity 文件中的内容
 *
 */
public class Test_Properties {

	public static void main(String[] args) {
/**
 * 1.在try的括号里声明需要关闭的流系统会自动帮你关闭而无需用close()
 * 2.利用反射机制获取文件夹中的变量		
 */
		try(InputStream is =  Test_Properties.class.getResourceAsStream("test.properties");
				OutputStream os = new FileOutputStream("test.properties", true);){
			Properties myProperties = new Properties();
			myProperties.load(is);
			//向Properities文件中写入变量
			myProperties.getProperty("Phone","10086");
			myProperties.store(os, "Comment");
			
			//持久化文件的写入
			File properity = new File("test.properties");
			Writer write_properities = new FileWriter(properity);
			myProperties.setProperty("Personality", "kind");
			myProperties.store(write_properities, "Comment2");
			
			//向Properities文件中读取变量
			System.out.println(myProperties.getProperty("Name"));
			System.out.println(myProperties.getProperty("Gender"));
			System.out.println(myProperties.getProperty("Age"));
			System.out.println(myProperties.getProperty("Phone"));
			System.out.println(myProperties.getProperty("Personality"));
			System.out.println("--------------------------------------------------------");
			System.out.println("利用迭代器输出Properities:");

			Iterator<String> iterator = myProperties.stringPropertyNames().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				System.out.println( key+":  " + myProperties.getProperty(key));
			}
			System.out.println("The Path of Properities: "+properity.getAbsolutePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
