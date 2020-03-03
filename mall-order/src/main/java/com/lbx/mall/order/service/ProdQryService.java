package com.lbx.mall.order.service;

import org.springframework.cloud.openfeign.FeignClient;

import com.lbx.mall.api.service.product.ProductQueryService;

@FeignClient(value="mall-product")
public interface ProdQryService extends ProductQueryService{

}
