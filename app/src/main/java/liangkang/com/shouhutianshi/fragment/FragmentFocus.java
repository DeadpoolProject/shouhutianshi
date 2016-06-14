package liangkang.com.shouhutianshi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import liangkang.com.shouhutianshi.R;
import liangkang.com.shouhutianshi.activity.ActivityFocus;
import liangkang.com.shouhutianshi.adapter.AdapterDiscuss;
import liangkang.com.shouhutianshi.adapter.AdapterFoucus;
import liangkang.com.shouhutianshi.base.Angle_Of_Children;

/**
 * Created by Administrator on 2016/6/6.
 */
public class FragmentFocus extends Fragment {
    private static FragmentFocus fragmentFocus;
    private ListView listview;
    private AdapterDiscuss adapterDiscuss;
    public static FragmentFocus getInstance_fragmentNews() {
        if (fragmentFocus == null) {
            fragmentFocus = new FragmentFocus();
            return fragmentFocus;
        } else {
            return fragmentFocus;
        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_focus,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        listview= (ListView) view.findViewById(R.id.list_focus);
        adapterDiscuss = new AdapterDiscuss(getContext());
        View headView=View.inflate(getContext(),R.layout.fragment_focus_head,null);
        listview.addHeaderView(headView);
        listview.setAdapter(adapterDiscuss);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getContext(),ActivityFocus.class);
                startActivity(intent);
            }
        });
    }
}
