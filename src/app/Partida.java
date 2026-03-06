package app;

public class Partida {
	
	private Baraja baraja;
	private Jugador jugador;
	private Jugador crupier;
	private Consola consola;
	
	public Partida() {
		this.baraja = new Baraja();
		this.consola = new Consola();
		this.jugador = new Jugador("Jugador 1");
		this.crupier = new Jugador("Crupier");
	}
	
	/**
	 * Se encarga de montar el flujo de la partida
	 */
	public void iniciar() {
		String nombreJugador;
		
		consola.mostrarMensaje("----- Partida iniciada -----");
		baraja.barajar();
		consola.mostrarMensaje("----- Mazo barajado -----");
		
		consola.mostrarMensaje("Introduce el nombre del Jugador:");
		nombreJugador = consola.leerEntrada();
		jugador.setNombre(nombreJugador);
		consola.mostrarMensaje("Bienvenido "+jugador.getNombre()+".");
		
		repartirCartas();
		jugarTurno();	
		jugarCrupier();
		resultado();
	}
	
	/**
	 * Reparte dos cartas a cada jugador para empezar la partida
	 */
	private void repartirCartas() {
		jugador.robarCarta(baraja.darCarta());
		crupier.robarCarta(baraja.darCarta());
		jugador.robarCarta(baraja.darCarta());
		crupier.robarCarta(baraja.darCarta());
	}
	
	/**
	 * Se encarga de la lógica del turno del jugador
	 */
	private void jugarTurno() {
		boolean quiereCarta = true;
		while (quiereCarta && jugador.calcularPuntuacion()<21) {
			consola.mostrarMensaje("Turno de "+jugador.toString());
			consola.mostrarMensaje("Puntuación: "+jugador.calcularPuntuacion());
			
			consola.mostrarMensaje("¿Quieres otra carta? (S/N)");
			quiereCarta = consola.leerOpcion('S', 'N');
			
			if (quiereCarta) {
				jugador.robarCarta(baraja.darCarta());
			}
		}
	}
	
	/**
	 * Se encarga de la lógica del turno del crupier, juega de forma automática
	 */
	private void jugarCrupier() {
		consola.mostrarMensaje("Turno del crupier");
		while (crupier.calcularPuntuacion()<17) {
			crupier.robarCarta(baraja.darCarta());
		}
		consola.mostrarMensaje(crupier.toString());
	}
	
	/**
	 * Compara las puntuaciones de los jugadores y decide el resultado de la partida.
	 */
	private void resultado() {
		int puntJugador = jugador.calcularPuntuacion();
		int puntCrupier = crupier.calcularPuntuacion();
		
		consola.mostrarMensaje("----- Resultados: -----");
		if (puntJugador>21) {
			consola.mostrarMensaje("Te has pasado de 21. Gana el crupier.");
		}else if(puntCrupier>21 || puntJugador > puntCrupier) {
			consola.mostrarMensaje("La victoria es para "+jugador.getNombre()+", ¡Felicidades!");
		}else if(puntCrupier>puntJugador) {
			consola.mostrarMensaje("La victoria es para el crupier.");
		}else {
			consola.mostrarMensaje("Empate");
		}
	}
	
}
