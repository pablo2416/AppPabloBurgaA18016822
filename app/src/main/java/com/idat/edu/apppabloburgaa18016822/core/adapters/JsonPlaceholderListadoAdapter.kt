package com.idat.edu.apppabloburgaa18016822.core.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idat.edu.apppabloburgaa18016822.R
import com.idat.edu.apppabloburgaa18016822.data.network.model.JsonPlaceholderListadoModel
import com.idat.edu.apppabloburgaa18016822.databinding.JsonplaceholderTemplateBinding

class JsonPlaceholderListadoAdapter(private val listadoMain: List<JsonPlaceholderListadoModel>) :
    RecyclerView.Adapter<JsonPlaceholderListadoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.jsonplaceholder_template, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txvUserId.text = "UserId: ${listadoMain[position].userId}"
        holder.txvId.text = "Id: ${listadoMain[position].id}"
        holder.txvTitle.text = "Title: ${listadoMain[position].title}"
        holder.txvCompleted.text = "Completed: ${listadoMain[position].completed}"
    }

    override fun getItemCount(): Int = listadoMain.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = JsonplaceholderTemplateBinding.bind(itemView)
        val txvUserId = binding.txvUserId
        val txvId = binding.txvId
        val txvTitle = binding.txvTitle
        val txvCompleted = binding.txvCompleted
    }
}