# Java特种兵上册

# 第1章 



## 1.5 功底补充



- 实例化ArrayList的时候带上长度，例如 new ArrayList(128);这样降低了内存碎片化和内存拷贝的次数



中文拼音排序

```java
public class SampleChineseSort {

	private final static Comparator CHINA_COMPARE = Collator.getInstance(java.util.Locale.CHINA);

	public static void main(String[] args) {
		sortArry();
		System.out.println();
		sortList();
	}

	private static void sortList() {
		List<String> asList = Arrays.asList("张三", "李四", "王五", "张啊");

		Collections.sort(asList, CHINA_COMPARE);
		for (String str : asList) {
			System.out.println(str);
		}
	}

	private static void sortArry() {
		String[] arr = { "张三", "李四", "王五", "张啊" };
		Arrays.sort(arr, CHINA_COMPARE);
		for (String string : arr) {
			System.out.println(string);
		}
	}
}

```

