package com.acronymmeaning.example

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.acronymmeaning.example.adapters.AcronymAdapter
import com.acronymmeaning.example.model.Lf

class BindingAdapters {

    @BindingAdapter("itemViewModels")
    fun bindItemViewModels(recyclerView: RecyclerView, itemViewModels: List<Lf>) {
        val adapter = getOrCreateAdapter(recyclerView, itemViewModels)
        adapter.updateItems(itemViewModels)
    }

    private fun getOrCreateAdapter(recyclerView: RecyclerView, itemViewModels: List<Lf>): AcronymAdapter {
        return if (recyclerView.adapter != null && recyclerView.adapter is AcronymAdapter) {
            recyclerView.adapter as AcronymAdapter
        } else {
            val bindableRecyclerAdapter = AcronymAdapter(itemViewModels)
            recyclerView.adapter = bindableRecyclerAdapter
            bindableRecyclerAdapter
        }
    }
}