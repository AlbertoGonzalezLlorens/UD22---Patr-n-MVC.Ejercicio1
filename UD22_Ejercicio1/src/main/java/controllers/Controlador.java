package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.sql.Connection;


import models.Modelo;
import models.ModeloConexion;
import views.Vista;

public class Controlador implements ActionListener {
	
	private Modelo modelo;
	private ModeloConexion modeloconexion;
	private Vista vista;
	private Connection conexion;

	public Controlador(Modelo modelo, ModeloConexion modeloconexion, Vista vista) {
		this.modelo = modelo;
		this.modeloconexion=modeloconexion;
		this.vista = vista;
		this.vista.btnCrearConexion.addActionListener(this);
		this.vista.btnCerrarConexion.addActionListener(this);
		this.vista.btnCrearBaseDatos.addActionListener(this);
		this.vista.btnInsertarValores.addActionListener(this);
		this.vista.btnVerelementos.addActionListener(this);
		this.vista.btnConsulta.addActionListener(this);
		this.vista.btnEliminar.addActionListener(this);

		
	}
	
	public void iniciarVista() {
		vista.setTitle("Vista principal");
		vista.pack();
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setLocationRelativeTo(null);
		vista.setBounds(500, 500, 1500, 600);
		vista.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent event) {
		if (vista.btnCrearConexion==event.getSource()) {
			this.conexion = modeloconexion.createConexion();
		}
		else if(vista.btnCerrarConexion==event.getSource()) {
			modeloconexion.closeConnection(conexion);
		}
		else if(vista.btnCrearBaseDatos==event.getSource()) {
			modeloconexion.createDB(conexion, "ejercicio1");
			modeloconexion.createTable(conexion, "ejercicio1", "cliente");
		}
		else if(vista.btnInsertarValores==event.getSource()) {
			modeloconexion.insertData(conexion, "ejercicio1", "cliente", vista.txtNombre.getText(), vista.txtApellido.getText(), 			vista.txtDireccion.getText(), Integer.parseInt(vista.txtDni.getText()), vista.txtFecha.getText());
			
		}
		else if(vista.btnVerelementos==event.getSource()) {
			vista.textPane.setText(modeloconexion.getValues(conexion, "ejercicio1", "cliente"));
		}
		else if(vista.btnConsulta==event.getSource()) {
			vista.textPane.setText(modeloconexion.consulta(conexion, "ejercicio1", vista.txtConsulta.getText()));
		}
		else if(vista.btnEliminar==event.getSource()) {
			modeloconexion.deleteRecord(conexion, "ejercicio1", "cliente", vista.txtEliminar.getText());
		}
	}

}
