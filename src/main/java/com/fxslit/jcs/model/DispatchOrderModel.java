package com.fxslit.jcs.model;

/**
 * @program: jcs
 * @description: 调度订单
 * @author: Losn
 * @create: 2018-07-03 13:36
 **/
public class DispatchOrderModel {
    private Integer id;
    private String qrcode;
    private String sender;
    private String senderTel;

    private String senderIDCardNum;
    private String senderDetailAddress;
    private String recipient;
    private String recipientTel;
    private String recipientDetailAddress;
    private Integer destinationID;
    private String destinationName;
    private Integer payment;
    private String paymentName;
    private Double goodValue;
    private String contents;
    private Integer quantity;
    private Double collectionFee;
    private String remark;
    private String opsDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSenderTel() {
        return senderTel;
    }

    public void setSenderTel(String senderTel) {
        this.senderTel = senderTel;
    }

    public String getSenderIDCardNum() {
        return senderIDCardNum;
    }

    public void setSenderIDCardNum(String senderIDCardNum) {
        this.senderIDCardNum = senderIDCardNum;
    }

    public String getSenderDetailAddress() {
        return senderDetailAddress;
    }

    public void setSenderDetailAddress(String senderDetailAddress) {
        this.senderDetailAddress = senderDetailAddress;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getRecipientTel() {
        return recipientTel;
    }

    public void setRecipientTel(String recipientTel) {
        this.recipientTel = recipientTel;
    }

    public String getRecipientDetailAddress() {
        return recipientDetailAddress;
    }

    public void setRecipientDetailAddress(String recipientDetailAddress) {
        this.recipientDetailAddress = recipientDetailAddress;
    }

    public Integer getDestinationID() {
        return destinationID;
    }

    public void setDestinationID(Integer destinationID) {
        this.destinationID = destinationID;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public Double getGoodValue() {
        return goodValue;
    }

    public void setGoodValue(Double goodValue) {
        this.goodValue = goodValue;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getCollectionFee() {
        return collectionFee;
    }

    public void setCollectionFee(Double collectionFee) {
        this.collectionFee = collectionFee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOpsDate() {
        return opsDate;
    }

    public void setOpsDate(String opsDate) {
        this.opsDate = opsDate;
    }
}
