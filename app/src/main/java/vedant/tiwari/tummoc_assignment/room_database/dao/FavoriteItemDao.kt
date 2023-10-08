package vedant.tiwari.tummoc_assignment.room_database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import vedant.tiwari.tummoc_assignment.room_database.entity.FavoriteItem

@Dao
interface FavoriteItemDao {

    @Insert
     fun insertFavorite(favoriteItem: FavoriteItem): Void

    @Query("DELETE FROM favorites WHERE id=:id")
     fun deleteFavorite(id: Int): Void

    @Query("SELECT * FROM favorites")
    fun getAllFavorites(): LiveData<List<FavoriteItem>>

}