package com.damianp.Parcial_I.Entidades;

import java.util.Objects;

/**
 *
 * @author damianp
 *
 */

public abstract class Nave implements Comparable<Nave> {
  // Atributos
  private String nombre;
  private int capacidadTripulacion;
  private int anioLanzamiento;

  // Constructor
  /**
   * Constructor con los siguientes parametros.
   * @param nombre de tipo String Nombre de la nave
   * @param capacidad capacidad de la nave tipo int
   * @param anio anio de lanzamiento de tipo int
   */
  public Nave(String nombre, int capacidad, int anio) {
    this.nombre = nombre;
    this.capacidadTripulacion = capacidad;
    this.anioLanzamiento = anio;
  }

  // Gettes y Setters
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getCapacidadTripulacion() {
    return capacidadTripulacion;
  }

  public void setCapacidadTripulacion(int capacidadTripulacion) {
    this.capacidadTripulacion = capacidadTripulacion;
  }

  public int getAnioLanzamiento() {
    return anioLanzamiento;
  }

  public void setAnioLanzamiento(int anioLanzamiento) {
    this.anioLanzamiento = anioLanzamiento;
  }

  // Metodos
  @Override
  public boolean equals(Object obj) {
    if(this == obj) return true; 
    if(obj == null) return false; 
    if(getClass() != obj.getClass()) return false;
    Nave nav = (Nave) obj;
   
    return Objects.equals(nombre, nav.nombre) &&
      Objects.equals(anioLanzamiento, nav.anioLanzamiento);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombre, anioLanzamiento);
  }

  @Override
  public int compareTo(Nave otraNave) {
    if(this.anioLanzamiento != otraNave.anioLanzamiento) {
      // Lo organiza descendentemente
      return Integer.compare(otraNave.anioLanzamiento,
        this.anioLanzamiento);
    }
    else {
      return Integer.compare(otraNave.capacidadTripulacion,
        this.capacidadTripulacion);
    }
  }
 
  /**
   * Muestra la nave con sus datos.
   */
  public abstract void mostrarNave();

  /**
   * Inicia la misión para naves explorables (Exploración y Cargueros)
   */
  public abstract void iniciarExploracion();
 
}
