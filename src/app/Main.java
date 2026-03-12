package app;

/**
 * Actúa como punto de inicio para la aplicación.
 * Instancia el menú de inicio del juego y arranca el flujo del programa.
 */
public class Main {

	/**
	 * Crea una instancia del menú e inicia la partida.
	 */
	public void encender() {
		MenuInicio menu = new MenuInicio();
		menu.iniciar();
	}
	
	public static void main(String[] args) {
		new Main().encender();
	}
}
