import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestFile {
	public static void main(String[] args) {
		try {
			File f = new File("d:"+File.separator+"hello2.txt");
			if(f.exists()){
				f.createNewFile();
			}
			System.out.println(f.getName());
			System.out.println(f.length());
			System.out.println(f.canRead()+"===="+f.canWrite());
			System.out.println(f.getAbsolutePath());
			System.out.println(f.getParent());
			File file = f.getParentFile();
			System.out.println(f.isFile());
			System.out.println(file.isFile());
			// 距离1970 1 1 0：0：0 的毫秒数
			long lastDate = f.lastModified();
			Date date =new Date(lastDate);
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy年MM-dd hh:mm:ss");
			String formatStr= sdf.format(date);
			System.out.println(formatStr);
			
			File ds[]= file.listFiles();
			for (File file2 : ds) {
				System.out.println(file2.getName()+"@");
			}
			System.out.println("-------------");
			// 查找所有的txt文件  需要使用过滤器来完成  匿名内部类
			File txts[] = file.listFiles(new TxtFileFilter());
			for (File file2 : txts) {
				System.out.println(file2.getName()+"#");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
