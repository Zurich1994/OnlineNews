package com.news.dao.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Description: ��ʼ�����дʿ⣬�����дʼ��뵽HashMap�У�����DFA�㷨ģ��
 * @Project��test
 * @Author : chenming
 * @Date �� 2014��4��20�� ����2:27:06
 * @version 1.0
 */
public class SensitiveWordInit {
	private String ENCODING = "GBK";    //�ַ�����
	@SuppressWarnings("rawtypes")
	public HashMap sensitiveWordMap;
	
	public SensitiveWordInit(){
		super();
	}

	@SuppressWarnings("rawtypes")
	public Map initKeyWord(){
		try {
			//��ȡ���дʿ�
			Set<String> keyWordSet = readSensitiveWordFile();
			//�����дʿ���뵽HashMap��
			addSensitiveWordToHashMap(keyWordSet);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return sensitiveWordMap;
	}

	/**
	 * ��ȡ���дʿ⣬�����дʷ���HashSet�У�����һ��DFA�㷨ģ�ͣ�<br>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void addSensitiveWordToHashMap(Set<String> keyWordSet) {
		sensitiveWordMap = new HashMap(keyWordSet.size());     //��ʼ�����д��������������ݲ���
		String key = null;  
		Map nowMap = null;
		Map<String, String> newWorMap = null;
		//����keyWordSet
		Iterator<String> iterator = keyWordSet.iterator();
		while(iterator.hasNext()){
			key = iterator.next();    //�ؼ���
			nowMap = sensitiveWordMap;
			for(int i = 0 ; i < key.length() ; i++){
				char keyChar = key.charAt(i);       //ת����char��
				Object wordMap = nowMap.get(keyChar);       //��ȡ
				
				if(wordMap != null){        //������ڸ�key��ֱ�Ӹ�ֵ
					nowMap = (Map) wordMap;
				}
				else{     //���������򹹽�һ��map��ͬʱ��isEnd����Ϊ0����Ϊ���������һ��
					newWorMap = new HashMap<String,String>();
					newWorMap.put("isEnd", "0");     //�������һ��
					nowMap.put(keyChar, newWorMap);
					nowMap = newWorMap;
				}
				
				if(i == key.length() - 1){
					nowMap.put("isEnd", "1");    //���һ��
				}
//				System.out.println(sensitiveWordMap);
			}
			
		}
	}


	private Set<String> readSensitiveWordFile() throws Exception{
		Set<String> set = null;
		String rootPath=getClass().getResource("/").toString();
		rootPath=rootPath.substring(6, rootPath.length()-1);
		File file = new File(rootPath+"/���дʿ�.txt");    //��ȡ�ļ�
		InputStreamReader read = new InputStreamReader(new FileInputStream(file),ENCODING);
		try {
			if(file.isFile() && file.exists()){      //�ļ����Ƿ����
				set = new HashSet<String>();
				BufferedReader bufferedReader = new BufferedReader(read);
				String txt = null;
				while((txt = bufferedReader.readLine()) != null){    //��ȡ�ļ������ļ����ݷ��뵽set��
					set.add(txt);
			    }
			}
			else{         //�������׳��쳣��Ϣ
				throw new Exception("���дʿ��ļ�������");
			}
		} catch (Exception e) {
			throw e;
		}finally{
			read.close();     //�ر��ļ���
		}
		return set;
	}
}
