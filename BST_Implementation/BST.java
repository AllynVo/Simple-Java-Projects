/*
Allyn Vo 
CS 302
Lab 1
 */
package bst;

import java.util.*;

/**
 *
 * @author allynvo
 */
public class BST<E> extends AbstractSet<E> {
    //Fields for Binary Search Tree Class
    private Entry<E> root;
    protected int size;
////////////////////////////////////////////////////////////////
// Method: Main *** RUNS PROGRAM ***
////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        
        
        BST bst = new BST();
        
        //Loop through the menu unless user wants to exit
        String userEntry;
        do{
            //New Scanner
            Scanner scanEntry = new Scanner(System.in);
            
            //Instructions
            System.out.println("==================== MENU ====================");
            System.out.println("  | # | What would you like to complete? ");
            System.out.println("  | 1 | Add an entry.");
            System.out.println("E | 2 | Delete an entry.");
            System.out.println("N | 3 | Iterate through the tree in pre-order.");
            System.out.println("T | 4 | Get the height of the tree.");
            System.out.println("E | 5 | Get the number of leaves.");
            System.out.println("R | 6 | To exit");
            System.out.println("  | 7 | Do a right rotation.");
            System.out.println("  | 8 | Do a left Rotation.");
            System.out.println("----------------------------------------------");
            
            //Get users entry for cases
            userEntry = scanEntry.next();
            
            //New Scanner, separete, for specific entry such as "ID's"
            Scanner input = new Scanner(System.in);
            String iD;
            
            //Switch Menu
            switch(userEntry){
                case "1":
                    System.out.print("Enter an ID number to add : ");
                    iD = input.next();
                    bst.add(iD);
                    System.out.println(iD + " added!");
                    break;
                
                case "2":
                    System.out.print("Enter an ID number to delete : ");
                    iD = input.next();
                    if(bst.delete(iD)) System.out.println(iD + " deleted!");
                    else System.out.println("ID not found.");
                    break;
                
                case "3":
                    System.out.print("\nID numbers in pre-order : " );
                    bst.printPreOrder();
                    System.out.println();
                    break;
                
                case "4":
                    System.out.println("Height of tree is : " + bst.height());
                    break;
                    
                case "5":
                    System.out.println("Number of leaves is : " + bst.leaves());
                    break;
                    
                case "6":
                    System.out.println("Thanks! Exited.\n -Allyn");
                    System.exit(0);
                    
                case "7":
                    System.out.println("What ID would you like to rotate to the right? : ");
                    iD = input.next();
                    bst.rotateRight(bst.findNode(iD));
                    System.out.println("Rotation done.");
                    break;
                    
                case "8":
                    System.out.println("What ID would you like to rotate to the left? : ");
                    iD = input.next();
                    bst.rotateLeft(bst.findNode(iD));
                    System.out.println("Rotation done.");
                    break;
                    
                default:
                    System.out.println("Invlaid option.");
                    break;

            }
        }while(!userEntry.equals("6"));
        
    }

////////////////////////////////////////////////////////////////
// Method: Display in pre order
////////////////////////////////////////////////////////////////
    public void display(Entry root) {
        if (root != null) {
            System.out.print(" " + root.element);
            display(root.left);
            //System.out.print(" " + root.element);
            //For in order^^^
            display(root.right);
        }
    }
    public void printPreOrder(){
        TreeIterator itr = new TreeIterator();
        do{
            System.out.print(itr.next() + " ");
        }while(itr.hasNext());
    }
    
////////////////////////////////////////////////////////////////
// Method: Add an Entry Object
////////////////////////////////////////////////////////////////
    public boolean add(E element) {
        //If no root yet
        if (root == null) {
            root = new Entry(element, null);
            size++;
            return true;
        }
        //Else find place to add new entry
        else {
            Entry<E> temp = root;
            int comp;
            //Do while root hasnt been placed yet
            while (true) {
                comp = ((Comparable) element).compareTo(temp.element);
                if (comp == 0) {
                    return false;//return false to Add method
                }
                if (comp < 0) {
                    if (temp.left != null) {
                        temp = temp.left;
                    } else {
                        temp.left = new Entry<E>(element, temp);
                        size++;
                        return true;//return true to  Add method
                    }//temp.left == null
                } else if (temp.right != null) {
                    temp = temp.right;
                } else {
                    temp.right = new Entry<E>(element, temp);
                    size++;
                    return true;//return true to Add method
                }//temp.right == null
            }
        }
    }

////////////////////////////////////////////////////////////////
// Method: Successor
////////////////////////////////////////////////////////////////
    protected Entry<E> getSuccessor(Entry<E> element) {
        Entry<E> successor = null,
                successorParent = null,
                current = element.right;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        //If successor has a right child.
        if (successor != element.right) {
            //If it does have a right child, add it to the left of successorParent.
            successorParent.left = successor.right;
            successor.right = element.right;
        }
        return successor;
    }

