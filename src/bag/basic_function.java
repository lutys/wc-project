package bag;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class basic_function {   //基本功能类，支持-c-w-l查询字符数、词的数目、行数
	
	   String c2,c21,c3;
	   int a1,a2=0;
	   properties sx = new properties();
	   
	   public void lineNum(String p) {  //计算行数的方法
		   try {
			BufferedReader bw = new  BufferedReader(new FileReader(p));//读入文件
			while(bw.readLine()!= null) {  //当读行不为空
				a1++;                      //行数加一
				sx.setLineNum(a1);
			}
			System.out.println("该文件的行数为:"+sx.getLineNum());
			bw.close();      //关闭流
		} catch (FileNotFoundException e) {   //捕获错误1
			System.out.println("无法找到指定文件");
		} catch (IOException e) {         //捕获错误2
			System.out.println("I/O错误");
		}
		}
	   
	   public void strNum(String p) {  //计算字符数的方法
		   try {
			BufferedReader bw = new  BufferedReader(new FileReader(p)); //读入文件
			while((c2=bw.readLine())!=null) {
				String k = c2.replace(" ","");  //将空格全部替换成空
			    a2=a2+k.length(); //每读一行，累计字符数   
			    sx.setStrNum(a2);
			}
			System.out.println("该文件的字符数为："+sx.getStrNum());
			bw.close();
		} catch (FileNotFoundException e) {
			System.out.println("无法找到指定文件");
		} catch (IOException e) {
			System.out.println("I/O错误");
		}
	   }
	   
	   public void wordNum(String p) {  //计算单词数的方法
		try {
			BufferedReader bw = new  BufferedReader(new FileReader(p)); //读入文件
			 StringBuffer sb=new StringBuffer();
		        while((c3=bw.readLine())!=null) {    //readline读取到换行不算为null
		        	if(c3.matches("")==false) {   //字符比较不能直接！=，如果读取的行非空执行下面语句
		            sb.append(c3+"\\s");    //将读取到的内容追加在StringBuffer对象中，在结尾加上一个空白字符避免与下行的首部相连
		            }
		        }
		        c3=sb.toString();  //转为字符串模式
		        String[] strings=c3.split("[^\\w]");  //以非词字符为分隔 将词分开
		       System.out.println("该文件单词个数为："+(strings.length-1));
		       bw.close();
		} catch (FileNotFoundException e) {
			System.out.println("无法找到指定文件");
		} catch (IOException e) {
			System.out.println("I/O错误");
		}
	    }
	   }
