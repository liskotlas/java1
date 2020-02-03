package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

//Информация о заказах поступает в виде файлов, которые лежат в под-папках разбитых по неделям, имена папок не имеют значения.
// Имя каждого файла имеет формат: AAA-999999-ZZZZ.csv где AAA - обязательные 3 символа shopId - идентификатор магазина, 999999 - обязательные 6 символов orderId - номер заказа,
// ZZZZ - обязательные 4 символа customerId - идентификатор покупателя, расширение файла - csv, например S02-P01X12-0012.csv: shopId=”S02”, orderId=”P01X12”, customerId=”0012”
public class OrderProcessor {
    public String startPath;
    List<OrderItem> orderItemList = new ArrayList<>();
    List<Order> orderList = new ArrayList<>();
    public int failedFile = 0;
    LocalDateTime fileDate;

    public OrderProcessor(String startPath) {
        this.startPath = startPath;
    }

    public int loadOrders(LocalDate start, LocalDate finish, String shopId) {

        try {
            Files.walkFileTree(Paths.get(startPath), new SimpleFileVisitor<Path>() {


                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
                    OrderList(start, finish, shopId, path);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return failedFile;
    }

    // Проверка входящих файлов
    private boolean checkOrderDate(LocalDate start, LocalDate finish, String shopId, Path path) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'");
        fileDate = LocalDateTime.from(formatter.parse(Files.getAttribute(path, "lastModifiedTime").toString()));
        String s = "glob:**/???-??????-????.csv";
        if (shopId != null) {
            s = "glob:**/" + shopId + "-??????-????.csv";
        }

        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher(s);

        if (pathMatcher.matches(path)) {

            if (start == null && fileDate.isBefore(LocalDateTime.of(finish, LocalTime.of(23, 53, 59)))) {
                return true;
            }

            if (finish == null && fileDate.isAfter(LocalDateTime.of(start, LocalTime.of(0, 0, 0)))) {
                return true;
            }

            if (fileDate.isAfter(LocalDateTime.of(start, LocalTime.of(0, 0, 0))) && fileDate.isBefore(LocalDateTime.of(finish, LocalTime.of(23, 53, 59)))) {
                return true;
            }
        }
        failedFile++;
        return false;
    }

//    Создание листа заказов

    private List<Order> OrderList(LocalDate start, LocalDate finish, String shopId, Path pathOrderFile) throws IOException {
//        orderList.clear();
        if (checkOrderDate(start, finish, shopId, pathOrderFile)) {
            List<String> good = new ArrayList<>(sortGoods(Files.readAllLines(pathOrderFile)));
            for (String s : good) {
                String[] positionGood = s.split(",");
                orderItemList.add(new OrderItem(positionGood));
            }
            good.clear();

            orderList.add(new Order(pathOrderFile, orderItemList));
//            orderItemList.clear();
        }
        return orderList;
    }

    // Сортировка листа товаров
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

//    Сортировка листа заказов

    public List<Order> sortOrdes(List<Order> ordersFiltr) {
        ArrayList<Order> ordersArrayList = new ArrayList<>();

        Order tmp;
        for (int f = 0; f < ordersFiltr.size(); f++) {
            for (int i = f + 1; i < ordersFiltr.size(); i++) {
                if (ordersFiltr.get(f).datetime.isAfter((ordersFiltr.get(i).datetime))) {
                    tmp = ordersFiltr.get(f);
                    ordersFiltr.add(f, ordersFiltr.get(i));
                    ordersFiltr.add(i, tmp);
                }
            }
        }
        return ordersFiltr;
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

            this.shopId = fileOrder.getFileName().toString().substring(0, 3);
            this.orderId = fileOrder.getFileName().toString().substring(5, 10);
            this.customerId = fileOrder.getFileName().toString().substring(12, 16);
            this.datetime = fileDate;
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

    public List<Order> process(String shopId) {
        List<Order> ordersFiltr = new ArrayList<>();

        for (Order order : orderList) {
            if (shopId != null && order.shopId == shopId) {
                ordersFiltr.add(order);
                continue;
            }
            if (shopId != null && order.shopId != shopId) {
                continue;
            }
            ordersFiltr.add(order);
        }
        return sortOrdes(ordersFiltr);
    }

    public Map<String, Double> statisticsByShop(){
        Map <String, Double> mapSales = new TreeMap<>();
        for(Order order : orderList){
            if(mapSales.containsKey(order.shopId)){
                mapSales.put(order.shopId, mapSales.get(order.shopId) + order.sum);
                continue;
            }
            mapSales.putIfAbsent(order.shopId, order.sum);
        }
        return mapSales;
    }

//    выдать информацию по объему продаж по товарам (отсортированную по ключам):
//    String - goodsName, double - сумма стоимости всех проданных товаров этого наименования
    public Map<String, Double> statisticsByGoods() {

        Map<String, Double> mapGoods = new TreeMap<>();
        for (Order order : orderList) {
            for (OrderItem item : order.items) {
                if (mapGoods.containsKey(item.googsName)) {
                    mapGoods.put(item.googsName, mapGoods.get(item.googsName) + item.count * item.price);
                    System.out.println(item.googsName + "   " + item.count * item.price);
                    continue;
                }
                mapGoods.putIfAbsent(item.googsName, item.price * item.count);
            }
        }
        return mapGoods;
    }

//    выдать информацию по объему продаж по дням (отсортированную по ключам):
//    LocalDate - конкретный день, double - сумма стоимости всех проданных товаров в этот день
    public Map<LocalDate, Double> statisticsByDay(){

        Map<LocalDate, Double> mapDays = new TreeMap<>();
        for(Order order : orderList){
            if(mapDays.containsKey(LocalDate.from(order.datetime))){
                mapDays.put(LocalDate.from(order.datetime), mapDays.get(order.datetime) + order.sum);
                continue;
            }
            mapDays.putIfAbsent(LocalDate.from(order.datetime), order.sum);
        }
        return mapDays;
    }




    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor("E:\\Java\\Education\\src\\ru\\progwards\\java1\\lessons\\files\\Order");
        processor.loadOrders(LocalDate.now(ZoneId.systemDefault()).minusMonths(1), LocalDate.now(ZoneId.systemDefault()).plusMonths(1), "S01");
        for (Order order : processor.orderList){
            System.out.println(order.shopId + " " + order.datetime.toString()+ " " + order.sum);
            for (OrderItem item : order.items){
                System.out.println(item.googsName+ " " + item.price+ " " + item.count);
            }
        }
//        Map map = processor.statisticsByGoods();
//        for (var entry : map.entrySet()) {
//            System.out.println(entry.toString());
//        }

    }
}
