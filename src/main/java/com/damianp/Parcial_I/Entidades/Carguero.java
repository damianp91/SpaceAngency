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
    this.capacidadCarga = Math.max(100, Math.min(500, capacidadCarga));
  }   

  // Metodos
  @Override
  public void mostrarNave() {
    System.out.println(String.format("""
      Nombre: %s
      Tipo: Carguero. 
      Cap Tripulacion: %d 
      Anio Lanzamiento: %d
      Capacidad carga (en toneladas): %d
      """,
      getNombre(),
      getCapacidadTripulacion(),
      getAnioLanzamiento(),
      capacidadCarga
    ));
  }

  @Override
  public void iniciarExploracion() {
    System.out.println("Carguero " + getNombre() + " inicia mision de " +
    "exploracion.");
  }
}
