package ru.progwards.java1.lessons.sets;


import java.util.*;

public class ProductAnalytics {

    private List<Shop> shops;
    private List<Product> products;


    public ProductAnalytics(List<Product> products, List<Shop> shops) {
        this.products = products;
        this.shops = shops;
    }

    public Set<Product> existInAll() {
        Set<Product> result = new HashSet<>();
        result.addAll(products);
        for (Shop shop : shops) {
                result.retainAll(shop.getProducts());
            }
        return result;
    }

    public Set<Product> existAtListInOne(){
        Set<Product> result = new HashSet<>();
        for (Shop shop : shops) {
            result.addAll(shop.getProducts());
        }
        return result;
    }

    public Set<Product> notExistInShops(){
        Set<Product> result = new HashSet<>();
        Set<Product> productsList = new HashSet<>();
        productsList.addAll(products);
        for (Shop shop : shops) {
            result.addAll(shop.getProducts());
        }
        productsList.removeAll(result);
        return productsList;
    }

    public Set<Product> existOnlyInOne(){
        Set <Product> resSum = new HashSet<>();
        Set <Product> resUn = new HashSet<>();
        Set <Product> resObch = new HashSet<>();
        Set <Product> resShop2 = new HashSet<>();
        Set <Product> productsSet = new HashSet<>();

        for (Shop shop : shops){
            if (resSum.isEmpty()){
                resSum.addAll(shop.getProducts());
//                System.out.println("Первый " + resSum);
                continue;
            }
            resShop2.addAll(shop.getProducts());
//            System.out.println("Следующий " + resShop2);

            resSum.addAll(resShop2);
//            System.out.println("Сумма обоих" + resSum);
            resObch.clear();
            resObch.addAll(resSum);

            resObch.retainAll(shop.getProducts());
//            System.out.println("Общие " + resObch);
            resUn.clear();
            resUn.addAll(resSum);
            resUn.removeAll(resObch);
//            System.out.println("Уникальные " + resUn);
//            res1.clear();
//            res1.addAll(res2);
//            res2.clear();
        }
        return resUn;
    }



    public static void main(String[] args) {

        Product product1 = new Product("0001");
        Product product2 = new Product("0002");
        Product product3 = new Product("0003");
        Product product4 = new Product("0004");
        Product product5 = new Product("0005");
        Product product6 = new Product("0006");
        Product product7 = new Product("0007");
        Product product8 = new Product("0008");
        Product product9 = new Product("0009");
        Product product10 = new Product("0010");
        Product product11 = new Product("0011");

        List <Product> one = new ArrayList<>();
        one.add(product1);
        one.add(product2);
        one.add(product3);
        one.add(product8);
        List <Product> two = new ArrayList<>();
        two.add(product4);
        two.add(product5);
        two.add(product6);
        two.add(product8);
        List <Product> three = new ArrayList<>();
        three.add(product7);
        three.add(product8);
        three.add(product9);
        three.add(product10);



        Shop shop1 = new Shop(one);
        Shop shop2 = new Shop(two);
        Shop shop3 = new Shop(three);



        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
        products.add(product7);
        products.add(product8);
        products.add(product9);
        products.add(product10);
        products.add(product11);

        List <Shop> shops = new ArrayList<>();
        shops.add(shop1);
        shops.add(shop2);
        shops.add(shop3);

        ProductAnalytics productAnalytics1 = new ProductAnalytics(products, shops);
        System.out.println(productAnalytics1.existOnlyInOne());
    }
}


