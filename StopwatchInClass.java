
public class StopwatchInClass {

	// fields ---creating a player in madden.. have to add stats
	public long startTime;

	// constructor --makes objet sets fields- -this guy is 6 ft
	public StopwatchInClass() {
		// save current time to the field startTime
		startTime = 0;
	}

	// mutator check check this guy is 7 foot
	public void resetWatch() {
		startTime = (long) (System.nanoTime() * Math.pow(10, -9));
		// save current time to the field startTime
	}

	// accessor -- how tall is that guy? person.height
	public double getTime() {
		// return, in seconds, the diff between the current time and the field startTime
		return ((System.nanoTime() * Math.pow(10, -9)) - startTime);
	}

}
