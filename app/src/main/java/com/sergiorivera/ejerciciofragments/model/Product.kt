package com.sergiorivera.ejerciciofragments.model

data class Product(
    var id: Int,
    var nombre: String,
    var precio: Int,
    var stock: Int,
    var descripcion: String,
    var disponible: Boolean,
    var imagen: Int
)
