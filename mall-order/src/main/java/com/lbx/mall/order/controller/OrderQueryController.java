package com.lbx.mall.order.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lbx.mall.api.entity.account.Account;
import com.lbx.mall.api.entity.order.Order;
import com.lbx.mall.api.entity.product.Product;
import com.lbx.mall.order.service.AcctQryService;
import com.lbx.mall.order.service.ProdQryService;

@RestController
public class OrderQueryController {
	
	@Autowired
	private ProdQryService productQueryService;
	
	@Autowired
	private AcctQryService accountQueryService;
	
	@PostMapping(value="/queryOrdersByParam", produces="application/json")
	public List<Order> queryOrdersByParam(@RequestBody Map<String, String> param){
		List<Product> productList = productQueryService.qryProductByParams(param);
		productList.parallelStream().forEach(System.out::println);
		List<Account> accountList = accountQueryService.qryAccountByParams(param);
		accountList.parallelStream().forEach(System.out::println);
		List<Order> orderList = new ArrayList<>(2);
		orderList.add(new Order("orderId1","acctId1","productId1",LocalDateTime.now(), accountList, productList));
		orderList.add(new Order("orderId2","acctId2","productId2",LocalDateTime.now(), accountList, productList));
		return orderList;
	}
	
	
}
