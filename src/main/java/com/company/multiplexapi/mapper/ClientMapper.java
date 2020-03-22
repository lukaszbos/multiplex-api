package com.company.multiplexapi.mapper;

import com.company.multiplexapi.dto.ClientDto;
import com.company.multiplexapi.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public Client toModel(ClientDto clientDto) {
        return new Client(clientDto.getName(), clientDto.getSurname(), clientDto.getTypeOfTicket());
    }

    public ClientDto toDto(Client client) {
        return new ClientDto(client.getClientId(), client.getName(), client.getSurname(), client.getTypeOfTicket());
    }
}