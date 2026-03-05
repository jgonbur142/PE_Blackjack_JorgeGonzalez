package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baraja {
	
	private List<Carta> cartas;
	
	public Baraja() {
		this.cartas = new ArrayList<>();
		crearBaraja();
	}

	/**
	 * El constructor de la baraja ya crea automáticamente la baraja
	 */
	private void crearBaraja() {
		for (Palo p : Palo.values()) {
			for (Numero n : Numero.values()) {
				cartas.add(new Carta(n,p));
			}
		}
	}
	
	/**
	 * Coge todas las cartas dentro del ArrayList y las mezcla
	 */
	public void barajar() {
		Collections.shuffle(cartas);
	}
	
	/**
	 * "Levanta" la primera carta de la baraja, si no quedan cartas crea una baraja nueva
	 * @return
	 */
	public Carta darCarta() {
		if(cartas.isEmpty()) {
			Baraja nuevaBaraja = new Baraja();
			return nuevaBaraja.cartas.remove(0);
		}
		return cartas.remove(0);
	}
	
	
	public List<Carta> getCartas() {
		return cartas;
	}
}
