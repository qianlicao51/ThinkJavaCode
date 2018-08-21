package com.zhuziym.a.char09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @Title: Demo01.java
 * @Package com.zhuziym.a.char09
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月20日 上午8:58:32
 *
 */
public class Demo01 {
	/**
	 * 集合转数组
	 * 
	 * @throws Exception
	 */
	@Test
	public void listToArr() throws Exception {
		List<String> asList = Arrays.asList("1", "g", "r", "3");
		String[] array = (String[]) asList.toArray();

	}

	/**
	 * list转数组，如果参数数组长度足以容纳所有元素，就使用该数组
	 * <p>
	 * 否则就建立一个数组
	 */
	@Test
	public void listToArrys() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);

		Integer[] arrA = new Integer[3];
		arrayList.toArray(arrA);
		System.out.println(Arrays.toString(arrA));

		Integer[] array = arrayList.toArray(new Integer[1]);
		for (Integer integer : array) {
			System.out.println(integer);
		}
	}
	/**
	 * <p>
	 * ArrayList不是线程安全的。
	 * <p>
	 * ArrayList特点
	 * <p>
	 * 1)可以随机访问，按照索引位置进行访问效率很高，
	 * <p>
	 * 2)除非数组已经排序，否则按照内容查找效率比较低
	 * <p>
	 * 3)添加元素的效率还可以，重新分配和复制数组的开销被平摊了
	 * <p>
	 * 4)插入和删除元素效率比较低，因为要移动元素
	 * <p>
	 * <p>
	 * LinkedList的特点
	 * <p>
	 * 1)按需分配空间，不需要预先分配很多空间
	 * <p>
	 * 2)不可以随机访问，按照索引位置访问效率比较低，必须从头或尾顺着链接找
	 * <p>
	 * 3)不管列表是否已经排序，只要按照内容查找元素，效率都比较低
	 * <p>
	 * 4)在两端添加、删除元素的效率很高
	 * <p>
	 * 5)在中间插入、删除元素，要先定位，
	 */
}
