package domain;

import java.util.List;

public class Evolution extends Pokemon
{
	protected int levelToEvolution;
	protected int pokID;
	protected int evoID;
	
	public int getLevelToEvolution() {
		return this.levelToEvolution;
	}

	public void setLevelToEvolution(int levelToEvolution) {
		this.levelToEvolution = levelToEvolution;
	}

	public int getPokID() {
		return this.pokID;
	}

	public void setPokID(int pokID) {
		this.pokID = pokID;
	}

	public int getEvoID() {
		return this.evoID;
	}

	public void setEvoID(int evoID) {
		this.evoID = evoID;
	}
	
	public Evolution(String name, int levelToEvolute, int pokID, int evoID, List<Abilitie> abilities, eType type){
		
		super(name, pokID, abilities, type);
		
		if(levelToEvolute > 1 && pokID >= 1 && evoID >= 1) {
			this.evoID = evoID;
			this.pokID = pokID;
			this.levelToEvolution = levelToEvolute;
		}
	}

	/**
	 * Returns a string built with all the evolution's attributes and abilities.
	 */
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("\n<-------Evolution N�: " + this.evoID + "------>\n");
		sb.append("Name: " + this.getName()+ "\n");
		sb.append("Type: " + this.getType() + "\n");
		sb.append("Level To Evolute: " + this.getLevelToEvolution() + "\n");
		
		for(Abilitie ab : this.abilities)
		{
			sb.append(ab.toString());
		}
		
		return sb.toString();
	}

}
