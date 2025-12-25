package client;

import admin.Show;
import exceptions.IdNotFoundException;
import exceptions.IsNegException;
import exceptions.IsZeroOrNegException;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.min;

public class Payment {
    int paymentId;
    boolean state;
    double received;
    double refund;
    double purchased;
    boolean flag;
    int show_id;
    int user_id;
    int no_seat;


    static Map<Integer, Payment> paymentLog = new HashMap<>();
    static int paymentCount = 0;

    Payment(double received, int no_t, int show_id, int user_id) {
        paymentId = ++paymentCount;
        this.state = false;
        if(received < 0) {
            paymentLog.put(paymentCount, this);
            throw new IsNegException("Payment Failed! ID : " + paymentId);
        }
        if(no_t <= 0) {
            paymentLog.put(paymentCount, this);
            throw new IsZeroOrNegException("Payment Failed! ID : " + paymentId);
        }
        try {
            double price = Show.getPrice(show_id);
            int availableTickets = Show.getAvailableTicketCount(show_id);
            int booked = min((int) (received / price), min(no_t, availableTickets));
            double refund = received - price * booked;
            if(refund < 0) {
                paymentLog.put(paymentCount, this);
                System.out.println("Refund Amount : " + received);
                throw new IsNegException("Payment Failed! ID : " + paymentId);
            }
            Show.booked(show_id, booked, user_id);
            this.state = true;

            System.out.println("Payment Successful! ID : " + paymentId);
            System.out.println("No. of Booked Tickets : " + booked);
            if(refund > 0) {
                System.out.println("Refund Amount : " + refund);
            }
            this.received = received;
            this.refund = refund;
            this.purchased = booked * price;
            this.flag = received == purchased + refund;
            this.show_id = show_id;
            this.user_id = user_id;
            this.no_seat = booked;

            paymentLog.put(paymentCount, this);
        } catch (IdNotFoundException e) {
            throw new IdNotFoundException(e.getMessage());
        } catch (IsNegException e) {
            throw new IsNegException(e.getMessage());
        }
    }
}
