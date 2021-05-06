package Pokedex;

import java.util.*;
import Exceptions.*;
import domain.Evolution;
import domain.Pokemon;


public class Main {

	public static void main(String[] args) {

		int optionMenu;
		
		///////////////////////////POKEDEX//////////////////////////////////
		List<Evolution> evolutions = new ArrayList<Evolution>();
		List<Pokemon> pokemons = new ArrayList<Pokemon>();
		pokemons = Pokedex.readPokemonXml();
		evolutions = Pokedex.readEvolutionXml();
		Pokedex pokedex = new Pokedex(pokemons, evolutions);			
		
		//ABM
		do {
			optionMenu = Main.showMenu();
			switch(optionMenu) {
				case 1:
					if(pokedex.addPokemon())
					{
						System.out.print("Pokemon added to the database");
					}
					break;
				case 2:
					try {
						if(pokedex.modifyPokemon())
						{
							System.out.print("Pokemon modified succesfully");
						}						
					}
					catch(MaxEvolutionsException m) {
						System.out.print(m.getMessage());
					}
					break;
				case 3:
					System.out.print(pokedex.toString());
					break;
				case 4:
					if(pokedex.writeXml()) {
						System.out.print("\nPokedex saved\n");
					}
					break;
				case 5:
					//exit;
					System.out.println("Successful exit");
					break;
				default:
					break;
			}
		} while (optionMenu != 5);
		
	}
	
	/**
	 * Displays a Menu to the user and waits for an option to be choosed.
	 * @return returns the option typed by the user.
	 */
	static int showMenu(){
		
		int option = 0;
		Scanner reader = new Scanner(System.in);
		
		System.out.println("\n***********Pokedex Menu*********\n");
		System.out.println("1- Add a new Pokemon\n");
		System.out.println("2- Modify an existent Pokemon\n");
	    System.out.println("3- List all the Pokemons\n");
	    System.out.println("4- Save Pokedex in the database\n");
	    System.out.println("5- Exit Program\n");
		
	    System.out.print("Enter a valid option: ");
	    
	    do {
	    	
	    	try {
	    		option = reader.nextInt();
	    		
	    	} catch (InputMismatchException ex) {
	    		System.out.print("Please enter only valid numbers");
	    		reader.next();
	    		//reader.close();
	    	}
	    	
	    } while(option < 1 || option > 5);
	   
		return option;
	}

}
