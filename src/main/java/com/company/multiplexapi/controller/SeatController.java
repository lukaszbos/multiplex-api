package com.company.multiplexapi.controller;

import com.company.multiplexapi.dto.SeatDto;
import com.company.multiplexapi.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seat")
public class SeatController {
    private final SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @PostMapping
    public ResponseEntity<SeatDto> reserveSeats (@RequestBody SeatDto seatDto){
        SeatDto addedSeatDto = seatService.reserveSeat(seatDto);
        return new ResponseEntity<>(addedSeatDto, HttpStatus.ACCEPTED);
    }

    @PutMapping
    public ResponseEntity<List<SeatDto>> reserveSeats (@RequestBody List<SeatDto> seatDtoList){
        List<SeatDto> addedDtos = seatService.reserveSeats(seatDtoList);
        return new ResponseEntity<>(addedDtos, HttpStatus.ACCEPTED);
    }

}