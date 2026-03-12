package app;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de un jugador.
 * Gestiona el nombre del jugador, su mano y el cálculo de la puntuación.
 */
public class Jugador implements IJugador {
	
	private String nombre;
	private List<Carta> mano;
	
	/**
	 * Crea un jugador nuevo con su nombre y una mano vacía.
	 * @param nombre 
	 */
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.mano = new ArrayList<>();
	}
	
	/**
	 * Controla que haya una carta que robar y la roba.
	 * @param carta que recibe de {@link Carta}.
	 */
	public void robarCarta(Carta carta) {
		if (carta != null) {
			mano.add(carta);
		}
	}
	
	/**
	 * Se calcula el valor de cada carta individual y se suma, se guarda si la carta es un As para reajustar la puntuación.
	 * @return Puntuación ajustada teniendo en cuenta el As.
	 */
	public int calcularPuntuacion() {
		int total=0;
		int numAses=0;
		int valor=0;
		
		for (Carta c : mano) {
			valor = c.valorCarta();
			total += valor;
			
			if (valor ==1 || valor ==11) {
				numAses++;
			}
		}
		
		while (total > 21 && numAses > 0) {
			total -= 10;
			numAses--;
		}
		
		return total;
	}
	
	/**
	 * @Inherit
	 */
	public void vaciarMano() {
		mano.clear();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Carta> getMano() {
		return mano;
	}

	@Override
	public String toString() {
		return String.format("Jugador: %s\n Mano: %s",nombre, mano);
	}

	
	
	
	
	
}
