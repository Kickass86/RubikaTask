package com.fapna.rubikatask

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fapna.rubikatask.data.MainViewModel
import com.fapna.rubikatask.data.PostAdapter
import com.fapna.rubikatask.databinding.ActivityMainBinding
import com.fapna.rubikatask.model.PostEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launchWhenStarted {
            viewModel.getPosts()
                .catch {

                }
                .collect {
                    adapter = PostAdapter(
                        it,
                        likePost = { item, position -> like(item, position) },
                        unlikePost = { item, position -> unlike(item, position) }
                    )
                    binding.postRecyclerview.layoutManager = LinearLayoutManager(
                        baseContext,
                        RecyclerView.VERTICAL,
                        false
                    )
                    binding.postRecyclerview.adapter = adapter
                }
        }
    }

    private fun like(item: PostEntity, position: Int) {
        lifecycleScope.launchWhenStarted {
            viewModel.likePost(item.id)
                .catch {}
                .collect {
                    adapter.setDataList(it)
                    binding.postRecyclerview.adapter!!.notifyItemChanged(
                        position,
                        item
                    )
                }
        }
    }

    private fun unlike(item: PostEntity, position: Int) {
        lifecycleScope.launchWhenStarted {
            viewModel.unlikePost(item.id)
                .catch {}
                .collect {
                    adapter.setDataList(it)
                    binding.postRecyclerview.adapter!!.notifyItemChanged(
                        position,
                        item
                    )
                }
        }
    }

}