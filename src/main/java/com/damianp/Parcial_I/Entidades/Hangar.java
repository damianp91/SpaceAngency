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
      System.out.print("Debe ingresar un numero: ");
      // Limpia consola
      scanner.next();
    }
    int elemento = scanner.nextInt();
    // Agregar salto de linea
    scanner.nextLine();
    return elemento;
  }

  private String toCapitalice(String p) {
    String[] array = p.split(" ");
    for(int i = 0; i < array.length; i ++) {
      array[i] = array[i].substring(0, 1).toUpperCase() + 
        array[i].substring(1).toLowerCase();
    }
    p = String.join(" ", array);
    return p;
  }

  /**
   * Verifica que el elemento ingresado tenga por lo menos un caracter.
   * @return Si hay caracteres retorna un valor de tipo String
   */
  private String leerString() {
    String palabra = "";
    do {
      palabra = scanner.nextLine().trim();
      if(palabra.isEmpty()) {
        System.out.print("Debe ingresar al menos un caracter para identificar: " +
        "a la nave.");
      }
    } while(palabra.isEmpty());
    return palabra;
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
    
    System.out.print("Nombre: ");
    String nombre = leerString();
    System.out.print("Capacidad tripulacion: ");
    int tripulacion = leerEntero();
    System.out.print("Anio de lanzamiento: ");
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
        yield new Explorador(toCapitalice(nombre), tripulacion, anio, tipo);
      }
      case 2 -> {
        System.out.print("Capacidad de carga (toneladas): ");
        int carga = leerEntero();
        // Se evalua de adentro hacia fuera con un ajuste por
        // limites o 'clamping'
        carga = Math.max(100, Math.min(500, carga));
        yield new Carguero(toCapitalice(nombre), tripulacion, anio, carga);
      }
      case 3 -> {
        System.out.print("Cantidad de pasajeros: ");
        int pasajeros = leerEntero();
        yield new CruceroEstelar(toCapitalice(nombre), tripulacion, anio, pasajeros);
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
    return nave != null && !flota.contains(nave);
  }

  /**
   * Muestra todas las naves con sus datos.
   */
  public void mostrarNaves() {
    System.out.println("===\t NAVES EN HANGAR\t===\n");
    flota.forEach(nave -> {
      nave.mostrarNave();
    });
    System.out.println("======================================");
  }

  /**
   * Inicia la misión para naves explorables (Exploración y Cargueros).
   * Los Cruceros no participan y se informa por consola.
   */
  public void iniciarExploracion() {
    System.out.println("===\t INICIO DE EXPLORACION\t===\n");
    flota.forEach(nave -> {
      nave.iniciarExploracion();
    });
    System.out.println("=======================================");
  }
  
  public void ordenarPorNombre() {
    System.out.println("Ordenamiento por nombre.");
    flota.sort(Nave.porNombre());
    mostrarNaves();
  }

  public void ordenarPorAnioDesc() {
    System.out.println("Ordenamiento por anio");
    flota.sort(Nave.porAnioDescendente());
    mostrarNaves();
  }

  public void ordenarPorCapacidadDesc() {
    System.out.println("Ordenamiento por capacidad");
    flota.sort(Nave.porCapacidadDescendente());
    mostrarNaves();
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
          if(nave != null && agregarNave(nave)){
            flota.add(nave);
            System.out.println("Nave agregada con exito.");
          }
          else if(nave == null) {
            System.out.println("No ingreso datos a nave. No se agregara" +
              "a lista de Hagar");
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
            mostrarNaves();
          }
        }
        case 3 -> {
          if(flota.isEmpty()) {
            System.out.println("En este momento el Hangar no cuenta con naves.");
          }
          else {
            iniciarExploracion();
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
