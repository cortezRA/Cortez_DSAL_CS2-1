import java.util.Scanner;

public class PT3_Cortez {
    class Node {
        int key, count;
        Node leftST, rightST;
    
        public Node(int data) {
            key = data;
            leftST = rightST = null;
            count = 1;
        }
    }

    Node root;
    PT3_Cortez() {
        root = null;
    }

    void insert(int key) {
        root = insertNode(root, key);
    }

    // Insert key in the tree
    Node insertNode(Node root, int key) {
        // Return a new node if the tree is empty
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key == root.key) {
            System.out.print("\n" + key + " has a duplicate!");
            root.count++;
            System.out.println("\nCreated " + root.key + "(" + root.count + ")...");
            return root;
        }

        // Traverse to the right place and insert the node
        if (key < root.key) {
            root.leftST = insertNode(root.leftST, key);
        } else if (key > root.key) {
            root.rightST = insertNode(root.rightST, key);
        }
        
        return root;
    }

    void search(int key) {
        System.out.print("\n\nPath to node value " + key + " -> ");
        root = searchNode(root, key);
    }

    //Search a node value
    Node searchNode(Node root, int key) {
        //System.out.print("\n Visiting node value")

        // Base Cases: root is null or key is present at root
        if (root==null) {
            System.out.println("\n"+ key + " does not exist...");
            return root;
        } else if (root.key==key) {
            System.out.print(root.key + "(" + root.count + ")");
            System.out.println("\n"+ key + " has been found sucessfully!!!");
            return root;
        }

        System.out.print(root.key + "(" + root.count + ")");

        // Key is greater than root's key
        if (root.key < key) {
            System.out.print(" < ");
            root.rightST = searchNode(root.rightST, key);
        } else {
            System.out.print(" > ");
            root.leftST = searchNode(root.leftST, key);
        }

        return root;
    }


    //in-order traversal
    public void InOrder(Node node) {
        if(node != null) {
            InOrder(node.leftST);
            System.out.print(" " + node.key + "(" + node.count + ")");
            InOrder(node.rightST);
        }
    }

    //pre-order traversal
    public void PreOrder(Node node) {
        if(node != null) {
            System.out.print(" " + node.key + "(" + node.count + ")");
            PreOrder(node.leftST);
            PreOrder(node.rightST);
        }
    }

    //post-order traversal
    public void PostOrder(Node node) {
        if(node != null) {
            PostOrder(node.leftST);
            PostOrder(node.rightST);
            System.out.print(" " + node.key + "(" + node.count + ")");
        }
    }

    void delete(int key) {
        System.out.print("\n\nPath to node value " + key + " -> ");
        root = deleteNode(root, key);
    }
    
    Node deleteNode(Node root, int key) {
        // Return if the tree is empty
        if (root == null) {
            System.out.println("\n"+ key + " does not exist...");
            return root;
        }

        System.out.print(root.key + "(" + root.count + ")");
    
        // Find the node to be deleted
        if (key < root.key) {
            System.out.print(" > ");
            root.leftST = deleteNode(root.leftST, key);
        } else if (key > root.key) {
            System.out.print(" < ");
            root.rightST = deleteNode(root.rightST, key);
        } else {
            if (root.count > 1) {
                root.count--;
                System.out.println("\nA duplicate of " + key + " has been deleted successfully...");
                return root;
            }

            // If the node is with only one child or no child
            if (root.leftST == null) {
                System.out.println("\n" + key + " has been deleted successfully...");
                return root.rightST;
            }
            else if (root.rightST == null) {
                System.out.println("\n" + key + " has been deleted successfully...");
                return root.leftST;
            }
    
            // If the node has two children
            // Place the inorder successor in position of the node to be deleted
            root.key = minValue(root.rightST);
    
            // Delete the inorder successor
            root.rightST = deleteNode(root.rightST, root.key);
        }

        return root;
    }

    // Find the inorder successor
    int minValue(Node root) {
        int min = root.key;

        while (root.leftST != null) {
            min = root.leftST.key;
            root = root.leftST;
        }

    return min;
    }

    void mainMenu() {
        System.out.println("\n\n-- Welcome to Binary Tree Implementation --");
        System.out.println("\n[1] - Insert a Node");
        System.out.println("[2] - Search a Node");
        System.out.println("[3] - Delete a Node");
        System.out.println("[4] - Traverse all Nodes");
        System.out.println("[5] - Exit");
        System.out.print("\nWhat would you like to do? ");
    }
    
    void traverseTree() {
        System.out.println("\n\nWould you like to traverse the current binary tree?");
        System.out.println("\n[1] - In-Order Traversal");
        System.out.println("[2] - Pre-Order Traversal");
        System.out.println("[3] - Post-Order Traversal");
        System.out.println("[4] - Show All Methods");
        System.out.println("\n-- Press any number to exit --");
        System.out.print("\nWhat would you like to do? ");
    }

    public static void main(String[] args) {
        PT3_Cortez btree = new PT3_Cortez();
        Scanner in = new Scanner(System.in);
        int size;

        System.out.print("\nEnter initial number of nodes: ");
        size = in.nextInt();

        int addNode;
        for (int x = 0; x < size; x++) {
            System.out.print("\nEnter node value #" + (x+1) + ": ");
            addNode = in.nextInt();
            btree.insert(addNode);
        }

        System.out.print("\n");

        int operation;
        do {
            btree.mainMenu();
            operation = in.nextInt();

            if (operation == 1) {
                int value1 = 0;

                System.out.println("\n\n-- INSERT A NODE --");
                System.out.print("\nEnter number: ");
                value1 = in.nextInt();

                System.out.println("Inserting node value " + value1 + "...");
                btree.insert(value1);
                System.out.println("\n"+ value1 + " has been inserted sucessfully!!!");
                System.out.println("\n\n-- RETURNING TO MAIN MENU --");
            } else if (operation == 2) {
                int value2 = 0;

                System.out.println("\n\n-- SEARCH A NODE --");
                System.out.print("\nEnter number: ");
                value2 = in.nextInt();

                System.out.println("Searching node value " + value2 + "...");
                btree.search(value2);
                System.out.println("\n\n-- RETURNING TO MAIN MENU --");
            } else if (operation == 3) {
                int value3 = 0;

                System.out.println("\n\n-- DELETE A NODE --");
                System.out.print("\nEnter number: ");
                value3 = in.nextInt();

                System.out.println("Deleting node value " + value3 + "...");
                btree.delete(value3);
                System.out.println("\n\n-- RETURNING TO MAIN MENU --");
            } else if (operation == 4) {
                int method;
                btree.traverseTree();
                method = in.nextInt();

                if (method == 1) {
                    System.out.println("\nIn-Order Tree Traversal:");
                    btree.InOrder(btree.root);
                } else if (method == 2) {
                    System.out.println("\nPre-Order Tree Traversal:");
                    btree.PreOrder(btree.root);
                } else if (method == 3) {
                    System.out.println("\nPost-Order Tree Traversal:");
                    btree.PostOrder(btree.root);
                } else if (method == 4) {
                    System.out.println("\nIn-Order Tree Traversal:");
                    btree.InOrder(btree.root);
                    System.out.println("\nPre-Order Tree Traversal:");
                    btree.PreOrder(btree.root);
                    System.out.println("\nPost-Order Tree Traversal:");
                    btree.PostOrder(btree.root);
                } else {
                    return;
                }
                System.out.print("\n\n-- RETURNING TO MAIN MENU --");
            } else if (operation == 5) {
                System.out.print("\n\nProgram shutting down...");
            } else {
                System.out.println("\nYou have inputted a wrong value...");
                System.out.println("-- RETURNING TO MAIN MENU --\n");
            }
        } while (operation != 5);
    }
}
