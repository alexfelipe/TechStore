package alexf.com.br.techstore.ui.activity

import alexf.com.br.techstore.model.Product
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class ProductViewModel: ViewModel() {

    val products: LiveData<List<Product>> = MutableLiveData()

}