////////////////////////////////////////////////////////////////
// Method: Delete an Entry Object
////////////////////////////////////////////////////////////////
    public boolean delete(E toDelete) {
        Entry<E> parent = root;
        Entry<E> current = root;
        boolean isLeftChild = false;
        //loop through tree to find the entry to delete
        while (((Comparable) toDelete).compareTo(current.element) != 0) {
            parent = current;
            if (((Comparable) toDelete).compareTo(current.element) < 0) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }
        //if reached this point, that means node exists 
        //Four cases depending on if the entry has 0, 1(left or right), or 2 children
        //Case 1: if node to be deleted has no children 
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild == true) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } //Case 2 : if node to be deleted has only one child 
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } //Continuation of case 2
        else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } //Case 3 : if node has two children 
        else if (current.left != null && current.right != null) {

            //now we have found the minimum element in the right sub tree 
            Entry<E> successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

////////////////////////////////////////////////////////////////
// Method: Right Rotation
////////////////////////////////////////////////////////////////
    public void rotateRight(Entry<E> p) {
        /*
        p for parent, and l for left child of p(parent).
        */
        try{ //incase rotation cannot be done such as just one node.
            Entry<E> l = p.left;
            p.left = l.right;
            if (l.right != null) {
                l.right.parent = p;
            }
            l.parent = p.parent;
            if (p.parent == null) {
                root = l;
            } else if (p.parent.right == p) {
                p.parent.right = l;
            } else {
                p.parent.left = l;
            }
            l.right = p;
            p.parent = l;
        } catch (NullPointerException e) {
        }
    }

////////////////////////////////////////////////////////////////
// Method: Left Rotation
////////////////////////////////////////////////////////////////
    public void rotateLeft(Entry<E> p) {
        try { 
            /*
            p for parent, and r for right child of p(parent).
            Parent of its right child becomes the left child of its right child.
            That right childs left child becomes the first parents right child.
            */
            Entry<E> r = p.right;
            p.right = r.left;
            if (r.left != null) {
                r.left.parent = p;
            }
            r.parent = p.parent;
            if (p.parent == null) {
                root = r;
            } else if (p.parent.left == p) {
                p.parent.left = r;
            } else {
                p.parent.right = r;
            }
            r.left = p;
            p.parent = r;
        } catch (NullPointerException e) {
        }
    }

////////////////////////////////////////////////////////////////
// Method: Node Location, recursively
////////////////////////////////////////////////////////////////
    public Entry<E> findNode(String data) {
        return findNode(root, data);
    }

    private Entry<E> findNode(Entry<E> n, String data) {
        if (n == null) {
            return n; //nothing exists here
        } else if (((Comparable) data).compareTo(n.element) > 0){ //data should be on left if it exists
            return findNode(n.left, data);
        } else if (((Comparable) data).compareTo(n.element) < 0){ //data should be on right if it exists
            return findNode(n.right, data);
        } else {
            return n; //found it
        }
    }

////////////////////////////////////////////////////////////////
// Method: Leaves Counter, recursively
////////////////////////////////////////////////////////////////    
    public int leaves(){
        return leaves(root);
    }
    private int leaves(Entry<E> entry)
    {
       if(entry == null) 
           return 0;
       
       if(entry.left == null && entry.right == null) //when reached a leaf, add 1
           return 1;
       else
           return leaves(entry.left) + leaves(entry.right);//checks whole tree
    }

////////////////////////////////////////////////////////////////
// Method: Height Calculator, recursively
////////////////////////////////////////////////////////////////
    //Height = max of left or right subtrees - 1
    public int height(){
        return height(root);
    }
    private int height(Entry<E> entry){
        if(entry == null)
            return -1;
        else
            return 1 + Math.max(height(entry.left), height(entry.right));
    }
    
////////////////////////////////////////////////////////////////
// Class: Iterator
////////////////////////////////////////////////////////////////
    @Override
    public Iterator<E> iterator() {
        return new TreeIterator();
    }

    //pre order
    public class TreeIterator implements Iterator {

        Stack<Entry<E>> stak = new Stack<Entry<E>>();

        //Default contrsuctor 
        public TreeIterator() {
            if (root != null) {
                stak.push(root);
            }
        }

        //hasNext method
        public boolean hasNext() {
            return !stak.isEmpty();
            //if stack is empty, hasNext is false
        }

        public E next() {
            Entry<E> current = stak.peek(); //current is object at top of stack
            if (current.left != null) {
                stak.push(current.left);
            } else {
                Entry<E> entry = stak.pop();
                while (entry.right == null) {
                    if (stak.isEmpty()) {
                        return current.element;
                    }
                    entry = stak.pop();
                }
                stak.push(entry.right);
            }
            return current.element;
        }
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

////////////////////////////////////////////////////////////////
// Class: Entry, in other words, Node
////////////////////////////////////////////////////////////////
    protected static class Entry<E> {

        protected E element;
        int data;
        //     Parent
        //      / \
        //  Left   Right
        protected Entry<E> left = null,
                           right = null,
                           parent;

        //initializes this Entry object from element and parent.
        protected Entry(E element, Entry<E> parent) {
            this.element = element;
            this.parent = parent;
        }

    }

}
