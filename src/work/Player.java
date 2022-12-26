package work;
public class Player {
	private int pos;
	public Player() {
		pos=0;
	}
	public void setPos(int num) {
		pos = num;
	}
	public void addPos(int num) {
		pos += num;
	}
	public int getPos() {
		return pos;
	}
}
