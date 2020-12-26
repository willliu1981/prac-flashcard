package test;

public class T2 {
	
	private SC sc=new SC();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T2 t=new T2();
		t.sc.s="a";
		set(t.sc);
		System.out.println(t.sc.s);
	}
	
	static void set(SC sc) {
		sc=new SC();
		sc.s="b";
	}
	
	static class SC{
		public String s;

	}

}
