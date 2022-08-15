package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5 {
    public static Double execute() {
        List<Movie> movies = DataUtil.getMovies();

        Double res= movies.stream()
                .map(movie -> movie.getRating())
                .reduce(0.0, Double::max);

        return res;
    }
}
    /*public static Double execute() {
        List<Movie> movies = DataUtil.getMovies();
        return movies.stream().map(movie -> movie.getRating())
                .reduce(0.0, (rating1, rating2) -> rating1 > rating2 ? rating1 : rating2);
    }*/

/*public static Double execute() {
        List<Movie> movies = DataUtil.getMovies();
        Double rating = movies.stream()
                .reduce((movie1, movie2) -> movie1.getRating() > movie2.getRating() ? movie1 : movie2)
                .map(movie -> movie.getRating()).get();
        return rating;
    }*/