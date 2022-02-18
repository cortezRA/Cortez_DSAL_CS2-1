import java.util.Scanner;

public class OE3_Cortez {

    class Node {
        int data;
        Node next;
        Node previous;

        //constructor-defined method
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    //represent the head and the tail
    public Node head = null;
    public Node tail = null;

    //method to add node in LinkedList
    public void addNode(int data) {
        //ability to create node using instance of node
        Node newNode = new Node(data);

        //Checker - when list is empty
        if(head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            //new node becomes tail
            tail.next = newNode;
            tail = newNode;
        }
    }

    //method to remove node in LinkedList
    public void removeNode(int position) {
        Node currentNode = this.head;
        Node previousNode = this.head;
        if(this.head == null) {
            System.out.print("Linked list is empty!");
            return;
        }
        else if(position-1 == 0) {
            this.head = head.next;
        }
        else {
            while(position-1 != 0) {
                previousNode = currentNode;
                currentNode = currentNode.next;
                position--;
            }
            previousNode.next = currentNode.next;
            currentNode = null;
        }
    }

    //method to display LinkedList nodes
    public void printNode() {
        Node  currentNode = head;
        if(head == null) {
            System.out.println("Linked list is empty!");
            return;
        }

        System.out.println("Nodes of the Linked List...");
        while (currentNode != null) {
            System.out.print("[" + currentNode.data + "]");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        OE3_Cortez myList = new OE3_Cortez();

        int size;
        String operation;
        int value = 0;
        int position = 0;
        int exit = 0;
        Scanner in = new Scanner(System.in);

        System.out.println("Creating Initial LinkedList...\n\n");
        System.out.println("Please enter size of linkedlist: ");
        size = in.nextInt();

        for(int num = 0; num < size; num++) {
            System.out.println("Please enter the ");

            if(num+1 == 1) {
                System.out.print((num+1) + "st integer value of the LinkedList: ");
            }
            else if(num+1 == 2) {
                System.out.print((num+1) + "nd integer value of the LinkedList: ");
            }
            else if(num+1 == 3) {
                System.out.print((num+1) + "rd integer value of the LinkedList: ");
            }
            else {
                System.out.print((num+1) + "th integer value of the LinkedList: ");
            }
            value = in.nextInt();
            myList.addNode(value);
        }

        do {
            System.out.println();
            System.out.println("-- Welcome to the LinkedList Editing Program --\n");
            System.out.println("[1] - Add a Node");
            System.out.println("[2] - Remove a Node");
            System.out.println("[3] - Exit Program\n");
            myList.printNode();
            System.out.println("\n\nWhat would you like to do? ");
            operation = in.next();

            if(operation == "1") {
                System.out.println("Enter integer value to be added on LinkedList: ");
                value = in.nextInt();
                myList.addNode(value);
                size++;
            }
            else if(operation == "2") {
                System.out.println("Enter position of the value to be removed on LinkedList (1 to " + size + "): ");
                position = in.nextInt();

                if (position >= 1 || position <= size) {
                    myList.removeNode(position);
                    size--;
                }
                else {
                    System.out.println("You have inputted a wrong value...");
                    System.out.println("-- RETURNING TO MAIN MENU --");
                }
            }
            else if(operation == "3") {
                System.out.println("Exit the program? ");
                System.out.println("\n[1] - Yes");
                System.out.println("[2] - No\n");
                exit = in.nextInt();
            }
            else {
                System.out.println("You have inputted a wrong value...");
                System.out.println("-- RETURNING TO MAIN MENU --");
            }
        } while(exit != 1);
    }
}