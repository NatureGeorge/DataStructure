package lessons;

public class Counter{
	private int count;
	
	public Counter() {
		setValue();
	}
	
	public void add() {
		this.count += 1;
	}
	
	public void setValue() {
		this.count = 0;
	}
	
	public int getValue() {
		return this.count;
	}
}