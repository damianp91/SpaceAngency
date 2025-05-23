package com.damianp.Parcial_I.Entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author damianp
 */
public class CruceroEstelar extends Nave{
  // Atributos
  private int cantidadPasajeros;
  private List<Nave> listaCruceroEstelar;

  // Constructor
  public CruceroEstelar(String nombre, int tripulacion,
    int anio, int cantidad) {
    super(nombre, tripulacion, anio);
    this.cantidadPasajeros = cantidad;
    this.listaCruceroEstelar = new ArrayList<>();
  }

  // Getters y Setters
  public int getCantidadPasajeros() {
    return cantidadPasajeros;
  }

  public void setCantidadPasajeros(int cantidadPasajeros) {
    this.cantidadPasajeros = cantidadPasajeros;
  }

  // Metodos
  @Override
  public void mostrarNave() {
    System.out.println("\nNave: " + getNombre() + "\n" +
      "Tipo nave: Crucero Estelar\n" + "Cantidad Pasajeros: " +
      cantidadPasajeros);
  }

  @Override
  public boolean agregarNave(Nave nave) {
    boolean agregado = false;
    if(!listaCruceroEstelar.contains(nave)) {
      listaCruceroEstelar.add(nave);
      agregado = true;
    }
    else {
      System.out.println("Nave ya esta en lista.");
    }
    return agregado;
  }

  public void mostrarFlota() {
    System.out.println("===\tFLOTA CRUCERO ESTELAR\t===");
    if(listaCruceroEstelar.isEmpty()) {
      System.out.println("Lista vacia");
    }
    listaCruceroEstelar.forEach(nave -> {
      System.out.println("Explorador: " + nave);
    });
  }
}
