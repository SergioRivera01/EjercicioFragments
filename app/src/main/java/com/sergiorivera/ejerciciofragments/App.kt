package com.sergiorivera.ejerciciofragments

import android.app.Application
import androidx.fragment.app.Fragment
import com.sergiorivera.ejerciciofragments.model.Product

class App  : Application()  {

    val products: MutableList<Product> = mutableListOf(
        Product(0,"Manzana",5,20,"manzana roja",true, R.drawable.manzana),
        Product(1,"Platano",3,10,"Platano de canarias",false, R.drawable.platano),
        Product(2,"Pera",2,3,"Pera de peral",true, R.drawable.pera),
        Product(3,"Limon",7,22,"Limon lima",false, R.drawable.limon),
        Product(4,"Aguacate",11,5,"Aguacate para guacamole",true, R.drawable.aguacate),
        Product(5,"Sandia",20,10,"Sandia para el verano",true, R.drawable.sandia),
        Product(6,"Melon",15,14,"Melon amarillo",false, R.drawable.melon),
        Product(7,"Tomate",4,4,"Tomate de la mata",true, R.drawable.tomate),
        Product(8,"Aceituna",25,45,"Aceituna de olivo",true, R.drawable.aceituna),
        Product(9,"Naranja",1,7,"Naranja como el color",false, R.drawable.naranja)
        )
}
private val Fragment.app: App
    get() = this.activity?.application as App

val Fragment.products
    get() = app.products