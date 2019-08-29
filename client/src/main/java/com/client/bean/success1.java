package com.client.bean;

public class success1 {

	//private int code;

	private String price;
	private String priceDesc;
	private String cost;
	private String costDesc;
	private String key;
	private String keyExpire;
	private String encodeType;
	private String storeNode;
	private String publicKey;
	private String signature;


	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPriceDesc() {
		return priceDesc;
	}
	public void setPriceDesc(String priceDesc) {
		this.priceDesc = priceDesc;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getCostDesc() {
		return costDesc;
	}
	public void setCostDesc(String costDesc) {
		this.costDesc = costDesc;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getKeyExpire() {
		return keyExpire;
	}
	public void setKeyExpire(String keyExpire) {
		this.keyExpire = keyExpire;
	}
	public String getEncodeType() {
		return encodeType;
	}
	public void setEncodeType(String encodeType) {
		this.encodeType = encodeType;
	}
	public String getStoreNode() {
		return storeNode;
	}
	public void setStoreNode(String storeNode) {
		this.storeNode = storeNode;
	}
	public String getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	public success1(String price, String priceDesc, String cost, String costDesc, String key, String keyExpire,
			String encodeType, String storeNode, String publicKey, String signature) {
		super();
		this.price = price;
		this.priceDesc = priceDesc;
		this.cost = cost;
		this.costDesc = costDesc;
		this.key = key;
		this.keyExpire = keyExpire;
		this.encodeType = encodeType;
		this.storeNode = storeNode;
		this.publicKey = publicKey;
		this.signature = signature;
	}
	public success1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
