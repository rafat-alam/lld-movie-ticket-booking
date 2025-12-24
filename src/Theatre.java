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
        this.id = ++theatreCount;
        this.name = name;
        this.address = address;
        this.city = city;
        this.screen_ids = new ArrayList<>();
        listedTheatre.put(theatreCount, this);
        System.out.println("Theatre created with id : " + theatreCount);
    }

    static void addScreen(int theatre_id, int screen_id) {
        listedTheatre.get(theatre_id).screen_ids.add(screen_id);
        System.out.println("Screen added to Theatre with id : " + theatre_id);
    }

    static void fetchCity(String city, Date date) {
        for (int key : listedTheatre.keySet()) {
            Theatre value = listedTheatre.get(key);
            if(Objects.equals(value.city, city)) {
                System.out.println("Theatre id : " + value.id);
                System.out.println("Theatre name : " + value.name);
                System.out.println("Theatre Address : " + value.address);

                for(int screen_id : value.screen_ids) {
                    System.out.println();
                    Screen.fetchScreen(screen_id);
                    Show.fetchShow(screen_id, date);
                    System.out.println();
                }

                System.out.println();
                System.out.println("-------------------------------------");
                System.out.println();
            }
        }
    }
}
