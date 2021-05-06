package domain;

import java.util.List;

public class Pokemon {
	
	private static int counter = 1;
	protected String name;
	protected eType type;
	protected int levelFound;
	protected int pokID;
	protected List<Abilitie> abilities;
	
	public void setPokID(int pokID){
		
		this.pokID = pokID;
	}
	
	public int getPokID(){
		
		return pokID;
	}
	
	public List<Abilitie> getAbilities() {
		
		return this.abilities;
	}

	public void setAbilities(List<Abilitie> abilities) {
		
		this.abilities = abilities;
	}

	public String getName(){
		
		return this.name;
	}

	public void setName(String name){
		
		this.name = name;
	}

	public eType getType(){
		
		return this.type;
	}

	public void setType(eType type){
		
		this.type = type;
	}

	public int getLevel(){
		
		return this.levelFound;
	}

	public void setLevel(int level){
		
		this.levelFound = level;
	}

	public Pokemon(String name, eType type, int level) {
		if(name != null && type != null && level > 0)
		{
			this.name = name;
			this.type = type;
			this.levelFound = level;
			this.pokID = Pokemon.counter++;
		}
	}
	
	public Pokemon(String name, eType type, int level, List<Abilitie> abilities) {
		if(name != null && type != null && level > 0)
		{
			this.name = name;
			this.type = type;
			this.levelFound = level;
			this.abilities = abilities;
			this.pokID = Pokemon.counter++;
		}
	}
	
	public Pokemon(String name, int pokID, List<Abilitie> abilities, eType type) {
		if(name != null && type != null)
		{
			this.name = name;
			this.pokID = pokID;
			this.abilities = abilities;
			this.type = type;
		}
	}
	
	/**
	 * 
	 * @param p Gets an especific pokemon to list its attributes.
	 * @return Returns a string built with the pokemon's attributes.
	 */
	public static String listPokemon(Pokemon p) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n*************Pokemon: " + p.name.toUpperCase() + "*************\n");
		sb.append("Type: " + p.type + "\n");
		sb.append("Level: " + p.levelFound + "\n");
		sb.append("ID: " + p.pokID + "\n");
		return sb.toString();
	}
	/**
	 * 
	 * @param p Gets an especific pokemon to list its abilities.
	 * @return Returns a string built with the pokemon's abilities.
	 */
	public static String listAbilities(Pokemon p) {
		
		StringBuilder sb = new StringBuilder();
		
		for(Abilitie ab : p.abilities)
		{
			sb.append(ab.toString());
		}			
		
		return sb.toString();
	}
	
	/**
	 * Returns a string built with all the pokemon's attributes and abilities.
	 */
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		//Muestro pokemon
		sb.append(listPokemon(this));
		
		//Muestro habilidades
		sb.append(listAbilities(this));
		
		return sb.toString();
	}
}
