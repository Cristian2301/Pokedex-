package pokedexLite;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Integer opcion;
		Scanner sc = new Scanner(System.in);
		Aplicacion aplicacion = new Aplicacion();
		
		System.out.println("Ingrese la opcion 1 para mostrar un pokemon");
        System.out.println("Ingrese la opcion 2 para agregar un pokemon Nuevo");
        System.out.println("Ingrese la opcion 3 para modificar un pokemon ya existente");
        System.out.println("Ingrese la opcion 4 para eliminar un pokemon ya existente");
        System.out.println("Ingrese la opcion 5 para salir del programa");
        
        System.out.println("Ingrese una opcion:");
        opcion = sc.nextInt();
        
        System.out.println("Ingrese el nombre del pokemon:");
        String nombrePokemon = sc.nextLine();
        
        
        
        // Declarar el objeto e inicializar con
        // el objeto de entrada estándar predefinido
        
        // entrada de una cadena
        /*String name = sc.nextLine();
        // entrada de un carácter
        char gender = sc.next().charAt(0);
        // Entrada de datos numéricos
        // byte, short y float
        int age = sc.nextInt();
        long mobileNo = sc.nextLong();
        double average = sc.nextDouble();
        // Imprima los valores para verificar si la entrada
        // fue obtenida correctamente.
        System.out.println("Nombre: "+name);
        System.out.println("Género: "+gender);
        System.out.println("Edad: "+age);
        System.out.println("Teléfono: "+mobileNo);
        System.out.println("Promedio: "+average);*/
    }
}
