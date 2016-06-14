package liangkang.com.shouhutianshi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import liangkang.com.shouhutianshi.R;

/**
 * Created by Administrator on 2016/6/6.
 */
public class FragmentInformation extends Fragment {
    private static FragmentInformation fragmentInformation;

    public static FragmentInformation getInstance_FragmentInformation() {
        if (fragmentInformation == null) {
            fragmentInformation = new FragmentInformation();
            return fragmentInformation;
        } else {
            return fragmentInformation;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_information, container, false);
    }
}
