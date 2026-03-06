package app;

import java.util.Scanner;

public class Consola {

	private Scanner teclado = new Scanner(System.in);
	
	/**
	 * Lee la cadena introducida por el usuario
	 * @return
	 */
	public String leerEntrada() {// devuelve una cadena de caracteres
		return teclado.nextLine();
	}
	
	/**
	 * Lee la opción introducida por el usuario y devuelve true si coincide con affirmativeValue y false si coincide con negativeValue 
	 * 
	 * @param affirmativeValue
	 * @param negativeValue
	 * @return
	 */
	public boolean leerOpcion(char affirmativeValue, char negativeValue) {// devuelve un booleano de forma que: [coincide con affirmativeValue -> true | coincide con negativeValue -> false]
		char input;
		
		do {
			input= Character.toLowerCase(leerCaracter());
			char aff = Character.toLowerCase(affirmativeValue);
			char neg = Character.toLowerCase(negativeValue);
			if(input != aff && input != neg) {
				System.err.printf("Error: Por favor, introduce '%c' para afirmar y '%c' para negar\n",affirmativeValue,negativeValue);
			}
		}while(input!=Character.toLowerCase(affirmativeValue) && input!=Character.toLowerCase(negativeValue));
		
		return input == Character.toLowerCase(affirmativeValue);
	}
	
	/**
	 * Lee un caracter introducido por el usuario, controla que sea un solo caracter.
	 * @return
	 */
	private char leerCaracter() {
		String input;
		
		do {
			input=teclado.nextLine();
			if(input.length()!=1) {
				System.err.println("Error: Introduce un solo carácter");
			}
		}while(input.length()!=1);
		
		return input.charAt(0);
	}
	
	/**
	 * Muestra por consola el mensaje que recibe por parámetro
	 * @param mensaje
	 */
	public void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
}
