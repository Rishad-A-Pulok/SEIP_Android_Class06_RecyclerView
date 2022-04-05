package com.example.class06

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.class06.databinding.EmployeeRowBinding

class EmployeeAdapter(val callback: (Employee) -> Unit): ListAdapter<Employee,EmployeeAdapter.EmployeeViewHolder>(EmployeeDiffUtil()) {

    class EmployeeViewHolder(private val binding: EmployeeRowBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(employee: Employee){
            binding.emp = employee
        }
    }

    class EmployeeDiffUtil: DiffUtil.ItemCallback<Employee>(){

        override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val binding = EmployeeRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return EmployeeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee = getItem(position)
        holder.bind(employee)
        holder.itemView.setOnClickListener {
            callback(employee)
        }
    }
}


// recycler view is called adapter view as well. few adapter views are list view, recycler view, grid view, spinner etc(adapter is used when it comes to collection of data)
// adapter generates a row/grid
// view that works with collection is called adapter view