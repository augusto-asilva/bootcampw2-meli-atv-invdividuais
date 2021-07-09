package br.com.meli.bootcamp.fake.shop.domain;

import java.math.BigDecimal;

public class Product {
    private int id;
    private String description;
    private String color;
    private int quantity;
    private BigDecimal value;

    public Product() {
    }

    public Product(int id, String description, String color, int quantity, BigDecimal value) {
        this.id = id;
        this.description = description;
        this.color = color;
        this.quantity = quantity;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
