package br.com.meli.bootcamp.fake.shop;

import br.com.meli.bootcamp.fake.shop.domain.Customer;
import br.com.meli.bootcamp.fake.shop.domain.Order;
import br.com.meli.bootcamp.fake.shop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findCustomers();
    }

    public Customer getCustomer(Integer id) {
        return customerRepository.findCustomer(id);
    }

    public Customer postCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
        return customer;
    }

    public List<Order> getCustomerOrders(Integer customerId) {
        return customerRepository.findCustomer(customerId).getOrders();
    }
}
