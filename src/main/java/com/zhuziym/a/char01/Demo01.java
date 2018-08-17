package com.zhuziym.a.char01;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 * @Title: Demo01.java
 * @Package com.zhuziym.a.char01
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月16日 下午11:58:53
 *
 */
public class Demo01 {
	/**
	 * 数组是两块空间，<br>
	 * 
	 * (如果arrA对应的内 存空间直 接存储的数组内容， 那么它将没有 足够的空间去容纳arrB的所有元素)
	 * <p>
	 * 
	 * 用两块空间存储就简单的多了，arrA存储的值就变成和arrB的一样<br>
	 * ,存储的都是数组内容为{ 1, 2, 3, 4 }的内存空间的地址，此后访问arrA就和arrB<br>
	 * 是一样的了，而arrA{1,2,3}的内存空间由于不再被引用会进行垃圾回收。
	 * <p>
	 * 
	 * <p>
	 * 给数组变量赋值和给数组中元素赋值是两回事，<br>
	 * 给数据中的元素赋值是改变数据内容，而给数组变量赋值则会让变量指向<br>
	 * 一个不同的位置
	 * <p>
	 * 数组的长度是不可变的，不可变指的是数组的内容空间，一经分配，长度就不能<br>
	 * 再变了，但是可以改变数组变量的值，让它指向一个长度不同的空间，
	 * <p>
	 * 
	 * <p>
	 * 结果 [1, 2, 3]<>[1, 2, 3, 4]<br>
	 * [1, 2, 3, 4] <br>
	 * [1, 2, 51, 4]
	 */
	@Test
	public void testCode1() {
		int[] arrA = { 1, 2, 3 };
		int[] arrB = { 1, 2, 3, 4 };
		System.out.println(Arrays.toString(arrA) + "<>" + Arrays.toString(arrB));
		arrA = arrB;
		System.out.println(Arrays.toString(arrA));
		arrB[2] = 51;
		System.out.println(Arrays.toString(arrA));
	}

	/**
	 * Returns the runtime class of this {@code Object}. The returned
	 * {@code Class} object is the object that is locked by
	 * {@code static synchronized} methods of the represented class.
	 *
	 * <p>
	 * <b>The actual result type is {@code Class<? extends |X|>} where
	 * {@code |X|} is the erasure of the static type of the expression on which
	 * {@code getClass} is called.</b> For example, no cast is required in this
	 * code fragment:
	 * </p>
	 *
	 * <p>
	 * {@code Number n = 0;                             }
	 * {@code Class<? extends Number> c = n.getClass(); }
	 * </p>
	 *
	 * @return The {@code Class} object that represents the runtime class of
	 *         this object.
	 * @jls 15.8.2 Class Literals
	 */
	@Test
	public void testDemo2() throws Exception {

	}
}