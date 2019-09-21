package lessons;

public class CircleSqQueue implements IQueue{
	
	public Object[] queueElem;
	private int front;
	private int rear;
	//private int size;

	public CircleSqQueue (int maxSize){
		front = rear = 0;
		//size = maxSize;
		queueElem = new Object[maxSize];
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		front = rear = 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		//return (rear+1)%size == front;
		return (rear+1)%queueElem.length == front;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return (rear - front + queueElem.length) % queueElem.length;
	}

	@Override
	public Object peek() throws Exception {
		// TODO Auto-generated method stub
		if (front == rear) {
			return null;
		}else {
			return queueElem[front];
		}
		
	}

	@Override
	public Object poll() throws Exception {
		// TODO Auto-generated method stub
		if (front == rear) {
			return null;
		}else{
			Object t = queueElem[front];
			front = (front + 1) % queueElem.length;
			return t;
		}
	}

	@Override
	public void offer(Object x) throws Exception {
		// TODO Auto-generated method stub
		if ((rear+1)%queueElem.length == front) {
			throw new Exception("The CircleSqQueue Is Full !");
		}else {
			queueElem[rear] = x;
		}
		rear = (rear + 1) % queueElem.length;
	}

	@Override
	public String display() {
		// TODO Auto-generated method stub
		String represent = "";
		if (! isEmpty()) {
			for (int i = front; i != rear; i = (i+1) % queueElem.length) {
				represent += queueElem[i] + ", ";
			}
		}
		return String.format("[ %s ]", represent.substring(0,represent.length()-2));
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