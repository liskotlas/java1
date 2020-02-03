package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Order {
    public String shopId = "";
    //        - идентификатор магазина
    public String orderId = "";
    //        - идентификатор заказа
    public String customerId = "";
    //        - идентификатор покупателя
    public LocalDateTime datetime;
    //        - дата-время заказа (из атрибутов файла - дата последнего изменения)
    public List<OrderItem> items;
    //        - список позиций в заказе, отсортированный по наименованию товара
    public double sum = 0;
//        - сумма стоимости всех позиций в заказе

    public Order(Path fileOrder, List<OrderItem> orderItemList) throws IOException {

        this.shopId = fileOrder.getFileName().toString().substring(0, 3);

        this.orderId = fileOrder.getFileName().toString().substring(5, 10);

        this.customerId = fileOrder.getFileName().toString().substring(12, 16);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'");
        this.datetime = LocalDateTime.from(formatter.parse(Files.getAttribute(fileOrder, "lastModifiedTime").toString()));

        this.items = orderItemList;

        for (OrderItem item : items) {
            this.sum += item.count * item.price;
        }
    }
}
