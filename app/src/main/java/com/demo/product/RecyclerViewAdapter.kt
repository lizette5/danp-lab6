package com.demo.product

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.demo.product.database.Product

class RecyclerViewAdapter(): PagingDataAdapter<Product, RecyclerViewAdapter.MyViewHolder>(DiffUtilCallback()) {
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
       val inflater =  LayoutInflater.from(parent.context).inflate(R.layout.layout_recycler_row, parent, false)

        return MyViewHolder(inflater)
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textViewName: TextView = view.findViewById(R.id.textViewName)
        val textViewDescripcion: TextView = view.findViewById(R.id.textViewDescripcion)
        val textViewTiempo: TextView = view.findViewById(R.id.textViewTiempo)
        val textViewMaterial: TextView = view.findViewById(R.id.textViewMaterial)

        fun bind(product: Product) {
            textViewName.text = product.nombre
            textViewDescripcion.text = product.descripcion
            textViewTiempo.text = product.tiempo
            textViewMaterial.text = product.material
        }
    }

    class  DiffUtilCallback: DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {

            return oldItem.nombre == newItem.nombre&&
                    oldItem.descripcion==newItem.descripcion&&
                    oldItem.tiempo==newItem.tiempo&&
                    oldItem.material==newItem.material
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.nombre == newItem.nombre && oldItem.nombre == newItem.nombre&&
                   oldItem.descripcion==newItem.descripcion&& oldItem.descripcion==newItem.descripcion&&
                    oldItem.tiempo==newItem.tiempo&& oldItem.tiempo==newItem.tiempo&&
                    oldItem.material==newItem.material && oldItem.material==newItem.material
        }

    }

}