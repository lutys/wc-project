package bag;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class basic_function {   //���������֧࣬��-c-w-l��ѯ�ַ������ʵ���Ŀ������
	
	   String c2,c21,c3;
	   int a1,a2=0;
	   properties sx = new properties();
	   
	   public void lineNum(String p) {  //���������ķ���
		   try {
			BufferedReader bw = new  BufferedReader(new FileReader(p));//�����ļ�
			while(bw.readLine()!= null) {  //�����в�Ϊ��
				a1++;                      //������һ
				sx.setLineNum(a1);
			}
			System.out.println("���ļ�������Ϊ:"+sx.getLineNum());
			bw.close();      //�ر���
		} catch (FileNotFoundException e) {   //�������1
			System.out.println("�޷��ҵ�ָ���ļ�");
		} catch (IOException e) {         //�������2
			System.out.println("I/O����");
		}
		}
	   
	   public void strNum(String p) {  //�����ַ����ķ���
		   try {
			BufferedReader bw = new  BufferedReader(new FileReader(p)); //�����ļ�
			while((c2=bw.readLine())!=null) {
				String k = c2.replace(" ","");  //���ո�ȫ���滻�ɿ�
			    a2=a2+k.length(); //ÿ��һ�У��ۼ��ַ���   
			    sx.setStrNum(a2);
			}
			System.out.println("���ļ����ַ���Ϊ��"+sx.getStrNum());
			bw.close();
		} catch (FileNotFoundException e) {
			System.out.println("�޷��ҵ�ָ���ļ�");
		} catch (IOException e) {
			System.out.println("I/O����");
		}
	   }
	   
	   public void wordNum(String p) {  //���㵥�����ķ���
		try {
			BufferedReader bw = new  BufferedReader(new FileReader(p)); //�����ļ�
			 StringBuffer sb=new StringBuffer();
		        while((c3=bw.readLine())!=null) {    //readline��ȡ�����в���Ϊnull
		        	if(c3.matches("")==false) {   //�ַ��Ƚϲ���ֱ�ӣ�=�������ȡ���зǿ�ִ���������
		            sb.append(c3+"\\s");    //����ȡ��������׷����StringBuffer�����У��ڽ�β����һ���հ��ַ����������е��ײ�����
		            }
		        }
		        c3=sb.toString();  //תΪ�ַ���ģʽ
		        String[] strings=c3.split("[^\\w]");  //�ԷǴ��ַ�Ϊ�ָ� ���ʷֿ�
		       System.out.println("���ļ����ʸ���Ϊ��"+(strings.length-1));
		       bw.close();
		} catch (FileNotFoundException e) {
			System.out.println("�޷��ҵ�ָ���ļ�");
		} catch (IOException e) {
			System.out.println("I/O����");
		}
	    }
	   }
