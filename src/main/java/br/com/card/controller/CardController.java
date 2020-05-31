package br.com.card.controller;

import br.com.card.entity.Transaction;
import br.com.card.repository.CardRepository;
import br.com.card.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class CardController {

    private CardRepository cardRepository;
    private TransactionService service;

    @Autowired
    public CardController(TransactionService service, CardRepository cardRepository){
        this.cardRepository = cardRepository;
        this.service = service;

    }
    @RequestMapping(path = "/transactions", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTransaction(@RequestBody Transaction transaction) {
      transaction = service.insert(transaction);
      URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(transaction.getId()).toUri();
      return ResponseEntity.created(uri).build();
    }
    @RequestMapping(path = "/transactions/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Transaction>> findAll() {
        List<Transaction> list = service.findAll();
         return ResponseEntity.ok().body(list);
    }
//    @RequestMapping(path = "/transactions/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Void> update(@RequestBody Transaction transaction, @PathVariable String id) {
//         transaction = cardRepository.findOne(transaction)


}
