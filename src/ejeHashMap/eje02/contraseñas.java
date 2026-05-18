package ejeHashMap.eje02;

/**
d* Ejercicio Nº 2 
* 
* Implementa el control de acceso al área restringida de un programa.
* Se debe pedir un nombre de usuario y una contraseña. Si el usuario
* introduce los datos correctamente, el programa dirá “Ha accedido al área restringida”.
* El usuario tendrá un máximo de 3 oportunidades.
* Si se agotan las oportunidades el programa dirá
* “Lo siento, no tiene acceso al área restringida”.
* Los nombres de usuario con sus correspondientes contraseñas deben estar
* almacenados en una estructura de la clase HashMap.
*
* @author (Alberto López) 
* @version (24/04/2018)
*/
import java.util.HashMap;
import javax.swing.JOptionPane;

public class contraseñas {
    public static void main(String[] args) {

        HashMap<String, String> thAcceso = new HashMap<>();

        final int NUM_INTENTOS_MAX = 3;
        int intentos = 0;

        thAcceso.put("admin", "admin");
        thAcceso.put("maria", "1234");
        thAcceso.put("root", "root");

        boolean acceso = false;

        do {
            String usuario = JOptionPane.showInputDialog("Usuario:");
            String clave = JOptionPane.showInputDialog("Contraseña:");

            if (!thAcceso.containsKey(usuario)) {
                JOptionPane.showMessageDialog(null, "El usuario no existe", "Información",
                        JOptionPane.WARNING_MESSAGE);
            } else if (thAcceso.get(usuario).equals(clave)) {
                acceso = true;
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Información",
                        JOptionPane.WARNING_MESSAGE);
            }

            intentos++;

        } while (!acceso && intentos < NUM_INTENTOS_MAX);

        if (acceso) {
            JOptionPane.showMessageDialog(null, "Acceso concedido", "Información",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Superado número máximo de intentos", "Información",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
