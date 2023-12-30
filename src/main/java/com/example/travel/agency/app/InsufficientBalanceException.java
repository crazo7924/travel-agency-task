package com.example.travel.agency.app;

public final class InsufficientBalanceException extends RuntimeException {
    private final Passenger passenger;

    InsufficientBalanceException(Passenger passenger) {
        super("This Insufficient Balance for this passenger.");
        this.passenger = passenger;
    }

    public final Passenger getPassenger() {
        return passenger;
    }
}
