package admin;

import exceptions.EmptyField;
import exceptions.IdNotFoundException;
import universal.Date;

import java.util.*;

public class Theatre {
    int id;
    String name;
    String address;
    String city;
    List<Integer> screen_ids;

    static Map<Integer, Theatre> listedTheatre = new HashMap<>();
    static int theatreCount = 0;

    Theatre(String name, String address, String city) {
        if(Objects.equals(name, "")) {
            throw new EmptyField("Theatre name must be there");
        }
        if(Objects.equals(address, "")) {
            throw new EmptyField("Theatre address must be there");
        }
        if(Objects.equals(city, "")) {
            throw new EmptyField("Theatre city must be there");
        }
        this.id = ++theatreCount;
        this.name = name;
        this.address = address;
        this.city = city;
        this.screen_ids = new ArrayList<>();
        listedTheatre.put(theatreCount, this);
        System.out.println("Theatre created with id : " + theatreCount);
    }

    static void addScreen(int theatre_id, int screen_id) {
        Theatre theatre = listedTheatre.get(theatre_id);
        if(theatre == null) {
            throw new IdNotFoundException("Theatre id not found: " + theatre_id);
        }
        theatre.screen_ids.add(screen_id);
        System.out.println("Screen added to Theatre with id : " + theatre_id);
    }

    static void fetchCity(String city, Date date) {
        if(Objects.equals(city, "")) {
            throw new EmptyField("Theatre city must be there");
        }
        for (int key : listedTheatre.keySet()) {
            Theatre value = listedTheatre.get(key);
            if(Objects.equals(value.city, city)) {
                System.out.println("Theatre id : " + value.id);
                System.out.println("Theatre name : " + value.name);
                System.out.println("Theatre Address : " + value.address);

                for(int screen_id : value.screen_ids) {
                    Screen.fetchScreen(screen_id, date);
                }
            }
        }
    }
}
