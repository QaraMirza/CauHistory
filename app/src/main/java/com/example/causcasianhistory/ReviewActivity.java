package com.example.causcasianhistory;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.causcasianhistory.adapter.DataAdapter;
import com.example.causcasianhistory.adapter.ListItem;
import com.example.causcasianhistory.adapter.RecOnClickListener;

import java.util.ArrayList;
import java.util.List;

import com.example.causcasianhistory.MainActivity;

public class ReviewActivity extends AppCompatActivity {

    private RecOnClickListener recOnClickListener;
    private DataAdapter adapter;
    private List<ListItem> listItem;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_content);
        setRecOnClickListener();
        init();
    }

    private void init() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listItem = new ArrayList<>();
        String[] battleArray = getResources().getStringArray(R.array.battles);

        for(int i = 0; i < battleArray.length; i++) {
            ListItem item = new ListItem();
            item.setText(battleArray[i]);
            listItem.add(item);
        }

        adapter = new DataAdapter(this, recOnClickListener, listItem);

        recyclerView.setAdapter(adapter);
    }

    private void setRecOnClickListener() {
        recOnClickListener = new RecOnClickListener() {
            @Override
            public void onItemClicked(int pos) {

            }
        };
    }

    public static void sayHi() {

    }
}