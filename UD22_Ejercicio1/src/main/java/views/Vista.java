package views;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Vista extends JFrame {

	private JPanel contentPane;
	public JButton btnCrearConexion, btnCerrarConexion, btnCrearBaseDatos;
	public JLabel lblVerElementos;
	public JButton btnVerelementos;
	public JScrollPane scrollPane;
	public JTextField txtNombre;
	public JTextField txtApellido;
	public JTextField txtDireccion;
	public JTextField txtDni;
	public JTextField txtFecha;
	public JLabel lblNewLabel;
	public JLabel lblApellido;
	public JLabel lblDireccion;
	public JLabel lblDni;
	public JLabel lblFecha;
	public JButton btnInsertarValores;
	public JTextPane textPane;
	public JTextField txtConsulta;
	public JButton btnConsulta;
	public JLabel lblEliminarConsulta;
	public JTextField txtEliminar;
	public JButton btnEliminar;
	

	/**
	 * Create the frame.
	 */
	public Vista() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCrearConexion = new JButton("Crear Conexion");
		btnCrearConexion.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnCrearConexion.setBounds(64, 40, 138, 35);
		contentPane.add(btnCrearConexion);
		
		btnCerrarConexion = new JButton("Cerrar Conexion");
		btnCerrarConexion.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnCerrarConexion.setBounds(601, 40, 138, 35);
		contentPane.add(btnCerrarConexion);
		
		btnCrearBaseDatos = new JButton("Crear Base de Datos + tabla");
		btnCrearBaseDatos.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnCrearBaseDatos.setBounds(277, 40, 228, 35);
		contentPane.add(btnCrearBaseDatos);
		
		lblVerElementos = new JLabel("Insertar elementos");
		lblVerElementos.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblVerElementos.setBounds(506, 118, 138, 35);
		contentPane.add(lblVerElementos);
		
		btnVerelementos = new JButton("Ver Elementos");
		btnVerelementos.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnVerelementos.setBounds(64, 118, 138, 35);
		contentPane.add(btnVerelementos);
		
		textPane = new JTextPane();
		
		scrollPane = new JScrollPane(textPane);
		scrollPane.setBounds(64, 164, 336, 386);
		contentPane.add(scrollPane);
		
		txtNombre = new JTextField();
		txtNombre.setToolTipText("");
		txtNombre.setBounds(601, 183, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(601, 214, 86, 20);
		contentPane.add(txtApellido);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(601, 244, 86, 20);
		contentPane.add(txtDireccion);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(601, 275, 86, 20);
		contentPane.add(txtDni);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(601, 306, 86, 20);
		contentPane.add(txtFecha);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(459, 186, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(459, 217, 46, 14);
		contentPane.add(lblApellido);
		
		lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(459, 247, 46, 14);
		contentPane.add(lblDireccion);
		
		lblDni = new JLabel("Dni");
		lblDni.setBounds(459, 278, 46, 14);
		contentPane.add(lblDni);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(459, 309, 46, 14);
		contentPane.add(lblFecha);
		
		btnInsertarValores = new JButton("Insertar Valores");
		btnInsertarValores.setBounds(506, 355, 138, 23);
		contentPane.add(btnInsertarValores);
		
		txtConsulta = new JTextField();
		txtConsulta.setToolTipText("");
		txtConsulta.setColumns(10);
		txtConsulta.setBounds(818, 183, 498, 20);
		contentPane.add(txtConsulta);
		
		JLabel lblEscribirConsulta = new JLabel("Escribir consulta");
		lblEscribirConsulta.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblEscribirConsulta.setBounds(818, 118, 138, 35);
		contentPane.add(lblEscribirConsulta);
		
		btnConsulta = new JButton("Ejecutar consulta");
		btnConsulta.setBounds(1326, 182, 142, 23);
		contentPane.add(btnConsulta);
		
		lblEliminarConsulta = new JLabel("Eliminar registro (id)");
		lblEliminarConsulta.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblEliminarConsulta.setBounds(818, 270, 138, 35);
		contentPane.add(lblEliminarConsulta);
		
		txtEliminar = new JTextField();
		txtEliminar.setBounds(818, 306, 128, 20);
		contentPane.add(txtEliminar);
		txtEliminar.setColumns(10);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(838, 337, 89, 23);
		contentPane.add(btnEliminar);
	}
}
