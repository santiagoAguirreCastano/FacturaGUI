package vista.gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.Coordinador;
import modelo.operaciones.Procesos;
import modelo.vo.ProductosVO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VentanaOperaciones extends JFrame implements ActionListener {

	private JPanel panelPrincipal;
	private JTextField txtNombre;
	private JTextField txtNota1;
	private JTextField txtNota2;

	private JButton btnCalcular;
	private JLabel lblResPromedio,lblResultado;
	
	
	private Coordinador miCoordinador;
	
	private JButton btnImprimirTotal;
	private JButton btnConsultarestudiante;
	private JTextField txtDocumento;
	private JButton btnConsultarLista;

	public VentanaOperaciones() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(486, 531);
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
		
		JLabel lblTitulo = new JLabel("FACTURA DE PRODUCTO");
		lblTitulo.setBackground(Color.green);
		lblTitulo.setForeground(Color.white);
		lblTitulo.setOpaque(true);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitulo.setBounds(0, 0, 477, 50);
		panelPrincipal.add(lblTitulo);
		
		JLabel lblNombre = new JLabel("Nombre del producto");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(31, 50, 200, 23);
		panelPrincipal.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(31, 80, 200, 39);
		panelPrincipal.add(txtNombre);
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNombre.setColumns(10);
		
		JLabel lblNota1 = new JLabel("Precio del producto");
		lblNota1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota1.setBounds(31, 135, 200, 39);
		panelPrincipal.add(lblNota1);
		
		txtNota1 = new JTextField();
		txtNota1.setColumns(10);
		txtNota1.setBounds(31, 170, 200, 39);
		txtNota1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPrincipal.add(txtNota1);
		
		lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblResultado.setBounds(31, 300, 300, 23);
		panelPrincipal.add(lblResultado);
		
		JLabel lblNota2 = new JLabel("Cantidad del producto");
		lblNota2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota2.setBounds(260, 135, 200, 23);
		panelPrincipal.add(lblNota2);
		
		txtNota2 = new JTextField();
		txtNota2.setColumns(10);
		txtNota2.setBounds(260, 170, 190, 39);
		txtNota2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPrincipal.add(txtNota2);
		
		
		JLabel lblPromedio = new JLabel("Total:");
		lblPromedio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPromedio.setBounds(31, 270, 127, 23);
		panelPrincipal.add(lblPromedio);
		
		lblResPromedio = new JLabel("");
		lblResPromedio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblResPromedio.setBounds(90, 265, 271, 31);
		panelPrincipal.add(lblResPromedio);
		
		
		
		btnCalcular = new JButton();
		btnCalcular.setText("Calcular");
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN,15));
		btnCalcular.setBounds(180, 220, 117, 31);
		btnCalcular.addActionListener(this);
		panelPrincipal.add(btnCalcular);
		
		btnImprimirTotal = new JButton();
		btnImprimirTotal.setText("Imprimir total");
		btnImprimirTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnImprimirTotal.setBounds(28, 365, 136, 31);
		btnImprimirTotal.addActionListener(this);
		panelPrincipal.add(btnImprimirTotal);
		
		btnConsultarestudiante = new JButton();
		btnConsultarestudiante.setText("Consultar");
		btnConsultarestudiante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultarestudiante.setBounds(327, 365, 100, 31);
		btnConsultarestudiante.addActionListener(this);
		panelPrincipal.add(btnConsultarestudiante);
		
		txtDocumento = new JTextField();
		txtDocumento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(260, 80, 190, 39);
		panelPrincipal.add(txtDocumento);
		
		JLabel lblDoc = new JLabel("ID del Producto: ");
		lblDoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDoc.setBounds(260, 50, 190, 23);
		panelPrincipal.add(lblDoc);
		
		btnConsultarLista = new JButton();
		btnConsultarLista.setText("Consulta Total");
		btnConsultarLista.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultarLista.setBounds(181, 365, 136, 31);
		btnConsultarLista.addActionListener(this);
		panelPrincipal.add(btnConsultarLista);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnCalcular) {
			calcularPromedio();	
			txtNota1.setText("");
			txtNota2.setText("");
			
		}
		else if (e.getSource()==btnImprimirTotal) {
			miCoordinador.mostrarVentanaConsultaGeneral();
		}
		else if (e.getSource()==btnConsultarestudiante) {
			miCoordinador.mostrarConsultarProductos();
		}
		else if (e.getSource()==btnConsultarLista) {
			miCoordinador.mostrarVentanaConsultaProductos();
		}
	}

	private void calcularPromedio() {
		
		ProductosVO producto=new ProductosVO();
		
		producto.setNombreProducto(txtNombre.getText());
		producto.setIdProducto(txtDocumento.getText());
		
		try {
			producto.setPrecioProducto(Double.parseDouble(txtNota1.getText()));
			producto.setCantidad(Double.parseDouble(txtNota2.getText()));
			
			
			//double promedio=misProcesos.calcularPromedio(estudiante);
			miCoordinador.calcularPrecio(producto.getPrecioProducto(), producto.getCantidad());
			
			producto.setTotal(miCoordinador.calcularPrecio(producto));
			
			lblResPromedio.setText(producto.getTotal()+"");
			
			String resultado=miCoordinador.calcularDefinitiva(producto.getTotal());
			
			String registro=miCoordinador.registrarEnBD(producto);
			
			if (registro.equals("ok")) {
				if (resultado.equals("Exito")) {
					lblResultado.setText("Su cuenta total es de: "+producto.getTotal()+"$");
					lblResultado.setForeground(Color.GREEN);
				}
			}else {
				JOptionPane.showMessageDialog(null, "NO SE PUDO REGISTRAR",
						"ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
			}

			
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Error de ingreso de texto",
					"ERROR",JOptionPane.ERROR_MESSAGE);
			System.out.println(e.getMessage());
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Ocurre un error",
					"ERROR",JOptionPane.ERROR_MESSAGE);
			System.out.println("ESTE ES EL ERROR= "+e.getMessage());
			e.printStackTrace();
		}		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
}