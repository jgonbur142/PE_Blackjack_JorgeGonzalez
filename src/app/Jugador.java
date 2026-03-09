package app;

import java.util.ArrayList;
import java.util.List;

public class Jugador implements IJugador {
	
	private String nombre;
	private List<Carta> mano;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.mano = new ArrayList<>();
	}
	
	/**
	 * El jugador roba una carta
	 * @param carta
	 */
	public void robarCarta(Carta carta) {
		if (carta != null) {
			mano.add(carta);
		}
	}
	
	/**
	 * Se calcula el valor de cada carta individual y se suma, se guarda si la carta es un As para reajustar la puntuación.
	 * @return 
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
	 * Deja la mano actual sin cartas.
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
