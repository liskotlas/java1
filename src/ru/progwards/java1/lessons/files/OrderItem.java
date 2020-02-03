package ru.progwards.java1.lessons.files;

public class OrderItem {

    public String googsName = "";
//        - наименование товара

    public int count = 0;
//        - количество

    public double price = 0;
//        - цена за единицу

    public OrderItem(String[] positionGood) {
        this.googsName = positionGood[0].trim();
        this.count = Integer.parseInt(positionGood[1].trim());
        this.price = Integer.parseInt(positionGood[2].trim());
    }
}
