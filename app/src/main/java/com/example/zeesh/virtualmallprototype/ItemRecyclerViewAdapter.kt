package com.example.zeesh.virtualmallprototype

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by zeesh on 5/14/2018.
 */
class ItemRecyclerViewAdapter(val dataset: MutableList<Item>, val context: Context): RecyclerView.Adapter<ItemRecyclerViewAdapter.ItemViewHolder>() {
    override fun onBindViewHolder(holder: ItemViewHolder?, position: Int) {
        holder?.bind(dataset[position])
//        if (dataset[position].image == null){
//            val r = getImageDrawable(position)
//            if (r!=null)
//            holder?.image?.setImageResource(r)
//
//        }

        holder?.itemView?.setOnClickListener{
            context.startActivity(Intent(context, ItemDetailActivity::class.java))

        }

    }

    override fun getItemCount(): Int = dataset.size



    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.item_card_view_item, parent, false)

        return ItemViewHolder(v)
    }
    fun addNewItem(item: Item){
        dataset.add(item)
    }

//    fun getImageDrawable(i: Int): Int{
//        var r = R.drawable.watch
//        when(i%4){
//            0->{r = R.drawable.shoe}
//            1->{r = R.drawable.shirt}
//            2->{r = R.drawable.glasses}
//        }
//
//        return r
//    }

    class ItemViewHolder(v: View): RecyclerView.ViewHolder(v){

        val image: ImageView
        val textOne : TextView
        val textTwo : TextView
        val dodts : ImageView

        init {
            image = v.findViewById(R.id.item_card_view_image)
            textOne = v.findViewById(R.id.item_card_view_text_one)
            textTwo = v.findViewById(R.id.item_card_view_text_two)
            dodts = v.findViewById(R.id.item_card_view_dots)
        }

         fun bind(item: Item){
            image.setImageBitmap(item.image)
            textOne.text = "Rs: ${item.price}"
            textTwo.text = item.brand
        }

    }
}