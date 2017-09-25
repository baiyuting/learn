package demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoRegex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//如果是一个反斜扛会被认为是转义字符，所以需要再加一个
		String regex = "1\\d{10}";
		System.out.println("23900000009".matches(regex));


		String str = "asdf13209099090ewewr13987877873";
		//Pattern对象用来声明规则
		Pattern p = Pattern.compile("1\\d{10}");
		//使用p的规则去匹配str
		Matcher m = p.matcher(str);
		//遍历循环提取匹配规则的内容
		while(m.find()) {
			//提取内容
			String phoneNum = m.group();
			System.out.println(phoneNum);
		}
	}

}
