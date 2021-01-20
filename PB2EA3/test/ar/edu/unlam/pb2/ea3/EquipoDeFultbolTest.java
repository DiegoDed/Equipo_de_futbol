package ar.edu.unlam.pb2.ea3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;



public class EquipoDeFultbolTest {

	@Test
	public void queSePuedaCrearUnEquipoVacio() {
		EquipoDeFutbol equipo = new EquipoDeFutbol("equipo");
		assertEquals(0, equipo.getJugadores().size());
	}
	
	@Test
	public void queSePuedanAgregarJugadorAlEquipo(){
		Jugador jugador1= new Jugador(5, "Juan", 100);
		EquipoDeFutbol equipo = new EquipoDeFutbol("equipo");
		try {
		equipo.agregarJugador(jugador1);
		equipo.agregarJugador(jugador1);
		}catch(CapacidadMaximaException e) {
			
		}catch(JugadorDuplicadoException e) {
			
		}
		assertEquals(1, equipo.getJugadores().size());
		
	}
	
	@Test(expected= JugadorDuplicadoException.class)
	public void queAlIntentarAgregarUnJugadorExistenetLanceExcepcion() throws CapacidadMaximaException, JugadorDuplicadoException{
		Jugador jugador1= new Jugador(5, "Juan", 100);
		EquipoDeFutbol equipo = new EquipoDeFutbol("equipo");
	
		equipo.agregarJugador(jugador1);
		equipo.agregarJugador(jugador1);
		
	}
	
	@Test(expected= CapacidadMaximaException.class)
	public void queAlIntentarAgregarCantidadExcesivaDeJugadoresLanceExcepcion() throws CapacidadMaximaException, JugadorDuplicadoException{
		Jugador jugador1= new Jugador(5, "Juan", 100);
		Jugador jugador2= new Jugador(2, "Eduardo", 200);
		Jugador jugador3= new Jugador(3, "Ignacio", 400);
		Jugador jugador4= new Jugador(4,"Hernan",500);
		
		EquipoDeFutbol equipo = new EquipoDeFutbol("equipo");
	
		equipo.agregarJugador(jugador1);
		equipo.agregarJugador(jugador2);
		equipo.agregarJugador(jugador3);
		equipo.agregarJugador(jugador4);
	}
	
	@Test
	public void queSePuedaCambiarUnJugador(){
		Jugador jugador1= new Jugador(5, "Juan", 100);
		Jugador jugador2= new Jugador(2, "Eduardo", 200);
		Jugador jugador3= new Jugador(3, "Ignacio", 400);
		EquipoDeFutbol equipo = new EquipoDeFutbol("equipo");
		
		try {
			equipo.agregarJugador(jugador1);
			equipo.agregarJugador(jugador2);
		} catch (CapacidadMaximaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JugadorDuplicadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean valorEsperado= false;
		try {
			valorEsperado= equipo.cambiarJugador(jugador1, jugador3);
		} catch (JugadorInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertTrue(valorEsperado);
	}
	
	@Test (expected = JugadorInexistenteException.class)
	public void queAlCambiarUnJugadorInexistenteLanceExcepcion()throws CapacidadMaximaException, JugadorDuplicadoException,JugadorInexistenteException{
		Jugador jugador1= new Jugador(5, "Juan", 100);
		Jugador jugador2= new Jugador(2, "Eduardo", 200);
		Jugador jugador3= new Jugador(3, "Ignacio", 400);
		EquipoDeFutbol equipo = new EquipoDeFutbol("equipo");
		
		equipo.agregarJugador(jugador1);
		equipo.cambiarJugador(jugador2, jugador3);
		
	}

	@Test
	public void queElEquipoPresenteLosJugadoresOrdenadosPorNombre(){
		Jugador jugador1= new Jugador(5, "Juan", 100);
		Jugador jugador2= new Jugador(2,"Eduardo", 200);
		Jugador jugador3= new Jugador(3,"Hernan", 300);
		EquipoDeFutbol equipo = new EquipoDeFutbol("equipo");
		try {
		equipo.agregarJugador(jugador1);
		equipo.agregarJugador(jugador2);
		equipo.agregarJugador(jugador3);
		}catch(CapacidadMaximaException e) {
			
		}catch(JugadorDuplicadoException e) {
			
		}
		
		equipo.devolverPlanteOrdenadoPorNombreDeJugador();
		
		Integer i=0;
		Iterator <Jugador> it= equipo.getJugadores().iterator() ;
		while(it.hasNext()) {
		Jugador jugador = it.next();
		switch (i) {
		case 0:
				assertEquals("Eduardo", jugador.getNombre());
				i++;
				break;
		case 1:
				assertEquals("Hernan", jugador.getNombre());
				i++;
				break;
		case 2:
				assertEquals("Juan", jugador.getNombre());
				i++;
				break;
			
			}
		}
	}
	
	@Test
	public void queElEquipoPresenteLosJugadoresOrdenadosPorPrecioDeCompra(){
		Jugador jugador1= new Jugador(5, "Juan", 300);
		Jugador jugador2= new Jugador(2,"Eduardo", 100);
		Jugador jugador3= new Jugador(3,"Hernan", 200);
		EquipoDeFutbol equipo = new EquipoDeFutbol("equipo");
		try {
		equipo.agregarJugador(jugador1);
		equipo.agregarJugador(jugador2);
		equipo.agregarJugador(jugador3);
		}catch(CapacidadMaximaException e) {
			
		}catch(JugadorDuplicadoException e) {
			
		}
		
		equipo.devolverPlanteOrdenadoPorPrecioDeCompraDeJugador();
		
		Integer i=0;
		Iterator <Jugador> it= equipo.getJugadores().iterator() ;
		while(it.hasNext()) {
		Jugador jugador = it.next();
		switch (i) {
		case 0:
				assertEquals(100, jugador.getPrecio(), 0.0);
				i++;
				break;
		case 1:
				assertEquals(200, jugador.getPrecio(), 0.0);
				i++;
				break;
		case 2:
				assertEquals(300, jugador.getPrecio(), 0.0);
				i++;
				break;
			}
		}
	}
	
	@Test
	public void queElEquipoPresenteLosJugadoresOrdenadosPorNumeroDeCamiseta(){
		Jugador jugador1= new Jugador(5, "Juan", 300);
		Jugador jugador2= new Jugador(2,"Eduardo", 100);
		Jugador jugador3= new Jugador(3,"Hernan", 200);
		EquipoDeFutbol equipo = new EquipoDeFutbol("equipo");
		try {
		equipo.agregarJugador(jugador1);
		equipo.agregarJugador(jugador2);
		equipo.agregarJugador(jugador3);
		}catch(CapacidadMaximaException e) {
			
		}catch(JugadorDuplicadoException e) {
			
		}
		
		equipo.devolverPlanteOrdenadoPorNumeroDeCamisetaDeJugador();
		
		Integer i=0;
		Iterator <Jugador> it= equipo.getJugadores().iterator() ;
		while(it.hasNext()) {
		Jugador jugador = it.next();
		switch (i) {
		case 0:
				assertEquals(2, jugador.getNumero(), 0.0);
				i++;
				break;
		case 1:
				assertEquals(3, jugador.getNumero(), 0.0);
				i++;
				break;
		case 2:
				assertEquals(5, jugador.getNumero(), 0.0);
				i++;
				break;
			}
		}
	}
	
	
}
        
        