package com.br.meli.spring.crud.simulado;

public class ProductForm {
    private String code;
    private String name;

    public ProductForm(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{" +
                "\"code\":\"" + code + "\"" +
                ", \"name\":\"" + name + "\"" +
                "}";
    }
}
