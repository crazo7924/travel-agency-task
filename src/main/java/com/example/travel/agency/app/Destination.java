package com.example.travel.agency.app;

import java.util.ArrayList;
import java.util.List;

class Destination {
    private int id;
    private String name;
    private List<Activity> activities;

    /**
     * @param name The human-readable name of this destination meant for displaying
     *             at the front-end side.
     * 
     */
    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    /**
     * @param activity The activity to be added and that is unique to this
     *                 destination.
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public int getId() {
        return id;
    }

    /**
     * @apiNote Note that the id is meant to be auto-generated (if not set) and then
     *          assigned.
     * @param id the unique id of this destination.
     */
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((activities == null) ? 0 : activities.hashCode());
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
        Destination other = (Destination) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (activities == null) {
            if (other.activities != null)
                return false;
        } else if (!activities.equals(other.activities))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Destination [id=" + id + ", name=" + name + ", activities=" + activities + "]";
    }
}