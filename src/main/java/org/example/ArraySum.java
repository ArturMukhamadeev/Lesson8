package org.example;

public class ArraySum {
    public static int sum(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if(arr.length != 4) throw new MyArraySizeException("Array size is not 4x4");
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].length != 4) throw new MyArraySizeException("Row " + i + " does not have 4 elements");
        }
        int sum = 0;
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Invalid data at (" + i + ", " + j + "): " + arr[i][j]);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        String[][] invalidArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "X", "11", "12"},
                {"13", "14", "15", "16"}
        };
        try {
            int result = sum(validArray);
            System.out.println("Sum of validArray: " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            int result = sum(invalidArray);
            System.out.println("Sum of invalidArray: " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
