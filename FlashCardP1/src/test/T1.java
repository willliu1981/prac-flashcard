package test;

import java.util.Scanner;

public class T1 {
	
	public static final String sss="a";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * String test="";
		 * 
		 * String [] s=test.split(" "); System.out.println(s[0].toString());
		 ///
		A cls = new T1().new B();
		System.out.println(cls.getClass().getTypeName());
		
		String s="a";
		
		switch(s) {
		case sss:
			
		}
		///
		Scanner sc=new Scanner(System.in);
		
		//String ss=sc.nextLine();
		String ss="a";
		
		String s[]=ss.split(" ");
		
		System.out.println(s[0]==sss);
		System.out.println(s[0]);
		System.out.println("s0 : "+s[0].hashCode()+" , "+System.identityHashCode(s[0]));
		System.out.println("sss : "+sss.hashCode()+" , "+System.identityHashCode(sss));
		 ///
		
		Scanner sc=new Scanner(System.in);
		
		String ss=sc.nextLine();
		//String ss="a";
		
		System.out.println(ss==sss);
		System.out.println(ss);
		System.out.println("ss : "+ss.hashCode()+" , "+System.identityHashCode(ss));
		System.out.println("sss : "+sss.hashCode()+" , "+System.identityHashCode(sss));
		*///
		
		System.out.println("Enter country code\nChoices: IND, USA, JPN, NZ, WI");
	    Scanner cc = new Scanner(System.in);
	    String txt = cc.nextLine();
	    
	    System.out.println("txt : "+System.identityHashCode(txt));
	    System.out.println("IND : "+System.identityHashCode("IND"));
	    switch (txt) {
	        case "IND":
	            System.out.println(txt + " refers to INDIA");
	            break;

	        case "USA":
	            System.out.println(txt + " refers to UNITED STATES");
	            break;

	        case "JPN":
	            System.out.println(txt + " refers to JAPAN");
	            break;

	        case "NZ":
	            System.out.println(txt + " refers to NEW ZEALAND");
	            break;

	        case "WI":
	            System.out.println(txt + " refers to WEST INDIES");
	            break;

	        default:
	            System.out.println("Invalid choice");
	   }
	}

	class A {

	}

	class B extends A {

	}

	class C {

	}

}
