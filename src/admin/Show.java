package admin;

import exceptions.IdNotFoundException;
import exceptions.IsNegException;
import universal.Date;
import universal.Time;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Show {
    int id;
    int movie_id;
    int screen_id;
    int leftCapacity;
    double ticketPrice;
    Time time;
    Date date;
    List<Integer> bookedUserId;

    static Map<Integer, Show> listedShows = new HashMap<>();
    static int showsCount = 0;

    Show(int movie_id, int screen_id, double ticketPrice, Date date, Time time) {
        this.ticketPrice = ticketPrice;
        this.movie_id = movie_id;
        this.screen_id = screen_id;
        this.date = date;
        this.time = time;
        this.bookedUserId = new ArrayList<>();

        try {
            Movie movie = Movie.getById(movie_id);
            Screen screen = Screen.getById(screen_id);

            this.leftCapacity = screen.capacity;

            int start = time.hr * 60 + time.min;
            int end = start + movie.duration;

            // Check overlap
            for(Show s : listedShows.values()) {
                if(s.date == date) {
                    Movie e_movie = Movie.getById(s.movie_id);

                    int sStart = s.time.hr * 60 + s.time.min;
                    int sEnd = sStart + e_movie.duration;

                    if(start < sEnd && sStart < end) {
                        System.out.println("Screen overlaps");
                    }
                }
            }

            this.id = ++showsCount;
            listedShows.put(showsCount, this);

            Screen.addShow(screen_id, showsCount, date);

            System.out.println("Show added with id : " + showsCount + ", on Screen : " + screen.id + ", with Movie : " + movie.name);
        } catch (IdNotFoundException e) {
            throw new IdNotFoundException(e.getMessage());
        }
    }

    public static void fetchShow(int show_id) {
        Show show = listedShows.get(show_id);

        if(show == null) {
            throw new IdNotFoundException("Show id not found: " + show_id);
        }

        System.out.println("Show Id : " + show.id);
        Movie.fetchMovie(show.movie_id);
        System.out.println("Left Seat : " + show.leftCapacity);
        System.out.println("Ticket Price : Rs." + show.ticketPrice);
        System.out.println("Show Time : " + show.time.hr + ":" + show.time.min);
    }

    public static double getPrice(int show_id) {
        Show show = listedShows.get(show_id);

        if(show == null) {
            throw new IdNotFoundException("Show id not found: " + show_id);
        }

        return show.ticketPrice;
    }

    public static int getAvailableTicketCount(int show_id) {
        Show show = listedShows.get(show_id);

        if(show == null) {
            throw new IdNotFoundException("Show id not found: " + show_id);
        }

        return show.leftCapacity;
    }

    public static void booked(int show_id, int cnt, int user_id) {
        Show show = listedShows.get(show_id);

        if(show == null) {
            throw new IdNotFoundException("Show id not found: " + show_id);
        }

        if(show.leftCapacity < cnt) {
            throw new IsNegException("Left Seat went negative on show id : " + show_id);
        }

        show.leftCapacity -= cnt;
        for(int i = 0; i < cnt; i++) {
            show.bookedUserId.add(user_id);
        }
    }

    static void getBookedList(int show_id) {
        Show show = listedShows.get(show_id);

        if(show == null) {
            throw new IdNotFoundException("Show id not found: " + show_id);
        }

        System.out.print("Users : ");
        for(int user_id : show.bookedUserId) {
            System.out.print( user_id+ ", ");
        }
        System.out.println();

        System.out.println("Left Seats : " + show.leftCapacity);
    }
}