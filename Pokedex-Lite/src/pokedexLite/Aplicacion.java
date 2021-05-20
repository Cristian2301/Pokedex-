package pokedexLite;

import java.util.List;

import java.util.Scanner;
import java.util.ArrayList;

import java.util.Map;
import java.util.HashMap;

import java.util.InputMismatchException;
import java.lang.IndexOutOfBoundsException;

public class Aplicacion {
	private Validador validador = new Validador();
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
		Boolean pokemonEsValido;
		String datosPokemon = "";
		
		do {
			System.out.println("Ingrese el nombre del pokemon que desea que se muestre:");
			String nombrePokemon = sc.next();
			
			try {
				datosPokemon = this.datosPokemon(this.buscarPokemon(nombrePokemon));
				pokemonEsValido = false;
			}
			catch (IndexOutOfBoundsException e) {
				System.out.println("El pokemon ingresado no existe");
				pokemonEsValido = true;
			} 
		} while(pokemonEsValido);
		
		return datosPokemon;
	}
	//("El pokemon ingresado no existe"); //generar excepcion que mande mensaje por consola
	// usar finally / como hacer rollback en excepcion
	
	public void agregarPokemon() {	
		String nombrePokemon = "";
		Boolean pokemonExistente;
		Integer nivelPokemon = 0;
		
		do {
			System.out.println("Ingrese los datos del pokemon que desea agregar:");
			
			try {
				nombrePokemon = this.insertarNombre();
				
				validador.validarPokemon(this, nombrePokemon);
				pokemonExistente = false;
			}
			catch(PokemonYaExisteExcepcion e) {
				System.out.println("El pokemon ingresado ya existe");
				pokemonExistente = true;
			}
		} while(pokemonExistente);
		
		nivelPokemon = this.insertarNivel();
		
		Pokemon pokemon = new Pokemon(nombrePokemon, nivelPokemon);
		
		pokemon.setTipos(this.insertarTipo());
		
		this.agregarEvolucionesAMap(pokemon);
		
		this.getPokemons().add(pokemon);
		
	}
	
		
	public void modificarPokemon() {
		Pokemon pokemon = null;
		Boolean pokemonNoExiste;
		Boolean modificandoPokemon = true;
		
		do {
			System.out.println("Ingrese el nombre del pokemon que desea modificar:");
			String nombre = sc.next();
			
			try {
				pokemon = this.buscarPokemon(nombre);
				pokemonNoExiste = false;
			}
			catch (IndexOutOfBoundsException e) {
				System.out.println("El pokemon ingresado no existe");
				pokemonNoExiste = true;
			}
		} while(pokemonNoExiste);
		
		this.edicionDatosPokemon(pokemon);
		
	}
	
	public void edicionDatosPokemon(Pokemon pokemon) {
		Boolean modificandoPokemon = true;
		Boolean condicionPokemon = false;
		
		do {
			try {
				while (modificandoPokemon) {
					System.out.println(" ¿Que dato del pokemon desea modificar? (Ingrese: Nivel/Tipos/Evoluciones/Habilidades) \n Si no desea modificar ningún dato ingrese 'Salir':");
					String opcion = sc.next();
					switch (opcion) {
					
						case "Nivel":
							Integer nivelPokemon = this.insertarNivel();
							pokemon.setNivel(nivelPokemon);
							break;
							
						case "Tipos":	
							pokemon.getTipos().removeAll(pokemon.getTipos());
							pokemon.setTipos(this.insertarTipo());
							break;
							
						case "Evoluciones":
							this.edicionEvoluciones(pokemon);
							break;
							
						case "Habilidades":
							break;
							
						case "Salir":
							modificandoPokemon = false;
							break;
					}
				}
				condicionPokemon = false;
			}
			catch (PokemonNoEvolucionadoExcepcion e) {
				System.out.println("El pokemon " + pokemon.getNombre() + " aún no evolucionó /n El pokemon debe haber evolucionado antes para que se pueda eliminar una evolución");
				condicionPokemon = true;
			}
		} while(condicionPokemon);
	}
	
	
	public void eliminarPokemon() {
		Boolean pokemonNoExiste;
		do {
			System.out.println("Ingrese el nombre del pokemon que desea eliminar:");
			String nombre = sc.next();
			
			try {
				this.getPokemons().remove(this.buscarPokemon(nombre));
				pokemonNoExiste = false;
			}
			catch (IndexOutOfBoundsException e) {
				System.out.println("El pokemon ingresado no existe");
				pokemonNoExiste = true;
			}
		} while(pokemonNoExiste);
	}
	
	
	public String listarPokemons() {
		StringBuilder strPokemons = new StringBuilder();
		for (Pokemon p: this.getPokemons()) {
			strPokemons.append(this.datosPokemon(p)+"\n");
		}
		return strPokemons.toString();
	}
	
	
	//TODO: HACER QUE LA EXCEPTION DE QUE NO PUEDE EVOLUCIONAR MAS, CUANDO HAGA EL ROLLBACK ME TIRE PARA LA LISTA DE OPCIONES
	//DEL MENU 
	public void evolucionarPokemon() {
		Boolean pokemonNoExiste = false;
		Boolean pokemonNoEvoluciona = false;
		do { 
			System.out.println("Ingrese el nombre del pokemon que desea evolucionar:");
			String nombre = sc.next();
			Pokemon pokemon;
			
			try {
				pokemon = this.buscarPokemon(nombre);
				pokemonNoExiste = false;
				
				validador.validarPokemonEvolucionado(pokemon);
				pokemonNoEvoluciona = false;
				
				this.evolucionDePokemon(pokemon);
			}
			catch(IndexOutOfBoundsException e) {
				System.out.println("El pokemon ingresado no existe");
				pokemonNoExiste = true;
			}
			catch(PokemonNoEvolucionaMasExcepcion e) {
				System.out.println("El pokemon " + nombre + " no puede evolucionar más");
				pokemonNoEvoluciona = true;
			}
		} while(pokemonNoExiste || pokemonNoEvoluciona);
	}
	
	
	public void eliminarEvolucion(Pokemon pokemon) throws PokemonNoEvolucionadoExcepcion {
		validador.validarPokemonNoEvolucionado(pokemon);
		if (pokemon.getEvoluciones().size() == 2) {
			pokemon.getEvoluciones().remove(1);
		}
		else {
			pokemon.getEvoluciones().remove(0);
		}
	}
	
	/*	public modificarEvolucion(Pokemon pokemon) {
	System.out.println("Ingrese el nombre de la evolucion que desea modificar:");
	
}*/

