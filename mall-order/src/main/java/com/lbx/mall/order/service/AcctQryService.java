package com.lbx.mall.order.service;

import org.springframework.cloud.openfeign.FeignClient;

import com.lbx.mall.api.service.account.AccountQueryService;

@FeignClient(value="mall-account")
public interface AcctQryService extends AccountQueryService{

}
