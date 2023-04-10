package com.example.javaandroidtutorial.listview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.javaandroidtutorial.R;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    private List<Bean> data;
    private Context context;

    public ListViewAdapter(List<Bean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            viewHolder.textView = convertView.findViewById(R.id.tv);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //find view waste time, create viewHolder to solve this
        //TextView textView = convertView.findViewById(R.id.tv);
        //textView.setText(data.get(position).getName());

        Log.e("LUC", "getView: " + position );

        return convertView;
    }

    private final class ViewHolder{
        TextView textView;
    }
}
