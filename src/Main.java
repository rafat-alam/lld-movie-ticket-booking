import admin.Listing;
import client.Booking;

void main() {
    Scanner sc = new Scanner(System.in);

    while (true) {
        try {
            System.out.println("1. Add Theatre");
            System.out.println("2. Add Screen");
            System.out.println("3. Add Movie");
            System.out.println("4. Add Show");
            System.out.println("5. Show Me City List");
            System.out.println("6. Book Tickets");
            System.out.println("7. Booked Seat List");
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

                System.out.print("Ticket Price : ");
                double ticketPrice = sc.nextDouble();

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

                Listing.addShow(movie_id, screen_id, ticketPrice, date, month, year, hour, min);
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
            } else if (x == 6) {
                System.out.print("Show Id : ");
                int show_id = sc.nextInt();
                System.out.print("User Id : ");
                int user_id = sc.nextInt();
                sc.nextLine();
                Booking.initBookTicket(show_id);

                System.out.print("No of tickets : ");
                int no_t = sc.nextInt();
                sc.nextLine();
                Booking.getPaymentTotal(show_id, no_t);

                System.out.print("Pay : Rs.");
                double amount = sc.nextDouble();
                sc.nextLine();
                Booking.Payment(amount, show_id, no_t, user_id);
            } else if(x == 7) {
                System.out.print("Show Id : ");
                int show_id = sc.nextInt();
                sc.nextLine();

                Listing.getBookedList(show_id);
            } else {
                break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    sc.close();
}