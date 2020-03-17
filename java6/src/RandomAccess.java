import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class RandomAccess {
    public static void testSkip(File f){
    	try{
    		RandomAccessFile raf =new RandomAccessFile(f,"rw");
    		String str = "b";
    		raf.skipBytes(1);
    		raf.writeBytes(str);
    		raf.skipBytes(1);
    		raf.writeBytes(str);
    		raf.seek(0);
    		String content = raf.readLine();
    		System.out.println(content);
    		raf.close();
    		
    	}catch(FileNotFoundException e){
    		e.printStackTrace();
    		
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }
    public static void testSeek(File f){
    	try{
    		RandomAccessFile raf =new RandomAccessFile(f,"rw");
    		String str = "b";
    		raf.skipBytes(1);
    		raf.writeBytes(str);
    		raf.skipBytes(1);
    		raf.writeBytes(str);
    		raf.seek(0);
    		String content = raf.readLine();
    		System.out.println(content);
    		raf.close();
    		
    	}catch(FileNotFoundException e){
    		e.printStackTrace();
    		
    	}catch(IOException e){
    		e.printStackTrace();
    }
    	}
    public static void main(String[] args){
    	File f1 =new File("raf-ship.txt");
    	FileTest.showProperties(f1);
    	RandomAccess.testSkip(f1);
    	File f2 =new File("raf-seek.txt");
    	FileTest.showProperties(f2);
    	RandomAccess.testSkip(f2);
    }
}
