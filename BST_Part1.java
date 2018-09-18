
  class BST_Part2 {

	  public static void main(String[] args) {
		AbsTree tr = new DupTree(100);
		tr.insert(50);
		tr.insert(125);
		tr.insert(150);
		tr.insert(20);
		tr.insert(75);
		tr.insert(20);
		tr.insert(90);
		tr.insert(50);
		tr.insert(125);
		tr.insert(150);
		tr.insert(75);
		tr.insert(90);
		
		tr.delete(20);
		tr.delete(20);
		tr.delete(20);
		tr.delete(150);
		tr.delete(100);
		tr.delete(150);
		tr.delete(125);
		tr.delete(125);
		tr.delete(50);
		tr.delete(50);
		tr.delete(50);
		tr.delete(75);
		tr.delete(90);
		tr.delete(75);
		tr.delete(90);
		}
  }
  
  abstract class AbsTree {
	  
	  
	 

	public AbsTree(int n) {
		value = n;
		left = null;
		right = null;
		
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	
	public void insert(int n) {
		if (value == n)
			count_duplicates();
		else if (value < n)
			if (right == null) {
				
				right = add_node(n);
				right.parent=this;}
			else
				right.insert(n);
		else if (left == null) {
			
		
			left = add_node(n);
			left.parent = this;}
		else
			left.insert(n);
	}
	
	public void delete(int n) {  		
	// adapt Part 1 solution and use here
		
		AbsTree t = find(n);
			if (t == null) { // n is not in the tree
			System.out.println("Unable to delete " + n + " -- not in the tree!");
				return;
		} else if (t.left == null && t.right == null) { // n is at a leaf position
			if (t != this) // if t is not the root of the tree
				case1(t);
				else
				System.out.println("Unable to delete " + n + " -- tree will become empty!");
				return;
			} else if (t.left == null || t.right == null) {
				// t has one subtree only
				if (t != this) { // if t is not the root of the tree
				case2(t);
					return;
				} else { // t is the root of the tree with one subtree
					if (t.left != null)
						case3L(t);
					else
						case3R(t);
					return;
				}
			} else 
				// t has two subtrees; replace n with the smallest value in t's right subtree
				case3R(t);
		}
	
	
	protected void case1(AbsTree t) {  
		DupTree d;
			if(t instanceof DupTree)
			{
				d = (DupTree) t;
				if(d.count>1) {	
					d.count=d.count-1;
				}
				else if(d.count == 1) {
					deletForcase1(t);
				}
			}else {
				deletForcase1(t); 
			}
	}
	
	private void deletForcase1(AbsTree t) {  

			if(t.parent.value>t.value)
				//|| t.parent.right!=null)
			{
				t.parent.left=null;
				t.parent=null;
			}
			else
			{
				t.parent.right=null;
				t.parent=null;
			}
	}
	// adapt Part 1 solution and use here
	
	
	protected void case2(AbsTree t) { 
	// adapt Part 1 solution and use here
		DupTree d;
		if(t instanceof DupTree)
		{
			d = (DupTree) t;
			if(d.count>1) {	
				d.count=d.count-1;
			}
			else if(d.count == 1) {
				deletForcase2(t);
			}
		}else {
			deletForcase2(t); 
		}
}

private void deletForcase2(AbsTree t) {  
		
			 
		if(t.parent.value<t.value)
		{
		
		t.parent.right=t.right;
		t.right.parent=t.parent;
		t.right=null;
		t.parent=null;
		
		}
		else
		{
			t.parent.left=t.right;
			t.right.parent=t.parent;
			t.right=null;
			
			t.parent=null;
		}
		}
		
		
	
	
	protected void case3L(AbsTree t) { 
		
		
	// adapt Part 1 solution and use here
		DupTree d;
		if(t instanceof DupTree)
		{
			d = (DupTree) t;
			if(d.count>1) {	
				d.count=d.count-1;
			}
			else if(d.count == 1) {
				deletForcase3L(t);
			}
		}else {
			deletForcase3L(t); 
		}
}

private void deletForcase3L(AbsTree t) { 
		if( t instanceof DupTree)
		{
		DupTree d = (DupTree) t;
		AbsTree temp =t.left.max();
		
		
		t.value = t.left.max().value;
		t.left.max().parent.right=null;
		temp.left=null;
		temp.parent=null;
		
		d.count=t.left.retrievecount();
		
		
		//temp.value = t.left.max().value;
		//delete(t.left.max().value);
		}
		else
		{
			AbsTree temp =t.left.max();
			
			
			t.value = t.left.max().value;
			t.left.max().parent.right=null;
			temp.left=null;
			temp.parent=null;
		}
		
		
	}

	protected void case3R(AbsTree t) {  
	// adapt Part 1 solution and use here
		DupTree d;
		if(t instanceof DupTree)
		{
			d = (DupTree) t;
			if(d.count>1) {	
				d.count=d.count-1;
			}
			else if(d.count == 1) {
				deletForcase3R(t);
			}
		}else {
			deletForcase3R(t); 
		}
}
	private void deletForcase3R(AbsTree t) { 
		
		if( t instanceof DupTree)
		{
			//d.count=t.right.retrievecount();
			DupTree d = (DupTree) t;
			
			AbsTree temp =t.right.min();
			
			
			t.value = temp.value;
			temp.parent.right=temp.right;
			temp.right.parent=t;
			//DupTree d1 = (DupTree) t;
			//d(t.right(d.getCount());
			temp.right=null;
			temp.parent=null;
			
			
				
				d.count=t.left.retrievecount();
			
			
			
			//temp.value = t.left.max().value;
			//delete(t.left.max().value);
			
		}
		else{
AbsTree temp =t.right.min();
			
			
			t.value = temp.value;
			temp.parent.right=null;
			//temp.right.parent=t;
				//DupTree d1 = (DupTree) t;
				//d(t.right(d.getCount());
				temp.right=null;
				temp.parent=null;
			}
		
	}
		
	
	public AbsTree min() {
		if(left == null)
   	 {
   		 return this;
   	 }
   		 int val=0;
   		 if(left!=null)
   		 {
   			 AbsTree temp = left.min();
   			 val = temp.getValue();
   		 }
   		 return this;
    }

//	// adapt Part 1 solution and use here
//	}
//
	public AbsTree max() {
//	// adapt Part 1 solution and use here
	  
    {
  	  AbsTree temp=null;
  	  if(right==null)
  		  return this;
  	  int val=0;
  	  if(right!= null)
  	  {
  	  
  		  temp =right.max();
  		  val = temp.getValue();
  	  }
  	  	return temp;
  	  
    }
    }
//	}
	protected AbsTree find(int n)
    {
    //Tree obj= new Value;
    {
  	  if (n == value)
  	  {
  		  
            return this;
  	  }

      else if (n < value) {

            if (left == null)

                  return null ;

            else

                  return left.find(n);

      } else if (n > value) {

            if (right == null)

                  return null ;

            else

                  return right.find(n);

      }

  	 return new Tree(n);

    }
}
	protected int value;
	protected AbsTree left;
	protected AbsTree right;
	protected AbsTree parent;
	

	// Protected Abstract Methods
	
	protected abstract AbsTree add_node(int n);
	protected abstract void count_duplicates();
	//protected abstract Abstree find(int n);
	protected abstract int retrievecount();

	// Additional protected abstract methods, as needed
}


class Tree extends AbsTree {

	public Tree(int n) {
		super(n);
	}

	protected AbsTree add_node(int n) {
		
		return new Tree(n);
	}

	protected void count_duplicates() {
		int count=0;
		
			count = count+1;
		;
	}
	

	// define additional protected methods here, as needed
protected int retrievecount()
{
	return 1;
}
}

class DupTree extends AbsTree {

	public DupTree(int n) {
		super(n);
		count = 1;
	};

	protected AbsTree add_node(int n) {
		
		
		return new DupTree(n);
	}

	protected void count_duplicates() {
		count++;
	}

	// define additional protected methods here, as needed

	protected int count;

	protected  int retrievecount()
	{
		return count;
	}
}
