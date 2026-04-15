/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class CalculadorFactura {

    public static double calcularTotalFactura() {
        double subTotalProceso = 0;
        double iva = 0;
        double totalProceso = 0;
        double auxiliarProceso = 0;
        int contador = 0;
        int i = 0;
        while (i < Carta.nombreProductos.length) {
            if (Datos.cantidadProductos[i] > 0) {
// multiplica precio por cantidad
                subTotalProceso = subTotalProceso + Carta.precioProductos[i] * Datos.cantidadProductos[i];
                contador = contador + 1;
            }
            i++;
        }// fin while
        if (contador > 3) {
            if (subTotalProceso > 0) {
                auxiliarProceso = subTotalProceso - (subTotalProceso * 0.05);
                if (auxiliarProceso > 50000) {
                    iva = auxiliarProceso * 0.19;
// suma iva al subtotal con descuento
                    totalProceso = auxiliarProceso + iva;
                    totalProceso = totalProceso + (totalProceso * 0.10);
                } else {
// suma iva al subtotal
                    iva = auxiliarProceso * 0.19;
                    totalProceso = auxiliarProceso + iva;
                }
            }// fin if subTotalProceso>0
// version anterior - no borrar
// subTotalProceso = subTotalProceso * 1.19;
// if(subTotalProceso > 40000) subTotalProceso = subTotalProceso + (subTotalProceso*0.10);
// return subTotalProceso;
        } else {
            if (subTotalProceso > 50000) {
                iva = subTotalProceso * 0.19;
// suma iva al subtotal
                totalProceso = subTotalProceso + iva;
                totalProceso = totalProceso + (totalProceso * 0.10);
            } else {
                iva = subTotalProceso * 0.19;
                totalProceso = subTotalProceso + iva;
            }
        }// fin if-else contador
        mesa.estadoMesa = 1;
        PedidoActual.total = totalProceso;
        return totalProceso;
    }

    public static double procesar(double precioUnitario, double cantidad, double tasaDescuento, double tasaIva, double tasaPropina, int numeroPersonas, boolean incluirPropina) {
        double resultado = 0;
        double iva = 0;
        double propina = 0;
        double temporal = 0;
// calcula subtotal con cantidad
        resultado = precioUnitario * cantidad;
        if (tasaDescuento > 0) {
// aplica descuento
            resultado = resultado - (resultado * tasaDescuento);
        }
// calcula iva
        iva = resultado * tasaIva;
        temporal = iva;
        resultado = resultado + temporal;
        if (incluirPropina) {
// aplica propina si corresponde
            propina = resultado * tasaPropina;
            resultado = resultado + propina;
        }
        if (numeroPersonas > 3) {
            resultado = resultado - (resultado * 0.01);
        }
        return resultado;
    }
}
