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

    //find movie
    // ilyesmik lesznek a vizsgán
    //flatmap lehet, hoyg lesz... : összefésüli a belső listákat, ha többdimenziós a struktúra
    //onnantó meg lehet hívni a metódusokat
    //itt vannak ismétlődések, distinct-tel lehet kiszűrni a duplikációkat

    public List<Movie> getMoviesWithActors(String actor) {
        return movies.stream()
                //
                .filter(m->m.getActors().contains(actor))
//                .filter(movie -> movie.getActors().stream().anyMatch(a -> a.equals(actor)))
                .toList();
    }

    public int getLongestFilm() {
        return movies.stream()
                .mapToInt(o -> o.getLength())
                .max()
                .orElseThrow(() -> new IllegalArgumentException("No such film"));
    }
}
