package ru.progwards.java2.lessons.recursion;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GoodsWithLambda {

    List<Goods> goodsList;

    public GoodsWithLambda(List<Goods> list){
        goodsList = list;
    }


    void setGoods(List<Goods> list){

        goodsList = list;
    }

    // - вернуть список, отсортированный по наименованию
    List<Goods> sortByName(){
        this.goodsList.sort(Comparator.comparing(x -> x.name));

        return this.goodsList;
    }

    // - вернуть список, отсортированный по артикулу, без учета регистра
    List<Goods> sortByNumber(){

        this.goodsList.sort(Comparator.comparing(x -> x.number));
        return this.goodsList;
    }

    // - вернуть список, отсортированный по первым 3-м символам артикула, без учета регистра
    List<Goods> sortByPartNumber(){
        this.goodsList.sort(Comparator.comparing(x -> x.number.substring(0, 3)));
        return this.goodsList;
    }

    //- вернуть список, отсортированный по количеству, а для одинакового количества, по артикулу, без учета регистра
    List<Goods> sortByAvailabilityAndNumber() {
        this.goodsList.sort(new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                if (o1.available == o2.available){
                    return o1.number.compareTo(o2.number);
                }else return Integer.compare(o1.available, o2.available);
            }
        });
        return this.goodsList;
    }

    //- вернуть список, с товаром, который будет просрочен после указанной даты, отсортированный по дате годности
    List<Goods> expiredAfter(Instant date){
        this.goodsList.sort(Comparator.comparing(x -> date.isBefore(x.expired)));
        return null;
    }

    // - вернуть список, с товаром, количество на складе которого меньше указанного
    List<Goods> сountLess(int count){
        this.goodsList.sort(Comparator.comparing(x -> count > x.available));
        return this.goodsList;
    }

    // - вернуть список, с товаром, количество на складе которого больше count1 и меньше count2
    List<Goods> сountBetween(int count1, int count2){

        goodsList.sort(Comparator.comparing(x -> count1 < x.available && count2 > x.available));
        return this.goodsList;
    }


}

class Goods {

    String name;
    String number;
    int available;
    double price;
    Instant expired;

    public Goods(String name, String number, int available, double price, Instant expired){
        this.name = name;
        this.number = number;
        this.available = available;
        this.price = price;
        this.expired = expired;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", available=" + available +
                ", price=" + price +
                ", expired=" + expired +
                '}';
    }

    public static void main(String[] args) {
        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(new Goods("Рис", "1110", 1000, 100.00, Instant.now()));
        goodsList.add(new Goods("Греча", "1120", 1000, 50.00, Instant.now()));
        goodsList.add(new Goods("Пшено", "1130", 900, 30.00, Instant.now()));
        GoodsWithLambda lambda = new GoodsWithLambda(goodsList);
        lambda.sortByAvailabilityAndNumber().forEach(System.out ::println);



//        GoodsWithLambda lambda = new GoodsWithLambda();


    }
}


