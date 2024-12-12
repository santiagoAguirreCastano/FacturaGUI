package vista.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.operaciones.Procesos;
import modelo.vo.ProductosVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaConsulta extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JTextField txtDoc;
	private JButton btnConsultar;
	private Coordinador miCoordinador;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JLabel lblResultado;
	private JLabel lblResPromedio;
	private JLabel lblResActualizacion;


	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	
	/**
	 * Create the frame.
	 */
	public VentanaConsulta() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(491, 426);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(null);
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPrincipal.setBounds(0, 0, 477, 379);
		getContentPane().add(panelPrincipal);
		
		JLabel lblConsultar = new JLabel("CONSULTAR");
		lblConsultar.setOpaque(true);
		lblConsultar.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultar.setForeground(Color.WHITE);
		lblConsultar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblConsultar.setBackground(Color.green);
		lblConsultar.setBounds(0, 0, 477, 50);
		panelPrincipal.add(lblConsultar);
		
		JLabel lblNombre = new JLabel("Nombre del Producto:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(31, 104, 200, 23);
		panelPrincipal.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNombre.setColumns(10);
		txtNombre.setBounds(180, 98, 250, 39);
		panelPrincipal.add(txtNombre);
		
		JLabel lblNota1 = new JLabel("Precio del Producto:");
		lblNota1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota1.setBounds(31, 140, 200, 23);
		panelPrincipal.add(lblNota1);
		
		txtNota1 = new JTextField();
		txtNota1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNota1.setColumns(10);
		txtNota1.setBounds(31, 170, 180, 39);
		panelPrincipal.add(txtNota1);
		
		JLabel lblNota2 = new JLabel("Cantidad del Producto:");
		lblNota2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota2.setBounds(240, 140, 200, 23);
		panelPrincipal.add(lblNota2);
		
		txtNota2 = new JTextField();
		txtNota2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNota2.setColumns(10);
		txtNota2.setBounds(240, 170, 190, 39);
		panelPrincipal.add(txtNota2);
		
		
		
		JLabel lblPromedio = new JLabel("Total:");
		lblPromedio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPromedio.setBounds(31, 220, 127, 23);
		panelPrincipal.add(lblPromedio);
		
		lblResPromedio = new JLabel("");
		lblResPromedio.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblResPromedio.setBounds(100, 220, 271, 31);
		panelPrincipal.add(lblResPromedio);
		
		lblResultado = new JLabel("Resultado");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblResultado.setBounds(31, 237, 396, 31);
		panelPrincipal.add(lblResultado);
		
		btnConsultar = new JButton();
		btnConsultar.setText("...");
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConsultar.setBounds(364, 60, 63, 31);
		btnConsultar.addActionListener(this);
		panelPrincipal.add(btnConsultar);
		
		JLabel lblDoc = new JLabel("ID del Producto");
		lblDoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDoc.setBounds(195, 62, 200, 23);
		panelPrincipal.add(lblDoc);
		
		txtDoc = new JTextField();
		txtDoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDoc.setColumns(10);
		txtDoc.setBounds(300, 60, 63, 31);
		panelPrincipal.add(txtDoc);
		
		btnActualizar = new JButton();
		btnActualizar.setText("Actualizar");
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnActualizar.setBounds(31, 278, 184, 31);
		btnActualizar.addActionListener(this);
		panelPrincipal.add(btnActualizar);
		
		btnEliminar = new JButton();
		btnEliminar.setText("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminar.setBounds(243, 278, 184, 31);
		btnEliminar.addActionListener(this);
		panelPrincipal.add(btnEliminar);
		
		lblResActualizacion = new JLabel("");
		lblResActualizacion.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblResActualizacion.setBounds(31, 325, 396, 31);
		panelPrincipal.add(lblResActualizacion);
		
	}


	public void iniciarComponentes() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnConsultar) {
			lblResActualizacion.setText("");
			ProductosVO miProducto=miCoordinador.obtenerProducto(txtDoc.getText());
			if (miProducto!=null) {
				txtNombre.setText(miProducto.getNombreProducto());
				txtNota1.setText(miProducto.getPrecioProducto()+"");
				txtNota2.setText(miProducto.getCantidad()+"");
				lblResPromedio.setText(miProducto.getTotal()+"");
				
			
				
			}else {
				JOptionPane.showMessageDialog(null, "El Estudiante NO existe");
			}
		}
		else if (e.getSource()==btnActualizar) {
			ProductosVO miProducto=new ProductosVO();
			miProducto.setIdProducto(txtDoc.getText());
			miProducto.setNombreProducto(txtNombre.getText());
			miProducto.setPrecioProducto(Double.parseDouble(txtNota1.getText()));
			miProducto.setCantidad(Double.parseDouble(txtNota2.getText()));
			miProducto.setTotal(miCoordinador.calcularPrecio(miProducto));
			
			String res=miCoordinador.actualizarProducto(miProducto);
			
			if (res.equals("ok")) {
				lblResActualizacion.setText("Se ha actualizado correctamente");
				lblResPromedio.setText(miProducto.getTotal()+"");
				lblResultado.setText("");
			}else {
				lblResActualizacion.setText("No se pudo actualizar");
			}
		}
		else if (e.getSource()==btnEliminar) { 
			String documento=txtDoc.getText();
			String res=miCoordinador.eliminarProducto(documento);
			
			if (res.equals("ok")) {
				limpiarCampos();
				lblResActualizacion.setText("Se ha eliminado correctamente");
			}else {
				lblResActualizacion.setText("No se pudo eliminar");
			}
		}
	}

	public void limpiarCampos() {
		txtDoc.setText("");
		txtNombre.setText("");
		txtNota1.setText("");
		txtNota2.setText("");
		lblResPromedio.setText("");
		lblResultado.setText("");
		lblResActualizacion.setText("");
	}
}