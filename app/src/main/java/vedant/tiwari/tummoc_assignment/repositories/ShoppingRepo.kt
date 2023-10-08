package vedant.tiwari.tummoc_assignment.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import vedant.tiwari.tummoc_assignment.room_database.ShoppingDatabase
import vedant.tiwari.tummoc_assignment.room_database.entity.ShoppingTableModel


class ShoppingRepo {

    companion object {
        private lateinit var shopDatabase: ShoppingDatabase

        private lateinit var shoppingTableModel: LiveData<ShoppingTableModel>

        private fun initializeDB(context: Context): ShoppingDatabase {
            shopDatabase = ShoppingDatabase.getDatabaseClient(context)
            return shopDatabase
        }

        fun getShopDetails(context: Context): LiveData<ShoppingTableModel> {

            shopDatabase = initializeDB(context)
            shoppingTableModel = shopDatabase.shopDao().getShopList()
            return shoppingTableModel
        }


    }
}