package liangkang.com.shouhutianshi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import liangkang.com.shouhutianshi.R;

/**
 * Created by Administrator on 2016/6/6.
 */
public class FragmentPerson extends FragmentBase{
    private static FragmentPerson fragmentPerson;
    private Button btn_login;
    public static FragmentPerson getInstance_fragmentPerson() {
        if (fragmentPerson == null) {
            fragmentPerson = new FragmentPerson();
            return fragmentPerson;
        } else {
            return fragmentPerson;
        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_person,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        btn_login= (Button) view.findViewById(R.id.button_mine_login);
        btn_login.setOnClickListener(this);
    }
}
