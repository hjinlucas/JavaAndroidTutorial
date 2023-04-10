package com.example.javaandroidtutorial.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.javaandroidtutorial.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private List<RecyclerBean> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycl_view);

        for(int i = 9000; i < 20000; i++){
            if (i % 4 != 0){
                continue;
            }
            RecyclerBean recyclerBean = new RecyclerBean();
            recyclerBean.setName("test" + i);
            data.add(recyclerBean);
        }

        RecyclerView recyclerView = findViewById(R.id.rv);

//        Display Style 1
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(linearLayoutManager);

//        Display Style 2
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);

//        Display Style 3
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, LinearLayout.VERTICAL);
//        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(data, this);
        recyclerView.setAdapter(recyclerAdapter);

        recyclerAdapter.setRecyclerItemClickListener(new RecyclerAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onRecyclerItemClickListener(int position) {
                Log.e("LUC", "onRecyclerItemClickListener: " + position );
            }
        });

    }
}