package pokedexLite;

import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

public class Aplicacion {
	//private List<Pokemon> pokemonsValidos;
	private List<Pokemon> pokemons;
	private List<Evolucion> evoluciones;
	private Scanner sc = new Scanner(System.in);	
	
	/* Constructor */
	public Aplicacion() {
		this.pokemons = new ArrayList<Pokemon>();
	}
	
	public List<Pokemon> getPokemons(){
		return pokemons;
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
		
/*		Boolean ingresarTipos = true;
		while (ingresarTipos) {
			System.out.println("Si desea agregar otro tipo presione 1, sino presione 2");
			opcion = sc.nextInt();
			if (opcion == 1) {
				System.out.println("Tipo:");
				tipo = sc.next();
				pokemon.agregarTipo(tipo);
			}
			else {
				ingresarTipos = false;
			}
		}*/
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
	
	public void evolucionarPokemon(Pokemon pokemon) {
		pokemon.agregarEvolucion(this.buscarPokemon(pokemon.getNombre()).getEvoluciones().get(0));
	}
	
}
