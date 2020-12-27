package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
		///
		
		String userIn="a b";
		String[] userIns = userIn.split(" ");
		List<String> list = (List<String>) Arrays.asList(userIns);
		*///
		
		//*
		try {
			Class<?> c =Class.forName("test.T2$TestC");
			
			//Constructor <?> ctor =c.getConstructor(new Class[]{SC[].class, SC.class});
			Constructor <?> ctor =c.getConstructor(A.class,SC[].class);
			TestC tc=(TestC)ctor.newInstance(new A(),new SC[2] );
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		///
		System.out.println("-----------");
		//*
		SC [] scs=new SC[]{new SC(),new SC(),new SC()};
//		TestC tc=new TestC(new A(),new SC(),new SC());
		//TestC tc=new TestC(new A(),scs);
		///
		
	}

	
	static void set(SC sc) {
		sc=new SC();
		sc.s="b";
	}
	
	static class SC{
		public String s="sc";

	}
	static class A{
		public String s="a";
		
	}
	
	static class TestC{
		public TestC(A[] as) {
			//System.out.println("A: "+a);
			//for(A a:as) {
			//	System.out.println("A: "+a);
				
			
		}
		public TestC(SC sc) {
			//System.out.println("A: "+a);

				System.out.println( sc);
				
		
		}
		public TestC(A a,SC... sc) {
			//System.out.println("A: "+a);
			
			System.out.println( a);
			System.out.println( sc);
			
			
		}
	}

}
