package lessons;

class Sort{
	
	public RecordNode[] r;
    public int curlen; 
    
    public Sort(int maxSize) {
        this.r = new RecordNode[maxSize];
        this.curlen = 0;
    }
    
    public int length() {
        return curlen;
    }
    
    public void setR(RecordNode[] newR) {
    	this.r = newR;
    	this.curlen = newR.length;
    }
    
    public void insert(int i, RecordNode x) throws Exception {
        if (curlen == r.length) { 
            throw new Exception("The list is full");
        }
        if (i < 0 || i > curlen) { 
            throw new Exception("Invalid insertion index");
        }
        for (int j = curlen; j > i; j--) {
            r[j] = r[j - 1]; 
        }
        r[i] = x;
        this.curlen++;
    }
    
    public void insertSort() {
        RecordNode temp;
        int i, j;
        for (i = 1; i < this.curlen; i++) {
            temp = r[i];
            for (j = i - 1; j >= 0 && temp.key.compareTo(r[j].key) < 0; j--) { //将前面比r[i]大的记录向后移动
                r[j + 1] = r[j];
            }
            r[j + 1] = temp; 
        }
    }

	
	public void shellSort(int[] d) {
        RecordNode temp;
        int i, j;
        for (int k = 0; k < d.length; k++) {
            int dk = d[k];
            for (i = dk; i < this.curlen; i++) {
                temp = r[i];
                for (j = i - dk; j >= 0 && temp.key.compareTo(r[j].key) < 0; j -= dk) {
                    r[j + dk] = r[j];
                }
                r[j + dk] = temp;
            }
        }
    }

	public static int[] hibbard(int length) {
		double k = Math.log(length) / Math.log(2) - 1;
		int num = (int) k;
		int[] array = new int[length];
		for (int i=0; num-i>0;i++) {
			array[i] = (int) Math.pow(2, num-i) - 1;
		}
		return array;
	}
	
	public void bubbleSort() {
		RecordNode temp;
	    boolean flag = true;
	    for (int i = 1; i < this.curlen && flag; i++) {
	        flag = false;
	        for (int j = 0; j < this.curlen - i; j++) {
	            if (r[j].key.compareTo(r[j + 1].key) > 0) {
	                temp = r[j];
	                r[j] = r[j + 1];
	                r[j + 1] = temp;
	                flag = true;
	            }
	        }
	    }
	}

	public int Partition(int i, int j) {
        RecordNode pivot = r[i];
        while (i < j) { 
            while (i < j && pivot.key.compareTo(r[j].key) <= 0) {
                j--;
            }
            if (i < j) {
                r[i] = r[j];
                i++;
            }
            while (i < j && pivot.key.compareTo(r[i].key) > 0) {
                i++;
            }
            if (i < j) {
                r[j] = r[i];
                j--;
            }
        }
        r[i] = pivot;
        return i;
    }

	public void qSort(int low, int high) {
        if (low < high) {
            int pivotloc = Partition(low, high);
            qSort(low, pivotloc - 1);
            qSort(pivotloc + 1, high);
        }
    }

	public void quickSort() {
        qSort(0, this.curlen - 1);
    }

	public String display() {
		String dis = "";
        for (int i = 0; i < this.curlen; i++) {
            dis = dis + r[i].key.toString() + ", ";
        }
        return dis;
    }
}