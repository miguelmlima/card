package br.com.card.entity;

import br.com.card.entities.enums.CardApplication;
import br.com.card.entities.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "transaction")
public class Transaction {
    @Id
    private String id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date;

    @JsonFormat(pattern = ("HH:mm:ss"))
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private LocalTime time;

    private BigDecimal value;
    private CardApplication cardApplication;
    private PaymentStatus status;

    public Transaction() {
    }
}
