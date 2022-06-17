package com.demo.product.database

import androidx.paging.PagingSource
import javax.inject.Inject

class RoomRepository @Inject constructor(private val databaseDao: DatabaseDao) {

    fun getAllRecords(): PagingSource<Int, Product> {
        return databaseDao.getAllRecords()
    }

    fun insertRecord(product: Product) {
        databaseDao.insertRecord(product)
    }
}