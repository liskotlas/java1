package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;

public class OrderProcessor {
    public String startPath;
    List<OrderItem> orderItemList = new ArrayList<>();
    List<Order> orderList = new ArrayList<>();
    public int failedFile = 0;

    public OrderProcessor(String startPath) {
        this.startPath = startPath;
    }

    public int loadOrders(LocalDate start, LocalDate finish, String shopId) {

        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/AAA-999999-ZZZZ.csv  ");

        try {
            Files.walkFileTree(Paths.get(startPath), new SimpleFileVisitor<Path>() {



                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {

//                    if (pathMatcher.matches(pathFile.relativize(path))) {
                    if (pathMatcher.matches(path)) {
                        LocalDateTime localDateTimeOrder = LocalDateTime.parse(Files.getLastModifiedTime(path).toString());
                        if (localDateTimeOrder.isAfter(LocalDateTime.of(start, LocalTime.of(0, 0, 0))) && localDateTimeOrder.isBefore(LocalDateTime.of(finish, LocalTime.of(0, 0, 0)))) {

                            List<String> good = sortGoods(Files.readAllLines(path)); // Получение и сортировка листа позиций товаров из одного файла
//                  Создание листа товаров (OrderItem)
                            for (String s : good) {
                                String[] positionGood = s.split(",");
                                orderItemList.add(new OrderItem(positionGood));
                            }

//                        Создание заказа (Order)
                            orderList.add(new Order(path, orderItemList));

                            return FileVisitResult.CONTINUE;
                        }
                    }
                    failedFile += 1;
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    return FileVisitResult.CONTINUE;
                }
            });
            System.out.println(pathMatcher);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return failedFile;
    }


    public List<String> sortGoods(List<String> goodsList) {
        ArrayList<String> goodsArrayList = new ArrayList<>(goodsList);

        String tmp;
        for (int f = 0; f < goodsArrayList.size(); f++) {
            for (int i = f + 1; i < goodsArrayList.size(); i++) {
                if (goodsArrayList.get(f).equals(goodsArrayList.get(i))) {
                    tmp = goodsArrayList.get(f);
                    goodsArrayList.add(f, goodsArrayList.get(i));
                    goodsArrayList.add(i, tmp);
                }
            }
        }
        return goodsArrayList;
    }


    class Order {


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

            this.shopId = fileOrder.getFileName().toString().substring(0, 4);
            this.orderId = fileOrder.getFileName().toString().substring(5, 11);
            this.customerId = fileOrder.getFileName().toString().substring(12, 16);
            this.datetime = LocalDateTime.parse(Files.getLastModifiedTime(fileOrder).toString());
            this.items = orderItemList;
            for (OrderItem item : items) {
                this.sum += item.count * item.price;
            }
        }
    }

    class OrderItem {


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

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor("E:\\Java\\Education\\src\\ru\\progwards\\java1\\lessons\\files\\Order");
        processor.loadOrders(LocalDate.now(ZoneId.systemDefault()).minusMonths(1), LocalDate.now(ZoneId.systemDefault()).plusMonths(1), "0001" );
    }
}
