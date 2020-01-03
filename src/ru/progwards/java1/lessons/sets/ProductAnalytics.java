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
        Set <Product> result = new HashSet<>();
        int score = 0;


        for (Product product : products){
            for (Shop shop : shops){
                if (shop.getProducts().contains(product)) {
                    score++;
                }
                if (score > 1){
                    score = 0;
                    break;
                }
            }
            if (score == 1){
                result.add(product);
                score = 0;
            }
        }
        return result;
    }



    public static void main(String[] args) {

        Product product1 = new Product("art-1");
        Product product2 = new Product("art-2");
        Product product3 = new Product("art-3");
        Product product4 = new Product("art-4");
        Product product5 = new Product("art-5");
        Product product6 = new Product("art-6");
        Product product7 = new Product("art-7");
        Product product8 = new Product("art-8");
        Product product9 = new Product("art-9");
        Product product10 = new Product("art-10");

        List <Product> one = new ArrayList<>();
        one.add(product4);
        one.add(product6);
        one.add(product7);
        one.add(product9);
        List <Product> two = new ArrayList<>();
        two.add(product1);
        two.add(product4);
        two.add(product8);
        two.add(product10);
        List <Product> three = new ArrayList<>();
        three.add(product1);
        three.add(product3);
        three.add(product8);



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

        List <Shop> shops = new ArrayList<>();
        shops.add(shop1);
        shops.add(shop2);
        shops.add(shop3);

        ProductAnalytics productAnalytics1 = new ProductAnalytics(products, shops);
        System.out.println(productAnalytics1.existOnlyInOne());
    }
}


