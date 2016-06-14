package liangkang.com.shouhutianshi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import liangkang.com.shouhutianshi.R;

/**
 * Created by Administrator on 2016/6/6.
 */
public class FragmentLatest extends Fragment{
    private static FragmentLatest fragmentLatest;
    private ViewPager vp;
    private TabLayout tabLayout;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;
    public static FragmentLatest getInstance_fragmentLatest() {
        if (fragmentLatest == null) {
            fragmentLatest = new FragmentLatest();
            return fragmentLatest;
        } else {
            return fragmentLatest;
        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_latest,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vp= (ViewPager) view.findViewById(R.id.vp_lasted);
        tabLayout= (TabLayout) view.findViewById(R.id.tab_lasted);
        fragments=new ArrayList<>();
        titles=new ArrayList<>();
        titles.add(getString(R.string.child_seek));
        titles.add(getString(R.string.older_seek));
        fragments.add(FragmentLatestChild.getInstance_fragmentLatest());
        fragments.add(FragmentLatestOlder.getInstance_fragmentLatest());
        vp.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }
        });
        tabLayout.setupWithViewPager(vp);


    }
}
