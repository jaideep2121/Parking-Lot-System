package Strategy.Payment;

import Models.Ticket;

public interface PaymentStrategy {
    public boolean processPayment(Ticket ticket, double amount);
}
