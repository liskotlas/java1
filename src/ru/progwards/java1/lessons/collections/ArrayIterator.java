package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {
    private T[] array;
    private int indexArr;

    ArrayIterator(T[] array) {
        this.array = array;
        int indexArr;
    }

    @Override
    public boolean hasNext() {
        return (indexArr + 1) < array.length && array[indexArr + 1] != null ? true : false;
    }

    @Override
    public T next() {
        ++indexArr;
        System.out.println(indexArr);
        return array[indexArr] != null ? array[indexArr] : null;
    }

    public static void main(String[] args) {
        Integer[] arr = {0, 1, 2, 3, 4};
        ArrayIterator<Integer> iterator1 = new ArrayIterator<>(arr);
        while (iterator1.hasNext()) {

            System.out.println(iterator1.next());
        }
    }
}
