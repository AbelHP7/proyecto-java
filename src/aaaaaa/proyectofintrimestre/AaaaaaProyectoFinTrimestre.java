/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aaaaaa.proyectofintrimestre;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author usuario
 */
public class AaaaaaProyectoFinTrimestre {

    /**
     * @param args the command line arguments
     */
    
    
    
 
   
/**
 *
 * @author abelh
 */

public static void menuInicio( int[]opciones){
    Scanner sc = new Scanner(System.in);
   
    int opcion1;
    System.out.println("1.Continuar con controles predeterminados");
    System.out.println("2.Cambiar configuracion del juego");
    System.out.println("3.Terminar el juego");
    opcion1=sc.nextInt();
    switch(opcion1)
    {
      case 1:
        break;
      case 2:
        MenuDeOpciones(opciones);
        break;
      case 3:
        
        break;
      default:
        System.out.println("elige una opción correcta");    
    }
 } 

public static void MenuDeOpciones(int[]opciones){
    Scanner sc = new Scanner(System.in);
    System.out.println("1.Tamaño del tablero");
    System.out.println("2.Dificultad");
    System.out.println("3.Numero de errores");
    System.out.println("4.Tiempo de aparición");
    System.out.println("5.Zoom");
    System.out.println("6.Salir del juego");
    
    
int opcion2;
opcion2=sc.nextInt();

    switch(opcion2)
    {
  case 1:
   TamañoTablero(opciones);
    break;
  case 2:
   Dificultad();
    break;
  case 3:
   NumeroDeErrores();
    break;
  case 4:
    TiempoDeAparición();
    break;
  case 5:
    Zoom();
    break;
  case 6:
  
    break;
  default:
    System.out.println("Elige una opción correcta");    
    }
        
}
public static void TamañoTablero(int[]opciones)
{
    
   
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Introduce cuantas filas quieres");
    opciones[0] = sc.nextInt();
    System.out.println("Introduce cuantas columnas quieres");
    opciones[1] = sc.nextInt(); 
    
    
    
    
    
}






public static void Dificultad()
{
    Scanner sc = new Scanner(System.in);
}

public static void NumeroDeErrores()
{
    Scanner sc = new Scanner(System.in);
}

public static void TiempoDeAparición()
{
    Scanner sc = new Scanner(System.in);
}

public static void Zoom()
{
    Scanner sc = new Scanner(System.in);
}




    public static void main(String[] args) {
        System.out.println("¡Bienvenido al juego Memorión!");
        System.out.println("Ajustes:");
        int[]opciones={3,4,0,3,2000,1};
        int intentos = 0, parejasEncontradas = 0;
         
         
        //Llamamos al menu
        Scanner sc = new Scanner(System.in);
        menuInicio(opciones);
        String[][] tablero  = new String[opciones[0]][opciones[1]];
        boolean[][] descubiertas = new boolean[opciones[0]][opciones[1]];
        
        
        while (parejasEncontradas < (opciones[0] * opciones[1]) / 2) {
            mostrarTablero(tablero, descubiertas, opciones);

            System.out.println("Elige la primera celda (fila y columna):");
            int[] primeraCelda = obtenerCoordenadas(opciones);
            descubiertas[primeraCelda[0]][primeraCelda[1]] = true;

            mostrarTablero(tablero, descubiertas, opciones);

            System.out.println("Elige la segunda celda (fila y columna):");
            int[] segundaCelda = obtenerCoordenadas(opciones);
            descubiertas[segundaCelda[0]][segundaCelda[1]] = true;
                    
           //--- 
           
            if (tablero[primeraCelda[0]][primeraCelda[1]].equals(tablero[segundaCelda[0]][segundaCelda[1]])) {
                System.out.println("¡Pareja encontrada!");
                parejasEncontradas++;
            } else {
                System.out.println("No coinciden. Intenta nuevamente.");
                descubiertas[primeraCelda[0]][primeraCelda[1]] = false;
                descubiertas[segundaCelda[0]][segundaCelda[1]] = false;
                intentos++;
            }
        }

        System.out.println("¡Felicidades! Has encontrado todas las parejas.");
        System.out.println("Intentos totales: " + intentos);
    }

    
  
    
    
    
    // Mostrar el tablero al jugador
    public static void mostrarTablero(String[][] tablero, boolean[][] descubiertas,int[]opciones) {
       
        
        System.out.print("  | ");
        for (int c = 0; c <  tablero[0].length; c++)
        {
        System.out.print(" "+(c + 1) + " |");
        
        }
               System.out.println("");
       
        for (int f = 0; f < tablero.length; f++) 
        {
           for(int r=0;r<tablero[0].length;r++)
            {
                System.out.print("-----");               
            }
            System.out.println("");
            System.out.print((f + 1) + " | ");
                for (int c = 0; c < tablero[0].length; c++)
                {
                if (descubiertas[f][c]) 
                    {
                     System.out.print(tablero[f][c] + " ");
                    } 
                else
                    {
                        System.out.print(" * |");
                    }
                }

            System.out.println("");
           
        }
    }
    
    
    // Crear un tablero inicial con pares de letras
    public static String[][] crearTablero(int filas, int columnas) {
        String[][] tablero = new String[filas][columnas];
        char[] simbolos = generarSimbolos((filas * columnas) / 2);
        int indice = 0;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = String.valueOf(simbolos[indice / 2]);
                indice++;
            }
        }
        mezclarTablero(tablero);
                return tablero;
            }

    
    
        
        
        public static void mezclarTablero(String[][] tablero) {
        int filas = tablero.length;
        int columnas = tablero[0].length;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int filaAleatoria = (int) (Math.random() * filas);
                int columnaAleatoria = (int) (Math.random() * columnas);

                String temp = tablero[i][j];
                tablero[i][j] = tablero[filaAleatoria][columnaAleatoria];
                tablero[filaAleatoria][columnaAleatoria] = temp;
            }
        }
        }
    
    // Generar una lista de símbolos para las parejas
    public static String[] generarSimbolos(int numeroDePares) {
        String[] simbolos = new String[numeroDePares];
        char letra = 'A';
        for (int i = 0; i < numeroDePares; i++) {
            simbolos[i] = String.valueOf(letra);
            letra++;
        }
        return simbolos;
    }

    
    
    

   

    

    
    
    // Obtener coordenadas válidas del usuario
   public static int[] obtenerCoordenadas( int[] opciones) {
        Scanner sc = new Scanner(System.in);
        int fila, columna;
        while (true) {
            System.out.println("Introduce fila (1-" + opciones[0] + "):");
            fila = sc.nextInt() - 1;
            System.out.println("Introduce columna (1-" + opciones[1] + "):");
            columna = sc.nextInt() - 1;

            if (fila >= 0 && fila < opciones[0] && columna >= 0 && columna < opciones[1]) {
                return new int[]{fila, columna};
            } else {
                System.out.println("Coordenadas inválidas. Intenta de nuevo.");
            }
        }
   }
}

        
        
        
        
        
        
    

