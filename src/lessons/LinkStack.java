package lessons;

public class LinkStack implements IStack{
	private Node top;
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		top = null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top == null;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		Node cur = top;
		int length = 0;
		while (cur != null) {
			cur = cur.getNext();
			length += 1;
		}
		return length;
	}

	@Override
	public Object peek() throws Exception {
		// TODO Auto-generated method stub
		if(! isEmpty()) {
			return top.getData();
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
			Node cur = top;
			top = top.getNext();
			return cur.getData();
		}
	}

	@Override
	public void push(Object x) throws Exception {
		// TODO Auto-generated method stub
		Node newNode = new Node(x);
		newNode.setNext(top);
		top = newNode;
	}

	@Override
	public String display() {
		// TODO Auto-generated method stub
		Node cur = top;
		String represent = "";
        while (cur.getNext() != null) {
        	represent += cur.getData()+ ", ";
            cur = cur.getNext();
        }
        represent += cur.getData();
        return represent;
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