//****************************************************************************//
	
	
		
	public String insertarNombre() {
			System.out.println("Nombre:");
			String nombre = sc.next();
			return nombre;
	}
	
	
	//TODO: ESTA TIRANDO ERROR: SE QUEDA LOOPEANDO EN EL nivel = sc.nextInt();
	public Integer insertarNivel() {
		Integer nivel = 0;
		Boolean nivelNoEsNumerico = false;
		do {
			try {
				System.out.println("nivel:");
				nivel = sc.nextInt();
				nivelNoEsNumerico = false;
			}
			catch(InputMismatchException e) {
				System.out.println("el nivel ingresado debe ser un valor numerico");
				nivelNoEsNumerico = true;
			}
		} while(nivelNoEsNumerico);
		
		return nivel;
	} 
	
/*	public List<String> insertarTipo() {
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
	}*/
	
	public void insertarTipo(Pokemon pokemon){
		System.out.println("*Mensaje: Recuerde que al agregar un tipo al pokemon, tambien esta agregando al pokemon la habilidad que corresponde a ese tipo*");
		String tipo1 = sc.next();
		Tipo tipo = null;
		switch(tipo1) {
			case "bicho":
				pokemon.agregarTipo(tipo.BICHO);
				break;
			   
			case "agua":
				pokemon.agregarTipo(tipo.AGUA);
				break;
			
			case "volador":
				pokemon.agregarTipo(tipo.VOLADOR);
				break;
				
			case "fuego":
				pokemon.agregarTipo(tipo.FUEGO);
				break;
		     
			case "roca":
				pokemon.agregarTipo(tipo.ROCA);
				break;
				
			case "electrico":
				pokemon.agregarTipo(tipo.ELECTRICO);
				break;
				
			case "tierra":
				pokemon.agregarTipo(tipo.TIERRA);
				break;
				
			case "hielo":
				pokemon.agregarTipo(tipo.HIELO);
				break;
			
			case "acero":
				pokemon.agregarTipo(tipo.ACERO);
				break;
		}
	}

	
	public Evolucion insertarEvolucion() {
		String nombreEvolucion = this.insertarNombre();
		Integer nivelEvolucion = this.insertarNivel();

		Evolucion evolucion = new Evolucion(nombreEvolucion, nivelEvolucion);
		
		evolucion.setTipos(this.insertarTipo());
		
		return evolucion;
	}
	

	public void evolucionDePokemon(Pokemon pokemon) {
		if (pokemon.getEvoluciones().size() == 0) {
			pokemon.agregarEvolucion(this.evolucionesDePokemon(pokemon).get(0));
		}
		else {
			pokemon.agregarEvolucion(this.evolucionesDePokemon(pokemon).get(1));
		}
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
	
	
	public void edicionEvoluciones(Pokemon pokemon) throws PokemonNoEvolucionadoExcepcion {
		String opcion;
		Boolean editandoEvolucion = true;
		while (editandoEvolucion) {
			System.out.println("Si desea modificar una evolucion ingrese 'M' /n Si desea eliminar una evolucion ingrese 'E' \n Si desea salir ingrese 'Salir'");
			opcion = sc.next();
			switch (opcion) {
			
				case "M":
	//				this.modificarEvolucion(pokemon);
					System.out.println("Evolucion modificada");
					break;
					
				case "E":
					this.eliminarEvolucion(pokemon);
					System.out.println("Evolucion eliminada");
					break;
					
				case "Salir":
					editandoEvolucion = false;
					break;
			}
		}
	}

	
	public String datosPokemon(Pokemon pokemon) {
		return pokemon.toString();
	}
	
	
	public void agregarEvolucionesAMap(Pokemon pokemon) {
		ArrayList<Evolucion> evoluciones = new ArrayList<Evolucion>();
		if (!this.existePokemonConEvoluciones(pokemon.getNombre())) {
			System.out.println("Está agregando un pokemon nuevo, a continuacion agregue sus respectivas evoluciones:");
			System.out.println("primerEvolucion:");
			evoluciones.add(this.insertarEvolucion());
			System.out.println("SegundaEvolucion:");
			evoluciones.add(this.insertarEvolucion());
			
			this.getPokemonsYEvoluciones().put(pokemon, evoluciones);	
		}
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
