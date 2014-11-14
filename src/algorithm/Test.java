package algorithm;

public class Test {
	
	public static void main(String[] args) {
		System.out.println("hello world");
		String[] s = {"fee", "fefe"};
		int a = s.length;
		StringBuilder sb = new StringBuilder("fefefe");
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
		
		
	}

}
