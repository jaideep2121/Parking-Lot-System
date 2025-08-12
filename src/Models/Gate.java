package Models;

import Enums.GateType;
import Services.ParkingLot;

import java.time.LocalDateTime;

public abstract class Gate {
    protected final String id;

    Gate(String id){
        this.id=id;
    }

    public abstract GateType gettype();

}
