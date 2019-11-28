package com.lbx.mall.product.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lbx.mall.api.entity.account.Account;
import com.lbx.mall.api.entity.product.Product;
import com.lbx.mall.product.service.AcctQryService;

@RestController
public class ProductQueryController {
	
	@Autowired
	private AcctQryService accountQueryService;
	
//	@Autowired
//	private AccountService accountService;

	@PostMapping(value="/qryProductByParams", produces="application/json")
	public List<Product> qryProductByParams(@RequestBody Map<String, String> param) {
		//List<Account> accountList = accountQueryService.qryAccountByParams(param);
		System.out.println("qryProductByParams");
		List<Account> accountList = accountQueryService.qryAccountByParams(param);
		System.out.println(accountList == null);
		
		List<Product> productList = new ArrayList<>(2);
		productList.add(new Product("productId1","productName1",LocalDateTime.now()));
		productList.add(new Product("productId2","productName2",LocalDateTime.now()));
		return productList;
	}
}
