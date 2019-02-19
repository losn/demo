package com.fxslit.jcs.controller.report;

/**
 * @program: jcs
 * @description: 原货返回
 * @author: Losn
 * @create: 2018-07-13 16:32
 **/
public class ReturnReportModel {
    private int shdAmount;
    private int actAmount;
    private int unAmount;
    private int doAmount;
    private String returnRate;

    public int getShdAmount() {
        return shdAmount;
    }

    public void setShdAmount(int shdAmount) {
        this.shdAmount = shdAmount;
    }

    public int getActAmount() {
        return actAmount;
    }

    public void setActAmount(int actAmount) {
        this.actAmount = actAmount;
    }

    public int getUnAmount() {
        return unAmount;
    }

    public void setUnAmount(int unAmount) {
        this.unAmount = unAmount;
    }

    public int getDoAmount() {
        return doAmount;
    }

    public void setDoAmount(int doAmount) {
        this.doAmount = doAmount;
    }

    public String getReturnRate() {
        return returnRate;
    }

    public void setReturnRate(String returnRate) {
        this.returnRate = returnRate;
    }
}
