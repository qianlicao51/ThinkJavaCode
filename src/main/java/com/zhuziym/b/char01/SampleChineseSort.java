package com.zhuziym.b.char01;

import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.comparators.ComparatorChain;

/**
 * @Title: SampleChineseSort.java
 * @Package com.zhuziym.b.char01
 * @Description: TODO(中文拼音排序)
 * @author 作者 grq
 * @version 创建时间：2018年8月21日 下午2:56:20
 *
 */
public class SampleChineseSort {

	@SuppressWarnings("rawtypes")
	private final static Comparator CHINA_COMPARE = Collator.getInstance(java.util.Locale.CHINA);

	public static void main(String[] args) {
		sortArry();
		System.out.println();
		sortList();
	}

	@SuppressWarnings("unchecked")
	private static void sortList() {
		List<String> asList = Arrays.asList("张三", "李四", "王五", "张啊");

		Collections.sort(asList, CHINA_COMPARE);
		for (String str : asList) {
			System.out.println(str);
		}
	}

	@SuppressWarnings("unchecked")
	private static void sortArry() {
		String[] arr = { "张三", "李四", "王五", "张啊" };
		Arrays.sort(arr, CHINA_COMPARE);
		for (String string : arr) {
			System.out.println(string);
		}
	}
}
