package com.anggapambudi.kbbionline.adapter

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anggapambudi.kbbionline.R
import com.anggapambudi.kbbionline.model.ResultListsItem
import com.github.akshay_naik.texthighlighterapi.TextHighlighter
import com.github.vipulasri.timelineview.TimelineView
import kotlinx.android.synthetic.main.item_kata.view.*

class KamusAdapter(private val item: ArrayList<ResultListsItem>):
        RecyclerView.Adapter<KamusAdapter.KamusViewHolder>() {

    class KamusViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(resultListsItem: ResultListsItem) {
            val highlighter = TextHighlighter()
            highlighter.setColorForTheToken("a", "red")
            highlighter.setColorForTheToken("cak", "red")
            highlighter.setColorForTheToken("n", "red")
            highlighter.setColorForTheToken("v", "red")
            highlighter.setColorForTheToken("Huk", "red")
            highlighter.setColorForTheToken("Prm", "red")
            highlighter.setColorForTheToken("ki", "purple")
            highlighter.setColorForTheToken("Ling", "red")
            highlighter.setColorForTheToken("ark", "red")
            highlighter.setColorForTheToken("Sas", "red")
            highlighter.setColorForTheToken("Kim", "red")
            highlighter.setColorForTheToken("Komp", "red")
            highlighter.setColorForTheToken("sing", "red")
            highlighter.setColorForTheToken("adv", "red")
            highlighter.setColorForTheToken("num", "red")
            highlighter.setColorForTheToken("Ek", "red")
            highlighter.setColorForTheToken("kas", "red")
            highlighter.setColorForTheToken("Fis", "red")
            highlighter.setColorForTheToken("Mat", "red")
            highlighter.setColorForTheToken("kp", "red")

            val highlightedText = highlighter.getHighlightedText(resultListsItem.arti.toString())
            itemView.tvKata.text = resultListsItem.kata
            itemView.tvArti.text = Html.fromHtml(highlightedText)
            itemView.timelineView.initLine(itemViewType)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= KamusViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_kata, parent, false)
    )

    override fun onBindViewHolder(holder: KamusViewHolder, position: Int) {
        holder.bind(item[position])
    }

    override fun getItemCount(): Int {
        return item.size
    }

}