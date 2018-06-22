package alexf.com.br.techstore.ui.activity.recyclerview

import alexf.com.br.techstore.model.Product
import android.support.v7.util.DiffUtil

class ProductDiffUtil(
        private val oldProducts: List<Product>,
        private val newProducts: List<Product>) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItemPosition == newItemPosition
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val newProduct = newProducts[newItemPosition]
        val oldProduct = oldProducts[oldItemPosition]
        return newProduct.id == oldProduct.id
    }

    override fun getOldListSize(): Int {
        return oldProducts.size
    }

    override fun getNewListSize(): Int {
        return newProducts.size
    }

}