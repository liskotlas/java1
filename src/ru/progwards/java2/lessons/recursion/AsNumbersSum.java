package ru.progwards.java2.lessons.recursion;

public class AsNumbersSum {

    //Реализовать класс, AsNumbersSum, содержащий метод
    //public static String asNumbersSum(int number), который раскладывает параметр number, как всевозможные уникальные комбинации сумм натуральных чисел, например:
    //5 = 4+1 = 3+2 = 3+1+1 = 2+2+1 = 2+1+1+1 = 1+1+1+1+1
    //
    //Строка должна содержать результат, отформатированный точно, как указано в примере.
    // Повторные комбинации не допускаются, например, если а строке уже есть 3+2, то 2+3 там быть не должно. Задача должна быть решена методом рекурсии, циклы использовать запрещено.

    public static String asNumbersSum(int number){
        int m = 1;
        if(number == 1){
            return "+1";
        }
        String result;


        result = asNumbersSum(number-1);

        result  = "=" + number + "+" + ((number+1) - (number - 1)) + result;
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        asNumbersSum(4);
    }
}
