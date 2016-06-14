package liangkang.com.shouhutianshi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import liangkang.com.shouhutianshi.R;
import liangkang.com.shouhutianshi.adapter.AdapterFoucus;

/**
 * Created by Administrator on 2016/6/7.
 */
public class ActivityFocus extends AppCompatActivity{
    private ListView listview_focus;
    private AdapterFoucus adapterFoucus;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_focus);
        initView();
    }

    private void initView() {
        listview_focus= (ListView) findViewById(R.id.list_focus);
        adapterFoucus=new AdapterFoucus(this);
        listview_focus.setAdapter(adapterFoucus);
        View headView=View.inflate(this,R.layout.fragment_focus_item_head,null);
        listview_focus.addHeaderView(headView);
        listview_focus.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getBaseContext(),ActivityLatest.class);
                startActivity(intent);
            }
        });
    }
}
