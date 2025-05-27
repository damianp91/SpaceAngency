package com.damianp.Parcial_I.Entidades;

/**
 *
 * @author damianp
 */
public class Explorador extends Nave{
  // Atributos
  private TipoMision mision;

  // Constructor
  public Explorador(String nombre, int tripulacion,
    int anio, TipoMision tipo) {
    super(nombre, tripulacion, anio);
    this.mision = tipo;
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
    System.out.println(String.format("""
      Nombre: %s
      Tipo: Explorador.
      Cap Tripulacion: %d 
      Anio Lanzamiento: %d
      Mision: %s
      """,
      getNombre(),
      getCapacidadTripulacion(),
      getAnioLanzamiento(),
      mision
    ));
  }
  
  @Override
  public void iniciarExploracion() {
    System.out.println("Nave de exploracion: " + getNombre() +
      " inicia mision de exploracion de tipo: " + mision);
  }
 
}
