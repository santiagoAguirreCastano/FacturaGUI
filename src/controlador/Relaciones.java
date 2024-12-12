package controlador;


import modelo.dao.ProductosDAO;
import modelo.operaciones.Procesos;
import vista.gui.VentanaConsulta;
import vista.gui.VentanaConsultaGeneral;
import vista.gui.VentanaConsultaProductos;
import vista.gui.VentanaOperaciones;

public class Relaciones {

	public void iniciar() {
		
		/**Se instancian las clases*/
		VentanaOperaciones ventanaOperaciones=new VentanaOperaciones();
		VentanaConsulta ventanaConsulta=new VentanaConsulta();
		VentanaConsultaGeneral ventanaConsultaGeneral=new VentanaConsultaGeneral();
		VentanaConsultaProductos ventanaConsultaProductos=new VentanaConsultaProductos();
		Procesos misProcesos=new Procesos();
		ProductosDAO miProductoDao=new ProductosDAO();
		Coordinador miCoordinador=new Coordinador();
		
		/**Se establecen las relaciones entre clases*/
		ventanaOperaciones.setCoordinador(miCoordinador);
		ventanaConsultaGeneral.setCoordinador(miCoordinador);
		ventanaConsultaProductos.setCoordinador(miCoordinador);
		ventanaConsulta.setCoordinador(miCoordinador);
		misProcesos.setCoordinador(miCoordinador);
		miProductoDao.setCoordinador(miCoordinador);
		
		/**Se establecen relaciones con la clase coordinador*/
		miCoordinador.setVentanaOperaciones(ventanaOperaciones);
		miCoordinador.setVentanaConsulta(ventanaConsulta);
		miCoordinador.setVentanaConsultaGeneral(ventanaConsultaGeneral);
		miCoordinador.setVentanaConsultaPersonas(ventanaConsultaProductos);
		miCoordinador.setProcesos(misProcesos);
		miCoordinador.setmiProductoDao(miProductoDao);
		
		miCoordinador.mostrarVentanaPrincipal();

	}
	
}