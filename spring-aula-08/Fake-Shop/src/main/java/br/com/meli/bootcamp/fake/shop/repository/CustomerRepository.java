package br.com.meli.bootcamp.fake.shop.repository;

import br.com.meli.bootcamp.fake.shop.domain.Customer;
import br.com.meli.bootcamp.fake.shop.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepository {

    public Map<Integer,Customer> customers;

    public CustomerRepository() {
        this.customers = new HashMap<Integer, Customer>();
    }

    public void addCustomer(Customer customer) {
        this.customers.put(customer.getId(), customer);
    }

    public List<Customer> findCustomers () {
        return new ArrayList<>(this.customers.values());
    }

    public Customer findCustomer(Integer id) {
        return this.customers.get(id);
    }

    public void editCustomer(Integer id, Customer newCustomer) {
        Customer customer = findCustomer(id);
        customer.setName(newCustomer.getName());
        customer.setCpf(newCustomer.getCpf());
        customer.setEmail(newCustomer.getEmail());
        customer.setTelefone(newCustomer.getTelefone());
        customer.setOrders(newCustomer.getOrders());
    }

    public void removeCustomer(Integer id) {
        this.customers.remove(id);
    }
}
