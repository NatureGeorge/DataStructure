package lessons;

public interface IStack extends ISeries{
	public void clear();
	public boolean isEmpty();
	public int length();
	public Object peek() throws Exception;
	public Object pop() throws Exception;
	public void push(Object x) throws Exception;
	public String display();
}