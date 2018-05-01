package com.endse.common.tool;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * List工具类
 */
public class ListUtils {
	/**
	 *是否为空
	 */
	public static boolean isNotEmpty(List list) {
		if (list == null || list.size() <= 0) {
			return false;
		}
		return true;
	}

	/**
	 *
	 * @return
	 * @since <IVersion>
	 */
	public static boolean isNotEmpty(Set list) {
		if (list == null || list.size() <= 0) {
			return false;
		}
		return true;
	}

	/**
	 * @return
	 * @since <IVersion>
	 */
	public static boolean isEmpty(Set list) {
		if (list == null || list.size() <= 0) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * 
	 * @param list
	 * @return
	 * @since <IVersion>
	 */
	public static boolean isEmpty(List list) {
		if (list == null || list.size() <= 0) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * 
	 * @param list
	 * @return
	 * @since <IVersion>
	 */
	public static int size(List list) {
		if (isEmpty(list)) {
			return 0;
		}
		return list.size();
	}

	/**
	 * 按新的Class对象复制
	 * 
	 * @param source
	 *            list, example: list

	 */
	public static <E> List<E> copyTo(List<?> source, Class<E> destinationClass) throws Exception {
		if (source.size() == 0)
			return new ArrayList();
		List<E> res = new ArrayList<E>(source.size());
		for (Object o : source) {
			E e = destinationClass.newInstance();
			BeanUtils.copyProperties(o, e);
			res.add(e);
		}
		return res;
	}

	public static <T> T getOne(List<T> list) {
		if (isNotEmpty(list)) {
			return list.get(0);
		}
		return null;
	}



}
