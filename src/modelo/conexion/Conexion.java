package modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import javax.management.OperationsException;
import javax.management.OperationsException;

public class Conexion {
	
	private String nombreBd="bd_productos";
	private String usuario="root";
	private String password="";
	private String url="jdbc:mysql://localhost:3306/"+nombreBd+"?useUnicode=true&use"
			+ "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
			+ "serverTimezone=UTC";

	Connection conn=null;
	
	public String conectar()  {
		String respuesta = "";
		
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn=DriverManager.getConnection(url,usuario,password);
			
			if (conn!=null) {
				respuesta="conectado";
			}else{
				respuesta="NO SE PUDO CONECTAR "+nombreBd;
			}
			
		} 	catch (ClassNotFoundException e) {
			respuesta="ocurre una ClassNotFoundException : "+e.getMessage();
		}
		catch (SQLSyntaxErrorException e) {
			respuesta="ocurre una SQLSyntaxErrorException: "+e.getMessage()+"\n";
			respuesta+="Verifique que se esté usando la base de datos y tablas correctas...";
		}
		catch (SQLException e) {
			respuesta="ocurre una SQLException: "+e.getMessage()+"\n";
			respuesta+="Este es un problema general de SQL, verifique con el administrador";
		}
		
		return respuesta;
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public void desconectar() {
		conn = null;
	}
	
	
}
