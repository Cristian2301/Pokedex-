package pokedexLite;

import java.util.List;
import java.util.Scanner;

public class Menu {
	public static Aplicacion aplicacion = new Aplicacion();
	
	public static void main(String[] args) {
		Integer opcion;
		Scanner sc = new Scanner(System.in);
				
		while(true) {
			System.out.println("Ingrese la opcion 1 para mostrar un pokemon");
	        System.out.println("Ingrese la opcion 2 para agregar un pokemon Nuevo");
	        System.out.println("Ingrese la opcion 3 para modificar un pokemon ya existente");
	        System.out.println("Ingrese la opcion 4 para eliminar un pokemon ya existente");
	        System.out.println("Ingrese la opcion 5 para salir del programa");
	        System.out.println("Ingrese una opcion:");
        
	        opcion = sc.nextInt();
	        opciones(opcion);
		}
        //

    }
	
	public static void opciones(Integer opcion) {
		switch (opcion) {
			case 1: 
				System.out.println("mostrando pokemon");
				break;
				
			case 2: 
				aplicacion.agregarPokemon();
				System.out.println("pokemon agregado");
				break;
				
			case 3: 
				System.out.println("pokemon modificado");
				break;
				
			case 4: 
				System.out.println("pokemon eliminado");
				break;	
				
			case 5: 
				System.out.println("usted ha salido del programa");
				System.exit(0);
				break;	
		}
	
	}
}
