package lessons;


public class LinkQueue implements IQueue {
	private Node front;

	private Node rear;

	
	public LinkQueue() {
		front = rear = null;
	}

	
	public void clear() {
		front = rear = null;

	}

	
	public boolean isEmpty() {
		return front == null;
	}

	
	public int length() {
		Node p = front;
		int length = 0;
		while (p != null) {
			p = p.getNext();
			++length;
		}
		return length;
	}

	
	public void offer(Object o) {
		Node p = new Node(o);
		if (front != null) {
			rear.setNext(p);
			rear = p;
		} else

			front = rear = p;
	}

	
	public Object peek() {
		if (front != null)
			return front.getData();
		else
			return null;
	}

	
	public Object poll() {
		if (front != null) { 
			Node p = front;
			front = front.getNext();
			if (p==rear)
				rear=null;
			return p.getData();
		} else
			return null;
	}

	
	public String display() {
		if (!isEmpty()) {
			Node p = front;
			while (p != rear.getNext()) {
				System.out.print(p.getData().toString() + " ");
				p = p.getNext();
			}
		} else {
			System.out.println("None");
		}
		return "";
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
	public Object pop() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void push(Object x) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
