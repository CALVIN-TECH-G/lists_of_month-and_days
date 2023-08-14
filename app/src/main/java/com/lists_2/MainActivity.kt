package com.lists_2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.lists_2.databinding.ActivityMainBinding
import java.time.Month

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list_mine = binding.listMine
        val months = listOf("January","Febuary","March","April","May","June","July","August","September","October","November","December")
        val days= listOf("30 days","29 days ","31 days","30 days","31 days","30 days","31 days","30 days","31 days","30 days","31 Days","30 Days")

        val arryadapter =  NewAdapter (this, months, days )

        list_mine.adapter = arryadapter
    }
}

class  NewAdapter(context: Context, val months: List<String>, val days : List<String>): ArrayAdapter<String>(context, R.layout.item_list, R.id.months_id, months ){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent)
         val month_id = view.findViewById<TextView>(R.id.months_id)
        val days_id = view.findViewById<TextView>(R.id.days_id)

        month_id.text = months[position]
        days_id.text = days[position]

        return  view

    }
}