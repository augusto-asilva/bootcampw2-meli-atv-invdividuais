package com.br.meli.spring.crud.simulado;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FakeCrudController {

    private Map<Integer, ProductForm> fakeDb = new HashMap<>();
    private int currentId = 0;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String getAll(){
        return fakeDb.toString();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String get(@PathVariable Integer id){
        return fakeDb.get(id).toString();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody ProductForm product) {
        fakeDb.put(currentId, product);
        currentId++;
        return "{ \"added\": \"true\", \"product\": " + product + "}";
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String put(@PathVariable Integer id, @RequestBody ProductForm product){
        ProductForm oldProduct = fakeDb.get(id);
        fakeDb.replace(id, oldProduct, product);
        return "{ \"updated\": \"true\", " +
                " \"oldData\": " + oldProduct + ", " +
                " \"newData\": " + product + "}";
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable Integer id){
        ProductForm removed = fakeDb.remove(id);
        return "{ \"removed\": \"true\", \"removeProduct\": " + removed + "}";
    }
}
