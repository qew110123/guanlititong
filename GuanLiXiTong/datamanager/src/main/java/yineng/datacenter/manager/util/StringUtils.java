package yineng.datacenter.manager.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * Copyright (c)2013,银海艺能  All rights reserved.
 * 
 * <core>字符串的工具类</core>
 * 
 * @author Administrator
 * 
 * @version
 *
 */
public class StringUtils {
	
	public static void main(String[] args){
		
		System.out.println(isEmpty("	 	"));
	}

	/**
	 * @param list
	 * @return
	 */
	public static String listToString(List<?> list){
		StringBuilder sb = new StringBuilder();   
		for (int i = 0; i < list.size(); i++) {  
		    sb.append(list.get(i)+",");  
		}
		if(sb.toString().endsWith(","))
			return sb.substring(0, sb.length()-1);
		return sb.toString();  
	}
	/**
	 * 判断字符串是否是空串
	 * 
	 * @param str
	 * 		待判断的字符串
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (null == str || "".equals(str.trim())) {
			return true;
		}

		Pattern pattern = Pattern.compile("^[\\s|　]\t\r\n*$");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
	/**
	 * 清除字符串中的空格
	 * 
	 * @param str
	 * @return
	 */
	public static String removeStrSpace(String str) {
		if (str == null || str.equals("")) {
			return str;
		}
		Matcher matcher = Pattern.compile("\\s|　|\t|\r|\n").matcher(str);
		return matcher.replaceAll("");
	}
	
	/**
	 * 判断字符串是否是数字
	 * 
	 * @param str
	 * 		待判断的字符串
	 * @return
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}
	
	/**
	 * 字符串截取
	 * @param str
	 * @param reg
	 * @return
	 */
	public static List<String> split(String str, String regex){
		
		List<String> strList = null;
		if(str==null || str.equals("")){
			return strList;
		}
		
		strList = Arrays.asList(str.split(regex));
		
		return strList;
	}
	
	/**
	 * 拆分字符串：“number1, number2, number3”
	 * 
	 * @param str
	 * 		待拆分的字符串
	 * @return
	 */
	public static List<Long> getLongListByStr(String str) {
		List<Long> list = new ArrayList<Long>();
		
		if(!StringUtils.isEmpty(str)) {
			if(str.indexOf(",") != -1) {
				String []strArr = str.split(",");
				for(String s: strArr) {
					if(StringUtils.isNumeric(s)) {
						list.add(Long.valueOf(s));
					}
				}
			}
			else {
				if(StringUtils.isNumeric(str.trim())) {
					list.add(Long.valueOf(str.trim()));
				}
			}
		}
		
		return list;
	}
	
	/**
	 * 拆分字符串：“number1, number2, number3”
	 * 
	 * @param str
	 * 		待拆分的字符串
	 * @return
	 */
	public static List<Integer> getIntegerListByStr(String str) {
		List<Integer> list = new ArrayList<Integer>();
		
		if(!StringUtils.isEmpty(str)) {
			if(str.indexOf(",") != -1) {
				String []strArr = str.split(",");
				for(String s: strArr) {
					if(StringUtils.isNumeric(s.trim())) {
						list.add(Integer.valueOf(s.trim()));
					}
				}
			}
			else {
				if(StringUtils.isNumeric(str.trim())) {
					list.add(Integer.valueOf(str.trim()));
				}
			}
		}
		
		return list;
	}	
	
    /**
	 * 将字符串中的全角数字转换为半角
	 * @param str：
	 * @return
	 */
	public static String numberTransform(String str){
		if(str==null || str.equals("")){
			return null;
		}
		
		StringBuffer newStr = new StringBuffer();
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			switch(ch){
			case '０':
				newStr.append(0);
				break;
			case '１':
				newStr.append(1);
				break;
			case '２':
				newStr.append(2);
				break;
			case '３':
				newStr.append(3);
				break;
			case '４':
				newStr.append(4);
				break;
			case '５':
				newStr.append(5);
				break;
			case '６':
				newStr.append(6);
				break;
			case '７':
				newStr.append(7);
				break;
			case '８':
				newStr.append(8);
				break;
			case '９':
				newStr.append(9);
				break;
			default:
				newStr.append(ch);
			}
		}
		return newStr.toString();
	}

}
