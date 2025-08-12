package Services;

import Enums.PaymentStatus;
import Models.Ticket;
import Strategy.Payment.PaymentStrategy;

public class PaymentProcess {

    private final PaymentStrategy paymentStrategy;

    public PaymentProcess(PaymentStrategy paymentStrategy){
        this.paymentStrategy=paymentStrategy;
    }

    public boolean pay(Ticket ticket, double amount){
        boolean success=paymentStrategy.processPayment(ticket,amount);
        if(success){
            ticket.setPaymentStatus(PaymentStatus.SUCCES);
        }else{
            ticket.setPaymentStatus(PaymentStatus.FAILED);
            System.out.println("Status failed for that tickket"+ ticket.getTicketId());
        }
        return success;
    }
}
