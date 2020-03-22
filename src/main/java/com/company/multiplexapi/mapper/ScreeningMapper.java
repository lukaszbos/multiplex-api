package com.company.multiplexapi.mapper;

import com.company.multiplexapi.dto.ScreeningDto;
import com.company.multiplexapi.model.Screening;
import org.springframework.stereotype.Component;

@Component
public class ScreeningMapper {

    public Screening toModel(Screening screening) {
        return new Screening(screening.getMovie(), screening.getStartTime());
    }

    public ScreeningDto toDto(ScreeningDto screeningDto) {
        return new ScreeningDto(screeningDto.getScreeningId(), screeningDto.getStartTime(), screeningDto.getMovie());
    }
}
