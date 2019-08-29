package com.client.bean;

import java.util.HashMap;
import java.util.Map;

/*
 * 通用的返回类  
 */

public class Msg {

	//状态码：200-成功 100失败
	private String code;
	//private String errorCode;
	private String msg;


	//用户要返回给浏览器的数据
	private Map<String,Object> extend = new HashMap<String,Object>();
	
	public static Msg success(){
		Msg result  = new Msg();
		result.setCode("http 200");
		result.setMsg("处理成功");
		
		return result;
	}
	
	public static Msg fail(){
		Msg result  = new Msg();
		result.setCode("http 200");
		return result;
	}
	
	public Msg add(String key, Object value) {
		this.getExtend().put(key, value);
		return this;
	}
	


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	/*public String getPrice() {
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
*/
	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}

	
	
}
