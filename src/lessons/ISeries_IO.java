package lessons;

public class ISeries_IO {
	public ISeries demo;
	Node cur;
	Node next;
	
	public Object receive(String[] inputList, String text) throws Exception{
		if (text == "SqList") {
			SqList demo_list = new SqList(inputList.length+10);
			for(int i=0;i<inputList.length;i++)
			{
				demo_list.insert(i, inputList[i]);
			}
			demo = demo_list;
		}else if (text == "LinkList") {
			LinkList demo_list = new LinkList();
			for(int i=0;i<inputList.length;i++)
			{
				demo_list.insert(i, inputList[i]);
			}
			demo = demo_list;
		}else if (text == "LinkStack") {
			LinkStack demo_list = new LinkStack();
			for(int i=0;i<inputList.length;i++)
			{
				demo_list.push(inputList[i]);
			}
			demo = demo_list;
		}else if (text == "SqStack") {
			SqStack demo_list = new SqStack(inputList.length+10);
			for(int i=0;i<inputList.length;i++)
			{
				demo_list.push(inputList[i]);
			}
			demo = demo_list;
		}else if (text == "CircleSqQueue") {
			CircleSqQueue demo_list = new CircleSqQueue(inputList.length+10);
			for(int i=0;i<inputList.length;i++)
			{
				demo_list.offer(inputList[i]);
			}
			demo = demo_list;
		}
		return demo;
	}
	
	public String check() {
		float step = demo.length();
		return String.format("The average-time-complexity is n/2=T(n)=O(n).\nThe average-movement-steps is %.2f", step/2); // Is It Correct?
	}
	
	public String showList() {
		return demo.display();
	}
	
	public void clearList() {
		demo.clear();
	}
	
	public int getListLength() {
		return demo.length();
	}
	
	public boolean isListEmpty() {
		return demo.isEmpty();
	}
	
	public Object getEleViaIndex(int index) throws Exception {
		//System.out.println(demo instanceof LinkList);
		if (demo instanceof LinkList) {
			cur = (Node) demo.get(index);
			return cur.getNext().getData();
		}else if (demo instanceof SqList){
			return demo.get(index);
		}else if (demo instanceof IStack) {
			return demo.peek();
		}else if (demo instanceof IQueue) {
			return demo.peek();
		}
		return null;
	}
	
	public Object getEleBeforeViaIndex(int index) throws Exception {
		if (demo instanceof LinkList) {
			Object result = cur.getData();
			if (result == null) {
				return "Nothing !";
			}else {
				return result;
			}
		}else if (demo instanceof SqList) {
			return demo.get(index-1);
		}else if (demo instanceof IStack) {
			return "CAN NOT ACCESS";
		}else if (demo instanceof IQueue) {
			return "CAN NOT ACCESS";
		}
		return null;
	}
	
	public void addEleToIndex(int index, Object ele) throws Exception{
		if (demo instanceof IList) {
			demo.insert(index, ele);
		}else if (demo instanceof IStack) {
			demo.push(ele);
		}else if (demo instanceof IQueue) {
			demo.offer(ele);
		}
		
	}
	
	public void delEleViaIndex(int index) throws Exception {
		if (demo instanceof IList) {
			demo.remove(index);
		}else if (demo instanceof IStack) {
			demo.pop();
		}else if (demo instanceof IQueue) {
			demo.poll();
		}
		
	}
	
	public Object findEle(Object x) {
		return demo.indexOf(x);
	}
}