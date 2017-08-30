package org.jdc.template.ux.directory

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item.view.*
import org.jdc.template.R
import org.jdc.template.model.database.main.individual.Individual

class DirectoryAdapter : RecyclerView.Adapter<DirectoryAdapter.ViewHolder>() {

    var list: List<Individual> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var itemClickListener: (Individual) -> Unit = {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent).apply {
            clickListener = { itemClickListener(list[it.adapterPosition]) }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val individual = list[position]

        // bind data to view holder
        holder.itemView.listItemTextView.text = individual.getFullName()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)) {
        init {
            itemView.setOnClickListener { clickListener(this) }
        }

        var clickListener: (ViewHolder) -> Unit = {}
    }
}
