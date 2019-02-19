package com.fxslit.jcs.service.impl;

import com.alibaba.fastjson.JSON;
import com.fxslit.common.ResultMap;
import com.fxslit.common.tools.CardNoTools;
import com.fxslit.common.tools.HttpTools;
import com.fxslit.common.util.GetTime;
import com.fxslit.daishu.dao.DaishuSiteDAO;
import com.fxslit.daishu.entity.*;
import com.fxslit.jcs.controller.model.*;
import com.fxslit.jcs.dao.DestinationDAO;
import com.fxslit.jcs.dao.EquipmentDAO;
import com.fxslit.jcs.dao.ExpressOrderDAO;
import com.fxslit.jcs.entity.*;
import com.fxslit.jcs.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExpressOrderServiceImpl implements ExpressOrderService {
    @Autowired
    private DaishuSiteDAO sdao;
    @Autowired
    private DaishuService dsSvc;
    @Autowired
    private ExpressOrderDAO dao;
    @Autowired
    private EquipmentDAO edao;
    @Autowired
    private AddressService asvc;
    @Autowired
    private UserService usvc;
    @Autowired
    private DestinationDAO ddao;
    @Autowired
    private SiteService siteService;




    private ExpressOrder insertModel2Entity(ExpressInsertModel model, ExpressPrintModel expressPrintModel, SiteModel fromSiteModel, SiteModel toSiteModel) {
        ExpressOrder expressOrder = new ExpressOrder();

        int fromSiteID = fromSiteModel.getId();//始发站ID

        String fromSite = fromSiteModel.getSiteName();//
        String senderTel = model.getSenderTel();//寄件人电话
        String sender = model.getSender();//寄件人
        String senderIDCard = model.getSenderIDCard();//寄件人身份证号码
        String senderDetailAddress = model.getSenderDetailAddress();//寄件人详细地址
        String senderCoordinate = model.getSenderCoordinate();//寄件人地址坐标

        int isDirect = toSiteModel.getIsDirect();//0否 1是
        int toSiteID = model.getToSiteID();//目的站ID
        String toSite = toSiteModel.getSiteName();//
        String recipientTel = model.getRecipientTel();//收件人电话
        String recipient = model.getRecipient();//收件人
        String recipientDetailAddress = model.getRecipientDetailAddress();//收件人详细地址
        String recipientCoordinate = model.getRecipientCoordinate();//收件人坐标

        int billingType = model.getBillingType();//计费方式 1 起步价 2 汽配 3 重量体积 4 自定义

        //汽配计费数据
        String autoParts = JSON.toJSONString(model.getAutoParts());//汽配列表
        //重量体积计费数据
        double weight = model.getWeight();//重量
        double volume = model.getVolume();//体积

        String contents = model.getContents();//物品名称
        int quantity = model.getQuantity();//件数

        double systemFreight = model.getSystemFreight();//系统计算后得出的运费
        double discount = model.getDiscount();//折扣1 0.95...
        int payment = model.getPayment();//付款方式
        double freight = model.getFreight();//运费（经过各种计算，最终的得到的结果）

        double collectionFee = model.getCollectionFee();//代收金额
        double value = model.getValue();//申明价值
        double insuranceRate = model.getInsuranceRate();//保险费率
        double insuranceFee = model.getInsuranceFee();//保价费

        double transFee = model.getTransFee();//转货费
        double pickupFee = model.getPickupFee();//取货费
        double deliveryFee = model.getDeliveryFee();//派送费
        double packingFee = model.getPackingFee();//包装费
        double stairsFee = model.getStairsFee();//上楼费

        int remark = model.getOrderNote();//备注 1 签字返单送货 2 包运不包损 3 等通知送货
        String returnNum = model.getReturnNum();//签字返单单号
        String notice = model.getRemark();//说明

        String codeList = "";//
        if(quantity>1){
            codeList = JSON.toJSONString(expressPrintModel.getCodeList());
        }
        String expressDate = expressPrintModel.getExpressDate();//
        String expressNum = expressPrintModel.getExpressNum();//运单号码
        int isConfirm = 0;//

        expressOrder.setExpressNum(expressNum);

        expressOrder.setFromSiteID(fromSiteID);
        expressOrder.setFromSite(fromSite);
        expressOrder.setSender(sender);
        expressOrder.setSenderTel(senderTel);
        expressOrder.setSenderIDCard(senderIDCard);
        expressOrder.setSenderDetailAddress(senderDetailAddress);
        expressOrder.setSenderCoordinate(senderCoordinate);

        expressOrder.setIsDirect(isDirect);
        expressOrder.setToSiteID(toSiteID);
        expressOrder.setToSite(toSite);
        expressOrder.setRecipient(recipient);
        expressOrder.setRecipientTel(recipientTel);
        expressOrder.setRecipientDetailAddress(recipientDetailAddress);
        expressOrder.setRecipientCoordinate(recipientCoordinate);

        expressOrder.setBillingType(billingType);
        expressOrder.setAutoParts(autoParts);
        expressOrder.setWeight(weight);
        expressOrder.setVolume(volume);

        expressOrder.setContents(contents);
        expressOrder.setQuantity(quantity);
        expressOrder.setSystemFreight(systemFreight);
        expressOrder.setDiscount(discount);
        expressOrder.setPayment(payment);
        expressOrder.setFreight(freight);

        expressOrder.setCollectionFee(collectionFee);
        expressOrder.setValue(value);
        expressOrder.setInsuranceRate(insuranceRate);
        expressOrder.setInsuranceFee(insuranceFee);

        expressOrder.setTransFee(transFee);
        expressOrder.setPickupFee(pickupFee);
        expressOrder.setDeliveryFee(deliveryFee);
        expressOrder.setPackingFee(packingFee);
        expressOrder.setStairsFee(stairsFee);

        expressOrder.setRemark(remark);
        expressOrder.setReturnNum(returnNum);
        expressOrder.setNotice(notice);
        expressOrder.setCodeList(codeList);
        expressOrder.setExpressDate(expressDate);
        expressOrder.setIsConfirm(isConfirm);

        expressOrder.setFromWorkName(expressPrintModel.getFromWorkName());
        expressOrder.setFromWorkNum(expressPrintModel.getFromWorkNum());
        expressOrder.setQrcode(model.getQrcode());
        return expressOrder;
    }

    Map<Integer, String> getSiteNameMap() {
        List<Site> list = sdao.getList();
        Iterator<Site> it = list.iterator();
        Map<Integer, String> map = new HashMap<Integer, String>();
        while (it.hasNext()) {
            Site site = it.next();
            map.put(site.getSiteID(), site.getSiteName());
        }
        return map;
    }


    /******************************************************************************/
    public Map<String, Object> onlineAdd(ExpressInsertModel model, int uid) {
        Map<String, Object> map = new HashMap<String, Object>();

        SiteUser user = usvc.getUser(uid);
        if (user == null || user.getId() == 0) {
            return ResultMap.init(1,"用户未登录，请重新提交");
        }
        if(model == null) {
            return ResultMap.init(1,"请提交正确的数据");
        }
        String qrcode = model.getQrcode();
        if(qrcode!=null && qrcode.length()==8) {
            if(!this.checkByExpressInfoByQRCode(qrcode, model)) {
                return ResultMap.init(1,"在线下单人信息与寄件人信息不符，请重新输入寄件码或重新下单");
            }
        }

        int toSiteID = model.getToSiteID();
        if(dsSvc.isDelivery(toSiteID)){
            return ResultMap.init(1,"您好，您选择的站点今日停收，无法进行下单");
        }
        int siteID = user.getSiteID();
        int eid = user.getEquipmentID();
        Equipment eq = edao.get(eid);
        if(eq == null || eq.getId()==0){
            return ResultMap.init(1,"获取设备信息失败，请重试");
        }
        String equipmentCode = eq.getName();
        SiteModel fromSiteModel = siteService.site(siteID);
        if(fromSiteModel == null) {
            return ResultMap.init(1,"获取始发站信息失败");
        }
        SiteModel toSiteModel = siteService.site(model.getToSiteID());
        if(toSiteModel == null) {
            return ResultMap.init(1,"获取目的站信息失败");
        }
        ExpressInitModel expressInitModel = dsSvc.initInsertExpress(siteID, equipmentCode, model, user, toSiteModel);
        if(expressInitModel == null || expressInitModel.getResultCode()!=0){
            return ResultMap.init(expressInitModel.getResultCode(),expressInitModel.getResultMessage());
        }
        ExpressPrintModel printModel = expressInitModel.getData();

        ExpressOrder expressOrder = this.insertModel2Entity(model, printModel, fromSiteModel, toSiteModel);
        expressOrder.setOpsUserID(uid);
        expressOrder.setOpsDate(GetTime.getDateTime());
        int flag = dao.insert(expressOrder);
        if(flag>0){
            asvc.extractAddress(expressOrder);
            List<Integer> idArray = new ArrayList<Integer>();
            idArray.add(expressOrder.getId());
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("idArray", idArray);
            data.put("result", printModel);
            return ResultMap.init(0,"", data);
        }else{
            return ResultMap.init(1,"过程出错，请重新开票");
        }



    }



    public Map<String, Object> onlineConfirm(Map<String, List<Integer>> model, int uid) {
        Map<String, Object> map = new HashMap<String, Object>();
        SiteUser user = usvc.getUser(uid);
        if (user == null || user.getId() == 0) {
            return ResultMap.init(1,"用户未登录，请重新提交");
        }
        System.out.println("confirm————————————————" + JSON.toJSONString(model));
        List<ExpressOrder> orderList = new ArrayList<ExpressOrder>();
        if (model.get("idArray") != null && model.get("idArray").size() == 1) {
            int id = model.get("idArray").get(0);
            if(id>0){
                ExpressOrder expressOrder = dao.get(id);
                if(expressOrder == null || expressOrder.getId() == 0) {
                    return ResultMap.init(1,"idArray错误");
                }

                int siteID = user.getSiteID();
                int eid = user.getEquipmentID();
                Equipment eq = edao.get(eid);
                if(eq == null || eq.getId()==0){
                    return ResultMap.init(1,"获取设备信息失败，请重试");
                }
                String equipmentCode = eq.getName();
                ExpressConfirmModel expressConfirmModel = dsSvc.insertExpress(expressOrder, siteID, equipmentCode, user);
                if(expressConfirmModel!=null && expressConfirmModel.getResultCode() == 0){
                    expressOrder.setIsConfirm(1);
                    expressOrder.setOpsDate(GetTime.getDateTime());
                    dao.confirm(expressOrder);
                    return ResultMap.init(0,"", "success");
                }else{
                    return ResultMap.init(expressConfirmModel.getResultCode(),expressConfirmModel.getResultMessage());
                }


            }else{
                return ResultMap.init(1,"idArray错误_0");
            }
        } else {
            return ResultMap.init(1,"idArray错误");
        }
    }

    public Map<String, Object> getByExpressInfoByQRCode(String qrcode){
        Map<String, Object> map = new HashMap<String, Object>();
        String url = "http://127.0.0.1/jieqd/qr/"+qrcode;
        String resultStr = HttpTools.get(url);
        System.out.println("**********************"+resultStr);
        ExpressQR result = JSON.parseObject(resultStr, ExpressQR.class);
        if(result == null) {
            return ResultMap.init(1,"未找到数据");
        }
        OrderResponseModel or = result.getResult();
        if(or == null) {
            return ResultMap.init(1,"未找到数据");
        }
        ExpressQRModel model = new ExpressQRModel();
        String senderIDCard = or.getSenderIDCardNum();
        model.setSenderIDCard(senderIDCard);
        model.setSenderTel(or.getSenderTel());
        model.setSender(or.getSender());
        model.setSenderDetailAddress(or.getSenderDetailAddress());

        Destination d = ddao.get(or.getDestinationID());
        int siteID = 0;//TODO
        if (d!=null && d.getId()>0){
            siteID = d.getId();
            if (siteID == 999) {
                siteID = 482;
            }
        }else{
            map.put("error", 1);
            map.put("errorMsg", "站点信息获取失败");
            return map;
        }
        SiteModel site = siteService.site(siteID);
        model.setToSiteID(siteID);
        model.setSiteName(site.getSiteName());
        model.setTransferName(site.getTransferName());
        model.setIsDirect(site.getIsDirect());
        model.setRecipient(or.getRecipient());
        model.setRecipientTel(or.getRecipientTel());
        model.setRecipientDetailAddress(or.getRecipientDetailAddress());

        model.setContents(or.getContents());
        model.setQuantity(or.getQuantity());

        model.setPayment(or.getPayment());
        int payment = or.getPayment();
        String paymentName = "现付";
        if(payment == 1){
            paymentName = "现付";
        }
        if (payment == 2){
            paymentName = "到付";
        }
        if (payment == 3){
            paymentName = "月结";
        }

        model.setPaymentName(paymentName);
        model.setCollectionFee(or.getCollectionFee()==null?0:or.getCollectionFee());
        double value = 0;
        if (or.getGoodValue() !=null) {
            value = or.getGoodValue();
        }
        model.setValue(value);

        model.setNotice(or.getRemark()==null?"":or.getRemark());
        model.setQrcode(or.getQrcode());



        return ResultMap.init(0, "", model);
    }

    private boolean checkByExpressInfoByQRCode(String qrcode, ExpressInsertModel model){
        Map<String, Object> map = new HashMap<String, Object>();
        String url = "http://127.0.0.1/jieqd/qr/"+qrcode;
        String resultStr = HttpTools.get(url);
        System.out.println("**********************"+resultStr);
        ExpressQR result = JSON.parseObject(resultStr, ExpressQR.class);
        if(result == null) {
            return false;
        }
        OrderResponseModel or = result.getResult();
        if(or == null) {
            return false;
        }

        String sender_model = model.getSender();
        String senderIDCardNum_model = model.getSenderIDCard();

        String recipientTel_model = model.getRecipientTel();
        int destinationID_model = model.getToSiteID();
        double collectionFee_model = model.getCollectionFee();
        int destinationID_express = or.getDestinationID();
        double collectionFee_express = 0;
        if(or.getCollectionFee()!=null) {
            collectionFee_express = or.getCollectionFee().doubleValue();
        }

        if(sender_model==null || senderIDCardNum_model==null || recipientTel_model == null
                || destinationID_model == 0 || destinationID_express == 0) {
            return false;
        }

        if(sender_model.equals(or.getSender()) && senderIDCardNum_model.equals(or.getSenderIDCardNum())
                && recipientTel_model.equals(or.getRecipientTel())
                && destinationID_model == destinationID_express
                && collectionFee_model == collectionFee_express) {
            return true;
        }else {
            return false;
        }
    }


}
