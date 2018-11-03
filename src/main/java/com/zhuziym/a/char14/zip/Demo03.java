package com.zhuziym.a.char14.zip;

import java.io.File;

/**
 * @Title: Demo03.java
 * @Package com.zhuziym.a.char14.zip
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月31日 下午10:25:19
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		ApachZip.zipFiles(args[0], null, true, args[1],args[2]);
	}
}
