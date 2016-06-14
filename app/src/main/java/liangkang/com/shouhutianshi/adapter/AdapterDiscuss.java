package liangkang.com.shouhutianshi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import liangkang.com.shouhutianshi.R;

/**
 * Created by Administrator on 2016/6/7.
 */
public class AdapterDiscuss extends BaseAdapter{
    private static int COUNT=10;
    private ArrayList<Integer> data=new ArrayList<>(10);
    private LayoutInflater inflater;
    public AdapterDiscuss(Context context){
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       convertView=inflater.inflate(R.layout.fragment_list_item,parent,false);
        return convertView;
    }

}
