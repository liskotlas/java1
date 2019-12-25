package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ArrayIterator<T> implements Iterator<T> {
    private static final Object T = null;
    private T[] array;
    public int y;

    ArrayIterator(T[] array) {
        this.array = array;
        y = -1;
    }

    ArrayIterator(T[] array, int y) {
        this.array = array;
        this.y = y;
    }


    @Override
    public boolean hasNext() {
        return array[y + 1]!= null ? true : false;
    }

    @Override
    public T next() {
            return array[y + 1]!= null ? array[y + 1] : null;
    }

    public static void main(String[] args) {
        ArrayList <Integer> integerList = new ArrayList<>();
        Iterator <Integer> iterator = integerList.iterator();
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);

        for (;iterator.hasNext();){


        }

    }
}
