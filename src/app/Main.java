package app;

public class Main {
	
	public void encender() {
		MenuInicio menu = new MenuInicio();
		menu.iniciar();
	}
	
	public static void main(String[] args) {
		new Main().encender();
	}
}
