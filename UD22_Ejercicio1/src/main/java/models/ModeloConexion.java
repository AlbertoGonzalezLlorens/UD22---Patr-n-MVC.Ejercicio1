package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class ModeloConexion {

	// ---------------------------------------------------Crear Conexion
	// BBDD-----------------------------------------------------------------------------------------
	public Connection createConexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://192.168.1.105:3306?useTimezone=true&serverTimezone=UTC", "remote",
					"Ivan7442@");
			JOptionPane.showMessageDialog(null,"Servidor conectado");
			return conexion;
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("No se ha podido conectar con mi base de datos");
			System.out.println(ex);
			return null;
		}
	}

	// -----------------------------------------------Cerrar Conexion
	// BBDD--------------------------------------------------------------------------------------------
	public void closeConnection(Connection conexion) {
		try {
			conexion.close();
			JOptionPane.showMessageDialog(null, "Se ha finalizado al conexión con el servidor");
		} catch (SQLException ex) {
			Logger.getLogger(ModeloConexion.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// -------------------------------------------------CREAR
	// BBDD----------------------------------------------------------------------------------------------------
	public void createDB(Connection conexion, String name) {
		try {
			String Query = "DROP DATABASE IF EXISTS " + name;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			Query = "CREATE DATABASE " + name;
			st = conexion.createStatement();
			st.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Se ha creado la base de datos " + name + " de forma exitosa");
		} catch (SQLException ex) {
			Logger.getLogger(ModeloConexion.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// ---------------------------------------------------MOSTRAR
	// BBDD-------------------------------------------------------------------------------------------------

	public void showDB(Connection conexion, String name) {
		try {
			String Query = "SHOW DATABASE " + name;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
		} catch (SQLException ex) {
			Logger.getLogger(ModeloConexion.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// -------------------------------------------------CREAR
	// TABLAS---------------------------------------------------------------------
	public void createTable(Connection conexion, String db, String name) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "CREATE TABLE " + name+"(id INT(11) PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(250) DEFAULT NULL, apellido VARCHAR(250) DEFAULT NULL, direccion VARCHAR(250) DEFAULT NULL, dni INT(11) DEFAULT NULL, fecha DATE DEFAULT NULL)";

			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Tabla creada");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla.");
		}

	}

	// --------------------------------------------------INTRODUCIR
	// DATOS---------------------------------------------------------------------------------------------
	public void insertData(Connection conexion, String db, String table_name, String name, String lastname,
			String direccion, int dni, String fecha) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "INSERT INTO " + table_name + "  (nombre, apellido, direccion, dni, fecha) VALUE(" + "\""
					+ name + "\", " + "\"" + lastname + "\", " + "\"" + direccion + "\", " + "\"" + dni + "\", " + "\""
					+ fecha + "\");";

			Statement st = conexion.createStatement();
			st.executeUpdate(Query);

			JOptionPane.showMessageDialog(null, "Datos almacenados correctamente");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}

	// -------------------------------------------------VER
	// DATOS----------------------------------------------------------------------------------------------------
	public String getValues(Connection conexion, String db, String table_name) {
		String values = "";
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);

			while (resultSet.next()) {
				values+=("{\nid: " + resultSet.getString("id") + "\n" + "nombre: " + resultSet.getString("nombre")
						+ "\n" + "apellido: " + resultSet.getString("apellido") + "\n" + "direccion: "
						+ resultSet.getString("direccion") + "\n" + "dni: " + resultSet.getString("dni") + "\n"
						+ "fecha: " + resultSet.getString("fecha")+"\n}\n\n");
			}
			

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
		}
		return values;
	}

	// -------------------------------------------------MODIFICAR
	// REGISTROS-----------------------------------------------------------------------------------------
	public void updateRecord(Connection conexion, String db, String table_name, String comando) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "UPDATE " + table_name + " SET " + comando;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Se ha updeteado el registro correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al updetear el registro especificado");
		}
	}

	// -------------------------------------------------CONSULTAR
	// REGISTROS-----------------------------------------------------------------------------------------
	public void consulta(Connection conexion, String db, String comando) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT " + comando;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al updetear el registro especificado");
		}
	}

	// -------------------------------------------------ELIMINAR
	// REGISTROS-------------------------------------------------------------------------------------------
	public void deleteRecord(Connection conexion, String db, String table_name, String ID) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "DELETE FROM " + table_name + " WHERE ID = \"" + ID + "\"";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Se ha eliminado el registro correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
		}
	}
}
