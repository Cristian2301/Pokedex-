package pokedexLiteTest;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

import pokedexLite.Pokemon;
import pokedexLite.Aplicacion;

import pokedexLite.Evolucion;

class PokedexTest {
	private Pokemon pokemon1;
	private Pokemon pokemon2;
	private Pokemon pokemon3;
	private Pokemon pokemon4;
	private Pokemon pokemon5;
	private Pokemon pokemon6;
	private Pokemon pokemon7;
	private Pokemon pokemon8;
	private Pokemon pokemon9;
	private Pokemon pokemon10;
	private Pokemon pokemon11;
	private List<Pokemon> pokemons;
	private Aplicacion aplicacion;
	private List<String> tiposPokemon1;
	private List<Evolucion> evolucionesPokemon4;
	private Evolucion evolucionChikorita1;
	private Evolucion evolucionChikorita2;
	private List<Evolucion> evolucionesPokemon3;
	private Evolucion evolucionBulbasaur1;
	private Evolucion evolucionBulbasaur2;
	private List<String> tiposEvolucionBulbasaur1;
	private List<String> tiposEvolucionBulbasaur2;
	private List<String> habilidadesPokemon4;

	@BeforeEach
	void setUp() throws Exception {
		pokemon1 = new Pokemon("Charmander", 2);
		pokemon2 = new Pokemon("Squirtle", 1);
		pokemon3 = new Pokemon("Bulbasaur", 4);
		pokemon4 = new Pokemon("Chikorita", 6);
		pokemon5 = new Pokemon("Cyndaquil", 5);
		pokemon6 = new Pokemon("Totodile", 2);
		pokemon7 = new Pokemon("Treecko", 10);
		pokemon8 = new Pokemon("Torchic", 1);
		pokemon9 = new Pokemon("Turtwig", 6);
		pokemon10 = new Pokemon("Chimchar", 3);
		pokemon11 = new Pokemon("Piplup", 5);
		pokemons = new ArrayList<Pokemon>();
		tiposPokemon1 = new ArrayList<String>();
		evolucionesPokemon4 = new ArrayList<Evolucion>();
		evolucionChikorita1 = new Evolucion("Bayleef", 6);
		evolucionChikorita2 = new Evolucion("Meganium", 10);
		evolucionesPokemon3 = new ArrayList<Evolucion>();
		evolucionBulbasaur1 = new Evolucion("Ivysaur", 10);
		evolucionBulbasaur2 = new Evolucion("Venusaur", 20);
		tiposEvolucionBulbasaur1 = new ArrayList<String>();
		tiposEvolucionBulbasaur2 = new ArrayList<String>();
		habilidadesPokemon4 = new ArrayList<String>();
		aplicacion = new Aplicacion();
		
		/* testPokemonsListados */
		aplicacion.agregarPokemon();
		pokemons.add(pokemon1);
		aplicacion.agregarPokemon();
		pokemons.add(pokemon2);
		aplicacion.agregarPokemon();
		pokemons.add(pokemon3);
		aplicacion.agregarPokemon();
		pokemons.add(pokemon4);
		aplicacion.agregarPokemon();
		pokemons.add(pokemon5);
		aplicacion.agregarPokemon();
		pokemons.add(pokemon6);
		aplicacion.agregarPokemon();
		pokemons.add(pokemon7);
		aplicacion.agregarPokemon();
		pokemons.add(pokemon8);
		aplicacion.agregarPokemon();
		pokemons.add(pokemon9);
		aplicacion.agregarPokemon();
		pokemons.add(pokemon10);
		
		/* testNombreTiposYNivel - testActualizaInformacionPokemon */
		tiposPokemon1.add("fuego");
		tiposPokemon1.add("agua");
		tiposPokemon1.add("dragon");	
		pokemon1.agregarTipo("fuego");
		pokemon1.agregarTipo("agua");
		pokemon1.agregarTipo("dragon");
		
		/* testHabilidadesYEvoluciones */
		habilidadesPokemon4.add("espesura");
		habilidadesPokemon4.add("defensaHoja");
		pokemon4.setHabilidades(habilidadesPokemon4);
		
		evolucionesPokemon4.add(evolucionChikorita1);
		evolucionesPokemon4.add(evolucionChikorita2);
		pokemon4.agregarEvolucion(evolucionChikorita1);
		pokemon4.agregarEvolucion(evolucionChikorita2);
		
		/* testEvolucionesEInformacion */
		evolucionesPokemon3.add(evolucionBulbasaur1);
		evolucionesPokemon3.add(evolucionBulbasaur2);
		pokemon3.agregarEvolucion(evolucionBulbasaur1);
		pokemon3.agregarEvolucion(evolucionBulbasaur2);

		tiposEvolucionBulbasaur1.add("Planta");
		tiposEvolucionBulbasaur1.add("Veneno");
		tiposEvolucionBulbasaur2.add("Planta");
		tiposEvolucionBulbasaur2.add("Veneno");
		evolucionBulbasaur1.setTipos(tiposEvolucionBulbasaur1);
		evolucionBulbasaur2.setTipos(tiposEvolucionBulbasaur2);
		
	}
	
