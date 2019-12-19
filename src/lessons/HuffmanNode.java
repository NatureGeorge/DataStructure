package lessons;

public class HuffmanNode{
	public int weight;
	public Object data;
	public HuffmanNode parent, lchild, rchild;
	public int flag;
	public static String format = "(%s|%s)";
	
	public HuffmanNode(int weight, Object data) {
		this.weight = weight;
		this.data = data;
		this.parent = null;
		this.lchild = null;
		this.rchild = null;
		this.flag = 0;
	}
	
	public HuffmanNode() {
		this(0, null);
	}
}