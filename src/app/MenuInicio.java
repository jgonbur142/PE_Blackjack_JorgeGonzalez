package app;

public class MenuInicio {
	private Consola consola;
	
	public MenuInicio() {
		this.consola = new Consola();
	}
	
	/**
	 * Inicia el menú y lo muestra por consola
	 */
	public void iniciar() {
		String opcion="";
		
		do {
			mostrarLogo();
			consola.mostrarMensaje("------------");
			consola.mostrarMensaje("- 1. Jugar -");
			consola.mostrarMensaje("- 2. Salir -");
			consola.mostrarMensaje("------------");
			
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
