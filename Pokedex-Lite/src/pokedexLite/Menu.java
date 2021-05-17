package pokedexLite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
	public static Aplicacion aplicacion = new Aplicacion();
	
	public static void main(String[] args) throws Exception {
		Pokemon pokemon1 = new Pokemon("Charmander", 2);
		Pokemon pokemon2 = new Pokemon("Squirtle", 1);
		Pokemon pokemon3 = new Pokemon("Bulbasaur", 4);
		Pokemon pokemon4 = new Pokemon("Chikorita", 6);
		Pokemon pokemon5 = new Pokemon("Cyndaquil", 5);
		pokemon1.agregarTipo("fuego");
		pokemon4.agregarTipo("agua");
		/*Pokemon pokemon6 = new Pokemon("Totodile", 2);
		Pokemon pokemon8 = new Pokemon("Treecko", 2);
		Pokemon pokemon9 = new Pokemon("Torchic", 2);
		Pokemon pokemon10 = new Pokemon("Turtwig", 2);*/
		Evolucion evolucion1Charmander = new Evolucion("Charmeleon", 16);
		Evolucion evolucion2Charmander = new Evolucion("Charizard", 36);
		Evolucion evolucion1Squirtle = new Evolucion("Wartortle", 16);
		Evolucion evolucion2Squirtle = new Evolucion("Blastoise", 36);
		Evolucion evolucion1Bulbasaur = new Evolucion("Ivysaur", 16);
		Evolucion evolucion2Bulbasaur = new Evolucion("Venusaur", 32);
		Evolucion evolucion1Chikorita = new Evolucion("Bayleef", 16);
		Evolucion evolucion2Chikorita = new Evolucion("Meganium", 32);
		Evolucion evolucion1Cyndaquil = new Evolucion("Quilava", 14);
		Evolucion evolucion2Cyndaquil = new Evolucion("Typhlosion", 36);
		ArrayList<Evolucion> evolucionesChar = new ArrayList<Evolucion>();
		ArrayList<Evolucion> evolucionesChik = new ArrayList<Evolucion>();
		evolucionesChar.add(evolucion1Charmander);
		evolucionesChar.add(evolucion2Charmander);
		evolucionesChik.add(evolucion1Chikorita);
		evolucionesChik.add(evolucion2Chikorita);
		
/*		aplicacion.getPokemonsYEvoluciones().put(pokemon1, (ArrayList<Evolucion>) Arrays.asList(evolucion1Charmander, evolucion2Charmander));
		aplicacion.getPokemonsYEvoluciones().put(pokemon2, (ArrayList<Evolucion>) Arrays.asList(evolucion1Squirtle, evolucion2Squirtle));
		aplicacion.getPokemonsYEvoluciones().put(pokemon3, (ArrayList<Evolucion>) Arrays.asList(evolucion1Bulbasaur, evolucion2Bulbasaur));
		aplicacion.getPokemonsYEvoluciones().put(pokemon4, (ArrayList<Evolucion>) Arrays.asList(evolucion1Chikorita, evolucion2Chikorita));
		aplicacion.getPokemonsYEvoluciones().put(pokemon5, (ArrayList<Evolucion>) Arrays.asList(evolucion1Cyndaquil, evolucion2Cyndaquil));*/		
	
		aplicacion.getPokemonsYEvoluciones().put(pokemon1, evolucionesChar);
		aplicacion.getPokemonsYEvoluciones().put(pokemon4, evolucionesChik);
		
		Integer opcion;
		List<Integer> opcionesValidas = Arrays.asList(1,2,3,4,5,6);
		Scanner sc = new Scanner(System.in);
				
		while(true) {
			System.out.println("Ingrese la opcion 1 para mostrar un pokemon");
	        System.out.println("Ingrese la opcion 2 para agregar un pokemon Nuevo");
	        System.out.println("Ingrese la opcion 3 para modificar un pokemon ya existente");
	        System.out.println("Ingrese la opcion 4 para eliminar un pokemon ya existente");
	        System.out.println("Ingrese la opcion 5 para listar todos los pokemons");
	        System.out.println("Ingrese la opcion 6 para evolucionar un pokemon");
	        System.out.println("Ingrese la opcion 7 para salir del programa");
	        System.out.println("Ingrese una opcion:");
        
	        
	        try {
	        	opcion = sc.nextInt();
	        	if (!opcionesValidas.contains(opcion)) {
	        		throw new ArithmeticException("no es una opcion valida");
	        	}
	        }
	        catch(Exception e) {
	        	throw new ArithmeticException("no es una opcion valida");
	        }
	        opciones(opcion);
		}
    }
	
	public static void opciones(Integer opcion) throws Exception {
		switch (opcion) {
			case 1: 
				System.out.println(aplicacion.mostrarPokemon());
				System.out.println("mostrando pokemon");
				break;
				
			case 2: 
				aplicacion.agregarPokemon();
				System.out.println("pokemon agregado");
				break;
				
			case 3:
				aplicacion.modificarPokemon();
				System.out.println("pokemon modificado");
				break;
				
			case 4: 
				aplicacion.eliminarPokemon();
				System.out.println("pokemon eliminado");
				break;	
					
			case 5:
				System.out.println(aplicacion.listarPokemons());
				System.out.println("lista de pokemons");
				break;
			
			case 6: 
				aplicacion.evolucionarPokemon();
				System.out.println("Se evolucionó el pokemon");
				break;	
				
			case 7: 
				System.out.println("usted ha salido del programa");
				System.exit(0);
				break;	
		}
	
	}
}
