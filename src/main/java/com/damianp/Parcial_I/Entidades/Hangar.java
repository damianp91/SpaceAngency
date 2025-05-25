package com.damianp.Parcial_I.Entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author damianp
 *
 */
public class Hangar {
  // Atributos
  private List<Nave> flota = new ArrayList<>();
  Scanner scanner = new Scanner(System.in);

  // Metodos
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
    flota.forEach(nave -> {
      nave.mostrarNave();
    });
  }

  /**
   * Inicia la misión para naves explorables (Exploración y Cargueros).
   * Los Cruceros no participan y se informa por consola.
   */
  public void iniciarExploracion() {
    flota.forEach(nave -> {
      nave.iniciarExploracion();
    });
  }

}
