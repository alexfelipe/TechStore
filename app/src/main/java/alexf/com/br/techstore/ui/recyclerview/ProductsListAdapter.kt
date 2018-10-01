package alexf.com.br.techstore.ui.recyclerview

import alexf.com.br.techstore.R
import alexf.com.br.techstore.model.Product
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.product_item.view.*

class ProductsListAdapter(
        private val products: MutableList<Product> = mutableListOf(),
        private val context: Context) : RecyclerView.Adapter<ProductsListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val createdView = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false)
        return ViewHolder(createdView)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    fun add(products: List<Product>) {
        this.products.addAll(products)
        notifyItemRangeInserted(0, products.size)
    }

    fun replaceAllProducts(products: List<Product>) {
        this.products.clear()
        this.products.addAll(products)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val name: TextView = itemView.product_item_name
        private val description: TextView = itemView.product_item_description
        private val quantity: TextView = itemView.product_item_quantity

        fun bind(product: Product) {
            name.text = product.name
            description.text = product.description
            quantity.text = product.quantity.toString()
        }
    }
}