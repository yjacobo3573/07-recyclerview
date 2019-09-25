package com.ualr.recyclerview.adapter;

/**
 * Created by irconde on 2019-09-25.
 */

// TODO 11: The new Adapter class must be derived from RecyclerView.Adapter.
// We will have to implement the onCreateViewHolder, onBindViewHolder, and getItemCount methods from the RecyclerView.Adapter class

public class AdapterListBasic {

    // TODO 12: Define a variable that will contain the data source that is passed into the constructor

    // TODO 13: The constructor copies the people collection to the corresponding variable

    // TODO 14: Add the onCreateViewHolder method
    // This method is called by the layout manager when the RecyclerView needs a new view holder to represent an item
    // So,it inflates the item view from the view's layout file and wraps the view in a new ViewHolder instance
    // TODO 15: We need to define the layout used for each item in the RecyclerView
    // TODO 16: We also need to define the ViewHolder class, used to hold a reference to the different widgets within each row item

    // TODO 17: We implement the onCreateViewHolder method
    // TODO 18: Inflate the view for a row item
    // TODO 19: Create a ViewHolder to hold view references inside the view

    // TODO 20: Add the onBindViewHolder method
    // This method is called when the layout manager is ready to display a particular view in the Recycler's view
    // visible screen area
    // Basically, the method fills the item at the specified row position with content from the data source
    // Gets the person information for the specified row position (and the corresponding image) and copies this data to the associated views.
    // Views are located via references stored in the view holder object (passed in through the holder parameter)

    // TODO 21: We can use the glide library just to make the scrolling faster and smoother. We will use the displayImageRound from the Tools class

    // TODO 22: We add the getItemCount method
    // It returns the number of items in the data collection

    // TODO 16: Typically, we'll define the ViewHolder class as an inner class
    // Each instance holds references to the ImageView and TextView of an associated row item

}
