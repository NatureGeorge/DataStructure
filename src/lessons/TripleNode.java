package lessons;

public class TripleNode{
	public int row;
	public int col;
	public float value;
	
	public TripleNode(int row, int col, float value) {
		this.row = row;
		this.col = col;
		this.value = value;
	}
	
	public TripleNode() {
		this(0, 0, 0);
	}
}