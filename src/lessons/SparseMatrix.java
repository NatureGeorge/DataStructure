package lessons;

public class SparseMatrix{
	public TripleNode data[];
	public int rows;
	public int cols;
	public int nums;
	public Counter tCounter;
	public Counter ftCounter;
	
	public SparseMatrix(int maxSize) {
		data = new TripleNode[maxSize];
		for (int i=0; i < data.length; i++) {
			data[i] = new TripleNode();
		}
		rows = 0;
		cols = 0;
		nums = 0;
	}
	
	public SparseMatrix(int rows, int cols, int maxSize) {
		data = new TripleNode[maxSize];
		for (int i=0; i < data.length; i++) {
			data[i] = new TripleNode();
		}
		this.rows = rows;
		this.cols = cols;
		nums = 0;
	}
	
	public SparseMatrix(int mat[][]) {
		int i, j, k=0, count=0;
		rows = mat.length;
		cols = mat[0].length;
		for (i=0; i < mat.length; i++) {
			for (j=0; j < mat[i].length; j++) {
				if(mat[i][j] != 0) {
					count++;
				}
			}
		}
		nums = count;
		data = new TripleNode[nums];
		for (i=0; i < mat.length; i++) {
			for (j=0; j < mat[i].length; j++) {
				if(mat[i][j] != 0) {
					data[k] = new TripleNode(i, j, mat[i][j]);
					k++;
				}
			}
		}
	}

	
	public void receive (int row, int col, float value){
		if (row < rows && col < cols) {
			data[nums] = new TripleNode(row, col, value);
			nums += 1;
		}
		
	}
	
	public SparseMatrix transpose() {
		SparseMatrix tm = new SparseMatrix(nums);
		tCounter = new Counter();
		tm.cols = rows;
		tm.rows = cols;
		tm.nums = nums;
		int q = 0;
		for (int col=0; col < cols; col++) {
			for (int p = 0; p < nums; p++) {
				if (data[p].col == col) {
					tm.data[q].row = data[p].col;
					tm.data[q].col = data[p].row;
					tm.data[q].value = data[p].value;
					q++;
				}
				tCounter.add();
			}
		}
		return tm;
	}
	
	public SparseMatrix fastTranspose() {
		SparseMatrix tm = new SparseMatrix(nums);
		ftCounter = new Counter();
		tm.cols = rows;
		tm.rows = cols;
		tm.nums = nums;
		int i, j = 0, k = 0;
		int[] num, cpot;
		if (nums > 0) {
			num = new int[cols];
			cpot = new int[cols];
			for (i = 0; i < cols; i++) {
				num[i] = 0;
				ftCounter.add();
			}
			for (i = 0; i < nums; i++) {
				j = data[i].col;
				num[j]++;
				ftCounter.add();
			}
			cpot[0] = 0;
			for (i = 1; i < cols; i++) {
				cpot[i] = cpot[i-1] + num[i-1];
				ftCounter.add();
			}
			for (i=0; i<nums; i++) {
				j = data[i].col;
				k = cpot[j];
				tm.data[k].row = data[i].col;
				tm.data[k].col = data[i].row;
				tm.data[k].value = data[i].value;
				cpot[j]++;
				ftCounter.add();
			}
		}
		return tm;
	}
	
	public String stringMatrix() {
		int i;
		String disaplay = "Content of Matrix:\nrow\tcol\tvalue\n";
		//System.out.println("Content of Matrix:\nrow\tcol\tvalue");
		for (i=0; i<nums; i++) {
			//System.out.println(String.format("%s\t%s\t%s", data[i].row, data[i].col, data[i].value));
			disaplay += String.format("%s\t%s\t%s\n", data[i].row, data[i].col, data[i].value);
		}
		//System.out.println("");
		return disaplay;
	}
	
	public static void main(String args[]) {
		int m[][] = {{0,0,8,0,0,0}, {0,0,0,0,0,0}, {5,0,0,0,16,0}, {0,0,18,0,0,0}, {0,0,0,9,0,0}};
		SparseMatrix sm = new SparseMatrix(m);
		/*
		SparseMatrix sm = new SparseMatrix(3, 4, 4);
		
		sm.receive(0, 0, (float)4.2);
		sm.receive(1, 2, (float)1.1);
		sm.receive(2, 2, (float)1.2);
		*/
		SparseMatrix tm = sm.transpose();
		SparseMatrix ttm = sm.fastTranspose();
		System.out.println(sm.stringMatrix());
		System.out.println(tm.stringMatrix());
		System.out.println(ttm.stringMatrix());
	}
}