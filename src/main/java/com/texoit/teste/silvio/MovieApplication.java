package com.texoit.teste.silvio;

import java.io.FileReader;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;

import com.texoit.teste.silvio.model.Movie;
import com.texoit.teste.silvio.repository.MovieRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class MovieApplication {
	
	@Autowired
	private MovieRepository movieRepository;

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}

	@EventListener(ContextRefreshedEvent.class)
	@Transactional
	public void insertMoviesFromCSV(ContextRefreshedEvent e) {
		System.out.println("ContextRefreshedEvent");
		var moviesFileName = "movielist.csv";
		
        try (Reader inputReader = new FileReader(new ClassPathResource(moviesFileName).getFile())) {
            CSVFormat.EXCEL.builder()
            	.setDelimiter(';')
                .setAllowMissingColumnNames(true)
                .setHeader("year", "title", "studios", "producer", "winner")
                .setSkipHeaderRecord(true)
                .build().parse(inputReader).forEach(record -> {
                    Movie movie = new Movie();
                    movie.setAno(record.get("year"));
                    movie.setTitle(record.get("title"));
                    movie.setStudios (record.get("studios"));
                    movie.setProducers  (record.get("producer"));
                    movie.setWinner (record.get("winner"));
                    movieRepository.save(movie);
                    System.out.println(movie);
                });
        } catch (Exception ex) {
            System.out.println("Não conseguiu ler arquivo CSV " + moviesFileName);
            ex.printStackTrace();
        }
	}

}