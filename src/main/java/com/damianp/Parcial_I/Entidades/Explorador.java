package com.damianp.Parcial_I.Entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author damianp
 */
public class Explorador extends Nave{
  // Atributos
  private TipoMision mision;
  private List<Nave> listaExploracion;

  // Constructor
  public Explorador(String nombre, int tripulacion,
    int anio, TipoMision tipo) {
    super(nombre, tripulacion, anio);
    this.mision = tipo;
    this.listaExploracion = new ArrayList<>();
  }

  // Getters y Setters
  public TipoMision getMision() {
    return mision;
  }

  public void setMision(TipoMision mision) {
    this.mision = mision;
  }

  // Metodos
  @Override
  public void mostrarNave() {
    System.out.println("\nNave: " + getNombre() + "\n" +
      "Tipo nave: Exploracion\n" + "Mision: " + mision);
  }

  @Override
  public boolean agregarNave(Nave nave) {
    boolean agregado = false;
    if(!listaExploracion.contains(nave)) {
      listaExploracion.add(nave);
      agregado = true;
    }
    else {
      System.out.println("Nave ya esta en lista.");
    }
    return agregado;
  }

  public void mostrarFlota() {
    System.out.println("===\tFLOTA EXPLORACION\t===");
    if(listaExploracion.isEmpty()) {
      System.out.println("Lista vacia");
    }
    listaExploracion.forEach(nave -> {
      System.out.println("Explorador: " + nave);
    });
  } 
}
