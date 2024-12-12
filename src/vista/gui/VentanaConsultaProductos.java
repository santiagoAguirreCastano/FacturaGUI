package vista.gui;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.Coordinador;
import modelo.operaciones.Procesos;
import modelo.vo.ProductosVO;


public class VentanaConsultaProductos extends JFrame {

	private JPanel panelPrincipal;
	private JTable tablaPersonas;
	DefaultTableModel modelo;
	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	
	public VentanaConsultaProductos() {
		setSize(507, 343);
		setTitle("CALCULO DE PROMEDIO");
		setLocationRelativeTo(null);
		setResizable(false);
		iniciarComponentes();
		
	}
	
	private void iniciarComponentes(){
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JLabel lblTitulo = new JLabel("MOSTRAR PERSONAS");
		lblTitulo.setBackground(Color.green);
		lblTitulo.setForeground(Color.white);
		lblTitulo.setOpaque(true);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitulo.setBounds(0, 0, 499, 50);
		panelPrincipal.add(lblTitulo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 473, 236);
		panelPrincipal.add(scrollPane);
		
		tablaPersonas = new JTable();
		

		
		scrollPane.setViewportView(tablaPersonas);

	}

	private void crearModelo() {
		
		modelo=new DefaultTableModel();
		modelo.addColumn("ID del producto");
		modelo.addColumn("Nombre del Producto");
		modelo.addColumn("Precio");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Total");
		
		tablaPersonas.setModel(modelo);
	}

	public void llenarTabla() {
		ArrayList<ProductosVO> listaProductos=miCoordinador.getListaProducto();
		
		crearModelo();
		
		for (ProductosVO p: listaProductos) {
			Object[] fila=new Object[5];
			fila[0]=p.getIdProducto();
			fila[1]=p.getNombreProducto();
			fila[2]=p.getPrecioProducto();
			fila[3]=p.getCantidad();
			fila[4]=p.getTotal();
			modelo.addRow(fila);
		}
	}
	

}









