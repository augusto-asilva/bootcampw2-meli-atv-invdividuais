package br.com.meli.bootcamp.fake.shop;

import br.com.meli.bootcamp.fake.shop.domain.Customer;
import br.com.meli.bootcamp.fake.shop.domain.Order;
import br.com.meli.bootcamp.fake.shop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

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

    public void updateCustomer(Integer id, Customer newCustomer) {
        customerRepository.editCustomer(id, newCustomer);
    }

    public void deleteCustomer(Integer id) {
        customerRepository.removeCustomer(id);
    }

    public List<Order> getCustomerOrders(Integer customerId) {
        return customerRepository.findCustomer(customerId).getOrders();
    }

    public List<Order> getCustomerOrdersByDate(Integer customerId, String dateStr) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(dateStr, dtf);

        return customerRepository.findCustomer(customerId)
                .getOrders()
                .stream()
                .filter(order -> order.getDate().isEqual(localDate))
                .collect(Collectors.toList());
    }
}
