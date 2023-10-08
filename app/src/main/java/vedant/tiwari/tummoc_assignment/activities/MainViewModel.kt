package vedant.tiwari.tummoc_assignment.activities

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import vedant.tiwari.tummoc_assignment.repositories.ShoppingRepo
import vedant.tiwari.tummoc_assignment.room_database.entity.ShoppingTableModel

class MainViewModel : ViewModel() {

    private lateinit var liveDataShop: LiveData<ShoppingTableModel>


    fun getShopDetails(context: Context): LiveData<ShoppingTableModel> {
        liveDataShop = ShoppingRepo.getShopDetails(context)
        return liveDataShop
    }
}