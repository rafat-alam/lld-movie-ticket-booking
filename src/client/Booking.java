package client;

import admin.Show;
import exceptions.IdNotFoundException;
import exceptions.IsNegException;
import exceptions.IsZeroOrNegException;

public class Booking {
    public static void initBookTicket(int show_id) {
        Show.fetchShow(show_id);
    }

    public static void getPaymentTotal(int show_id, int no_t) {
        double price = Show.getPrice(show_id);
        System.out.println("Total you have to Pay : " + price * no_t);
    }

    public static void Payment(double amount, int show_id, int no_t, int user_id) {
        try {
            Payment temp = new Payment(amount, no_t, show_id, user_id);
        } catch (IdNotFoundException | IsZeroOrNegException | IsNegException e) {
            System.out.println(e.getMessage());
        }
    }
}