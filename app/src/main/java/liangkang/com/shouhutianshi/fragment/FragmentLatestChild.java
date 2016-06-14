package liangkang.com.shouhutianshi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import liangkang.com.shouhutianshi.R;
import liangkang.com.shouhutianshi.activity.ActivityLatest;
import liangkang.com.shouhutianshi.adapter.AdapterLasted;
import liangkang.com.shouhutianshi.base.Angle_Of_Children;

/**
 * Created by Administrator on 2016/6/6.
 */
public class FragmentLatestChild extends Fragment{
    private static FragmentLatestChild fragmentLatest;
    private ListView listView;
    private AdapterLasted adapterLasted;
    public static FragmentLatestChild getInstance_fragmentLatest() {
        if (fragmentLatest == null) {
            fragmentLatest = new FragmentLatestChild();
            return fragmentLatest;
        } else {
            return fragmentLatest;
        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_latest_child,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView= (ListView) view.findViewById(R.id.list_latest);
        adapterLasted=new AdapterLasted(Angle_Of_Children.getContext());
        listView.setAdapter(adapterLasted);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getContext(),ActivityLatest.class);
                startActivity(intent);
            }
        });
    }
}
