package pokedexLite;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import java.util.Map;
import java.util.HashMap;

public class Aplicacion {
	//private List<Pokemon> pokemonsValidos;
	private List<Pokemon> pokemons;
	private Map<Pokemon, Evolucion> evolucionesValidas = new HashMap<Pokemon, Evolucion>();
	private Scanner sc = new Scanner(System.in);
	private StringBuilder str = new StringBuilder();
	
	/* Constructor */
	public Aplicacion() {
		this.pokemons = new ArrayList<Pokemon>();
	}
	
	public List<Pokemon> getPokemons(){
		return pokemons;
	}
	
	public Map<Pokemon, Evolucion> getEvolucionesValidas(){
		return evolucionesValidas;
	}
	
	
	public String mostrarPokemon() {
		System.out.println("Ingrese el nombre del pokemon que desea que se muestre:");
		String nombre = sc.next();
		
		try {
			return this.datosPokemon(this.buscarPokemon(nombre));
		}
		catch (Exception e) {
			throw new ArithmeticException("El pokemon ingresado no existe");
		}
	}
	
	
	public void agregarPokemon() {	
		System.out.println("Ingrese los datos del pokemon que desea agregar:");
		
		System.out.println("Nombre:");
		String nombre = sc.next();
		if (this.existePokemon(nombre)) {
			throw new ArithmeticException("El pokemon ingresado ya existe");
		}
		
		System.out.println("nivel:");
		Integer nivel = sc.nextInt();
		

		Pokemon pokemon = new Pokemon(nombre, nivel);

		Integer opcion = 1;
		String tipo;
		while (opcion == 1) {
			System.out.println("Tipo:");
			tipo = sc.next();
			pokemon.agregarTipo(tipo);
			System.out.println("Si desea agregar otro tipo presione 1, sino presione 2:");
			opcion = sc.nextInt();
		}
		this.getPokemons().add(pokemon);
		
	}
			
		
	public void modificarPokemon() {
		
	}
	
	
	public void eliminarPokemon() {
		
	}
		
	//	System.out.println("Desea evolucionar el pokemon? (si / no)");
	//	this.evolucionarPokemon(pokemon);
	//	System.out.println("evolucion:"+pokemon.getEvoluciones().get(0));
		//pokemonsAEncontrar.add(pokemon);
		
		

	public Boolean existePokemon(String nombre) {
		Boolean existePokemon = false;
		for (Pokemon p: this.getPokemons()) {
			existePokemon = existePokemon || p.getNombre().equals(nombre);
		}
		return existePokemon;
	}	

	public Pokemon buscarPokemon(String nombre) {
		Integer i = 0;
		while(!(this.pokemons.get(i).getNombre().equals(nombre))) {
			i++;
		}
		return pokemons.get(i);
	}
	
	public List<String> tiposDePokemon(String nombre) {
		return this.buscarPokemon(nombre).getTipos();
	}
	
	public String datosPokemon(Pokemon pokemon) {
		str.append("*POKEMON " + pokemon.getNombre().toUpperCase()+"*\n");
		str.append("Tipos:" + pokemon.getTipos()+"\n");
		str.append("Nivel:" + pokemon.getNivel()+"\n");
		str.append("Evoluciones:" + pokemon.getEvoluciones()+"\n");
		str.append("Habilidades:" + pokemon.getHabilidades()+"\n");
		return str.toString();
	}
	
/*	public void evolucionarPokemon(Pokemon pokemon) {
		pokemon.agregarEvolucion(this.
	}*/
	
}
