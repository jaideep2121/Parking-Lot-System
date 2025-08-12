package Models;

import Enums.VehicleTypes;

public class Bike extends  Vehicle{
   public Bike(String number){
       super(number, VehicleTypes.BIKE);
   }
}
