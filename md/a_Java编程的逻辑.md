# Java编程的逻辑

# 第1章 编程基础



## 1.2 赋值

`数组`

---

```java
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

```

