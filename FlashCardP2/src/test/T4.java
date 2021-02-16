package test;

import java.io.File;
import java.net.URL;

public class T4 extends T3 {

	public T4(int num) {
		super(num);
		// TODO Auto-generated constructor stub
	}

	public T4() {
		// TODO Auto-generated constructor stub
	}

	static int num;
	public String name;
	// public String System;

	public static void main(String s[]) {
		// T3 t=new T4();

		// T3 t2=new T3(2);
		// T3 t=new T4();

		/*
		 * String ss=""; String ss2=new String("");
		 * System.out.format("%s , %s",System.identityHashCode(ss),System.
		 * identityHashCode(ss2)); System.out.format("%s",ss==ss2);
		 * 
		 * File f=new File("test.txt"); System.out.println();
		 * System.out.println(f.getAbsolutePath());
		 *///
			// System.out.println(T4.rr().)

	}

	static int aaa = 0;

	static Class rr() {
		aaa++;
		return T4.class;
	}

	public void test() {
		super.num = 2;

	}
}
