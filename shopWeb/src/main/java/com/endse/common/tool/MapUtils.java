package com.endse.common.tool;

import java.util.*;

/**
 * 
 * Map工具类
 * 
 * @author administrator
 * @version [v1.0, 2016-8-1]
 * @see
 * @since
 */
public final class MapUtils {
	/**
	 * 判断Map对象是否为空
	 * 
	 * @param map
	 * @return
	 * @since <IVersion>
	 */
	public static boolean isEmpty(Map map) {
		if (map == null || map.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * 判断Map对象是否为空
	 * 
	 * @param map
	 * @return
	 * @since <IVersion>
	 */
	public static boolean isNotEmpty(Map map) {
		if (map != null && !map.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * 将Map的key转化为大写
	 * 
	 * 
	 * @param map
	 * @return
	 * @since <IVersion>
	 */
	public static Map<String, Object> keyToUpperCase(Map<String, Object> map) {
		if (MapUtils.isEmpty(map)) {
			return map;
		}
		Set<String> set = map.keySet();
		Map<String, Object> tempMap = new HashMap<String, Object>();
		// 将Map的Key全部转化为大写
		for (String key : set) {
			tempMap.put(key.toUpperCase(), map.get(key));
		}
		return tempMap;
	}

	/**
	 * 将Map集合的key转化为大写
	 * 
	 * 
	 * @param list
	 * @return
	 * @since <IVersion>
	 */
	public static List<Map<String, Object>> keyToUpperCase(List<Map<String, Object>> list) {
		if (ListUtils.isEmpty(list)) {
			return list;
		}
		List<Map<String, Object>> tempList = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> map : list) {
			tempList.add(MapUtils.keyToUpperCase(map));
		}
		return tempList;
	}
}
