package lessons;

public interface IQueue extends ISeries{
	public void clear();
	public boolean isEmpty();
	public int length();
	public Object peek() throws Exception;
	public Object poll() throws Exception;
	public void offer(Object x) throws Exception;
	public String display();
}