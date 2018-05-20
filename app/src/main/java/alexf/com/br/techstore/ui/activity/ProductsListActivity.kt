package alexf.com.br.techstore.ui.activity

import alexf.com.br.techstore.R
import alexf.com.br.techstore.database.AppDatabase
import alexf.com.br.techstore.database.dao.ProductDao
import alexf.com.br.techstore.ui.activity.recyclerview.ProductsListAdapter
import android.arch.persistence.room.Room
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_products_list.*


class ProductsListActivity : AppCompatActivity() {

    private lateinit var productDao: ProductDao
    private lateinit var adapter: ProductsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_list)
        val database = Room.databaseBuilder(
                this,
                AppDatabase::class.java,
                "techstore-database")
                .allowMainThreadQueries()
                .build()
        productDao = database.productDao()
        configureRecyclerView()
        configureFabAddProduct()
    }

    private fun configureFabAddProduct() {
        product_list_add_product.setOnClickListener {
            val openProductForm = Intent(this, FormProductActivity::class.java)
            startActivity(openProductForm)
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.replaceAllProducts(productDao.all())
    }

    private fun configureRecyclerView() {
        this.adapter = ProductsListAdapter(context = this)
        products_list_recyclerview.adapter = adapter
    }

}
