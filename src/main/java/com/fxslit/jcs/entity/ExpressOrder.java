package com.fxslit.jcs.entity;

public class ExpressOrder{
    private String qrcode;
    private int id;//
    private String expressNum;//运单号码

    private int fromSiteID;//始发站ID
    private String fromSite;//
    private String senderTel;//寄件人电话
    private String sender;//寄件人
    private String senderIDCard;//寄件人身份证号码
    private String senderDetailAddress;//寄件人详细地址
    private String senderCoordinate;//寄件人地址坐标

    private int isDirect;//0否 1是
    private int toSiteID;//目的站ID
    private String toSite;//
    private String recipientTel;//收件人电话
    private String recipient;//收件人
    private String recipientDetailAddress;//收件人详细地址
    private String recipientCoordinate;//收件人坐标

    private int billingType;//计费方式 1 起步价 2 汽配 3 重量体积 4 自定义

    //汽配计费数据
    private String autoParts;//汽配列表
    //重量体积计费数据
    private double weight;//重量
    private double volume;//体积

    private String contents;//物品名称
    private int quantity;//件数

    private double systemFreight;//系统计算后得出的运费
    private double discount;//折扣1 0.95...
    private int payment;//付款方式
    private double freight;//运费（经过各种计算，最终的得到的结果）

    private double collectionFee;//代收金额
    private double value;//申明价值
    private double insuranceRate;//保险费率
    private double insuranceFee;//保价费

    private double transFee;//转货费
    private double pickupFee;//取货费
    private double deliveryFee;//派送费
    private double packingFee;//包装费
    private double stairsFee;//上楼费

    private int remark;//备注 1 签字返单送货 2 包运不包损 3 等通知送货
    private String returnNum;//签字返单单号
    private String notice;//说明

    private String codeList;//
    private String expressDate;//
    private int isConfirm;//

    private String fromWorkName;//开单业务员姓名
    private String fromWorkNum;//开单业务员编号
    private String opsDate;
    private Integer opsUserID;

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getOpsDate() {
        return opsDate;
    }

    public void setOpsDate(String opsDate) {
        this.opsDate = opsDate;
    }

    public String getFromWorkName() {
        return fromWorkName;
    }

    public void setFromWorkName(String fromWorkName) {
        this.fromWorkName = fromWorkName;
    }

    public String getFromWorkNum() {
        return fromWorkNum;
    }

    public void setFromWorkNum(String fromWorkNum) {
        this.fromWorkNum = fromWorkNum;
    }

    public String getExpressNum() {
        return expressNum;
    }

    public void setExpressNum(String expressNum) {
        this.expressNum = expressNum;
    }

    public int getFromSiteID() {
        return fromSiteID;
    }

    public void setFromSiteID(int fromSiteID) {
        this.fromSiteID = fromSiteID;
    }

    public String getSenderTel() {
        return senderTel;
    }

    public void setSenderTel(String senderTel) {
        this.senderTel = senderTel;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSenderIDCard() {
        return senderIDCard;
    }

    public void setSenderIDCard(String senderIDCard) {
        this.senderIDCard = senderIDCard;
    }

    public String getSenderDetailAddress() {
        return senderDetailAddress;
    }

    public void setSenderDetailAddress(String senderDetailAddress) {
        this.senderDetailAddress = senderDetailAddress;
    }

    public String getSenderCoordinate() {
        return senderCoordinate;
    }

    public void setSenderCoordinate(String senderCoordinate) {
        this.senderCoordinate = senderCoordinate;
    }

    public int getIsDirect() {
        return isDirect;
    }

    public void setIsDirect(int isDirect) {
        this.isDirect = isDirect;
    }

    public int getToSiteID() {
        return toSiteID;
    }

    public void setToSiteID(int toSiteID) {
        this.toSiteID = toSiteID;
    }

    public String getRecipientTel() {
        return recipientTel;
    }

    public void setRecipientTel(String recipientTel) {
        this.recipientTel = recipientTel;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getRecipientDetailAddress() {
        return recipientDetailAddress;
    }

    public void setRecipientDetailAddress(String recipientDetailAddress) {
        this.recipientDetailAddress = recipientDetailAddress;
    }

    public String getRecipientCoordinate() {
        return recipientCoordinate;
    }

    public void setRecipientCoordinate(String recipientCoordinate) {
        this.recipientCoordinate = recipientCoordinate;
    }

    public int getBillingType() {
        return billingType;
    }

    public void setBillingType(int billingType) {
        this.billingType = billingType;
    }

    public String getAutoParts() {
        return autoParts;
    }

    public void setAutoParts(String autoParts) {
        this.autoParts = autoParts;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSystemFreight() {
        return systemFreight;
    }

    public void setSystemFreight(double systemFreight) {
        this.systemFreight = systemFreight;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public double getFreight() {
        return freight;
    }

    public void setFreight(double freight) {
        this.freight = freight;
    }

    public double getCollectionFee() {
        return collectionFee;
    }

    public void setCollectionFee(double collectionFee) {
        this.collectionFee = collectionFee;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getInsuranceRate() {
        return insuranceRate;
    }

    public void setInsuranceRate(double insuranceRate) {
        this.insuranceRate = insuranceRate;
    }

    public double getInsuranceFee() {
        return insuranceFee;
    }

    public void setInsuranceFee(double insuranceFee) {
        this.insuranceFee = insuranceFee;
    }

    public double getTransFee() {
        return transFee;
    }

    public void setTransFee(double transFee) {
        this.transFee = transFee;
    }

    public double getPickupFee() {
        return pickupFee;
    }

    public void setPickupFee(double pickupFee) {
        this.pickupFee = pickupFee;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public double getPackingFee() {
        return packingFee;
    }

    public void setPackingFee(double packingFee) {
        this.packingFee = packingFee;
    }

    public double getStairsFee() {
        return stairsFee;
    }

    public void setStairsFee(double stairsFee) {
        this.stairsFee = stairsFee;
    }

    public int getRemark() {
        return remark;
    }

    public void setRemark(int remark) {
        this.remark = remark;
    }

    public String getReturnNum() {
        return returnNum;
    }

    public void setReturnNum(String returnNum) {
        this.returnNum = returnNum;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeList() {
        return codeList;
    }

    public void setCodeList(String codeList) {
        this.codeList = codeList;
    }

    public String getExpressDate() {
        return expressDate;
    }

    public void setExpressDate(String expressDate) {
        this.expressDate = expressDate;
    }

    public int getIsConfirm() {
        return isConfirm;
    }

    public void setIsConfirm(int isConfirm) {
        this.isConfirm = isConfirm;
    }

    public String getFromSite() {
        return fromSite;
    }

    public void setFromSite(String fromSite) {
        this.fromSite = fromSite;
    }

    public String getToSite() {
        return toSite;
    }

    public void setToSite(String toSite) {
        this.toSite = toSite;
    }

    public Integer getOpsUserID() {
        return opsUserID;
    }

    public void setOpsUserID(Integer opsUserID) {
        this.opsUserID = opsUserID;
    }
}
