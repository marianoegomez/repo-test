package com.mercadolibre.examen.utils;

public class CacheUtils {

	public static String getCurrencyCacheKey() {
		return DateUtils.getCurrentDate("yyyy-MM-dd");
	}

}
