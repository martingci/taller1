import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        jugar();
    }
    public static int userOption(String text) {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        boolean opcionValida = false;
        System.out.print(text + " ");
        while (!opcionValida) {
            try {
                option = scanner.nextInt();
                opcionValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Por favor ingrese un número entero.");
                scanner.next();
            }
        }
        return option;
    }
    public static void optionElection(int option) {
        switch (option) {
            case 1:
                System.out.println("Has seleccionado la opción 1");
                break;
            default:
                System.out.println("Cerrando programa");
        }
    }
    public static void jugar() {
        int opcion;
        do {
            elections();
            opcion = userOption("Seleccione una opción (0 para salir)");
            optionElection(opcion);
        } while (opcion != 0);
    }
    public static void elections() {
        System.out.println("1. Jugar");
        System.out.println("0. Salir");
    }
}
