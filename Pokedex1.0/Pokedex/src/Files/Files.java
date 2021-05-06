package Files;

import java.util.List;

import domain.Evolution;
import domain.Pokemon;

public interface Files {
	
	public abstract List<Pokemon> readPokemonXml();
	
	public abstract List<Evolution> readEvolutionXml();

	public abstract boolean writePokXml(String fileName, List<Pokemon> pokList);
	
	public abstract boolean writeEvoXml(String fileName, List<Evolution> evoList);

}
