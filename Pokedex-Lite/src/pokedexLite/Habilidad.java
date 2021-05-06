package pokedexLite;

public class Habilidad {
	private String nombre;
	private Integer danio;
	
	public Habilidad(String nombre, Integer danio) {
		this.nombre = nombre;
		this.danio = danio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDanio() {
		return danio;
	}

	public void setDanio(Integer danio) {
		this.danio = danio;
	}
	
	
}
