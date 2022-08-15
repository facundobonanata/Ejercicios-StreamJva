package katas;

import com.google.common.collect.ImmutableList;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Use map() and flatMap() to project and flatten the movieLists into an array of video ids (flatMap(c -> c.stream()))
    DataSource: DataUtil.getMovieLists()
    Output: List of Integers
*/
public class Kata3 {
    public static List<Integer> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Integer> videoList = movieLists
                .stream()
                //obtenemos todas las peliculas
                .map(movieList -> movieList.getVideos())
                //operacion intermedia, pasamos la info y la devolvemos al map
                //flatMap devuelve un flujo
                .flatMap(c -> c.stream())
                //tomar id luego de sacar las peliculas con flatmap
                .map(movie -> movie.getId())
                //transformamos a lista
                .collect(Collectors.toUnmodifiableList());

        return videoList;
    }
}
