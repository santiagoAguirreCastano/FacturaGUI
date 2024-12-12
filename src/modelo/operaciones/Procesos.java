package modelo.operaciones;

import java.awt.Color;
import java.util.ArrayList;

import controlador.Coordinador;

import modelo.vo.ProductosVO;

public class Procesos {

	ArrayList<ProductosVO> listaProductos;
	String mensje;
	private Coordinador miCoordinador;
	
	public Procesos() {
		listaProductos=new ArrayList<ProductosVO>();
	}
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	
	public double calcularPrecio(double precio,double cantidad) {
		
		double total=precio*cantidad;
		
		return total;
		
	}
	public String calcularDefinitiva(double total) {

		return "Exito";
	}
	

	public double calcularPrecio(ProductosVO producto) {

		double total=producto.getPrecioProducto()*producto.getCantidad();
		System.out.println(total);
		total=Math.round(total*100.0)/100.0;	
		return total;
	}

	public void registrarEnBD(ProductosVO producto) {
		int bandera=0;
		if (listaProductos.size()>0) 
		{			
			for (ProductosVO producto1 : listaProductos) {
				if (producto1.getIdProducto().equals(producto1.getIdProducto())) {
					bandera=1;
					break;
				}
			}
			
			if (bandera==0) {
				System.out.println("Se registra en la BD");
				listaProductos.add(producto);
			}else {
				System.out.println("La persona ya existe!");
			}
			
		}else {
			System.out.println("Se registra en la BD");
			listaProductos.add(producto);
		}
	}

	public void imprimirListaProductos() {
		for (ProductosVO producto1 : listaProductos) {
			System.out.println(producto1);
		}
	}
	
	public ArrayList<ProductosVO> getListaPersonas(){
		return listaProductos;
	}

	public ProductosVO obtenerProducto(String doc) {
		ProductosVO p=null;
		for (ProductosVO producto1 : listaProductos) {
			if (producto1.getIdProducto().equals(doc)) {
				p= producto1;
			}
	
		}
		return p;
		
	}
	
}