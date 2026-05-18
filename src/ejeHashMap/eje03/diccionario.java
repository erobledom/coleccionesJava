package ejeHashMap.eje03;


/**
 * Write a description of class Ejercicio03 here.
 * 
 * Se presenta la solución más sencilla usando la libreria de Colecciones
 * 
 * @author (Alberto López) 
 * @version 
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class diccionario {

	public static void main(String argv[]) {

		HashMap<String, String> diccionario = new HashMap<String, String>();
		final int NUMPALABRAS = 5;

		// Relleno el diccionario
		diccionario.put("hola", "hello");
		diccionario.put("mesa", "table");
		diccionario.put("mientras", "while");
		diccionario.put("casa", "house");
		diccionario.put("sol", "sun");
		diccionario.put("luna", "moon");
		diccionario.put("ventana", "window");
		diccionario.put("lápiz", "pen");
		diccionario.put("ratón", "mouse");
		diccionario.put("abrir", "open");
		diccionario.put("cerrar", "close");
		diccionario.put("comer", "eat");
		diccionario.put("correr ", "run");
		diccionario.put("cantar ", "sing");
		diccionario.put("leer", "read");
		diccionario.put("escribir", "write");
		diccionario.put("tamaño", "size");
		diccionario.put("pantalla", "screen");
		diccionario.put("blanco", "white");
		diccionario.put("árbol", "tree ");

		// Creo en un ArrayList a partir de la lista de clave para poder acceder por
		// posición
		// Podemos crear una Colección a partir de otra aunque sean de distinto tipo
		

		ArrayList <String> listaseleccionadas = obtenerPalabras2(diccionario,NUMPALABRAS);
		

		System.out.println(" Indique cual es la traducción a inglés de la siguientes palabras:");
		Scanner sc = new Scanner(System.in);

		int puntos = 0;

		// A JUGAR
		for (int i = 0; i < NUMPALABRAS; i++) {

			String palabraEnEspañol = listaseleccionadas.get(i); // Palabra en español aleatoria
			System.out.print(palabraEnEspañol + " ? ");
			String palabraEnIngles = sc.next();
			String resu = diccionario.get(palabraEnEspañol);
			if (resu.contentEquals(palabraEnIngles)) {
				System.out.println("> Respuesta correcta.");
				puntos++;
			} else {
				System.out.println("> Error. La respuesta correcta es " + resu);
			}
		}

		System.out.println(" Has acertado " + puntos + " de cinco palabras.");

	}

	/*
	 * Devuelve una lista de tamaño indicado, con valores aleatorios en la lista
	 * pasada como parámetro Usando métodos de collections
	 */
	private static ArrayList <String> obtenerPalabras( HashMap<String, String> diccionario, int num){
		
		// Copio la lista de palabras en español (clave)
		List <String> completa = new ArrayList <String>(diccionario.keySet());
		
		// Reordena al azar
	    Collections.shuffle(completa);   
	 
	    // No puedo seleccionar mas de las que tengo
		if (num > diccionario.size()) num = diccionario.size(); 
		
	    // Creo un array List con solo num elementos
	    var seleccionados = new ArrayList <String>(completa.subList(0, num));
		
	    return seleccionados;
	}
	
	
	/*
	 * Devuelve una lista de tamaño indicado, con valores aleatorios en la lista
	 * pasada como parámetro
	 * Programada directamente
	 */

	private static ArrayList<String> obtenerPalabras2( HashMap<String, String> diccionario, int num) {

		// Obtengo la lista de palabras en español
		
		var lista = new ArrayList<String>(diccionario.keySet());
		var seleccionadas = new ArrayList<String>();

		// No puedo seleccionar mas de las que tengo
		if (num > diccionario.size()) num = diccionario.size(); 
				
		
		for (int i = 0; i < num; i++) {
			String palabraEnEspañol;
			// Busco una palabra al azar que no esté en la lista de palabras nueva
			boolean repetida = true;
			do {
				// Posición al azar
				int index = (int) (Math.random() * lista.size());
				palabraEnEspañol = lista.get(index);
				// Si no sido utilizada
				if (!seleccionadas.contains(palabraEnEspañol)) {
					repetida = false;
				}

			} while (repetida);
			// Añado la palabra a preguntas
			seleccionadas.add(palabraEnEspañol);
		}
		return seleccionadas;

	}

}