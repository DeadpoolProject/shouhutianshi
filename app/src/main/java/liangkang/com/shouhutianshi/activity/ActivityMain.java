package liangkang.com.shouhutianshi.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.RadioButton;

import com.facebook.drawee.backends.pipeline.Fresco;

import liangkang.com.shouhutianshi.R;

/**
 * Created by Administrator on 2016/6/6.
 */
public class ActivityMain extends ActivityBase {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(ActivityMain.this);
        setContentView(R.layout.activity_main);
        initFragment();
        initClickListen();
    }

    private void initClickListen() {
        RadioButton homepage = (RadioButton) findViewById(R.id.button_homepage);
        RadioButton latest = (RadioButton) findViewById(R.id.button_latest);
        RadioButton release = (RadioButton) findViewById(R.id.button_discuss);
        RadioButton personal = (RadioButton) findViewById(R.id.button_personal);
        homepage.setOnClickListener(this);
        latest.setOnClickListener(this);
        release.setOnClickListener(this);
        personal.setOnClickListener(this);
    }



}
