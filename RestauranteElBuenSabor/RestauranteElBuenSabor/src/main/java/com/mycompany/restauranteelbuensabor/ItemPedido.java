/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author santi
 */
public class ItemPedido {
    private final Producto producto = null;
    private int cantidad;

    public double calcularSubtotal() {
        return producto.getPrecio() * cantidad;
    }
}

