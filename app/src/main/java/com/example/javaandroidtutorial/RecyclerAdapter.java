package com.example.javaandroidtutorial;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<RecyclerBean> data;
    private Context context;

    public RecyclerAdapter(List<RecyclerBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.recyclerview_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv.setText(data.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mOnItemClickListener != null){
                        mOnItemClickListener.onRecyclerItemClickListener(getAdapterPosition());
                    }
                }
            });

        }
    }


    //set up onclick listener
    private OnRecyclerItemClickListener mOnItemClickListener;

    public void  setRecyclerItemClickListener(OnRecyclerItemClickListener listener){
        mOnItemClickListener = listener;
    }

    public interface OnRecyclerItemClickListener{
        void onRecyclerItemClickListener(int position);
    }
}
