package app;

public class Carta {
	private final Numero numero;
	private final Palo palo;
	
	public Carta(Numero numero, Palo palo) {
		this.numero = numero;
		this.palo = palo;
	}

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
