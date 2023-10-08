package vedant.tiwari.tummoc_assignment.activities.internal_screen.fav

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import vedant.tiwari.tummoc_assignment.repositories.FavoriteRepo
import vedant.tiwari.tummoc_assignment.room_database.entity.FavoriteItem
import vedant.tiwari.tummoc_assignment.room_database.entity.ShoppingTableModel

class FavoriteViewModel : ViewModel() {

    private lateinit var favList: LiveData<List<FavoriteItem>>

    fun insertFavorite(context: Context, favoriteItem: FavoriteItem) {
        viewModelScope.launch {
            FavoriteRepo.insertFavorite(context, favoriteItem)
        }
    }

    fun getAllFavorites(context: Context): LiveData<List<FavoriteItem>> {
        Log.d("vedant",FavoriteRepo.getAllFavorites(context).toString())
        favList = FavoriteRepo.getAllFavorites(context)
        return favList
    }

    fun deleteFavorite(context: Context, id: Int) {
        viewModelScope.launch {
            FavoriteRepo.deleteFavorite(context, id)
        }
    }

    fun checkIfFavoriteExists(context: Context,id: Int):Boolean{
        return FavoriteRepo.doesFavoriteExist(context, id)
    }
}