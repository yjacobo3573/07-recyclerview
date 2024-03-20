package com.ualr.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ualr.recyclerview.adapter.AdapterListBasic;
import com.ualr.recyclerview.data.DataGenerator;
import com.ualr.recyclerview.databinding.ActivityMainBinding;
import com.ualr.recyclerview.model.People;

import java.util.List;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       mBinding= ActivityMainBinding.inflate(getLayoutInflater());
       setContentView(mBinding.getRoot());

        initRecyclerView();
    }

    private void initRecyclerView() {
        // TODO 06: Prepare the data source
        List<People> items= DataGenerator.getPeopleData(this);
        items.addAll(DataGenerator.getPeopleData(this));
        items.addAll(DataGenerator.getPeopleData(this));

        // TODO 07: Get a reference to the RecyclerView in the layout
        RecyclerView contactListView= mBinding.recyclerView;
        // TODO 08: Create a LayoutManager and plug it into RecyclerView
        //We will be using linear layout since the list is vertical

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        contactListView.setLayoutManager(layoutManager);


        // TODO 09: Create a new adapter class: AdapterListBasic class
        AdapterListBasic adapter= new AdapterListBasic(items);
        contactListView.setAdapter(adapter);


        // TODO 22: Instantiate the adapter (pass its data source) and plug the new instance into the RecyclerView.
    }
}
