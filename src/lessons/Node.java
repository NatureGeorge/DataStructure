package lessons;

class Node{
	private Object data;
	private Node next;
	
	public Node() {
		this(null, null);
	}
	
	public Node(Object data) {
		this(data, null);
	}
	
	public Node(Object data, Node next) {
		//this.data = data;
		//this.next = next;
		setData(data);
		setNext(next);
	}
	
	public Object getData() {
		return this.data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
}