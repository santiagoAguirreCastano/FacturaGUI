package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.Coordinador;
import modelo.conexion.Conexion;
import modelo.vo.ProductosVO;


public class ProductosDAO{
	private Coordinador miCoordinador;
	
	Connection connection = null;
	Conexion conexion = null;
	PreparedStatement preStatement = null;
	
	private String conectar() {
		conexion = new Conexion();
		String resultado=conexion.conectar();
		if (resultado.equals("conectado")) {
			connection = conexion.getConnection();
		}else {
			JOptionPane.showMessageDialog(null, resultado,"Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return resultado;
	}

	public String registrarEstudiante(ProductosVO producto) throws SQLException {
		
		String resultado = "";
		
		if (!conectar().equals("conectado")) {
			return "error";
		}

		String consulta = "INSERT INTO producto (id_producto,nombre_producto,precio,cantidad,total)"
				+ "  VALUES (?,?,?,?,?)";

		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, producto.getIdProducto());
			preStatement.setString(2, producto.getNombreProducto());
			preStatement.setDouble(3,producto.getPrecioProducto());
			preStatement.setDouble(4,producto.getCantidad());
			preStatement.setDouble(5,producto.getTotal());
			preStatement.execute();

			resultado = "ok";
		
		}catch (SQLException e) {
			System.out.println("No se pudo registrar el estudiante, verifique que el documento no exista: " + e.getMessage());
			//e.printStackTrace();
			resultado = "error";
		}
		catch (Exception e) {
			System.out.println("No se pudo registrar el estudiante: " + e.getMessage());
			//e.printStackTrace();
			resultado = "error";
		}
		finally {
			preStatement.close();
			connection.close();
			conexion.desconectar();
		}
		return resultado;
	}
	

	public ProductosVO consultarProducto(String idProducto) throws SQLException {
		ProductosVO producto1=null;
		
		if (!conectar().equals("conectado")) {
			return producto1;
		}
		
		ResultSet result=null;
	
		String consulta="SELECT id_producto,nombre_producto,precio,cantidad,total"
				+ " FROM producto where id_producto= ? ";
		
		try {
			preStatement=connection.prepareStatement(consulta);
			preStatement.setString(1, idProducto);
				
			result=preStatement.executeQuery();
				
			if(result.next()){
				producto1=new ProductosVO();
				producto1.setIdProducto(result.getString("id_producto"));
				producto1.setNombreProducto(result.getString("nombre_producto"));
				producto1.setPrecioProducto(result.getDouble("precio"));
				producto1.setCantidad(result.getDouble("cantidad"));
				producto1.setTotal(result.getDouble("total"));
			}		
			   
		} catch (SQLException e) {
			System.out.println("Error en la consulta de la persona: "+e.getMessage());
		}finally {
			result.close();
			preStatement.close();
			connection.close();
			conexion.desconectar();
		}
		return producto1;
	}
	
	public ArrayList<ProductosVO> consultarListaProductos() throws SQLException {
		ArrayList<ProductosVO> listaProductos=new ArrayList<ProductosVO>();
		
		if (!conectar().equals("conectado")) {
			return listaProductos;
		}
		
		ResultSet result=null;
		ProductosVO producto1=null;
		
		String consulta="SELECT id_producto,nombre_producto,precio,cantidad,total"
				+ " FROM producto ";
		
		try {
			preStatement=connection.prepareStatement(consulta);
				
			result=preStatement.executeQuery();
				
			while(result.next()==true){
				producto1=new ProductosVO();
				producto1.setIdProducto(result.getString("id_producto"));
				producto1.setNombreProducto(result.getString("nombre_producto"));
				producto1.setPrecioProducto(result.getDouble("precio"));
				producto1.setCantidad(result.getDouble("cantidad"));
				producto1.setTotal(result.getDouble("total"));
				listaProductos.add(producto1);
			}		
			   
		} catch (SQLException e) {
			System.out.println("Error en la consulta de personas: "+e.getMessage());
		}finally {
			result.close();
			preStatement.close();
			connection.close();
			conexion.desconectar();
		}
			return listaProductos;
	}
	
	
	public String actualizarProducto(ProductosVO productoVO) throws SQLException {
		String resultado="";

		if (!conectar().equals("conectado")) {
			return "error";
		}

		try{
			String consulta="UPDATE producto "
					+ "SET nombre_producto = ? , "
					+ "precio= ? , "
					+ "cantidad= ? , "
					+ "total= ? "
					+ "WHERE id_producto= ?;";
			preStatement = connection.prepareStatement(consulta);

			
			preStatement.setString(1, productoVO.getNombreProducto());
			preStatement.setDouble(2, productoVO.getPrecioProducto());
			preStatement.setDouble(3, productoVO.getCantidad());
			preStatement.setDouble(4, productoVO.getTotal());
			preStatement.setString(5, productoVO.getIdProducto());
			preStatement.executeUpdate();
			
          resultado="ok";
          
        }catch(SQLException	 e){
            System.out.println("Ocurrió una excepcion de SQL "
            		+ "al momento de actualizar: "+e);
            resultado="error";
        }finally {
			preStatement.close();
			connection.close();
			conexion.desconectar();
		}
		return resultado;
	}

	public String eliminarProducto(String idProducto) throws SQLException {
		
		String respuesta="";
		
		if (!conectar().equals("conectado")) {
			return "error";
		}
		
		try {
			String sentencia="DELETE FROM producto WHERE id_producto= ? ";

			PreparedStatement statement = connection.prepareStatement(sentencia);
			statement.setString(1, idProducto);
			
			statement.executeUpdate();
						
			respuesta="ok";
			
		} catch (SQLException e) {
            System.out.println("Ocurrió una excepcion de SQL "
            		+ "al momento de eliminar "+e);
			respuesta="error";
		}finally {
			preStatement.close();
			connection.close();
			conexion.desconectar();
		}
		return respuesta;
	}
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}

}