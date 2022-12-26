package work;
import java.awt.Point;
import java.util.ArrayList;

public class Board {
	private static ArrayList<Snakes> snakes;
	private static ArrayList<Ladders> ladders;
	public static ArrayList<Point> board(ArrayList<Point> points) {
		//Row 1
	    	points.add(new Point(217,628));
	    	points.add(new Point(265,628));
	    	points.add(new Point(313,628));
	    	points.add(new Point(361,628));
	    //Row 2	
	    	points.add(new Point(409,580));
	    	points.add(new Point(361,580));
	    	points.add(new Point(313,580));
	    	points.add(new Point(265,580));
	    	points.add(new Point(217,580));
	    	points.add(new Point(169,580));
	    //Row 3	
	    	points.add(new Point(169,532));
	    	points.add(new Point(217,532));
	    	points.add(new Point(265,532));
	    	points.add(new Point(313,532));
	    	points.add(new Point(361,532));
	    	points.add(new Point(409,532));
	    //Row 4	
	    	points.add(new Point(505,484));
	    	points.add(new Point(457,484));
	    	points.add(new Point(409,484));
	    	points.add(new Point(361,484));
	    	points.add(new Point(313,484));
	    	points.add(new Point(265,484));
	    	points.add(new Point(217,484));
	    	points.add(new Point(169,484));
	    	points.add(new Point(121,484));
	    	points.add(new Point(73,484));
    	//Row 5
	    	points.add(new Point(25,436));
	    	points.add(new Point(73,436));
	    	points.add(new Point(121,436));
	    	points.add(new Point(169,436));
	    	points.add(new Point(217,436));
	    	points.add(new Point(265,436));
	    	points.add(new Point(313,436));
	    	points.add(new Point(361,436));
	    	points.add(new Point(409,436));
	    	points.add(new Point(457,436));
	    	points.add(new Point(505,436));
	    	points.add(new Point(553,436));
    	//Row 6
	    	points.add(new Point(553,388));
	    	points.add(new Point(505,388));
	    	points.add(new Point(457,388));
	    	points.add(new Point(409,388));
	    	points.add(new Point(361,388));
	    	points.add(new Point(313,388));
	    	points.add(new Point(265,388));
	    	points.add(new Point(217,388));
	    	points.add(new Point(169,388));
	    	points.add(new Point(121,388));
	    	points.add(new Point(73,388));
	    	points.add(new Point(25,388));
    	//Row 7
	    	points.add(new Point(25,340));
	    	points.add(new Point(73,340));
	    	points.add(new Point(121,340));
	    	points.add(new Point(169,340));
	    	points.add(new Point(217,340));
	    	points.add(new Point(265,340));
	    	points.add(new Point(313,340));
	    	points.add(new Point(361,340));
	    	points.add(new Point(409,340));
	    	points.add(new Point(457,340));
	    	points.add(new Point(505,340));
	    	points.add(new Point(553,340));
    	//Row 8
	    	points.add(new Point(553,292));
	    	points.add(new Point(505,292));
	    	points.add(new Point(457,292));
	    	points.add(new Point(409,292));
	    	points.add(new Point(361,292));
	    	points.add(new Point(313,292));
	    	points.add(new Point(265,292));
	    	points.add(new Point(217,292));
	    	points.add(new Point(169,292));
	    	points.add(new Point(121,292));
	    	points.add(new Point(73,292));
	    	points.add(new Point(25,292));
    	//Row 9
	    	points.add(new Point(73,244));
	    	points.add(new Point(121,244));
	    	points.add(new Point(169,244));
	    	points.add(new Point(217,244));
	    	points.add(new Point(265,244));
	    	points.add(new Point(313,244));
	    	points.add(new Point(361,244));
	    	points.add(new Point(409,244));
	    	points.add(new Point(457,244));
	    	points.add(new Point(505,244));
    	//Row 10
	    	points.add(new Point(409,196));
	    	points.add(new Point(361,196));
	    	points.add(new Point(313,196));
	    	points.add(new Point(265,196));
	    	points.add(new Point(217,196));
	    	points.add(new Point(169,196));
    	//Row 11
	    	points.add(new Point(169,148));
	    	points.add(new Point(217,148));
	    	points.add(new Point(265,148));
	    	points.add(new Point(313,148));
	    	points.add(new Point(361,148));
	    	points.add(new Point(409,148));
    	//Row 12
	    	points.add(new Point(361,100));
	    	points.add(new Point(313,100));
	    	points.add(new Point(265,100));
	    	points.add(new Point(217,100));
    	
    	return points;
    }
	public static ArrayList<Snakes> makeSnakes() {
		snakes = new ArrayList<Snakes>();
		snakes.add(new Snakes(32,13));
		snakes.add(new Snakes(60,38));
		snakes.add(new Snakes(63,4));
		snakes.add(new Snakes(70,25));
		snakes.add(new Snakes(73,47));
		snakes.add(new Snakes(82,43));
		snakes.add(new Snakes(89,53));
		snakes.add(new Snakes(97,12));
		return snakes;
	}
	public static ArrayList<Ladders> makeLadders() {
		ladders = new ArrayList<Ladders>();
		ladders.add(new Ladders(6,16));
		ladders.add(new Ladders(8,41));
		ladders.add(new Ladders(26,29));
		ladders.add(new Ladders(50,93));
		ladders.add(new Ladders(59,84));
		ladders.add(new Ladders(55,80));
		return ladders;
	}
}
