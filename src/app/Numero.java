package app;

public enum Numero {
	AS(11),
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
	
	private final int VALUE;
	
	Numero(int VALUE) {
		this.VALUE=VALUE;
	}

	
	
	public int getValue() {
		return VALUE;
	}
}
