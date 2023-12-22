
public class ClassB {

	private int x;
	private static int y;

	public static void main(String[] args) {
		ClassB obj = new ClassB();
		ClassB obj2 = new ClassB();
		obj2.x = 20;
		obj.x = 10;
		y = 30;


		System.out.println(obj.x);
		System.out.println(y);
		System.out.println(obj2.x);
		System.out.println(y);



	}

}
