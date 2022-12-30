package com.idat.edu.apppabloburgaa18016822.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.idat.edu.apppabloburgaa18016822.core.adapters.JsonPlaceholderListadoAdapter
import com.idat.edu.apppabloburgaa18016822.databinding.FragmentListadoBinding
import com.idat.edu.apppabloburgaa18016822.ui.viewmodel.JsonPlaceHolderViewModel

class ListadoFragment : Fragment() {

    private lateinit var binding: FragmentListadoBinding
    private lateinit var adapter: JsonPlaceholderListadoAdapter
    private val jsonPlaceHolderViewModel: JsonPlaceHolderViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentListadoBinding.inflate(inflater, container, false)
        setRecyclerView()
        return binding.root
    }

    private fun setRecyclerView() {
        jsonPlaceHolderViewModel.obtenerListadoPrincipal()

        jsonPlaceHolderViewModel.responseListMainData.observe(viewLifecycleOwner, Observer {
            adapter = JsonPlaceholderListadoAdapter(it)
            binding.rcvListaMain.layoutManager = LinearLayoutManager(binding.root.context)
            binding.rcvListaMain.adapter = adapter
        })
    }
}