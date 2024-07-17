package template.mock_demo.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import template.mock_demo.model.Customer;
import template.mock_demo.repository.CustomerRepository;
import template.mock_demo.service.implementation.CustomerServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

//    @Test
//    public void testCreateCustomer() throws ParseException {
//        // Given
//        Customer customer = new Customer();
//        customer.setName("Budi");
//            // Parse the date string
//        String birthDateString = "2001-01-01";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date birthDate = sdf.parse(birthDateString);
//        customer.setBirth_date(birthDate);
//
//        // When
//        Mockito.when(customerRepository.save(any(Customer.class))).thenReturn(customer);
//        Customer createdCustomer = customerService.create(customer);
//
//
//        // Then
//        assertEquals("Budi", createdCustomer.getName());
//        assertEquals(birthDate, createdCustomer.getBirth_date());
//        Mockito.verify(customerRepository, Mockito.times(1)).save(customer);
//    }

    @Test
    public void testGetAllCustomer() throws ParseException {
        // given
        String birthDateString1 = "2001-01-01";
        String birthDateString2 = "2002-02-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate1 = sdf.parse(birthDateString1);
        Date birthDate2 = sdf.parse(birthDateString2);
        Customer customer1 = new Customer(1, "Budi", birthDate1);
        Customer customer2 = new Customer(1, "Budi", birthDate1);

        // when
        Mockito.when(customerRepository.findAll()).thenReturn(List.of(customer1, customer2));
        List<Customer> customerList = customerService.getAll();

        // then
        assertThat(!customerList.isEmpty());
        assertThat(customerList.size()==2);
    }

}