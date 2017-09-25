package demo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoLinke {
	private static List<String> allUrl = new ArrayList<String>();
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		URL url = new URL("http://news.sina.com.cn");
		URLConnection conn = url.openConnection();
		InputStream is = conn.getInputStream();
		BufferedReader br = new BufferedReader(
				new InputStreamReader(is, "UTF-8"));
		String line = null;
		//超链接规则
		Pattern p1 = Pattern.compile("<a .* href=.*</a>");
		//有效的超链接的规则
		Pattern p2 = Pattern.compile("http://.*\"");
		while((line=br.readLine())!=null) {
			//先找到所有的超链接
			Matcher m1 = p1.matcher(line);
			while(m1.find()) {
				String link = m1.group();
				//找到有效的超链接
				Matcher m2 = p2.matcher(link);
				if(m2.find()) {
					link = m2.group();
					link = link.substring(0, link.indexOf("\""));
					//将有效的超链接放入到集合中去
					allUrl.add(link);
				}
			}
		}
		br.close();
		System.out.println(allUrl);
	}

}
