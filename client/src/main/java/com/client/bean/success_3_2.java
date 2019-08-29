package com.client.bean;

public class success_3_2 {

	private String BlockBegin;
	private String publicKey;
	private String signature;
	public String getBlockBegin() {
		return BlockBegin;
	}
	public void setBlockBegin(String blockBegin) {
		BlockBegin = blockBegin;
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
	public success_3_2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public success_3_2(String blockBegin, String publicKey, String signature) {
		super();
		BlockBegin = blockBegin;
		this.publicKey = publicKey;
		this.signature = signature;
	}
	
	
}
