package com.company.multiplexapi.mapper;

import com.company.multiplexapi.dto.MovieDto;
import com.company.multiplexapi.model.Movie;
import org.springframework.stereotype.Component;


@Component
public class MovieMapper {

    public Movie toModel(MovieDto movieDto) {
        return new Movie(movieDto.getName(), movieDto.getRunningTime());
    }

    public MovieDto toDto(Movie movie){
        return new MovieDto(movie.getMovieId(),movie.getName(),movie.getRunningTime());
    }
}