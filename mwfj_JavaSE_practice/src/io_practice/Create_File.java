package io_practice;

import java.io.File;
import java.io.IOException;




public class Create_File {

	public static void main(String[] args) {

		try {
			File myFile = new File("io_file");
			myFile.mkdirs();
			System.out.println(myFile.getPath());
			System.out.println(myFile.getParentFile());
			File myFile2 = new File("io_file", "text.txt");
			myFile2.createNewFile();
			System.out.println(myFile2.getAbsolutePath());
			System.out.println(myFile2.exists());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
