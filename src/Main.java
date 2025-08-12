import Enums.PaymentMode;
import Enums.VehicleTypes;
import Factory.VehicleFactory;
import Models.*;
import Services.ParkingLot;

import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot=ParkingLot.getInstance();
        EntryGate entryGate= new EntryGate("EG1");
        ExitGate exitGate = new ExitGate("XG1");


        ParkingFloor floor1 = new ParkingFloor("F1");
        floor1.addSpot(new ParkingSpot("F1S1", VehicleTypes.CAR));
        floor1.addSpot(new ParkingSpot("F1S2", VehicleTypes.CAR));
        floor1.addSpot(new ParkingSpot("F1S3", VehicleTypes.BIKE));
        floor1.addSpot(new ParkingSpot("F1S4", VehicleTypes.BIKE));
        parkingLot.addFloor(floor1);

        System.out.println("--------------------------------------");
        Vehicle car = VehicleFactory.create("DL3CS1654",VehicleTypes.CAR);
        Vehicle car2 = VehicleFactory.create("DL3CS1654",VehicleTypes.BIKE);

//        LocalDateTime entrytime= LocalDateTime.parse("21 May  7:30 AM 2025");
        LocalDateTime entryTime = LocalDateTime.parse("2025-05-21T07:30:00");

        Ticket ticket= entryGate.parkvehicle(car,entryTime);
        Ticket ticket2= entryGate.parkvehicle(car2,entryTime);


        System.out.println("--------------------------------------");
           parkingLot.Seestatus();

        LocalDateTime exitTime = LocalDateTime.parse("2025-05-21T11:30:00");

        System.out.println("--------------------------------------");
        parkingLot.unpark(ticket.getTicketId(),exitTime, PaymentMode.UPI);


        System.out.println("--------------------------------------");

        parkingLot.Seestatus();




    }
}