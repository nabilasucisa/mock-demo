package template.mock_demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import template.mock_demo.model.Customer;
import template.mock_demo.model.Transaction;
import template.mock_demo.service.TransactionService;
import template.mock_demo.utils.TransactionDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@WebMvcTest(TransactionController.class)
public class TransactionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    TransactionService transactionService;

    @Autowired
    private ObjectMapper objectMapper;

    private Transaction transaction;
    private TransactionDTO transactionDTO;
    private Customer customer;

    @BeforeEach
    void setUp() throws ParseException {
        // init customer
        customer = new Customer();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        customer.setId(1);
        customer.setName("Budi");
        customer.setBirth_date(sdf.parse("2001-01-01"));

        // init transaction transactionDTO
        transactionDTO = new TransactionDTO();
        transactionDTO.setProduct_name("Pensil");
        transactionDTO.setPrice(2000);
        transactionDTO.setQuantity(2);
        transactionDTO.setCustomer_id(1);

        // init transaction
        transaction = new Transaction();
        transaction.setId(1);
        transaction.setProduct_name(transactionDTO.getProduct_name());
        transaction.setQuantity(transactionDTO.getQuantity());
        transaction.setPrice(transactionDTO.getPrice());
        transaction.setCustomer(transaction.getCustomer());
    }

    @Test
    void testCustomerControllerCreate() {

    }

}
