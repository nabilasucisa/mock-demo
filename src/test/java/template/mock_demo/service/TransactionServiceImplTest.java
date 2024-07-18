package template.mock_demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import template.mock_demo.model.Customer;
import template.mock_demo.model.Transaction;
import template.mock_demo.repository.TransactionRepository;
import template.mock_demo.service.implementation.TransactionServiceImpl;
import template.mock_demo.utils.CustomerNotFoundException;
import template.mock_demo.utils.TransactionDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class TransactionServiceImplTest {
    @Mock private TransactionRepository transactionRepository;
    @Mock private CustomerService customerService;

    @InjectMocks
    private TransactionServiceImpl transactionService;

    private Transaction transaction;
    private TransactionDTO transactionDTO;
    private Customer customer;

    @BeforeEach
    void setUp () throws ParseException {
        MockitoAnnotations.openMocks(this);
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
    void testTransactionGetAll_Success() {
        // Arrange or Given
        List<Transaction> transactions = Arrays.asList(new Transaction(), new Transaction());
        when(transactionRepository.findAll()).thenReturn(transactions);

        // Act or When
        List<Transaction> result = transactionService.getAll();

        // Assert ot Then
        assertEquals(transactions, result);
        verify(transactionRepository, times(1)).findAll();
    }

    @Test
    void testTransactionCreate_Success() {
        // Given
        when(customerService.getOne(1)).thenReturn(customer);
        when(transactionRepository.save(any(Transaction.class))).thenReturn(transaction);

        // When
        Transaction result = transactionService.create(transactionDTO);

        // Then
        assertEquals(transaction, result);
        verify(customerService,times(1)).getOne(1);
        verify(transactionRepository,times(1)).save(any(Transaction.class));
    }

    @Test
    void testTransactionGetOne_Success() {
        // Given
        when(transactionRepository.findById(1)).thenReturn(Optional.of(transaction));

        // When
        Transaction getOneTransaction = transactionService.getOne(1);

        // Then
        assertNotNull(getOneTransaction);
        assertEquals("Pensil",getOneTransaction.getProduct_name());
        assertEquals(2000,getOneTransaction.getPrice());
        assertEquals(2,getOneTransaction.getQuantity());
    }

    @Test
    void testTransactionCreate_FailedCustomerNotFound () {
        // Arrange
        Integer nonExistenceCustomerID = 999;
        transactionDTO.setCustomer_id(nonExistenceCustomerID);
        when(customerService.getOne(nonExistenceCustomerID)).thenReturn(null);

        // Then & Act (Act di dalam assert (then) karena pakai lambda)
        assertThatThrownBy(() -> transactionService.create(transactionDTO))
                .isInstanceOf(CustomerNotFoundException.class)
                .hasMessageContaining("CUSTOMER NOT FOUND");
        verify(customerService).getOne(nonExistenceCustomerID);
        verify(transactionRepository,never()).save(any(Transaction.class));
    }

    @Test
    void testTransactionUpdate_Success() {
        // Arrange
        Integer id = 1;

        // Create Update DTO
        TransactionDTO updateDTO = new TransactionDTO();
        updateDTO.setCustomer_id(1);
        updateDTO.setProduct_name("Penghapus");
        updateDTO.setQuantity(5);
        updateDTO.setPrice(1000);

        Transaction updateTrans = new Transaction();
        updateTrans.setId(id);
        updateTrans.setCustomer(transaction.getCustomer());
        updateTrans.setProduct_name(updateDTO.getProduct_name());
        updateTrans.setQuantity(updateDTO.getQuantity());
        updateTrans.setPrice(updateDTO.getPrice());

        when(transactionRepository.findById(id)).thenReturn(Optional.of(transaction));
        when(transactionRepository.save(any(Transaction.class))).thenReturn(updateTrans);

        // Act
        Transaction result = transactionService.update(updateDTO, id);

        // Assert
        assertEquals(result, updateTrans);
        verify(transactionRepository).findById(id);
        verify(transactionRepository).save(any(Transaction.class));
    }

}
