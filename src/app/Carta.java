package app;
/**
 * Representa una carta individual.
 * Cada carta tiene un número y un palo.
 */
public class Carta {
	
	private final Numero numero;
	private final Palo palo;
	
	/**
	 * Crea una carta y le da un numero y palo en concreto
	 * @param numero El valor de la carta
	 * @param palo El palo de la carta
	 */
	public Carta(Numero numero, Palo palo) {
		this.numero = numero;
		this.palo = palo;
	}

	/**
	 * Obtiene el valor numérico de la carta
	 * @return Valor entero de la carta.
	 */
	public int valorCarta() {
		return numero.getValor();
	}
	
	public Numero getNumero() {
		return numero;
	}

	public Palo getPalo() {
		return palo;
	}

	@Override
	public String toString() {
		return String.format("%s %s",numero,palo);
	}
	
	
	
	
}
