package liangkang.com.shouhutianshi.activity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.ArrayList;
import java.util.HashMap;

import liangkang.com.shouhutianshi.R;

/**
 * Created by Administrator on 2016/6/7.
 */
public class ActivityBabyInformation extends ActivityBase {
    private Button btn_born_time, btn_lost_time, upload_photo, btn_province, btn_locator, btn_submit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        initview();
    }

    private void initview() {
        btn_born_time = (Button) findViewById(R.id.button_baby_born);
        btn_lost_time = (Button) findViewById(R.id.button_baby_lostTime);
        upload_photo = (Button) findViewById(R.id.button_upload_photo);
        btn_province = (Button) findViewById(R.id.button_province);
        btn_locator = (Button) findViewById(R.id.button_baby_lostAddress);
        btn_submit = (Button) findViewById(R.id.button_information_submit);
        btn_born_time.setOnClickListener(this);
        btn_lost_time.setOnClickListener(this);
        upload_photo.setOnClickListener(this);
        btn_province.setOnClickListener(this);
        btn_submit.setOnClickListener(this);
        initBabyData();
    }


}
