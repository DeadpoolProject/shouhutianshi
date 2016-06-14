package liangkang.com.shouhutianshi.base;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/6/7.
 */
public class Angle_Of_Children extends Application {
    private static Context context;
    private static String SHOUHUTIANSHI="The Angle Of Children";//文件名
    private static String ISFIRST="IsFirst";
    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }
    public static Context getContext(){
        return context;
    }
    public static boolean isFirst(){
        SharedPreferences sharedPreferences=context.getSharedPreferences(SHOUHUTIANSHI,MODE_PRIVATE);
        boolean isFirst=sharedPreferences.getBoolean(ISFIRST,true);
        if (isFirst){
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putBoolean(ISFIRST,false).apply();

        }
        return isFirst;
    }
    public static void makeToast(String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();


    }
}
