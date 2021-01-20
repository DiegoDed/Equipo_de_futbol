package ar.edu.unlam.pb2.ea3;

public class CapacidadMaximaException extends Exception {

	public CapacidadMaximaException() {
		super("No se puede agregar el jugador por que el equipo ya esta completo");
	}
}
