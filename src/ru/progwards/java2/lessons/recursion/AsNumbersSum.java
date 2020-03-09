package ru.progwards.java2.lessons.recursion;

public class AsNumbersSum {

    //Реализовать класс, AsNumbersSum, содержащий метод
    //public static String asNumbersSum(int number), который раскладывает параметр number, как всевозможные уникальные комбинации сумм натуральных чисел, например:
    //5 = 4+1 = 3+2 = 3+1+1 = 2+2+1 = 2+1+1+1 = 1+1+1+1+1
    //
    //Строка должна содержать результат, отформатированный точно, как указано в примере.
    // Повторные комбинации не допускаются, например, если а строке уже есть 3+2, то 2+3 там быть не должно. Задача должна быть решена методом рекурсии, циклы использовать запрещено.

//    public static String asNumbersSum(int number){
//
//
//        int m = 0;
//        if(number == 0){
//            return "";
//        }
//        String result;
//        System.out.println("Number = " + number);
//
//        result = asNumbersSum(number-1);
//
//        if (((5 - (number - 1)) % 2) == 1){
//            result = "=" + number + "+1+1" + result;
//        }
//
//        result  = "=" + number + "+" + (5 - number) + result;
//        System.out.println(result);
//        return result;
//    }

    public static String asNumbersSum(int number){
        System.out.printf("%d=", number);
        for (int i = 1; i < number; i++){
            System.out.printf("%d%+d=", number - i, i);
            if (i > 1){
                for (int f = 1; f < i; f++){
                    System.out.printf("%d%+d%+d=", number-i, i-f, f);
                    if (f > 1) {
                        for (int t = 1; t < f; t++) {
                            System.out.printf("%d%+d%+d%+d=", number - i, i - f, f - t, t);
                            if (t > 1){
                                for (int r = 1; r < t; r++){
                                    System.out.printf("%d%+d%+d%+d%+d", number - i, i - f, f - t, t - r, r);

                                }
                            }
                        }
                    }
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        asNumbersSum(5);
    }
}
