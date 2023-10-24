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
	
	@Query(nativeQuery = true, value = """
		SELECT DISTINCT
            studios, ano AS `year`
        FROM
            MOVIE    
        WHERE
            winner = 'yes'   
	""")
	List<MovieWinnerStudio> countWinnerAgregatedByStudios();

	@Query(nativeQuery = true, value = """
		SELECT DISTINCT
	        producers, ano AS `year`
	    FROM
	        MOVIE    
	    WHERE
	        winner = 'yes'   
	""")
	List<MovieWinnerProducer> countWinnerAgregatedByProducers();
	
}
