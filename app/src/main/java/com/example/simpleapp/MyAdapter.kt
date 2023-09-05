package com.example.simpleapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleapp.databinding.ItemLayoutMsgBinding
import org.libpag.PAGFile

class MyAdapter constructor(val item: List<String>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private val pagSpeaking by lazy {

    }

    class ViewHolder(val binding: ItemLayoutMsgBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutMsgBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = item.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            val flag = payloads[0] as Boolean
            if (flag) {
                val pag =
                    PAGFile.Load(holder.binding.root.context.assets, "chat_wt_speaking.pag")
                holder.binding.pag.setRepeatCount(0)
                holder.binding.pag.composition = pag
                holder.binding.pag.visibility=View.VISIBLE
                holder.binding.pag.play()
            } else {
                holder.binding.pag.stop()
                holder.binding.pag.visibility=View.GONE
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvItem.text = item[position]
        "onBindViewHolder ${position} root.isShown ${holder.binding.root.isShown} root.parent ${holder.binding.root.parent}".logD()

    }
}