import java.io.File;
import java.sql.Date;


public class FileTest {
	public static void showProperties(File f){
		System.out.println("==========显示文件属性======");
		System.out.println("文件名：" + f.getName());
		System.out.println("相对路径："+ f.getPath());
		System.out.println("绝对路径："+f.getAbsolutePath());
		System.out.println("是否存在："+ f.exists());
		System.out.println("最后修改："+ new Date(f.lastModified()));
		System.out.println();
	}

}
