package com.deitel.wishlist1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
class WishAdapter (private val mWish: List<Wish>) : RecyclerView.Adapter<WishAdapter.ViewHolder>() {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val nameTextView = itemView.findViewById<TextView>(R.id.wish_name)
        val priceTextView = itemView.findViewById<TextView>(R.id.wish_price)
        val urlTextView = itemView.findViewById<TextView>(R.id.wish_url)
    }
    // ... constructor and member variables
    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wish_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: WishAdapter.ViewHolder, position: Int) {
        // Get the data model based on position
        val contact: Wish = mWish.get(position)
        // Set item views based on your views and data model
        val textView = viewHolder.nameTextView
        textView.setText(contact.name)

        val textView2 = viewHolder.priceTextView
        textView2.setText(contact.price)

        val textView3 = viewHolder.urlTextView
        textView3.setText(contact.url)
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return mWish.size
    }
}
