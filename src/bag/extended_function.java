package bag;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class extended_function {  //扩展功能类第一部分，支持-a返回更复杂的数据（代码行 /空行 /注释行）
	
	String e1,e2,e3;
	int j1,j2,j3;
	boolean o;
	properties sx = new properties();
	
	public void codeline(String p) {  //计算代码行方法，判断代码行标准：本行包括多于一个字符的代码
		   try {
			BufferedReader bw = new  BufferedReader(new FileReader(p));//读入文件
			while( (e1=bw.readLine())!= null) {
				if(e1.length()>=2){  //若本行内容长度多于一个字符
					j1++;
				}
				sx.setCodeLine(j1);
			}
			System.out.println("该文件的代码行数为:"+sx.getCodeLine());
			bw.close();
		} catch (FileNotFoundException e) {
			System.out.println("无法找到指定文件");
		} catch (IOException e) {
			System.out.println("I/O错误");
		}
		}
	
	public void blankline(String p) {   //计算空行的方法，判断空行标准：本行全部是空格或格式控制字符，如果包括代码，则只有不超过一个可显示的字符
		try {
			BufferedReader bw = new  BufferedReader(new FileReader(p));
			while( (e2=bw.readLine())!= null) {
				o = e2.matches("\\s+||\\S");   //e2不加双引号！！，如果读行内容匹配多个空白字符或只有一个非空白字符，空行加一
				if(o == true) {     //=是错的！！
					j2++;
				}
				sx.setBlankLine(j2);
			}
			System.out.println("该文件的空行数为:"+sx.getBlankLine());
			bw.close();
		} catch (FileNotFoundException e) {
			System.out.println("无法找到指定文件");
		} catch (IOException e) {
			System.out.println("I/O错误");
		}
		}
	
	public void commentline(String p) { //计算注释行的方法，判断注释行标准：本行不是代码行（包括多于一个字符的代码），并且本行包括注释，注释前可有}
		try {
			BufferedReader bw = new  BufferedReader(new FileReader(p));
			while( (e3=bw.readLine())!= null) {
				if(e3.contains("//")) {  //如果本行有//
					o = (e3.substring(0, e3.indexOf("//"))).matches("\\S{0,1}");//判断//前如果为一个或零个字符则为注释行
					if(o == true) {
						j3++;}
				}
				else if(e3.contains("/*")){  //同理
					o = (e3.substring(0, e3.indexOf("/*"))).matches("\\S{0,1}");
					if(o == true) {
					j3++;}
				}
				else if(e3.contains("*/")){  //同理
					o = (e3.substring(0, e3.indexOf("*/"))).matches("\\S{0,1}");
					if(o == true) {
					j3++;}
				}
				sx.setCommentLine(j3);
			}
			System.out.println("该文件的注释行数为:"+sx.getCommentLine());
			bw.close();
		} catch (FileNotFoundException e) {
			System.out.println("无法找到指定文件");
		} catch (IOException e) {
			System.out.println("I/O错误");
		}
	}
}
