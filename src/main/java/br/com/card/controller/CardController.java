package br.com.card.controller;

import br.com.card.dto.TransactionDTO;
import br.com.card.entity.Transaction;
import br.com.card.service.TransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(value = "API Rest cartões")
@CrossOrigin(origins="*")
public class CardController {

    private TransactionService service;

    @Autowired
    public CardController(TransactionService service) {
        this.service = service;

    }

    @RequestMapping(path = "/transactions", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Cadastra dados do cartão")
    public ResponseEntity<Void> createTransaction(@RequestBody Transaction transaction) {
        transaction = service.insert(transaction);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(transaction.get_id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(path = "/transactions/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retorna todos os cartões")
    public ResponseEntity<List<TransactionDTO>> findAll() {
        List<Transaction> list = service.findAll();
        List<TransactionDTO> listDto = list.stream().map(x -> new TransactionDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(path = "/transactions/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Atualiza dados do cartão")
    public ResponseEntity<Void> update(@RequestBody Transaction transactionDTO, @PathVariable("id") ObjectId id) {
        transactionDTO.set_id(id);
        service.update(transactionDTO);
        return ResponseEntity.noContent().build();
    }

}
