package pokedexLite;

import java.util.List;
import java.util.ArrayList;

public class Evolucion {
	private String nombre;
	private List<Tipo> tipos;
	private Integer nivel;
	private List<Habilidad> habilidades;
	
	/*Constructor*/
	public Evolucion(String nombre, Integer nivel) {
		this.nombre = nombre;
		this.tipos = new ArrayList<Tipo>();
		this.nivel = nivel;
		this.habilidades = new ArrayList<Habilidad>();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public List<Tipo> getTipos() {
		return tipos;
	}
	
	public void setTipos(List<Tipo> tipos) {
		this.tipos = tipos;
	}
	
//	public void agregarTipo(String tipo) {
		/*agrega el tipo "tipo" a la lista de tipos.*/
//			this.tipos.add(tipo);
//		}
	
	public Integer getNivel() {
		return nivel;
	}
	
	public List<Habilidad> getHabilidades(){
		return habilidades;
	}
	
	public void setHabilidades(List<Habilidad> habilidades){
		this.habilidades = habilidades;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("*EVOLUCION " + getNombre().toUpperCase()+"*\n");
		str.append("Tipos:" + getTipos()+"\n");
		str.append("Nivel:" + getNivel()+"\n");
		str.append("Habilidades:" + getHabilidades()+"\n");
		return str.toString();
	}
}
