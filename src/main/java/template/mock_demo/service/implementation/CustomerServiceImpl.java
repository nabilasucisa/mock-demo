package template.mock_demo.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import template.mock_demo.model.Customer;
import template.mock_demo.repository.CustomerRepository;
import template.mock_demo.service.CustomerService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Customer create(Customer request) {
        return customerRepository.save(request);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getOne(Integer id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CUSTOMER NOT FOUND"));
    }

    @Override
    public Customer update(Customer request, Integer id) {
        Customer updatedCustomer = this.getOne(id);
        updatedCustomer.setName(request.getName());
        updatedCustomer.setBirth_date(request.getBirth_date());
        return customerRepository.save(updatedCustomer);
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }
}
