package com.fxslit.jcs.controller;

import com.fxslit.common.Msg;
import com.fxslit.common.ResultMap;
import com.fxslit.common.validator.Validator;
import com.fxslit.jcs.controller.model.*;
import com.fxslit.jcs.controller.token.TokenManager;
import com.fxslit.jcs.service.ExpressOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class ExpressOrderController {
    @Autowired
    private ExpressOrderService svc;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value="/onlineOrder",method= RequestMethod.POST)
    public Map<String,Object> onlineOrder(@Valid @RequestBody ExpressInsertModel model, BindingResult result, @RequestHeader HttpHeaders headers){
        if(!TokenManager.check(headers)){
            return ResultMap.init(1, Msg.AUTH_FAIL.toString());
        }
        if(result.hasErrors()){
            return Validator.valid(result);
        }
        int uid = TokenManager.getKey(headers);
        return svc.onlineAdd(model, uid);
    }
    /**
     *
     * @return
     */
    @RequestMapping(value="/onlineOrder/confirm",method= RequestMethod.POST)
    public Map<String,Object> onlineOrderConfirm(@Valid @RequestBody Map<String, List<Integer>> model, BindingResult result, @RequestHeader HttpHeaders headers){
        if(!TokenManager.check(headers)){
            return ResultMap.init(1, Msg.AUTH_FAIL.toString());
        }
        int uid = TokenManager.getKey(headers);
        if(result.hasErrors()){
            return Validator.valid(result);
        }
        return svc.onlineConfirm(model, uid);
    }


    @RequestMapping(value="/qrcode/{qrcode}",method= RequestMethod.GET)
    public Map<String,Object> getExpressInfoByQrcodeWX(@PathVariable(value="qrcode") String qrcode, @RequestHeader HttpHeaders headers){
        if(!TokenManager.check(headers)){
            return ResultMap.init(1, Msg.AUTH_FAIL.toString());
        }
        return svc.getByExpressInfoByQRCode(qrcode);
    }



}
