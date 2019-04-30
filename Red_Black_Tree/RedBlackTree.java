/*
 * Allyn Vo
 * CS 302
 * Date: 11-20-17
 * Assignment: Lab 5, Red-Black trees
 */
package redblacktree;

import java.util.Arrays;

/**
 *
 * @author allynvo
 *
 * Question 4 answer for Lab: 
 * Red-Black tree vs. AVL tree 
 * -AVL trees is more balanced than red-black trees 
 * -AVL causes more rotations while inserting and deleting 
 * -Red-Black trees preferred when doing more inserts and deletes 
 * -AVL trees preferred when inserts and deletes are less & searching happens 
 *  more frequently 
 * -Red-Black tree balances by checking coloring rules and path rule
 * -AVL tree balances by checking the height of tree (leaves)
 */

////////////////////////////////////////////////////////////////////////////////
// Class for Nodes of the tree
////////////////////////////////////////////////////////////////////////////////
class RedBlackNode {

    // fields
    RedBlackNode left, right; // right & left children
    int element; // element of type int
    int color; // color : red or black

    // constructor, sets left and right child to null
    public RedBlackNode(int ele) {
        this(ele, null, null);
    }

    // constructor, sets left and right child from inserted parameters
    public RedBlackNode(int ele, RedBlackNode l, RedBlackNode r) {
        left = l;
        right = r;
        element = ele;
        color = 1; // set default color to black
    }
}

////////////////////////////////////////////////////////////////////////////////
// Class for Red Black Tree
////////////////////////////////////////////////////////////////////////////////
class RBTree {

    // Node Fields
    private RedBlackNode current;
    private RedBlackNode parent;
    private RedBlackNode grand; //grandparent
    private RedBlackNode great; // great grandparent
    private RedBlackNode header;
    private static RedBlackNode nullNode;

    ////////////////////////////////////////////////////////////////////////////
    // Static initializer
    static {
        nullNode = new RedBlackNode(0);
        nullNode.left = nullNode;
        nullNode.right = nullNode;
    }
    
    /* 
    Black = 1
    Red   = 0
    */ 
    static final int BLACK = 1;
    static final int RED = 0;

    ////////////////////////////////////////////////////////////////////////////
    // Constructor 
    public RBTree(int negInf) {
        header = new RedBlackNode(negInf);
        header.left = nullNode;
        header.right = nullNode;
    }


    ////////////////////////////////////////////////////////////////////////////
    // Method to insert a new item
    public void insert(int item) {
        current = parent = grand = header;
        nullNode.element = item;
        while (current.element != item) {
            // set next fields
            great = grand;
            grand = parent;
            parent = current;
            
            /*
            If item < "current" element, current=current.left
            Otherwise, current=current.right
            */
            current = item < current.element ? current.left : current.right;
            
            // Check if theres two red children and fix if so            
            if (current.left.color == RED && current.right.color == RED) {
                handlesReorientation(item);
            }
        }
        // Insertionion fails if it's already present
        if (current != nullNode) {
            return;
        }
        current = new RedBlackNode(item, nullNode, nullNode);
        
        // Attaches to the parent
        if (item < parent.element) {
            parent.left = current;
        } else {
            parent.right = current;
        }
        handlesReorientation(item);
    }

