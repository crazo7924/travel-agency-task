package com.example.travel.agency.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ActivityTest {

    Destination destination;
    Activity activity;

    @BeforeEach
    void setup() {

        destination = new Destination("TestDestination");
        activity = new Activity("TestActivity", "Description", 50.0, 10, destination);
    }

    @Test
    void activityCreationTest() {
        
        assertEquals("TestActivity", activity.getName());
        assertEquals("Description", activity.getDescription());
        assertEquals(50.0, activity.getCost());
        assertEquals(10, activity.getCapacity());
        assertEquals(destination, activity.getDestination());
    }
}
