package app;

public class Crupier extends Jugador {
	
	public Crupier() {
		super("Crupier");
	}
	
	public boolean debeRobar() {
		return calcularPuntuacion()<17;
	}
}
