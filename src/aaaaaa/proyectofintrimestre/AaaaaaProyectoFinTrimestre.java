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
    



public static boolean menuInicio( int[]opciones){
    Scanner sc = new Scanner(System.in);
    int opcion1;
    
    boolean salirMenu = true;   
    while(salirMenu==true){
        System.out.println("Menu Inicial");
        System.out.println("1. Continuar con controles predeterminados");
        System.out.println("2. Cambiar configuración del juego");
        System.out.println("3. Terminar el juego");
       
         opcion1 = sc.nextInt();
     
    
         switch (opcion1) {
            case 1:
                 MecanismoDeJuego(opciones);
                break;
            case 2:
                MenuDeOpciones(opciones);
                break;
            case 3:
                salirMenu=false;
                System.out.println("Juego terminado.");
                break;
            default:
                    
                System.out.println("Elige una opción correcta.");
            }
    }
    return salirMenu;
}

//Menu para elegir las opciones modificadas del usuario
public static void MenuDeOpciones(int[]opciones)
    {
        boolean salida=true;
        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("1.Tamaño del tablero");
            System.out.println("2.Dificultad");
            System.out.println("3.Numero de errores");
            System.out.println("4.Tiempo de aparición");
            System.out.println("5.Zoom");
            System.out.println("6.Jugar");


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
                NumeroDeErrores(opciones);
                break;
            case 4:
                TiempoDeAparición(opciones);
                break;
            case 5:
                Zoom();
                break;
            case 6:
                salida=false;
                break;
            default:
              System.out.println("Elige una opción correcta");    

              }
            }while(salida==true);
        }

public static void TamañoTablero(int[]opciones)
{
    Scanner sc = new Scanner(System.in);
   
    System.out.println("Introduce cuantas filas quieres");
    opciones[0] = sc.nextInt();
    System.out.println("Introduce cuantas columnas quieres");
    opciones[1] = sc.nextInt();    
    limpiarPantalla();
}






public static void Dificultad()
    {
        Scanner sc = new Scanner(System.in);
    }

public static void NumeroDeErrores(int[]opciones)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Tienes un margen de 6 errores");
        System.out.println("Cuantos intentos quieres tener");
        System.out.println("Nota: como maximo tienes 12 intentos");
        
        opciones[6]=sc.nextInt();
        limpiarPantalla();
    }

public static void TiempoDeAparición(int[]opciones)
    {
        Scanner sc = new Scanner(System.in);

        int TiempoDeAparicion;
        System.out.println("Cuantos milesegundos quieres que aparezca(0-4000)");
        System.out.println("Nota: 1000 milesegundos es igual a 1 segundo");
        
        opciones[4]=sc.nextInt();
        while(opciones[4]>=5000)
        {
            System.out.println("Uy ,es demasiado tiempo ");
            System.out.println("¡Cambialo!");
            opciones[4]=sc.nextInt();
            limpiarPantalla();
        }
    }

public static void Zoom()
    {
        Scanner sc = new Scanner(System.in);
    }

