package com.ualr.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ualr.recyclerview.adapter.AdapterListBasic;
import com.ualr.recyclerview.data.DataGenerator;
import com.ualr.recyclerview.model.Item;
import com.ualr.recyclerview.model.People;
import com.ualr.recyclerview.model.SectionHeader;
import com.ualr.recyclerview.utils.Tools;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int DEFAULT_POS = 2;

    private RecyclerView recyclerView;
    private AdapterListBasic mAdapter;
    private List<Item> mDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }

    private void initRecyclerView() {
        mDataSource = DataGenerator.getPeopleData(this);

        mAdapter = new AdapterListBasic(this, mDataSource);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(mAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // TODO 05: Invoke the removeItem method
        mAdapter.setOnItemClickListener(new AdapterListBasic.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mAdapter.removeItem(position);
            }
        });

        FloatingActionButton addBtn = findViewById(R.id.floating_action_button);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO 09: Invoke adapter's addItem method to add new item to the recyclerview
                mAdapter.addItem(DEFAULT_POS, mDataSource.get(Tools.getRandomNumberInRange(0, mDataSource.size()-1)));
                // TODO 10: Scroll to newly added item position
                recyclerView.scrollToPosition(DEFAULT_POS);
            }
        });
    }
}
