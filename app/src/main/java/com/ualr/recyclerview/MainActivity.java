package com.ualr.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.ualr.recyclerview.adapter.AdapterListBasic;
import com.ualr.recyclerview.data.DataGenerator;
import com.ualr.recyclerview.model.Item;
import com.ualr.recyclerview.databinding.ActivityMainBinding;
import com.ualr.recyclerview.utils.Tools;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int DEFAULT_POS = 2;

    private ActivityMainBinding mBinding;
    private AdapterListBasic mAdapter;
    private List<Item> mDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        initRecyclerView();
    }

    private void initRecyclerView() {
        mDataSource = DataGenerator.getPeopleData(this);

        mAdapter = new AdapterListBasic(this, mDataSource);
        mBinding.recyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mBinding.recyclerView.setLayoutManager(layoutManager);

        // TODO 05: Invoke the removeItem method
        mAdapter.setOnItemClickListener(new AdapterListBasic.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mAdapter.removeItem(position);
            }
        });

        mBinding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO 09: Invoke adapter's addItem method to add new item to the recyclerview
                mAdapter.addItem(DEFAULT_POS,mDataSource.get(Tools.getRandomNumberInRange(0, mDataSource.size()-1)));
                //Default_Pos is a tag defined above with position 2
                //mDataSource= DataGenerator.getPeopleData(this);
                //gets the items data photos and name
                // TODO 10: Scroll to newly added item position
                mBinding.recyclerView.scrollToPosition(DEFAULT_POS);

            }
        });

    }
}
