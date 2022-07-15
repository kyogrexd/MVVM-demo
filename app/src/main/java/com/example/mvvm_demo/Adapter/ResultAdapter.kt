package com.example.mvvm_demo.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_demo.R
import com.example.mvvm_demo.ViewModel.ResultViewModel
import com.example.mvvm_demo.databinding.ItemResultBinding

class ResultAdapter(val context: Context, private val viewModel: ResultViewModel):RecyclerView.Adapter<ResultAdapter.ViewHolder>() {

    class ViewHolder(v: View): RecyclerView.ViewHolder(v) {
        val tvItemResultID: TextView = v.findViewById(R.id.tvItemResultID)
        val tvItemResultContent: TextView = v.findViewById(R.id.tvItemResultContent)
        val tvItemResultPrint: TextView = v.findViewById(R.id.tvItemResultPrint)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = ItemResultBinding.inflate(LayoutInflater.from(parent.context), parent, false).root
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = viewModel.getAllText()[position]
        holder.tvItemResultID.text = item.id.toString()
        holder.tvItemResultContent.text = item.content
        holder.tvItemResultPrint.text = item.print()
    }

    override fun getItemCount() = viewModel.getAllText().size

}