//Allyn Vo
//CS 302
//ID: 36835977

package lab1;
import java.util.*;
import lab1.BinarySearchTree.TreeIterator;


public class Lab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int userEntry = -1;
        
        BinarySearchTree BST = new BinarySearchTree();
        
        
        //Loop through the menu unless user wants to exit
        do{
        
            Scanner scanEntry = new Scanner(System.in);
            System.out.println("\nWhat would you like to do?");
            System.out.println("Enter 1 if you would like to add an entry.");
            System.out.println("Enter 2 if you would like to delete an entry.");
            System.out.println("Enter 3 to iterate through the tree in pre-order.");
            System.out.println("Enter 4 to get the height of the tree.");
            System.out.println("Enter 5 to see how many leaves there are.");
            System.out.println("Enter 6 to exit\n");
            userEntry = scanEntry.nextInt();

            Scanner input = new Scanner(System.in);
            switch(userEntry){
                case 1:
                    System.out.println("Enter an ID number to add: ");
                    int iD = input.nextInt();
                    BST.add(iD);
                    System.out.println(iD + " Added!");
                    break;
                
                case 2:
                    System.out.println("Enter an ID number to delete: ");
                    iD = input.nextInt();
                    if(BST.delete(iD)) System.out.println(iD + " Deleted!");
                    else System.out.println("ID not found.");
                    break;
                
                case 3:
                    System.out.print("\nID numbers in pre-order: " );
                    BST.printPreOrder();
                    break;
                
                case 4:
                    System.out.println("Height of tree is " + BST.height());
                    break;
                    
                case 5:
                    System.out.println("Number of leaves are " + BST.Leaves());
                    break;
                    
                case 6:
                    System.out.println("Thanks! Exited.");
                    break;
                default:
                    System.out.println("Invlaid option.");

            }
        }while(userEntry != 6);
        
    }
    
}
