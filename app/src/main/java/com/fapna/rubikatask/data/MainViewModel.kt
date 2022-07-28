package com.fapna.rubikatask.data

import android.util.Log
import androidx.lifecycle.ViewModel
import com.fapna.rubikatask.model.PostEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    lateinit var response: List<PostEntity>
    lateinit var item: PostEntity

    fun getPosts(): Flow<List<PostEntity>> = flow {
        try {
            response = repository.getPosts()
            emit(response)
        } catch (ee: Exception) {
            Log.e("db", ee.message.toString())
        }

    }

    fun unlikePost(id: Int) = flow {

//        withContext(Dispatchers.IO) {
        repository.unlikePost(id)
        response = repository.getPosts()
//        }
        emit(response)

    }

    fun likePost(id: Int) = flow {

//        withContext(Dispatchers.IO) {
        repository.likePost(id)
        response = repository.getPosts()
//        }
        emit(response)

    }

}