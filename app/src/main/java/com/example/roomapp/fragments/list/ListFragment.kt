package com.example.roomapp.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomapp.R
import com.example.roomapp.data.NamesViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment() {

    private lateinit var mNamesViewModel: NamesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        // Recyclerview
        val adapter = ListAdapter()
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // NamesViewModel
        mNamesViewModel = ViewModelProvider(this).get(NamesViewModel::class.java)
        mNamesViewModel.readAllData.observe(viewLifecycleOwner, Observer { names ->
            adapter.setData(names)
        })

        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        return view
    }

}