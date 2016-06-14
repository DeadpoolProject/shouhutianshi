package liangkang.com.shouhutianshi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import liangkang.com.shouhutianshi.R;

/**
 * Created by Administrator on 2016/6/7.
 */
public class ActivityLogin extends ActivityBase{
    private Button btn_login,btn_register,btn_forgetPassword;
    private EditText et_account,et_password;
    private String account,password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        btn_login= (Button) findViewById(R.id.button_login);
        btn_register= (Button) findViewById(R.id.button_register);
        btn_forgetPassword= (Button) findViewById(R.id.button_passwordForget);
        et_account = (EditText) findViewById(R.id.et_account);
        et_password= (EditText) findViewById(R.id.et_password);
        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
        btn_forgetPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_login:
                //登录
                login(account,password);
                return;
            case R.id.button_register:
                //注册
                Intent intent1=new Intent(this,ActivityRegister.class);
                startActivity(intent1);
                return;
            case R.id.button_passwordForget:
                //忘记密码
                Intent intent2=new Intent(this,ActivityForgetPassword.class);
                startActivity(intent2);
                return;
        }
    }
    public void login(String account,String password) {

    }
}
