package com.sergiorivera.ejerciciofragments

import android.app.Application
import androidx.fragment.app.Fragment
import com.sergiorivera.ejerciciofragments.model.Product

class App  : Application()  {

    val products: MutableList<Product> = mutableListOf(
        Product(0,"Manzana",5,20,"manzana",true, R.drawable.manzana),
        Product(1,"Platano",3,10,"Platano",true, R.drawable.platano),
        Product(2,"Pera",2,11,"Pera",true, R.drawable.pera),
        Product(3,"Limon",7,22,"Limon",true, R.drawable.limon),
        Product(4,"Aguacate",11,5,"Aguacate",true, R.drawable.aguacate),
        Product(5,"Sandia",20,10,"Sandia",true, R.drawable.sandia),
        Product(6,"Melon",15,14,"Melon",true, R.drawable.melon),
        Product(7,"Tomate",4,19,"Tomate",true, R.drawable.tomate),
        Product(9,"Aceituna",25,45,"Aceituna",true, R.drawable.aceituna),
        Product(9,"Naranja",1,7,"Naranja",true, R.drawable.naranja)
        )
}
private val Fragment.app: App
    get() = this.activity?.application as App

val Fragment.products
    get() = app.products