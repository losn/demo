package com.fxslit.jcs.service.impl;

import com.alibaba.fastjson.JSON;
import com.fxslit.common.ResultMap;
import com.fxslit.common.tools.HttpTools;
import com.fxslit.common.tools.JsonPropertise;
import com.fxslit.common.util.GetTime;
import com.fxslit.daishu.dao.DaishuSiteDAO;
import com.fxslit.daishu.entity.Site;
import com.fxslit.jcs.controller.model.*;
import com.fxslit.jcs.dao.AddressDAO;
import com.fxslit.jcs.entity.Address;
import com.fxslit.jcs.entity.ExpressOrder;
import com.fxslit.jcs.entity.SiteLocation;
import com.fxslit.jcs.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDAO dao;
	@Autowired
    private DaishuSiteDAO sdao;
	private static final String key = "6d024bdf15f8e9789d98feedf57b65c5";
	private static final String output = "json";

	@Override
	public Map<String, Object> getSiteAddress(String tel, int type){
		Map<String, Object> map = new HashMap<String, Object>();
		Address address = new Address();
		if(type == 1){//
			address.setIsSender(1);
		}
		if(type == 2){//
			address.setIsReceiver(1);
		}
		address.setTel(tel);
		if(tel!=null&&tel.length()>4){
            Address addr =  dao.getByTel(address);
			if(addr!=null && addr.getId()>0){
				AddressModel model = new AddressModel();
				model.setDetailAddress(addr.getAddress());
				model.setIdCard(addr.getCardID());
				model.setIdCardName(addr.getCardName());
				model.setName(addr.getName());
				model.setSiteID(addr.getSiteID());
				model.setSiteName(addr.getSiteName());
				model.setTel(addr.getTel());
				return ResultMap.init(0, "", model);
			}else {
				return ResultMap.init(1, "未找到用户信息");
			}
		}else {
			return ResultMap.init(1, "未找到用户信息");
		}
	}
	public Map<String, Object> detailToSite(String detailAddress){
		//获取坐标
		String city="乌鲁木齐";
		String geocodeURL = "http://restapi.amap.com/v3/geocode/geo?&output="+output+"&key="+key+"&address="+detailAddress+"&city="+city;
		String gaodeLocationJSON = HttpTools.get(geocodeURL);
		System.out.println(gaodeLocationJSON);
		GaodeLocationModel gaodeLocationModel = JSON.parseObject(gaodeLocationJSON, GaodeLocationModel.class);
		//获取目的地坐标
		String geocode = "";
		int siteID = 55;//默认为返货部
		if("1".equals(gaodeLocationModel.getStatus())){
			if(gaodeLocationModel.getGeocodes()!=null && gaodeLocationModel.getGeocodes().size()>0){
				geocode = gaodeLocationModel.getGeocodes().get(0).getLocation();
				//获取最近距离
				String origins = "";
				String destination = geocode;
				String siteJSON = JsonPropertise.readJsonFile("baseData", "location");
				List<SiteLocation> locationList = JSON.parseArray(siteJSON, SiteLocation.class);
				Map<String, SiteLocation> locationMap = new HashMap<String, SiteLocation>();
				for(SiteLocation sl : locationList){
					String location = sl.getLocation();
					origins += location+"|";
					locationMap.put(sl.getId(), sl);
				}
				origins = origins.substring(0, origins.length()-1);
				String type = "1";
				String distanceURL = "http://restapi.amap.com/v3/distance?origins="+origins+"&destination="+destination+"&output="+output+"&key="+key;
				String distanceJSON = "";
				try {
					distanceJSON = HttpTools.sendGet(distanceURL);
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println(distanceJSON);
				GaodeDistanceModel distanceModel = JSON.parseObject(distanceJSON, GaodeDistanceModel.class);
				if("1".equals(distanceModel.getStatus())){

					if(distanceModel.getResults()!=null && distanceModel.getResults().size()>0){
						List<DistanceResultModel> list = distanceModel.getResults();
						Collections.sort(list);
						for(DistanceResultModel drm : list){
							System.out.println("ID="+drm.getOrigin_id()+" | dis="+drm.getDistance());
						}
						String minID = list.get(0).getOrigin_id();
						SiteLocation location = locationMap.get(minID);
						if(location!=null){
							siteID = location.getSiteID();
							System.out.println("***************************成功获取目的地");
						}
					}
				}
			}
		}


		System.out.println("siteID="+siteID);
		Site site = sdao.get(siteID);


		SiteModel model = new SiteModel();
        Integer isDirect = site.getIsDirect();
        String siteName = site.getSiteName();
        String areaName = site.getArea();
        areaName = areaName.replaceAll("地区", "");
        String transferName = "";//
        if(isDirect!=null && isDirect.equals(0)) {
            isDirect = 0;
            siteName = siteName+"  "+areaName+"";
            transferName = areaName;
        }else {
            isDirect = 1;
        }
        Double rate = site.getRate()==null ? 0 : site.getRate();
        Double price = site.getPrice()==null ? 0 : site.getPrice();
        Double volumePrice = site.getVolumePrice()==null ? 0 : site.getVolumePrice();
        Double weightPrice = site.getWeightPrice()==null ? 0 : site.getWeightPrice();
        Double turnPrice = site.getTurnPrice()==null ? 0 : site.getTurnPrice();

        model.setId(site.getSiteID());
        model.setSiteName(siteName);
        model.setIsDirect(isDirect);
        model.setTransferName(transferName);
        model.setRate(rate);
        model.setPrice(price);
        model.setVolumePrice(volumePrice);
        model.setWeightPrice(weightPrice);
        model.setTurnPrice(turnPrice);

        return ResultMap.init(0, "", model);
	}

	public void extractAddress(ExpressOrder oo) {
		Address fromAddress = this.fromAddress(oo);
		Address toAddress = this.toAddress(oo);
		if(dao.checkSender(fromAddress)>0){

		}else{
			dao.insert(fromAddress);
		}
		if(toAddress!=null&&toAddress.getSiteID()>0){
			if(dao.checkReceiver(toAddress)>0){

			}else{
				dao.insert(toAddress);
			}
		}
	}
	private Address fromAddress(ExpressOrder express){
		Address addr = new Address();
		String name = express.getSender();
		String tel = express.getSenderTel();//
		String address = express.getSenderDetailAddress();//

		int siteID = express.getFromSiteID();
		String siteName = "";
		Site site = sdao.get(siteID);
		if(site!=null){
			siteName = site.getSiteName();
		}
		String cardID = express.getSenderIDCard();
		String cardName = express.getSender();
		int isSender = 1;//
		int isReceiver = 0;//
		int userID = 0;//
		long opsTimestamp = GetTime.getTimestamp();//
		String opsDate = GetTime.getDateTime();
		addr.setName(name);
		addr.setTel(tel);
		addr.setAddress(address);
		addr.setIsSender(isSender);
		addr.setIsReceiver(isReceiver);
		addr.setUserID(userID);
		addr.setOpsTimestamp(opsTimestamp);
		addr.setOpsDate(opsDate);
		addr.setSiteID(siteID);
		addr.setSiteName(siteName);
		addr.setCardID(cardID);
		addr.setCardName(cardName);
		return addr;
	}
	private Address toAddress(ExpressOrder express){
		Address addr = new Address();
		String name = express.getRecipient();//
		String tel = express.getRecipientTel();//
		String address = express.getRecipientDetailAddress();//

		int siteID = express.getToSiteID();
		String siteName = "";
		Site site = sdao.get(siteID);
		if(site!=null){
			siteName = site.getSiteName();
		}
		String cardID = "";
		String cardName = express.getRecipient();
		int isSender = 0;//
		int isReceiver = 1;//
		int userID = 0;//
		long opsTimestamp = GetTime.getTimestamp();//
		String opsDate = GetTime.getDateTime();
		addr.setName(name);
		addr.setTel(tel);
		addr.setAddress(address);
		addr.setIsSender(isSender);
		addr.setIsReceiver(isReceiver);
		addr.setUserID(userID);
		addr.setOpsTimestamp(opsTimestamp);
		addr.setOpsDate(opsDate);
		addr.setSiteID(siteID);
		addr.setSiteName(siteName);
		addr.setCardID(cardID);
		addr.setCardName(cardName);
		return addr;
	}
}
