package vedant.tiwari.tummoc_assignment.activities.internal_screen.fav

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import vedant.tiwari.tummoc_assignment.repositories.FavoriteRepo
import vedant.tiwari.tummoc_assignment.room_database.entity.FavoriteItem

class FavoriteViewModel(private val repository: FavoriteRepo) : ViewModel() {

    fun insertFavorite(favoriteItem: FavoriteItem) {
        viewModelScope.launch {
            repository.insertFavorite(favoriteItem)
        }
    }

    fun getAllFavorites(context: Context): LiveData<List<FavoriteItem>> {
        return repository.getAllFavorites(context)
    }

    fun deleteFavorite(id: Int) {
        viewModelScope.launch {
            repository.deleteFavorite(id)
        }
    }
}