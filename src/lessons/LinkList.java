package lessons;

public class LinkList implements IList{
	private Node head;
	
	public LinkList() {
		head = new Node();
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head.setNext(null);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return length() == 0;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		if (head.getNext() == null)
            return 0;
        else {
            Node current = head;
            int size = 0;
            while (current.getNext() != null) {
                current = current.getNext();
                size++;
            }
            return size;
        }
	}
	
	@Override
	public Node get(int i) throws Exception {
		// TODO Auto-generated method stub
		if (i < 0 || i > length()) {
            throw new Exception("Invalid Input !");
        }
		if (i==0) return head;
		Node cur = head.getNext();
        for (int j = 0; j < i-1; ++j) {
            cur = cur.getNext();
        }
		return cur;
	}
	public void insertHead(Object x) {
		Node newNode = new Node(x);
		head.setNext(newNode);
	}
	@Override
	public void insert(int i, Object x) throws Exception {
		// TODO Auto-generated method stub
		 if (i < 0 || i > length()) {
	            throw new Exception("Invalid Input !");
	        }
		 else if (i == 0){
			 if (head.getNext() == null) {
				 insertHead(x);
			 }else {
				 Node newNode = new Node(x);
				 Node cur = head.getNext();
				 head.setNext(newNode);
				 newNode.setNext(cur);
			 }
			 
		 }
	     else {
	            Node cur = head;
	            Node node = new Node(x);
	            for (int j = 0; j < i; ++j) {
	                cur = cur.getNext();
	            }
	            node.setNext(cur.getNext());
	            cur.setNext(node);
	        }
	}
	
	@Override
	public void remove(int i) throws Exception {
		// TODO Auto-generated method stub
		if (i < 0 || i >= length()) {
            throw new Exception("Invalid Input !");
        }
        else {
            Node cur = head;
            for (int j = 0; j < i; ++j) {
                cur = cur.getNext();
            }
            cur.setNext(cur.getNext().getNext());
        }
	}

	@Override
	public int indexOf(Object x) {
		// TODO Auto-generated method stub
		Node cur = head;
        for (int j = 0; j < length(); ++j) {
            cur = cur.getNext();
            if (cur.getData().equals(x)) {
            	return j;
            }
        }
		return -1;
	}

	@Override
	public String display() {
		// TODO Auto-generated method stubs
		Node cur = head;
		String represent = "";
        while (cur.getNext() != null) {
            cur = cur.getNext();
            represent += cur.getData()+ ", ";
        }
        return represent;
	}
	
	public static void main(String args[]) {
        LinkList myList = new LinkList();

        assert myList.isEmpty();

        try {
        	myList.insert(0,1);
        	myList.insert(1,2);
        	myList.insert(2,3);
        	System.out.println(myList.display());
        	myList.remove(1);
        	System.out.println(myList.display());
        	myList.insert(1,"TARGET");
        	System.out.println(myList.display());
        }
        catch(Exception e) {
        	System.out.println(e);
        }

    }

	@Override
	public Object peek() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object poll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object pop() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void offer(Object x) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void push(Object x) throws Exception {
		// TODO Auto-generated method stub
		
	}

}