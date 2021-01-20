package ar.edu.unlam.pb2.ea3;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JugadorTest {
	@Test
	public void queUnJugadorSeaIgualAOtroPorSuNombre() {
		Jugador jugador1= new Jugador(5, "Juan", 100);
		Jugador jugador2= new Jugador(2, "Juan", 200);
		Jugador jugador3= new Jugador(5, "Juan", 100);
		
		assertTrue(jugador1.getNombre().equals(jugador2.getNombre()));
		assertTrue(jugador1.getNombre().equals(jugador3.getNombre()));
		assertTrue(jugador2.getNombre().equals(jugador3.getNombre()));
	}
}
