package pokedexLite;

import java.util.List;

import java.util.Scanner;
import java.util.ArrayList;

import java.util.Map;
import java.util.HashMap;

import java.util.InputMismatchException;
import java.lang.IndexOutOfBoundsException;

public class Aplicacion {
	//private List<Pokemon> pokemonsValidos;
	private List<Pokemon> pokemons;
	private Map<Pokemon, ArrayList<Evolucion>> pokemonsYEvoluciones = new HashMap<Pokemon, ArrayList<Evolucion>>();
	private Scanner sc = new Scanner(System.in);
	
	/* Constructor */
	public Aplicacion() {
		this.pokemons = new ArrayList<Pokemon>();
	}
	
	public List<Pokemon> getPokemons(){
		return pokemons;
	}
	
	public Map<Pokemon, ArrayList<Evolucion>> getPokemonsYEvoluciones(){
		return pokemonsYEvoluciones;
	}
	
	
	public String mostrarPokemon() {
		System.out.println("Ingrese el nombre del pokemon que desea que se muestre:");
		String nombrePokemon = sc.next();
		
		try {
			return this.datosPokemon(this.buscarPokemon(nombrePokemon));
		}
		catch (Exception e) {
			throw new IndexOutOfBoundsException("El pokemon ingresado no existe");
		}
	}
	
	
	public void agregarPokemon() throws Exception {	
		System.out.println("Ingrese los datos del pokemon que desea agregar:");
		
		String nombrePokemon = this.insertarNombre();
		
		if (this.existePokemon(nombrePokemon)) {
			throw new Exception("El pokemon ingresado ya existe");
		}
		
		Integer nivelPokemon = this.insertarNivel();
		
		Pokemon pokemon = new Pokemon(nombrePokemon, nivelPokemon);
		
		pokemon.setTipos(this.insertarTipo());
		//System.out.println("pokemon" + pokemon);
		
		//System.out.println("lista:" + this.getPokemonsYEvoluciones().get(pokemon));
		
		if (!this.existePokemonConEvoluciones(pokemon.getNombre())) {
			ArrayList<Evolucion> evoluciones = new ArrayList<Evolucion>();
			System.out.println("Está agregando un pokemon nuevo, a continuacion agregue sus respectivas evoluciones:");
			System.out.println("primerEvolucion:");
			evoluciones.add(this.insertarEvolucion());
			System.out.println("SegundaEvolucion:");
			evoluciones.add(this.insertarEvolucion());
			
			this.getPokemonsYEvoluciones().put(pokemon, evoluciones);	
		}
		
		this.getPokemons().add(pokemon);
		
	}
	
		
	public void modificarPokemon() throws Exception {
		System.out.println("Ingrese el nombre del pokemon que desea modificar:");
		String nombre = sc.next();
		Pokemon pokemon;
		
		try {
			pokemon = this.buscarPokemon(nombre);
		}
		catch (Exception e) {
			throw new IndexOutOfBoundsException("El pokemon ingresado no existe");
		}
		
/*		System.out.println("Nombre nuevo:");
		String nombreNuevo = sc.next();
		if (this.existePokemon(nombreNuevo)) {
			throw new Exception("El pokemon ingresado ya existe");
		}
		pokemon.setNombre(nombreNuevo);*/
		
		Integer nivelPokemon = this.insertarNivel();
		pokemon.setNivel(nivelPokemon);

		pokemon.getTipos().removeAll(pokemon.getTipos());
		pokemon.setTipos(this.insertarTipo());
		
	}
	
	
	public void eliminarPokemon() {
		System.out.println("Ingrese el nombre del pokemon que desea eliminar:");
		String nombre = sc.next();
		
		try {
			this.getPokemons().remove(this.buscarPokemon(nombre));
		}
		catch (Exception e) {
			throw new IndexOutOfBoundsException("El pokemon ingresado no existe");
		}
	}
	
	
	public String listarPokemons() {
		StringBuilder strPokemons = new StringBuilder();
		for (Pokemon p: this.getPokemons()) {
			strPokemons.append(this.datosPokemon(p)+"\n");
		}
		return strPokemons.toString();
	}
	
	
	public void evolucionarPokemon() throws Exception {
		System.out.println("Ingrese el nombre del pokemon que desea evolucionar:");
		String nombre = sc.next();
		
		try {
			Pokemon pokemon = this.buscarPokemon(nombre);
		
			if (pokemon.getEvoluciones().size() < 2) {
				if (pokemon.getEvoluciones().size() == 0) {
					pokemon.agregarEvolucion(this.evolucionesDePokemon(pokemon).get(0));
				}
				else {
						pokemon.agregarEvolucion(this.evolucionesDePokemon(pokemon).get(1));
				}
			}
			else {
				throw new Exception("El pokemon no puede evolucionar más");
			}
		}
		catch(Exception e) {
			throw new IndexOutOfBoundsException("El pokemon ingresado no existe");
		}
	}
	

//****************************************************************************//
	
	
		
