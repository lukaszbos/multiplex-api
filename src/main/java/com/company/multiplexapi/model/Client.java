package com.company.multiplexapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long clientId;
    String name;
    String surname;
    String typeOfTicket;

    public Client(String name, String surname, String typeOfTicket) {
        this.name = name;
        this.surname = surname;
        this.typeOfTicket = typeOfTicket;
    }
}