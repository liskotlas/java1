package ru.progwards.java1.lessons.collections;


import java.util.Iterator;

public class MatrixIterator<T> implements Iterator<T> {
    private T[][] array;
    private int indexArrX;
    private int indexArrY;

    MatrixIterator(T[][] array) {
        this.array = array;
        indexArrX = -1;
        indexArrY = 0;
    }

    @Override
    public boolean hasNext() {
        if (indexArrX + 1 >= array[indexArrY].length) {
            ++indexArrY;
            indexArrX = -1;
        }
        if (indexArrY >= array.length) {
            return false;
        }
        return (indexArrX + 1) < array[indexArrY].length && (indexArrY) < array.length && array[indexArrY][indexArrX + 1] != null ? true : false;
    }

    @Override
    public T next() {
        indexArrX++;

        return array[indexArrY][indexArrX] != null ? array[indexArrY][indexArrX] : null;
    }

    public static void main(String[] args) {
        Integer[][] matrix = {{0, 1, 2, 3, 4, 11, 15, 1, 6, 8, 9, 5, 6, 4, 9, 0}, {10, 11, 12, 13, 14}};
        MatrixIterator<Integer> matrixIterator = new MatrixIterator<>(matrix);
        while (matrixIterator.hasNext()) {
            System.out.println(matrixIterator.next());
        }
    }
}
