package com.example.travel.agency.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DestinationTest {
    Activity activity;
    Destination destination;

    @BeforeEach
    void setup() {

        destination = new Destination("TestDestination");
        activity = new Activity("TestActivity", "Description", 50.0, 10, destination);
    }

    @Test
    void destinationCreationTest() {

        assertEquals("TestDestination", destination.getName());
        assertTrue(destination.getActivities().isEmpty());
    }

    @Test
    void addActivityTest() {

        destination.addActivity(activity);

        assertEquals(1, destination.getActivities().size());
        assertTrue(destination.getActivities().contains(activity));
    }
}