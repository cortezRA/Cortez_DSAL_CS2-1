import java.util.Scanner;
import java.util.Arrays;

public class OE1_Cortez {
    public static void main(String[] args) {
        
        int current_size = 0;
        int current_array[] = new int[current_size];
        int done = 0;
        do {
            
            Scanner in = new Scanner(System.in);
            int operation;
            
            System.out.println();
            System.out.print("Welcome to Array Creating Station!!!");
            System.out.println();
            System.out.println("[1] Create a new Array List");
            System.out.println("[2] Insert an Array Element");
            System.out.println("[3] Search Array List");
            System.out.println("[4] Delete an Array Element");
            System.out.println("[0] Exit");
            System.out.println();
            System.out.println("Current Array List: " + Arrays.toString(current_array));
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("Press the number of desired operation: ");
            
            operation = in.nextInt();
            switch (operation) {
                case 1: {
                    System.out.println();
                    System.out.println("Create a new Array List");
                    System.out.println();
                    System.out.println("Enter array size: ");

                    int size;
                    size = in.nextInt();
                    int new_array[] = new int[size];

                    System.out.println();
                    for (int num = 0; num < size; num++) {
                        System.out.println("Enter array element: ");
                        new_array[num] = in.nextInt();
                    }

                    current_array = new_array;
                    current_size = size;
                    System.out.println();
                    System.out.println("Current Array List: " + Arrays.toString(current_array));
                    System.out.println();
                    break;
                }
                case 2: {
                    if (current_size == 0) {
                        System.out.println();
                        System.out.println("You currently don't have an array in need to be changed...");
                        System.out.println("-- You will now be prompted back into the Main Menu --");
                        break;
                    }

                    System.out.println();
                    System.out.println("Insert an Array Element");
                    System.out.println();
                    System.out.println("Enter array value to be inserted: ");    
                    int value, added_size = current_size + 1;
                    value = in.nextInt();

                    System.out.println();
                    System.out.println("Enter array location to insert array element (1 to " + added_size + "):");
                    int position;
                    position = in.nextInt();

                    if (position > added_size || position == 0) {
                        System.out.println();
                        System.out.println("The array location is greater than current array size...");
                        System.out.println("You will be returned to Main Menu!");
                    }

                    System.out.println();
                    System.out.println("How do you want to insert your desired array element? ");
                    System.out.println("[1] - Replace an array element from its location (only works within position " + current_size + ")");
                    System.out.println("[2] - Shift other array elements to insert array element to desired location");
                    System.out.println();
                    System.out.println("Warning! Having the first option while choosing " + added_size + " as the array location");
                    System.out.println("will create no changes whatsoever to your array");

                    int choose_insert;
                    choose_insert = in.nextInt();
                    System.out.println();

                    if (choose_insert == 1) {
                        current_array[position-1] = value;
                    }
                    else if (choose_insert == 2) {

                        int temp_array[] = current_array;
                        current_array = new int[current_size+1];

                        for (int num = 0; num < current_size; num++) {
                            current_array[num] = temp_array[num];
                        }
                        for (int num = current_size-1; num >= position-1; num--){
                            current_array[num+1] = current_array[num];
                        }

                        current_array[position-1] = value;
                    }

                    System.out.println("Current Array List: " + Arrays.toString(current_array));
                    System.out.println();

                    break;
                }
                case 3: {
                    if (current_size == 0) {
                        System.out.println();
                        System.out.println("You currently don't have an array to be searched...");
                        System.out.println("-- You will now be prompted back into the Main Menu --");
                        break;
                    }

                    System.out.println();
                    System.out.println("Search Array List");
                    System.out.println();
                    System.out.println("Enter array value: ");

                    int value;
                    value = in.nextInt();

                    System.out.println();
                    for(int num = 0; num < current_size; num++) {
                        if (current_array[num] == value ) {
                            int new_location = num + 1;
                            System.out.println("-- " + value + " is located at array location " + new_location + " --");
                        }
                    }

                    break;
                }
                case 4: {
                    if (current_size == 0) {
                        System.out.println();
                        System.out.println("You currently don't have an array in need to be deleted...");
                        System.out.println("-- You will now be prompted back into the Main Menu --");
                        break;
                    }

                    System.out.println();
                    System.out.println("Delete an Array Element");
                    System.out.println();
                    System.out.println("Enter array location to be deleted: ");

                    int position;
                    position = in.nextInt();

                    int temp_array[] = current_array;
                    current_array = new int[current_size-1];

                    for (int num = 0; num < current_size-1; num++) {
                        
                        if (num < position-1) {
                            current_array[num] = temp_array[num];
                        }
                        else if (num >= position-1) {
                            current_array[num] = temp_array[num+1];
                        } 
                    }

                    current_size--;
                    System.out.println();
                    System.out.println("Current Array List: " + Arrays.toString(current_array));
                    System.out.println();

                    break;
                }
                case 0: {
                    System.out.println();
                    System.out.println("Exit Array Creating Station?");
                    System.out.println("[1] - Yes       [2] - No");
                    
                    int exit;
                    exit = in.nextInt();

                    if (exit == 1) {
                        done = 1;
                    }
                    else {
                        done = 0;
                    }
                    break;
                }  
            }
        } while(done != 1); 
    }
}
