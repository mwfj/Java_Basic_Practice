package io_practice;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import basic.Student;

/**
 * @author mwfj
 *	Fileinputstream 必须与Fileoutputstream成对使用
 * Bufferinputstream/Bufferoutputstream 相对于Datainputstream/Dataoutputstream更高效
 * Objectinputstream/Objectoutputstream 读写的类必须序列化过，即继承Serializable接口
 */
public class Fileiostream {
	
	public static void main(String[] args) {
		
		try {
			String myword = "My file, my rules";
			File file = new File("io_file/text.txt");
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
			dataOutputStream.writeUTF(myword);;
			fileOutputStream.close();
			dataOutputStream.close();
			
			if (!file.exists()) {
				System.out.println("该文件不存在");
			}
			FileInputStream fileInputStream = new FileInputStream(file);
			DataInputStream dataInputStream = new DataInputStream(fileInputStream);
			String  read_str = dataInputStream.readUTF();
			System.out.println(read_str);
			fileInputStream.close();
			dataInputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//objection input/output stream
		
		Student student = new Student();
		student.setName("mwfj");
		student.setAge(23);
			try {
				File file_obejective = new File("io_file/text_io_objection.txt");
				if (!file_obejective.exists()) {
					file_obejective.createNewFile();
					}
				FileOutputStream object_fos = new FileOutputStream(file_obejective);
				ObjectOutputStream obos = new ObjectOutputStream(object_fos);
				obos.writeObject(student);
				object_fos.close();
				obos.close();
				FileInputStream object_fis = new FileInputStream(file_obejective);
				ObjectInputStream obis = new ObjectInputStream(object_fis);
				Student read_student  = (Student)obis.readObject();
				System.out.println(read_student.getName());
				System.out.println(read_student.getAge());
				System.out.println(read_student.school_name);
				object_fis.close();
				obis.close();
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}
}
