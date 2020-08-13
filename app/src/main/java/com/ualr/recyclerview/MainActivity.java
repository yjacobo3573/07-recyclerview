package com.ualr.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ualr.recyclerview.adapter.AdapterListBasic;
import com.ualr.recyclerview.data.DataGenerator;
import com.ualr.recyclerview.databinding.ActivityMainBinding;
import com.ualr.recyclerview.model.People;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ActivityMainBinding mBinding;
    private AdapterListBasic mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        initRecyclerView();
    }

    private void initRecyclerView() {
        List<People> items = DataGenerator.getPeopleData(this);
        items.addAll(DataGenerator.getPeopleData(this));
        items.addAll(DataGenerator.getPeopleData(this));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mBinding.recyclerView.setLayoutManager(layoutManager);
        mAdapter = new AdapterListBasic(this, items);

        // TODO 05: We plug a new listener in the adapter

        mBinding.recyclerView.setAdapter(mAdapter);

    }
}
