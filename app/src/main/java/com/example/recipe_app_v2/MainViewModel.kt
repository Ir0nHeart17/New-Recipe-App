package com.example.recipe_app_v2

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _categoriesState = mutableStateOf(RecipeState())
    //this will be exposed to UI
    val categoriesState: State<RecipeState> = _categoriesState

    init{
        fetchCategories()
    }

    private fun fetchCategories(){
        viewModelScope.launch {
            try{
                val response = recipieService.get()
                _categoriesState.value = _categoriesState.value.copy(
                    loading = false,
                    list = response.categories,
                    error = null
                )
            }catch (e:Exception){
                _categoriesState.value = _categoriesState.value.copy(
                    loading = false,
                    error = "Error fetching categories ${e.message}"
                )

            }
        }

    }





    data class RecipeState(
        val loading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null
    )
}