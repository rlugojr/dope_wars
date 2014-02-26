package dopewars;

public class Day{

	int num;

	public Day(int dayNumber){
		num = dayNumber;
	}

	public void start(){
		String dayString = String.format("Day %d", num);

		System.out.println(dayString);
	}
}