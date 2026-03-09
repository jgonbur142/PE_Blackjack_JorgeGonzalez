package app;

public enum Numero {
	AS("A",11),
	DOS("2",2),
	TRES("3",3),
	CUATRO("4",4),
	CINCO("5",5),
	SEIS("6",6),
	SIETE("7",7),
	OCHO("8",8),
	NUEVE("9",9),
	DIEZ("10",10),
	SOTA("J",10),
	CABALLO("Q",10),
	REY("K",10);
	
	private final String simbolo;
	private final int valor;	
	
	Numero(String simbolo, int valor) {
		this.simbolo=simbolo;
		this.valor=valor;
	}
	
	public int getValor() {
		return valor;
	}
	
	public String getSimbolo() {
		return simbolo;
	}
	
	@Override
	public String toString() {
		return simbolo;
	}
}
