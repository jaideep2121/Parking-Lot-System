package Strategy.Pricing;

import Enums.VehicleTypes;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class EventBasedPricing implements PricingStrategy {
   private static final Map<VehicleTypes,Double>EventRate=Map.of(
           VehicleTypes.TRUCK,70.0,
           VehicleTypes.CAR,50.0,
           VehicleTypes.BIKE,30.0
   );
    public double calculatefee(VehicleTypes type,LocalDateTime entrytime,LocalDateTime exitime){
        long durationminuted = Duration.between(entrytime, exitime).toMinutes();
        long totalHours = (long) Math.ceil(durationminuted / 60);


        double rateperhour=EventRate.getOrDefault(type,0.0);
        return rateperhour * totalHours;

    }
}
