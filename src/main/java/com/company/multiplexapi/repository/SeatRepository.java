package com.company.multiplexapi.repository;

import com.company.multiplexapi.dto.SeatDto;
import com.company.multiplexapi.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public
interface SeatRepository extends JpaRepository<Seat, Long> {

}