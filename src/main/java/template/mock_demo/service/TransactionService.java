package template.mock_demo.service;

import template.mock_demo.model.Transaction;
import template.mock_demo.utils.TransactionDTO;

import java.util.List;

public interface TransactionService {
    Transaction create(TransactionDTO request);
    List<Transaction> getAll();
    Transaction getOne(Integer id);
    Transaction update(TransactionDTO request, Integer id);
    void delete(Integer id);
}
