package liangkang.com.shouhutianshi.fragment;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.View;

import liangkang.com.shouhutianshi.R;
import liangkang.com.shouhutianshi.activity.ActivityBabyInformation;
import liangkang.com.shouhutianshi.activity.ActivityLogin;

/**
 * Created by Administrator on 2016/6/8.
 */
public class FragmentBase extends Fragment implements View.OnClickListener{
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //添加信息
            case R.id.button_addNews:
                final String[] persons={getString(R.string.old),getString(R.string.child)};
                final AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                builder.setIcon(R.mipmap.icon);
                builder.setTitle(R.string.personAdd);
                builder.setSingleChoiceItems(persons, 0, null);
                builder.setPositiveButton(R.string.sure,new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Intent informationActivity=new Intent(getContext(), ActivityBabyInformation.class);
                    startActivity(informationActivity);
                }
            });
                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();


                return;
            //指纹录入
            case R.id.button_fingerPrint:
                DatePickerDialog dialog=new DatePickerDialog(getContext(),null,2016,12,31);
                dialog.show();
                return;

            //注册登录
            case R.id.button_mine_login:
                Intent intent=new Intent(getContext(),ActivityLogin.class);
                startActivity(intent);
                return;
        }
    }
}
