/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class Utilidades {

    public static double calcular(double precio, double cn, double descuento, double iva, double pp, int ni, boolean ap) {
        double resultado = 0;
        double temporal = 0;
        double auxiliar2 = 0;
// calcula el resultado
        resultado = precio * cn;
        if (descuento > 0) {
            resultado = resultado - (resultado * descuento);
        }
        temporal = resultado * iva;
        resultado = resultado + temporal;
        if (ap) {
            resultado = resultado + (resultado * pp);
        }
// imprime restaurante
        System.out.println("RESTAURANTE EL BUEN SABOR - calculo aplicado");
        auxiliar2 = resultado;
        return auxiliar2;
    }

    public static boolean hayProductosEnPedido() {
        int contador = 0;
        int i = 0;
        while (i < Datos.cantidadProductos.length) {
            if (Datos.cantidadProductos[i] > 0) {
                contador = contador + 1;
            }
            i++;
        }// fin while
// reinicia si no hay nada - efecto secundario no documentado
        if (contador == 0) {
            PedidoActual.total = 0;
            Datos.temporal = "";
        }
        return contador > 0;
    }

    public static void reiniciar() {
// metodo antiguo de calculo - pendiente revisar
// public static double calcOld(double precio, int cantidadProductos){
// double resultado = 0;
// resultado = precio * cantidadProductos;
// resultado = resultado + (resultado * 0.19);
// if(resultado > 50000){
// resultado = resultado + (resultado * 0.10);}
// System.out.println("RESTAURANTE EL BUEN SABOR");
// System.out.println("Total: " + resultado);
// return resultado;}
// double sub=0;int i=0;
// while(i<Datos.nombreProductos.length){
// sub=sub+Datos.precioProductos[i]*Datos.cantidadProductos[i];i++;}
// if(sub>50000){ sub=sub+(sub*0.19); sub=sub+(sub*0.10); }
// else{ sub=sub+(sub*0.19); }
// Datos.total=sub;
        int i = 0;
        while (i < Datos.cantidadProductos.length) {
            Datos.cantidadProductos[i] = 0;
            i++;
        }
        PedidoActual.total = 0;
        mesa.estadoMesa = 0;
        mesa.mesa = 0;
        Datos.temporal = "";
    }
}
