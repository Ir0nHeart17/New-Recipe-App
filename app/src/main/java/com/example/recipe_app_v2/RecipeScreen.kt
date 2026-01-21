package com.example.recipe_app_v2

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage

@Composable
fun RecipeScreen(
    modifier: Modifier = Modifier,
    viewState: MainViewModel.RecipeState,
    navigateToDetail: (Category) -> Unit
) {
    val recipeViewmodel: MainViewModel = viewModel()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        when {
            viewState.loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            viewState.error != null -> {
                Text(text = "error occurred")

            }

            else -> {
                //Here we will display category if not loading and no error

                CategoryScreen(
                    category = viewState.list,
                    navigateToDetail
                )

            }

        }


    }
}

@Composable
fun CategoryScreen(
    category: List<Category>,
    navigateToDetail: (Category) -> Unit
) {
    LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
        items(category) { category ->
            CategoryItem(category = category, navigateToDetail)
        }
    }
}

//How each item in the grid will look like
@Composable
fun CategoryItem(
    category: Category,
    navigateToDetail: (Category) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable { navigateToDetail(category) }, elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Category Image
            AsyncImage(
                model = category.strCategoryThumb,
                contentDescription = "Image of ${category.strCategory}",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)

            )
            //Category Title
            Text(
                text = category.strCategory,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(top = 8.dp)

            )
        }
    }

}