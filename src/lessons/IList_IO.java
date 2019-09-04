package lessons;

public class IList_IO {
	private SqList demo_list;
	
	public void receive(String[] inputList) throws Exception{
		demo_list = new SqList(inputList.length+10);
		for(int i=0;i<inputList.length;i++)
		{
			demo_list.insert(i, inputList[i]);
		}
	}
	
	public String check() {
		float step = demo_list.length();
		return String.format("The average-time-complexity is n/2=T(n)=O(n).\nThe average-movement-steps is %.2f", step/2);
	}
	
	public String showList() {
		return demo_list.display();
	}
	
	public void clearList() {
		demo_list.clear();
	}
	
	public int getListLength() {
		return demo_list.length();
	}
	
	public boolean isListEmpty() {
		return demo_list.isEmpty();
	}
	
	public Object getEleViaIndex(int index) {
		try {
			return demo_list.get(index);
		}catch(Exception e) {
			return e;
		}
	}
	
	public void addEleToIndex(int index, Object ele) throws Exception{
		demo_list.insert(index, ele);
	}
	
	public void delEleViaIndex(int index) throws Exception {
		demo_list.remove(index);
	}
	
	public Object findEle(Object x) {
		return demo_list.indexOf(x);
	}
}