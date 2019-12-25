package ru.progwards.java1.lessons.collections;


import java.util.Iterator;

public class MatrixIterator<T> implements Iterator<T> {
    private T[][] array;
    private int indexArrX;
    private int indexArrY;

    MatrixIterator(T[][] array) {
        this.array = array;
        indexArrX = -1;
        indexArrY = -1;
    }

    @Override
    public boolean hasNext() {
        if (indexArrX >= array[indexArrY].length) {
            ++indexArrY;
            indexArrX = -1;
            return (indexArrX + 1) < array[indexArrY].length && (indexArrY + 1) < array.length && array[indexArrX + 1] != null ? true : false;
        }
        return false;
    }

    @Override
    public T next() {
        indexArrX++;

        return array[indexArrY][indexArrX] != null ? array[indexArrY][indexArrX] : null;
    }

    public static void main(String[] args) {
        Integer [][] matrix = {{0, 1,2,3,4},{10,11,12,13,14}};
        MatrixIterator <Integer> matrixIterator = new MatrixIterator<>(matrix);
        while (matrixIterator.hasNext()){
            System.out.println(matrixIterator.next());
        }
    }
}
