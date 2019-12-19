package lessons;

public class TopologicalSort {
	
	private static String display = "";
	
	public static void resetDisplay() {
		display = "";
	}
	
	public static String getDisplay() {
		return display;
	}
	
	
	public static boolean auto(IGraph G) throws Exception{
		if (ALGraph.class.isInstance(G)) {
			//System.out.println("ALGRAPH");
			return topologicalSort((ALGraph) G);
		}else if (MGraph.class.isInstance(G)) {
			//System.out.println("MGraph");
			return topologicalSort((MGraph) G);
		}
		//System.out.println("ELSE");
		return false;
	}
	
	public static boolean topologicalSort(MGraph G) throws Exception {
		int[][] map = G.getArcs();
		int vexNum = G.getVexNum();
		int[] indegree = new int[vexNum];
		LinkStack S = new LinkStack();
		for (int i=0;i<vexNum;i++) {
			indegree[i] = 0;
			for (int j=0;j<vexNum;j++) {
				int value  = map[i][j];
				if (value!=0 && value!=MGraph.INFINITY) {
					indegree[i]++;
				}
			}
		}
		
		int count = 0;
        for (int i = 0; i < vexNum; i++) {
            if (indegree[i] == 0) {
                S.push(i);
                indegree[i] = -1;
            }
        }
        while (!S.isEmpty()) {
            int p = (int) S.pop();
            display = display+ G.getVex(p) + " ";
            count++;
            for (int j = 0; j < vexNum; j++) {
                if (map[p][j] == 1) {
                    map[p][j] = 0;
                    indegree[j]--;
                    if (indegree[j] == 0) {
                        S.push(j);
                        indegree[j] = -1;
                    }
                }
            }
        }
		
        if (count < vexNum)
			return false;
		else
			return true;
	}
	
	
	public static boolean topologicalSort(ALGraph G) throws Exception {
		//System.out.println("USING:"+G.getVexNum());
		int count = 0;
		int[] indegree = findInDegree(G);
		LinkStack S = new LinkStack();
		for (int i = 0; i < G.getVexNum(); i++) {
			//System.out.println("indegree:"+indegree[i]);
			if (indegree[i] == 0) {
				S.push(i);
				//System.out.println("PUSHING");
			}
		}
				

		while (!S.isEmpty()) {
			int i = (Integer) S.pop();
			display = display+ G.getVex(i) + " ";
			//System.out.println("TEST"+display);
			++count;
			for (ArcNode arc = G.getVexs()[i].firstArc; arc != null; arc = arc.nextArc) {
				int k = arc.adjVex;
				if (--indegree[k] == 0)
					S.push(k);
			}
		}
		if (count < G.getVexNum())
			return false;
		else
			return true;
	}

	public static int[] findInDegree(ALGraph G) throws Exception {
		int[] indegree = new int[G.getVexNum()];
		for (int i = 0; i < G.getVexNum(); i++)
			for (ArcNode arc = G.getVexs()[i].firstArc; arc != null; arc = arc.nextArc)
				++indegree[arc.adjVex];
		return indegree;
	}
}