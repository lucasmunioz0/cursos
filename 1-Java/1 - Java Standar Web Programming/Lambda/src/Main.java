import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int matriz[][];
        int sumas[];

        System.out.print("ingrese la cantidad de filas x columnas: ");
        int n = entrada.nextInt();

        matriz = new int[n][n];
        sumas = new int[n];

        int sumaFila1 = 0, sumaFila = 0;
        System.out.println("ingrese los datos de la matriz");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("ingrese el dato de la posición: " + i + j);
                matriz[i][j] = entrada.nextInt();
                sumas[i] = sumas[i] + matriz[i][j];
            }
        }

        int sumaTotal = 0;
        for (int i = 0; i < sumas.length; i++) {
            sumaTotal = sumaTotal + sumas[i];
        }

        boolean resultado = false;
        if (sumaTotal % 2 == 0){
            resultado = true;
        }else{
            resultado = false;
        }

        System.out.println("la suma de las fila es :" + sumaFila);

    }
}