/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class FacturaImpresion {
private static final double TASA_IVA       = 0.19;
private static final double TASA_PROPINA   = 0.10;
private static final double TASA_DESCUENTO = 0.05;
private static final double UMBRAL_PROPINA = 50000;
private static final int    MIN_ITEMS_DESCUENTO = 3;
private static final String NOMBRE_RESTAURANTE  = "El Buen Sabor";
private static final String DIRECCION           = "Calle 15 #8-32, Valledupar";
private static final String NIT                 = "900.123.456-7";
public static void ImprimirEncabezado(){
 System.out.println("========================================");
        System.out.println("    RESTAURANTE EL BUEN SABOR");
        System.out.println("    --- NUESTRA CARTA ---");
        System.out.println("========================================");
}
    public static void mostrarCarta() {
       
        int i = 0;
        while (i < Carta.nombreProductos.length) {
            System.out.printf("%d. %-22s $%,.0f%n", (i + 1), Carta.nombreProductos[i], Carta.precioProductos[i]);
            i++;
        }// fin while
        System.out.println("========================================");
    }

    public static void mostrarPedido() {
        double subTotal = 0;
        int i = 0;
        System.out.println("--- PEDIDO ACTUAL ---");
        while (i < Carta.nombreProductos.length) {
            if (Datos.cantidadProductos[i] > 0) {
// imprime producto con cantidad y subtotal parcial
                System.out.printf("%-20s x%-6d $%,.0f%n", Carta.nombreProductos[i], Datos.cantidadProductos[i], (Carta.precioProductos[i] * Datos.cantidadProductos[i]));
// suma al subtotal
                subTotal = subTotal + Carta.precioProductos[i] * Datos.cantidadProductos[i];
            }
            i++;
        }// fin while
        System.out.println("--------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subTotal);
    }

    public static void imprimirFacturaCompleta() {
        double subTotal = 0;
        double iva = 0;
        double total = 0;
        double propina = 0;
        int contador = 0;
        double auxiliar = 0;
// calcula subtotal otra vez
        int i = 0;
        while (i < Carta.nombreProductos.length) {
            if (Datos.cantidadProductos[i] > 0) {
                subTotal = subTotal + Carta.precioProductos[i] * Datos.cantidadProductos[i];
                contador = contador + 1;
            }
            i++;
        }// fin while
        if (contador > MIN_ITEMS_DESCUENTO) {
            auxiliar = subTotal - (subTotal * TASA_DESCUENTO);
        } else {
            auxiliar = subTotal;
        }
        if (auxiliar > UMBRAL_PROPINA) {
            iva = auxiliar * TASA_IVA;
            total = auxiliar + iva;
            propina = total * TASA_PROPINA;
            total = total + propina;
        } else {
            iva = auxiliar * TASA_IVA;
            total = auxiliar + iva;
            propina = 0;
        }// fin if-else
        String separadorEstetico = "========================================";
        System.out.println(separadorEstetico);
        ImprimirEncabezado();
        System.out.println("    RESTAURANTE EL BUEN SABOR");
        System.out.println("    Calle 15 #8-32, Valledupar");
        System.out.println("    NIT: 900.123.456-7");
        System.out.println(separadorEstetico);
        System.out.printf("FACTURA No. %03d%n", PedidoActual.numeroFactura);
        System.out.println("----------------------------------------");
// imprime cada item del pedido
        int j = 0;
        while (j < Carta.nombreProductos.length) {
            if (Datos.cantidadProductos[j] > 0) {
                System.out.printf("%-20s x%-6d $%,.0f%n", Carta.nombreProductos[j], Datos.cantidadProductos[j], (Carta.precioProductos[j] * Datos.cantidadProductos[j]));
            }
            j++;
        }// fin while
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", auxiliar);
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", iva);
        if (propina > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", propina);
        }// fin if propina
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", total);
        System.out.println(separadorEstetico);
        System.out.println("Gracias por su visita!");
        System.out.println("El Buen Sabor - Valledupar");
        System.out.println(separadorEstetico);
// actualiza estado e incrementa factura - tres responsabilidades en un metodo
        PedidoActual.numeroFactura = PedidoActual.numeroFactura + 1;
        mesa.estadoMesa = 0;
        PedidoActual.total = total;
    }


}
