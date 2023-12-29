package com.example.travel.agency.app;

import java.util.ArrayList;
import java.util.List;

class TravelPackage {
    private int id;
    private String name;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    public TravelPackage(String name) {
        this.name = name;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Destination> getItinerary() {
        return itinerary;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void addDestination(Destination destination) {
        itinerary.add(destination);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((itinerary == null) ? 0 : itinerary.hashCode());
        result = prime * result + ((passengers == null) ? 0 : passengers.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TravelPackage other = (TravelPackage) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (itinerary == null) {
            if (other.itinerary != null)
                return false;
        } else if (!itinerary.equals(other.itinerary))
            return false;
        if (passengers == null) {
            if (other.passengers != null)
                return false;
        } else if (!passengers.equals(other.passengers))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TravelPackage [id=" + id + ", name=" + name +
                ", itinerary=" + itinerary + ", passengers=" + passengers + "]";
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }
}