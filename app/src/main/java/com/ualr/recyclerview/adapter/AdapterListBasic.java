package com.ualr.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ualr.recyclerview.R;
import com.ualr.recyclerview.model.People;

import java.util.List;

/**
 * Created by irconde on 2019-09-25.
 */

// TODO 10: The new Adapter class must be derived from RecyclerView.Adapter.

// We will have to implement the onCreateViewHolder, onBindViewHolder, and getItemCount methods from the RecyclerView.Adapter class

public class AdapterListBasic extends RecyclerView.Adapter {

    // TODO 11: Define a variable that will contain the data source that is passed into the constructor
    private List<People> mItems;

    // TODO 12: The constructor copies the people collection to the corresponding variable
    public AdapterListBasic(List<People>items)
    {
        this.mItems=items;
    }

    // TODO 13: Add the onCreateViewHolder method
    // This method is called by the layout manager when the RecyclerView needs a new view holder to represent an item
    // So,it inflates the item view from the view's layout file and wraps the view in a new ViewHolder instance
    // TODO 14: We need to define the layout used for each item in the RecyclerView
    // TODO 15: We also need to define the ViewHolder class, used to hold a reference to the different widgets within each row item
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //We don't create a new view we create an instance of the view holder class
        //visible component uses layoutInflater
        LayoutInflater lyInflater= LayoutInflater.from(parent.getContext());
       View itemView= lyInflater.inflate(R.layout.item_people_chat,parent,false);
        //we don't want to attach to root so set false
        RecyclerView.ViewHolder vh= new PersonViewHolder(itemView);

        return vh;

    }
    // TODO 16: We implement the onCreateViewHolder method
    // TODO 17: Inflate the view for a row item
    // TODO 18: Create a ViewHolder to hold view references inside the view

    // TODO 19: Add the onBindViewHolder method
    // This method is called when the layout manager is ready to display a particular view in the Recycler's view
    // visible screen area
    // Basically, the method fills the item at the specified row position with content from the data source
    // Gets the person information for the specified row position (and the corresponding image) and copies this data to the associated views.
    // Views are located via references stored in the view holder object (passed in through the holder parameter)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int index) {
//populate elements in the item with actual data

        PersonViewHolder personViewHolder=(PersonViewHolder) holder;
People p= mItems.get(index);
personViewHolder.name.setText(p.getName());
personViewHolder.image.setImageResource(p.getImage());
    }
    // TODO 20: We can use the glide library just to make the scrolling faster and smoother. We will use the displayImageRound from the Tools class

    // TODO 21: We add the getItemCount method
    // It returns the number of items in the data collection
    @Override
    public int getItemCount() {
        return mItems.size();
    }




    // TODO 15: Typically, we'll define the ViewHolder class as an inner class
    // Each instance holds references to the ImageView and TextView of an associated row item


    private class PersonViewHolder extends RecyclerView.ViewHolder
    {
        //we have this layout in our item_people layout file
        ImageView image;
        TextView name;
        public View lyt_parent; //This provides a reference to the
        //whole (item people chat) layout which its id is lyt_parent

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
            //now we intialize the image member of the class
            //by finding a reference of it in the (item people) layout
            name=itemView.findViewById(R.id.name);
            //we do the same

            lyt_parent= itemView.findViewById(R.id.lyt_parent);
        }
    }
}
