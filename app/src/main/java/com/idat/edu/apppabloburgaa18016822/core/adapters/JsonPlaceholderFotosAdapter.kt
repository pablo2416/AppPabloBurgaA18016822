package com.idat.edu.apppabloburgaa18016822.core.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.idat.edu.apppabloburgaa18016822.R
import com.idat.edu.apppabloburgaa18016822.data.network.model.JsonPlaceholderFotosModel
import com.idat.edu.apppabloburgaa18016822.databinding.JsonplaceholderphotosTemplateBinding

class JsonPlaceholderFotosAdapter(
    private val context: Context,
    private val listadoFotos: List<JsonPlaceholderFotosModel>,
) :
    RecyclerView.Adapter<JsonPlaceholderFotosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.jsonplaceholderphotos_template, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context)
            .load(listadoFotos[position].thumbnailUrl)
            .into(holder.imvFoto)

        holder.txvAlbumId.text = "AlbumId: ${listadoFotos[position].albumId}"
        holder.txvId.text = "Id: ${listadoFotos[position].id}"
        holder.txvTitle.text = "Title: ${listadoFotos[position].title}"
    }

    override fun getItemCount(): Int = listadoFotos.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = JsonplaceholderphotosTemplateBinding.bind(itemView)
        val imvFoto = binding.imvPhoto
        val txvAlbumId = binding.txvAlbumId
        val txvId = binding.txvIdPhoto
        val txvTitle = binding.txvTitlePhoto
    }
}