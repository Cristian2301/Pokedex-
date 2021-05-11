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
	
	public Integer getNivel() {
		return nivel;
	}
}
