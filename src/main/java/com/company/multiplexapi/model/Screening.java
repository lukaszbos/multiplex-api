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
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Screening {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long screeningId;
    LocalDateTime startTime;

    @JoinColumn(name = "movieId")
    @ManyToOne
    Movie movie;

    public Screening(Movie movie, LocalDateTime startTime) {
        this.movie = movie;
        this.startTime = startTime;
    }
}
