package liangkang.com.shouhutianshi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import liangkang.com.shouhutianshi.R;

/**
 * Created by Administrator on 2016/6/7.
 */
public class AdapterRecycle extends RecyclerView.Adapter<AdapterRecycle.MyHolder>{
    private LayoutInflater inflater;

    public AdapterRecycle(Context context) {
        inflater= LayoutInflater.from(context);
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.fragment_list_draw,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 12;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        public MyHolder(View itemView) {
            super(itemView);
        }
    }
}
