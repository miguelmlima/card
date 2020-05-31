package br.com.card.dto;

import br.com.card.entities.enums.CardApplication;
import br.com.card.entities.enums.PaymentStatus;
import br.com.card.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class TransactionDTO  {
    private  static final long serialVersionUID = 1L;

    private String id;
    private LocalDate date;
    private LocalTime time;
    private BigDecimal value;
    private CardApplication cardApplication;
    private PaymentStatus status;

    public TransactionDTO(Transaction transaction){
        id = transaction.get_id();
        date = transaction.getDate();
        time = transaction.getTime();
        value = transaction.getValue();
        cardApplication = transaction.getCardApplication();
        status = transaction.getStatus();
    }
}
