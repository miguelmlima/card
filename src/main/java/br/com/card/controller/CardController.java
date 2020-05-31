package br.com.card.controller;

import br.com.card.dto.TransactionDTO;
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
import java.util.stream.Collectors;

@RestController
public class CardController {

    private CardRepository cardRepository;
    private TransactionService service;

    @Autowired
    public CardController(TransactionService service){
        this.service = service;

    }
    @RequestMapping(path = "/transactions", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTransaction(@RequestBody Transaction transaction) {
      transaction = service.insert(transaction);
      URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(transaction.getId()).toUri();
      return ResponseEntity.created(uri).build();
    }
    @RequestMapping(path = "/transactions/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TransactionDTO>> findAll() {
        List<Transaction> list = service.findAll();
        List<TransactionDTO> listDto = list.stream().map(x -> new TransactionDTO(x)).collect(Collectors.toList());
         return ResponseEntity.ok().body(listDto);
    }
//    @RequestMapping(path = "/transactions/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Void> update(@RequestBody Transaction transaction, @PathVariable String id) {
//         transaction = cardRepository.findOne(transaction)


}
