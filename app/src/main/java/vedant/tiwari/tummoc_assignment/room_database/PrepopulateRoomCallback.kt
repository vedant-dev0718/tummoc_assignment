package vedant.tiwari.tummoc_assignment.room_database

import android.content.Context
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import vedant.tiwari.tummoc_assignment.R
import vedant.tiwari.tummoc_assignment.room_database.entity.ShoppingTableModel
import vedant.tiwari.tummoc_assignment.room_database.model.ShoppingResponse

class PrepopulateRoomCallback(private val context: Context) : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)

        CoroutineScope(Dispatchers.IO).launch {
            prePopulateUsers(context)
        }
    }

    private fun prePopulateUsers(context: Context) {
        try {
            val userDao = ShoppingDatabase.getDatabaseClient(context).shopDao()

            val shoppingResponse: ShoppingResponse =
                context.resources.openRawResource(R.raw.shopping).bufferedReader().use {
                    val json = it.readText()
                    Gson().fromJson(json, ShoppingResponse::class.java)
                }

            val shoppingTableModel = ShoppingTableModel(0, shoppingResponse)
            userDao.insertAllShops(shoppingTableModel)

        } catch (exception: Exception) {
            // Handle exceptions here
        }
    }
}