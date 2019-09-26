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

// TODO 11: The new Adapter class must be derived from RecyclerView.Adapter.
// We will have to implement the onCreateViewHolder, onBindViewHolder, and getItemCount methods from the RecyclerView.Adapter class

public class AdapterListBasic extends RecyclerView.Adapter{

    // TODO 12: Define a variable that will contain the data source that is passed into the constructor
    private List<People> mItems;
    private Context mContext;

    public AdapterListBasic(Context context, List<People> items) {
        // TODO 13: The constructor copies the people collection to the corresponding variable
        this.mItems = items;
        this.mContext = context;
    }

    // TODO 14: Add the onCreateViewHolder method
    // This method is called by the layout manager when the RecyclerView needs a new view holder to represent an item
    // So,it inflates the item view from the view's layout file and wraps the view in a new ViewHolder instance
    // TODO 15: We need to define the layout used for each item in the RecyclerView
    // TODO 16: We also need to define the ViewHolder class, used to hold a reference to the different widgets within each row item

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // TODO 17: We implement the onCreateViewHolder method
        RecyclerView.ViewHolder vh;
        // TODO 18: Inflate the view for a row item
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_people_chat, parent, false);
        // TODO 19: Create a ViewHolder to hold view references inside the view
        vh = new PersonViewHolder(itemView);
        // The resulting view holder instance is returned back to the called (the layout manager)
        return vh;
    }

    // TODO 20: Add the onBindViewHolder method
    // This method is called when the layout manager is ready to display a particular view in the Recycler's view
    // visible screen area
    // Basically, the method fills the item at the specified row position with content from the data source
    // Gets the person information for the specified row position (and the corresponding image) and copies this data to the associated views.
    // Views are located via references stored in the view holder object (passed in through the holder parameter)

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PersonViewHolder viewHolder = (PersonViewHolder)holder;
        // Load information regarding a specific person from people collection
        People p = mItems.get(position);
        // Populate the corresponding TextView
        viewHolder.name.setText(p.getName());
        // Populate the corresponding ImageView.
        // TODO 21: We can use the glide library just to make the scrolling faster and smoother
        //viewHolder.image.setImageResource(p.image);
        Tools.displayImageRound(mContext, viewHolder.image, p.getImage());
    }

    // TODO 22: We add the getItemCount method
    // It returns the number of items in the data collection
    @Override
    public int getItemCount() {
        return this.mItems.size();
    }

    // TODO 16: Typically, we'll define the ViewHolder class as an inner class
    // Each instance holds references to the ImageView and TextView of an associated row item
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
        }
    }
}
