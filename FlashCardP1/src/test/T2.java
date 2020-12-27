package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T2 {
	
	private SC sc=new SC();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		T2 t=new T2();
		t.sc.s="a";
		set(t.sc);
		System.out.println(t.sc.s);
		*///
		
		String userIn="a b c";
		String[] userIns = userIn.split(" ");
		List<String> list = (List<String>) Arrays.asList(userIns);
		list.forEach(System.out::print);
		
		for(String s:list) {
			
		}
	}
	
	static void set(SC sc) {
		sc=new SC();
		sc.s="b";
	}
	
	static class SC{
		public String s;

	}

}
