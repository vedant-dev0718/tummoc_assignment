package vedant.tiwari.tummoc_assignment.room_database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import vedant.tiwari.tummoc_assignment.room_database.entity.FavoriteItem

@Dao
interface FavoriteItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertFavorite(favoriteItem: FavoriteItem)

    @Query("DELETE FROM favorites WHERE id=:id")
     fun deleteFavorite(id: Int)

    @Query("SELECT * FROM favorites")
    fun getAllFavorites(): LiveData<List<FavoriteItem>>

    @Query("SELECT EXISTS(SELECT 1 FROM favorites WHERE id = :id LIMIT 1)")
    fun doesFavoriteExist(id: Int): Boolean

}