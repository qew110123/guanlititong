package yineng.datacenter.manager.util;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Copyright (c)2013,银海艺能  All rights reserved.
 * 
 * <core>字符串的工具类</core>
 * 
 * @author Administrator
 * 
 * @version
 *
 */
public class UUIDLongGenerator {

	private static int count = 10000;
	private static int step = 0;

	public static void main(String[] args) {

		int sum = 500000;

		Set<Long> set = new HashSet<Long>();

		long t1 = System.currentTimeMillis();
		for (int i = 0; i < sum; i++) {
			set.add(generateId());
		}
		System.out.println("time =" + (System.currentTimeMillis() - t1));

		System.out.println("count = " + count);
		System.out.println("step = " + step);
		System.out.println("set.size() = " + set.size());
	}

	/**
	 * 生成18位长整形数字
	 * 
	 * @return
	 */
	public static synchronized long generateId() {
		if (count > 99999) {
			step++;
			count = 10000;
		}
		return Long.parseLong("" + (System.currentTimeMillis() + step) + (count++));
	}

	/**
	 * 生成24位字符串
	 * 
	 * @return
	 */
	public static synchronized String getStringUUID() {
		count++;
		long time = System.currentTimeMillis();
		String uuid = "X" + Long.toHexString(time) + Integer.toHexString(count) + Long.toHexString(Double.doubleToLongBits(Math.random()));
		uuid = uuid.substring(0, 24).toUpperCase();
		return uuid;
	}
}
