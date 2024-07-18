package template.mock_demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import template.mock_demo.model.Customer;
import template.mock_demo.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor

public class CustomerController {
    private CustomerService customerService;

    @PostMapping
    public Customer create (@RequestBody Customer request) {
        return customerService.create(request);
    }

    @GetMapping
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public Customer getOne(@PathVariable Integer id) {
        return customerService.getOne(id);
    }

    @PutMapping("/update/{id}")
    public Customer update(@RequestBody Customer request,
                           @PathVariable Integer id) {
        return customerService.update(request, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        customerService.delete(id);
    }
}
