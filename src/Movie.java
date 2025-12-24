import java.util.HashMap;
import java.util.Map;

public class Movie {
    int id;
    String name;
    int duration; // in minutes

    static Map<Integer, Movie> listedMovies = new HashMap<>();
    static int moviesCount = 0;

    Movie(String name, int duration) {
        this.id = ++moviesCount;
        this.name = name;
        this.duration = duration;
        listedMovies.put(moviesCount, this);
        System.out.println("Movie created with id : " + moviesCount);
    }

    static Movie getById(int movie_id) {
        return listedMovies.get(movie_id);
    }
}