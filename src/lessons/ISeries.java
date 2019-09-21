package lessons;

public interface ISeries{
	public void clear();
	public boolean isEmpty();
	public int length();
	public String display();
	
	public Object get(int i) throws Exception;
	public void insert(int i, Object x) throws Exception;
	public void remove(int i) throws Exception;
	public int indexOf(Object x);
	
	public Object peek() throws Exception;
	public Object poll() throws Exception;
	public Object pop() throws Exception;
	public void offer(Object x) throws Exception;
	public void push(Object x) throws Exception;
	
}