package com.ualr.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ualr.recyclerview.R;
import com.ualr.recyclerview.model.People;
import com.ualr.recyclerview.utils.Tools;

import java.util.List;

/**
 * Created by irconde on 2019-09-25.
 */

public class AdapterListBasic extends RecyclerView.Adapter{

    private List<People> mItems;
    private Context mContext;

    // TODO 03: We define a new attribute using the created interface
    private OnItemClickListener mOnItemClickListener;

    // TODO 02: We define an interface to communicate the Adapter and the Activity/Fragment

    public interface OnItemClickListener {
        void onItemClick(View view, People obj, int position);
    }

    // TODO 04: We define the set method
    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public AdapterListBasic(Context context, List<People> items) {
        this.mItems = items;
        this.mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder vh;
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_people_chat, parent, false);
        vh = new PersonViewHolder(itemView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        PersonViewHolder viewHolder = (PersonViewHolder)holder;
        People p = mItems.get(position);
        viewHolder.name.setText(p.getName());
        //viewHolder.image.setImageResource(p.image);
        Tools.displayImageRound(mContext, viewHolder.image, p.getImage());
    }

    @Override
    public int getItemCount() {
        return this.mItems.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView name;
        public View lyt_parent;

        /**
         * PersonViewHolder constructor
         * Retrieves references to the ImageView and the TextView inside the the view provided as input parameter
         * The adapter later retrieves view references from these properties when it updates the child views with new data
         *
         * @param v parent item view reference
         */
        public PersonViewHolder(View v) {
            super(v);
            image = v.findViewById(R.id.image);
            name = v.findViewById(R.id.name);
            lyt_parent = v.findViewById(R.id.lyt_parent);
            // TODO 01: Handle click on RecyclerView items
            lyt_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // TODO 06: We invoke the onItemClick method of the listener
                    mOnItemClickListener.onItemClick(view, mItems.get(getAdapterPosition()), getAdapterPosition());
                }
            });
        }
    }
}
