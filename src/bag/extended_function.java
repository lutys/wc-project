package bag;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class extended_function {  //��չ�������һ���֣�֧��-a���ظ����ӵ����ݣ������� /���� /ע���У�
	
	String e1,e2,e3;
	int j1,j2,j3;
	boolean o;
	properties sx = new properties();
	
	public void codeline(String p) {  //��������з������жϴ����б�׼�����а�������һ���ַ��Ĵ���
		   try {
			BufferedReader bw = new  BufferedReader(new FileReader(p));//�����ļ�
			while( (e1=bw.readLine())!= null) {
				if(e1.length()>=2){  //���������ݳ��ȶ���һ���ַ�
					j1++;
				}
				sx.setCodeLine(j1);
			}
			System.out.println("���ļ��Ĵ�������Ϊ:"+sx.getCodeLine());
			bw.close();
		} catch (FileNotFoundException e) {
			System.out.println("�޷��ҵ�ָ���ļ�");
		} catch (IOException e) {
			System.out.println("I/O����");
		}
		}
	
	public void blankline(String p) {   //������еķ������жϿ��б�׼������ȫ���ǿո���ʽ�����ַ�������������룬��ֻ�в�����һ������ʾ���ַ�
		try {
			BufferedReader bw = new  BufferedReader(new FileReader(p));
			while( (e2=bw.readLine())!= null) {
				o = e2.matches("\\s+||\\S");   //e2����˫���ţ����������������ƥ�����հ��ַ���ֻ��һ���ǿհ��ַ������м�һ
				if(o == true) {     //=�Ǵ�ģ���
					j2++;
				}
				sx.setBlankLine(j2);
			}
			System.out.println("���ļ��Ŀ�����Ϊ:"+sx.getBlankLine());
			bw.close();
		} catch (FileNotFoundException e) {
			System.out.println("�޷��ҵ�ָ���ļ�");
		} catch (IOException e) {
			System.out.println("I/O����");
		}
		}
	
	public void commentline(String p) { //����ע���еķ������ж�ע���б�׼�����в��Ǵ����У���������һ���ַ��Ĵ��룩�����ұ��а���ע�ͣ�ע��ǰ����}
		try {
			BufferedReader bw = new  BufferedReader(new FileReader(p));
			while( (e3=bw.readLine())!= null) {
				if(e3.contains("//")) {  //���������//
					o = (e3.substring(0, e3.indexOf("//"))).matches("\\S{0,1}");//�ж�//ǰ���Ϊһ��������ַ���Ϊע����
					if(o == true) {
						j3++;}
				}
				else if(e3.contains("/*")){  //ͬ��
					o = (e3.substring(0, e3.indexOf("/*"))).matches("\\S{0,1}");
					if(o == true) {
					j3++;}
				}
				else if(e3.contains("*/")){  //ͬ��
					o = (e3.substring(0, e3.indexOf("*/"))).matches("\\S{0,1}");
					if(o == true) {
					j3++;}
				}
				sx.setCommentLine(j3);
			}
			System.out.println("���ļ���ע������Ϊ:"+sx.getCommentLine());
			bw.close();
		} catch (FileNotFoundException e) {
			System.out.println("�޷��ҵ�ָ���ļ�");
		} catch (IOException e) {
			System.out.println("I/O����");
		}
	}
}
