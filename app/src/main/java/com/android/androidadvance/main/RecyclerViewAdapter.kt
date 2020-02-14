package com.android.androidadvance.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.androidadvance.R
import kotlinx.android.synthetic.main.list_items.view.*

class ListAdapter(private val items : List<String>, private val clickListener: (String) -> Unit) :
                                                        RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_items, parent, false)
        return ViewHolder(v, clickListener)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind(items[position])


    class ViewHolder(
        val item: View,
        private val clickListener: (String) -> Unit
    ) : RecyclerView.ViewHolder(item){

        fun onBind(name: String){
            item.txtName.text = name
            item.setOnClickListener{clickListener(name)}

        }


    }
    }










