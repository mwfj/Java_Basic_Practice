import java.io.File;
import java.io.FileFilter;

public class TxtFileFilter implements FileFilter {
	// 每次都会把文件或目录交给你处理 符合要求的留下
	public boolean accept(File pathname) {
		if (pathname.getName().endsWith(".txt")) {
			return true;
		} else {
			return false;
		}
	}

}
