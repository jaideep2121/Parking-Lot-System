package Models;

import Enums.VehicleTypes;

public class Car extends Vehicle {

    public Car(String number){
        super(number, VehicleTypes.CAR);
    }
}
