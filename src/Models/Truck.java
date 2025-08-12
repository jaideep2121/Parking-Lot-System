package Models;

import Enums.VehicleTypes;

public class Truck extends Vehicle{
    public Truck(String number){
        super(number, VehicleTypes.TRUCK);
    }
}
