package ru.progwards.java2.lessons.recursion;

public class AsNumbersSum {

//    Реализовать класс, AsNumbersSum, содержащий метод
//    public static String asNumbersSum(int number), который раскладывает параметр number, как всевозможные уникальные комбинации сумм натуральных чисел, например:
//    5 = 4+1 = 3+2 = 3+1+1 = 2+2+1 = 2+1+1+1 = 1+1+1+1+1
//
//    Строка должна содержать результат, отформатированный точно, как указано в примере.
//     Повторные комбинации не допускаются, например, если а строке уже есть 3+2, то 2+3 там быть не должно. Задача должна быть решена методом рекурсии, циклы использовать запрещено.

//    public static String asNumbersSum(int number){
//
//
//        int m = 0;
//        if(number == 0){
//            return "";
//        }
//
//        String result;
//        System.out.println("Number = " + number);
//
//        result = asNumbersSum(number-1);
//
//
//        result  = "=" + number + "+"  + result;
//        System.out.println(result);
//        return result;
//    }



    public static String asNumbersSum(int number){
////        System.out.printf("%d=\n", number);
//        String result = String.format("%d=\n", number);
//        for (int i1 = 1; i1 < number; i1++){
//            result += String.format("i1 = %d%+d=\n", number - i1, i1);
//            if (i1 > 1){
//                for (int i2 = 1; i2 < i1; i2++){
//                    result += String.format("i2 = %d%+d%+d=\n", number-i1, i1-i2, i2);
//                    if (i2 > 1) {
//                        for (int i3 = 1; i3 < i2; i3++) {
//                            result += String.format("i3 = %d%+d%+d%+d=\n", number - i1, i1 - i2, i2 - i3, i3);
//                            if (i3 > 1){
//                                for (int i4 = 1; i4 < i3; i4++){
//                                    result += String.format("i4 = %d%+d%+d%+d%+d\n", number - i1, i1 - i2, i2 - i3, i3 - i4, i4);
//
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return result;
        return number + end(number-1, 1, "");
    }
    public static String end (int n, int i, String res){
//        System.out.println("n = " + n + " i = " + i);
        if (n <= 0){
            return "";
        }else
            return " = " + res + n + "+" + i + end(i - 1, 1, res + n + "+") + end(n - 1, i + 1, res);
        }




//    static public String two (int num, int numPlus, String plus ){
////        System.out.println(num + " " + numPlus);
////        System.out.println(plus + num);
//        if (numPlus <= num/2) {
//            three(num, numPlus, plus);
//            two(num, numPlus + 1, plus);
//            System.out.println(plus + num);
//
//        }
//        return "";
//    }

//    static String three (int num, int numPlus, String khvost){
//        two(num - numPlus, 1, khvost + numPlus + "+" );
//        return "";
//    }


    public static void main(String[] args) {
        System.out.println(asNumbersSum(5));
    }



//    public static void main(String[] args) {
//        System.out.println(two(5, 1,""));
//    }
}
