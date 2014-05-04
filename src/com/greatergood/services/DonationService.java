package com.greatergood.services;

import com.greatergood.BusinessObjects.Donation;
import com.parse.ParseObject;

public class DonationService {

    public static boolean SaveDonation(Donation d) {
        ParseObject donation = new ParseObject("Donation");
        donation.put("TransactionAmount", d.getAmountInCents());
        donation.put("UserID", d.getUserId());
        donation.put("MasjidID", d.getMasjidId());

        donation.saveEventually();

        return true;
    }
}
