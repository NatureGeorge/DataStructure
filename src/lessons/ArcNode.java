package lessons;

public class ArcNode {
	public int adjVex;

	public int value;

	public ArcNode nextArc;

	public ArcNode() {
		this(-1, 0, null);
	}

	public ArcNode(int adjVex) {
		this(adjVex, 0, null);
	}

	public ArcNode(int adjVex, int value) {
		this(adjVex, value, null);
	}

	public ArcNode(int adjVex, int value, ArcNode nextArc) {
		this.value = value;
		this.adjVex = adjVex;
		this.nextArc = nextArc;
	}

}
