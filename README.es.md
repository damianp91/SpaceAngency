# 🌐 Idioma / Language  
> 📌 **Selecciona tu idioma:**  
> - [**Español**](README.es.md) (actual)  
> - [English](README.md)  
---
# SpaceAngency

## Sistema de Gestión de Expediciones Espaciales

### Contexto General
La Agencia Espacial administra una flota de naves que participan en diversas misiones
interplanetarias. Cada nave espacial tiene características comunes, pero también atributos
específicos dependiendo de su tipo.
La agencia gestiona los siguientes tipos de naves:

- 🛰 Naves de Exploración: Realizan misiones del tipo CARTOGRAFÍA, INVESTIGACIÓN o
    CONTACTO.
- 🚚 Cargueros: Transportan suministros y poseen una capacidad de carga entre 100 y 500
    toneladas.
- 🚀 Cruceros Estelares: Transportan pasajeros a través del espacio profundo.
    Requisitos del Sistema
### Todas las naves poseen:
- nombre (String)
- capacidad de tripulación (int)
- año de lanzamiento (int)

### Las subclases poseen atributos adicionales

|Tipo Nave          | Atributos específicos                            |
|-------------------|--------------------------------------------------|
|Exploración        | tipoMision: CARTOGRAFIA; INVESTIGACION; CONTACTO |
|Carguero           | capacidadCarga: entre 100 y 500 toneladas        |
|Crucero            | Estelar cantidadPasajeros (int)                  |

### Comportamientos comunes:
- mostrarNaves(): muestra todas las naves con sus datos.
- agregarNave(Nave nave): agrega una nave si no existe ya una con el mismo nombre y año
- iniciarExploracion(): Inicia la misión para naves explorables (Exploración y Cargueros). Los
  Cruceros no participan y se informa por consola.

### Métodos de comparación:
- Dos naves se consideran iguales si tienen el mismo nombre y el mismo año de
  lanzamiento.
- Se implementa ```javaComparable<Nave>``` para ordenar por:
- Año de lanzamiento (más reciente primero)
- Capacidad de tripulación (mayor a menor)

### Funcionalidades disponibles desde el menú por consola
1. Agregar nave (Exploración, Carguero o Crucero Estelar)
2. Mostrar todas las naves registradas.
3. Iniciar misión de exploración
4. Mostrar naves ordenadas por nombre (Comparable)
5. Mostrar naves ordenadas por año de lanzamiento descendente.
6. Mostrar naves ordenadas por capacidad de tripulación descendente.
7. Salir del Sistema

### Validaciones
- La validación de la capacidad de carga (100 a 500) se realiza antes de instanciar el
  objeto carguero u otra opción si se ingresa un valor menor a 100 setear a 100
  análogamente para el límite superior.
- El sistema no utiliza excepciones para el control de flujo, sino validaciones previas y
  mensajes amigables.
- El uso de equals() permite validar duplicados de forma clara y reutilizable

> [!TIP]
> Ejemplo de ejecución
```console
=== MENÚ DE GESTIÓN DE EXPEDICIONES ESPACIALES ===
1. Agregar nave  
2. Mostrar todas las naves  
3. Iniciar exploración  
4. Mostrar naves ordenadas por nombre  
5. Mostrar naves ordenadas por año de lanzamiento (desc)  
6. Mostrar naves ordenadas por tripulación (desc)  
7. Salir  

Seleccione una opción: 1  
--- Tipo de nave ---  
1. Nave de exploración  
2. Carguero  
3. Crucero estelar  

Seleccione tipo de nave: 2  
Nombre: CargaGalaxia  

Capacidad de tripulación: 8  
Año de lanzamiento: 2047  

Capacidad de carga (100 a 500): 450  
Nave agregada con éxito.
```

### A partir del enunciado anterior, se solicita:
1. Realizar el diagrama de clases completo utilizando umletino, mostrando la relación
   entre Nave, NaveExploracion, Carguero, CruceroEstelar y demás.
2. Implementar el código fuente en Java que resuelva las funcionalidades solicitadas.

### Detalles adicionales:

* Diagrama de Clases:
    - Debe reflejar correctamente la jerarquía de clases entre las naves.
    - Los atributos comunes deben estar en la clase base Nave y los específicos en las clases
      derivadas.
* Clases y Herencia:
    - Debe haber una clase abstracta Nave que contenga los atributos comunes:
      nombre, capacidad de tripulación y año de lanzamiento.
    - Deben implementarse tres clases que hereden de Nave: NaveExploracion, Carguero y
      CruceroEstelar.
    - Las naves de exploración deben tener el atributo tipoMision (que contenga los valores:
      CARTOGRAFÍA, INVESTIGACIÓN, CONTACTO), los cargueros deben tener el atributo
      capacidadCarga (en toneladas) y los cruceros estelares el atributo cantidadPasajeros.
