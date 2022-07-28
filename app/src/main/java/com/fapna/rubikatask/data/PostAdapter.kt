package com.fapna.rubikatask.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.fapna.rubikatask.R
import com.fapna.rubikatask.databinding.PostItemBinding
import com.fapna.rubikatask.model.PostEntity

class PostAdapter(
    private var posts: List<PostEntity>,
    val likePost : (PostEntity, Int) -> Unit,
    val unlikePost : (PostEntity, Int) -> Unit
): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {


    fun setDataList(postList: List<PostEntity>) {
        posts = postList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            PostItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position], position)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    inner class PostViewHolder(private val view: PostItemBinding): RecyclerView.ViewHolder(view.root) {

        val IMAGE_FOLDER = "file:///android_asset/images/"

        fun bind(post: PostEntity, position: Int) {
            view.apply {
                caption.text = post.caption
                likeCount.text = post.likeCount.toString()
                commentCount.text = post.viewCount.toString()
                if (post.isLiked) {
                    like.setBackgroundResource(R.drawable.ic_baseline_favorite_24)
                } else {
                    like.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24)
                }

                Glide
                    .with(this.root.context)
                    .load(IMAGE_FOLDER + post.picture)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .into(postPicture)

                like.setOnClickListener {
                    if (post.isLiked) {
                        unlikePost(post, position)
//                        post.likeCount--
//                        post.isLiked = false
                    } else {
                        likePost(post, position)
//                        post.likeCount++
//                        post.isLiked = true
                    }
                    notifyItemChanged(position, post)
                }
            }
        }
    }
}