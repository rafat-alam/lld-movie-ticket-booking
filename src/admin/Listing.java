package admin;

import exceptions.*;
import universal.Date;
import universal.Time;

public class Listing {
    public static void addTheatre(String name, String address, String city) {
        try {
            Theatre temp = new Theatre(name, address, city);
        } catch (EmptyField e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addScreen(int theatre_id, int capacity) {
        try {
            Screen temp = new Screen(theatre_id, capacity);
        } catch (IsZeroOrNegException | IdNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addMovie(String name, int duration) {
        try {
            Movie temp = new Movie(name, duration);
        } catch (EmptyField | IsZeroOrNegException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addShow(int movie_id, int screen_id, double ticketPrice, int d, int m, int y, int hr, int min) {
        try {
            Date date = new Date(d, m, y);
            Time time = new Time(hr, min);

            Show temp = new Show(movie_id, screen_id, ticketPrice, date, time);
        } catch (IdNotFoundException | IsZeroOrNegException | YearException | TimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void fetchCity(String city, int d, int m, int y) {
        try {
            Date date = new Date(d, m, y);
            Theatre.fetchCity(city, date);
        } catch (EmptyField | IsZeroOrNegException | YearException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getBookedList(int show_id) {
        try {
            Show.getBookedList(show_id);
        } catch (IdNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