    ////////////////////////////////////////////////////////////////////////////
    // Method to handle what to switch around
    private void handlesReorientation(int item) {
        // flips the color
        current.color = RED;
        current.left.color = BLACK;
        current.right.color = BLACK;

        // if parent color is red, then rotate
        if (parent.color == RED) {
            grand.color = RED;
            if (item < grand.element != item < parent.element) {
                parent = rotate(item, grand);  // Start dbl rotate
            }
            current = rotate(item, great);
            current.color = BLACK;
        }
        // Make the root black
        header.right.color = BLACK;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // Method to rotate
    private RedBlackNode rotate(int item, RedBlackNode parent) {
        if (item < parent.element) {
            // if compare, to know which to rotate and return
            return parent.left = item < parent.left.element 
                    ? rotateWithLeftChild(parent.left) : rotateWithRightChild(parent.left);
        } else {
            //if compare, to know which to rotate and return
            return parent.right = item < parent.right.element 
                    ? rotateWithLeftChild(parent.right) : rotateWithRightChild(parent.right);
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    // Method to rotate left
    private RedBlackNode rotateWithLeftChild(RedBlackNode k2) {
        RedBlackNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }

    ////////////////////////////////////////////////////////////////////////////
    // Method to rotate right
    private RedBlackNode rotateWithRightChild(RedBlackNode k1) {
        RedBlackNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }

    ////////////////////////////////////////////////////////////////////////////
    // Method to print tree in in-order
    public void inorder() {
        inorder(header.right);
    }

    private void inorder(RedBlackNode x) {
        if (x != nullNode) {
            inorder(x.left);
            char color = 'B';
            if (x.color == 0) {
                color = 'R';
            }
            // prints if B or R after number to show color
            System.out.print(x.element + "" + color + " ");
            inorder(x.right);
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    // Method to print tree in pre-order
    public void preorder() {
        preorder(header.right);
    }

    private void preorder(RedBlackNode x) {
        if (x != nullNode) {
            char color = 'B';
            if (x.color == 0) {
                color = 'R';
            }
            // prints if B or R after number to show color
            System.out.print(x.element + "" + color + " ");
            preorder(x.left);
            preorder(x.right);
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    // Method to print tree in post-order
    public void postorder() {
        postorder(header.right);
    }

    private void postorder(RedBlackNode x) {
        if (x != nullNode) {
            postorder(x.left);
            postorder(x.right);
            char color = 'B';
            if (x.color == 0) {
                color = 'R';
            }
            // prints if B or R after number to show color
            System.out.print(x.element + "" + color + " ");
        }
    }
}

////////////////////////////////////////////////////////////////////////////////
// Class for to run Red Black Tree class and input and output
////////////////////////////////////////////////////////////////////////////////
public class RedBlackTree {

    public static void main(String[] args) {
        ////////////////////////////////////////////////////////////////////////
        // new Red-Black Tree
        RBTree given = new RBTree(Integer.MIN_VALUE);
        System.out.print("Question 2 : Tree from given input");
        // given values into new array
        int arr1[] = {50,20,80,70,100,10,90,110};
        // insert all of array into tree
        for (int i : arr1) {
            given.insert(i);
        }
        // display different orders of tree
        System.out.print("\nPost-order : ");
        given.postorder();
        System.out.print("\nPre-order  : ");
        given.preorder();
        System.out.print("\nIn-order   : ");
        given.inorder();
        System.out.println("\n");
        
        ////////////////////////////////////////////////////////////////////////
        // new Red-Black Tree
        RBTree notAVL = new RBTree(Integer.MIN_VALUE);
        System.out.print("Question 5 : Red-Black Tree that's not AVL Tree");
        // given values into new array
        int arr2[] = {60, 70, 40, 50, 45, 20};
        // insert all of array into tree
        for (int i : arr2) {
            notAVL.insert(i);
        }
        // display different orders of tree
        System.out.print("\nPost-order : ");
        notAVL.postorder();
        System.out.print("\nPre-order  : ");
        notAVL.preorder();
        System.out.print("\nIn-order   : ");
        notAVL.inorder();
        System.out.println("\n");
        
        ////////////////////////////////////////////////////////////////////////
        // new Red-Black Tree
        RBTree rbt1 = new RBTree(Integer.MIN_VALUE);
        System.out.print("Question 6 : same six elements, diff tree 1");
        // given values into new array
        int arr3[] = {0, 1, 2, 3, 4, 5};
        // insert all of array into tree
        for (int i : arr3) {
            rbt1.insert(i);
        }
        // display different orders of tree
        System.out.print("\nPost-order : ");
        rbt1.postorder();
        System.out.print("\nPre-order  : ");
        rbt1.preorder();
        System.out.print("\nIn-order   : ");
        rbt1.inorder();
        System.out.println("\n");
        
        ////////////////////////////////////////////////////////////////////////
        // new Red-Black Tree
        RBTree rbt2 = new RBTree(Integer.MIN_VALUE);
        System.out.print("Question 6 : same six elements, diff tree 2");
        // given values into new array
        int arr4[] = {5, 4, 3, 2, 1, 0};
        // insert all of array into tree
        for (int i : arr4) {
            rbt2.insert(i);
        }
        // display different orders of tree
        System.out.print("\nPost-order : ");
        rbt2.postorder();
        System.out.print("\nPre-order  : ");
        rbt2.preorder();
        System.out.print("\nIn-order   : ");
        rbt2.inorder();
        System.out.println("\n");

    }
}
