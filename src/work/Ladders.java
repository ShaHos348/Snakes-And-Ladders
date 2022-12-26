package work;
public class Ladders {
	private int top,bot;
	public Ladders(int start, int end) {
		top = end;
		bot = start;
	}
	public int getTop() {
		return top;
	}
	public int getBot() {
		return bot;
	}
}
