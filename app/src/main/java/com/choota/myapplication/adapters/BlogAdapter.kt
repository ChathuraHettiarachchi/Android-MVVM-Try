package com.choota.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.choota.myapplication.R
import com.choota.myapplication.extensions.load
import com.choota.myapplication.services.api.blog.model.Blog
import kotlinx.android.synthetic.main.widget_blog.view.*

class BlogAdapter(private val items: List<Blog>?) : RecyclerView.Adapter<BlogAdapter.BlogHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogHolder {
        return BlogHolder(LayoutInflater.from(parent.context).inflate(R.layout.widget_blog, parent, false))
    }

    override fun getItemCount(): Int {
        if (items != null) {
            return items.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: BlogHolder, position: Int) {
        val item: Blog = items?.get(position) ?: Blog()
        holder.txtTitle.text = item.title
        holder.txtDescriptioin.text = item.description
        holder.txtLink.text = item.link
        holder.imgBanner.load(item.thumbnail)
    }

    inner class BlogHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtTitle: TextView = itemView.txtTitle
        var txtDescriptioin: TextView = itemView.txtDescription
        var txtLink: TextView = itemView.txtLink
        var imgBanner: ImageView = itemView.imgBanner
    }
}