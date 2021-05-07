package pokedexLite;

import java.util.List;
import java.util.ArrayList;

public class Pokemon {
	private String nombre;
	private List<String> tipos;
	private Integer nivel;
	private List<Habilidad> habilidades;
	private List<Evolucion> evoluciones;
	
	/*Constructor*/
	public Pokemon(String nombre, Integer nivel) {
		this.nombre = nombre;
		this.tipos = new ArrayList<String>();
		this.nivel = nivel;
		this.evoluciones = new ArrayList<Evolucion>();
		this.habilidades = new ArrayList<Habilidad>();
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	public void eliminarTipo(String tipo) {
	/*elimina el tipo "tipo" de la lista de tipos.*/
		this.tipos.remove(tipo);
	}
	
	public Integer getNivel() {
		return nivel;
	}
	
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	
	public List<Evolucion> getEvoluciones() {
		return evoluciones;
	}
	
	public void agregarEvolucion(Evolucion evolucion) {
	/*agrega la evolucion "evolucion" a la lista de evoluciones.*/
		this.evoluciones.add(evolucion);
	}
	
	public List<Habilidad> getHabilidades() {
		return habilidades;
	}
	
	public void setHabilidades(List<Habilidad> habilidades) {
		this.habilidades = habilidades;
	}
	 
}
