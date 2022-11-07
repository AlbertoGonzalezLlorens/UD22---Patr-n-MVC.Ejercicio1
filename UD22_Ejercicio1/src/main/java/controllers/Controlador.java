package controllers;

import javax.swing.JFrame;

import models.Modelo;
import views.Vista;

public class Controlador {
	
	private Modelo modelo;
	private Vista vista;

	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		
	}
	
	public void iniciarVista() {
		vista.setTitle("Vista principal");
		vista.pack();
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setLocationRelativeTo(null);
		vista.setBounds(500, 500, 800, 600);
		vista.setVisible(true);
		
	}

}
