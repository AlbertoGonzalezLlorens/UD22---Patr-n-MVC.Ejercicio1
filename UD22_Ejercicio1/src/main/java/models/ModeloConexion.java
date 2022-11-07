package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import mysql_functions.Functions;

public class ModeloConexion {

	//---------------------------------------------------Crear Conexion BBDD-----------------------------------------------------------------------------------------
			public Connection createConexion() {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conexion=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306?useTimezone=true&serverTimezone=UTC","remote","Introducir contraseña");
					System.out.println("Server Connected");
					return conexion;
				}catch(SQLException | ClassNotFoundException ex) {
					System.out.println("No se ha podido conectar con mi base de datos");
					System.out.println(ex);
					return null;
				}
			}
			
	//-----------------------------------------------Cerrar Conexion BBDD--------------------------------------------------------------------------------------------
			public void closeConnection(Connection conexion) {
				try {
					conexion.close();
					JOptionPane.showMessageDialog(null,"Se ha finalizado al conexión con el servidor");
				}catch(SQLException ex) {
					Logger.getLogger(ModeloConexion.class.getName()).log(Level.SEVERE,null,ex);
				}
			}
	
	//-------------------------------------------------CREAR BBDD----------------------------------------------------------------------------------------------------
			public void createDB(Connection conexion,String name) {
				try {
					String Query = "CREATE DATABASE "+name;
					Statement st = conexion.createStatement();
					st.executeUpdate(Query);
					JOptionPane.showMessageDialog(null, "Se ha creado la base de datos "+name+" de forma exitosa");			
				}catch(SQLException ex) {
					Logger.getLogger(ModeloConexion.class.getName()).log(Level.SEVERE,null,ex);
				}
			}
			
	//---------------------------------------------------MOSTRAR BBDD-------------------------------------------------------------------------------------------------
	
			public void showDB(Connection conexion,String name) {
				try {
					String Query = "SHOW DATABASE "+name;
					Statement st = conexion.createStatement();
					st.executeUpdate(Query);		
				}catch(SQLException ex) {
					Logger.getLogger(ModeloConexion.class.getName()).log(Level.SEVERE,null,ex);
				}
			}
			
			
	//-------------------------------------------------CREAR TABLAS---------------------------------------------------------------------
			public static void createTable(Connection conexion,String db, String name) {
				try {
					String Querydb = "USE " +db+";";
					Statement stdb= conexion.createStatement();
					stdb.executeUpdate(Querydb);
					
					String Query = "CREATE TABLE " + name+"(id INT PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(250) DEFAULT NULL, apellido VARCHAR(250), Edad VARCHAR(3), Sexo VARCHAR(1))";
					Statement st = conexion.createStatement();
					st.executeUpdate(Query);
					System.out.println("Tabla creada");
					}catch(SQLException ex) {
					System.out.println(ex.getMessage());
					System.out.println("Error creando tabla.");
				}
				
			}
	
	
}
