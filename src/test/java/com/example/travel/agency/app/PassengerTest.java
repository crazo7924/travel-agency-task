package com.example.travel.agency.app;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PassengerTest {

    Passenger passenger;
    Passenger passenger2;
    Destination destination;
    Activity activity;

    @BeforeEach
    void setup() {

        passenger = new Passenger("TestPassenger", 1, MembershipTier.STANDARD);
        passenger2 = new Passenger("TestPassenger2", 2, MembershipTier.PREMIUM);
        destination = new Destination("TestDestination");
        activity = new Activity("TestActivity", "Description", 50.0, 1, destination);
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
    void signUpForActivityWithInsufficientBalanceTest() {
        assertThrows(InsufficientBalanceException.class, () -> passenger.signUpForActivity(activity));
        assertEquals(0.0, passenger.getBalance());
        assertEquals(0, passenger.getSignedUpActivities().size());
        assertFalse(passenger.getSignedUpActivities().contains(activity));
    }

    @Test
    void signUpForActivityWithSufficientBalanceTest() {

        passenger.addBalance(100.0);
        assertDoesNotThrow(() -> passenger.signUpForActivity(activity));
        assertEquals(50.0, passenger.getBalance());
        assertEquals(1, passenger.getSignedUpActivities().size());
        assertTrue(passenger.getSignedUpActivities().contains(activity));
    }

    @Test
    void signUpForActivityByPremiumMemberIsFreeOfCostTest() {
        passenger.setMembershipTier(MembershipTier.PREMIUM);
        passenger.addBalance(100.0);
        passenger.signUpForActivity(activity);
        assertEquals(MembershipTier.PREMIUM, passenger.getMembershipTier());
        assertEquals(100.0, passenger.getBalance());
    }

    @Test
    void signUpForActivityByGoldMemberIsDiscountedTest() {
        passenger.setMembershipTier(MembershipTier.GOLD);
        passenger.addBalance(100.0);
        double initialBalance = passenger.getBalance();
        passenger.signUpForActivity(activity);
        double currentBalance = passenger.getBalance();
        assertEquals(MembershipTier.GOLD, passenger.getMembershipTier());
        assertTrue((initialBalance - currentBalance) < activity.getCost());
        assertEquals(55.0, passenger.getBalance());
    }

    @Test
    void signUpForActivityWithFullCapacity() {
        passenger.addBalance(100.0);
        passenger.signUpForActivity(activity);
        assertEquals(0, activity.getCapacity());
        assertThrows(CapacityFullException.class, () -> passenger.signUpForActivity(activity));
    }
}
