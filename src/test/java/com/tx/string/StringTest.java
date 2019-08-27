package com.tx.string;

import org.junit.Test;

public class StringTest {

	@Test
	public void testString(){


		String str1 = "第"+1+"个String"+"aaa";

		//str2的值不是直接量，但是编译时可以确定它的值，然后直接引用字符串池中对应的字符串，所以str1 == str2
		String str2 = "第"+1+"个String"+"aaa";

		System.out.println(str1 == str2);

		String trimStr = " 213 456 aaa   ";
		String replace = trimStr.trim();
		System.out.println(replace);
	}

}
