package pokedexLite;

public class Validador {
	
	public void validarPokemonEvolucionado(Pokemon pokemon) throws PokemonNoEvolucionaMasExcepcion {
		if (pokemon.getEvoluciones().size() >= 2) throw new PokemonNoEvolucionaMasExcepcion();
	}
	
	public void validarPokemon(Aplicacion app, String nombrePokemon) throws PokemonYaExisteExcepcion {
		if (app.existePokemon(nombrePokemon)) throw new PokemonYaExisteExcepcion();
	}
	
	
	public void validarPokemonNoEvolucionado(Pokemon pokemon) throws PokemonNoEvolucionadoExcepcion {
		if (pokemon.getEvoluciones().isEmpty()) throw new PokemonNoEvolucionadoExcepcion();
	}
}