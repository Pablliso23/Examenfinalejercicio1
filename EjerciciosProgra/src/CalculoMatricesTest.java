import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class CalculoMatricesTest {

    @Test
    public void testCalcularMatrizB() {
        int[][] matrizA = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrizC = {
                {2, 3, 4},
                {6, 7, 8},
                {10, 11, 12}
        };

        int[][] matrizB = CalculoMatrices.calcularMatrizB(matrizC, matrizA);

        int[][] matrizEsperada = {
                {1, 1, 1},
                {2, 2, 2},
                {3, 3, 3}
        };

        try {
            Assert.assertArrayEquals("La matriz B calculada no coincide con la matriz esperada", matrizEsperada, matrizB);
            System.out.println("La prueba ha sido exitosa. La matriz B se ha calculado correctamente.");
        } catch (AssertionError e) {
            System.out.println("Error: La matriz B calculada no coincide con la matriz esperada.");
            throw e;
        }
    }

    @Test
    public void testArithmeticException() {
        int[][] matrizA = {
                {1, 2},
                {3, 4}
        };

        int[][] matrizC = {
                {2, 3},
                {4, 5}
        };

        try {
            CalculoMatrices.calcularMatrizB(matrizC, matrizA);
            System.out.println("Error: Se esperaba una ArithmeticException, pero no se lanzó ninguna excepción.");
        } catch (ArithmeticException e) {
            System.out.println("La prueba ha sido exitosa. Se lanzó la ArithmeticException correctamente.");
        }
    }

    @Test
    public void testNumberFormatException() {
        try {
            int[][] matrizA = CalculoMatrices.leerMatrizDesdeArchivo("matriz_invalida.txt");
            System.out.println("Error: Se esperaba una NumberFormatException, pero no se lanzó ninguna excepción.");
        } catch (NumberFormatException e) {
            System.out.println("La prueba ha sido exitosa. Se lanzó la NumberFormatException correctamente.");
        }
    }

    @Test
    public void testArrayIndexOutOfBoundsException() {
        int[][] matrizA = {
                {1, 2},
                {3, 4}
        };

        int[][] matrizC = {
                {2, 3, 4},
                {5, 6, 7}
        };

        try {
            CalculoMatrices.calcularMatrizB(matrizC, matrizA);
            System.out.println("Error: Se esperaba una ArrayIndexOutOfBoundsException, pero no se lanzó ninguna excepción.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("La prueba ha sido exitosa. Se lanzó la ArrayIndexOutOfBoundsException correctamente.");
        }
    }

    @Test
    public void testExistenciaArchivoMatrizA() {
        File archivoMatrizA = new File("matrizA.txt");
        Assert.assertTrue("Error: No se encontró el archivo matrizA.txt", archivoMatrizA.exists());
    }

    @Test
    public void testExistenciaArchivoMatrizC() {
        File archivoMatrizC = new File("matrizC.txt");
        Assert.assertTrue("Error: No se encontró el archivo matrizC.txt", archivoMatrizC.exists());
    }

    @Test
    public void testExistenciaArchivoMatrizB() {
        File archivoMatrizB = new File("matrizB.txt");
        Assert.assertTrue("Error: No se encontró el archivo matrizB.txt", archivoMatrizB.exists());
    }
}
