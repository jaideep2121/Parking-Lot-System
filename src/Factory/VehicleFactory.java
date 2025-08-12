package Factory;

import Enums.VehicleTypes;
import Models.Bike;
import Models.Car;
import Models.Truck;
import Models.Vehicle;

public class VehicleFactory {

    public static Vehicle create(String number, VehicleTypes type){
        return switch (type){
            case CAR -> new Car(number);
            case BIKE -> new Bike(number);
            case TRUCK -> new Truck(number);

        };
    }
}
