package liangkang.com.shouhutianshi.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import liangkang.com.shouhutianshi.R;
import liangkang.com.shouhutianshi.adapter.AdapterDiscuss;
import liangkang.com.shouhutianshi.base.Angle_Of_Children;

/**
 * Created by Administrator on 2016/6/7.
 */
public class ActivityLatest extends ActivityBase {
    private TextView tv_name;
    private SimpleDraweeView icon;
    private ListView lv;
    private View headView;
    private Button button_connect1, button_connect2;
    private String mobile1, mobile2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_latest_child);
        initView();
    }

    private void initView() {
        headView = View.inflate(this, R.layout.activity_lasted, null);
        lv = (ListView) findViewById(R.id.list_latest);
        lv.setAdapter(new AdapterDiscuss(this));
        lv.addHeaderView(headView);
        tv_name = (TextView) findViewById(R.id.tv_latest_name);
        button_connect1 = (Button) headView.findViewById(R.id.button_latest_mobile1);
        button_connect2 = (Button) headView.findViewById(R.id.button_latest_mobile2);
        button_connect1.setOnClickListener(this);
        button_connect2.setOnClickListener(this);
        mobile1 = "12345679";
        mobile2 = "12345679";
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_latest_mobile1:
                //拨打电话1
                setDialog(tv_name.getText().toString(), R.array.inform, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                //打电话
                                callMobile(mobile1);
                                dialog.dismiss();
                                return;
                            case 1:
                                dialog.dismiss();
                                Angle_Of_Children.makeToast(getString(R.string.informed));
                                return;
                        }
                    }
                });
                return;
            case R.id.button_latest_mobile2:
                //拨打电话2
                setDialog(tv_name.getText().toString(), R.array.inform, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                callMobile(mobile2);
                                dialog.dismiss();
                                return;
                            case 1:
                                dialog.dismiss();
                                Angle_Of_Children.makeToast(getString(R.string.informed));
                                return;
                        }
                    }
                });
                return;
        }
    }
}
