package lessons;

public class SqStack implements IStack {
	
	public Object[] stackElem;
	private int top;
	
	public SqStack (int maxSize){
		top = 0;
		stackElem = new Object[maxSize];
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		top = 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top == 0;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return top;
	}

	@Override
	public Object peek() throws Exception {
		// TODO Auto-generated method stub
		if (! isEmpty()) {
			return stackElem[top-1];
		}else {
			return null;
		}
	}

	@Override
	public Object pop() throws Exception {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		}else {
			top -= 1;
			return stackElem[top];
		}
	}

	@Override
	public void push(Object x) throws Exception {
		// TODO Auto-generated method stub
		if (top == stackElem.length) {
			throw new Exception("The Stack Is Full !");
		}else {
			stackElem[top] = x;
			top += 1;
		}
	}

	@Override
	public String display() {
		// TODO Auto-generated method stub
		String represent = "";
		for(int i=0;i<top;i++)
		{
			represent += stackElem[i] + ", ";
		}
		
		return String.format(": %s ", represent.substring(0,represent.length()-2));
	}

	@Override
	public Object get(int i) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(int i, Object x) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int i) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int indexOf(Object x) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object poll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void offer(Object x) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}