package bag;

import java.io.File;
import java.util.Scanner;

public class wc {
	public static void main(String[] args) {
		basic_function mts = new basic_function(); //�������д������������
		extended_function wtf = new extended_function();
		extended_function_recursion efr = new extended_function_recursion();
		tong_pei tp = new tong_pei();
	     
		Scanner scan = new Scanner(System.in);//����Scanner�����
		if (scan.hasNext()) { //��������
            String str1 = scan.nextLine();
            if((str1.substring(0,2)).equals("-l"))mts.lineNum(str1.substring(3,str1.length()));
            if((str1.substring(0,2)).equals("-c"))mts.strNum(str1.substring(3,str1.length()));
            if((str1.substring(0,2)).equals("-w"))mts.wordNum(str1.substring(3,str1.length()));
            if((str1.substring(0,2)).equals("-a")) {
			    wtf.codeline(str1.substring(3,str1.length()));  //substring() �������ص��Ӵ����� start �����ַ����������� stop �����ַ�
				wtf.blankline(str1.substring(3,str1.length()));
				wtf.commentline(str1.substring(3,str1.length()));
			}
            if((str1.substring(0,2)).equals("-s")) {   	
            	String arrays[] = str1.split(" ");
            	File f[] = tp.getFiles(arrays[2],arrays[1]); //����tong_pei����getFiles()����
            	for(File ff:f) {
            		efr.recursion(ff.getName(),ff.getAbsolutePath());
            	}        	
            }
		scan.close(); //�ر���
		}
	}
}
