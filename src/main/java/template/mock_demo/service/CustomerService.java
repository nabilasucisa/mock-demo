package template.mock_demo.service;

import template.mock_demo.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer create(Customer request);
    List<Customer> getAll();
    Customer getOne(Integer id);
    Customer update(Customer request, Integer id);
    void delete(Integer id);
}
