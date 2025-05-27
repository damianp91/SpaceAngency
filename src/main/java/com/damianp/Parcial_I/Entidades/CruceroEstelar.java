package com.damianp.Parcial_I.Entidades;

/**
 *
 * @author damianp
 */
public class CruceroEstelar extends Nave{
  // Atributos
  private int cantidadPasajeros;

  // Constructor
  public CruceroEstelar(String nombre, int tripulacion,
    int anio, int cantidad) {
    super(nombre, tripulacion, anio);
    this.cantidadPasajeros = cantidad;
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
    System.out.println(String.format("""
      Nombre: %s
      Tipo: Crucero Estelar 
      Cap Tripulacion: %d  
      Anio Lanzamiento: %d
      Cant. de pasajeros: %d
      """,
      getNombre(),
      getCapacidadTripulacion(),
      getAnioLanzamiento(),
      cantidadPasajeros
    ));
  }

  @Override
  public void iniciarExploracion() {
    System.out.println("Crucero Estelar " + getNombre() + " no participa" +
    " de misiones de exploracion");
  }

}
