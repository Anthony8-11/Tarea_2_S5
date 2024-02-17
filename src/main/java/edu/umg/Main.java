package edu.umg;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        // Definir la matriz de ventas (5 filas x 12 columnas)
        int[][] ventas = new int[5][12];

        // Generar valores aleatorios para las ventas
        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                ventas[i][j] = random.nextInt(10000) + 1; // Ventas entre 1 y 10000
            }
        }

        // Imprimir la matriz de ventas usando forEach
        System.out.println("Matriz de ventas:");
        Arrays.stream(ventas)
                .forEach(row -> {
                    Arrays.stream(row)
                            .forEach(value -> System.out.printf("%8d  ", value));
                    System.out.println();
                });

        // Ordenar los elementos de la matriz por columna
        System.out.println("\nMatriz ordenada por columna:");
        IntStream.range(0, ventas[0].length)
                .forEach(columnIndex -> {
                    int[] column = Arrays.stream(ventas)
                            .mapToInt(row -> row[columnIndex])
                            .toArray();
                    Arrays.sort(column);
                    IntStream.range(0, ventas.length)
                            .forEach(rowIndex -> ventas[rowIndex][columnIndex] = column[rowIndex]);
                });

        // Imprimir la matriz ordenada por columna
        Arrays.stream(ventas)
                .forEach(row -> {
                    Arrays.stream(row)
                            .forEach(value -> System.out.printf("%8d  ", value));
                    System.out.println();
                });

        // Filtrar elementos de la matriz por un criterio (ejemplo: ventas mayores a 5000)
        System.out.println("\nMatriz filtrada por ventas mayores a 5000:");
        Arrays.stream(ventas)
                .forEach(row -> {
                    Arrays.stream(row)
                            .filter(value -> value > 7000)
                            .forEach(value -> System.out.printf("%8d  ", value));
                    System.out.println();
                });
    }
}