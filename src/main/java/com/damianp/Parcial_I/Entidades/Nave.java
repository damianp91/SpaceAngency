package com.damianp.Parcial_I.Entidades;

import java.util.Comparator;
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
  public int compareTo(Nave nave) {
    if(this.anioLanzamiento != nave.anioLanzamiento) {
      // Lo organiza descendentemente
      return Integer.compare(nave.anioLanzamiento,
        this.anioLanzamiento);
    }
    else {
      return Integer.compare(nave.capacidadTripulacion,
        this.capacidadTripulacion);
    }
  }

  // Comparadores estáticos para otros órdenes
  public static Comparator<Nave> porNombre() {
    return (n1, n2) -> n1.getNombre().compareTo(n2.getNombre());
  }

  public static Comparator<Nave> porAnioDescendente() {
    // Reutilizo la logica del compareTo que ya lo ordena
    // por el criterio de año descendente
    return Nave::compareTo;
  }

  public static Comparator<Nave> porCapacidadDescendente() {
    return (n1, n2) -> Integer.compare(n2.capacidadTripulacion,
      n1.capacidadTripulacion);
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
