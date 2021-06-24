package com.test.searchapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.recyclerview.widget.RecyclerView
import com.test.searchapp.R
import com.test.searchapp.domain.modellocal.SearchLocal
import kotlinx.android.synthetic.main.adapter_search.view.*
import java.util.*

class SearchAdapter(var myDataset: List<SearchLocal>) :
RecyclerView.Adapter<SearchAdapter.SearchHolder>(){

    var detailSearch : DetailSearchInterface? = null

    inner class SearchHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val mTvTitle = itemView.tvTitle

        init {
            mTvTitle.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            val i = v!!.id
            if (i == R.id.tvTitle){
                detailSearch!!.onDetailsSearch(myDataset[position])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_search, parent, false)
        return SearchHolder(view)
    }

    override fun onBindViewHolder(holder: SearchHolder, position: Int) {
        val title = myDataset[position].originalName
       holder.mTvTitle.text = title

        setAnimation(holder.mTvTitle, position)
    }

    private var lastPosition = -1

    private fun setAnimation(viewToAnimate: View, position: Int) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            val anim = ScaleAnimation(
                0.0f,
                1.0f,
                0.0f,
                1.0f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
            )
            anim.duration = Random().nextInt(701).toLong()//to make duration random number between [0,501)
            viewToAnimate.startAnimation(anim)
            lastPosition = position
        }
    }

    fun onDetailsSearch(detailSearchInterface: DetailSearchInterface){
        this.detailSearch = detailSearchInterface
    }

    fun filterList(filterdNames: ArrayList<SearchLocal>) {
        this.myDataset = filterdNames
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = myDataset.size
}