package admin;

import exceptions.IdNotFoundException;
import exceptions.IsZeroOrNegException;
import universal.Date;

import java.util.*;

public class Screen {
    int id;
    int theatreId;
    int capacity;
    Map<Date, List<Integer>> show_ids;

    static Map<Integer, Screen> listedScreen = new HashMap<>();
    static int screenCount = 0;

    Screen(int theatreId, int capacity) {
        if(capacity <= 0) {
            throw new IsZeroOrNegException("Screen capacity must be positive");
        }
        try {
            Theatre.addScreen(theatreId, screenCount + 1);
        } catch (IdNotFoundException e) {
            throw new IdNotFoundException(e.getMessage());
        }
        this.id = ++screenCount;
        this.theatreId = theatreId;
        this.capacity = capacity;
        this.show_ids = new HashMap<>();
        listedScreen.put(screenCount, this);
        System.out.println("Screen created with id : " + screenCount);
    }

    static Screen getById(int screen_id) {
        Screen screen = listedScreen.get(screen_id);
        if (screen == null) {
            throw new IdNotFoundException("Screen id not found: " + screen_id);
        }
        return screen;
    }

    static void addShow(int screen_id, int show_id, Date date) {
        Screen screen = listedScreen.get(screen_id);
        List<Integer> showlist = screen.show_ids.computeIfAbsent(date, k -> new ArrayList<>());

        showlist.add(show_id);
    }

    static void fetchScreen(int screen_id, Date date) {
        Screen screen = listedScreen.get(screen_id);
        System.out.println("Screen Id : " + screen_id);
        System.out.println("Screen Capacity : " + screen.capacity);

        List<Integer> showlist = screen.show_ids.get(date);
        if(showlist != null) {
            for(int show_id : showlist) {
                Show.fetchShow(show_id);
            }
        }
    }
}
