package pokedexLite;

import java.util.List;
import java.util.ArrayList;

public class Evolucion {
	private String nombre;
	private List<String> tipos;
	private Integer nivel;
	
	/*Constructor*/
	public Evolucion(String nombre, Integer nivel) {
		this.nombre = nombre;
		this.tipos = new ArrayList<String>();
		this.nivel = nivel;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public List<String> getTipos() {
		return tipos;
	}
	
	public void setTipos(List<String> tipos) {
		this.tipos = tipos;
	}
	
	public void agregarTipo(String tipo) {
		/*agrega el tipo "tipo" a la lista de tipos.*/
			this.tipos.add(tipo);
		}
	
	public Integer getNivel() {
		return nivel;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("*EVOLUCION " + getNombre().toUpperCase()+"*\n");
		str.append("Tipos:" + getTipos()+"\n");
		str.append("Nivel:" + getNivel()+"\n");
		return str.toString();
	}
}
