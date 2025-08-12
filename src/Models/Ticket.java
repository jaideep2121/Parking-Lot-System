package Models;

import Enums.PaymentStatus;

import java.time.LocalDateTime;
import java.util.Locale;


import java.time.LocalDateTime;

public class Ticket {
    private String ticketId;
    private LocalDateTime entryTime;
    private Vehicle vehicle;
    private String floorId;
    private String spotId;
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;

    // Private constructor for builder
    private Ticket(Builder builder) {
        this.ticketId = builder.ticketId;
        this.entryTime = builder.entryTime;
        this.vehicle = builder.vehicle;
        this.floorId = builder.floorId;
        this.spotId = builder.spotId;
        this.paymentStatus = builder.paymentStatus;
    }

    // Getters
    public String getTicketId() {
        return ticketId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getFloorId() {
        return floorId;
    }

    public String getSpotId() {
        return spotId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    // Setters
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    // Builder Class
    public static class Builder {
        private String ticketId;
        private LocalDateTime entryTime;
        private Vehicle vehicle;
        private String floorId;
        private String spotId;
        private PaymentStatus paymentStatus = PaymentStatus.PENDING;

        public Builder ticketId(String ticketId) {
            this.ticketId = ticketId;
            return this;
        }

        public Builder entryTime(LocalDateTime entryTime) {
            this.entryTime = entryTime;
            return this;
        }

        public Builder vehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return this;
        }

        public Builder floorId(String floorId) {
            this.floorId = floorId;
            return this;
        }

        public Builder spotId(String spotId) {
            this.spotId = spotId;
            return this;
        }

        public Builder paymentStatus(PaymentStatus paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }
    }
}
