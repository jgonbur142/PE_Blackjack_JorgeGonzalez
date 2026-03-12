package app;

/**
 * Representa los palos de una baraja francesa.
 * Cada palo tiene un símbolo que lo representa de forma gráfica.
 */
public enum Palo {
	TREBOLES("♣"), DIAMANTES("♦"), CORAZONES("♥"), PICAS("♠");
	
	private final String simbolo;
	
	/**
	 * Constructor que asigna un símbolo con su palo
	 * @param simbolo gráfico del palo.
	 */
	Palo(String simbolo){
		this.simbolo=simbolo;
	}
	
	public String getSimbolo() {
		return simbolo;
	}
	
	@Override
	public String toString() {
		return simbolo;
	}
}
