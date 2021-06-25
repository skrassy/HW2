import com.sun.tools.javac.util.StringUtils;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите размерность матрицы N x N (число): ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[][] array = new String[n][n];
        initArray(array);
        array[2][2] = "Не число";
        System.out.println(Arrays.deepToString(array));
        try {
            checkIfArray4x4(array);
            int result = arrayToInt(array);
            System.out.println("Сумма преобразованных элементов массива = " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void checkIfArray4x4(String[][] array) throws MyArraySizeException {
        if (array.length != 4 && array[0].length != 4) {
            throw new MyArraySizeException("Введен массив неверного размера");
        }
        System.out.println("Введен массив верного размера");
    }

    public static int arrayToInt(String[][] array) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                try {
                    int number = Integer.parseInt(array[i][j]);
                    sum = sum + number;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Преобразование строки в число невозможно! Ошибка в элементе: [" + i + ", " + j + "] = " + array[i][j]);
                }
            }
        }
        return sum;
    }

    public static void initArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = Integer.toString(i + 1);
            }
        }
    }
}
