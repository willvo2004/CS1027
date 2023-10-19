public class DebuggingExercise2 {

	private static int load = 1;
	public static void main(String[] args) {
		int i;
		int total;
		
		i = process(2);

		try {
			total = (i * 100) / load;
			System.out.println("The value of total is "+total);
		} catch (ArithmeticException e ) {
			System.out.println("The value of total is infinity");
		}
	}

	private static int process(int step) {
		int result = step;
		for (int i = 1; i <= 3; ++i) {
			result = result * i * step + step;
			if (result > 100) {
				load = 0;
				step = step - result;
			}
			else {
				load = load * result;
				++step;
			}
		}
		
		// What are the values of i, step, result, and load?
		return result;	
	}
}
