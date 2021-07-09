package br.com.meli.bootcamp.fake.shop.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Order {
    private int id;
    private List<Product> products;
    private BigDecimal totalValue;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    public Order() {
    }

    public Order(int id, List<Product> products, BigDecimal totalValue, LocalDate date) {
        this.id = id;
        this.products = products;
        this.totalValue = totalValue;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
