package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Representación de una baraja de cartas francesa
 * Se encarga de crear, mezclar y dar las cartas de la baraja 
 */
public class Baraja {
	
	
	private List<Carta> cartas;
	
	/**
	 * Constructor que inicializa la lista de cartas y genera la baraja
	 */
	public Baraja() {
		this.cartas = new ArrayList<>();
		crearBaraja();
	}

	/**
	 * Genera la baraja al completo (4 palos * 13 Números = 52 cartas)
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
	 * @return La primera {@link Carta} de la lista.
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
