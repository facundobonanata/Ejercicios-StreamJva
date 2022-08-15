package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();


        List<Map> movielist = movieLists.stream()
                .map(movieList -> movieList.getVideos())
                .flatMap(movies -> movies.stream())
                .map(datos ->
                        ImmutableMap.of(
                                "id", datos.getId(),
                                "title", datos.getTitle(),
                                "time", new Date(),
                                "url", datos.getBoxarts()
                                        .stream()
                                        .reduce((a, b) -> (a.getHeight() * a.getWidth() > b.getHeight() * b.getWidth()) ? a : b)// ? se cumple?dame el izquierdo, sino el otro
                                        .get().getUrl()))
                .collect(Collectors.toList());

        return movielist;
    }
}
