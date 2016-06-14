package liangkang.com.shouhutianshi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import liangkang.com.shouhutianshi.R;

/**
 * Created by Administrator on 2016/6/8.
 */
public class FragmentMain extends FragmentBase{
    private static FragmentMain fragmentMain;
    private Button button_add;
    private Button button_finger;
    public static FragmentMain getInstanceFragmentMain(){
        if (fragmentMain==null){
            fragmentMain=new FragmentMain();
        }
        return fragmentMain;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button_add= (Button) view.findViewById(R.id.button_addNews);
        button_finger= (Button) view.findViewById(R.id.button_fingerPrint);
        button_add.setOnClickListener(this);
        button_finger.setOnClickListener(this);
    }
}
