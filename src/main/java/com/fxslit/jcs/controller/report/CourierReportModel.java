package com.fxslit.jcs.controller.report;

/**
 * @program: jcs
 * @description: 业务员揽件派送报表
 * @author: Losn
 * @create: 2018-07-13 15:28
 **/
public class CourierReportModel {
    private String courierName;
    private int collectNumAmount;
    private int collectQuaAmount;
    private double collectFreAmount;
    private int sendNumAmount;
    private int sendQuaAmount;
    private double sendFreAmount;
    private double sendColAmount;
    private int returnArriveNumAmount;
    private int returnArriveQuaAmount;
    private double returnArriveFreAmount;
    private double amount;

    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    public int getCollectNumAmount() {
        return collectNumAmount;
    }

    public void setCollectNumAmount(int collectNumAmount) {
        this.collectNumAmount = collectNumAmount;
    }

    public int getCollectQuaAmount() {
        return collectQuaAmount;
    }

    public void setCollectQuaAmount(int collectQuaAmount) {
        this.collectQuaAmount = collectQuaAmount;
    }

    public double getCollectFreAmount() {
        return collectFreAmount;
    }

    public void setCollectFreAmount(double collectFreAmount) {
        this.collectFreAmount = collectFreAmount;
    }

    public int getSendNumAmount() {
        return sendNumAmount;
    }

    public void setSendNumAmount(int sendNumAmount) {
        this.sendNumAmount = sendNumAmount;
    }

    public int getSendQuaAmount() {
        return sendQuaAmount;
    }

    public void setSendQuaAmount(int sendQuaAmount) {
        this.sendQuaAmount = sendQuaAmount;
    }

    public double getSendFreAmount() {
        return sendFreAmount;
    }

    public void setSendFreAmount(double sendFreAmount) {
        this.sendFreAmount = sendFreAmount;
    }

    public double getSendColAmount() {
        return sendColAmount;
    }

    public void setSendColAmount(double sendColAmount) {
        this.sendColAmount = sendColAmount;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getReturnArriveNumAmount() {
        return returnArriveNumAmount;
    }

    public void setReturnArriveNumAmount(int returnArriveNumAmount) {
        this.returnArriveNumAmount = returnArriveNumAmount;
    }

    public int getReturnArriveQuaAmount() {
        return returnArriveQuaAmount;
    }

    public void setReturnArriveQuaAmount(int returnArriveQuaAmount) {
        this.returnArriveQuaAmount = returnArriveQuaAmount;
    }

    public double getReturnArriveFreAmount() {
        return returnArriveFreAmount;
    }

    public void setReturnArriveFreAmount(double returnArriveFreAmount) {
        this.returnArriveFreAmount = returnArriveFreAmount;
    }
}
