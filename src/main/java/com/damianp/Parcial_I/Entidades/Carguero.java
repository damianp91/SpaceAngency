package com.damianp.Parcial_I.Entidades;

/**
 *
 * @author damianp
 */
public class Carguero extends Nave{
  private int capacidadCarga;

  // Constructor
  public Carguero(String nombre, int tripulacion,
    int anio, int capacidad) {
    super(nombre, tripulacion, anio);
    this.capacidadCarga = capacidad;
  }

  // Getters y Setters
  public int getCapacidadCarga() {
    return capacidadCarga;
  }

  public void setCapacidadCarga(int capacidadCarga) {
    if(capacidadCarga < 100) {
      System.out.println("Capacidad de carga menor a 100. Se ajusta a 100 toneladas.");
      this.capacidadCarga = 100;
    }
    else if(capacidadCarga > 500){
      System.out.println("Capacidad de carga mayor a 500. Se ajusta a 500 toneladas");
      this.capacidadCarga = 500;
    }
    else {
      this.capacidadCarga = capacidadCarga;
    }
  }   

  // Metodos
  @Override
  public void mostrarNave() {
    System.out.println(String.format("""
      Nombre:
      Tipo: Carguero. 
      Cap Tripulacion: 
      Anio Lanzamiento: 
      "Capacidad carga (en toneladas):
      """,
      getNombre(),
      getCapacidadTripulacion(),
      getAnioLanzamiento(),
      capacidadCarga
    ));
  }

  @Override
  public void iniciarExploracion() {
    System.out.println("Carguero " + getNombre() + "inicia mision de " +
    "exploracion.");
  }
}
