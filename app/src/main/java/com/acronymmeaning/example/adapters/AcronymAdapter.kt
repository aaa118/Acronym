package com.acronymmeaning.example.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.acronymmeaning.example.R
import com.acronymmeaning.example.databinding.RowLayoutBinding
import com.acronymmeaning.example.model.Lf
import kotlinx.android.synthetic.main.row_layout.view.*

class AcronymAdapter(var listLf: List<Lf>) : RecyclerView.Adapter<AcronymAdapter.ViewHolder>() {
    lateinit var binding: RowLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_layout,
            parent,
            false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sf = listLf[position]
        binding.model  = sf
    }

    override fun getItemCount(): Int {
        return listLf.size
    }


    fun updateItems(items: List<Lf>?) {
        listLf = items ?: emptyList()
        notifyDataSetChanged()
    }


    class ViewHolder(private var itemRowBinding: RowLayoutBinding) :
        RecyclerView.ViewHolder(itemRowBinding.root) {
    }
}