* Métodos:
    - El método agregarNave() debe añadir naves a una colección y lanzar una excepción si la
      nave ya existe.
    - El método mostrarNaves() debe imprimir una lista con todas las naves y sus atributos.
    - El método iniciarExploracion() debe permitir iniciar la exploración para naves de
      exploración y cargueros, e informar que los cruceros estelares no pueden participar en
      misiones.
    - Desarrolle los métodos necesarios para asegurar su funcionalidad


### Ejemplos de escenarios:
1. Agregar naves espaciales:
    - Se debe poder agregar un carguero llamado "Galáctica" con una capacidad de
      carga de 300 toneladas, y al intentar agregar otra nave con el mismo nombre y
      año de lanzamiento, se debe lanzar la advertencia
2. Mostrar naves:
    - El sistema debe poder listar todas las naves, mostrando tanto los atributos
      comunes (nombre, capacidad de tripulación, año de lanzamiento) como los
      específicos (tipo de misión, capacidad de carga o cantidad de pasajeros).
3. Iniciar exploración:
    - El sistema debe permitir que las naves de exploración y los cargueros inicien su
      misión, mientras que debe indicar que los cruceros estelares no pueden participar.

-------
## Tabla de datos de prueba para la agencia espacial
| Tipo de Nave         | Nombre           | Cap. Tripulación | Año Lanzamiento | Atributo Específico              |
|-----------------------|------------------|------------------|-----------------|-----------------------------------|
| Nave de Exploración   | Odisea           | 10               | 2050            | Misión: INVESTIGACIÓN             |
| Nave de Exploración   | CosmosX          | 7                | 2042            | Misión: CARTOGRAFÍA               |
| Nave de Exploración   | Alfa Centauri    | 6                | 2035            | Misión: CONTACTO                  |
| Carguero              | CargaGalaxia     | 5                | 2047            | Capacidad de carga: 450 toneladas |
| Carguero              | VulcanoCargo     | 8                | 2049            | Capacidad de carga: 300 toneladas |
| Carguero              | MercurioX        | 4                | 2045            | Capacidad de carga: 120 toneladas |
| Crucero Estelar       | EstelarLux       | 15               | 2045            | Pasajeros: 1000                   |
| Crucero Estelar       | NebulaStar       | 20               | 2048            | Pasajeros: 1500                   |
| Crucero Estelar       | AuroraEspacial   | 12               | 2038            | Pasajeros: 750                    |


-------
## Escenarios de prueba funcional
| Nº | Escenario                              | Entrada / Acción                                      | Resultado Esperado                                                                 |
|----|----------------------------------------|-------------------------------------------------------|-----------------------------------------------------------------------------------|
| 1  | Agregar nave de exploración válida     | Nombre: Odisea, Año: 2050, Misión: INVESTIGACIÓN      | Nave agregada correctamente                                                       |
| 2  | Agregar nave carguero con carga válida | Nombre: CargaGalaxia, Carga: 400 toneladas            | Nave agregada correctamente                                                       |
| 3  | Agregar crucero estelar                | Nombre: EstelarLux, Pasajeros: 1200                   | Nave agregada correctamente                                                       |
| 4  | Agregar carguero con carga fuera de rango | Carga: 90 toneladas                                | Rechazo con mensaje: "Valor fuera de rango. Intente nuevamente."                  |
| 5  | Agregar nave duplicada                 | Nombre: Odisea, Año: 2050 (ya existe)                 | Rechazo con mensaje: "Ya existe una nave con ese nombre y año de lanzamiento."    |
| 6  | Mostrar todas las naves                | Acción: opción 2 del menú                             | Lista de naves en orden de ingreso                                                |
| 7  | Iniciar exploración                    | Acción: opción 3                                      | Ejecuta método `explorar()` en exploradoras y cargueros. Informa para cruceros.   |
| 8  | Ordenar por nombre (Comparable)        | Acción: opción 4                                      | Lista ordenada alfabéticamente por nombre                                         |
| 9  | Ordenar por año de lanzamiento (Comparator) | Acción: opción 5                                  | Lista ordenada del más reciente al más antiguo                                    |
| 10 | Ordenar por capacidad de tripulación (Comparator) | Acción: opción 6                              | Lista ordenada por mayor capacidad de tripulación primero                         |

-------
## Escenarios de Validación y Manejo de Errores
| Nº | Escenario                           | Entrada / Acción                 | Resultado Esperado                          |
|:--:|:-----------------------------------:|:--------------------------------:|:-------------------------------------------:|
| 11 | Cargar nave con año negativo       | Año de lanzamiento: -2030        | Rechazo o mensaje de validación previa      |
| 12 | Cargar nave con nombre vacío       | Nombre: [Enter]                  | Rechazo o mensaje solicitando reingreso     |
| 13 | Cargar carguero sin validar carga  | Carga: 1000                      | Se ajusta o se muestra advertencia          |
| 14 | Ingresar tipo de nave inválido     | Tipo: 99                         | "Tipo inválido" en consola                  |
| 15 | Ingresar texto donde se espera número | Capacidad: abc               | Mensaje de reingreso: "Ingrese un número válido" |
