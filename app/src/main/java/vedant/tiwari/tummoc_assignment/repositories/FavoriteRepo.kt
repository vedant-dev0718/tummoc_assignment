package vedant.tiwari.tummoc_assignment.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import vedant.tiwari.tummoc_assignment.room_database.FavoriteDatabase
import vedant.tiwari.tummoc_assignment.room_database.dao.FavoriteItemDao
import vedant.tiwari.tummoc_assignment.room_database.entity.FavoriteItem

class FavoriteRepo(private val favoriteItemDao: FavoriteItemDao) {

    private lateinit var favDatabase: FavoriteDatabase

    private fun initializeDB(context: Context): FavoriteDatabase {
        favDatabase = FavoriteDatabase.getDatabaseClient(context)
        return favDatabase
    }

     fun insertFavorite(favoriteItem: FavoriteItem) {
        favoriteItemDao.insertFavorite(favoriteItem)
    }

     fun deleteFavorite(id: Int) {
        favoriteItemDao.deleteFavorite(id)
    }

    fun getAllFavorites(context: Context): LiveData<List<FavoriteItem>> {
        favDatabase = initializeDB(context)

        return favDatabase.favoriteItemDao().getAllFavorites()
    }
}