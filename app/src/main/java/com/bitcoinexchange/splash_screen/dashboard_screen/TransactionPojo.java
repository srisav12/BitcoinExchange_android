package com.bitcoinexchange.splash_screen.dashboard_screen;

/**
 * Created by shashank.rawat on 10-10-2017.
 */

public class TransactionPojo {
    private String companyName;
    private String date;
    private String amount;
    private int sendReceive;

    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }

    public int getSendReceive() {
        return sendReceive;
    }

    public void setSendReceive(int sendReceive) {
        this.sendReceive = sendReceive;
    }
}
