package template.mock_demo.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import template.mock_demo.model.Customer;
import template.mock_demo.model.Transaction;
import template.mock_demo.repository.TransactionRepository;
import template.mock_demo.service.CustomerService;
import template.mock_demo.service.TransactionService;
import template.mock_demo.utils.CustomerNotFoundException;
import template.mock_demo.utils.TransactionDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final CustomerService customerService;

    @Override
    public Transaction create(TransactionDTO request) {
//        validateTransaction(request);
        Customer customer = customerService.getOne(request.getCustomer_id());
        if (customer == null) {
            throw new CustomerNotFoundException("CUSTOMER NOT FOUND");
        }

        Transaction createTransaction = new Transaction();
        createTransaction.setCustomer(customer);
        createTransaction.setProduct_name(request.getProduct_name());
        createTransaction.setPrice(request.getPrice());
        createTransaction.setQuantity(request.getQuantity());
        return transactionRepository.save(createTransaction);
    }

    @Override
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getOne(Integer id) {
        return transactionRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("TRANSACTION NOT FOUND"));
    }

    @Override
    public Transaction update(TransactionDTO request, Integer id) {
        Transaction updateTransaction = this.getOne(id);
        Customer updateCustomer = customerService.getOne(request.getCustomer_id());
        updateTransaction.setCustomer(updateCustomer);
        updateTransaction.setProduct_name(request.getProduct_name());
        updateTransaction.setPrice(request.getPrice());
        updateTransaction.setQuantity(request.getQuantity());
        return transactionRepository.save(updateTransaction);
    }

    @Override
    public void delete(Integer id) {
        Transaction transaction = getOne(id);
        transactionRepository.delete(transaction);
    }
}
