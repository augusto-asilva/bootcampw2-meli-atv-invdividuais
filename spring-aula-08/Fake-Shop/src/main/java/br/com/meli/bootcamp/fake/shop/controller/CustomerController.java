package br.com.meli.bootcamp.fake.shop.controller;

import br.com.meli.bootcamp.fake.shop.CustomerService;
import br.com.meli.bootcamp.fake.shop.domain.Customer;
import br.com.meli.bootcamp.fake.shop.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shop/")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> customers = customerService.getCustomers();
        return new ResponseEntity<>(customers, HttpStatus.FOUND);
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> getCustomers(@RequestBody Customer customer) {
        Customer newCustomer = customerService.postCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<Customer> getCustomers(@PathVariable Integer customerId) {
        Customer customer = customerService.getCustomer(customerId);
        return new ResponseEntity<>(customer, HttpStatus.FOUND);
    }

    @GetMapping("/customers/{customerId}/orders")
    public ResponseEntity<List<Order>> getCustomerOrders(@PathVariable Integer customerId) {
        List<Order> orders = customerService.getCustomerOrders(customerId);
        return new ResponseEntity<>(orders, HttpStatus.FOUND);
    }
}
