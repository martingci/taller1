import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        jugarMenu();
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
                inicioJuego();
                break;
            default:
                System.out.println("Cerrando programa");
        }
    }
    public static void jugarMenu() {
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
    public static String [][] crearMatrizCartas () {
        return (new String [12][2]);
    }
    public static void inicioJuego() {
        String [][] cards = crearMatrizCartas();
        cards = inicializarCartasJuego(cards);
        int jugador1 = obtenerCartas(cards);
        System.out.println(jugador1);


    }
    public static String [][] agregarCartas (String [][] matriz, String nombre, String valor) {
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] == null) {
                matriz[i][0] = nombre;
                matriz[i][1] = valor;
                break;
            }
        }
        return matriz;
    }
    public static String [][] inicializarCartasJuego(String [][] matriz) {
        matriz = agregarCartas(matriz, "As", "11");
        matriz = agregarCartas(matriz, "2", "2");
        matriz = agregarCartas(matriz, "3", "3");
        matriz = agregarCartas(matriz, "4", "4");
        matriz = agregarCartas(matriz, "5", "5");
        matriz = agregarCartas(matriz, "6", "6");
        matriz = agregarCartas(matriz, "7", "7");
        matriz = agregarCartas(matriz, "8", "8");
        matriz = agregarCartas(matriz, "9", "9");
        matriz = agregarCartas(matriz, "Jota", "10");
        matriz = agregarCartas(matriz, "Reina", "10");
        matriz = agregarCartas(matriz, "Rey", "10");
        return matriz;
    }
    public static int obtenerCartas (String [][] matriz) {
        Random random = new Random();
        int suma = 0;
        for (int i = 0; i < 3; i++) {
            int numeroAleatorio = random.nextInt(12);
            System.out.println("Usted ha sacado "+matriz[numeroAleatorio][0]);
            suma += Integer.parseInt(matriz[numeroAleatorio][1]);
        }
        return suma;
    }
}
