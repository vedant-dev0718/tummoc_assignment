package vedant.tiwari.tummoc_assignment.room_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import vedant.tiwari.tummoc_assignment.room_database.converter.Converters
import vedant.tiwari.tummoc_assignment.room_database.dao.FavoriteItemDao
import vedant.tiwari.tummoc_assignment.room_database.dao.ShoppingDao
import vedant.tiwari.tummoc_assignment.room_database.entity.FavoriteItem
import vedant.tiwari.tummoc_assignment.room_database.entity.ShoppingTableModel


@Database(entities = [ShoppingTableModel::class], version = 1)
@TypeConverters(Converters::class)
abstract class ShoppingDatabase : RoomDatabase() {

    abstract fun shopDao(): ShoppingDao

    companion object {
        @Volatile
        lateinit var INSTANCE: ShoppingDatabase

        fun getDatabaseClient(context: Context): ShoppingDatabase {

            synchronized(this) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    ShoppingDatabase::class.java,
                    "shopping_table"
                ).addCallback(PrepopulateRoomCallback(context))
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE

            }
        }
    }


}
