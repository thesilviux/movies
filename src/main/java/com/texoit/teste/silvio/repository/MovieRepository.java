package com.texoit.teste.silvio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.texoit.teste.silvio.model.Movie;
import com.texoit.teste.silvio.model.MovieWinnerProducer;
import com.texoit.teste.silvio.model.MovieWinnerStudio;

@Repository()
public interface MovieRepository extends JpaRepository<Movie, Long> {
	

	@Query(nativeQuery = true, value = "\r\n"
			+ "SELECT ag.*, m.ano AS `year`, m.winner \r\n"
			+ "FROM\r\n"
			+ "(\r\n"
			+ "	SELECT \r\n"
			+ "	    studios, \r\n"
			+ "	    count(1) AS times\r\n"
			+ "	FROM MOVIE \r\n"
			+ "	WHERE winner = 'yes'\r\n"
			+ "	GROUP BY studios\r\n"
			+ "	HAVING times > 1\r\n"
			+ ") ag\r\n"
			+ "LEFT JOIN MOVIE m ON ag.studios= m.studios \r\n"
			+ "WHERE winner = 'yes'\r\n"
			+ "ORDER BY ag.times DESC, ag.studios, `year`\r\n"
			+ "")
	List<MovieWinnerStudio> countWinnerAgregatedByStudios();
	
	@Query(nativeQuery = true, value = "\r\n"
			+ "SELECT ag.*, m.ano AS `year`, m.winner \r\n"
			+ "FROM\r\n"
			+ "(\r\n"
			+ "	SELECT \r\n"
			+ "	    producers, \r\n"
			+ "	    count(1) AS times\r\n"
			+ "	FROM MOVIE \r\n"
			+ "	WHERE winner = 'yes'\r\n"
			+ "	GROUP BY producers\r\n"
			+ "	HAVING times > 1\r\n"
			+ ") ag\r\n"
			+ "LEFT JOIN MOVIE m ON ag.producers= m.producers \r\n"
			+ "WHERE winner = 'yes'\r\n"
			+ "ORDER BY ag.times DESC, ag.producers, `year`\r\n"
			+ "")
	List<MovieWinnerProducer> countWinnerAgregatedByProducers();
	
}
