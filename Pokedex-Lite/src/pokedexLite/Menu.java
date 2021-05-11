package pokedexLite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
	public static Aplicacion aplicacion = new Aplicacion();
	
	public static void main(String[] args) {
		Pokemon pokemon1 = new Pokemon("Charmander", 2);
		Pokemon pokemon2 = new Pokemon("Squirtle", 1);
		Pokemon pokemon3 = new Pokemon("Bulbasaur", 4);
		Pokemon pokemon4 = new Pokemon("Chikorita", 6);
		Pokemon pokemon5 = new Pokemon("Cyndaquil", 5);
		Pokemon pokemon6 = new Pokemon("Totodile", 2);
		Pokemon pokemon8 = new Pokemon("Treecko", 2);
		Pokemon pokemon9 = new Pokemon("Torchic", 2);
		Pokemon pokemon10 = new Pokemon("Turtwig", 2);
		Evolucion evolucion1Charmander = new Evolucion("Charmeleon", 6);
		Evolucion evolucion2Charmander = new Evolucion("Charizard", 10);
		Evolucion evolucion1Chikorita = new Evolucion("Bayleef", 6);
		Evolucion evolucion2Chikorita = new Evolucion("Meganium", 10);
		//Evolucion evolucion2Chikorita = new Evolucion("Meganium", 10);
		
/*		aplicacion.getEvolucionesValidas().put("Charmander", "Charmeleon");
		aplicacion.getEvolucionesValidas().put("Charmander", "Charizard");
		aplicacion.getEvolucionesValidas().put("Chikorita", "Bayleef");
		aplicacion.getEvolucionesValidas().put("Chikorita", "Meganium");
		aplicacion.getEvolucionesValidas().put("Bulbasaur", "Ivysaur");
		aplicacion.getEvolucionesValidas().put("Cyndaquil", "Quilava");
		aplicacion.getEvolucionesValidas().put("Cyndaquil", "Typhlosion");
		aplicacion.getEvolucionesValidas().put("Totodile", "Croconaw");
		aplicacion.getEvolucionesValidas().put("Totodile", "Feraligatr");
		aplicacion.getEvolucionesValidas().put("Treecko", "Grovyle");
		aplicacion.getEvolucionesValidas().put("Treecko", "Sceptile");*/
		
		
		
		Integer opcion;
		List<Integer> opcionesValidas = Arrays.asList(1,2,3,4,5);
		Scanner sc = new Scanner(System.in);
				
		while(true) {
			System.out.println("Ingrese la opcion 1 para mostrar un pokemon");
	        System.out.println("Ingrese la opcion 2 para agregar un pokemon Nuevo");
	        System.out.println("Ingrese la opcion 3 para modificar un pokemon ya existente");
	        System.out.println("Ingrese la opcion 4 para eliminar un pokemon ya existente");
	        System.out.println("Ingrese la opcion 5 para salir del programa");
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
	
	public static void opciones(Integer opcion) {
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
				System.out.println("usted ha salido del programa");
				System.exit(0);
				break;	
		}
	
	}
}
