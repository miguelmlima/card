package br.com.card.dto;

import br.com.card.entities.enums.CardApplication;
import br.com.card.entities.enums.PaymentStatus;
import br.com.card.entity.Transaction;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
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
