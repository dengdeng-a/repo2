package com.qw.chain.bean;

import java.util.List;

/*存储回显信息的类*/
public class Messages {
	private String messages;
	private Double money;
	private List<ChainUsers_types> list;
	

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public List<ChainUsers_types> getList() {
		return list;
	}

	public void setList(List<ChainUsers_types> list) {
		this.list = list;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	
	
}
