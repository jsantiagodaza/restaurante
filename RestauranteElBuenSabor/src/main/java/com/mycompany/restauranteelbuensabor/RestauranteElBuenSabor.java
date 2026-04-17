/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.restauranteelbuensabor;

import java.util.Scanner;
import com.mycompany.restauranteelbuensabor.Factura;

/**
 *
 * @author alfre
 */
public class RestauranteElBuenSabor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean ejecutando = true;

        FacturaImpresion.imprimirEncabezado();

        while (ejecutando) {
            mostrarMenuPrincipal();
            int opcionMenu = scanner.nextInt();

            if (opcionMenu == 1) {
                FacturaImpresion.mostrarCarta();

            } else if (opcionMenu == 2) {
                procesarAgregarProducto(scanner);

            } else if (opcionMenu == 3) {
                mostrarPedidoActual();

            } else if (opcionMenu == 4) {
                generarFactura();

            } else if (opcionMenu == 5) {
                reiniciarMesa();

            } else if (opcionMenu == 0) {
                ejecutando = false;
                System.out.println("Hasta luego!");

            } else {
                System.out.println("Opcion no valida. Seleccione entre 0 y 5.");
            }
        }

        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("1. Ver carta");
        System.out.println("2. Agregar producto al pedido");
        System.out.println("3. Ver pedido actual");
        System.out.println("4. Generar factura");
        System.out.println("5. Nueva mesa");
        System.out.println("0. Salir");
        System.out.println("========================================");
        System.out.print("Seleccione una opcion: ");
    }

    private static void procesarAgregarProducto(Scanner scanner) {
        System.out.println("--- AGREGAR PRODUCTO ---");
        System.out.print("Numero de producto (1-" + Carta.PRODUCTOS.length + "): ");
        int numeroProducto = scanner.nextInt();
        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();

        if (numeroProducto <= 0 || numeroProducto > Carta.PRODUCTOS.length) {
            System.out.println("Producto no existe. La carta tiene " + Carta.PRODUCTOS.length + " productos.");
            return;
        }

        if (cantidad <= 0) {
            System.out.println("Cantidad invalida. Ingrese un valor positivo.");
            return;
        }

        if (mesa.estadoMesa == 0) {
            System.out.print("Ingrese numero de mesa: ");
            int numeroMesa = scanner.nextInt();
            mesa.mesa = (numeroMesa > 0) ? numeroMesa : 1;
            mesa.estadoMesa = 1;
        }

        Producto producto = Carta.PRODUCTOS[numeroProducto - 1];
        PedidoActual.pedido.agregarItem(producto, cantidad);
        System.out.println("Producto agregado al pedido.");
        System.out.println("  -> " + producto.getNombre() + " x" + cantidad);
        System.out.println();
    }

    private static void mostrarPedidoActual() {
        System.out.println();
        if (PedidoActual.pedido.tieneProductos()) {
            FacturaImpresion.mostrarPedido();
        } else {
            System.out.println("No hay productos en el pedido actual.");
            System.out.println("Use la opcion 2 para agregar productos.");
        }
        System.out.println();
    }

    private static void generarFactura() {
        System.out.println();
        if (!PedidoActual.pedido.tieneProductos()) {
            System.out.println("No se puede generar factura.");
            System.out.println("No hay productos en el pedido.");
            System.out.println("Use la opcion 2 para agregar productos primero.");
            return;
        }

        Factura factura = new Factura(PedidoActual.pedido, PedidoActual.numeroFactura);
        PedidoActual.total = factura.calcularTotal();
        FacturaImpresion.imprimirFacturaCompleta(factura);

        PedidoActual.numeroFactura = PedidoActual.numeroFactura + 1;
        mesa.estadoMesa = 0;
        System.out.println();
    }

    private static void reiniciarMesa() {
        System.out.println();
        PedidoActual.pedido.limpiar();
        PedidoActual.total = 0;
        mesa.estadoMesa = 0;
        mesa.mesa = 0;
        System.out.println("Mesa reiniciada. Lista para nuevo cliente.");
        System.out.println();
    }
}
