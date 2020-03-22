package com.company.multiplexapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Procurement {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long procurementId;
    BigDecimal totalPrice;
    LocalDateTime procurementTime;

    @JoinColumn(name = "clientId")
    @OneToOne
    private Client client;

    public Procurement(BigDecimal totalPrice, LocalDateTime procurementTime, Client client) {
        this.totalPrice = totalPrice;
        this.client = client;
        this.procurementTime = procurementTime;

    }
}
