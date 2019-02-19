package com.fxslit.jcs.controller;

import com.fxslit.common.Msg;
import com.fxslit.common.ResultMap;
import com.fxslit.jcs.controller.token.TokenManager;
import com.fxslit.jcs.service.ExpressReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @program: jcs
 * @description: 报表
 * @author: Losn
 * @create: 2018-07-13 16:44
 **/
@RestController
public class ExpressReportController {
    @Autowired
    private ExpressReportService service;

    @RequestMapping(value="/report/courier/{date}",method= RequestMethod.GET)
    public Map<String,Object> courier(@PathVariable(value="date") String date, @RequestHeader HttpHeaders headers){
        if(!TokenManager.check(headers)){
            return ResultMap.init(1, Msg.AUTH_FAIL.toString());
        }
        int uid = TokenManager.getKey(headers);
        return service.courierReport(date, uid);
    }

    @RequestMapping(value="/report/express/collect/{date}",method= RequestMethod.GET)
    public Map<String,Object> collect(@PathVariable(value="date") String date, @RequestHeader HttpHeaders headers){
        if(!TokenManager.check(headers)){
            return ResultMap.init(1, Msg.AUTH_FAIL.toString());
        }
        int uid = TokenManager.getKey(headers);
        return service.collect(date, uid);
    }

    @RequestMapping(value="/report/express/send/{date}",method= RequestMethod.GET)
    public Map<String,Object> send(@PathVariable(value="date") String date, @RequestHeader HttpHeaders headers){
        if(!TokenManager.check(headers)){
            return ResultMap.init(1, Msg.AUTH_FAIL.toString());
        }
        int uid = TokenManager.getKey(headers);
        return service.send(date, uid);
    }

    @RequestMapping(value="/report/express/returnArrive/{date}",method= RequestMethod.GET)
    public Map<String,Object> returnArrive(@PathVariable(value="date") String date, @RequestHeader HttpHeaders headers){
        if(!TokenManager.check(headers)){
            return ResultMap.init(1, Msg.AUTH_FAIL.toString());
        }
        int uid = TokenManager.getKey(headers);
        return service.returnArrive(date, uid);
    }

    @RequestMapping(value="/report/express/inv/{date}",method= RequestMethod.GET)
    public Map<String,Object> inv(@PathVariable(value="date") String date, @RequestHeader HttpHeaders headers){
        if(!TokenManager.check(headers)){
            return ResultMap.init(1, Msg.AUTH_FAIL.toString());
        }
        int uid = TokenManager.getKey(headers);
        return service.inv(date, uid);
    }

    @RequestMapping(value="/report/express/return/{date}",method= RequestMethod.GET)
    public Map<String,Object> returnBack(@PathVariable(value="date") String date, @RequestHeader HttpHeaders headers){
        if(!TokenManager.check(headers)){
            return ResultMap.init(1, Msg.AUTH_FAIL.toString());
        }
        int uid = TokenManager.getKey(headers);
        return service.returnBack(date, uid);
    }

    @RequestMapping(value="/report/charts/express/collect/{date}",method= RequestMethod.GET)
    public Map<String,Object> collectChart(@PathVariable(value="date") String date, @RequestHeader HttpHeaders headers){
        if(!TokenManager.check(headers)){
            return ResultMap.init(1, Msg.AUTH_FAIL.toString());
        }
        int uid = TokenManager.getKey(headers);
        return service.collectChart(date, uid);
    }

    @RequestMapping(value="/report/charts/express/send/{date}",method= RequestMethod.GET)
    public Map<String,Object> sendChart(@PathVariable(value="date") String date, @RequestHeader HttpHeaders headers){
        if(!TokenManager.check(headers)){
            return ResultMap.init(1, Msg.AUTH_FAIL.toString());
        }
        int uid = TokenManager.getKey(headers);
        return service.sendChart(date, uid);
    }

}
