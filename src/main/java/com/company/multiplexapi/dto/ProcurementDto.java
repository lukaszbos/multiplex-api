package com.company.multiplexapi.dto;

import com.company.multiplexapi.model.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProcurementDto {
    Long procurementId;
    BigDecimal totalPrice;
    LocalDateTime procurementTime;
    Client client;
}
