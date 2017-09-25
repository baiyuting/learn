package demo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoMobile {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        URL url = new URL("http://www.jihaowang.cn");
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(is));
        //创建规则
        Pattern p1 = Pattern.compile("title=\"1\\d{10}\"");
        Pattern p2 = Pattern.compile("<span class=\"s4\">￥\\d+</span>");
        Pattern p1Content = Pattern.compile("1\\d{10}");
        Pattern p2Content = Pattern.compile("￥\\d+");
        String line = null;

        while ((line = br.readLine()) != null) {
            //匹配规则
            Matcher m1 = p1.matcher(line);
            Matcher m2 = p2.matcher(line);
            try {
                while (m1.find()) {
                    m2.find();
                    String phone = m1.group();
                    Matcher m1Content = p1Content.matcher(phone);
                    m1Content.find();
                    phone = m1Content.group();

                    String price = m2.group();
                    Matcher m2Content = p2Content.matcher(price);
                    m2Content.find();
                    price = m2Content.group();
                    System.out.println(phone + "==>" + price);
                }
            } catch (Exception e) {

            }

        }
        br.close();
    }

}
