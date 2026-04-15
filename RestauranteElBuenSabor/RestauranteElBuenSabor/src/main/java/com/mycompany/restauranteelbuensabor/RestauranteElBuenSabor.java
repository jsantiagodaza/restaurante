    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.restauranteelbuensabor;

import java.util.Scanner;

/**
 *
 * @author alfre
 */
public class RestauranteElBuenSabor {
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
int opcion=0;boolean bandera=true;int x=0;String auxiliar="";int temporal=0;double m=0;boolean continuar=true;
System.out.println("========================================");
System.out.println("    RESTAURANTE EL BUEN SABOR");
System.out.println("    Calle 15 #8-32, Valledupar");
System.out.println("    NIT: 900.123.456-7");
System.out.println("========================================");
while(bandera){
System.out.println("1. Ver carta");
System.out.println("2. Agregar producto al pedido");
System.out.println("3. Ver pedido actual");
System.out.println("4. Generar factura");
System.out.println("5. Nueva mesa");
System.out.println("0. Salir");
System.out.println("========================================");
System.out.print("Seleccione una opcion: ");
opcion=sc.nextInt();
if(opcion==1){
// mostrar carta
FacturaImpresion.mostrarCarta();
System.out.println();
}else if(opcion==2){
// agregar producto
System.out.println("--- AGREGAR PRODUCTO ---");
System.out.print("Numero de producto (1-"+Carta.nombreProductos.length+"): ");
int n=sc.nextInt();
System.out.print("Cantidad: ");
int c=sc.nextInt();
if(n>0&&n<=Carta.nombreProductos.length){
if(c>0){
if(mesa.estadoMesa==0){
// mesa no activa - pedir numero de mesa
System.out.print("Ingrese numero de mesa: ");
mesa.mesa=sc.nextInt();
if(mesa.mesa>0){
mesa.estadoMesa=1;
auxiliar=String.valueOf(mesa.mesa);
temporal=mesa.mesa;
x=temporal+1;}
else{
// mesa invalida pero se continua igual
mesa.mesa=1;mesa.estadoMesa=1;
auxiliar="1";temporal=1;x=2;}// fin if mesa>0
}// fin if estadoMesa==0
// agrega al pedido
Datos.cantidadProductos[n-1]=Datos.cantidadProductos[n-1]+c;
System.out.println("Producto agregado al pedido.");
System.out.println("  -> "+Carta.nombreProductos[n-1]+" x"+c);
m=Carta.precioProductos[n-1]*c;
}else{
if(c==0){
// cantidad es cero
System.out.println("La cantidad no puede ser cero.");}
else{
// cantidad negativa
System.out.println("Cantidad invalida. Ingrese un valor positivo.");}
}// fin if c>0
}else{
if(n<=0){
System.out.println("El numero debe ser mayor a cero.");}
else{
System.out.println("Producto no existe. La carta tiene "+Carta.nombreProductos.length+" productos.");}
}// fin if n>0
System.out.println();
}else if(opcion==3){
// ver pedido actual
System.out.println();
if(Utilidades.hayProductosEnPedido()){
FacturaImpresion.mostrarPedido();
}else{
System.out.println("No hay productos en el pedido actual.");
System.out.println("Use la opcion 2 para agregar productos.");
continuar=true;}// fin if hayProductosEnPedido
System.out.println();
}else if(opcion==4){
// generar factura
System.out.println();
if(Utilidades.hayProductosEnPedido()){
double r=0;
// procesar pedido y generar total
r=CalculadorFactura.calcularTotalFactura();
temporal=(int)r;
auxiliar="Total calculado: $"+temporal;
m=r;
// imprimir factura detallada
FacturaImpresion.imprimirFacturaCompleta();
System.out.println();
}else{
System.out.println("No se puede generar factura.");
System.out.println("No hay productos en el pedido.");
System.out.println("Use la opcion 2 para agregar productos primero.");
// reiniciar variables locales
temporal=0;auxiliar="";m=0;continuar=true;}// fin if hayProductosEnPedido
}else if(opcion==5){
// nueva mesa - reiniciar pedido
System.out.println();
Utilidades.reiniciar();
// limpiar variables locales del main
x=0;temporal=0;auxiliar="";m=0;continuar=true;
System.out.println("Mesa reiniciada. Lista para nuevo cliente.");
System.out.println();
}else if(opcion==0){
// salir
bandera=false;
System.out.println("Hasta luego!");
}else{
// opcion no reconocida
System.out.println("Opcion no valida. Seleccione entre 0 y 5.");
Scanner sc2=new Scanner(System.in);
x=x+1;
if(x>3){
System.out.println("Demasiados intentos invalidos.");
x=0;
// limpiar buffer con segundo scanner - innecesario
String s2=sc2.hasNextLine()?sc2.nextLine():"";}// fin if cadenaTexto>3
}// fin if-else opcion
}// fin while
sc.close();}// fin main
}