//Limpia la pantalla
public static void limpiarPantalla()
{
    try
    {
        String sistemaOperativo=System.getProperty("os.name").toLowerCase();//Mira que sistema operativo es y ponerlo en minuscula porque en el sistema puede estar escrito de otra manera
        //Si es en windows
        if(sistemaOperativo.contains("win"))
        {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        //Si es Unix/Linux/Mac
        else
        {
            System.out.print("\033[H\033[2J");  
            System.out.flush();
        }
    }
    catch(Exception e)
    {
        System.out.println("Error al limpiar la pantalla: "+ e.getMessage());
    }
}



public static void main(String[] args)
    {
        System.out.println("¡Bienvenido al juego Memorión!");
        int[]opciones={3,4,0,3,1000,1,6};
        
         
        Scanner sc = new Scanner(System.in);
        //Llamamos al menu de inicio
        menuInicio(opciones);
        boolean salida=true;
        menuInicio(opciones);
        salida=menuInicio(opciones);
        while(salida==true)
        {
        
        MecanismoDeJuego(opciones);    
        }
        
        
        
        
        
    
  }
 public static void MecanismoDeJuego(int[]opciones)
    {
        int  parejasEncontradas = 0;
        String[][] tablero = crearTablero(opciones[0], opciones[1]);

        boolean[][] descubiertas = new boolean[opciones[0]][opciones[1]];
       
       
        while (parejasEncontradas < (opciones[0] * opciones[1]) / 2 && opciones[6]>=0)
            {

                //Mostramos el tablero de inicio
                mostrarTablero(tablero, descubiertas, opciones);
                System.out.println("Intentos restantes: " + opciones[6]);


                System.out.println("Elige la primera celda (fila y columna):");
                int[] primeraCelda = obtenerCoordenadas(opciones);
                descubiertas[primeraCelda[0]][primeraCelda[1]] = true;

                mostrarTablero(tablero, descubiertas, opciones);

                System.out.println("Elige la segunda celda (fila y columna):");
                int[] segundaCelda = obtenerCoordenadas(opciones);
                descubiertas[segundaCelda[0]][segundaCelda[1]] = true;


                mostrarTablero(tablero, descubiertas, opciones);


             if (tablero[primeraCelda[0]][primeraCelda[1]].equals(tablero[segundaCelda[0]][segundaCelda[1]])) {
                System.out.println("¡Pareja encontrada!");
                parejasEncontradas++;
            } else
            {
                System.out.println("No coinciden. Mostrando...");
                //Este metodo se utiliza para mostrar en una serie de milesegundos que quiere poner el usuario la tabla con las parejas elegidas
                try
                {
                  Thread.sleep(opciones[4]);
                }
                //Por si falla el sistema
                catch (InterruptedException e)
                {
                  System.out.println("Ha fallado el sistema");
                }
                descubiertas[primeraCelda[0]][primeraCelda[1]] = false;
                descubiertas[segundaCelda[0]][segundaCelda[1]] = false;
            }      
            opciones[6]--;    
        }
        if(opciones[6]>=0)
            {
        System.out.println("¡Felicidades! Has encontrado todas las parejas.");
        System.out.println("Intentos restantes: " + opciones[6]);
        
        mostrarTablero(tablero, descubiertas, opciones);
            }
        else
        {
            System.out.println("Se te ha acabado los intentos");
            System.out.println("¿Quieres volver a jugar?" );
            menuInicio(opciones);
        }
}
// Mostrar el tablero al jugador
public static void mostrarTablero(String[][] tablero, boolean[][] descubiertas, int[] opciones) {
        System.out.print("  | ");
        for (int c = 0; c < tablero[0].length; c++)
        {
            System.out.print(" " + (c + 1) + " |");
        }
        System.out.println();

        for (int f = 0; f < tablero.length; f++)
        {
            for (int r = 0; r < tablero[0].length; r++)
            {
                System.out.print("-----");
            }
            System.out.println();
            System.out.print((f + 1) + " | ");
            for (int c = 0; c < tablero[0].length; c++)
            {
                if (descubiertas[f][c])
                {
                    System.out.print(" "+tablero[f][c] + " |");
                }
                else
                {
                    System.out.print("   |");
                }
            }
            System.out.println();
        }
    }
   
   
// Crear un tablero inicial con pares de letras
public static String[][] crearTablero(int filas, int columnas)
   {
        int tamaño = filas * columnas;
        String[] simbolos = generarSimbolos(tamaño / 2);
        String[][] tablero = new String[filas][columnas];

        int indice = 0;
        for (int i = 0; i < filas; i++)
        {
            for (int j = 0; j < columnas; j++)
            {
                tablero[i][j] = simbolos[indice / 2];
                indice++;
            }
        }

        mezclarTablero(tablero);
        return tablero;
    }
   
   
       
       
public static void mezclarTablero(String[][] tablero)
    {
    int filas = tablero.length;
    int columnas = tablero[0].length;

    for (int i = 0; i < filas; i++)
    {
        for (int j = 0; j < columnas; j++)
        {
            int filaAleatoria = (int) (Math.random() * filas);
            int columnaAleatoria = (int) (Math.random() * columnas);

            String temp = tablero[i][j];
            tablero[i][j] = tablero[filaAleatoria][columnaAleatoria];
            tablero[filaAleatoria][columnaAleatoria] = temp;
        }
    }
    }
   
// Generar una lista de símbolos para las parejas
public static String[] generarSimbolos(int numeroDePares)
   {
        String[] simbolos = new String[numeroDePares * 2];
        int ascii = 65;

        for (int i = 0; i < numeroDePares; i++)
        {
            simbolos[i * 2] = String.valueOf((char) ascii);
            simbolos[i * 2 + 1] = String.valueOf((char) (ascii + 32));
            ascii++;
        }

        return simbolos;
    }
   
// Obtener coordenadas válidas del usuario
public static int[] obtenerCoordenadas(int[] opciones) {
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





        
        
        
        
        
        
    

