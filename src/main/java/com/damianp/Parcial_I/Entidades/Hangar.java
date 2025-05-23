package com.damianp.Parcial_I.Entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author damianp
 */
public class Hangar {
  private List<Nave> ListaNaves = new ArrayList<>();
  private Scanner scanner = new Scanner(System.in);

  private int leerEntero() {
    while (!scanner.hasNextInt()) {
      System.out.print("Debe ingresar un número: ");
      scanner.next(); // Limpia entrada inválida
    }
    int valor = scanner.nextInt();
    scanner.nextLine(); // Consumir salto de línea
    return valor;
  }

  public void menuPrincipal() {
    int opcion;
    do {
      System.out.println("""
        ===\tHANGAR DE NAVES\t===\n
        1. Agregar nave (Exploración, Carguero o Crucero Estelar)
        2. Mostrar todas las naves registradas
        3. Iniciar misión de exploración
        4. Mostrar naves ordenadas por nombre
        5. Mostrar naves ordenadas por año de lanzamiento descendente
        6. Mostrar naves ordenadas por capacidad de tripulación descendente
        7. Salir del Sistema
        Seleccione una opción:
        """);

      opcion = leerEntero();

      switch (opcion) {
        case 1 -> agregarNave();
        case 2 -> mostrarNaves();
        case 3 -> iniciarMision();
        case 4 -> mostrarOrdenadasPorNombre();
        case 5 -> mostrarOrdenadasPorAnio();
        case 6 -> mostrarOrdenadasPorCapacidad();
        case 7 -> System.out.println("Saliendo del sistema...");
        default -> System.out.println("Opción inválida.");
      }
    } while (opcion != 7);
  }

  private void agregarNave() {
    System.out.println("""
      Tipo de nave a agregar:
      1. Exploración
      2. Carguero
      3. Crucero Estelar
      """);
    int tipo = leerEntero();
    System.out.print("Nombre: ");
    String nombre = scanner.nextLine();
    System.out.print("Capacidad tripulación: ");
    int tripulacion = leerEntero();
    System.out.print("Año de lanzamiento: ");
    int anio = leerEntero();
  }

  private void mostrarNaves() {

  }

  private void iniciarMision() {

  }

  private void mostrarOrdenadasPorNombre() {

  }

  private void mostrarOrdenadasPorAnio() {

  }

  private void mostrarOrdenadasPorCapacidad() {

  }
}
