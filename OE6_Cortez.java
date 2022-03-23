import java.util.Scanner;

class Node {
    int key;
    Node leftST, rightST;

    public Node(int data) {
        key = data;
        leftST = rightST = null;
    }
}

public class OE6_Cortez {
    Node root;

    //in-order traversal
    public void InOrder(Node node) {
        if(node != null) {
            InOrder(node.leftST);
            System.out.print(" " + node.key);
            InOrder(node.rightST);
        }
    }

    public void PreOrder(Node node) {
        if(node != null) {
            System.out.print(" " + node.key);
            PreOrder(node.leftST);
            PreOrder(node.rightST);
        }
    }

    public void PostOrder(Node node) {
        if(node != null) {
            PostOrder(node.leftST);
            PostOrder(node.rightST);
            System.out.print(" " + node.key);
        }
    }

    public static void main(String[] args) {
        //Instance of the tree
        OE6_Cortez myTree = new OE6_Cortez();

        //Create Nodes
        myTree.root = new Node(1);
        myTree.root.leftST = new Node(2);
        myTree.root.rightST = new Node(3);
        myTree.root.leftST.leftST = new Node(4);
        myTree.root.leftST.rightST = new Node(5);
        myTree.root.rightST.leftST = new Node(6);
        myTree.root.rightST.rightST = new Node(7);
        myTree.root.leftST.leftST.leftST = new Node(8);
        myTree.root.leftST.leftST.rightST = new Node(9);
        myTree.root.leftST.rightST.leftST = new Node(10);
        myTree.root.leftST.rightST.rightST = new Node(11);
        myTree.root.rightST.leftST.leftST = new Node(12);
        myTree.root.rightST.leftST.rightST = new Node(13);
        myTree.root.rightST.rightST.leftST = new Node(14);
        myTree.root.rightST.rightST.rightST = new Node(15);
        
        int operation = 0;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("\n-- Binary Tree Traversal Program--");
            System.out.println("\n Sample Binary Tree for Traversal:");
            System.out.println("                      /1\\");
            System.out.println("                       |");
            System.out.println("         /2\\ <-------------------> /3\\");
            System.out.println("          |                         |");
            System.out.println("   /4\\ <-----> /5\\          /6\\ <-------> /7\\");
            System.out.println("    |           |            |             |");
            System.out.println("/8 <-> 9\\  /10 <-> 11\\  /12 <-> 13\\   /14 <-> 15\\");
            System.out.println("\n[1] - In-Order Tree Traversal");
            System.out.println("[2] - Pre-Order Tree Traversal");
            System.out.println("[3] - Post-Order Tree Traversal");
            System.out.print("\nChoose tree traversal type to use: ");

            operation = in.nextInt();

            if (operation == 1) {
                System.out.println("\nIn-Order Tree Traversal:");
                myTree.InOrder(myTree.root);
                System.out.println("\n-- RETURNING TO MAIN MENU --");

            } else if (operation == 2) {
                System.out.println("\nPre-Order Tree Traversal:");
                myTree.PreOrder(myTree.root);
                System.out.println("\n-- RETURNING TO MAIN MENU --");

            } else if (operation == 3) {
                System.out.println("\nPost-Order Tree Traversal:");
                myTree.PostOrder(myTree.root);
                System.out.println("\n-- RETURNING TO MAIN MENU --");

            } else if (operation == 4) {
                return;
            
            } else {
                System.out.println("\nYou have inputted a wrong value...");
                System.out.println("-- RETURNING TO MAIN MENU --");

            }
            System.out.println();
        } while (operation != 4);
    }
}