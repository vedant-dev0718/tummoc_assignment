package vedant.tiwari.tummoc_assignment.room_database

import android.content.Context
import android.util.Log
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject
import vedant.tiwari.tummoc_assignment.R
import vedant.tiwari.tummoc_assignment.room_database.dao.ShoppingDao
import vedant.tiwari.tummoc_assignment.room_database.entity.CategoriesItem
import vedant.tiwari.tummoc_assignment.room_database.entity.ShoppingTableModel

class PrepopulateRoomCallback(private val context: Context) : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)

        CoroutineScope(Dispatchers.IO).launch {
            prePopulateUsers(context)
        }
    }
    private suspend fun prePopulateUsers(context: Context) {
        try {
            val userDao = ShoppingDatabase.getDatabaseClient(context).shopDao()

            val shopping: JSONObject =
                context.resources.openRawResource(R.raw.shopping).bufferedReader().use {
                    JSONObject(it.readText())
                }



//            userList.takeIf { it.length() > 0 }?.let { list ->
//                for (index in 0 until list.length()) {
//                    val obj = list.getJSONObject(index)
//                    userDao.insertItem(
//                       ShoppingTableModel (
//                          obj.getString("message"),
//                           obj.getString("error"),
//                           obj.getBoolean("status"),
//                        )
//                    )
//
//                }

//            }
        } catch (exception: Exception) {
        }
    }
}