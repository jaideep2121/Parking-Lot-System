package Strategy.Pricing;

import Enums.VehicleTypes;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TimeBasedPricing implements PricingStrategy {
    private static final LocalTime PEAK_START= LocalTime.of(8,0);

    private static final LocalTime PEAK_END= LocalTime.of(17,0);


    private boolean isPeak(LocalTime time){
        return !time.isBefore(PEAK_START) && !time.isAfter(PEAK_END);
    }

    public double  calculatefee(VehicleTypes type, LocalDateTime entrytime, LocalDateTime exitTime) {

        long durationminuted = Duration.between(entrytime, exitTime).toMinutes();
        long totalHours = (long) Math.ceil(durationminuted / 60);


        int peakHours = 0;
        int nonPekahours = 0;

        LocalDateTime cursor = entrytime.truncatedTo(ChronoUnit.HOURS);

        for (int i = 0; i < totalHours; i++) {
            LocalTime hourStart = cursor.toLocalTime();
            if (isPeak(hourStart)) peakHours++;
            else {
                nonPekahours++;
            }
            cursor = cursor.plusHours(1);
        }

        double peakRate = switch (type) {
            case CAR -> 30.0;
            case BIKE -> 15;
            case TRUCK -> 50;
        };
        double nonpeakRate = switch (type) {
            case CAR -> 20.0;
            case BIKE -> 10;
            case TRUCK -> 35;
        };

        return nonPekahours * nonpeakRate + peakHours * peakRate;
    }
}
