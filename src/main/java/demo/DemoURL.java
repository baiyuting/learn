package demo;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class DemoURL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//用来保存抓取页面的文件夹
			String savePath = "D:/savePath/";
			String fileName = System.currentTimeMillis() + ".txt";
			File file = new File(savePath + fileName);
			PrintWriter pw = new PrintWriter(file);
			// 根据种子页面创建URL对象
			URL url = new URL("http://news.sina.com.cn");
			// 建立连接
			URLConnection conn = url.openConnection();
			// 获取网页中的内容，会以字节流的形式返回
			InputStream is = conn.getInputStream();
			//我们想要逐行读取，但是is是字节流，只能挨个字节读取
			//所以需要使用缓冲流
			//先将is转换成字符流，然后再使用缓冲流来读取
			//如果需要转码，那么在is后面要加相应的字符编码
			BufferedReader br = new BufferedReader(
					new InputStreamReader(is, "UTF-8"));
			//用来接收每次读取的一行内容
			String line = null;
			//将读取出来的一行内容赋值给line,然后判断line是否为空。
			//如果读取的是null值，就意味着读取到了最后。
			while((line=br.readLine())!=null) {
				pw.println(line);
			}
			//关闭连接
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
