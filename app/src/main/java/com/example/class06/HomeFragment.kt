package com.example.class06

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.class06.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val adapter = EmployeeAdapter {
            Toast.makeText(activity, "${it.name}", Toast.LENGTH_SHORT).show()
        }
        binding.employeeRV.layoutManager = LinearLayoutManager(activity)
        binding.employeeRV.adapter = adapter
        adapter.submitList(empList)
        return binding.root
    }
}