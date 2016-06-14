package liangkang.com.shouhutianshi.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import liangkang.com.shouhutianshi.R;

/**
 * Created by Administrator on 2016/6/14.
 */
public class ActivityForgetPassword extends ActivityBase {
    private Button btn_send, btn_test;
    private EditText et_num,et_auth;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        initView();
    }

    private void initView() {
        btn_send = (Button) findViewById(R.id.button_sendMessage);
        btn_test = (Button) findViewById(R.id.button_test);
        et_num= (EditText) findViewById(R.id.et_mobile);
        et_auth= (EditText) findViewById(R.id.et_authCode);
        btn_send.setOnClickListener(this);
        btn_test.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_sendMessage:
                return;
            case R.id.button_test:
                return;
        }
    }
}
