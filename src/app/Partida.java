package app;

/**
 * Gestiona e flujo de la partida.
 * Controla el reparto de cartas, los turnos del jugador y del crupier, y determina el ganador de la partida.
 */
public class Partida {
	
	private Baraja baraja;
	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador crupier;
	private Consola consola;
	private int ronda;
	
	/**
	 * Inicializa los componentes necesarios para empezar a jugar.
	 * Baraja, consola y jugadores.
	 */
	public Partida() {
		this.baraja = new Baraja();
		this.consola = new Consola();
		this.jugador1 = new Jugador("Jugador 1");
		this.jugador2 = new Jugador("Jugador 2");
		this.crupier = new Jugador("Crupier");
		this.ronda=1;
	}
	
	/**
	 * Marca el flujo de vida de una partida.
	 * Preparación, reparto de cartas, turnos y resultado.
	 */
	public void iniciar() {
		jugador1.vaciarMano();
		jugador2.vaciarMano();
		crupier.vaciarMano();
		
		String nombreJ1, nombreJ2;
		
		consola.mostrarMensaje("----- PARTIDA INICIADA -----");
		baraja.barajar();
		consola.mostrarMensaje("----- MAZO BARAJADO -----");
		
		consola.mostrarMensaje("Introduce el nombre del Jugador 1:");
		nombreJ1 = consola.leerEntrada();
		jugador1.setNombre(nombreJ1);
		consola.mostrarMensaje("Bienvenido "+jugador1.getNombre()+".");
		
		consola.mostrarMensaje("Introduce el nombre del Jugador 2:");
		nombreJ2 = consola.leerEntrada();
		jugador2.setNombre(nombreJ2);
		consola.mostrarMensaje("Bienvenido "+jugador1.getNombre()+".");
		
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
		consola.mostrarMensaje("-----ESTADO DE LA MESA: RONDA "+ronda+"-----");
		
		consola.mostrarMensaje("Crupier: ");
		consola.mostrarMensaje(crupier.getMano().toString());
		consola.mostrarMensaje("Puntuación: "+crupier.calcularPuntuacion());
		consola.mostrarMensaje("");
		
		consola.mostrarMensaje(jugador1.getNombre()+":");
		consola.mostrarMensaje(jugador1.getMano().toString());
		
		consola.mostrarMensaje("Puntuación: "+jugador1.calcularPuntuacion());
		
		consola.mostrarMensaje("------------------------------");
		consola.mostrarMensaje("");
		
		consola.mostrarMensaje(jugador2.getNombre()+":");
		consola.mostrarMensaje(jugador2.getMano().toString());
		
		consola.mostrarMensaje("Puntuación: "+jugador2.calcularPuntuacion());
		
		consola.mostrarMensaje("------------------------------");
		consola.mostrarMensaje("");
	}
	
	/**
	 * Se encarga de repartir las cartas iniciales a cada jugador.
	 */
	private void repartirCartas() {
		jugador1.robarCarta(baraja.darCarta());
		jugador2.robarCarta(baraja.darCarta());
		crupier.robarCarta(baraja.darCarta());
		jugador1.robarCarta(baraja.darCarta());
		jugador2.robarCarta(baraja.darCarta());
		crupier.robarCarta(baraja.darCarta());
	}
	
	/**
	 * Gestiona el turno de los usuarios, permitiendo pedir carta o plantarse.
	 * Se pregunta por separado a cada jugador y se les reparte carta a la vez.
	 * Cuando la puntuación supera 21, no se juegan más turnos.
	 */
	private void jugarTurno() {
		boolean J1QuiereCarta = true, J2QuiereCarta = true;
		
		while (J1QuiereCarta || J2QuiereCarta) {
			mostrarEstado();
			
			 boolean pregunta;
			 
			 if (J1QuiereCarta && jugador1.calcularPuntuacion()<21) {
				 consola.mostrarMensaje(jugador1.getNombre()+", ¿Quieres robar carta? (S/N)");
				 pregunta = consola.leerOpcion('S', 'N');
				 if (!pregunta) {
					 J1QuiereCarta = false;
				 }
			 }else {
				 J1QuiereCarta = false;
			 }
			 
			 if (J2QuiereCarta && jugador2.calcularPuntuacion()<21) {
				 consola.mostrarMensaje(jugador2.getNombre()+", ¿Quieres robar carta? (S/N)");
				 pregunta = consola.leerOpcion('S', 'N');
				 if (!pregunta) {
					 J2QuiereCarta = false;
				 }
			 }else {
				 J2QuiereCarta = false;
			 }
			 
			 if (J1QuiereCarta) {
				 jugador1.robarCarta(baraja.darCarta());
			 }
			 if (J2QuiereCarta) {
				 jugador2.robarCarta(baraja.darCarta());
			 }
			 
			 ronda++;
			
		}
		
		mostrarEstado();
		
	}
	
