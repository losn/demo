package com.fxslit.jcs.service.impl;

import com.fxslit.common.ResultMap;
import com.fxslit.jcs.controller.report.*;
import com.fxslit.jcs.service.ExpressReportService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: jcs
 * @description: 报表
 * @author: Losn
 * @create: 2018-07-13 15:37
 **/
@Service
public class ExpressReportServiceImpl implements ExpressReportService{

    @Override
    public Map<String, Object> courierReport(String date, int uid) {
        List<CourierReportModel> courierReport = new ArrayList<>();
        CourierReportModel model = new CourierReportModel();
        model.setCourierName("隔壁老王");
        model.setCollectNumAmount(100);
        model.setCollectQuaAmount(130);
        model.setCollectFreAmount(1500);
        model.setSendNumAmount(70);
        model.setSendQuaAmount(110);
        model.setSendFreAmount(1800);
        model.setSendColAmount(15000);
        model.setReturnArriveNumAmount(2);
        model.setReturnArriveQuaAmount(4);
        model.setReturnArriveFreAmount(50);
        model.setAmount(18350);
        courierReport.add(model);

        model = new CourierReportModel();
        model.setCourierName("隔壁老王的邻居小王");
        model.setCollectNumAmount(100);
        model.setCollectQuaAmount(130);
        model.setCollectFreAmount(1500);
        model.setSendNumAmount(70);
        model.setSendQuaAmount(110);
        model.setSendFreAmount(1800);
        model.setSendColAmount(15000);
        model.setReturnArriveNumAmount(2);
        model.setReturnArriveQuaAmount(4);
        model.setReturnArriveFreAmount(50);
        model.setAmount(18350);
        courierReport.add(model);

        model = new CourierReportModel();
        model.setCourierName("合计");
        model.setCollectNumAmount(100);
        model.setCollectQuaAmount(130);
        model.setCollectFreAmount(1500);
        model.setSendNumAmount(70);
        model.setSendQuaAmount(110);
        model.setSendFreAmount(1800);
        model.setSendColAmount(15000);
        model.setReturnArriveNumAmount(2);
        model.setReturnArriveQuaAmount(4);
        model.setReturnArriveFreAmount(50);
        model.setAmount(18350);
        courierReport.add(model);

        CourierTitleModel titleModel = new CourierTitleModel();
        titleModel.setCollectNumAmount(200);
        titleModel.setSendNumAmount(100);
        titleModel.setReturnNumAmount(10);
        titleModel.setSignRate("75.63%");

        Map<String, Object> result = new HashMap<>();
        result.put("contents", courierReport);
        result.put("title", titleModel);
        return ResultMap.init(0, "", result);

    }
    @Override
    public Map<String, Object> collect(String date, int uid) {
        CollectReportModel model = new CollectReportModel();
        model.setFreAmount(1);
        model.setNumAmount(2);
        model.setQuaAmount(3);
        model.setReturnNumAmount(4);
        model.setSignNumAmount(5);
        model.setUnusualNumAmount(6);
        return ResultMap.init(0, "", model);
    }

    @Override
    public Map<String, Object> send(String date, int uid) {
        SendReprotModel model = new SendReprotModel();
        model.setActNumAmount(1);
        model.setActQuaAmount(2);
        model.setShdFreAmount(3);
        model.setShdNumAmount(4);
        model.setShdQuaAmount(5);
        model.setSignNumAmount(2);
        model.setSignRate("75%");
        return ResultMap.init(0, "", model);
    }
    @Override
    public Map<String, Object> returnArrive(String date, int uid) {
        ReturnArriveReportModel model = new ReturnArriveReportModel();
        model.setActNumAmount(1);
        model.setActQuaAmount(2);
        model.setShdNumAmount(4);
        model.setShdQuaAmount(5);
        model.setSignNumAmount(2);
        model.setSignRate("75%");
        return ResultMap.init(0, "", model);
    }

    @Override
    public Map<String, Object> inv(String date, int uid) {
        InvReprotModel model = new InvReprotModel();
        model.setActNumAmount(1);
        model.setActQuaAmount(2);
        model.setShdNumAmount(4);
        model.setShdQuaAmount(5);
        model.setInvRate("70%");
        model.setShdFreAmount(100);
        return ResultMap.init(0, "", model);
    }

    @Override
    public Map<String, Object> returnBack(String date, int uid) {
        ReturnReportModel model = new ReturnReportModel();
        model.setActAmount(1);
        model.setDoAmount(2);
        model.setReturnRate("70%");
        model.setShdAmount(5);
        model.setUnAmount(3);
        return ResultMap.init(0, "", model);
    }

    @Override
    public Map<String, Object> sendChart(String date, int uid) {
        List<ChartsModel> result = new ArrayList<>();
        ChartsModel model = new ChartsModel();
        model.setDate("2018-06-01");
        model.setFreAmount(10000);
        model.setNumAmount(500);
        result.add(model);

        model = new ChartsModel();
        model.setDate("2018-06-02");
        model.setFreAmount(8000);
        model.setNumAmount(480);
        result.add(model);

        model = new ChartsModel();
        model.setDate("2018-06-03");
        model.setFreAmount(12000);
        model.setNumAmount(500);
        result.add(model);

        model = new ChartsModel();
        model.setDate("2018-06-04");
        model.setFreAmount(10300);
        model.setNumAmount(570);
        result.add(model);

        model = new ChartsModel();
        model.setDate("2018-06-05");
        model.setFreAmount(9000);
        model.setNumAmount(660);
        result.add(model);

        model = new ChartsModel();
        model.setDate("2018-06-06");
        model.setFreAmount(12000);
        model.setNumAmount(482);
        result.add(model);

        model = new ChartsModel();
        model.setDate("2018-06-07");
        model.setFreAmount(12345);
        model.setNumAmount(525);
        result.add(model);


        return ResultMap.init(0, "", result);
    }

    @Override
    public Map<String, Object> collectChart(String date, int uid) {
        List<ChartsModel> result = new ArrayList<>();
        ChartsModel model = new ChartsModel();
        model.setDate("2018-06-01");
        model.setFreAmount(10000);
        model.setNumAmount(500);
        result.add(model);

        model = new ChartsModel();
        model.setDate("2018-06-02");
        model.setFreAmount(8000);
        model.setNumAmount(480);
        result.add(model);

        model = new ChartsModel();
        model.setDate("2018-06-03");
        model.setFreAmount(12000);
        model.setNumAmount(500);
        result.add(model);

        model = new ChartsModel();
        model.setDate("2018-06-04");
        model.setFreAmount(10300);
        model.setNumAmount(570);
        result.add(model);

        model = new ChartsModel();
        model.setDate("2018-06-05");
        model.setFreAmount(9000);
        model.setNumAmount(660);
        result.add(model);

        model = new ChartsModel();
        model.setDate("2018-06-06");
        model.setFreAmount(12000);
        model.setNumAmount(482);
        result.add(model);

        model = new ChartsModel();
        model.setDate("2018-06-07");
        model.setFreAmount(12345);
        model.setNumAmount(525);
        result.add(model);


        return ResultMap.init(0, "", result);
    }

}
