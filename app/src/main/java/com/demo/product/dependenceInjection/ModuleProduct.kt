package com.demo.product.dependenciaInjection

import android.app.Application
import com.demo.product.database.DatabaseDao
import com.demo.product.database.DatabaseData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ModuleProduct {

    @Singleton
    @Provides
    fun getAppDatabase(context: Application): DatabaseData {
        return DatabaseData.getAppDbInstance(context)
    }

    @Singleton
    @Provides
    fun appDao(databaseData: DatabaseData): DatabaseDao {
        return databaseData.getAppDao()
    }
}