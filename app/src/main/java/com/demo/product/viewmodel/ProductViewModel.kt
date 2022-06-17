package com.demo.product.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.demo.product.database.Product
import com.demo.product.database.RoomRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val repository: RoomRepository): ViewModel() {

    fun getAllRecords(): Flow<PagingData<Product>> {
        return Pager(config = PagingConfig(pageSize = 20, maxSize = 200),
        pagingSourceFactory = {repository.getAllRecords()}).flow.cachedIn(viewModelScope)
    }


    fun insertRecords() {
        //base de datos
        val nombre = mutableListOf("Tecnopor","Bolsa negra","Vaso de plastico","Bolsa de color","Petroleo")
        val name = nombre.random()

        val tiempo = mutableListOf(13,5,4,2,3,8,10)
        val time = tiempo.random()

        val material = mutableListOf("Politilieno","Polipropileno","ABS","Poliestireno")
        val materiall = material.random()

        for(i in 1..200) {
            repository.insertRecord(Product(0, "NOMBRE DE PRODUCTO: "+name,"DESCRIPCION : Producto "+i,
                "CICLO DE VIDA: "+time,"MATERIAL: "+materiall))
        }
    }
}