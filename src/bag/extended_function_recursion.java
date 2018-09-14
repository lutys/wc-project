package bag;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class extended_function_recursion { //扩展功能第二部分支持 -s递归处理目录下符合条件的文件
	
	basic_function bf = new basic_function(); //创建基本功能类对象
	extended_function ef = new extended_function(); //创建扩展功能类第一部分对象
	
	public void recursion(String fileName, String filePath) {  //递归处理目录下符合条件的文件
		List<String> l = new ArrayList<String>();
		find(new File(filePath),fileName,l);
		String path = null;
		if(l.size()>=1)path = l.get(0);  //提取文件路径
		System.out.println("该目录下符合要求的文件的绝对路径为："+path);
		System.out.println("以下为递归处理目录下符合条件的文件的属性：");
		bf.lineNum(path);  //以下为文件属性
		bf.strNum(path);
		bf.wordNum(path);
		ef.codeline(path);
		ef.blankline(path);
		ef.commentline(path);
	}

	public static void find(File file,String fileName,List<String> l) {  
		if (file.isDirectory()) {    //如果是一个文件夹，返回true
            File[] f1 = file.listFiles();  //返回某个当前目录下的所有文件和文件夹的绝对路径，返回的是File数组
            for (File f : f1) {  
            	find(f,fileName,l); //递归执行
            }  
        }else{
        	if(file.getName().equals(fileName)){
        		l.add(file.getAbsolutePath()); //获取绝对路径
            }
        }
	}
}
