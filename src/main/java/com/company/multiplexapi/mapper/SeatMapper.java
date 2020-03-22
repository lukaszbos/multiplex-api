package com.company.multiplexapi.mapper;

import com.company.multiplexapi.dto.SeatDto;
import com.company.multiplexapi.model.Seat;
import org.springframework.stereotype.Component;

@Component
public class SeatMapper {
    public Seat toModel(SeatDto seatDto) {
        return Seat.builder()
                .seatNumber(seatDto.getSeatNumber())
                .numberOfRow(seatDto.getNumberOfRow())
                .screeningRoomNumber(seatDto.getScreeningRoomNumber())
                .procurement(seatDto.getProcurement())
                .screening(seatDto.getScreening())
                .build();
    }

    public SeatDto toDto(Seat seat) {
        return SeatDto.builder()
                .seatId(seat.getSeatId())
                .seatNumber(seat.getSeatNumber())
                .numberOfRow(seat.getNumberOfRow())
                .screeningRoomNumber(seat.getScreeningRoomNumber())
                .procurement(seat.getProcurement())
                .screening(seat.getScreening())
                .build();
    }
}
