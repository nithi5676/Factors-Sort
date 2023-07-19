package factorsSort;

import java.util.Scanner;

public class FactorsSort {

    public static void Sort(int[] array) {

        int[] factors = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = 1; j <= Math.sqrt(array[i]); j++) {
                if (array[i] % j == 0) {
                    count += 2;
                    if (j == array[i] / j) {
                        count--;
                    }
                }
            }
            factors[i] = count;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (factors[i] > factors[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                } else if (factors[i] == factors[j] && array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size ");
        int size = scanner.nextInt();
        System.out.println("Enter array Elements");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        Sort(array);
    }
}
