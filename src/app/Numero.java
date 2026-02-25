package app;

public enum Numero {
	UNO(1),
	DOS(2),
	TRES(3),
	CUATRO(4),
	CINCO(5),
	SEIS(6),
	SIETE(7),
	OCHO(8),
	NUEVE(9),
	DIEZ(10),
	SOTA(10),
	CABALLO(10),
	REY(10);
	
	Numero(int value) {
		this.value=value;
	}

	private final int value;
	
	public int getValue() {
		return value;
	}
}
