import java.util.Scanner;
import java.util.Arrays;

public class Prelim_Cortez {
    static void Search(int[] in_array, int in_value) {

        int index = in_array.length;
        int counter = 0;

        System.out.println("Searching...");
        System.out.println();
        for(int x = 0; x < index; x++) {
            if (in_value == in_array[x]) {
                System.out.println("-- SEARCH SUCCESSFUL --");
                System.out.println("Array Element " + in_value + " was found in the position " + (x+1) + "...");
                System.out.println();
                System.out.println("-- RETURNING TO MAIN MENU --");
                counter++;
            }
        }

        if (counter == 0) {
            System.out.println("-- SEARCH UNSUCCESSFUL --");
            System.out.println("Array Element " + in_value + " was not found in the array...");
            System.out.println();
            System.out.println();
            System.out.println("-- RETURNING TO MAIN MENU --");
        }

        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        int exit = 0;
        Scanner in = new Scanner(System.in);

            System.out.println("Enter array size: ");

            int size = 0;
            size = in.nextInt();
            int array[] = new int[size];

            System.out.println();
            for (int x = 0; x < size; x++) {
                System.out.println("Please enter the array element: ");
                array[x] = in.nextInt(); 
            }

            System.out.println();
            System.out.println("-- YOU HAVE CREATED YOUR OWN ARRAY --");

        do {
            int operation;

            System.out.println("What would you like to do?");
            System.out.println();
            System.out.println("[1] - Search an Array Element");
            System.out.println("[2] - Insert an Array Element");
            System.out.println("[3] - Delete an Array Element");
            System.out.println("[4] - Exit");
            System.out.println();
            operation = in.nextInt();

            int value, location;
            if (operation == 1) {
                System.out.println("Enter Array Value: ");
                value = in.nextInt();
                Search(array, value);
            }
            else if (operation == 2) {
                System.out.println("Enter Value to be Inserted: ");
                value = in.nextInt();
                System.out.println();
                System.out.println("Enter Position for Insertion (from 1 to " + (size+1) + "): ");
                location = in.nextInt();
                
                int temp_array[] = array;
                array = new int[size+1];
        
                for (int num = 0; num < size; num++) {
                    array[num] = temp_array[num];
                }
                for (int num = size-1; num >= location-1; num--){
                    array[num+1] = array[num];
                }
        
                array[location-1] = value;
                size++;
        
                System.out.println("-- INSERTION SUCCESSFUL --");
                System.out.println("Array Element " + value + " has been inserted successfully...");
                System.out.println();
                System.out.println("Current Array Values: " + Arrays.toString(array));
            }
            else if (operation == 3) {
                System.out.println("Enter Value to be Deleted: ");
                value = in.nextInt();
                System.out.println();
                
                int temp_array[] = array;
                int savenum = 0, ctr = 0;

                for (int num = 0; num < size; num++) {
                    if (value == temp_array[num]) {
                        temp_array[num] = 0;
                        savenum = num;
                        ctr++;
                        break;
                    }
                }
                if (ctr > 0) {
                    array = new int[size-1];

                    for (int num = 0; num < savenum; num++) {
                        array[num] = temp_array[num];
                    }
                    for (int num = savenum; num < size-1; num++){
                        array[num] = temp_array[num+1];
                    }

                    size--;
                    System.out.println("-- DELETION SUCCESSFUL --");
                    System.out.println("Array Element " + value + " has been deleted successfully...");
                    System.out.println();
                    System.out.println("Current Array Values: " + Arrays.toString(array));
                    System.out.println("-- RETURNING TO MAIN MENU --");
                }
                else {
                    System.out.println("-- DELETION FAILED --");
                    System.out.println("Array Element " + value + " does not exist in the array");
                    System.out.println();
                    System.out.println("Current Array Values: " + Arrays.toString(array));
                    System.out.println("-- RETURNING TO MAIN MENU --");
                }
            }
            else if (operation == 4) {
                exit = 1;
            }
            else{
                System.out.println("You have inputted a wrong key");
                System.out.println("-- RETURNING TO MAIN MENU --");
            }
        } while (exit == 0);
    }
}
