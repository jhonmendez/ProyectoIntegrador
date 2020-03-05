/**
 * Clase: ControladorPaisDAO.java
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


package edu.cecar.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.cecar.componentesReutilizables.ConectarMySQL;
import edu.cecar.interfaces.InterfazDAO;
import edu.cecar.modelo.Pais;

/**
 *
 * Clase que controla las operaciones CRUD sobre la tabla
 * Paises
 */

public class ControladorPaisDAO implements InterfazDAO<Pais> {

	private String nombreTabla = "paises";

	public String guardar(Pais pais) {

		String resultado = "OK";

		try {

			PreparedStatement preparedStatement
			= ConectarMySQL.getConexion().
			prepareStatement("insert into " + nombreTabla +
					" values (?,?,?)");

			preparedStatement.setString(1, pais.getNombre());
			preparedStatement.setString(2, pais.getCapital());
			preparedStatement.setString(3, pais.getContinente());
			preparedStatement.execute();


		} catch (SQLException e) {

			resultado = e.getMessage();
		}

		return resultado;

	}

	public String actualizar(Pais pais) {

		String resultado = "OK";

		try {

			PreparedStatement preparedStatement
			= ConectarMySQL.getConexion().
			prepareStatement("update " + nombreTabla +
					" set capital = ?, continente = ? " +
					" where pais = ?");

			preparedStatement.setString(1, pais.getCapital());
			preparedStatement.setString(2, pais.getContinente());
			preparedStatement.setString(3, pais.getNombre());
			preparedStatement.execute();


		} catch (SQLException e) {

			resultado = e.getMessage();
		}

		return resultado;

	}

	public Pais consultar(String... criteriosBusqueda) {

		Pais pais = null;

		try {

			PreparedStatement preparedStatement
			= ConectarMySQL.getConexion().
			prepareStatement("Select * from  " + nombreTabla +
					" where pais = ?");

			preparedStatement.setString(1, criteriosBusqueda[0]);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				pais = new Pais(resultSet.getString(1), 
						resultSet.getString(2), resultSet.getString(3));
			}


		} catch (SQLException e) {

			e.printStackTrace();
		}

		return pais;

	}

	public String eliminar(String... criteriosBusqueda) {

		String resultado = "OK";

		try {

			PreparedStatement preparedStatement
			= ConectarMySQL.getConexion().
			prepareStatement("delete  from " + nombreTabla +
					" where pais = ?");

			preparedStatement.setString(1, criteriosBusqueda[0]);
			preparedStatement.execute();


		} catch (SQLException e) {

			resultado = e.getMessage();
		}

		return resultado;

	}

	public List<Pais> listar() {

		List<Pais> paises = new ArrayList<Pais>();

		try {

			PreparedStatement preparedStatement
							= ConectarMySQL.getConexion().
							prepareStatement("Select * from " + nombreTabla);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Pais pais = new Pais(resultSet.getString(1), 
							resultSet.getString(2), resultSet.getString(3));
				
				paises.add(pais);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return paises;

	}

}


