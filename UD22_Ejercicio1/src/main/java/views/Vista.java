package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

public class Vista extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public Vista() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCrearConexion = new JButton("Crear Conexion");
		btnCrearConexion.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnCrearConexion.setBounds(64, 36, 138, 35);
		contentPane.add(btnCrearConexion);
		
		JButton btnCerrarConexion = new JButton("Cerrar Conexion");
		btnCerrarConexion.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnCerrarConexion.setBounds(262, 40, 138, 35);
		contentPane.add(btnCerrarConexion);
		
		JButton btnCrearBaseDatos = new JButton("Crear Base de Datos + tabla");
		btnCrearBaseDatos.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnCrearBaseDatos.setBounds(459, 40, 228, 35);
		contentPane.add(btnCrearBaseDatos);
		
		JLabel lblNewLabel = new JLabel("Introducir elementos");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabel.setBounds(64, 141, 138, 35);
		contentPane.add(lblNewLabel);
	}
}
