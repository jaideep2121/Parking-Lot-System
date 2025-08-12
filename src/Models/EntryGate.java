package Models;

import Enums.GateType;
import Services.ParkingLot;

import java.time.LocalDateTime;

public class EntryGate extends Gate {
    public EntryGate(String id){
        super(id);
    }

    public GateType gettype(){
        return GateType.ENTRY;
    }


    public Ticket parkvehicle(Vehicle vehicle, LocalDateTime entrytime){
        return ParkingLot.getInstance().parkVehicle(vehicle,entrytime);
    }
}
