package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {
    private T[] array;
    private int indexArr;

    ArrayIterator(T[] array) {
        this.array = array;
        indexArr = -1;
    }

    @Override
    public boolean hasNext() {
//        System.out.println(indexArr);
        return (indexArr + 1) < array.length && array[indexArr + 1] != null ? true : false;
    }

    @Override
    public T next() {
//        System.out.println(indexArr);
        ++indexArr;
//        System.out.println(indexArr);
        return array[indexArr] != null ? array[indexArr] : null;
    }

    public static void main(String[] args) {
        Integer[] arr = {10, 11, 12, 13, 14};
        ArrayIterator<Integer> iterator1 = new ArrayIterator<>(arr);
        while (iterator1.hasNext()) {

            System.out.println(iterator1.next());
        }
    }
}
