package vedant.tiwari.tummoc_assignment.room_database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import vedant.tiwari.tummoc_assignment.room_database.entity.ShoppingTableModel

@Dao
interface ShoppingDao {

    @Query("SELECT * FROM shopping_table")
    fun getShopList(): LiveData<ShoppingTableModel>

    @Insert
    fun insertAllShops(vararg shoppingTableModel: ShoppingTableModel)
}
