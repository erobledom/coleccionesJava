package ejeHashMap.eje04;
import java.util.HashMap;
import java.util.Scanner;


public class Eliza {
	public static void main(String[] args) {
		
		var map = new HashMap <String, String> ();
		
		map.put("HOLA", "Hola que tal?");
		map.put("ENCANTADO", "Encantado de conocerte, yo tambien");
		map.put("ADIOS", "Adios espero volver a verte pronto");
		map.put("HORA", "Lo siento, no llevo reloj");
		map.put("NOMBRE", "Mi nombre es Eliza");
		map.put("CINCO", "Por el culo te la hinco jaja saludos");
		
		String msgDefault = "Lo siento, no te comprendo";
		
		Scanner sc = new Scanner(System.in);
		System.out.println(" Bienvenido al sistema Eliza 0.0: ");
		String frase;
		boolean fin = false;
		do {
			frase = sc.nextLine();
			for (String clave: map.keySet()) {
				boolean encontrada = false;
				if (frase.toUpperCase().contains(clave)) {
					encontrada = true;
					System.out.println(">"+map.get(clave));
					if (frase.toUpperCase().contains("ADIOS")) {
						fin = true;
					}
					break;
				}
			}
		} while(! fin);
			System.out.println(" Muchas gracias por conectarse");
		
		if (frase.toUpperCase().contains("HOLA")) {
			
		}
	}
}
