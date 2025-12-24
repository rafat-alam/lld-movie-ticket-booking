import java.util.HashMap;
import java.util.Map;

public class Screen {
    int id;
    int theatreId;
    int capacity;

    static Map<Integer, Screen> listedScreen = new HashMap<>();
    static int screenCount = 0;

    Screen(int theatreId, int capacity) {
        this.id = ++screenCount;
        this.theatreId = theatreId;
        this.capacity = capacity;
        listedScreen.put(screenCount, this);
        System.out.println("Screen created with id : " + screenCount);
    }

    static Screen getById(int screen_id) {
        return listedScreen.get(screen_id);
    }

    static void fetchScreen(int screen_id) {
        System.out.println("Screen Id : " + screen_id);
        System.out.println("Screen Capacity : " + listedScreen.get(screen_id).capacity);
    }
}
