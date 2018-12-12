

public class BSTree0 implements iBSTree
{
	Node root;
	
	class Node{
		int val;
		Node left;
		Node right;
		int height;
		
		public Node(int val) {
			this.val = val;
			height = 1;
		}
}

	public void init(int[] ini) {
		if (ini==null) ini=new int[0];
		  for (int i: ini) {
		   add(i);
		  }		  
		 }

	public void clear() {
		root = null;		
	}

	public void add(int val) {
		root = addNode(root, val);		
	}

	private Node addNode(Node p, int val) {
		if (p == null) {
		return new Node(val);
		}
		if (val < p.val) {			
			p.left = addNode (p.left, val);
		}

		if (val > p.val) {			
			p.right = addNode (p.right, val);			
		}
		return balance(p);			
	}		
	

	public int size() {		
		return sizeNode(root);
	}

	private int sizeNode(Node p) {
		if (p==null) return 0;
		int count = 0;
		count+=sizeNode(p.left);
		count++;
		count+=sizeNode(p.right);
		return count;
	}
	
	public int leaves() {
		return leavesNode(root, new Counter());
	}

	private int leavesNode(Node p, Counter i) {
		if (p==null) return 0;		
		leavesNode(p.left, i);
		if (p.left==null&p.right==null) i.index++;
		leavesNode(p.right, i);
		return i.index;
	}

	public int nodes() {
		return nodesNode(root, new Counter());
		}

	private int nodesNode(Node p, Counter i) {
		if (p==null) return 0;		
		nodesNode(p.left, i);
		if ((p.left!=null|p.right!=null)) i.index++;
		nodesNode(p.right, i);
		return i.index;
	}

	public int height() {	
		 return heightNode(root);
	}
	private int heightNode(Node p) {
		{
			if (p == null)
				return 0;
			else
				return (1 + Math.max(heightNode(p.left), heightNode(p.right)));
		}
	}
	
	public int width()
	{
		int [] ar = new int [height()];
		widthNode(root, ar, 0);
		return (arMax(ar));
	}

	private void widthNode(Node p, int[] ar, int index) {
		if (p==null) return;
		widthNode (p.left, ar, index++);
		ar[index]++;
		widthNode (p.right, ar, index++);		
	}
	public int arMax(int [] ar){
		int max = ar[0];
		for (int i = 0; i < ar.length; i++) max = Math.max(max, ar[i]);
		return max;
	}

	public void reverse() {
		reverseNode(root);
	}

	private void reverseNode(Node p) {
		if (p == null) return;
		reverseNode(p.left);
		reverseNode(p.right);
		if (p != null) {
			Node tmp = p.left;
			p.left = p.right;
			p.right = tmp;
		}
		return;
	}

	public void del(int val) {
	root =	delNode(val, root);		
	}
	private Node delNode(int val, Node p) {		
		if (p==null) throw new IllegalArgumentException();
		if (val<p.val) {
			p.left=delNode(val, p.left);
		}
		else if (val>p.val) {
			p.right = delNode (val, p.right);
		}
		else {
			Node tmp;
			if (p.left==null&&p.right==null) {
				tmp=null;
			}
			else if (p.left==null) {
				tmp = p.right;
			}
			else if (p.right==null) {
				tmp = p.left;
			}
			else {
				tmp = searchNode(p.left);
				p.left = delNode(tmp.val, p.left);
				tmp.left = p.left;
				tmp.right = p.right;
			}
			return tmp;
		}
		return balance(p);
	}

	private Node searchNode(Node p) {
		while (p.right!=null) {
			p=p.right;
		}
		return p;
	}

	private Node searchByVal(Node p) {		
		return (searchNodeByVal(root, p.val));		
	}
	private Node searchNodeByVal(Node p, int val) {
	if (p==null) {
		return p;
	}
	else {
		if (val==p.val) return p;
		else {
			if (val<p.val) return (searchNodeByVal(p.left, val));
			else return (searchNodeByVal(p.right, val));
		}
	}
}

	public int[] toArray() {
		int [] ar = new int [size()];
		toNodeArray(root, ar, new Counter());
		return ar;
	}
	
	class Counter{
		int index = 0;
	}

	private void toNodeArray(Node p, int[] ar, Counter i) {
	if (p==null) return;		
	toNodeArray(p.left, ar, i);
	ar[i.index++] = p.val;	
	toNodeArray (p.right, ar, i);	
	}
	
	public String toString() {
		String strRet="";		
		return nodesTostring(root, strRet).trim();		
	}
	private String nodesTostring(Node p, String strRet) {
		if (p==null) return strRet;		
		strRet= nodesTostring(p.left, strRet);
		strRet+=p.val+" ";
		strRet=	nodesTostring(p.right, strRet);
		return strRet;
	}
	
	public boolean compareTrees(BSTree0 lst2BSTree0) {
		return compareTreesNodes(root, lst2BSTree0.root);
	}	
	private boolean compareTreesNodes(Node p1, Node p2) {		
		if (p1==null&p2==null) return true;
		else if (p1!=null & p2!=null) {
			return(
(p1.val == p2.val)&compareTreesNodes(p1.left, p2.left)&compareTreesNodes(p1.right, p2.right)
				  );		
		}
		else return false;
	}

	private int getHeight (Node p) {
		int h = 0;
		if (p!=null) {
			h = p.height;
		}
		return h;
	}
	
	private int getBalanceFactor (Node p) {
		int bf = getHeight (p.right) - getHeight(p.left);
		return bf;
	}
	
	private void setHeight (Node p) {
		if (p!=null)
		p.height = 1+ Math.max(getHeight(p.right), getHeight(p.left));
	}
	
	private Node rotateRight(Node p) {
		Node tmp = p.left;
		p.left = tmp.right;
		tmp.right = p;
		setHeight (p);
		setHeight (tmp);
		return tmp;
	}
	
	private Node rotateLeft(Node p) {
		Node tmp = p.right;
		p.right = tmp.left;
		tmp.left = p;
		setHeight (p);
		setHeight (tmp);
		return tmp;
	}
	
	private Node balance (Node p) {
		setHeight (p);
		int bf = getBalanceFactor (p);
		if (bf == 2) {
			if (getBalanceFactor(p.right)<0) {
				p.right = rotateRight (p.right);
			}
			return rotateLeft (p);
		}
		if (bf == -2) {
			if (getBalanceFactor(p.left)>0) {
				p.left = rotateLeft (p.left);
			}
			return rotateRight(p);
		}
		return p;
	}
}

