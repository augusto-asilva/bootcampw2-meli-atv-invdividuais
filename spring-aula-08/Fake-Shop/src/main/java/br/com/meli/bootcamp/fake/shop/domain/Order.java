package br.com.meli.bootcamp.fake.shop.domain;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    private int id;
    private List<Product> products;
    private BigDecimal totalValue;

    public Order(int id, List<Product> products, BigDecimal totalValue) {
        this.id = id;
        this.products = products;
        this.totalValue = totalValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }
}
