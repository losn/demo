package com.fxslit.jcs.controller.report;

/**
 * @program: jcs
 * @description: 业务员员报表标题
 * @author: Losn
 * @create: 2018-07-13 15:35
 **/
public class CourierTitleModel {
    private int collectNumAmount;
    private int sendNumAmount;
    private int returnNumAmount;
    private String signRate;

    public int getCollectNumAmount() {
        return collectNumAmount;
    }

    public void setCollectNumAmount(int collectNumAmount) {
        this.collectNumAmount = collectNumAmount;
    }

    public int getSendNumAmount() {
        return sendNumAmount;
    }

    public void setSendNumAmount(int sendNumAmount) {
        this.sendNumAmount = sendNumAmount;
    }

    public int getReturnNumAmount() {
        return returnNumAmount;
    }

    public void setReturnNumAmount(int returnNumAmount) {
        this.returnNumAmount = returnNumAmount;
    }

    public String getSignRate() {
        return signRate;
    }

    public void setSignRate(String signRate) {
        this.signRate = signRate;
    }
}
