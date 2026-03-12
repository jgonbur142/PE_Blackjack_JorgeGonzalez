package app;

/**
 * Se encarga de gestionar el menú principal del juego.
 * Permite elegir entre iniciar una partida o salir de la aplicación.
 */
public class MenuInicio {
	
	private Consola consola;
	
	/**
	 * Constructor que inicializa la consola para el menú.
	 */
	public MenuInicio() {
		this.consola = new Consola();
	}
	
	/**
	 * Gestiona el bucle principal del menú.
	 * Muestra las opciones del usuario y procesa la entrada por consola del mismo.
	 * El bucle se detiene cuando el usuario elige salir del programa.
	 */
	public void iniciar() {
		String opcion="";
		
		do {
			consola.mostrarMensaje("");
			mostrarLogo();
			consola.mostrarMensaje("------------");
			consola.mostrarMensaje("- 1. Jugar -");
			consola.mostrarMensaje("- 2. Salir -");
			consola.mostrarMensaje("------------");
			consola.mostrarMensaje("");
			
			opcion = consola.leerEntrada();
			
			switch (opcion) {
				case "1" ->{
					Partida partida = new Partida();
					partida.iniciar();
				}
				case "2" ->{
					consola.mostrarMensaje("Saliendo...");
				}
				default -> consola.mostrarMensaje("Opción no válida");
			}
		}while (!opcion.equals("2"));
		
	}
	
	/**
	 * Muestra el Título del juego por consola
	 */
	private void mostrarLogo() {
		consola.mostrarMensaje("----------------------------------");
		consola.mostrarMensaje("             Blackjack            ");
		consola.mostrarMensaje("Jorge González Burgos - 1ºDAM");
		consola.mostrarMensaje("----------------------------------");
	}
}
