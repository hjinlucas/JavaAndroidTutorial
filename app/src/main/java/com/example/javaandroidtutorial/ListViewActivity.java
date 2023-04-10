package com.example.javaandroidtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private List<Bean> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        for(int i = 0; i < 100; i++){
            Bean bean = new Bean();
            bean.setName("test" + i);
            data.add(bean);
        }

        ListView listView = findViewById(R.id.lv);
        listView.setAdapter(new ListViewAdapter(data, this));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("LUC", "onItemClick: " + i );
            }
        });

    }



}