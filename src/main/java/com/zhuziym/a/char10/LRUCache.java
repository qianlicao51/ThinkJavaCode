package com.zhuziym.a.char10;

import java.util.LinkedHashMap;

/**
 * @Title: LRUCache.java
 * @Package com.zhuziym.a.char10
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月20日 下午3:25:41
 *          <p>
 *          LinkedHashMap可以用于缓存，例如保存部分活跃的用户
 *          <p>
 *          缓存容量有限，不能无限缓存所有的数据，如果缓存满，需要存储新数据时，<br>
 *          就需要一定的策略将一些老的数据清理出去，这个策略叫做替换算法。LRU是一<br>
 *          种流行的替换算法。刚被使用的很快再次被用的可能性高，而最久没被使用的<br>
 *          再次被使用的可能性低，所以被优先清理。
 *
 *
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
	private int maxEntries;

	public LRUCache(int maxEntries) {
		super(16, 0.75f, true);
		this.maxEntries = maxEntries;
	}

	/**
	 * <p>
	 * 添加元素到LinkedHahsMap后，会调动此方法，传递的参数是最久没被访问<br>
	 * 的键值对，如果返回true，则这个最久的键值对就会被删除，
	 */
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		return size() > maxEntries;
	}

	public static void main(String[] args) {
		LRUCache<String, Object> lruCache = new LRUCache<String, Object>(3);

		lruCache.put("a", "avalue");
		lruCache.put("b", "bvalue");
		lruCache.put("c", "call");
		lruCache.get("a");
		lruCache.put("d", "del");

		System.out.println(lruCache);
	}
}
