package com.example.travel.agency.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TravelPackageTest {
    TravelPackage travelPackage;
    Destination destination;
    Passenger passenger;

    @BeforeEach
    void setup() {

        travelPackage = new TravelPackage("TestPackage");
        destination = new Destination("TestDestination");
        passenger = new Passenger("TestPassenger", 1, MembershipTier.STANDARD);
    }

    @Test
    void travelPackageCreationTest() {

        assertEquals("TestPackage", travelPackage.getName());
        assertTrue(travelPackage.getItinerary().isEmpty());
        assertTrue(travelPackage.getPassengers().isEmpty());
    }

    @Test
    void addDestinationTest() {

        travelPackage.addDestination(destination);

        assertEquals(1, travelPackage.getItinerary().size());
        assertTrue(travelPackage.getItinerary().contains(destination));
    }

    @Test
    void addPassengerTest() {

        travelPackage.addPassenger(passenger);

        assertEquals(1, travelPackage.getPassengers().size());
        assertTrue(travelPackage.getPassengers().contains(passenger));
    }
}