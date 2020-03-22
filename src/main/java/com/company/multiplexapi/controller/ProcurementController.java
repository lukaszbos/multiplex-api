package com.company.multiplexapi.controller;

import com.company.multiplexapi.dto.ProcurementDto;
import com.company.multiplexapi.model.Client;
import com.company.multiplexapi.service.ProcurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
@RequestMapping("/procurement")
public class ProcurementController {
    private final ProcurementService procurementService;

    @Autowired
    public ProcurementController(ProcurementService procurementService){
        this.procurementService = procurementService;
    }

    @GetMapping
    public ResponseEntity<ProcurementDto> getProcurement(){
        ProcurementDto procurementDto = new ProcurementDto((long) 1,new BigDecimal(1, MathContext.DECIMAL32), LocalDateTime.now(),new Client());
        return new ResponseEntity<>(procurementDto, HttpStatus.ACCEPTED);
    }
    @PostMapping
    public ResponseEntity<ProcurementDto> placeProcurement(@RequestBody ProcurementDto procurementDto){
        ProcurementDto placedProcurementDto = procurementService.placeProcurement(procurementDto);
        return new ResponseEntity<>(placedProcurementDto, HttpStatus.CREATED);
    }


}