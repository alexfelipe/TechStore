package alexf.com.br.techstore.ui.activity

import alexf.com.br.techstore.R
import alexf.com.br.techstore.database.dao.ProductDao
import alexf.com.br.techstore.ui.recyclerview.ProductsListAdapter
import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_products_list.*
import org.koin.android.ext.android.inject


class ProductsListActivity : AppCompatActivity() {

    private val productDao: ProductDao by inject()
    private val adapter: ProductsListAdapter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_list)
        val productsLiveData = productDao.all()
        productsLiveData.observe(this, Observer { products ->
            products?.let {
                adapter.replaceAllProducts(it)
            }
        })
        configureRecyclerView()
        configureFabAddProduct()
    }

    private fun configureFabAddProduct() {
        product_list_add_product.setOnClickListener {
            val openProductForm = Intent(this, FormProductActivity::class.java)
            startActivity(openProductForm)
        }
    }

    private fun configureRecyclerView() {
        products_list_recyclerview.adapter = adapter
    }

}
