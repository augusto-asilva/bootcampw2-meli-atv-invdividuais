package br.com.meli.bootcamp.fake.shop.domain;

import java.util.List;

public class Customer {

    private int id;
    private String name;
    private String cpf;
    private String email;
    private String telefone;
    private List<Order> orders;

    public Customer() {
    }

    public Customer(int id, String name, String cpf, String email, String telefone, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
