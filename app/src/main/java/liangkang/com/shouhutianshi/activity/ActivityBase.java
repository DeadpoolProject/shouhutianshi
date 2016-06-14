package liangkang.com.shouhutianshi.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import liangkang.com.shouhutianshi.R;
import liangkang.com.shouhutianshi.base.Angle_Of_Children;
import liangkang.com.shouhutianshi.fragment.FragmentInformation;
import liangkang.com.shouhutianshi.fragment.FragmentLatest;
import liangkang.com.shouhutianshi.fragment.FragmentFocus;
import liangkang.com.shouhutianshi.fragment.FragmentMain;
import liangkang.com.shouhutianshi.fragment.FragmentPerson;

/**
 * Created by Administrator on 2016/6/6.
 */
public class ActivityBase extends AppCompatActivity implements View.OnClickListener {
    private FragmentMain fragmentMain;
    private FragmentLatest fragmentLatest;
    private FragmentFocus fragmentFocus;
    private FragmentPerson fragmentPerson;
    private ArrayList<Fragment> fragments;
    private static int FRAGMENTMAIN = 0;
    private static int FRAGMENTLATEST = 1;
    private static int FRAGMENTDISCUSS = 2;
    private static int FRAGMENTPERSON = 3;
    private String[] provinces;
    private int baby_year, baby_month, baby_day;
    private int lost_year, lost_month, lost_day;
    private HashMap<String, Integer> cities, towns;
    private String province, city, town;

    //加载碎片
    public void initBabyData() {
        provinces = getResources().getStringArray(R.array.province_select);
        cities = new HashMap<>();
        cities.put("jiangsu", R.array.jiangsu_select);
    }

    public void initFragment() {
        fragmentMain = FragmentMain.getInstanceFragmentMain();
        fragmentFocus = FragmentFocus.getInstance_fragmentNews();
        fragmentLatest = FragmentLatest.getInstance_fragmentLatest();
        fragmentPerson = FragmentPerson.getInstance_fragmentPerson();
        fragments = new ArrayList<>();
        fragments.add(fragmentMain);
        fragments.add(fragmentLatest);
        fragments.add(fragmentFocus);
        fragments.add(fragmentPerson);
        for (Fragment fragment : fragments) {
            getFragmentTransaction().add(R.id.frame_main, fragment).commit();
        }
        showFragment(fragmentMain, FRAGMENTMAIN);
    }

    private void showFragment(Fragment fragment, int TAG) {
        for (int i = 0; i < 4; i++) {
            if (TAG == i) {
                getFragmentTransaction().show(fragment).commit();
            } else {
                getFragmentTransaction().hide(fragments.get(i)).commit();
            }
        }
    }

    public FragmentTransaction getFragmentTransaction() {
        return getSupportFragmentManager().beginTransaction();
    }


    @Override
    public void onClick(final View v) {
        switch (v.getId()) {
            case R.id.button_homepage:
                //主页
                showFragment(fragmentMain, FRAGMENTMAIN);
                return;
            case R.id.button_latest:
                //最近消息
                showFragment(fragmentLatest, FRAGMENTLATEST);
                return;
            case R.id.button_discuss:
                //讨论组
                showFragment(fragmentFocus, FRAGMENTDISCUSS);
                return;
            case R.id.button_personal:
                //我的
                showFragment(fragmentPerson, FRAGMENTPERSON);
                return;


            case R.id.button_baby_born:
                //宝宝信息中弹出出生日期
                DatePickerDialog dialog = new DatePickerDialog(v.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        baby_year = year;
                        baby_month = monthOfYear + 1;
                        baby_day = dayOfMonth;
                        ((Button) v).setText("" + year + getString(R.string.year) +
                                baby_month + getString(R.string.month) +
                                dayOfMonth + getString(R.string.day));
                    }
                }, 2000, 0, 1);
                dialog.show();
                return;
            case R.id.button_baby_lostTime:
                //宝宝信息中的丢失日期
                DatePickerDialog dialogLost = new DatePickerDialog(v.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        lost_year = year;
                        lost_month = monthOfYear + 1;
                        lost_day = dayOfMonth;
                        ((Button) v).setText("" + year + getString(R.string.year) +
                                lost_month + getString(R.string.month) +
                                dayOfMonth + getString(R.string.day));
                    }
                }, 2000, 0, 1);
                dialogLost.show();
                return;
            case R.id.button_upload_photo:
                //上传照片
                setDialog(getString(R.string.upload), R.array.photo_select, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                return;
            case R.id.button_province:
                //城市信息
                setDialog(getString(R.string.choose_province), R.array.province_select, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < provinces.length; i++) {
                            if (i == which) {
                                dialog.dismiss();
                                province = provinces[i];
                                setDialog(provinces[i], cities.get("jiangsu"), new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                        city = getResources().getStringArray(cities.get("jiangsu"))[which];
                                        ((Button) v).setText(province + city);
                                    }
                                });
                            }
                        }

                    }
                });
                return;
            case R.id.button_baby_lostAddress:
                //丢失的地址
                return;
            case R.id.button_information_submit:
                //信息填完结束以后的判断
                AlertDialog.Builder dialog_submit = new AlertDialog.Builder(v.getContext());
                dialog_submit.setTitle(getString(R.string.submit));
                dialog_submit.setPositiveButton(getText(R.string.sure_submit), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });
                dialog_submit.setNegativeButton(getText(R.string.cancel_submit), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog_submit.show();
                return;
        }
    }



    public void setDialog(String title, int array, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(title);
        dialog.setItems(array, onClickListener);
        dialog.show();
    }

    public void callMobile(String mobile){
        Intent call = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + mobile));
        boolean permission = (PackageManager.PERMISSION_GRANTED ==
                getPackageManager().checkPermission("android.permission.CALL_PHONE", "liangkang.com.shouhutianshi"));
        if(permission){
        startActivity(call);
        }else{
            Angle_Of_Children.makeToast(getString(R.string.NotCall));
        }

    }
}
