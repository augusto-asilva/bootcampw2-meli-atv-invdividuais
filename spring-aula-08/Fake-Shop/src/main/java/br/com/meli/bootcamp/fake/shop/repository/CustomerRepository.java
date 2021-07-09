package br.com.meli.bootcamp.fake.shop.repository;

import br.com.meli.bootcamp.fake.shop.domain.Customer;
import br.com.meli.bootcamp.fake.shop.domain.Order;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class CustomerRepository {

    public Map<Integer,Customer> customers;

    private static final String CUSTOMERS_JSON = "customers.json";

    private File getJson(String fileName) throws FileNotFoundException {
        File file = null;
        file = ResourceUtils.getFile("classpath:" + fileName);
        return file;
    }

    public CustomerRepository() {
        this.customers = new HashMap<Integer, Customer>();
    }

//    public void addCustomer(Customer customer) {
//        this.customers.put(customer.getId(), customer);
//    }

//    public List<Customer> findCustomers () {
//        return new ArrayList<>(this.customers.values());
//    }

//    public Customer findCustomer(Integer id) {
//        return this.customers.get(id);
//    }

    public Customer findCustomer(Integer customerId) {
        Optional<Customer> foundCustomer = this.findCustomers()
                .stream()
                .filter(x -> x.getId() == customerId)
                .findFirst();

        if (foundCustomer.isPresent()) {
            return foundCustomer.get();
        }
        return null;
    }

    public List<Customer> findCustomers() {
        List<Customer> customers = null;
        try {
            File file = this.getJson(CUSTOMERS_JSON);
            ObjectMapper mapper = new ObjectMapper();
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            mapper.setDateFormat(df);
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            TypeReference<List<Customer>> typeRef = new TypeReference<>() {
            };
            customers = mapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public void addCustomer(Customer customer) {
        List<Customer> customers = this.findCustomers();
        customers.add(customer);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        try {
            writer.writeValue(this.getJson(CUSTOMERS_JSON), customers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editCustomer(Integer id, Customer newCustomer) {
        List<Customer> customers = this.findCustomers();
        Customer customer = customers.stream()
                .filter(x -> x.getId() == id)
                .findFirst().get();

        customer.setName(newCustomer.getName());
        customer.setCpf(newCustomer.getCpf());
        customer.setEmail(newCustomer.getEmail());
        customer.setTelefone(newCustomer.getTelefone());
        customer.setOrders(newCustomer.getOrders());

        ObjectMapper mapper = new ObjectMapper();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        mapper.setDateFormat(df);
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        try {
            writer.writeValue(this.getJson(CUSTOMERS_JSON), customers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeCustomer(Integer customerId) {
        List<Customer> customers = this.findCustomers();
        boolean removed = customers.removeIf(x -> x.getId() == customerId);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        try {
            writer.writeValue(this.getJson(CUSTOMERS_JSON), customers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
