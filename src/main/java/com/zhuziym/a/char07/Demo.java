package com.zhuziym.a.char07;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import ch.lambdaj.Lambda;

/**
 * @Title: Demo.java
 * @Package com.zhuziym.a.char07
 * @Description: TODO(集合排序)
 * @author 作者 grq
 * @version 创建时间：2018年8月27日 下午3:47:09
 *
 */
public class Demo {
	String[] arr = { "hello", "world", "Break", "abc" };

	@Test
	public void arraysDemo() {
		Arrays.sort(arr);
		// [Break, abc, hello, world]
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * String提供的忽略大小写排序
	 */
	@Test
	public void arraysDemo2() {
		Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER);
		// [abc, Break, hello, world]
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 使用匿名内部类实现Comparator
	 */
	@Test
	public void arraysDemo3() {
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}
		});
		print();
	}

	public void print() {
		System.out.println(Arrays.toString(arr));
	}

	/**
	 ************************************************************
	 * Collections类提供的2个静态方法，返回逆序的Comparator
	 ************************************************************
	 * public static void reverse(List<?> list)
	 * <p>
	 * public static <T> Comparator<T> reverseOrder()
	 */
	@Test
	public void reverDemo() {
		Arrays.sort(arr, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
		print();
	}
}
