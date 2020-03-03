package com.lbx.mall.product.service;

import org.springframework.cloud.openfeign.FeignClient;
import com.lbx.mall.api.service.account.AccountQueryService;

@FeignClient("mall-account")
public interface AcctQryService extends AccountQueryService{

	//@PostMapping(value="/qryAccountByParams", produces="application/json")
	//List<Account> qryAccountByParams(@RequestBody Map<String, String> param);
}