	public String insertarNombre() {
			System.out.println("Nombre:");
			String nombre = sc.next();
			return nombre;
	}
	
	public Integer insertarNivel() {
		try {
			System.out.println("nivel:");
			Integer nivel = sc.nextInt();
			return nivel;
		}
		catch(Exception e) {
			throw new InputMismatchException("el nivel ingresado debe ser un valor numerico");
		}	
	}
	
	public List<String> insertarTipo() {
//		try {
			List<String> tipos = new ArrayList<String>();
			Integer opcion = 1;
			String tipo;
			while (opcion == 1) {
				System.out.println("Tipo:");
				tipo = sc.next();
				tipos.add(tipo);
				System.out.println("Si desea agregar otro tipo presione 1, sino presione 2:");
				opcion = sc.nextInt();
			}
			return tipos;
//		}
//		catch(Exception e) {
//			throw new ArithmeticException("El tipo ingresado es invalido");
//		}
	}

	
	public Evolucion insertarEvolucion() {
		String nombreEvolucion = this.insertarNombre();
		Integer nivelEvolucion = this.insertarNivel();

		Evolucion evolucion = new Evolucion(nombreEvolucion, nivelEvolucion);
		
		evolucion.setTipos(this.insertarTipo());
		
		return evolucion;
	}
	

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

	
	public String datosPokemon(Pokemon pokemon) {
		return pokemon.toString();
	}
	
	public Boolean existePokemonConEvoluciones(String nombre) {
		List<Pokemon> pokemons = new ArrayList<Pokemon>(this.getPokemonsYEvoluciones().keySet());
		Boolean existePokemon = false;
		for (Pokemon p : pokemons) {
			existePokemon = existePokemon || p.getNombre().equals(nombre);
		}
		return existePokemon;
	}
	
	
	
	public Pokemon buscarPokemonConEvoluciones(Pokemon pokemon) {
		List<Pokemon> pokemons = new ArrayList<Pokemon>(this.getPokemonsYEvoluciones().keySet());
		Integer i = 0;
		while(!(pokemons.get(i).equals(pokemon))) {
			i++;
		}
		return pokemons.get(i);
	}
	
/*	public List<Evolucion> evolucionesDePokemon(Pokemon pokemon) {
		List<Evolucion> evoluciones = new ArrayList<Evolucion>();
		for (Map.Entry<Pokemon, ArrayList<Evolucion>> entry : this.getPokemonsYEvoluciones().entrySet()) {
			if(entry.getKey().equals(pokemon)) {
				evoluciones.addAll(entry.getValue());
			}
		}
		return evoluciones;
	}*/
	
	public List<Evolucion> evolucionesDePokemon(Pokemon pokemon) {
		List<Evolucion> evoluciones = new ArrayList<Evolucion>();
		for (Map.Entry<Pokemon, ArrayList<Evolucion>> entry : this.getPokemonsYEvoluciones().entrySet()) {
			if(entry.getKey().getNombre().equals(pokemon.getNombre())) {
				evoluciones.addAll(entry.getValue());
			}
		}
		return evoluciones;
	}
	
	/*	public List<String> tiposDePokemon(String nombre) {
	return this.buscarPokemon(nombre).getTipos();
}*/
	
}
