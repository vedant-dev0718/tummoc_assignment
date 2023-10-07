package vedant.tiwari.tummoc_assignment.room_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import vedant.tiwari.tummoc_assignment.room_database.dao.ShoppingDao
import vedant.tiwari.tummoc_assignment.room_database.entity.ShoppingTableModel

@Database(entities = [ShoppingTableModel::class], version = 1, exportSchema = false)
abstract class ShoppingDatabase : RoomDatabase() {

    abstract fun shopDao(): ShoppingDao

    companion object {

        @Volatile
        private var INSTANCE: ShoppingDatabase? = null

        fun getDatabaseClient(context: Context): ShoppingDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    ShoppingDatabase::class.java,
                    "shopping_table"
                )
                    .addCallback(PrepopulateRoomCallback(context))
                    .build()

                return INSTANCE!!

            }
        }

    }

}
