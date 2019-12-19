package lessons;

public class BiTreeNode{
	public Object data;
	public BiTreeNode lchild, rchild;
	public BiTreeNode() {
		this(null);
	}
	public BiTreeNode(Object data) {
		this(data, null, null);
	}
	public BiTreeNode(Object data, BiTreeNode lchild, BiTreeNode rchild) {
		this.data = data;
		this.lchild = lchild;
		this.rchild = rchild;
	}
	
	public static BiTreeNode getLeft(BiTreeNode x, String order) {
		if (order.equals("LR")) {
			return x.lchild;
		}else {
			return x.rchild;
		}
	}
	
	public static BiTreeNode getRight(BiTreeNode x, String order) {
		if (order.equals("LR")) {
			return x.rchild;
		}else {
			return x.lchild;
		}
	}
	
	public static void setLeft(BiTreeNode x, BiTreeNode child, String order) {
		if (order.equals("LR")) {
			x.lchild = child;
		}else {
			x.rchild = child;
		}
	}
	
	public static void setRight(BiTreeNode x, BiTreeNode child, String order) {
		if (order.equals("LR")) {
			x.rchild = child;
		}else {
			x.lchild = child;
		}
	}
}