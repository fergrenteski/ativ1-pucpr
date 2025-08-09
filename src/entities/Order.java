package entities;

import java.util.ArrayList;

public class Order {
    private String userName;
    private ArrayList<Product> products;

    public Order() {
        products = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public double getTotalValue() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public double getTotalTax() {
        return getTotalValue() * 0.1;
    }

    public double getTotal() {
        return getTotalValue() + getTotalTax();
    }
    public void printOrder() {
        System.out.println("Informações do Pedido: ");
        System.out.println("--------------");
        if (!products.isEmpty()) {
            products.forEach(System.out::println);
            System.out.println("--------------");
            System.out.println("Total do Pedido: " + String.format("%.2f", this.getTotalValue()));
            System.out.println("Taxa de serviço: " + String.format("%.2f", this.getTotalTax()));
            System.out.println("--------------");
            System.out.println("Total do Pedido: " + String.format("%.2f", this.getTotal()));

        } else {
            System.out.println("Nenhum produto selecionado");
            System.out.println("--------------");
        }
    }
}
