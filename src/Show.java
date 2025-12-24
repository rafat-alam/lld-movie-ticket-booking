import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Show {
    int id;
    int movie_id;
    int screen_id;
    Time time;
    Date date;

    static Map<Integer, Map<Date, List<Show>>> listedShows = new HashMap<>();
    static int showsCount = 0;

    Show(int movie_id, int screen_id, Date date, Time time) {
        this.movie_id = movie_id;
        this.screen_id = screen_id;
        this.date = date;
        this.time = time;

        Movie movie = Movie.getById(movie_id);
        Screen screen = Screen.getById(screen_id);

        int start = time.hr * 60 + time.min;
        int end = start + movie.duration;

        listedShows.putIfAbsent(screen_id, new HashMap<>());
        Map<Date, List<Show>> dateMap = listedShows.get(screen_id);
        dateMap.putIfAbsent(date, new ArrayList<>());

        List<Show> existingShows = dateMap.get(date);

        // Check overlap
        for(Show s : existingShows) {
            Movie e_movie = Movie.getById(s.movie_id);

            int sStart = s.time.hr * 60 + s.time.min;
            int sEnd = sStart + e_movie.duration;

            if(start < sEnd && sStart < end) {
                System.out.println("Screen overlaps");
            }
        }

        this.id = ++showsCount;
        existingShows.add(this);

        System.out.println("Show added with id : " + showsCount + ", on Screen : " + screen.id + ", with Movie : " + movie.name);
    }

    static void fetchShow(int screen_id, Date date) {
        listedShows.putIfAbsent(screen_id, new HashMap<>());
        Map<Date, List<Show>> dateMap = listedShows.get(screen_id);
        dateMap.putIfAbsent(date, new ArrayList<>());

        List<Show> existingShows = dateMap.get(date);

        // Check overlap
        for(Show s : existingShows) {
            Movie e_movie = Movie.getById(s.movie_id);

            System.out.println("Movie Id : " + e_movie.id);
            System.out.println("Movie name : " + e_movie.name);
            System.out.println("Movie Duration : " + e_movie.duration);
            System.out.println("Time : " + s.time.hr + ":" + s.time.min);
        }
    }
}