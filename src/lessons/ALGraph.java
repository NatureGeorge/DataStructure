package lessons;

public class ALGraph implements IGraph {
	private GraphKind kind;

	private int vexNum;

	private VNode[] vexs;

	public ALGraph() {
		this(null, 0, null);
	}

	public ALGraph(GraphKind kind, int vexNum, VNode[] vexs) {
		this.kind = kind;
		this.vexNum = vexNum;
		this.vexs = vexs;
	}

	public void createGraph() {
		switch (kind) {
		case UDG:
			createUDG();
			return;
		case DG:
			createDG();
			return;
		case DN:
			createDN();
			return;
		case UDN:
			createUDN();
			return;
		}
	}


	private void createUDG() {
		
	};

	
	private void createDG() {
		
	};

	
	private void createUDN() {
	}


	private void createDN() {
	}


	public void addArc(int v, int u, int value) {
		ArcNode arc = new ArcNode(u, value);
		arc.nextArc=vexs[v].firstArc;
		vexs[v].firstArc=arc;
	}


	public int getVexNum() {
		return vexNum;
	}

	public int locateVex(Object vex) {
		for (int v = 0; v < vexNum; v++)
			if (vexs[v].data.equals(vex))
				return v;
		return -1;
	}

	public VNode[] getVexs() {
		return vexs;
	}

	public GraphKind getKind() {
		return kind;
	}


	public Object getVex(int v) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("NONE" + v + "NONE");

		return vexs[v].data;
	}


	public int firstAdjVex(int v) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("NONE" + v + "NONE");

		VNode vex = vexs[v];
		if (vex.firstArc != null)
			return vex.firstArc.adjVex;
		else
			return -1;
	}


	public int nextAdjVex(int v, int w) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("NONE" + v + "NONE");
		VNode vex = vexs[v];

		ArcNode arcvw = null;
		for (ArcNode arc = vex.firstArc; arc != null; arc = arc.nextArc)
			if (arc.adjVex == w) {
				arcvw = arc;
				break;
			}
		if (arcvw != null && arcvw.nextArc != null)
			return arcvw.nextArc.adjVex;
		else
			return -1;
	}


	public void setKind(GraphKind kind) {
		this.kind = kind;
	}

	public void setVexNum(int vexNum) {
		this.vexNum = vexNum;
	}

	public void setVexs(VNode[] vexs) {
		this.vexs = vexs;
	}
}
