package Strategy.Pricing;

import Enums.VehicleTypes;

import java.time.LocalDateTime;

public interface PricingStrategy {
    double calculatefee(VehicleTypes type, LocalDateTime entryTime,LocalDateTime exitTime);
}
