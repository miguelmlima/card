package br.com.card.service;

import br.com.card.entity.Transaction;
import br.com.card.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private CardRepository cardRepository;

    public List<Transaction> findAll() {
        return cardRepository.findAll();
    }
    public Transaction insert(Transaction transaction){
        return cardRepository.insert(transaction);
    }

//    public Transaction update(Transaction obj){
//        Transaction newObj = cardRepository.findOne();
//        updateTransaction(newObj, obj);
//        return cardRepository.save(newObj);
//    }
//    private void updateTransaction(Transaction newtransaction, Transaction transaction) {
//        newtransaction.setStatus(transaction.getStatus());
//        newtransaction.setCardApplication(transaction.getCardApplication());
//        newtransaction.setValue(transaction.getValue());
//    }

}
