package com.example.travel.agency.app;

import java.util.ArrayList;
import java.util.List;

class Passenger {
    private int id;
    private String name;

    private int passengerNumber;

    private double balance;
    private MembershipTier membershipTier;
    private List<Activity> signedUpActivities;

    /**
     * @param name            The human-readable name
     * @param passengerNumber The number of this passenger
     * @param tier            the {@link MembershipTier} this passenget holds
     */
    public Passenger(String name, int passengerNumber, MembershipTier tier) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.membershipTier = tier;
        this.signedUpActivities = new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    /**
     * @apiNote Note that the id is meant to be auto-generated (if not set) and then
     *          assigned.
     * @param id the unique id of this passenger.
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

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }

    public MembershipTier getMembershipTier() {
        return membershipTier;
    }

    public void setMembershipTier(MembershipTier membershipTier) {
        this.membershipTier = membershipTier;
    }

    public List<Activity> getSignedUpActivities() {
        return signedUpActivities;
    }

    /**
     * @param activity The activity that a passenger attempts to signup for.
     * @return a boolean value indicating sufficient {@link #balance} is present
     *         after
     *         deduction considering the discount amount according to the
     *         {@link MembershipTier} and checking for the activity's capacity.
     */
    public void signUpForActivity(Activity activity) throws RuntimeException {
        double cost = activity.getCost();
        double discountedCost = cost * (1.0 - membershipTier.getDiscount());
        if ((balance - discountedCost) < 0) {
            throw new InsufficientBalanceException(this);
        }
        activity.participate();
        balance -= discountedCost;
        signedUpActivities.add(activity);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + passengerNumber;
        long temp;
        temp = Double.doubleToLongBits(balance);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((membershipTier == null) ? 0 : membershipTier.hashCode());
        result = prime * result + ((signedUpActivities == null) ? 0 : signedUpActivities.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Passenger [id=" + id + ", name=" + name + ", passengerNumber=" + passengerNumber + ", balance="
                + balance + ", passengerType=" + membershipTier + ", signedUpActivities=" + signedUpActivities + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Passenger other = (Passenger) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (passengerNumber != other.passengerNumber)
            return false;
        if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
            return false;
        if (membershipTier != other.membershipTier)
            return false;
        if (signedUpActivities == null) {
            if (other.signedUpActivities != null)
                return false;
        } else if (!signedUpActivities.equals(other.signedUpActivities))
            return false;
        return true;
    }
}
