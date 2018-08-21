package com.zhuziym.a.char10;

/**
 * @Title: Demo02.java
 * @Package com.zhuziym.a.char10
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月20日 下午2:11:49
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		String a = "a" + "b" + 1;
		String b = "ab1";
		b.intern();
		System.out.println(a == b);

	}
}
