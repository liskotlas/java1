package ru.progwards.java2.lessons.recursion;

import ru.progwards.java1.lessons.Training.Array;

import java.util.Arrays;

public class HanoiTower {
    String empty = "  I  ";
    String[] one;
    String[] two;
    String[] zero;

    boolean on;

    int size;
    int pos;

    // инициализирует башню с size кольцами (1..size). pos - номер начального штыря (0,1,2)
    public HanoiTower(int size, int pos) {
        this.size = size;
        this.pos = pos;
        zero = new String[size];
        one = new String[size];
        two = new String[size];
        Arrays.fill(one, empty);
        Arrays.fill(two, empty);
        Arrays.fill(zero, empty);
        on = false;

        switch (pos) {
            case 0:
                for (int i = 0; i < size; i++) {
                    zero[i] = "<00" + (i + 1) + ">";
                }
                break;
            case 1:
                for (int i = 0; i < size; i++) {
                    one[i] = "<00" + (i + 1) + ">";
                }
                break;
            case 2:
                for (int i = 0; i < size; i++) {
                    two[i] = "<00" + (i + 1) + ">";
                }
                break;
        }
    }

    @Override
    public String toString() {

        String result = "";
        for (int i = 0; i < this.size; i++) {
            result += zero[i] + " " + one[i] + " " + two[i] + "\n";
        }
        result += "=================\n";
        return result;
    }


    //переносит башню со штыря from на штырь to
    public void move(int from, int to) {
        int additional = Integer.parseInt("012".replaceAll("" + from, "").replaceAll("" + to, ""));
        hanoi(size, from, to, additional);
    }

    void hanoi(int n, int from, int to, int additional) {

        if (n == 0) {
            return;
        }
        hanoi(n - 1, from, additional, to);
        System.out.println(from + " " + to);
//        replace(from, to);
        if (on == true) {
            print();
        }
        hanoi(n - 1, additional, to, from);
    }

    void replace(int from, int to) {
        String tmp = "";
        String[] tmpArr;

        switch (from) {
            case 0:
                for (int i = 0; i < zero.length; i++) {
                    if (zero[i] == empty) {
                        continue;
                    }
                    tmp = zero[i];
                    zero[i] = empty;
                    break;
                }
                break;

            case 1:
                for (int i = 0; i < one.length; i++) {
                    if (one[i] == empty) {
                        continue;
                    }
                    tmp = one[i];
                    one[i] = empty;
                    break;
                }
                break;

            case 2:
                for (int i = 0; i < two.length; i++) {
                    if (two[i] == empty) {
                        continue;
                    }
                    tmp = two[i];
                    two[i] = empty;
                    break;
                }
                break;
        }

        switch (to) {
            case 0:

                for (int i = (zero.length - 1); i >= 0; i--) {
                    if (zero[i] != empty) {
                        continue;
                    }
                    zero[i] = tmp;
                    break;
                }
                break;

            case 1:
                for (int i = one.length - 1; i >= 0; i--) {
                    if (one[i] != empty) {
                        continue;
                    }
                    one[i] = tmp;
                    break;
                }
                break;

            case 2:
                for (int i = two.length - 1; i >= 0; i--) {
                    if (two[i] != empty) {
                        continue;
                    }
                    two[i] = tmp;
                    break;
                }
                break;
        }
//
//        System.out.println("Zero = " + Arrays.toString(zero));
//        System.out.println("One = " + Arrays.toString(one));
//        System.out.println("Two = " + Arrays.toString(two));
    }

    // выводит текущее состояние башни на консоль
    void print() {
        System.out.println(this.toString());
    }

    //включает отладочную печать состояния игрового поля после каждого шага алгоритма (метода move). В результате все промежуточные ходы должны быть отображены
    void setTrace(boolean on) {
        this.on = on;
    }

    public static void main(String[] args) {
        HanoiTower test = new HanoiTower(3, 2);
        test.setTrace(false);
        test.print();
        test.move(2, 1);
        test.print();
    }
}
