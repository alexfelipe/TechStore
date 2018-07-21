package alexf.com.br.techstore.ui.activity

import alexf.com.br.techstore.R
import alexf.com.br.techstore.model.Product
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        if (!productReceivedWasLoaded()) finish()
    }

    private fun productReceivedWasLoaded(): Boolean {
        intent.getParcelableExtra<Product>(PRODUCT_KEY)?.let {
            fillProductInfo(it)
            return true
        }
        return false
    }

    private fun fillProductInfo(it: Product) {
        product_detail_id.text = it.id.toString()
        product_detail_name.text = it.name
        product_detail_description.text = it.description
        product_detail_quantity.text = it.quantity.toString()
    }

}
