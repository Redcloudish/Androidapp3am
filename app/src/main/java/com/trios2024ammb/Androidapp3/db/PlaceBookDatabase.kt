package com.trios2024ammb.Androidapp3.db

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
import com.trios2024ammb.Androidapp3.model.Bookmark


@Database(entities = arrayOf(Bookmark::class), version = 1)
abstract class PlaceBookDatabase : RoomDatabase() {

    abstract fun bookmarkDao(): BookmarkDao

    companion object {

        private var instance: PlaceBookDatabase? = null

        fun getInstance(context: Context): PlaceBookDatabase {
            if (instance == null) {

                instance = Room.databaseBuilder(
                    context.applicationContext,
                    PlaceBookDatabase::class.java,
                    "PlaceBook").build()
            }

            return instance as PlaceBookDatabase
        }
    }
}
