package bag;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tong_pei {  //扩展功能第三部分，支持各种文件的通配符（*,?）
	public File[] getFiles(String dir,String s) {  //getFiles方法，返回File数组存取路径
	     File file = new File(dir);
	     s = s.replace("*", ".*");//将*换为正则表达式的零次或多次的任意字符
	     s = s.replace("?", ".?");//将？换为正则表达式的一次或没有的任意字符
	     Pattern p = Pattern.compile(s); //用compile()方法设置匹配模式
	     ArrayList list = filePattern(file, p);//调用filePattern方法
	     File[] rtn = new File[list.size()];
	     list.toArray(rtn);
	     return rtn;
	   }
	
	public ArrayList filePattern(File file, Pattern p) {
	     if (file == null) {  //如果文件为空返回空
	       return null;
	     }
	     else if (file.isFile()) { //判断该文件是否标准文件
	       Matcher fMatcher = p.matcher(file.getName());
	       if (fMatcher.matches()) {
	         ArrayList list = new ArrayList();
	         list.add(file);
	         return list;
	       }
	     }
	     else if (file.isDirectory()) { //判断文件是否为文件夹
	       File[] files = file.listFiles();
	       if (files != null && files.length > 0) {
	         ArrayList list = new ArrayList();
	         for (int i = 0; i < files.length; i++) {
	           ArrayList rlist = filePattern(files[i], p);
	           if (rlist != null) {
	             list.addAll(rlist);
	           }
	         }
	         return list;
	       }
	     }
	     return null;
	   }
}
