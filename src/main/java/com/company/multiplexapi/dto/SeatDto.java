package com.company.multiplexapi.dto;

import com.company.multiplexapi.model.Procurement;
import com.company.multiplexapi.model.Screening;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeatDto {
    Long seatId;
    int seatNumber;
    int numberOfRow;
    int screeningRoomNumber;
    private Procurement procurement;
    private Screening screening;


}

