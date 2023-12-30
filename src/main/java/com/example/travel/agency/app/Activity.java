package com.example.travel.agency.app;

class Activity {
    private int id;
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private Destination destination;

    public Activity(String name, String description, double cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    /**
     * @apiNote Note that the id is meant to be auto-generated (if not set) and then
     *          assigned.
     * @param id the unique id of this activity.
     */
    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCapacity() {
        return capacity;
    }

    /**
     * Attempts to occupy and thereby reduce this Activity's capacity.
     * 
     * @throws CapacityFullException when the capacity is full. @see
     *                               {@link #isCapacityFull}
     */
    public void participate() throws CapacityFullException {
        if (isCapacityFull())
            throw new CapacityFullException(this);
        else
            capacity--;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    /**
     * Checks if the current capacity is zero.
     * This is equivalent to comparing the value of {@link #getCapacity} with zero.
     * 
     * @return a boolean value indicating if this Activity can be participated in or
     *         not.
     */
    public boolean isCapacityFull() {
        return capacity == 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        long temp;
        temp = Double.doubleToLongBits(cost);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + capacity;
        result = prime * result + id;
        result = prime * result + ((destination == null) ? 0 : destination.hashCode());
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
        Activity other = (Activity) obj;
        if (this.id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
            return false;
        if (capacity != other.capacity)
            return false;
        if (destination == null) {
            if (other.destination != null)
                return false;
        } else if (!destination.equals(other.destination))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Activity [name=" + name + ", description=" + description + ", cost=" + cost + ", capacity=" + capacity
                + ", destination=" + destination + "]";
    }
}