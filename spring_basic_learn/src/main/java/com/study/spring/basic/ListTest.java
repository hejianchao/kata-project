package com.study.spring.basic;

import java.util.List;

public class ListTest {
	private List<String> aList;

	public List<String> getaList() {
		return aList;
	}

	public void setaList(List<String> aList) {
		this.aList = aList;
	}

	@Override
	public String toString() {
		System.out.println(aList);
		return "hehe";
	}
}
