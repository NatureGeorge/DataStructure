package lessons;

public class SqList implements IList {
	private Object[] listElem;
	private int curLen;
	
	public SqList(int maxSize) {
		curLen = 0;
		listElem = new Object[maxSize];
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		curLen = 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return curLen == 0;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return curLen;
	}

	@Override
	public Object get(int i) throws Exception {
		// TODO Auto-generated method stub
		if (i < 0 || i > curLen-1) {
			throw new Exception(String.format("The %d element does not exist!", i));
		}
		return listElem[i];
	}

	@Override
	public void insert(int i, Object x) throws Exception {
		// TODO Auto-generated method stub
		if (curLen == listElem.length) {
			throw new Exception("The List Is Full !");
		}
		if (i <0 || i > curLen) {
			throw new Exception("Invalid Input !");
		}
		for (int j = curLen; j > i; j--) {
			listElem[j] = listElem[j - 1];
		}
		listElem[i] = x;
		curLen++;
	}

	@Override
	public void remove(int i)  throws Exception {
		// TODO Auto-generated method stub
		if (i < 0 || i > curLen - 1) {
			throw new Exception("Invalid Input !");
		}
		for (int j = i; j < curLen - 1; j++) {
			listElem[j] = listElem[j+1];
		}
		curLen--;
	}

	@Override
	public int indexOf(Object x) {
		// TODO Auto-generated method stub
		int j = 0;
		while (j < curLen && !listElem[j].equals(x)) {
			j++;
		}
		if (j < curLen) {
			return j;
		}
		else {
			return -1;
		}
	}

	@Override
	public String display() {
		// TODO Auto-generated method stub
		String represent = "";
		for(int i=0;i<curLen;i++)
		{
			represent += listElem[i] + ", ";
		}
		
		return String.format("[ %s ]", represent.substring(0,represent.length()-2));
	}
}