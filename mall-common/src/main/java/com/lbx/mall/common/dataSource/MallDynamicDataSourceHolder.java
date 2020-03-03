package com.lbx.mall.common.dataSource;

public class MallDynamicDataSourceHolder {
	public static final ThreadLocal<String> THREAD_DATA_SOURCE = new ThreadLocal<>();
	
	public static String getDataSource() {
		return THREAD_DATA_SOURCE.get();
	}
	
	public static void setDataSource(String dataSource) {
		THREAD_DATA_SOURCE.set(dataSource);
	}
	
	public static void removeDataSource() {
		THREAD_DATA_SOURCE.remove();
	}
 }
