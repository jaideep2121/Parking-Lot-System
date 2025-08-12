package Models;

import Enums.VehicleTypes;

public abstract  class Vehicle {
    private final String number;
    private final VehicleTypes type;

    public Vehicle(String number , VehicleTypes type){
        this.number=number;
        this.type=type;
    }
    public String getNumber() {
        return number;
    }

    public VehicleTypes getType() {
        return type;
    }



}
