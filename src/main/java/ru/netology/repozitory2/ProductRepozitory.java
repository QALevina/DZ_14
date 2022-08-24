package ru.netology.repozitory2;

import ru.netology.product2.NotFoundException;
import ru.netology.product2.Product;

public class ProductRepozitory {
    Product[] products = new Product[0];


    public Product[] add(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];

        }
        tmp[tmp.length - 1] = product;
        products = tmp;
        return products;
    }

    public void removeById(int removeId) {
        if (findById(removeId) == null) {
            throw new NotFoundException("Element with id: " + removeId + " not found");
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != removeId) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
            products = tmp;
        }

    }

    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }

        }
        return null;
    }
}
