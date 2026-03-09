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
		jugador.vaciarMano();
		crupier.vaciarMano();
		
		String nombreJugador;
		
		consola.mostrarMensaje("----- PARTIDA INICIADA -----");
		baraja.barajar();
		consola.mostrarMensaje("----- MAZO BARAJADO -----");
		
		consola.mostrarMensaje("Introduce el nombre del Jugador:");
		nombreJugador = consola.leerEntrada();
		jugador.setNombre(nombreJugador);
		consola.mostrarMensaje("Bienvenido "+jugador.getNombre()+".");
		
		repartirCartas();
		jugarTurno();	
		jugarCrupier();
		resultado();
	}
	
	private void mostrarEstado() {
		consola.mostrarMensaje("");
		consola.mostrarMensaje("-----ESTADO DE LA MESA: -----");
		
		consola.mostrarMensaje("Crupier: ");
		consola.mostrarMensaje(crupier.getMano().toString());
		consola.mostrarMensaje("Puntuación: "+crupier.calcularPuntuacion());
		consola.mostrarMensaje("");
		
		consola.mostrarMensaje(jugador.getNombre()+":");
		consola.mostrarMensaje(jugador.getMano().toString());
		
		consola.mostrarMensaje("Puntuación: "+jugador.calcularPuntuacion());
		
		consola.mostrarMensaje("------------------------------");
		consola.mostrarMensaje("");
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
		Carta nueva;
		
		while (quiereCarta && jugador.calcularPuntuacion()<21) {
			
			mostrarEstado();
			
			consola.mostrarMensaje("¿Quieres otra carta? (S/N)");
			quiereCarta = consola.leerOpcion('S', 'N');
			
			if (quiereCarta) {
				nueva = baraja.darCarta();
				jugador.robarCarta(nueva);
				consola.mostrarMensaje("Carta robada: "+nueva);
				
			}
		}
		mostrarEstado();
	}
	
	/**
	 * Se encarga de la lógica del turno del crupier, juega de forma automática
	 */
	private void jugarCrupier() {
		consola.mostrarMensaje("");
		consola.mostrarMensaje("-----TURNO DEL CRUPIER-----");
		while (crupier.calcularPuntuacion()<17) {
			crupier.robarCarta(baraja.darCarta());
		}
		consola.mostrarMensaje("Mano del crupier: "+crupier.getMano());
		consola.mostrarMensaje("Puntuación crupier: "+crupier.calcularPuntuacion());
	}
	
	/**
	 * Compara las puntuaciones de los jugadores y decide el resultado de la partida.
	 */
	private void resultado() {
		int puntJugador = jugador.calcularPuntuacion();
		int puntCrupier = crupier.calcularPuntuacion();
		
		consola.mostrarMensaje("");
		consola.mostrarMensaje("----- RESULTADOS: -----");
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
