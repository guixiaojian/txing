package com.tx.collect;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysAsList {

	/**
	 * Arrays.asList() 将数组转换成集合(不推荐使用)
	 */
	@Test
	public void asList(){
		String[] animals  = {"cat" , "dog" , "bird"};
		List<String> animalList = Arrays.asList(animals);
		System.out.println(animalList.size());
		System.out.println(animalList.get(2));
		animalList.forEach(animal -> System.out.println(animal+" / "));

		//Arrays.asList() 方法返回的并不是 java.util.ArrayList ，而是 java.util.Arrays 的一个内部类
		// 这个内部类并没有实现集合的修改方法或者说并没有重写这些方法。
		animalList.add("pig");
		animalList.forEach(animal -> System.out.print(animal)); // 会报错

	}

	/**
	 * 自己手写
	 */
	@Test
	public void asListBySelf(){
		List<String> animalList =  new ArrayList<>();
		String[] animals  = {"cat" , "dog" , "bird"};
		for(String animal : animals){
			animalList.add(animal);
		}
		animalList.add("monkey");
		animalList.forEach(animal -> System.out.println(animal));
	}


	/**
	 * 最简便的方法(推荐)
	 */
	@Test
	public void asListByNew(){
		List<String> charList = new ArrayList<>(Arrays.asList("a", "b", "c"));
		charList.add("d");
		charList.forEach(chars -> System.out.println(chars));
	}

	/**
	 * java8 stream 操作 (推荐)
	 */
	@Test
	public void asListByStream(){
		String[] animals  = {"cat" , "dog" , "bird"};
		List<String> animalList = Arrays.stream(animals).collect(Collectors.toList());
		animalList.add("pig");
		animalList.forEach(animal -> System.out.println(animal));
	}

	/**
	 * 使用 Apache Commons Collections
	 */
	@Test
	public void asListByCollectionUtils(){
		List<String> animalList =  new ArrayList<>();
		String[] animals  = {"cat" , "dog" , "bird"};
		CollectionUtils.addAll(animalList,animals);
		animalList.forEach(animal -> System.out.println(animal));
	}

}
