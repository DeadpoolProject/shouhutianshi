package liangkang.com.shouhutianshi.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import liangkang.com.shouhutianshi.R;

/**
 * Created by luying on 16/6/15.
 */
public class LoadingDialog extends Dialog {

    private TextView tv;
    private LinearLayout waitingDialogll;

    public LoadingDialog(Context context) {
        super(context, R.style.WaitingDialogStyle);
        setContentView(R.layout.waiting_dialog);
        tv = (TextView) findViewById(R.id.setting_wait_dialog_tv);
        waitingDialogll = (LinearLayout) findViewById(R.id.waitingDialog);
        getWindow().setGravity(Gravity.CENTER);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);

    }
    public void showDialog(String s) {
        super.show();
        tv.setText("");
//        waitingDialogll.setBackgroundResource(R.drawable.roundcorner_rect);//颜色较深的框框
    }

    @Override
    public void show() {
        super.show();
        //        waitingDialogll.setBackgroundResource(R.drawable.roundcorner_rect);//颜色较深的框框
    }

    @Override
    public void cancel() {
        super.cancel();
    }
    public void delayCancel() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                cancel();
            }
        }, 500);
    }

}
