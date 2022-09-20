package com.deitel.wishlist1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var  wishes: ArrayList<Wish>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.textView)
        val button = findViewById<Button>(R.id.button2)
        val amount = findViewById<EditText>(R.id.textView2)
        val url = findViewById<EditText>(R.id.textView3)

        wishes = ArrayList()
        button.setOnClickListener {
            val enter = editText.text.toString()
            val enter2 = amount.text.toString()
            val enter3 = url.text.toString()
            wishes.add(Wish(enter, enter2, enter3))
            editText.text.clear()
            amount.text.clear()
            url.text.clear()

            // Lookup the recyclerview in activity layout
            val rvContacts = findViewById<View>(R.id.nameRv) as RecyclerView
            // Create adapter passing in the sample user data
            val adapter = WishAdapter(wishes)
            // Attach the adapter to the recyclerview to populate items
            rvContacts.adapter = adapter
            // Set layout manager to position the items
            rvContacts.layoutManager = LinearLayoutManager(this)
            // That's all!
        }
    }
}