package com.example.recipe_app_v2

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navHostController: NavHostController) {
    val recipeViewModel: MainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState

    NavHost(navController = navHostController, startDestination = Screen.RecipeScreen.route) {
        composable(route = Screen.RecipeScreen.route) {
            RecipeScreen(viewState = viewState, navigateToDetail = {
                //This part is responsible for passing data from current screen to detail screen.
                //It utilizes the savedStateHandle,which is a component of the Compose navigation framework
                navHostController.currentBackStackEntry?.savedStateHandle?.set("category", it)
                navHostController.navigate(Screen.DetailScreen.route)
            })
        }

        composable(route = Screen.DetailScreen.route) {
            val category =
                navHostController.previousBackStackEntry?.savedStateHandle?.get<Category>("category")
                    ?: Category("", "", "", "")
            CategoryDetailScreen(category = category)


        }
    }


}