package com.GreaterGood.BusinessObjects;

public class Donation {

    protected String id;
    protected int amountInCents;
    protected int userId;
    protected int masjidId;

    private Donation() {
    }

    public static Donation CreateDonation(int amountInCents, int userId,
            int masjidId) {

        Donation donation = new Donation();
        donation.amountInCents = amountInCents;
        donation.userId = userId;
        donation.masjidId = masjidId;

        return donation;

    }

}
