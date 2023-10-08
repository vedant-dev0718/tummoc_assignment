package vedant.tiwari.tummoc_assignment.room_database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import vedant.tiwari.tummoc_assignment.room_database.dao.FavoriteItemDao
import vedant.tiwari.tummoc_assignment.room_database.entity.FavoriteItem

@Database(entities = [FavoriteItem::class], version = 1)
abstract class FavoriteDatabase : RoomDatabase() {
    abstract fun favoriteItemDao(): FavoriteItemDao

    companion object {
        private const val DATABASE_NAME = "favorite_database"

        fun getDatabaseClient(context: Context): FavoriteDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                FavoriteDatabase::class.java,
                DATABASE_NAME
            )
                .addCallback(object : Callback() {
                    override fun onOpen(db: SupportSQLiteDatabase) {
                        super.onOpen(db)
                    }

                })
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}