	@Test
	void testPokemonsListados() {
		assertEquals(pokemons, aplicacion.getPokemons());
		assertEquals(10, aplicacion.getPokemons().size());
	}

	@Test
	void testNombreTiposYNivel() {
		assertEquals("Charmander", aplicacion.devolverPokemon("Charmander").getNombre());
		assertEquals(tiposPokemon1, aplicacion.devolverPokemon("Charmander").getTipos());
		assertEquals(2, aplicacion.devolverPokemon("Charmander").getNivel());
	}

	@Test
	void testHabilidadesYEvoluciones() {
		assertEquals(habilidadesPokemon4, aplicacion.devolverPokemon("Chikorita").getHabilidades());
		assertEquals(evolucionesPokemon4, aplicacion.devolverPokemon("Chikorita").getEvoluciones());
	}
	
	@Test
	void testEvolucionesEInformacion() {
		assertEquals(evolucionesPokemon3, aplicacion.devolverPokemon("Bulbasaur").getEvoluciones());
		
		assertEquals("Ivysaur", aplicacion.devolverPokemon("Bulbasaur").getEvoluciones().get(0).getNombre());
		assertEquals(tiposEvolucionBulbasaur1, aplicacion.devolverPokemon("Bulbasaur").getEvoluciones().get(0).getTipos());
		assertEquals(10, aplicacion.devolverPokemon("Bulbasaur").getEvoluciones().get(0).getNivel());
		
		assertEquals("Venusaur", aplicacion.devolverPokemon("Bulbasaur").getEvoluciones().get(1).getNombre());
		assertEquals(tiposEvolucionBulbasaur2, aplicacion.devolverPokemon("Bulbasaur").getEvoluciones().get(1).getTipos());
		assertEquals(20, aplicacion.devolverPokemon("Bulbasaur").getEvoluciones().get(1).getNivel());
	}
	
	@Test
	void testAgregarYDevolverPokemon() {
		aplicacion.agregarPokemon(pokemon11);
		assertEquals(pokemon11, aplicacion.devolverPokemon("Piplup"));
	}
	
	@Test
	void testActualizaInformacionPokemon() {
		aplicacion.editarNombre(pokemon1, "Picachu");
		aplicacion.eliminarTipo(pokemon1, "agua");
		tiposPokemon1.remove("agua");
		aplicacion.agregarTipo(pokemon1, "bicho");
		tiposPokemon1.add("bicho");
		aplicacion.editarNivel(pokemon1, 10);
		assertEquals("Picachu", aplicacion.devolverPokemon("Picachu").getNombre());
		assertEquals(tiposPokemon1, aplicacion.devolverPokemon("Picachu").getTipos());
		assertEquals(10, aplicacion.devolverPokemon("Picachu").getNivel());
	}
}
