import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CalculoMatrices {
    public static void main(String[] args) {
        String archivoMatrizA = "matrizA.txt";
        String archivoMatrizB = "matrizB.txt";
        String archivoMatrizC = "matrizC.txt";

        int[][] matrizA = leerMatrizDesdeArchivo(archivoMatrizA);
        int[][] matrizB = leerMatrizDesdeArchivo(archivoMatrizB);
        int[][] matrizC = calcularMatrizC(matrizA, matrizB);

        escribirMatrizEnArchivo(matrizC, archivoMatrizC);

        System.out.println("La matriz C ha sido calculada y guardada en " + archivoMatrizC);
    }

    public static int[][] leerMatrizDesdeArchivo(String archivo) {
        int[][] matriz = null;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int fila = 0;

            while ((linea = br.readLine()) != null) {
                String[] valores = linea.trim().split(",");
                if (matriz == null) {
                    matriz = new int[valores.length][];
                }

                matriz[fila] = new int[valores.length];

                for (int columna = 0; columna < valores.length; columna++) {
                    matriz[fila][columna] = Integer.parseInt(valores[columna].trim());
                }

                fila++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return matriz;
    }

    public static int[][] calcularMatrizC(int[][] matrizA, int[][] matrizB) {
        int filas = matrizA.length;
        int columnas = matrizA[0].length;

        int[][] matrizC = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizC[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }

        return matrizC;
    }

    public static void escribirMatrizEnArchivo(int[][] matriz, String archivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    bw.write(String.valueOf(matriz[i][j]));
                    if (j < matriz[i].length - 1) {
                        bw.write(",");
                    }
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
