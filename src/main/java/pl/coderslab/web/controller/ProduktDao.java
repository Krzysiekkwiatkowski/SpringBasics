package pl.coderslab.web.controller;

import java.util.ArrayList;
import java.util.List;

public class ProduktDao {
    public static List<Product> getList(){
        List<Product> products = new ArrayList<>();
        Product product1 = new Product(0L, "Product0", 2.63);
        Product product2 = new Product(1L, "Product1", 5.80);
        Product product3 = new Product(2L, "Product2", 3.45);
        Product product4 = new Product(3L, "Product3", 1.13);
        Product product5 = new Product(4L, "Product4", 2.79);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        return products;
    }
}
