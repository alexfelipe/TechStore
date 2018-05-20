package alexf.com.br.techstore.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Product(
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
        val name: String,
        val description: String,
        val quantity: Int)