package Models;

import Enums.VehicleTypes;

import java.util.concurrent.atomic.AtomicBoolean;

public class ParkingSpot {

    private final String id;
    private final VehicleTypes allowedType;

    private AtomicBoolean occupied= new AtomicBoolean(false);

    public ParkingSpot(String id,VehicleTypes vehicleTypes){
        this.id=id;
        this.allowedType=vehicleTypes;
    }





    public void setOccupied(AtomicBoolean occupied) {
        this.occupied = occupied;
    }


    public VehicleTypes getAllowedType() {
        return allowedType;
    }

    public String getId() {
        return id;
    }

    public AtomicBoolean getOccupied() {
        return occupied;
    }

   public boolean tryOccpy(){
        return occupied.compareAndSet(false,true);
   }
   public void vacate(){
        occupied.set(false);
   }

   public boolean isOccupied(){
      return  occupied.get();
   }






}
