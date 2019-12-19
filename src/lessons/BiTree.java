package lessons;

public class BiTree{
	private BiTreeNode root;
	private static String display = "";
	private static int index = 0;
	
	public BiTree() {
		this.root = null;
	}
	
	public BiTree(BiTreeNode root) {
		this.root = root;
	}
	/*
	 * preRootTraverse: with Recursion
	*/
	public void preRootTraverse(BiTreeNode T, String order) {
		if (T != null) {
			//System.out.print(T.data);
			display = display + T.data;
			preRootTraverse(BiTreeNode.getLeft(T, order), order);
			preRootTraverse(BiTreeNode.getRight(T, order), order);
		}
	}
	/*
	 * preRootTraverse: with LinkStack
	*/
	public void preRootTraverse(String order) throws Exception{
		BiTreeNode T = root;
		if (T != null) {
			LinkStack S = new LinkStack();
			S.push(T);
			while (!S.isEmpty()) {
				T = (BiTreeNode) S.pop();
				//System.out.print(T.data);
				display = display + T.data;
				while (T != null) {
					if (BiTreeNode.getLeft(T, order) != null) {
						//System.out.print(T.lchild.data);
						display = display + BiTreeNode.getLeft(T, order).data;
					}
					if (BiTreeNode.getRight(T, order) != null) {
						S.push(BiTreeNode.getRight(T, order));
					}
					T = BiTreeNode.getLeft(T, order);
				}
			}
		}
	}
	/*
	 * inRootTraverse: with Recursion
	*/
	public void inRootTraverse(BiTreeNode T, String order) {
		if (T != null) {
			inRootTraverse(BiTreeNode.getLeft(T, order), order);
			//System.out.print(T.data);
			display = display + T.data;
			inRootTraverse(BiTreeNode.getRight(T, order), order);
		}
	}
	/*
	 * inRootTraverse: with LinkStack
	*/
	public void inRootTraverse(String order) throws Exception{
		BiTreeNode T = root;
		if (T != null) {
			LinkStack S = new LinkStack();
			S.push(T);
			while (!S.isEmpty()) {
				while (S.peek() != null) {
					S.push(BiTreeNode.getLeft((BiTreeNode) S.peek(), order));
				}
				S.pop();
				if (!S.isEmpty()) {
					T = (BiTreeNode) S.pop();
					//System.out.print(T.data);
					display = display + T.data;
					S.push(BiTreeNode.getRight(T, order));
				}
			}
		}
	}
	/*
	 * postRootTraverse: with Recursion
	*/
	public void postRootTraverse(BiTreeNode T, String order) {
		if (T != null) {
			postRootTraverse(BiTreeNode.getLeft(T, order), order);
			postRootTraverse(BiTreeNode.getRight(T, order), order);
			//System.out.print(T.data);
			display = display + T.data;
		}
	}
	/*
	 * postRootTraverse: with LinkStack
	*/
	public void postRootTraverse(String order) throws Exception{
		BiTreeNode T = root;
		if (T != null) {
			LinkStack S = new LinkStack();
			S.push(T);
			Boolean flag;
			BiTreeNode p =null;
			while (!S.isEmpty()) {
				while (S.peek() != null) {
					S.push(BiTreeNode.getLeft((BiTreeNode) S.peek(), order));
				}
				S.pop();
				while (!S.isEmpty()) {
					T = (BiTreeNode) S.peek();
					BiTreeNode right = BiTreeNode.getRight(T, order);
					if (right == null || right == p) {
						//System.out.print(T.data);
						display = display + T.data;
						S.pop();
						p = T;
						flag = true;
					}else {
						S.push(right);
						flag = false;
					}
					if (!flag) {
						break;
					}
				}
			}
		}
	}
	/*
	 * levelTraverse: with CircleSqQueue
	*/
	public void levelTraverse(String order) throws Exception{
		BiTreeNode T = root;
		if (T != null) {
			CircleSqQueue L = new CircleSqQueue(100);
			L.offer(T);
			// while (!L.isEmpty()) {
			while (T != null) {
				T = (BiTreeNode) L.poll();
				if (T != null) {
					//System.out.print(T.data);
					display = display + T.data;
					BiTreeNode left = BiTreeNode.getLeft(T, order);
					BiTreeNode right = BiTreeNode.getRight(T, order);
					if (left != null) {
						L.offer(left);
					}
					if (right != null) {
						L.offer(right);
					}
				}
			}
		}
	}
	
	public void cleandisplay() {
		display = "";
	}
	
	public String getdisplay() {
		return display;
	}
	
	public BiTreeNode getRoot() {
		return root;
	}
	
	public void setRoot(BiTreeNode root) {
		this.root = root;
	}
	
	public static boolean isEqual(BiTreeNode T1, BiTreeNode T2) {
		if (T1 == null && T2 == null) {
			return true;
		}
		if (T1 != null && T2 != null) {
			if (T1.data.equals(T2.data)) {
				if (isEqual(T1.lchild, T2.lchild)) {
					if (isEqual(T1.rchild, T2.rchild)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	public void resetIndex() {
		index = 0;
	}
	
	/*
	 * preTraverse to build the tree
	*/
	public BiTree(String preStr, String order) throws Exception{
		char c = preStr.charAt(index++);
		if (c != '#') {
			root = new BiTreeNode(c);
			//BiTreeNode.setLeft(root, child, order)
			BiTreeNode.setLeft(root, new BiTree(preStr, order).root, order);
			BiTreeNode.setRight(root, new BiTree(preStr, order).root, order);
		}else {
			root = null;
		}
	}
	
	/*
	 * preTraverse + inTraverse to build the tree
	*/
	public BiTree(String preOrder, String inOrder, int preIndex, int inIndex, int count, String order) {
		if (count > 0) {
			char r = preOrder.charAt(preIndex);
			int i = 0;
			for (; i < count; i++) {
				if (r == inOrder.charAt(i+inIndex)) {
					break;
				}
			}
			root = new BiTreeNode(r);
			BiTreeNode.setLeft(root, new BiTree(preOrder, inOrder, preIndex + 1, inIndex, i, order).root, order);
			BiTreeNode.setRight(root, new BiTree(preOrder, inOrder, preIndex + i + 1, inIndex + i + 1, count - i - 1, order).root, order);
		}
	}
	
	/*
	 * postTraverse + inTraverse to build the tree: Maybe there is a better way of doing this
	*/
	public BiTree(String postOrder, String inOrder, int postIndex, int inIndex, int count, boolean post, String order) {
		if (count > 0) {
			char r = postOrder.charAt(postIndex);
			int i = 0;
			for (; i < count; i++) {
				if (r == inOrder.charAt(inIndex - i)) {
					break;
				}
			}
			root = new BiTreeNode(r);
			BiTreeNode.setRight(root, new BiTree(postOrder, inOrder, postIndex - 1, inIndex, i, true, order).root, order);
			BiTreeNode.setLeft(root, new BiTree(postOrder, inOrder, postIndex - i - 1, inIndex - i - 1, count - i - 1, true, order).root, order);
		}
	}
	
	public static void main(String[] args) {
		String preStr = "AB##C##";
		String order = "LR";
		
		try{
			BiTree T = new BiTree(preStr, order);
			System.out.println("PreT");
			/*
			T.levelTraverse();
			System.out.println(display);
			T.cleandisplay();
			T.preRootTraverse();
			System.out.println(display);
			T.cleandisplay();
			*/
			T.inRootTraverse(order);
			System.out.println(display);
			T.cleandisplay();
			//T.postRootTraverse();
			//System.out.println(display);
			//T.cleandisplay();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}