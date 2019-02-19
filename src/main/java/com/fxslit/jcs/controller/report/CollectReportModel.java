package com.fxslit.jcs.controller.report;

/**
 * @program: jcs
 * @description: 揽件model
 * @author: Losn
 * @create: 2018-07-13 16:15
 **/
public class CollectReportModel {
    private int numAmount;
    private int quaAmount;
    private double freAmount;
    private int signNumAmount;
    private int returnNumAmount;
    private int unusualNumAmount;

    public int getNumAmount() {
        return numAmount;
    }

    public void setNumAmount(int numAmount) {
        this.numAmount = numAmount;
    }

    public int getQuaAmount() {
        return quaAmount;
    }

    public void setQuaAmount(int quaAmount) {
        this.quaAmount = quaAmount;
    }

    public double getFreAmount() {
        return freAmount;
    }

    public void setFreAmount(double freAmount) {
        this.freAmount = freAmount;
    }

    public int getSignNumAmount() {
        return signNumAmount;
    }

    public void setSignNumAmount(int signNumAmount) {
        this.signNumAmount = signNumAmount;
    }

    public int getReturnNumAmount() {
        return returnNumAmount;
    }

    public void setReturnNumAmount(int returnNumAmount) {
        this.returnNumAmount = returnNumAmount;
    }

    public int getUnusualNumAmount() {
        return unusualNumAmount;
    }

    public void setUnusualNumAmount(int unusualNumAmount) {
        this.unusualNumAmount = unusualNumAmount;
    }
}
