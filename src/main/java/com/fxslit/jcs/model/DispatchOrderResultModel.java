package com.fxslit.jcs.model;

import java.util.List;

/**
 * @program: jcs
 * @description: 调度订单结果model
 * @author: Losn
 * @create: 2018-07-03 13:35
 **/
public class DispatchOrderResultModel {
    private int error;
    private List<DispatchOrderModel> result;
    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public List<DispatchOrderModel> getResult() {
        return result;
    }

    public void setResult(List<DispatchOrderModel> result) {
        this.result = result;
    }
}