	/**
	 * Gestiona el turno del crupier, decide si pedir carta o no según {@link calcularPuntuacion()}.
	 * Cuando la puntuación supera 17, no pide más cartas.
	 */
	private void jugarCrupier() {
		consola.mostrarMensaje("");
		consola.mostrarMensaje("-----TURNO DEL CRUPIER: Ronda "+ronda+"-----");
		while (crupier.calcularPuntuacion()<17) {
			crupier.robarCarta(baraja.darCarta());
		}
		consola.mostrarMensaje("Mano del crupier: "+crupier.getMano());
		consola.mostrarMensaje("Puntuación crupier: "+crupier.calcularPuntuacion());
	}
	
	/**
	 * Compara las puntuaciones de los jugadores y decide el resultado de la partida.
	 * Primero compara la puntuación de los dos jugadores. 
	 * Después compara la del ganador de entre estos dos con la del crupier.
	 */
	private void resultado() {
		int puntJ1 = jugador1.calcularPuntuacion();
		int puntJ2 = jugador2.calcularPuntuacion();
		int puntCrupier = crupier.calcularPuntuacion();
		
		int puntJSuperior=0;
		String jugadorSuperior="";
		boolean empateJugadores = false;
		
		mostrarResultado(puntJ1, puntJ2, puntCrupier);		
		
		if (puntJ1 <= 21 && (puntJ1 > puntJ2 || puntJ2 > 21)) {
			jugadorSuperior = jugador1.getNombre();
			puntJSuperior = puntJ1;
		}else if (puntJ2 <= 21){
			jugadorSuperior = jugador2.getNombre();
			puntJSuperior = puntJ2;
		}else if (puntJ2 <=21 && puntJ1 <=21 && puntJ2==puntJ1) {
			empateJugadores = true;
		}
		
		if (empateJugadores) {
			if (puntCrupier>21 || puntJ1 > puntCrupier) {
				consola.mostrarMensaje("Empate entre ambos jugadores, pero ganan al crupier en puntos.");
			}else if (puntCrupier<=21 && puntCrupier>puntJ1){
				consola.mostrarMensaje("Empate entre ambos jugadores, pero el crupier gana por puntos.");
			}else {
				consola.mostrarMensaje("Empate entre ambos jugadores y el crupier.");
			}
		}else {
			if (puntJSuperior == 0 && puntCrupier<=21) {
				consola.mostrarMensaje("Ambos jugadores se han pasado. Gana el crupier.");
			}else if(puntJSuperior == 0 && puntCrupier>21) {
				consola.mostrarMensaje("Ambos jugadores y el crupier se han pasado, todos pierden.");
			}else if(puntCrupier>21 || puntJSuperior > puntCrupier) {
				consola.mostrarMensaje("La victoria es para "+jugadorSuperior+", ¡Felicidades!");
			}else if(puntCrupier<=21 && puntCrupier>puntJSuperior) {
				consola.mostrarMensaje("La victoria es para el crupier.");
			}else {
				consola.mostrarMensaje("Empate entre "+puntJSuperior+" y el crupier.");
			}
		}
		
		
	}
	
	/**
	 * Muestra la pantalla final con las puntuaciones finales y el resultado de la partida
	 * @param puntJ1 Puntuación final del jugador 1
	 * @param puntJ2 Puntuación final del jugador 2
	 * @param puntCrupier Puntuacón final del crupier
	 */
	private void mostrarResultado(int puntJ1, int puntJ2, int puntCrupier) {
		consola.mostrarMensaje("");
		consola.mostrarMensaje("----- RESULTADOS: -----");
		consola.mostrarMensaje(jugador1.getNombre()+": "+puntJ1);
		consola.mostrarMensaje(jugador2.getNombre()+": "+puntJ2);
		consola.mostrarMensaje("Crupier: "+puntCrupier);
		consola.mostrarMensaje("------------------------");
		consola.mostrarMensaje("");
	}
	
	
}
