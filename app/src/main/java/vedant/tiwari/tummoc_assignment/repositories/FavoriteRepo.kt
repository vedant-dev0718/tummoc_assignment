package vedant.tiwari.tummoc_assignment.repositories

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import vedant.tiwari.tummoc_assignment.room_database.FavoriteDatabase
import vedant.tiwari.tummoc_assignment.room_database.entity.FavoriteItem
import vedant.tiwari.tummoc_assignment.room_database.entity.ShoppingTableModel

class FavoriteRepo {

    companion object {
        private lateinit var favDatabase: FavoriteDatabase

        private fun initializeDB(context: Context): FavoriteDatabase {
            favDatabase = FavoriteDatabase.getDatabaseClient(context)
            return favDatabase
        }

        fun getAllFavorites(context: Context): LiveData<List<FavoriteItem>> {
            try {
                favDatabase = initializeDB(context)
                return favDatabase.favoriteItemDao().getAllFavorites()
            } catch (e: Exception) {
                Log.e("vedant", "Error getting all favorites: ${e.message}")
            }
            return MutableLiveData()
        }

        fun insertFavorite(context: Context, favoriteItem: FavoriteItem) {
            favDatabase = initializeDB(context)
            favDatabase.favoriteItemDao().insertFavorite(favoriteItem)
        }

        fun deleteFavorite(context: Context, id: Int) {
            favDatabase = initializeDB(context)
            favDatabase.favoriteItemDao().deleteFavorite(id)
        }

        fun doesFavoriteExist(context: Context,id: Int): Boolean {
            favDatabase = initializeDB(context)
            return favDatabase.favoriteItemDao().doesFavoriteExist(id)
        }

    }
}