package ru.netology.product2;

import ru.netology.repozitory2.ProductRepozitory;

public class ProductManager {
    ProductRepozitory repo;


    public ProductManager(ProductRepozitory repozitory) {
        this.repo = repozitory;
    }


    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i]; // "добавляем в конец" массива result продукт product
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }


    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }


    public void add(Product product) {
        repo.add(product);

    }


}
