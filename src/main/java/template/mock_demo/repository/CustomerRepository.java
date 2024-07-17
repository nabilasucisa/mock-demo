package template.mock_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import template.mock_demo.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
