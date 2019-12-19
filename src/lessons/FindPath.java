package lessons;


public class FindPath {
	private boolean[] visited;

	private int i = 0;

	private boolean find = false;

	public String findPath(IGraph G, int u, int v, int k) throws Exception {
		visited = new boolean[G.getVexNum()];
		for (int w = 0; w < G.getVexNum(); w++)
			visited[w] = false;
		find_DFS(G, u, v, k);
		if (find)
			
			return (G.getVex(u) + " and " + G.getVex(v) + " exists a path of "
					+ k + " length ");
		else
			return (G.getVex(u) + " and " + G.getVex(v) + " does not exists a path of "
					+ k + " length ");
	}

	private void find_DFS(IGraph G, int u, int v, int k) throws Exception {
		if (i == k && u == v)
			find = true;
		else if (!find) {
			visited[u] = true;
			for (int w = G.firstAdjVex(u); w >= 0; w = G.nextAdjVex(u, w))
				if (!visited[w]) {
					if (i < k) {
						++i;
						find_DFS(G, w, v, k);
					} else
						break;
				}
			--i;
		}
	}
}