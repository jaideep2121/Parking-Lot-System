package Models;

import Enums.VehicleTypes;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingFloor {

    public String getId() {
        return id;
    }

    private final String id;

    public Map<String, ParkingSpot> getSpots() {
        return spots;
    }

    private final Map<String, ParkingSpot> spots = new HashMap<>();

    public ParkingFloor(String id) {
        this.id = id;
    }


    public void addSpot(ParkingSpot spot) {
        spots.put(spot.getId(), spot);
    }

    public ParkingSpot findAvailableSpot(VehicleTypes vehicleTypes) {
        for (ParkingSpot spot : spots.values()) {
            if (spot.getAllowedType() == vehicleTypes && spot.tryOccpy()) {
                return spot;
            }
        }
        return null;
    }



}