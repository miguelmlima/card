package br.com.card.entity;

import br.com.card.entities.enums.CardApplication;
import br.com.card.entities.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Setter
@Document(collection = "transaction")
public class Transaction {
    @Id
    private ObjectId _id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    @NotEmpty(message = "Data é obrigatório")
    private LocalDate date;

    @JsonFormat(pattern = ("HH:mm:ss"))
    @NotEmpty(message = "Time é obrigatório")
    private LocalTime time;

    @NotEmpty(message = "Value é obrigatório")
    private BigDecimal value;

    @NotEmpty(message = "não pode ser nulo")
    private CardApplication cardApplication;

    @NotEmpty(message = "não pode ser nulo")
    private PaymentStatus status;

    public Transaction() {
    }

    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) {this._id = _id; }

}
