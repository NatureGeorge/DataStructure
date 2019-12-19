package lessons;

public class MGraph implements IGraph {
	public final static int INFINITY = Integer.MAX_VALUE;

	private GraphKind kind;

	private int vexNum;

	private Object[] vexs;

	private int[][] arcs;

	public MGraph() {
		this(null, 0, null, null);
	}

	public MGraph(GraphKind kind, int vexNum, Object[] vexs, int[][] arcs) {
			this.kind = kind;
			this.vexNum = vexNum;
			this.vexs = vexs;
			this.arcs = arcs;
		}

	public void createGraph() {
		switch (kind) {
		case UDG:
			createUDG();
			return;
		case DG:
			createDG();
			return;
		case UDN:
			createUDN();
			return;
		case DN:
			createDN();
			return;
		}
	}

	public GraphKind getKind() {
		return kind;
	}
	
	private void createUDG() {
		//temp useless
	};

	private void createDG() {
		//temp useless
	};

	private void createUDN() {
		//temp useless
	}

	private void createDN() {
		//temp useless
	}

	public int getVexNum() {
		return vexNum;
	}


	public int locateVex(Object vex) {
		for (int v = 0; v < vexNum; v++)
			if (vexs[v].equals(vex))
				return v;
		return -1;
	}

	public Object getVex(int v) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("None" + v + "None");
		return vexs[v];
	}

	public int firstAdjVex(int v) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("None" + v + "None");

		for (int j = 0; j < vexNum; j++)
			if (arcs[v][j] != 0 && arcs[v][j] < INFINITY)
				return j;

		return -1;
	}

	public int nextAdjVex(int v, int w) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("None" + v + "None");

		for (int j = w + 1; j < vexNum; j++)
			if (arcs[v][j] != 0 && arcs[v][j] < INFINITY)
				return j;

		return -1;
	}

	public int[][] getArcs() {
		return arcs;
	}

	public Object[] getVexs() {
		return vexs;
	}

	public void setArcs(int[][] arcs) {
		this.arcs = arcs;
	}

	public void setKind(GraphKind kind) {
		this.kind = kind;
	}

	public void setVexNum(int vexNum) {
		this.vexNum = vexNum;
	}

	public void setVexs(Object[] vexs) {
		this.vexs = vexs;
	}

	@Override
	public void addArc(int v, int u, int value) {
		// TODO Auto-generated method stub
		
	}

}
