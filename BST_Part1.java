package project1;

class BST_Part1 {

	public static void main(String args[]) {
		 Tree tr;
		 tr = new Tree(100);
		 tr.insert(50);
		 tr.insert(125);
		 tr.insert(150);
		 tr.insert(20);
		 tr.insert(75);
		 tr.insert(20);	
		 tr.insert(90);
		 tr.delete(20);
		 tr.delete(20);
		 tr.delete(125);
		 tr.delete(150);
		 tr.delete(100);
		 tr.delete(50);
		 tr.delete(75);
		 tr.delete(25);
		 tr.delete(90);
	}
}

class Tree { // Defines one node of a binary search tree
	
		 
				
				protected int value;
				protected Tree left;
				protected Tree right;
				
				
				public int getValue() {
					return value;
				}

				public void setValue(int value) {
					this.value = value;
				}

				public Tree getLeft() {
					return left;
				}

				public void setLeft(Tree left) {
					this.left = left;
				}

				public Tree getRight() {
					return right;
				}

				public void setRight(Tree right) {
					this.right = right;
				}

				public Tree getParent() {
					return parent;
				}

				public void setParent(Tree parent) {
					this.parent = parent;
				}
				protected Tree parent;
				
				public Tree(int n) {
					value = n;
					left = null;
					right = null;
				}
				
				public void insert(int n) {
					if (value == n)
						return;
					if (value < n)
					{
						if (right == null)
						{
							
							right = new Tree(n);
							right.parent = this;
							
						}
						else {
							
							right.insert(n);
							//parent = this.right;
							}
					}
					else if (left == null)
						
						{
						left = new Tree(n);
						left.parent  = this;
					    }
					else{//parent = this.left;
						left.insert(n);}
					
					
					
				}
				
				
			      
			      
			      public Tree find(int n)
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
			      
			      public Tree max()
			      
			      {
			    	  Tree temp=null;
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

			      
			     public Tree min() 
			     {
			    	 if(left == null)
			    	 {
			    		 return this;
			    	 }
			    		 int val=0;
			    		 if(left!=null)
			    		 {
			    			 Tree temp = left.min();
			    			 val = temp.getValue();
			    		 }
			    		 return this;
			     }

			    	 
			     
				public void delete(int n) {  
////					//
////					// *** do not modify this method ***
////					//
				
				
				Tree t = find(n);
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
					
						private void case1(Tree t) {
							
							
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
							
								return;
						}
//							
							private void case2(Tree t) {  
							// remove internal node t;
							// you should write the code
						
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
							
							

							
							
							
								
							
							
							private void case3L(Tree t) {   
							
								Tree temp =t.left.max();
								
								
								t.value = t.left.max().value;
								t.left.max().parent.right=null;
								temp.parent=null;
								
								
								
								
								
								
							}

							private void case3R(Tree t) {   
							// replace t.value with the smallest value, v, in
							// t's right subtree; then delete value v from tree;
							// you should write the code
								
								
								Tree temp =t.right.min();
								t.value = t.right.min().value;
								t.right.min().parent.right=null;
								temp.parent=null;
								//temp.value = t.left.max().value;
								//delete(t.right.min().value);
								
								
								
								
								
							
						 	}



}
			      
			      


			  	









	


