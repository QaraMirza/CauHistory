package com.example.causcasianhistory;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.causcasianhistory.adapter.DataAdapter;
import com.example.causcasianhistory.adapter.ListItem;
import com.example.causcasianhistory.adapter.RecOnClickListener;

import java.util.ArrayList;
import java.util.List;

public class ReviewActivity extends AppCompatActivity {

    private RecOnClickListener recOnClickListener;
    private DataAdapter adapter;
    private List<ListItem> listItem;
    private RecyclerView recyclerView;
    private static String[] array;
    private static String[] titleArray;
    private static int[] imageArray;

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

        for(int i = 0; i < array.length; i++) {
            ListItem item = new ListItem();
            item.setText(array[i]);
            item.setTitle(titleArray[i]);
            item.setImage(imageArray[i]);
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

    public static void getArray(String[] tempArray, String[] tempTitleArray, int[] tempImageArray) {
        array = tempArray;
        titleArray = tempTitleArray;
        imageArray = tempImageArray;
    }
}