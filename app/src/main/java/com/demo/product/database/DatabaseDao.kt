package com.demo.product.database

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DatabaseDao {

    @Query("SELECT * FROM product ORDER BY id DESC")
    fun getAllRecords(): PagingSource<Int, Product>
    @Insert
    fun insertRecord(product: Product)
}