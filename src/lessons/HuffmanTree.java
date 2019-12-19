package lessons;

class HuffmanTree{
	public HuffmanNode[] HuffmanNodes;
	public int[][] HuffCode;
	//public String[] HuffData;
	public String display = "";
	
	public int[][] huffmanCoding(int[] weights, Object[] data){
		int n = weights.length;
		int ndata = data.length;
		if (n != ndata) {
			return null;
		}
		int m = 2 * n - 1;
		HuffmanNode[] HN = new HuffmanNode[m];
		int i;
		for (i=0; i<n; i++) {
			HN[i] = new HuffmanNode(weights[i], data[i]);
		}
		for (i=n; i<m; i++) {
			HuffmanNode min1 = selectMin(HN, i-1);
			min1.flag = 1;
			HuffmanNode min2 = selectMin(HN, i-1);
			min2.flag = 1;
			HN[i] = new HuffmanNode();
			min1.parent = HN[i];
			min2.parent = HN[i];
			HN[i].lchild = min1;
			HN[i].rchild = min2;
			HN[i].weight = min1.weight + min2.weight;
			HN[i].data = String.format(HuffmanNode.format, min1.data, min2.data);
		}
		HuffmanNodes = HN;
		//int[][] HuffCode = new int[n][n];
		HuffCode = new int[n][n];
		for (int j=0;j<n;j++) {
			int start = n - 1;
			for (HuffmanNode c = HN[j], p=c.parent;p!=null;c=p,p=p.parent) {
				if (p.lchild.equals(c)) {
					HuffCode[j][start--] = 0;
				}else {
					HuffCode[j][start--] = 1;
				}
			HuffCode[j][start] = -1;
			}
		}
		return HuffCode;
	}

	
	private HuffmanNode selectMin(HuffmanNode[] HN, int end) {
		HuffmanNode min = HN[end];
		for (int i=0;i<=end;i++) {
			HuffmanNode h = HN[i];
			if (h.flag == 0 && h.weight < min.weight) {
				min = h;
			}
		}
		return min;
	}

	public HuffmanNode[] getHN() {
		return this.HuffmanNodes;
	}
	
	public int[][] getHC(){
		return this.HuffCode;
	}


	public void preRootTraverse() throws Exception{
		HuffmanNode T = HuffmanNodes[HuffmanNodes.length-1];
		if (T != null) {
			LinkStack S = new LinkStack();
			S.push(T);
			while (!S.isEmpty()) {
				T = (HuffmanNode) S.pop();
				//System.out.print(T.data);
				display = display + T.data;
				while (T != null) {
					if (T.lchild != null) {
						//System.out.print(T.lchild.data);
						//display = display + "\t" +T.lchild.data;
						display = String.format("%s, %s", display, T.lchild.data);
					}
					if (T.rchild != null) {
						S.push(T.rchild);
					}
					T = T.lchild;
				}
			}
		}
	}

	public void inRootTraverse() throws Exception{
		HuffmanNode T = HuffmanNodes[HuffmanNodes.length-1];
		if (T != null) {
			LinkStack S = new LinkStack();
			S.push(T);
			while (!S.isEmpty()) {
				while (S.peek() != null) {
					S.push(((HuffmanNode) S.peek()).lchild);
				}
				S.pop();
				if (!S.isEmpty()) {
					T = (HuffmanNode) S.pop();
					display = String.format("%s, %s", display, T.data);
					S.push(T.rchild);
				}
			}
		}
	}
	
	public void cleandisplay() {
		display = "";
	}

	public static void main(String[] args) {
		int[] weights = {23, 11, 5, 3, 29, 14, 7, 8};
		Object[] data = {"A", "B", "C", "D", "E", "F", "G", "H"};
		HuffmanTree T = new HuffmanTree();
		int[][] HN = T.huffmanCoding(weights, data);
		for (int i=0; i<HN.length; i++) {
			System.out.print(weights[i]+" ");
			for (int j=0; j<HN[i].length; j++) {
				if(HN[i][j] == -1) {
					for (int k= j + 1; k<HN[i].length; k++) {
						System.out.print(HN[i][k]);
					}
					break;
				}
			}
			System.out.println();
		}

		try {
			T.preRootTraverse();
			System.out.println(T.display);
			T.cleandisplay();
			T.inRootTraverse();
			System.out.println(T.display);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}