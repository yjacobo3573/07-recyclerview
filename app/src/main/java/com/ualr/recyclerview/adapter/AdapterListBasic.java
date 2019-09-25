package com.ualr.recyclerview.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ualr.recyclerview.MainActivity;
import com.ualr.recyclerview.model.People;

import java.util.List;

/**
 * Created by irconde on 2019-09-25.
 */
public class AdapterListBasic extends RecyclerView.Adapter{
    public AdapterListBasic(MainActivity mainActivity, List<People> items) {
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
