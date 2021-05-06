package Pokedex;

import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Exceptions.EvolutionAlreadyExistsException;
import Exceptions.MaxEvolutionsException;
import Files.FileHandler;
import domain.*;

public class Pokedex {

	private List<Pokemon> pokemons;
	private List<Evolution> evolutions;
	
	public List<Evolution> getEvolutions() {
		return this.evolutions;
	}
	
	public void setEvolutions(List<Evolution> evolutions) {
		this.evolutions = evolutions;
	}
	
	public List<Pokemon> getPokemons() {
		return this.pokemons;
	}

	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

	public Pokedex(List<Pokemon> pokemons, List<Evolution> evolutions) {
		
		if(pokemons != null && evolutions != null)
		{
			this.pokemons = pokemons;
			this.evolutions = evolutions;
		}
	}

	/**
	 * Returns a string built with all the pokemon's data, including abilities, evolutions and its evolution's abilities too.
	 */
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		for(Pokemon pok : this.pokemons) {
			
			sb.append(pok.toString());
			for(Evolution evo : this.evolutions) {
				
				if(evo.getPokID() == pok.getPokID()) {
					sb.append(evo.toString());
				}
			}
		}
	
		
		return sb.toString();
	}
	
	/**
	 * Gets the pokemon information from user input, builds a new pokemon and adds it to the list.
	 * @return Returns true if the pokemon was created and added to the list correctly.
	 */
	public boolean addPokemon(){
		boolean ret = false;
		Scanner reader = new Scanner(System.in);
		String name;
		int levelFound;
		eType typeOfPokemon;
		int type;
		
		Abilitie ab;
		String abName;
		eType typeOfAbilitie;
		int abType;
		List<Abilitie> abilities = new ArrayList<Abilitie>();
		
		try {
			System.out.print("\nEnter the Pokemon's name: ");
			name = reader.nextLine();
			
			System.out.print("Enter the Pokemon's level when found: ");
    		levelFound = reader.nextInt();
    		
    		System.out.print("Choose the type number: \n" + Pokedex.showEnum());
    		type = reader.nextInt();
    		typeOfPokemon = Pokedex.getType(type);
    		
    		reader.nextLine();
    		System.out.print("\nEnter the name of the Pokemon's main abilitie: ");
    		abName = reader.nextLine();
    		
    		System.out.print("Choose the abilitie type number: \n" + Pokedex.showEnum());
    		abType = reader.nextInt();
    		typeOfAbilitie = Pokedex.getType(abType);
    		
    		ab = new Abilitie(abName, typeOfAbilitie);
    		abilities.add(ab);
    		
    		if(this.validatePokemon(name, typeOfPokemon))
    		{
    			Pokemon p1 = new Pokemon(name, typeOfPokemon, levelFound, abilities);    			
    			this.pokemons.add(p1);
    			ret = true;
    			
    		}
    		
    	} catch (InputMismatchException ex) {
    		System.out.print("Pokemon could not be added");
    		reader.next();
    	}
		
		return ret;
	}
	
	/**
	 * Checks if the pokemon already exists in the lists.
	 * @param name Gets the pokemon's name
	 * @param type Gets the pokemon's type
	 * @return Returns true if the pokemon is not in the database.
	 */
	private boolean validatePokemon(String name, eType type){
		
		boolean ret = true;
		
		for(Pokemon pok: this.pokemons){
			
			if(name == pok.getName() && type == pok.getType()){
				ret = false;
			}
		}
		return ret;
	}
	
	/**
	 * 
	 * @return Returns a string built with the eType enum, in order to be displayed.
	 */
	static String showEnum() {
		
		StringBuilder sb = new StringBuilder();
		int i = 1;
		for(eType t: eType.values()) {
			
			sb.append(i + " - " + t.toString()+ "\n");
			i++;
		}
		return sb.toString();
	}
	
	static eType getType(int num){
		eType t;
		
		switch(num){
			case 1:
				t = eType.FIRE;
				break;
			case 2:
				t = eType.POISON;
				break;
			case 3: 
				t = eType.WATER;
				break;
			case 4:
				t = eType.ROCK;
				break;
			case 5:
				t = eType.ELECTRIC;
				break;
			case 6:
				t = eType.ICE;
				break;
			case 7:
				t = eType.PSYCHIC;
				break;
			default:
				t = eType.NEUTER;
				break;
		}
		
		return t;
	}
	
	/**
	 * Modifies an existent pokemon, checking if it actually exists first. Then displays a menu in which the user can choose
	 * what attribute will be modified.
	 * @return Returns true if the pokemon was correctly modified.
	 * @throws MaxEvolutionsException 
	 */
	public boolean modifyPokemon() throws MaxEvolutionsException{
		
		boolean ret = false;
		Scanner reader = new Scanner(System.in);
		int pokID;
		String newName;
		int type;
		eType typeOfPokemon;
		int optionMenu;
		
		
		System.out.print("Enter the pokemon's ID: ");
		pokID = reader.nextInt();
		reader.nextLine();
		
		if(this.checkForPokemon(pokID))
		{
			optionMenu = Pokedex.showModifyMenu();
			
			switch(optionMenu) {
			case 1:
				try {
					System.out.print("Enter the pokemon's NEW name: ");
					newName = reader.nextLine();
					for(Pokemon p: this.pokemons)
					{
						if(p.getPokID() == pokID)
						{
							p.setName(newName);
							ret = true;
						}
					}
				} catch (InputMismatchException ex) {
					System.out.print("Pokemon could not be modified");
					reader.next();
				}
				break;
			case 2:
				try {
					System.out.print("Choose the NEW type number: \n" + Pokedex.showEnum());
					type = reader.nextInt();
					typeOfPokemon = Pokedex.getType(type);
					for(Pokemon p: this.pokemons)
					{
						if(p.getPokID() == pokID)
						{
							p.setType(typeOfPokemon);
							ret = true;
						}
					}
					
				} catch (InputMismatchException ex) {
					System.out.print("Pokemon could not be added");
					reader.next();
				}
				break;
			case 3:
				for(Pokemon p: this.pokemons)
				{
					if(p.getPokID() == pokID)
					{
						p.setType(eType.NEUTER);
						ret = true;
					}
				}
				break;
			case 4:
				for(Pokemon p: this.pokemons) {
					if(p.getPokID() == pokID) {
						p.getAbilities().remove(0);
						ret = true;
					}
				}
				break;
			case 5:
				try {
					if(!this.checkIfHasMaxEvolutions(pokID)) {
						ret = this.addEvolution(pokID);					
					}
					else {
						throw new MaxEvolutionsException("This pokemon already has all its evolutions");
					}
				} catch(EvolutionAlreadyExistsException ex) {
					System.out.print(ex.getMessage());
					ret = false;
				}
				break;
			case 6:
				break;
			default:
				break;
			}
		}
	
		return ret;
	}
	
	/**
	 * 
	 * @param id Gets the pokID from the pokemon whose existency will be checked.
	 * @return Returns true if the pokemon exists in the list.
	 */
	private boolean checkForPokemon(int id){
		
		boolean ret = false;
		
		for(Pokemon p: this.pokemons)
		{
			if(id == p.getPokID())
			{
				ret = true;
			}
		}
		
		return ret;
	}
	
	/**
	 * Checks if the evolution already exists in the lists.
	 * @param name Gets the evolution's name
	 * @param type Gets the evolution's type
	 * @return Returns true if the evolution is not in the database.
	 */
	private boolean checkForEvolution(String name, eType type){
		
		boolean ret = false;
		
		for(Evolution evo: this.evolutions){
			
			if(name == evo.getName() && type == evo.getType()){
				ret = true;
			}
		}
		return ret;
	}
	
	private boolean checkIfHasMaxEvolutions(int pokId) {
		
		int count = 0;
		for(Evolution e: this.evolutions) {
			if(e.getPokID() == pokId) {
				count++;
				if(count == 2){
					
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Displays a Modify Menu to the user and waits for an option to be choosed.
	 * @return returns the option typed by the user.
	 */
	static int showModifyMenu(){
		
		int option = 0;
		Scanner reader = new Scanner(System.in);
		
		System.out.println("\n***********Modify Menu*********\n");
		System.out.println("1- Modify name\n");
		System.out.println("2- Change type\n");
	    System.out.println("3- Remove type\n");
	    System.out.println("4- Remove Abilitie");
	    System.out.println("5- Add a new evolution\n");
	    System.out.println("6- Exit menu\n");

		
	    System.out.print("Enter a valid option: ");
	    
	    do {
	    	
	    	try {
	    		option = reader.nextInt();
	    		
	    	} catch (InputMismatchException ex) {
	    		System.out.print("Please enter only valid numbers");
	    		reader.next();
	    	}
	    	
	    } while(option < 1 || option > 6);
	   
		return option;
	}
	
	/**
	 * Gets the evolution's information from user input, builds a new evolution and adds it to the list.
	 * @param pokID Gets the pokID of the pokemon whose going to get the Evolution added
	 * @return Returns true if the evolution was created and added to the list correctly.
	 * @throws EvolutionAlreadyExistsException 
	 */
	private boolean addEvolution(int pokID) throws EvolutionAlreadyExistsException {
		
		boolean ret = false;
		Scanner reader = new Scanner(System.in);
		String evolutionName;
		int levelToEvolution;
		eType typeOfEvolution;
		int type;
		int evoID;
		
		Abilitie ab;
		String abName;
		eType typeOfAbilitie;
		int abType;
		List<Abilitie> abilities = new ArrayList<Abilitie>();
		
		try {
			
			System.out.print("\nEnter the Evolution's name: ");
			evolutionName = reader.nextLine();
			
			System.out.print("Enter the level at which the pokemon evolves: ");
			levelToEvolution = reader.nextInt();
			
			System.out.print("Choose the type number: \n" + Pokedex.showEnum());
			type = reader.nextInt();
			typeOfEvolution = Pokedex.getType(type);
			
			System.out.print("Enter the evolution number: ");
			evoID = reader.nextInt();
			
			reader.nextLine();
			System.out.print("\nEnter the name of the Evolution's main abilitie: ");
			abName = reader.nextLine();
			
			System.out.print("Choose the abilitie type number: \n" + Pokedex.showEnum());
			abType = reader.nextInt();
			typeOfAbilitie = Pokedex.getType(abType);
			
			ab = new Abilitie(abName, typeOfAbilitie);
			abilities.add(ab);
			
			if(this.checkForEvolution(evolutionName, typeOfEvolution)){
				
				Evolution evo = new Evolution(evolutionName, levelToEvolution, pokID, evoID, abilities, typeOfEvolution);    			
				this.evolutions.add(evo);
				ret = true;
			}
			else {
				throw new EvolutionAlreadyExistsException("That evolution is already on the pokedex");
			}
			
		} catch (InputMismatchException ex) {
			System.out.print("Evolution could not be added");
			reader.next();
		}
    	
    	return ret;
	}
	
	/**
	 * Manages the methods from the FileHandler class in order to make them more encapsuled but accessible. 
	 * @return Returns true if the files were written successfully.
	 */
	public boolean writeXml() {
		boolean ret = false;
		
		FileHandler fh = new FileHandler();
		if(fh.writePokXml("pokemons", this.pokemons) && fh.writeEvoXml("evolutions", this.evolutions)){
			ret = true;
		}
		return ret;
	}
	/**
	 * Manages the method from the FileHandler class in order to make them more encapsuled but accessible.
	 * @return Returns the list returned by the FileHandler method.
	 */
	static List<Pokemon> readPokemonXml() {
		
		FileHandler fh = new FileHandler();
		
		return fh.readPokemonXml();
	}
	
	/**
	 * Manages the method from the FileHandler class in order to make them more encapsuled but accessible.
	 * @return Returns the list returned by the FileHandler method.
	 */
	static List<Evolution> readEvolutionXml() {
		
		FileHandler fh = new FileHandler();
		
		return fh.readEvolutionXml();
	}
}
