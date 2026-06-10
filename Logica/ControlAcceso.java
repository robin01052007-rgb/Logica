import java.util.Scanner;

public class ControlAcceso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatronAcceso patronCorrecto = new PatronAcceso();
        ValidacionPatron validador = new ValidacionPatron();
        
        int intentosRestantes = 3;

        while (intentosRestantes > 0) {
            System.out.println("Ingrese la contraseña (Intentos restantes: " + intentosRestantes + "):");
            int entrada = sc.nextInt();

            IntentoAcceso nuevoIntento = new IntentoAcceso(entrada);
            if (validador.esValido(patronCorrecto, nuevoIntento)) {
                System.out.println("Acceso concedido, Contraseña correcta.");
                break;
            } else {
                intentosRestantes--;
                System.out.println("Contrasena incorrecta.");
            }
        }

        if (intentosRestantes == 0) {
            System.out.println("Sistema bloqueado. Demasiados intentos fallidos.");
        }
        
        sc.close();
    }
}