package com.example.recyclerviewkotlin


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewkotlin.databinding.RowItemBinding

class AdapterItem(
    private var context: Context,
    private var itemList: ArrayList<ModelItem>
) : RecyclerView.Adapter<AdapterItem.HolderItem> () {

    private lateinit var  binding: RowItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderItem {
        binding = RowItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return HolderItem(binding.root)

    }

    override fun onBindViewHolder(holder: HolderItem, position: Int) {
        val model = itemList[position]

        val title = model.title
        val description = model.description
        val image = model.image

        holder.titleTv.text = title
        holder.descriptionTv.text = description
        holder.iconTv.setImageResource(image)

        holder.itemView.setOnClickListener {
            Toast.makeText(context, "$title", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class HolderItem(itemView: View) : RecyclerView.ViewHolder(itemView) {

         var titleTv: TextView
         var descriptionTv: TextView
         var iconTv: ImageView

        init {
            binding = RowItemBinding.bind(itemView)
            titleTv = binding.titleTV
            descriptionTv = binding.descriptionTv
            iconTv = binding.iconIv

        }

    }

}