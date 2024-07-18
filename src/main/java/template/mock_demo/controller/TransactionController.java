package template.mock_demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import template.mock_demo.model.Transaction;
import template.mock_demo.service.TransactionService;
import template.mock_demo.utils.TransactionDTO;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
@RequiredArgsConstructor

public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
//    @Validated
    public Transaction create(@RequestBody TransactionDTO request) {
        return transactionService.create(request);
    }

    @GetMapping
    public List<Transaction> getAll() {
        return transactionService.getAll();
    }

    @GetMapping("/{id}")
    public Transaction getOne(@PathVariable Integer id) {
        return transactionService.getOne(id);
    }

    @PutMapping("/update/{id}")
    public Transaction update(@RequestBody TransactionDTO request,
                           @PathVariable Integer id) {
        return transactionService.update(request, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        transactionService.delete(id);
    }
}
