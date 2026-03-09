package app;

public enum Palo {
	TREBOLES("♣"), DIAMANTES("♦"), CORAZONES("♥"), PICAS("♠");
	
	private final String simbolo;
	
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
