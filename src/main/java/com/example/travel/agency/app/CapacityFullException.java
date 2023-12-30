package com.example.travel.agency.app;

public class CapacityFullException extends RuntimeException {
    private final Activity activity;

    /**
     * @return the associated activity for this exception.
     */
    public Activity getActivity() {
        return activity;
    }

    /**
     * @param activity The {@link Activity} that cannot be participated as its
     *                 capacity is full and a {@link Passenger} tries to do so.
     */
    public CapacityFullException(Activity activity) {
        super("Capacity is full for this activity.");
        this.activity = activity;
    }
}
