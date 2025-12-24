void main() {
    Scanner sc = new Scanner(System.in);

    while (true) {
        System.out.println("1. Add Theatre");
        System.out.println("2. Add Screen");
        System.out.println("3. Add Movie");
        System.out.println("4. Add Show");
        System.out.println("5. Show Me");
        System.out.println("Else. Exit");

        System.out.print("Enter : ");
        int x = sc.nextInt();
        sc.nextLine();

        if (x == 1) {
            System.out.print("Name : ");
            String name = sc.nextLine();

            System.out.print("Address : ");
            String address = sc.nextLine();

            System.out.print("City : ");
            String city = sc.nextLine();

            Listing.addTheatre(name, address, city);
        } else if (x == 2) {
            System.out.print("Theater Id : ");
            int theater_id = sc.nextInt();

            System.out.print("Capacity : ");
            int capacity = sc.nextInt();
            sc.nextLine();

            Listing.addScreen(theater_id, capacity);
        } else if (x == 3) {
            System.out.print("Name : ");
            String name = sc.nextLine();

            System.out.print("Duration in Minute : ");
            int duration = sc.nextInt();
            sc.nextLine();

            Listing.addMovie(name, duration);
        } else if (x == 4) {
            System.out.print("Movie Id : ");
            int movie_id = sc.nextInt();

            System.out.print("Screen Id : ");
            int screen_id = sc.nextInt();

            System.out.print("Date : ");
            int date = sc.nextInt();

            System.out.print("Month : ");
            int month = sc.nextInt();

            System.out.print("Year : ");
            int year = sc.nextInt();

            System.out.print("Hour : ");
            int hour = sc.nextInt();

            System.out.print("Minute : ");
            int min = sc.nextInt();
            sc.nextLine();

            Listing.addShow(movie_id, screen_id, date, month, year, hour, min);
        } else if (x == 5) {
            System.out.print("City : ");
            String city = sc.nextLine();

            System.out.print("Date : ");
            int date = sc.nextInt();

            System.out.print("Month : ");
            int month = sc.nextInt();

            System.out.print("Year : ");
            int year = sc.nextInt();
            sc.nextLine();

            Listing.fetchCity(city, date, month, year);
        } else {
            break;
        }
    }

    sc.close();
}