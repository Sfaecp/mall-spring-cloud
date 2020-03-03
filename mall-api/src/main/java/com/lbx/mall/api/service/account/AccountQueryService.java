package com.lbx.mall.api.service.account;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lbx.mall.api.entity.account.Account;

@RequestMapping
public interface AccountQueryService {
	
	@PostMapping(value="/qryAccountByParams", produces="application/json")
	List<Account> qryAccountByParams(@RequestBody Map<String, String> param);
	
}
