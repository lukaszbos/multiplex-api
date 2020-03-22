package com.company.multiplexapi.service;

import com.company.multiplexapi.dto.SeatDto;
import com.company.multiplexapi.exception.NotFoundException;
import com.company.multiplexapi.mapper.ClientMapper;
import com.company.multiplexapi.mapper.MovieMapper;
import com.company.multiplexapi.mapper.ProcurementMapper;
import com.company.multiplexapi.mapper.ScreeningMapper;
import com.company.multiplexapi.mapper.SeatMapper;
import com.company.multiplexapi.model.Client;
import com.company.multiplexapi.model.Movie;
import com.company.multiplexapi.model.Procurement;
import com.company.multiplexapi.model.Screening;
import com.company.multiplexapi.model.Seat;
import com.company.multiplexapi.repository.ClientRepository;
import com.company.multiplexapi.repository.MovieRepository;
import com.company.multiplexapi.repository.ProcurementRepository;
import com.company.multiplexapi.repository.ScreeningRepository;
import com.company.multiplexapi.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatService {
    private final SeatMapper seatMapper;
    private final SeatRepository seatRepository;
    private final ProcurementRepository procurementRepository;
    private final ProcurementMapper procurementMapper;
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final ScreeningRepository screeningRepository;
    private final ScreeningMapper screeningMapper;
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Autowired
    SeatService(SeatMapper seatMapper, SeatRepository seatRepository, ProcurementRepository procurementRepository, ProcurementMapper procurementMapper,
                ClientRepository clientRepository, ClientMapper clientMapper, ScreeningRepository screeningRepository, ScreeningMapper screeningMapper,
                MovieRepository movieRepository, MovieMapper movieMapper) {
        this.seatMapper = seatMapper;
        this.seatRepository = seatRepository;
        this.procurementRepository = procurementRepository;
        this.procurementMapper = procurementMapper;
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
        this.screeningRepository = screeningRepository;
        this.screeningMapper = screeningMapper;
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    @Transactional(rollbackOn = Exception.class)
    public List<SeatDto> reserveSeats(List<SeatDto> seatDtoList) {
        List<Seat> seats = seatDtoList
                .stream()
                .map(seatDto -> seatMapper.toModel(seatDto))
                .collect(Collectors.toList());

        List<Seat> addedSeats = new ArrayList<>();
        for (Seat seat : seats) {
            Procurement constructedProcurement = constructProcurement(seat);
            procurementRepository.save(constructedProcurement);
            seat.setProcurement(constructedProcurement);

            Screening constructedScreening = constructScreening(seat);
            seat.setScreening(constructedScreening);

            Seat addedSeat = seatRepository.save(seat);
            addedSeats.add(addedSeat);
        }

        return addedSeats
                .stream()
                .map(seat -> seatMapper.toDto(seat))
                .collect(Collectors.toList());
    }


    @Transactional(rollbackOn = Exception.class)
    public SeatDto reserveSeat(SeatDto seatDto) {
        Seat seat = seatMapper.toModel(seatDto);

        Procurement constructedProcurement = constructProcurement(seat);
        procurementRepository.save(constructedProcurement);
        seat.setProcurement(constructedProcurement);

        Screening constructedScreening = constructScreening(seat);
        seat.setScreening(constructedScreening);

        Seat addedSeat = seatRepository.save(seat);

        return seatMapper.toDto(addedSeat);
    }

    public Procurement constructProcurement(Seat seatDto) {
        Client client = new Client(seatDto.getProcurement().getClient().getName(), seatDto.getProcurement().getClient().getSurname(), seatDto.getProcurement().getClient().getTypeOfTicket());
        Client addedClient = clientRepository.save(client);
        return new Procurement(seatDto.getProcurement().getTotalPrice(), LocalDateTime.now(), addedClient);
    }

    public Screening constructScreening(Seat seatDto) {
        Screening screening = getScreeningById(seatDto.getScreening().getScreeningId());
        Movie movie = getMovieById(screening.getMovie().getMovieId());
        screening.setMovie(movie);
        return screening;
    }

    private Screening getScreeningById(long screeningId) {
        return screeningRepository.findById(screeningId).orElseThrow(() -> new NotFoundException("Screening not Found"));
    }

    private Movie getMovieById(long movieId) {
        return movieRepository.findById(movieId).orElseThrow(() -> new NotFoundException("Movie not Found"));
    }
}
