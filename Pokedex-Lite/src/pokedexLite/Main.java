package pokedexLite;

import java.util.List;
import java.util.ArrayList;

public class Main {
	private Aplicacion aplicacion;
	private Pokemon pokemon1 = new Pokemon("Charmander", 2);
	private Pokemon pokemon2 = new Pokemon("Squirtle", 1);
	private Pokemon pokemon3 = new Pokemon("Bulbasaur", 4);
	private Pokemon pokemon4 = new Pokemon("Chikorita", 6);
	private Pokemon pokemon5 = new Pokemon("Cyndaquil", 5);
	private Pokemon pokemon6 = new Pokemon("Totodile", 2);
	private Pokemon pokemon8 = new Pokemon("", 2);
	private Pokemon pokemon9 = new Pokemon("", 2);
	private Pokemon pokemon10 = new Pokemon("", 2);
	private List <Evolucion> evolucionesPokemon1 = new ArrayList<Evolucion>();
	private List <Evolucion> evolucionesPokemon4 = new ArrayList<Evolucion>();
	private Evolucion evolucion1Charmander = new Evolucion("Charmeleon", 6);
	private Evolucion evolucion2Charmander = new Evolucion("Charizard", 10);
	private Evolucion evolucion1Chikorita = new Evolucion("Bayleef", 6);
	private Evolucion evolucion2Chikorita = new Evolucion("Meganium", 10);
	
	public void agregarEvolucionesValida() {
		
	}
	
	public void agregarPokemonesValidos() {
		pokemon1.agregarEvolucion(evolucion1Charmander);
		pokemon1.agregarEvolucion(evolucion2Charmander);
		aplicacion.getPokemonsValidos().add(pokemon1);
		aplicacion.getPokemonsValidos().add(pokemon2);
		aplicacion.getPokemonsValidos().add(pokemon3);
		aplicacion.getPokemonsValidos().add(pokemon4);
		aplicacion.getPokemonsValidos().add(pokemon5);
		aplicacion.getPokemonsValidos().add(pokemon6);
	}
	
	
	
}
