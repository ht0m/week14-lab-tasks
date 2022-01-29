package day02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {

    List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }
    
    public List<Movie> getMoviesWithActors(String actor) {
        return movies.stream()
                .filter(movie -> movie.getActors().contains(actor))
                .toList();

    }

    public int getLongestFilm() {
        return movies.stream()
                .mapToInt(o -> o.getLength())
                .max()
                .orElseThrow(() -> new IllegalArgumentException("No such film"));
    }
}
