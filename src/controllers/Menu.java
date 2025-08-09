package controllers;

import entities.Product;

import java.util.ArrayList;

public class Menu {
    private ArrayList<Product> products;

    public Menu() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addAllProduct(Product... products) {
        for (Product product : products) {
            addProduct(product);
        }
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public Product getProductById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void exibirMenu() {
        System.out.println("Menu");
        System.out.println("----------------");
        products.forEach(System.out::println);
        System.out.println("----------------");
        System.out.println("Taxa de Serviço: 10%");
    }
}
