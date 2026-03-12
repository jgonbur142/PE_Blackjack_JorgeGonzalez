package app;

import java.util.List;

/**
 * Define las acciones básicas que puede llevar a cabo cualquier jugador.
 */
public interface IJugador {
	
	/**
	 * Añade una carta a la mano del jugador.
	 */
	void robarCarta(Carta carta);
	
	/**
	 * Calcula la suma total de puntos según las cartas en mano.
	 * @return Número entero que representa la puntuación.
	 */
	int calcularPuntuacion();
	
	/**
	 * Elimina las cartas de la mano actual.
	 */
	void vaciarMano();
	
	/**
	 * Obtiene la lista de cartas en la mano.
	 * @return Lista de cartas.
	 */
	List<Carta> getMano();
	
	/**
	 * Obtiene el nombre del jugador.
	 * @return Cadena que representa el nombre del jugador.
	 */
	String getNombre();
}
