package bag;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class extended_function_recursion { //��չ���ܵڶ�����֧�� -s�ݹ鴦��Ŀ¼�·����������ļ�
	
	basic_function bf = new basic_function(); //�����������������
	extended_function ef = new extended_function(); //������չ�������һ���ֶ���
	
	public void recursion(String fileName, String filePath) {  //�ݹ鴦��Ŀ¼�·����������ļ�
		List<String> l = new ArrayList<String>();
		find(new File(filePath),fileName,l);
		String path = null;
		if(l.size()>=1)path = l.get(0);  //��ȡ�ļ�·��
		System.out.println("��Ŀ¼�·���Ҫ����ļ��ľ���·��Ϊ��"+path);
		System.out.println("����Ϊ�ݹ鴦��Ŀ¼�·����������ļ������ԣ�");
		bf.lineNum(path);  //����Ϊ�ļ�����
		bf.strNum(path);
		bf.wordNum(path);
		ef.codeline(path);
		ef.blankline(path);
		ef.commentline(path);
	}

	public static void find(File file,String fileName,List<String> l) {  
		if (file.isDirectory()) {    //�����һ���ļ��У�����true
            File[] f1 = file.listFiles();  //����ĳ����ǰĿ¼�µ������ļ����ļ��еľ���·�������ص���File����
            for (File f : f1) {  
            	find(f,fileName,l); //�ݹ�ִ��
            }  
        }else{
        	if(file.getName().equals(fileName)){
        		l.add(file.getAbsolutePath()); //��ȡ����·��
            }
        }
	}
}
