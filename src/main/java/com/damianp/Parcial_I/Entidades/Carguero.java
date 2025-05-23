package com.damianp.Parcial_I.Entidades;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author damianp
 */
public class Carguero extends Nave{
  private int capacidadCarga;
  private List<Nave> listaCargueros;

  // Constructor
  public Carguero(String nombre, int tripulacion,
    int anio, int capacidad) {
    super(nombre, tripulacion, anio);
    if(capacidad >= 100 && capacidad <= 500) {
      this.capacidadCarga = capacidad;
    }
    else {
      System.out.println("Debe ser un numero entre 100 y 500");
    }
    this.listaCargueros = new ArrayList<>();

  }

  // Getters y Setters
  public int getCapacidadCarga() {
    return capacidadCarga;
  }

  public void setCapacidadCarga(int capacidadCarga) {
    if(capacidadCarga >= 100 && capacidadCarga <= 500) {
      this.capacidadCarga = capacidadCarga;
    }
  }   

  // Metodos
  @Override
  public void mostrarNave() {
    System.out.println("\nNave: " + getNombre() + "\n" +
      "Tipo nave: Carguero\n" + "Capacidad: " + capacidadCarga);
  }

  @Override
  public boolean agregarNave(Nave nave) {
    boolean agregado = false;
    if(!listaCargueros.contains(nave)) {
      listaCargueros.add(nave);
      agregado = true;
    }
    else {
      System.out.println("Nave ya esta en lista.");
    }
    return agregado;
  }

  public void mostrarFlota() {
    System.out.println("===\tFLOTA CARGUEROS\t===");
    if(listaCargueros.isEmpty()) {
      System.out.println("Lista vacia");
    }
    listaCargueros.forEach(nave -> {
      System.out.println("Explorador: " + nave);
    });
  }
}
