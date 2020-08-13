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
        // TODO 06: Prepare the data source
        List<People> items = DataGenerator.getPeopleData(this);
        items.addAll(DataGenerator.getPeopleData(this));
        items.addAll(DataGenerator.getPeopleData(this));

        // TODO 07: Get a reference to the RecyclerView
        // TODO 08: Create a new LayoutManager and plug it into the RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mBinding.recyclerView.setLayoutManager(layoutManager);

        // TODO 09: Create a new adapter class: AdapterListBasic class

        // TODO 22: Instantiate the adapter (pass its data source) and plug the new instance in the recyclerView
        mAdapter = new AdapterListBasic(this, items);
        mBinding.recyclerView.setAdapter(mAdapter);

    }
}
