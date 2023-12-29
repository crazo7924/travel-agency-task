package com.example.travel.agency.app;

enum MembershipTier {
    STANDARD(1),
    GOLD(2),
    PREMIUM(3);

    private int tier;

    public int getTier() {
        return tier;
    }

    public double getDiscount() {
        switch (this) {
            case STANDARD:
            default:
                return 0.0; // no discount
            case GOLD:
                return 0.1; // 10%
            case PREMIUM:
                return 1.0; // 100%
        }
    }

    private MembershipTier(int tier) {
        this.tier = tier;
    }
}