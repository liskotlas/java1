package ru.progwards.java2.lessons.Training;

import ru.progwards.java1.lessons.queues.CollectionsSort;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Java2_2 {

    class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return name + " " + age;
        }
    }

    void sortAndPrint(List<Person> list){

        list.sort(Comparator.comparing(a -> a.age));
        list.forEach(System.out :: println);
    }

    String reverseChars(String str){
        if(str == ""){
            return "";
        }
        String s = "";
        if (str.length() == 1){
            return str;
        }
        s = reverseChars(str.substring(1));
        return s + str.charAt(0);
    }

    static int fact (int n){
        int res;
        System.out.println(n + " прямой");
        if(n == 1){
            System.out.println(n + " обратный1");
            return 1;
        }
        res = fact(n-1) * n;
        System.out.println(n + " обратный2");
        System.out.println(res + " res");
        return res;
    }







    static int sumSequence(int n) {
        if (n == 1)
            return n;
        return sumSequence(n-2)+n;
    }






        static void hanoi(int n, int from, int to, int additional){

            if (n == 0) return;

            hanoi(n-1,from,additional,to);

            System.out.println(from + " " + to);

            hanoi(n-1,additional,to,from);

        }



        public static void main(String[] args)

        {

//            Scanner con = new Scanner(System.in);

//            int n = con.nextInt();

            hanoi(3,1,2,3);

        }

    }





