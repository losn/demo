package com.fxslit.jcs.controller;

import com.fxslit.common.Msg;
import com.fxslit.common.ResultMap;
import com.fxslit.jcs.controller.model.ExpressBarcodeScanModel;
import com.fxslit.jcs.controller.token.TokenManager;
import com.fxslit.jcs.service.BarcodeScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @program: jcs
 * @description: 扫码
 * @author: Losn
 * @create: 2018-07-23 02:56
 **/
@RestController
public class BarcodeScanController {
    @Autowired
    private BarcodeScanService barcodeScanService;
    @RequestMapping(value="/barcode/scan/inv",method= RequestMethod.POST)
    public Map<String,Object> invScan(@RequestBody()ExpressBarcodeScanModel model, @RequestHeader HttpHeaders headers){
        if(!TokenManager.check(headers)){
            return ResultMap.init(1, Msg.AUTH_FAIL.toString());
        }
        int uid = TokenManager.getKey(headers);
        return barcodeScanService.invScan(model, uid);
    }
}
