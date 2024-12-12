package controlador;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.dao.ProductosDAO;
import modelo.operaciones.Procesos;
import modelo.vo.ProductosVO;
import vista.gui.VentanaConsulta;
import vista.gui.VentanaConsultaGeneral;
import vista.gui.VentanaConsultaProductos;
import vista.gui.VentanaOperaciones;

public class Coordinador {

	private VentanaOperaciones ventanaOperaciones;
	private VentanaConsulta ventanaConsulta;
	private VentanaConsultaGeneral ventanaConsultaGeneral;
	private VentanaConsultaProductos ventanaConsultaProductos;
	private Procesos misProcesos;
	private ProductosDAO miProductoDao;
	
	public void setVentanaOperaciones(VentanaOperaciones ventanaOperaciones) {
		this.ventanaOperaciones=ventanaOperaciones;
	}

	public void setVentanaConsulta(VentanaConsulta ventanaConsulta) {
		this.ventanaConsulta=ventanaConsulta;
	}

	public void setVentanaConsultaGeneral(VentanaConsultaGeneral ventanaConsultaGeneral) {
		this.ventanaConsultaGeneral=ventanaConsultaGeneral;
	}

	public void setVentanaConsultaPersonas(VentanaConsultaProductos ventanaConsultaProductos) {
		this.ventanaConsultaProductos=ventanaConsultaProductos;
	}

	public void setProcesos(Procesos misProcesos) {
		this.misProcesos=misProcesos;
	}
	
	public void setmiProductoDao(ProductosDAO miProductoDao) {
		this.miProductoDao=miProductoDao;
	}

	public void mostrarVentanaPrincipal() {
		ventanaOperaciones.setVisible(true);
	}

	public double calcularPrecio(double precio, double cantidad) {
		return misProcesos.calcularPrecio(precio, cantidad);
	}

	public double calcularPrecio(ProductosVO producto) {
		
		return misProcesos.calcularPrecio(producto);
	}


	public String registrarEnBD(ProductosVO producto)  {
	
		try {
			return miProductoDao.registrarEstudiante(producto);
		} catch (SQLException e) {
			//e.printStackTrace();
			return "error";
		}
	}

	public void mostrarVentanaConsultaProductos() {

		if (getListaProducto().isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay informaci�n en la lista");
		}else {
			ventanaConsultaProductos.llenarTabla();
			ventanaConsultaProductos.setVisible(true);
		}
	}

	public ArrayList<ProductosVO> getListaProducto() {
		
		//return misProcesos.getListaPersonas();
		try {
			return miProductoDao.consultarListaProductos();
		} catch (SQLException e) {
			//e.printStackTrace();
			return new ArrayList<ProductosVO>();
		}
	}

	public void mostrarConsultarProductos() {
		ventanaConsulta.limpiarCampos();
		ventanaConsulta.setVisible(true);
	}

	public void mostrarVentanaConsultaGeneral() {
		ventanaConsultaGeneral.llenarAreaTexto();
		ventanaConsultaGeneral.setVisible(true);
	}

	public ProductosVO obtenerProducto(String documento) {
		
		try {
			return miProductoDao.consultarProducto(documento);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public String calcularDefinitiva(double promedio) {
		
		return misProcesos.calcularDefinitiva(promedio);
	}
	public String actualizarProducto(ProductosVO producto)  {
		try {
			return miProductoDao.actualizarProducto(producto);
		} catch (SQLException e) {
			//e.printStackTrace();
			return "error"; 
		}
	}

	public String eliminarProducto(String documento)  {
		try {
			return miProductoDao.eliminarProducto(documento);
		} catch (SQLException e) {
			//e.printStackTrace();
			return "error"; 
		}
	}


}