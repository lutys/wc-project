package bag;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tong_pei {  //��չ���ܵ������֣�֧�ָ����ļ���ͨ�����*,?��
	public File[] getFiles(String dir,String s) {  //getFiles����������File�����ȡ·��
	     File file = new File(dir);
	     s = s.replace("*", ".*");//��*��Ϊ������ʽ����λ��ε������ַ�
	     s = s.replace("?", ".?");//������Ϊ������ʽ��һ�λ�û�е������ַ�
	     Pattern p = Pattern.compile(s); //��compile()��������ƥ��ģʽ
	     ArrayList list = filePattern(file, p);//����filePattern����
	     File[] rtn = new File[list.size()];
	     list.toArray(rtn);
	     return rtn;
	   }
	
	public ArrayList filePattern(File file, Pattern p) {
	     if (file == null) {  //����ļ�Ϊ�շ��ؿ�
	       return null;
	     }
	     else if (file.isFile()) { //�жϸ��ļ��Ƿ��׼�ļ�
	       Matcher fMatcher = p.matcher(file.getName());
	       if (fMatcher.matches()) {
	         ArrayList list = new ArrayList();
	         list.add(file);
	         return list;
	       }
	     }
	     else if (file.isDirectory()) { //�ж��ļ��Ƿ�Ϊ�ļ���
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
