package com.lbx.mall.api.entity.account;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Account {
	
	public Account(String accountId, String accountName, LocalDateTime createTime) {
		this.accountId = accountId;
		this.accountName = accountName;
		this.createTime = createTime;
	}

	private String accountId;
	
	private String accountName;
	
	private LocalDateTime createTime;
	
	public Account() {}
}
