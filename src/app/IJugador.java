package app;

import java.util.List;

public interface IJugador {
	void robarCarta(Carta carta);
	
	int calcularPuntuacion();
	
	void vaciarMano();
	
	List<Carta> getMano();
	
	String getNombre();
}
