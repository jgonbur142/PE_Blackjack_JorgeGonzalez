package app;
/**
 * Tipo de jugador que representa el "rival" dentro del juego
 */
public class Crupier extends Jugador {
	
	/**
	 * Constructor que utiliza el de {@link Jugador} con nombre fijo por parámetro 
	 */
	public Crupier() {
		super("Crupier");
	}

	/**
	 * Decide si debe plantarse o pedir nueva carta
	 * @return true si su puntuación es <17, false si su puntuación es >17
	 */
	public boolean debeRobar() {
		return calcularPuntuacion()<17;
	}
}
