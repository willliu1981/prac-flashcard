package test;

public class T1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * String test="";
		 * 
		 * String [] s=test.split(" "); System.out.println(s[0].toString());
		 *///
		A cls = new T1().new B();
		System.out.println(cls.getClass().getTypeName());

	}

	class A {

	}

	class B extends A {

	}

	class C {

	}

}
