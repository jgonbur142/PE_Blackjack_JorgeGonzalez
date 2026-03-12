package app;

/**
 * Gestiona e flujo de la partida.
 * Controla el reparto de cartas, los turnos del jugador y del crupier, y determina el ganador de la partida.
 */
public class Partida {
	
	private Baraja baraja;
	private Jugador jugador;
	private Jugador crupier;
	private Consola consola;
	
	/**
	 * Inicializa los componentes necesarios para empezar a jugar.
	 * Baraja, consola y jugadores.
	 */
	public Partida() {
		this.baraja = new Baraja();
		this.consola = new Consola();
		this.jugador = new Jugador("Jugador 1");
		this.crupier = new Jugador("Crupier");
	}
	
	/**
	 * Marca el flujo de vida de una partida.
	 * Preparación, reparto de cartas, turnos y resultado.
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
	
	/**
	 * Muestra el estado de la mesa en cada turno.
	 * Es llamado por {@link jugarTurno()} cada iteración hasta que termina la partida.
	 */
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
	 * Se encarga de repartir las cartas iniciales a cada jugador.
	 */
	private void repartirCartas() {
		jugador.robarCarta(baraja.darCarta());
		crupier.robarCarta(baraja.darCarta());
		jugador.robarCarta(baraja.darCarta());
		crupier.robarCarta(baraja.darCarta());
	}
	
	/**
	 * Gestiona el turno del usuario, permitiendo pedir carta o plantarse.
	 * Cuando la puntuación supera 21, no se juegan más turnos.
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
	 * Gestiona el turno del crupier, decide si pedir carta o no según {@link calcularPuntuacion()}.
	 * Cuando la puntuación supera 17, no pide más cartas.
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
