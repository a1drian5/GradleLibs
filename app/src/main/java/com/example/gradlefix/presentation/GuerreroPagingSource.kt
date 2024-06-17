package com.example.gradlefix.presentation

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.gradlefix.api.ItemsApiService
import com.example.gradlefix.model.Item
import retrofit2.HttpException

class GuerreroPagingSource(private val service: ItemsApiService) :PagingSource<String,Item>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Item> {
//        val position = params.key ?: 0

        return try {
            /**
            Este se utiliza para hacer los calculos manualmente de la paginacion
             **/
//            val response = service.getPokemons(limit = params.loadSize, offset = position)
//            val pokemons = response.body()?.results ?: emptyList()
//
//            LoadResult.Page(
//                data = pokemons,
//                prevKey = if (position == 0) null else position - params.loadSize,
//                nextKey = if (pokemons.isEmpty()) null else position + params.loadSize
//            )

            /**
            Este se utiliza para hacer los calculos desde la respuesta de la API
             **/

            val currentLoadingPageKey = params.key ?: "https://dragonball-api.com/api/characters?page=3&limit=15"

            val response = service.getGuerreroByUrl(currentLoadingPageKey)
            val responseData = response.body() ?: return LoadResult.Error(HttpException(response))
            val data = responseData.items

            LoadResult.Page(
                data = data,
                prevKey = responseData.links.previous,
                nextKey = responseData.links.next)
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<String, Item>): String? {
        return null
    }
}