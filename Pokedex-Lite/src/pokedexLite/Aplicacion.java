package pokedexLite;

import java.util.List;

import java.util.ArrayList;

public class Aplicacion {
	private List<Pokemon> pokemons;
	
	/* Constructor */
	public Aplicacion() {
		this.pokemons = new ArrayList<Pokemon>();
	}
	
	public List<Pokemon> getPokemons(){
		return pokemons;
	}
	
	public void agregarPokemon(Pokemon pokemon) {	
	/*Agrega un pokemon a la lista de pokemons.*/
		this.pokemons.add(pokemon);
	}
	
	public Pokemon devolverPokemon(String nombre) { 
	/* Devuelve el pokemon que tenga el nombre "nombre" en la lista de pokemons.
	Precondicion: debe existir un pokemon con ese nombre.*/
		Integer i = 0;
		while(this.getPokemons().get(i).getNombre() != nombre) {
			i++;
		}
		return this.getPokemons().get(i);
	}
	
	public void editarNombre(Pokemon pokemon, String nombre) {
	/*busca el pokemon "pokemon" en la lista de pokemons, y le setea el nombre "nombre".*/
		for(Pokemon p : this.getPokemons()) {
			if(p == pokemon) {
				p.setNombre(nombre);
			}
		}
	}
	
	public void agregarTipo(Pokemon pokemon, String tipo) {
	/*busca el pokemon "pokemon" en la lista de pokemons y le agrega el tipo "tipo" a la lista de tipos.*/
		for(Pokemon p : this.getPokemons()) {
			if(p == pokemon) {
				p.agregarTipo(tipo);
			}
		}
	}
	
	public void eliminarTipo(Pokemon pokemon, String tipo) {
	/*busca el pokemon "pokemon" en la lista de pokemons y elimina el tipo "tipo" de la lista de tipos.*/
		for(Pokemon p : this.getPokemons()) {
			if(p == pokemon) {
				p.eliminarTipo(tipo);
			}
		}
	}
	
	public void agregarEvolucion(Pokemon pokemon, Evolucion evolucion) {
	/*busca el pokemon "pokemon" en la lista de pokemons y agrega la evolucion "evolucion" a la lista de evoluciones.*/
		for(Pokemon p : this.getPokemons()) {
			if(p == pokemon) {
				p.agregarEvolucion(evolucion);
			}
		}
	}
	
	public void editarNivel(Pokemon pokemon, Integer nivel) {
	/*busca el pokemon "pokemon" en la lista de pokemons y le setea el nivel "nivel".*/
		for(Pokemon p : this.getPokemons()) {
			if(p == pokemon) {
				p.setNivel(nivel);
			}
		}
	}
}
