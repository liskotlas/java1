package ru.progwards.java1.lessons.sets;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ProductAnalytics {

    private List<Shop> shops;
    private List<Product> products;


    public ProductAnalytics(List<Product> products, List<Shop> shops) {
        this.products = products;
        this.shops = shops;
    }

    public Set<Product> existInAll() {
        Set<Product> result = (Set<Product>) products;
        Set<Product> res1 = null;
        for (Shop shop : shops) {
            for (Product productList : products) {
                result.retainAll(shop.getProducts());
            }
        }
        return result;
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

        List <Product> one = (List<Product>) new TreeSet<Product>();
        one.add(product1);
        one.add(product2);
        one.add(product3);
        one.add(product4);
        List <Product> two = (List<Product>) new TreeSet<Product>();
        two.add(product4);
        two.add(product5);
        two.add(product6);
        two.add(product7);
        List <Product> three = (List<Product>) new TreeSet<Product>();
        two.add(product7);
        two.add(product8);
        two.add(product9);
        two.add(product10);

        List<Product> shopListProducts1 = (List<Product>) new TreeSet<Product>();
        shopListProducts1.add((Product) one);

        List <Product> shopListProducts2 = (List<Product>) new TreeSet<Product>();
        shopListProducts1.add((Product) two);

        List <Product> shopListProducts3 = (List<Product>) new TreeSet<Product>();
        shopListProducts1.add((Product) three);

        Shop shop1 = new Shop(shopListProducts1);
        Shop shop2 = new Shop(shopListProducts2);
        Shop shop3 = new Shop(shopListProducts3);



        List<Product> products = (List<Product>) new TreeSet<Product>();
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

        List <Shop> shops = (List<Shop>) new TreeSet<Shop>();
        shops.add(shop1);
        shops.add(shop2);
        shops.add(shop3);

        ProductAnalytics productAnalytics1 = new ProductAnalytics(products, shops);
        System.out.println(productAnalytics1.existInAll());
    }
}


