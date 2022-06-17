package com.demo.product.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class DatabaseData: RoomDatabase() {

    abstract fun getAppDao(): DatabaseDao

    companion object {
        private var DB_INSTANCE: DatabaseData? = null

        fun getAppDbInstance(context: Context): DatabaseData {
            if(DB_INSTANCE == null) {
                DB_INSTANCE = Room.databaseBuilder<DatabaseData>(
                    context.applicationContext, DatabaseData::class.java, "MYDB"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return DB_INSTANCE!!
        }

    }
}