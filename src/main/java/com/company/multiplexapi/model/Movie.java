package com.company.multiplexapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Movie")
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long movieId;
    String name;
    int runningTime;

    public Movie(String name, int runningTime) {
        this.name = name;
        this.runningTime = runningTime;
    }
}