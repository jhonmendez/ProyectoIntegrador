/**
 * Clase: Principal.java
 *
 * @version: 0.1
 *
 * Fecha de Creación: 27/02/2020
 *
 * Fecha de modificación: 
 *
 * @author: 92531165
 *
 * Copyright: CECAR
 *
 */


package edu.cecar.vista;

import edu.cecar.componentesReutilizables.ConectarMySQL;
import edu.cecar.controlador.ControladorPaisDAO;
import edu.cecar.controlador.ControladorScraping;
import edu.cecar.modelo.Pais;

/**
 *
 * Clase Principal: Esta clase actuara como clase para probar las funcionalidad
 * 
 * OJO: No voy hacer la vista. Este la realizare con GUI mas adelante en el curso.
 */

public class Principal {

	public static void main(String[] args) {

		
		try {
			
			/*
			 * Se realiza la conexion a la base datos
			 * Configure los parametros segun sus especificaciones
			 */
			ConectarMySQL.getConectarMySQL("127.0.0.1", "proyectointegrador", "root", "");

			System.out.println("Iniciando Scrapeo\n\n");
			
			//Se procede a scrapear la pagina
			ControladorScraping controladorScraping = new ControladorScraping();
			
			//Se inicia el controlador DAO para los paises
			ControladorPaisDAO controladorPaisDAO = new ControladorPaisDAO();

			System.out.println("Insertando datos scrapeados en la de la base datos\n\n");
			
			//Se recorren los datos scrapeados
			for (Pais pais : controladorScraping.getpaises()) {

				controladorPaisDAO.guardar(pais);
				
			}

			System.out.println("Datos de la base de datos");
			
			//Se visualizan los datos insertado
			for (Pais pais : controladorPaisDAO.listar()) {
				
				System.out.println(pais);
				
			}

		} catch (Exception e) {
		
			e.printStackTrace();
			
		} 

	}

}


