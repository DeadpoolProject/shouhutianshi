package liangkang.com.shouhutianshi.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/6/14.
 */
public class ThreadLogin extends Thread {
    private String url;
    private String username;
    private String password;
    private String userId;
    public ThreadLogin(String url,String username,String password){
        this.url=url;
        this.username=username;
        this.password=password;
    }
    private void doGet(){
        url=url+"?username="+username+"&password="+password;
        try {
            URL httpUrl=new URL(url);
            //获取网络连接
            HttpURLConnection conn= (HttpURLConnection) httpUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setReadTimeout(5000);
            BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String str;
            StringBuffer sb=new StringBuffer();
            while ((str=reader.readLine())!=null){
                sb.append(str);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUserId(){
        return userId;
    }
    @Override
    public void run() {
        doGet();
    }
}
