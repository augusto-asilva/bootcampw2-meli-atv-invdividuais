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
    public ResponseEntity<Customer> postCustomers(@RequestBody Customer customer) {
        Customer newCustomer = customerService.postCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<Customer> getCustomersById(@PathVariable Integer customerId) {
        Customer customer = customerService.getCustomer(customerId);
        return new ResponseEntity<>(customer, HttpStatus.FOUND);
    }

    @PutMapping("/customers/{customerId}")
    public ResponseEntity<String> putCustomersById(@PathVariable Integer customerId, @RequestBody Customer customer) {
        customerService.updateCustomer(customerId, customer);
        return new ResponseEntity<>("{ \"msg\": \"Updated customer with ID: " + customerId + "\"}", HttpStatus.FOUND);
    }

    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<String> deleteCustomersById(@PathVariable Integer customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>("{ \"msg\": \"Removed customer with ID: " + customerId + "\"}", HttpStatus.FOUND);
    }

    @GetMapping("/customers/{customerId}/orders")
    public ResponseEntity<List<Order>> getCustomerOrders(@PathVariable Integer customerId) {
        List<Order> orders = customerService.getCustomerOrders(customerId);
        return new ResponseEntity<>(orders, HttpStatus.FOUND);
    }

    @GetMapping("/customers/{customerId}/orders/{orderDate}")
    public ResponseEntity<List<Order>> getCustomerOrders(@PathVariable Integer customerId, @PathVariable String orderDate) {
        List<Order> orders = customerService.getCustomerOrdersByDate(customerId, orderDate);
        return new ResponseEntity<>(orders, HttpStatus.FOUND);
    }
}
