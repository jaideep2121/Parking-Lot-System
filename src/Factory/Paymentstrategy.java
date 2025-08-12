package Factory;

import Enums.PaymentMode;
import Strategy.Payment.Card;
import Strategy.Payment.Cash;
import Strategy.Payment.PaymentStrategy;
import Strategy.Payment.Upi;

import static Enums.PaymentMode.*;

public class Paymentstrategy {
    public static PaymentStrategy get(PaymentMode mode){
        return switch(mode){
            case CASH-> new Cash();
            case UPI->new Upi();
            case CARD-> new Card();
        };
    }

}
