
public class Snail {
	
	public static char icon = '@';
	private int position;
	private QueueADT<Integer> movePattern;
	
	public Snail (int[] pattern) {
		position = 0;
		movePattern = new DLQueue<>();
		for (int i = 0; i < pattern.length; i ++) {
			movePattern.enqueue(pattern[i]);
		}
		
	}
	
	public void move () {
		int firstMove = movePattern.dequeue();
		movePattern.enqueue(firstMove);
		position += firstMove;
		if (position > SnailRace.raceLength) {
			position = SnailRace.raceLength;
		}
	}
	
	public int getPosition () {
		return position;
	}
	
	public void display () {
		int dashesBefore = position;
		int dashesAfter = 50 - position;
		for (int i = 0; i < dashesBefore; i ++) {
			System.out.print("-");
		}
		System.out.print(icon);
		for (int i = 0; i < dashesAfter; i ++) {
			System.out.print("-");
		}
		System.out.print("\n");
	}

}
