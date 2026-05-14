

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Enums.City;

public class MovieController {
	Map<City,List<Movie>> cityVsMovies;
	
	List<Movie> allMovies;
	
	MovieController(){
		cityVsMovies=new HashMap<City, List<Movie>>();
		allMovies=new ArrayList<Movie>();
	}
	
	void addMovie(Movie movie,City city) {
		allMovies.add(movie);
		List<Movie>movieList=cityVsMovies.getOrDefault(city,new ArrayList<Movie>());
		movieList.add(movie);
		cityVsMovies.put(city,movieList);
		
	}
	
	Movie getMovieByName(String movieName) {
		for(Movie movie:allMovies) {
			if(movie.movieName.equals(movieName)) {
				return movie;
			}
		}
		return null;
	}
	
	List<Movie> getMoviesByCity(City city){
		return cityVsMovies.get(city);
	}
	
	
	//CRUD Opn
}
