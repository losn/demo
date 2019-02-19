package com.fxslit.jcs.controller.report;

/**
 * @program: jcs
 * @description: 盘点
 * @author: Losn
 * @create: 2018-07-13 16:20
 **/
public class InvReprotModel {
    private int shdNumAmount;
    private int shdQuaAmount;
    private double shdFreAmount;
    private int actNumAmount;
    private int actQuaAmount;
    private String invRate;

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

    public double getShdFreAmount() {
        return shdFreAmount;
    }

    public void setShdFreAmount(double shdFreAmount) {
        this.shdFreAmount = shdFreAmount;
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

    public String getInvRate() {
        return invRate;
    }

    public void setInvRate(String invRate) {
        this.invRate = invRate;
    }
}
