package Models;

import Enums.GateType;

public class ExitGate extends Gate{

    public ExitGate(String id){
        super(id);
    }

    public GateType gettype(){
        return GateType.EXIT;
    }
}
