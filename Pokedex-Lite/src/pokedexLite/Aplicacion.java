package pokedexLite;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Aplicacion {
	private List<Pokemon> pokemonsValidos;
	private List<Pokemon> pokemonsAEncontrar;
	private Scanner sc = new Scanner(System.in);
	
	/* Constructor */
	public Aplicacion() {
		this.pokemonsValidos = new ArrayList<Pokemon>();
		this.pokemonsAEncontrar = new ArrayList<Pokemon>();
	}
	
	public List<Pokemon> getPokemonsValidos(){
		return pokemonsValidos;
	}
	
	
	public void agregarPokemon() {	
		System.out.println("Ingrese los datos del pokemon que desea agregar:");
		System.out.println("Nombre:");
		String nombre = sc.nextLine();
		System.out.println("nivel:");
		Integer nivel = sc.nextInt();
		Pokemon pokemon = new Pokemon(nombre, nivel);
		pokemon.setTipos(tiposDePokemon(pokemon.getNombre()));
		System.out.println("Desea evolucionar el pokemon? (si / no)");
		this.evolucionarPokemon(pokemon);
		System.out.println("evolucion:"+pokemon.getEvoluciones().get(0));
		//pokemonsAEncontrar.add(pokemon);
		
	/*	Boolean ingresarTipos = true;
		while (ingresarTipos) {
			System.out.println("Si desea agregar un tipo presione 1, sino presione 2");
			Integer opcion = sc.nextInt();
			if (opcion == 1) {
				System.out.println("Tipo:");
				String tipo = sc.nextLine();
			}
			else {
				ingresarTipos = false;*/
	}

	public Pokemon buscarPokemon(String nombre) {
		Integer i = 0;
		while(this.pokemonsValidos.get(i).getNombre() != nombre) {
			i++;
		}
		return pokemonsValidos.get(i);
	}
	
	public List<String> tiposDePokemon(String nombre) {
		return this.buscarPokemon(nombre).getTipos();
	}
	
	public void evolucionarPokemon(Pokemon pokemon) {
		pokemon.agregarEvolucion(this.buscarPokemon(pokemon.getNombre()).getEvoluciones().get(0));
	}
	
}
