package com.company.multiplexapi.dto;

import com.company.multiplexapi.model.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDto {
    Long clientId;
    String name;
    String surname;
    String typeOfTicket;

}
