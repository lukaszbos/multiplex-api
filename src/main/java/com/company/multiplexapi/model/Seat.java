package com.company.multiplexapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long seatId;
    int seatNumber;
    int numberOfRow;
    int screeningRoomNumber;

    @JoinColumn(name = "procurementId")
    @ManyToOne
    private Procurement procurement;

    @JoinColumn(name = "screeningId")
    @ManyToOne
    private Screening screening;

    private Seat(int seatNumber, int numberOfRow, int screeningRoomNumber, Procurement procurement, Screening screening) {
        this.seatNumber = seatNumber;
        this.numberOfRow = numberOfRow;
        this.screeningRoomNumber = screeningRoomNumber;
        this.procurement = procurement;
        this.screening = screening;
    }

}
