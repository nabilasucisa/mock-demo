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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    private Customer initialCust;

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @BeforeEach

    public void setUp() throws ParseException {
        initialCust = new Customer();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        initialCust.setId(1);
        initialCust.setName("Budi");
        initialCust.setBirth_date(sdf.parse("2001-01-01"));
    }

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
//
//    @Test
//    public void testGetAllCustomer() throws ParseException {
//        // given
//        String birthDateString1 = "2001-01-01";
//        String birthDateString2 = "2002-02-02";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date birthDate1 = sdf.parse(birthDateString1);
//        Date birthDate2 = sdf.parse(birthDateString2);
//        Customer customer1 = new Customer(1, "Budi", birthDate1);
//        Customer customer2 = new Customer(2, "Doremi", birthDate1);
//
//        // when
//        Mockito.when(customerRepository.findAll()).thenReturn(List.of(customer1, customer2));
//        List<Customer> customerList = customerService.getAll();
//
//        // then
//        assertThat(!customerList.isEmpty());
//        assertThat(customerList.size()==2);
//    }
//
//    @Test
//    public void testGetById() throws ParseException {
//        // given
//        String birthDateString = "2001-01-01";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date birthDate = sdf.parse(birthDateString);
//        Customer customer = new Customer(1, "Budi", birthDate);
//
//        // when
//        Mockito.when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
//        Customer getOneCust = customerService.getOne(1);
//
//        // then
//        assertNotNull(getOneCust);
//        assertEquals("Budi", getOneCust.getName());
//        assertEquals(birthDate, getOneCust.getBirth_date());
//    }
//
//    @Test
//    public void update() throws ParseException {
//        // Given
//        // Update
//        Customer updatedCust = new Customer();
//        updatedCust.setId(1);
//        updatedCust.setName("Updated Budi");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String birthDateStringUpd = "2002-02-02";
//        Date birthDateUpd = sdf.parse(birthDateStringUpd);
//        updatedCust.setBirth_date(birthDateUpd);
//
//        // When
//        Mockito.when(customerRepository.findById(any(Integer.class))).thenReturn(Optional.of(initialCust));
//        Mockito.when(customerRepository.save(any(Customer.class))).thenReturn(initialCust);
//        Customer updatedCustomer = customerService.update(updatedCust, updatedCust.getId());
//
//        // Then
//        Mockito.verify(customerRepository, Mockito.times(1)).findById(1);
//        Mockito.verify(customerRepository, Mockito.times(1)).save(initialCust);
//        assertEquals(updatedCust.getName(), updatedCustomer.getName());
//        assertEquals(updatedCust.getBirth_date(), updatedCustomer.getBirth_date());
//    }
//
//    @Test
//    public void delete() {
//        // When
//        given(customerRepository.findById(any(Integer.class))).willReturn(Optional.of(initialCust));
//        customerService.delete(1);
//        then(customerRepository).should().deleteById(1);
//        Customer getDeleteCustomer = customerService.getOne(1);
//
//        // Then
////        assertNull(getDeleteCustomer);
//        Mockito.verify(customerRepository, Mockito.times(1)).findById(1);
//        Mockito.verify(customerRepository, Mockito.times(1)).deleteById(1);
//    }
//
//    @Test
//    public void testCreateBlankName() throws ParseException {
//        // Given
//        Customer customer = new Customer();
//        customer.setName("");
//        // Parse the date string
//        String birthDateString = "2001-01-01";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date birthDate = sdf.parse(birthDateString);
//        customer.setBirth_date(birthDate);
//
//        // Then
//        assertThrows(RuntimeException.class, () -> customerService.create(customer));
//        then(customerRepository).should(never()).save(any(Customer.class));
//    }

//    @Test
//    public void testCreateInvalidDateFormat () throws ParseException {
//        // Given
//        Customer customer = new Customer();
//        customer.setName("Budi");
//        // Parse the date string
//        String birthDateString = "2000-13-32";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date birthDate = sdf.parse(birthDateString);
//        customer.setBirth_date(birthDate);
//
//        // then
//        assertThrows(RuntimeException.class, () -> customerService.create(customer));
//        then(customerRepository).should(never()).save(any(Customer.class));
//    }

    @Test
    public void testCreateNullBirthDate () throws ParseException {
        // Given
        Customer customer = new Customer();
        customer.setName("Budi");
        // not set any birthdate

        // then
        assertThrows(RuntimeException.class, () -> customerService.create(customer));
        then(customerRepository).should(never()).save(any(Customer.class));
    }



}