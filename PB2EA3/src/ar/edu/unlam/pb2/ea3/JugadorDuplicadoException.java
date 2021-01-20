package ar.edu.unlam.pb2.ea3;

public class JugadorDuplicadoException extends Exception {

	public JugadorDuplicadoException() {
		super("Este jugador ya se encuentra agregado");
	}
}
