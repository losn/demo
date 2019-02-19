package com.fxslit.jcs.controller.report;

/**
 * @program: jcs
 * @description: 原返到达
 * @author: Losn
 * @create: 2018-07-13 16:19
 **/
public class ReturnArriveReportModel {
    private int shdNumAmount;
    private int shdQuaAmount;
    private int actNumAmount;
    private int actQuaAmount;
    private int signNumAmount;
    private String signRate;

    public int getShdNumAmount() {
        return shdNumAmount;
    }

    public void setShdNumAmount(int shdNumAmount) {
        this.shdNumAmount = shdNumAmount;
    }

    public int getShdQuaAmount() {
        return shdQuaAmount;
    }

    public void setShdQuaAmount(int shdQuaAmount) {
        this.shdQuaAmount = shdQuaAmount;
    }

    public int getActNumAmount() {
        return actNumAmount;
    }

    public void setActNumAmount(int actNumAmount) {
        this.actNumAmount = actNumAmount;
    }

    public int getActQuaAmount() {
        return actQuaAmount;
    }

    public void setActQuaAmount(int actQuaAmount) {
        this.actQuaAmount = actQuaAmount;
    }

    public int getSignNumAmount() {
        return signNumAmount;
    }

    public void setSignNumAmount(int signNumAmount) {
        this.signNumAmount = signNumAmount;
    }

    public String getSignRate() {
        return signRate;
    }

    public void setSignRate(String signRate) {
        this.signRate = signRate;
    }
}
