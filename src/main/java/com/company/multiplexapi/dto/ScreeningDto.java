package com.company.multiplexapi.dto;

import com.company.multiplexapi.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScreeningDto {
    Long screeningId;
    LocalDateTime startTime;
    Movie movie;
}
