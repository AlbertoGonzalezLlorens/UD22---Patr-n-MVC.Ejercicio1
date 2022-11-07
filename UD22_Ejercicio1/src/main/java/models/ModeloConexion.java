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
					"jdbc:mysql://192.168.1.146:3306?useTimezone=true&serverTimezone=UTC", "remote",
					"Introducir contraseña");
			System.out.println("Server Connected");
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
			String Query = "CREATE DATABASE " + name;
			Statement st = conexion.createStatement();
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
	public static void createTable(Connection conexion, String db, String name) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "CREATE TABLE " + name
					+ "(id INT PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(250) DEFAULT NULL, apellido VARCHAR(250), Edad VARCHAR(3), Sexo VARCHAR(1))";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla.");
		}

	}

	// --------------------------------------------------INTRODUCIR
	// DATOS---------------------------------------------------------------------------------------------
	public static void insertData(Connection conexion, String db, String table_name, String name, String lastname,
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

			System.out.println("Datos almacenados correctamente");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}

	// -------------------------------------------------VER
	// DATOS----------------------------------------------------------------------------------------------------
	public static void getValues(Connection conexion, String db, String table_name) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);

			while (resultSet.next()) {
				System.out.println("id: " + resultSet.getString("id") + " " + "nombre: " + resultSet.getString("nombre")
						+ " " + "apellido: " + resultSet.getString("apellido") + " " + "direccion: "
						+ resultSet.getString("direccion") + " " + "dni: " + resultSet.getString("dni") + " "
						+ "fecha: " + resultSet.getString("fecha"));
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
		}
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
