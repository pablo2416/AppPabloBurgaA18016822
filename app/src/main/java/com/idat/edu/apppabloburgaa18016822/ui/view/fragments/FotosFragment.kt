package com.idat.edu.apppabloburgaa18016822.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.idat.edu.apppabloburgaa18016822.core.adapters.JsonPlaceholderFotosAdapter
import com.idat.edu.apppabloburgaa18016822.databinding.FragmentFotosBinding
import com.idat.edu.apppabloburgaa18016822.ui.viewmodel.JsonPlaceHolderViewModel

class FotosFragment : Fragment() {

    private lateinit var binding: FragmentFotosBinding
    private lateinit var adapter: JsonPlaceholderFotosAdapter
    private val jsonPlaceHolderViewModel: JsonPlaceHolderViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentFotosBinding.inflate(inflater, container, false)
        setRecycletView()
        return binding.root
    }

    private fun setRecycletView() {
        jsonPlaceHolderViewModel.obtenerListadoFotos()

        jsonPlaceHolderViewModel.responseListFotos.observe(viewLifecycleOwner, Observer {
            adapter = JsonPlaceholderFotosAdapter(binding.root.context, it)
            binding.rcvFotos.layoutManager = LinearLayoutManager(binding.root.context)
            binding.rcvFotos.adapter = adapter
        })
    }
}