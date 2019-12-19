package lessons;

public class BSTree{
	public BiTreeNode root;
	
	public BSTree() {
		root = null;
	}
	
	/*
	 * can use BiTree.inRootTraverse
	public void inOrderTraverse(BiTreeNode p) {
		if (p != null) {
		}
	}
	*/
	
	public Object searchBST(Comparable key) {
		if (key == null || !(key instanceof Comparable)) {
			return null;
		}
		
		return searchBST(root, key);
	}
	
	public Object searchBST(BiTreeNode p, Comparable key) {
		if (p != null) {
			int result = key.compareTo(((RecordNode) p.data).key);
			if (result == 0) {
				return p.data;
			}else if (result < 0) {
				return searchBST(p.lchild, key);
			}else {
				return searchBST(p.rchild, key);
			}
		}
		return null;
	}
	
	public boolean insertBST(Comparable key, Object theElement) {
		if (key == null || !(key instanceof Comparable)) {
			return false;
		}else if (root == null) {
			root = new BiTreeNode(new RecordNode(key, theElement));
			return true;
		}else {
			return insertBST(root, key, theElement);
		}
		
	}
	
	public boolean insertBST(BiTreeNode p, Comparable key, Object theElement) {
		int result = key.compareTo(((RecordNode) p.data).key);
		if (result == 0){
			return false;
		}else if (result < 0) {
			if (p.lchild == null) {
				p.lchild = new BiTreeNode(new RecordNode(key, theElement));
				return true;
			}else {
				return insertBST(p.lchild, key, theElement);
			}
		}else if (p.rchild == null) {
			p.rchild = new BiTreeNode(new RecordNode(key, theElement));
			return true;
		}else {
			return insertBST(p.rchild, key, theElement);
		}
	}
	
	public static void main(String args[]) {
		BSTree bstree = new BSTree();
		int[] k = {50, 13, 63, 8, 36, 90, 5, 10, 18, 70};
        String[] item = {"Wang", "Li", "Zhang", "Liu", "Chen", "Yang", "Huang", "Zhao", "Wu", "Zhou"};
        KeyType[] key = new KeyType[k.length];
        ElementType[] elem = new ElementType[k.length];
        for (int i = 0; i < k.length; i++) {
            key[i] = new KeyType(k[i]);
            elem[i] = new ElementType(item[i]);
            if (bstree.insertBST(key[i], elem[i])) {
                System.out.print("[" + key[i] + "," + elem[i] + "]");
            }
        }
        System.out.println();
        KeyType keyvalue = new KeyType();
        keyvalue.key=63;
        RecordNode found = (RecordNode) bstree.searchBST(keyvalue);
        if (found != null) {
            System.out.println("查找关键码：" + keyvalue + ",成功！ 对应姓氏为:" + found.element);
        } else {
            System.out.println("查找关键码：" + keyvalue + ",失败!");
        }

        keyvalue.key=39;
        found = (RecordNode) bstree.searchBST(keyvalue);
        if (found != null) {
            System.out.println("查找关键码：" + keyvalue + ",成功！ 对应姓氏为:" + found.element);
        } else {
            System.out.println("查找关键码：" + keyvalue + ",失败!");
        }

        
	}
	
	
	
}