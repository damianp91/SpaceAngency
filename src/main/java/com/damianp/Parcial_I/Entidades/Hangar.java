package com.damianp.Parcial_I.Entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase encargada del ingreso, validacion y ordenamiento de la clase
 * Nave
 * @author Damian Posada
 *
 */
public class Hangar {
  // Atributos
  private List<Nave> flota = new ArrayList<>();
  Scanner scanner = new Scanner(System.in);

  // Metodos
  /**
   * Verifica que el elemento ingresado sea un entero
   * @return Si es un entero retorna un valor de tipo entero
   */
  private int leerEntero() {
    while(!scanner.hasNextInt()) {
      System.out.println("Debe ingresar un numero: ");
      // Limpia consola
      scanner.next();
    }
    int elemento = scanner.nextInt();
    // Agregar salto de linea
    scanner.nextLine();
    return elemento;
  }

  /**
   * Verifica que el elemento ingresado tenga por lo menos un caracter.
   * @return Si hay caracteres retorna un valor de tipo String
   */
  private String leerString() {
    while(!scanner.hasNext(".+")) {
      System.out.println("Debe ingresar al menos 1 caracter.");
      scanner.next();
    }
    String elemento = scanner.next();
    scanner.nextLine();
    return elemento;
  }

  /**
   * Crea una nueva instancia del objeto Nave segun eleccion del usuario
   * usando el metodo switch expression 'switch {case -> {...}}'
   * @return
   */
  private Nave crearNave() {
    System.out.println("""
      Tipo de nave a agregar:
      1. Exploración
      2. Carguero
      3. Crucero Estelar
      """);
    int eleccion = leerEntero();
    
    System.out.println("Nombre: ");
    String nombre = leerString();
    System.out.println("Capacidad tripulacion: ");
    int tripulacion = leerEntero();
    System.out.println("Anio de lanzamiento: ");
    int anio = leerEntero();
    
    // este switch se lo denomina switch expression que es diferente a
    // switch statement que es el convencional.
    return switch(eleccion) {
      case 1 -> {
        System.out.println("""
          Tipo de misión:
          1. CARTOGRAFÍA
          2. INVESTIGACIÓN
          3. CONTACTO
          """);
        int eleccionMision = leerEntero();
        TipoMision tipo;
        if(eleccionMision == 1) {
          tipo = TipoMision.CARTOGRAFIA;
        }
        else if(eleccionMision == 2) {
          tipo = TipoMision.INVESTIGACION;
        }
        else {
          tipo = TipoMision.CONTACTO;
        }
        yield new Explorador(nombre, tripulacion, anio, tipo);
      }
      case 2 -> {
        System.out.println("Capacidad de carga (toneladas): ");
        int carga = leerEntero();
        // Se evalua de adentro hacia fuera con un ajuste por
        // limites o 'clamping'
        carga = Math.max(100, Math.min(500, carga));
        yield new Carguero(nombre, tripulacion, anio, carga);
      }
      case 3 -> {
        System.out.println("Cantidad de pasajeros: ");
        int pasajeros = leerEntero();
        yield new CruceroEstelar(nombre, tripulacion, anio, pasajeros);
      }
      default -> {
        System.out.println("Eleccion invalida.");
        yield null;
      }
    };
  }

  /**
   * Agrega una nave si no existe ya una con el mismo nombre y año
   * @param nave
   * @return false si existe nave true en caso contrario
   */
  public boolean agregarNave(Nave nave) {
    boolean agregar = false;
    if(!flota.contains(nave)) {
      agregar = true;
    }
    return agregar;
  }

  /**
   * Muestra todas las naves con sus datos.
   */
  public void mostrarNaves() {
    System.out.println("===\t NAVES EN HANGAR\t===\t");
    flota.forEach(nave -> {
      nave.mostrarNave();
    });
    System.out.println("============================");
  }

  /**
   * Inicia la misión para naves explorables (Exploración y Cargueros).
   * Los Cruceros no participan y se informa por consola.
   */
  public void iniciarExploracion() {
    System.out.println("===\t INICIO DE EXPLORACION\t===\t");

    flota.forEach(nave -> {
      nave.iniciarExploracion();
    });
    System.out.println("============================");
  }
  
  public void ordenarPorNombre() {
    Nave.porNombre();
  }

  public void ordenarPorAnioDesc() {
    Nave.porAnioDescendente();
  }

  public void ordenarPorCapacidadDesc() {
    Nave.porCapacidadDescendente();
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
        case 1 -> {
          Nave nave = crearNave();
          if(agregarNave(nave)){
            flota.add(nave);
          }
          else {
            System.out.println("Nave " + nave.getNombre() + "no se puede agregar." +
            "Ya se encuentra en lista de flota.");
          }
        }
        case 2 -> {
          if(flota.isEmpty()) {
            System.out.println("En este momento el Hangar no cuenta con naves.");
          }
          else {
            flota.forEach(nave -> {
              nave.mostrarNave();
            });
          }
        }
        case 3 -> {
          if(flota.isEmpty()) {
            System.out.println("En este momento el Hangar no cuenta con naves.");
          }
          else {
            flota.forEach(nave -> {
              nave.iniciarExploracion();
            });
          }
        }
        case 4 -> {
          if(flota.isEmpty()) {
            System.out.println("En este momento el Hangar no cuenta con naves.");
          }
          else {
            ordenarPorNombre();
          }
        }
        case 5 -> {
          if(flota.isEmpty()) {
            System.out.println("En este momento el Hangar no cuenta con naves.");
          }
          else {
            ordenarPorAnioDesc();
          }
        }
        case 6 -> {
          if(flota.isEmpty()) {
            System.out.println("En este momento el Hangar no cuenta con naves.");
          }
          else {
            ordenarPorCapacidadDesc();
          }
        }
        case 7 -> System.out.println("Saliendo del sistema...");
        default -> System.out.println("Opción inválida.");
      }
    } while (opcion != 7);
  }
}
