package ru.progwards.java1.lessons.Training;

import org.glassfish.grizzly.utils.ArrayUtils;

import java.util.*;


public class Java_12 {

//    public static void wSetTest() {
//        String TEXT = "на дворе трава на траве дрова не руби дрова на траве двора";
//        Set wordSet = new HashSet<>(Arrays.asList(TEXT.split(" ")));
//
//        Iterator iter = wordSet.iterator();
//        while (iter.hasNext())
//            if (iter.next().contains("ра"))
//                iter.remove();
//
//        System.out.println(wordSet.size());
//    }

            public Set<Integer> a2set(int[] a){
            Set <Integer> integerSet = new HashSet<>();
            for (int b: a){
                integerSet.add(b);
            }
            return integerSet;
        }

    public static void iSetTest() {
        Set iSet = new HashSet<>();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                iSet.add(i+j);
            }
        System.out.println(iSet.size());
    }



//    public static void main(String[] args) {
//        iSetTest();
//    }
}

class Figure {
    String figDetect(Figure fig){

        if (fig instanceof Square) {
            return "Сторона квадрата " + ((Square) fig).getSide();
        }
        if (fig instanceof Round){
            return "Диаметр круга "+ ((Round) fig).getDiameter();
        }
        else return "Неизвестная фигура";
    }

}

class Square extends Figure {
    private double side;
    public Square(double side) {
        this.side = side;
    }
    public double getSide() {
        return side;
    }
}

class Round extends Figure {
    private double diameter;
    public Round(double diameter) {
        this.diameter = diameter;
    }
    public double getDiameter() {
        return diameter;
    }

    public static void cset() {
        Set fiboSet1000 =
                Set.of(0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987);
        int sum = 0;
        for (int i = 2; i < 10; i++)
            sum += fiboSet1000.contains(i) ? 1 : 0;
        System.out.println(sum);
    }
    public static void main(String[] args) {
        cset();
    }
}

class User {
    public Integer id;
    public String name;
    public TreeSet <User> userTreeSet;
    User (Integer id, String name) {
        this.id = id;
        this.name = name;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public TreeSet<User> createSet() {
            TreeSet <User> userTreeSet = new TreeSet<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.id, o2.id) * -1;
            }
        });
            return (TreeSet<User>) userTreeSet;
    }

//    public static void main(String[] args) {
//        User user1 = new User(1, "Вася");
//        User user2 = new User(2, "Петя");
//        user1.createSet(user1, user2);
//        System.out.println(user1.userTreeSet);


    }


