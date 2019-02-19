package com.fxslit.jcs.controller;

import com.fxslit.common.Msg;
import com.fxslit.common.ResultMap;
import com.fxslit.jcs.controller.model.SiteUserToken;
import com.fxslit.jcs.controller.token.TokenManager;
import com.fxslit.jcs.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class AddressController {
	@Autowired
	private AddressService svc;
	@Autowired
	private HttpServletRequest request;


	@RequestMapping(value="/address/sender/{tel}",method= RequestMethod.GET)
	public Map<String,Object> sendAddressWX(@PathVariable(value="tel") String tel , @RequestHeader HttpHeaders headers){
		if(!TokenManager.check(headers)){
			return ResultMap.init(1, Msg.AUTH_FAIL.toString());
		}
		return svc.getSiteAddress(tel, 1);
	}
	@RequestMapping(value="/address/receiver/{tel}",method= RequestMethod.GET)
	public Map<String,Object> receiverAddressWX(@PathVariable(value="tel") String tel , @RequestHeader HttpHeaders headers){
		if(!TokenManager.check(headers)){
			return ResultMap.init(1, Msg.AUTH_FAIL.toString());
		}
		return svc.getSiteAddress(tel, 2);
	}
	@RequestMapping(value="/address/site/{detailAddress}",method=RequestMethod.GET)
	public Map<String,Object> detailToSite(@PathVariable(value="detailAddress") String detailAddress ,@RequestHeader HttpHeaders headers){
		if(!TokenManager.check(headers)){
			return ResultMap.init(1, Msg.AUTH_FAIL.toString());
		}
		return svc.detailToSite(detailAddress);
	}
}
