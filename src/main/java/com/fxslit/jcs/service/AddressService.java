package com.fxslit.jcs.service;

import com.fxslit.jcs.entity.ExpressOrder;

import java.util.Map;

public interface AddressService {
	void extractAddress(ExpressOrder express);
	Map<String, Object> detailToSite(String detailAddress);
	Map<String, Object> getSiteAddress(String tel, int type);
}
