package com.fxslit.jcs.entity;



public class Address{
	private int id;//
	private String name;//
	private String tel;//
	private String address;//
	private int isSender;//
	private int isReceiver;//
	private int userID;//
	private long opsTimestamp;//
	private String opsDate;
	
	private int siteID;//
	private String siteName;//
	private String cardName;//
	private String cardID;//
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getIsSender() {
		return isSender;
	}
	public void setIsSender(int isSender) {
		this.isSender = isSender;
	}
	public int getIsReceiver() {
		return isReceiver;
	}
	public void setIsReceiver(int isReceiver) {
		this.isReceiver = isReceiver;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public long getOpsTimestamp() {
		return opsTimestamp;
	}
	public void setOpsTimestamp(long opsTimestamp) {
		this.opsTimestamp = opsTimestamp;
	}
	public String getOpsDate() {
		return opsDate;
	}
	public void setOpsDate(String opsDate) {
		this.opsDate = opsDate;
	}
	public int getSiteID() {
		return siteID;
	}
	public void setSiteID(int siteID) {
		this.siteID = siteID;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getCardID() {
		return cardID;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}
	
}
