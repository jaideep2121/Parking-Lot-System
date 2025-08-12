package Services;

import Enums.PaymentMode;
import Enums.PrincingStratargy;
import Factory.Paymentstrategy;
import Factory.PricingStratgy;
import Models.ParkingFloor;
import Models.ParkingSpot;
import Models.Ticket;
import Models.Vehicle;
import Strategy.Payment.PaymentStrategy;
import Strategy.Pricing.PricingStrategy;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class ParkingLot {

    private static final ParkingLot INSTANCE=new ParkingLot();

    private  final Map<String, ParkingFloor>floors=new HashMap<>();
    private final Map<String,Ticket>activeticket=new HashMap<>();

    private PricingStrategy pricingStrategy;

    ParkingLot(){
        this.pricingStrategy= PricingStratgy.get(PrincingStratargy.TIME_BASED);
    }
    public static  ParkingLot getInstance(){
        return INSTANCE;
    }
    public void addFloor(ParkingFloor floor){
        floors.put(floor.getId(),floor);
    }

    public Ticket parkVehicle(Vehicle vehicle, LocalDateTime entryTime) {
        for (ParkingFloor floor : floors.values()) {
            ParkingSpot spot = floor.findAvailableSpot(vehicle.getType());
            if (spot != null) {
                String ticketId = UUID.randomUUID().toString();
                Ticket ticket = new Ticket.Builder()
                        .ticketId(ticketId)
                        .entryTime(entryTime)
                        .vehicle(vehicle)
                        .floorId(floor.getId())
                        .spotId(spot.getId())
                        .build();

              activeticket.put(ticketId, ticket);
                System.out.println("Vehicle parked " + ticketId);
                return ticket;
            }
        }
        System.out.println("No space for parking");
        return null;
    }

    public void unpark(String ticketId, LocalDateTime exprireTime, PaymentMode paymentMode){

        Ticket ticket=activeticket.get(ticketId);
        if(ticket==null){
            System.out.println("Inavlid ticket id");
            return;
        }
        double fee=pricingStrategy.calculatefee(ticket.getVehicle().getType(), ticket.getEntryTime(),exprireTime);

        PaymentStrategy paymentStrategy= Paymentstrategy.get(paymentMode);
        PaymentProcess paymentProcess= new PaymentProcess(paymentStrategy);
      boolean pay=  paymentProcess.pay(ticket,fee);
      if(!pay){
          System.out.println("failed  payment");
          return;
        }



       ParkingSpot spot=floors.get(ticket.getFloorId()).getSpots().get(ticket.getSpotId());
         spot.vacate();
       activeticket.remove(ticketId);

       System.out.println("Vehicle exit  with fess"+fee);







    }

    public void Seestatus(){
        for(Ticket ticket:activeticket.values()){
            System.out.println("Active Tickets "+ ticket.getTicketId());
        }

        for(ParkingFloor floor:floors.values()){
            System.out.println("Floor No is "+ floor.getId());
            Map<String, ParkingSpot> floorSpots = floor.getSpots();


            for (Map.Entry<String, ParkingSpot> entry : floorSpots.entrySet()) {
                String spotId = entry.getKey();
                ParkingSpot spot = entry.getValue();
                AtomicBoolean status = spot.getOccupied();
                String value = status.get() ? "Filled" : "Not filled";


                System.out.printf("%-10s %-15s %-10s%n",
                        spotId,
                        spot.getAllowedType(),
                        value);
            }



        }


    }


}
