package com.demo.example4;

import java.util.ArrayList;
import java.util.List;

public class ResultHandler {

	public void printResult(List list) {
		list= new ArrayList<Employee>();
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
