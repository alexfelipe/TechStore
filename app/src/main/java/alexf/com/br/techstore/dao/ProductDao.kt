package alexf.com.br.techstore.dao

import alexf.com.br.techstore.model.Product

class ProductDao {

    companion object {
        private val products: MutableList<Product> = mutableListOf()
    }

    fun all (): List<Product> {
        return products
    }

    fun add(vararg product: Product){
        products.addAll(product)
    }

}
