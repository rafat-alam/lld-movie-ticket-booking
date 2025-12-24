public class Listing {
    static void addTheatre(String name, String address, String city) {
        Theatre temp = new Theatre(name, address, city);
    }

    static void addScreen(int theatre_id, int capacity) {
        Screen temp = new Screen(theatre_id, capacity);
        Theatre.addScreen(theatre_id, temp.id);
    }

    static void addMovie(String name, int duration) {
        Movie temp = new Movie(name, duration);
    }

    static void addShow(int movie_id, int screen_id, int d, int m, int y, int hr, int min) {
        Date date = new Date(d, m, y);
        Time time = new Time(hr, min);

        Show temp = new Show(movie_id, screen_id, date, time);
    }

    static void fetchCity(String city, int d, int m, int y) {
        Date date = new Date(d, m, y);
        Theatre.fetchCity(city, date);
    }
}
