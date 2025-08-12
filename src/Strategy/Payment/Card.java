package Strategy.Payment;

import Enums.PaymentStatus;
import Models.Ticket;

public class Card implements PaymentStrategy{
    public boolean processPayment(Ticket ticket, double amount){
        System.out.println("Paid "+ amount + " for ticket" + ticket.getTicketId()+ "Status is"+ PaymentStatus.SUCCES);
        return true;
    }
}
