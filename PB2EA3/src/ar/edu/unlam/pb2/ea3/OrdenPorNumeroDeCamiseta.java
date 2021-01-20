package ar.edu.unlam.pb2.ea3;

import java.util.Comparator;

public class OrdenPorNumeroDeCamiseta implements Comparator<Jugador>{

	@Override
	public int compare(Jugador o1, Jugador o2) {
		// TODO Auto-generated method stub
		return o1.getNumero().compareTo(o2.getNumero());
	}
	
}
