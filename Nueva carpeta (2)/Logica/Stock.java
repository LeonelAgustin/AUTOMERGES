package Logica;

public class Stock {
    private int cantidad_autos;
    private int cantidad_piezas;
    private String nombre;
    private int dir;
	public Stock(int cantidad_autos, int cantidad_piezas, String nombre,int dir) {
		this.cantidad_autos = cantidad_autos;
		this.cantidad_piezas = cantidad_piezas;
		this.nombre = nombre;
		this.dir = dir;
	}

	public int getCantidad_autos() {
		return cantidad_autos;
	}

	public int getCantidad_piezas() {
		return cantidad_piezas;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		
		switch (this.dir) {
		case 0:
			return ", nombre=" + nombre + "cantidad_piezas=" + cantidad_piezas  ;
		case 1:
			return ", nombre=" + nombre +  "cantidad_autos=" + cantidad_autos ;
		default:
		return "error";
		}
		
		
		
	}
	

}
