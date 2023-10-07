package vedant.tiwari.tummoc_assignment.room_database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import vedant.tiwari.tummoc_assignment.room_database.entity.CategoriesItem
import vedant.tiwari.tummoc_assignment.room_database.entity.ItemsItem
import vedant.tiwari.tummoc_assignment.room_database.entity.ShoppingTableModel

@Dao
interface ShoppingDao {
    @Query("SELECT * FROM shopping_table")
    fun getShopList(): LiveData<ShoppingTableModel>

    @Insert
    suspend fun insertItem(shop: ShoppingTableModel)

    @Insert
    suspend fun insertShopList(shop: LiveData<List<ShoppingTableModel>>)

    @Insert
    suspend fun insertCategoriesItems(shop: LiveData<List<ItemsItem>>)


}
