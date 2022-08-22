package ru.netology.product2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repozitory2.ProductRepozitory;

class ProductManagerTest {
    ProductRepozitory repo = new ProductRepozitory();
    ProductManager manager = new ProductManager(repo);

    Book book1 = new Book(1, "book1", 100, "A1");
    Book book2 = new Book(2, "book2", 200, "A2");
    Book book3 = new Book(3, "book3", 300, "A3");
    Book book4 = new Book(4, "book4", 400, "A4");
    Book book5 = new Book(5, "book5", 500, "A5");
    Smartphone smartphone1 = new Smartphone(11, "smartphone11", 10_000, "M1");
    Smartphone smartphone2 = new Smartphone(22, "smartphone22", 20_000, "M2");
    Smartphone smartphone3 = new Smartphone(33, "smartphone33", 30_000, "M3");


    @Test
    public void searchBy() {
        manager.add(book1);
        manager.add(smartphone2);
        manager.add(book5);

        Product[] expected = {book1, book5};
        Product[] actual = manager.searchBy("book");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchMissingProduct() {
        manager.add(book1);
        manager.add(smartphone2);
        manager.add(book5);

        Product[] expected = {};
        Product[] actual = manager.searchBy("notebook");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void matches() {
        manager.add(smartphone1);
        manager.add(book3);
        manager.add(smartphone2);


        Product[] expected = {smartphone1, smartphone2};
        Product[] actual = manager.searchBy("smartphone");

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void removeById() {
        manager.add(smartphone1);
        manager.add(smartphone2);

        repo.removeById(11);


        Product[] expected = {smartphone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeDifferentCategoriesById() {
        manager.add(book1);
        manager.add(book5);

        repo.removeById(1);


        Product[] expected = {book5};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }


}