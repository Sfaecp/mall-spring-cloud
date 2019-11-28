package com.lbx.mall.common.dataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MallDynamicDataSource extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		return MallDynamicDataSourceHolder.getDataSource();
	}

}
