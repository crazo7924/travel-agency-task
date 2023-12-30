package com.example.travel.agency.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PassengerTest {

    Passenger passenger;
    Destination destination;
    Activity activity;

    @BeforeEach
    void setup() {

        passenger = new Passenger("TestPassenger", 1, MembershipTier.STANDARD);
        destination = new Destination("TestDestination");
        activity = new Activity("TestActivity", "Description", 50.0, 10, destination);
    }

    @Test
    void passengerCreationTest() {

        assertEquals("TestPassenger", passenger.getName());
        assertEquals(1, passenger.getPassengerNumber());
        assertEquals(0.0, passenger.getBalance());
        assertEquals(MembershipTier.STANDARD, passenger.getMembershipTier());
        assertTrue(passenger.getSignedUpActivities().isEmpty());
    }

    @Test
    void signUpForActivityTest() {

        passenger.signUpForActivity(activity);

        assertEquals(0, passenger.getSignedUpActivities().size());
        assertFalse(passenger.getSignedUpActivities().contains(activity));
    }
}
