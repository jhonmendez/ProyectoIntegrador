/**
  * Clase: InterfazDAO.java
   *
   * @version: 0.1
   *
   * Fecha de Creación: 4/03/2020
   *
   * Fecha de modificación: 
   *
   * @author: 92531165
   *
   * Copyright: CECAR
   *
*/


package edu.cecar.interfaces;

import java.util.List;

/**
  *
  *  Interfaz generica que define las operacion CRUD sobre
  *  una tabla de una base de datos
 */

public interface InterfazDAO<T> {
	
	String guardar(T t);
    String actualizar(T t);
    T consultar(String ... criteriosBusqueda);
    String eliminar(String ... criteriosBusqueda);
    List<T> listar();
    
}


