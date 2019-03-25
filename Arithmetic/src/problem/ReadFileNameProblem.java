package problem;

import java.io.File;
import java.util.LinkedList;

public class ReadFileNameProblem {

	public static void main(String[] args) {
		String path = "C:\\Users\\Qin\\Desktop\\a";
		printAllFileName(path);
	}

	private static void printAllFileName(String path) {
		File root = new File(path);
		LinkedList<File> dirs = new LinkedList<>();
		dirs.add(root);
		
		
		while(!dirs.isEmpty()){
			File parent = dirs.remove();
			
			File[] files = parent.listFiles();
			if(null == files || files.length < 1){
				continue;
			}
			
			for(File f : files){
				if(f.isDirectory()){
					dirs.add(f);
				}else{
					System.out.println(f.getName());
				}
			}
		}
		
	}

}
