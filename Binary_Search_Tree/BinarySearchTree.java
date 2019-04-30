//Allyn Vo
//CS 302
//ID: 36835977


package lab1;
import java.util.*;


public class BinarySearchTree {
    public static ObjectNode root;
    
    /// DEFAULT CONSTRUCTOR \\\
    public BinarySearchTree(){
        this.root = null;
    }
    
    /* /// ROTATE RIGHT & LEFT METHOD \\\
    -leftChild placeholder
    -leftChilds right child becomes the roots new left child
    -leftChilds new right child is the root
    */
    
    //Rotate RIGHT
    public void rotateRight(ObjectNode root){       
        ObjectNode leftChild = root.left;
        root.left = leftChild.right;
        leftChild.right = root; 
    }
    
    //Rotate LEFT
    public void rotateLeft(ObjectNode parent){
        ObjectNode leftChild = root.right;
        root.right = leftChild.left;
        leftChild.right = root;  
    }
    
    /* /// ADD METHOD \\\
    -Adds depending if the ID is less than or greater than the nodes
    -Once found a new null position, adds it there
    */
    public void add(int id){
        ObjectNode newEntry = new ObjectNode(id);
        //if no root yet, make new root
        if (root == null){
            root = newEntry;
            return;
        }
        //if root is already established, find where to add new 
        ObjectNode current = root; 
        ObjectNode parent = null;
        while (true){
            parent = current;
            if (id < current.data){
                current = current.left;
                if (current == null){
                    parent.left = newEntry;
                    return;
                }
            }else{
                current = current.right;
                if (current == null){
                    parent.right = newEntry;
                    return;
                }
            }
        }
    }
    
    /* /// DELETE METHOD \\\
    -Search through tree depending on if target ID is less than, or more than.
    */
    public boolean delete(int id){
        ObjectNode parent = root;
        ObjectNode current = root;
        boolean itIsLeftChild = false;
        
        while (current.data != id){
            parent = current;
            if (current.data > id){
                itIsLeftChild = true;
                current = current.left;
            }else{
                itIsLeftChild = false;
                current = current.right;
            }
            if (current == null){
                return false;
            }
        }   
    //If reached this point, the node searching for has been found
        //1st case: if node to be deleted has no children
        if(current.left == null && current.right == null){
            if (current == root){
                root = null;
            }
            if (itIsLeftChild == true){
                parent.left = null;
            }else{
                parent.right = null;
            }
        }
        //2nd case: if node to be deleted has only one child 
        else if (current.right == null){ //if it doesnt have a right child
                if (current == root){ 
                        root = current.left; 
                }else if (itIsLeftChild){ 
                        parent.left = current.left; 
                }else{ 
                        parent.right = current.left; 
                } 
        } 
        else if (current.left == null){ //if it doesnt have a left child
                if (current == root){ 
                        root = current.right; 
                }else if (itIsLeftChild){ 
                        parent.left = current.right; 
                }else{ 
                        parent.right = current.right; 
                } 
        //3rd case: if node to be deleted has two children
        }else if (current.left != null && current.right != null){ 
                //now we have to find the minimum element in the right sub tree
                //^left most element in right sub tree^
                ObjectNode successor = getSuccessor(current); 
                if (current == root){ 
                        root = successor; 
                }else if (itIsLeftChild){ 
                        parent.left = successor; 
                }else{ 
                        parent.right = successor; 
                }successor.left = current.left; 
        }return true;
    }
    
    /* /// GET SUCCESSOR \\\
    -Method to find and return a successor
    -Left most child in the right subtree of that node
    */
    public ObjectNode getSuccessor(ObjectNode deleteNode){ 
 		ObjectNode successor = null; 
 		ObjectNode successorParent = null; 
 		ObjectNode current = deleteNode.right; 
                
 		while(current != null){ 
 			successorParent = successor; 
 			successor = current; 
 			current = current.left; 
 		} 
 		//check if the successor has the right child, ifor sure it cannot have a left child 
 		//if it does have the right child, add it(Point it) to the left of the successors Parent. 
 		if(successor != deleteNode.right){ 
 			successorParent.left = successor.right; 
 			successor.right = deleteNode.right; 
 		} 
 		return successor; 
 	}
    
    /* /// COUNT LEAVES \\\
    -Count leaves starting from the root recursively
    -if the entry is empty(null), return 0
    -if the entry has no children(leaf), return 1
    -call out the method again with the right & left subtrees
    -returns the sum of leaves from each sub tree
    */
    public int Leaves(){
        return Leaves(root);
    }
    private int Leaves(ObjectNode entry)
    {
       if(entry == null) 
           return 0;
       
       if(entry.left == null && entry.right == null) 
           return 1;
       else
           return Leaves(entry.left) + Leaves(entry.right);
    }
    
    /* /// HEIGHT OF TREE \\\
    -if entry is empty return -1 (b/c the height counts the connections)
    -or else recursively go through the left and right subtree to find the hight
    -recursion: if the next entry (max of left or right) is present, add 1
    */
    public int height(){
        return height(root);
    }
    private int height(ObjectNode entry){
        if(entry == null)
            return -1;
        else
            return 1 + Math.max(height(entry.left), height(entry.right));
    }
    
    /*
    Method to print out each iteration in pre-order.
    */
    public void printPreOrder(){
        TreeIterator itr = new TreeIterator();
        do{
            System.out.print(itr.next() + " ");
        }while(itr.hasNext());
        System.out.println();
    }
    
    /*/// ITERATOR CLASS \\\
    -create stack of node objects
    -Default Contructor: if the root is not empty push it onto the stack
    -iterates in pre order (Root>left>right)
    */
    public Iterator<Integer> iterator(){
        return new TreeIterator();
    }
    public class TreeIterator implements Iterator<Integer>{
        Stack<ObjectNode> stak = new Stack<ObjectNode>();
        
        //Default contrsuctor 
        public TreeIterator(){
            if(root != null){ 
                stak.push(root);
            }
        }
        
        //hasNext method
        public boolean hasNext(){
            return !stak.isEmpty();
            //if stack is empty, hasNext is false
        }
        
        public Integer next(){
            ObjectNode current = stak.peek(); //current is object at top of stack
            if(current.left != null){
                stak.push(current.left);
            }else{
                ObjectNode entry = stak.pop();
                while(entry.right == null){
                    if(stak.isEmpty()){
                        return current.data;
                    }
                    entry = stak.pop();
                }
                stak.push(entry.right);
            }
            return current.data;
        }//next method
    }//TreeIterator class 
}