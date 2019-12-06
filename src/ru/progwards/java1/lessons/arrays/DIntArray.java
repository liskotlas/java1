package ru.progwards.java1.lessons.arrays;

        import ru.progwards.java1.lessons.Training.Array;

        import java.util.Arrays;

public class DIntArray {
    private int[] a;

    public DIntArray() {

    }

    public DIntArray(int []d) {
    a = d;
    }

    public void add(int num) {
        int[] b = Arrays.copyOf(a, a.length + 1);
        b[a.length] = num;
        a = Arrays.copyOf(b, b.length);
        System.out.println(Arrays.toString(a));
    }

    public void atInsert(int pos, int num) {
        int[] b = new int[a.length + 1];
        System.arraycopy(a, 0, b, 0, pos);
        b[pos] = num;
        System.arraycopy(a, pos, b, pos + 1, a.length - pos);
        a = Arrays.copyOf(b, b.length);
        System.out.println(Arrays.toString(a));
    }

    public void atDelete(int pos) {
        int b[];
        b = new int[a.length - 1];
        System.arraycopy(a, 0, b, 0, pos);
        System.arraycopy(a, pos + 1, b, pos, a.length - pos - 1);
        a = Arrays.copyOf(b, b.length);
        System.out.println(Arrays.toString(a));
    }

    public int at(int pos) {
        return a[pos];
    }


    public static void main(String[] args) {
        int[] b = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        DIntArray arr = new DIntArray(b);
        System.out.println(Arrays.toString(b));
        arr.add(333);
        arr.atInsert(5, 333);
       arr.atDelete(5);
       arr.atDelete(10);


    }
}